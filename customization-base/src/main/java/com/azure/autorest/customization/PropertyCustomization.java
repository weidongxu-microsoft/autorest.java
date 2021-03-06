package com.azure.autorest.customization;

import com.azure.autorest.customization.implementation.Utils;
import com.azure.autorest.customization.implementation.ls.EclipseLanguageClient;
import com.azure.autorest.customization.implementation.ls.models.CodeAction;
import com.azure.autorest.customization.implementation.ls.models.CodeActionKind;
import com.azure.autorest.customization.implementation.ls.models.FileChangeType;
import com.azure.autorest.customization.implementation.ls.models.FileEvent;
import com.azure.autorest.customization.implementation.ls.models.JavaCodeActionKind;
import com.azure.autorest.customization.implementation.ls.models.SymbolInformation;
import com.azure.autorest.customization.implementation.ls.models.SymbolKind;
import com.azure.autorest.customization.implementation.ls.models.TextEdit;
import com.azure.autorest.customization.implementation.ls.models.WorkspaceEdit;
import com.azure.autorest.customization.implementation.ls.models.WorkspaceEditCommand;
import com.azure.autorest.customization.models.Position;
import com.azure.autorest.customization.models.Range;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * The Javadoc customization for an AutoRest generated classes and methods.
 */
public final class PropertyCustomization {
    private final EclipseLanguageClient languageClient;
    private final Editor editor;
    private final String packageName;
    private final String className;
    private final SymbolInformation classSymbol;
    private final ClassCustomization classCustomization;
    private final String propertyName;

    PropertyCustomization(Editor editor, EclipseLanguageClient languageClient, String packageName, String className, SymbolInformation classSymbol, ClassCustomization classCustomization, String propertyName) {
        this.editor = editor;
        this.languageClient = languageClient;
        this.packageName = packageName;
        this.className = className;
        this.classSymbol = classSymbol;
        this.classCustomization = classCustomization;
        this.propertyName = propertyName;
    }

    /**
     * Rename a property in the class. This is a refactor operation. All references of the property will be renamed
     * and the getter and setter method(s) for this property will be renamed accordingly as well.
     *
     * @param newName the new name for the property
     * @return the current class customization for chaining
     */
    public PropertyCustomization rename(String newName) {
        URI fileUri = classSymbol.getLocation().getUri();
        List<SymbolInformation> symbols = languageClient.listDocumentSymbols(fileUri)
                .stream().filter(si -> si.getName().toLowerCase().contains(propertyName.toLowerCase()))
                .collect(Collectors.toList());
        String propertyPascalName = propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
        String newPascalName = newName.substring(0, 1).toUpperCase() + newName.substring(1);
        for (SymbolInformation symbol : symbols) {
            if (symbol.getKind() == SymbolKind.FIELD) {
                WorkspaceEdit edit = languageClient.renameSymbol(fileUri, symbol.getLocation().getRange().getStart(), newName);
                Utils.applyWorkspaceEdit(edit, editor, languageClient);
            } else if (symbol.getKind() == SymbolKind.METHOD) {
                String methodName = symbol.getName().replace(propertyPascalName, newPascalName)
                        .replace(propertyName, newName).replaceFirst("\\(.*\\)", "");
                WorkspaceEdit edit = languageClient.renameSymbol(fileUri, symbol.getLocation().getRange().getStart(), methodName);
                Utils.applyWorkspaceEdit(edit, editor, languageClient);
            }
        }
        return new PropertyCustomization(editor, languageClient, packageName, className, classSymbol, classCustomization, newName);
    }

    /**
     * Generates a getter and a setter method(s) for a property in the class. This is a refactor operation.
     * If a getter or a setter is already available on the class, the current getter or setter will be kept.
     *
     * @return the current class customization for chaining
     */
    public PropertyCustomization generateGetterAndSetter() {
        URI fileUri = classSymbol.getLocation().getUri();
        Optional<SymbolInformation> symbol = languageClient.listDocumentSymbols(fileUri)
                .stream().filter(si -> si.getName().equals(propertyName) && si.getKind() == SymbolKind.FIELD)
                .findFirst();
        if (symbol.isPresent()) {
            Optional<CodeAction> generateAccessors = languageClient.listCodeActions(fileUri, symbol.get().getLocation().getRange())
                    .stream().filter(ca -> ca.getKind().equals(JavaCodeActionKind.SOURCE_GENERATE_ACCESSORS.toString()))
                    .findFirst();
            if (generateAccessors.isPresent()) {
                WorkspaceEditCommand command;
                if (generateAccessors.get().getCommand() instanceof WorkspaceEditCommand) {
                    command = (WorkspaceEditCommand) generateAccessors.get().getCommand();
                    for (WorkspaceEdit workspaceEdit : command.getArguments()) {
                        Utils.applyWorkspaceEdit(workspaceEdit, editor, languageClient);
                    }
                    List<TextEdit> formats = languageClient.format(fileUri);
                    Utils.applyTextEdits(fileUri, formats, editor, languageClient);

                    String setterMethod = "set" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
                    classCustomization.getMethod(setterMethod).setReturnType(className, "this");
                }
            }
        }
        return this;
    }
}
