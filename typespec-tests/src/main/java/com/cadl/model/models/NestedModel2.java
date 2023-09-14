// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.cadl.model.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The NestedModel2 model. */
@Immutable
public final class NestedModel2 {
    /*
     * The data property.
     */
    @Generated
    @JsonProperty(value = "data")
    private String data;

    /**
     * Creates an instance of NestedModel2 class.
     *
     * @param data the data value to set.
     */
    @Generated
    @JsonCreator
    public NestedModel2(@JsonProperty(value = "data") String data) {
        this.data = data;
    }

    /**
     * Get the data property: The data property.
     *
     * @return the data value.
     */
    @Generated
    public String getData() {
        return this.data;
    }
}