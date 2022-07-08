// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.language.textanalytics.models;

import com.azure.core.annotation.Immutable;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

/** The Error model. */
@Immutable
public final class Error {
    /*
     * Error message.
     */
    @JsonProperty(value = "message", required = true, access = JsonProperty.Access.WRITE_ONLY)
    private String message;

    /*
     * Error code.
     */
    @JsonProperty(value = "code", required = true, access = JsonProperty.Access.WRITE_ONLY)
    private Code code;

    /*
     * Error details.
     */
    @JsonProperty(value = "details", access = JsonProperty.Access.WRITE_ONLY)
    private Map<String, String> details;

    /*
     * Error target.
     */
    @JsonProperty(value = "target", access = JsonProperty.Access.WRITE_ONLY)
    private String target;

    /*
     * Inner error contains more specific information.
     */
    @JsonProperty(value = "innererror", access = JsonProperty.Access.WRITE_ONLY)
    private InnerError innererror;

    /**
     * Creates an instance of Error class.
     *
     * @param message the message value to set.
     * @param code the code value to set.
     */
    @JsonCreator
    public Error(
            @JsonProperty(value = "message", required = true, access = JsonProperty.Access.WRITE_ONLY) String message,
            @JsonProperty(value = "code", required = true, access = JsonProperty.Access.WRITE_ONLY) Code code) {
        this.message = message;
        this.code = code;
    }

    /**
     * Get the message property: Error message.
     *
     * @return the message value.
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Get the code property: Error code.
     *
     * @return the code value.
     */
    public Code getCode() {
        return this.code;
    }

    /**
     * Get the details property: Error details.
     *
     * @return the details value.
     */
    public Map<String, String> getDetails() {
        return this.details;
    }

    /**
     * Get the target property: Error target.
     *
     * @return the target value.
     */
    public String getTarget() {
        return this.target;
    }

    /**
     * Get the innererror property: Inner error contains more specific information.
     *
     * @return the innererror value.
     */
    public InnerError getInnererror() {
        return this.innererror;
    }
}
