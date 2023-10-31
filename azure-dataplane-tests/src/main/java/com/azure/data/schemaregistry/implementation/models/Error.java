// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.data.schemaregistry.implementation.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An error response returned from Azure Schema Registry service.
 */
@Fluent
public final class Error {
    /*
     * Error response returned from Azure Schema Registry service.
     */
    @JsonProperty(value = "error", required = true)
    private ErrorDetail error;

    /**
     * Creates an instance of Error class.
     */
    public Error() {
    }

    /**
     * Get the error property: Error response returned from Azure Schema Registry service.
     * 
     * @return the error value.
     */
    public ErrorDetail getError() {
        return this.error;
    }

    /**
     * Set the error property: Error response returned from Azure Schema Registry service.
     * 
     * @param error the error value to set.
     * @return the Error object itself.
     */
    public Error setError(ErrorDetail error) {
        this.error = error;
        return this;
    }
}
