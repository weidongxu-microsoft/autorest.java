// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.cadl.internal.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The StandAloneUnion model. */
@Immutable
public final class StandAloneUnion {
    /*
     * The data property.
     */
    @Generated
    @JsonProperty(value = "data")
    private Object data;

    /**
     * Creates an instance of StandAloneUnion class.
     *
     * @param data the data value to set.
     */
    @Generated
    @JsonCreator
    private StandAloneUnion(@JsonProperty(value = "data") Object data) {
        this.data = data;
    }

    /**
     * Get the data property: The data property.
     *
     * @return the data value.
     */
    @Generated
    public Object getData() {
        return this.data;
    }
}
