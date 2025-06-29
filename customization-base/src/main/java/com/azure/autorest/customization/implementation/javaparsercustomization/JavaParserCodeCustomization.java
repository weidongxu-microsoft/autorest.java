// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.autorest.customization.implementation.javaparsercustomization;

import com.azure.autorest.customization.CodeCustomization;
import com.azure.autorest.customization.Editor;
import com.azure.autorest.customization.implementation.ls.EclipseLanguageClient;
import org.eclipse.lsp4j.SymbolInformation;

/**
 * Base interface for all code based customizations.
 */
public abstract class JavaParserCodeCustomization implements CodeCustomization {
    final Editor editor;
    final String fileName;

    JavaParserCodeCustomization(Editor editor, String packageName, String className) {
        this.editor = editor;
        this.fileName = "src/main/java/" + packageName.replace('.', '/') + "/" + className + ".java";
    }

    @Override
    public final Editor getEditor() {
        return editor;
    }

    @Override
    public final EclipseLanguageClient getLanguageClient() {
        return null;
    }

    @Override
    public final SymbolInformation getSymbol() {
        return null;
    }

    @Override
    public final String getFileUri() {
        return null;
    }

    @Override
    public final String getFileName() {
        return fileName;
    }
}
