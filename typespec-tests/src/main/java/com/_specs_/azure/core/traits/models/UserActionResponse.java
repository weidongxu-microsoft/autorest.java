// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com._specs_.azure.core.traits.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User action response.
 */
@Immutable
public final class UserActionResponse {
    /*
     * User action result.
     */
    @Generated
    @JsonProperty(value = "userActionResult")
    private String userActionResult;

    /**
     * Creates an instance of UserActionResponse class.
     * 
     * @param userActionResult the userActionResult value to set.
     */
    @Generated
    @JsonCreator
    private UserActionResponse(@JsonProperty(value = "userActionResult") String userActionResult) {
        this.userActionResult = userActionResult;
    }

    /**
     * Get the userActionResult property: User action result.
     * 
     * @return the userActionResult value.
     */
    @Generated
    public String getUserActionResult() {
        return this.userActionResult;
    }
}
