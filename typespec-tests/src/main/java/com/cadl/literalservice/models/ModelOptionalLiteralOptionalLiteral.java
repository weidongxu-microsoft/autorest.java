// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.cadl.literalservice.models;

/**
 * Defines values for ModelOptionalLiteralOptionalLiteral.
 */
public enum ModelOptionalLiteralOptionalLiteral {
    /**
     * Enum value optionalLiteral.
     */
    OPTIONAL_LITERAL("optionalLiteral");

    /**
     * The actual serialized value for a ModelOptionalLiteralOptionalLiteral instance.
     */
    private final String value;

    ModelOptionalLiteralOptionalLiteral(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a ModelOptionalLiteralOptionalLiteral instance.
     * 
     * @param value the serialized value to parse.
     * @return the parsed ModelOptionalLiteralOptionalLiteral object, or null if unable to parse.
     */
    public static ModelOptionalLiteralOptionalLiteral fromString(String value) {
        if (value == null) {
            return null;
        }
        ModelOptionalLiteralOptionalLiteral[] items = ModelOptionalLiteralOptionalLiteral.values();
        for (ModelOptionalLiteralOptionalLiteral item : items) {
            if (item.toString().equalsIgnoreCase(value)) {
                return item;
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return this.value;
    }
}