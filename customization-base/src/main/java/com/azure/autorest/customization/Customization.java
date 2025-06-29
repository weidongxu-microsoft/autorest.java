// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.autorest.customization;

import com.azure.autorest.customization.implementation.Utils;
import com.azure.autorest.customization.implementation.eclipsecustomization.EclipseLibraryCustomization;
import com.azure.autorest.customization.implementation.javaparsercustomization.JavaParserLibraryCustomization;
import com.azure.autorest.customization.implementation.ls.EclipseLanguageClient;
import com.azure.autorest.extension.base.util.FileUtils;
import org.slf4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Map;

/**
 * The base class for customization. Extend this class to plug into AutoRest generation.
 */
public abstract class Customization {
    /**
     * Start the customization process. This is called by the post processor in AutoRest.
     *
     * @param files the map of files generated in the previous steps in AutoRest
     * @param useEclipseLanguageServer whether to use the Eclipse language server
     * @param logger the logger
     * @return the map of files after customization
     */
    public final Map<String, String> run(Map<String, String> files, boolean useEclipseLanguageServer, Logger logger) {
        Path tempDirWithPrefix;

        // Populate editor
        Editor editor;
        try {
            tempDirWithPrefix = FileUtils.createTempDirectory("temp");
            editor = new Editor(files, tempDirWithPrefix);
            if (useEclipseLanguageServer) {
                try (InputStream pomStream = Customization.class.getResourceAsStream("/pom.xml")) {
                    editor.addFile("pom.xml", new String(pomStream.readAllBytes(), StandardCharsets.UTF_8));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (useEclipseLanguageServer) {
            // Start language client
            try (EclipseLanguageClient languageClient
                = new EclipseLanguageClient(null, tempDirWithPrefix.toString(), logger)) {
                languageClient.initialize();
                customize(new EclipseLibraryCustomization(editor, languageClient), logger);
                editor.removeFile("pom.xml");
                return editor.getContents();
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                Utils.deleteDirectory(tempDirWithPrefix.toFile());
            }
        } else {
            try {
                customize(new JavaParserLibraryCustomization(editor), logger);
                return editor.getContents();
            } finally {
                Utils.deleteDirectory(tempDirWithPrefix.toFile());
            }
        }
    }

    /**
     * Override this method to customize the client library.
     *
     * @param libraryCustomization the top level customization object
     * @param logger the logger
     */
    public abstract void customize(LibraryCustomization libraryCustomization, Logger logger);
}
