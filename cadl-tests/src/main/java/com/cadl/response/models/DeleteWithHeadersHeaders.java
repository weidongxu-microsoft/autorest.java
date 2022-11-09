// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.cadl.response.models;

import com.azure.core.annotation.Immutable;
import com.azure.core.http.HttpHeaderName;
import com.azure.core.http.HttpHeaders;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The DeleteWithHeadersHeaders model. */
@Immutable
public final class DeleteWithHeadersHeaders {
    /*
     * The operation-location property.
     */
    @JsonProperty(value = "operation-location")
    private String operationLocation;

    private static final HttpHeaderName OPERATION_LOCATION = HttpHeaderName.fromString("operation-location");

    // HttpHeaders containing the raw property values.
    /**
     * Creates an instance of DeleteWithHeadersHeaders class.
     *
     * @param rawHeaders The raw HttpHeaders that will be used to create the property values.
     */
    public DeleteWithHeadersHeaders(HttpHeaders rawHeaders) {
        this.operationLocation = rawHeaders.getValue(OPERATION_LOCATION);
    }

    /**
     * Get the operationLocation property: The operation-location property.
     *
     * @return the operationLocation value.
     */
    public String getOperationLocation() {
        return this.operationLocation;
    }
}
