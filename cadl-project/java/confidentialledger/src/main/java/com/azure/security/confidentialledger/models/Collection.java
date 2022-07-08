// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.security.confidentialledger.models;

import com.azure.core.annotation.Immutable;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Identifier for collections. */
@Immutable
public final class Collection {
    /*
     * The collectionId property.
     */
    @JsonProperty(value = "collectionId", required = true, access = JsonProperty.Access.WRITE_ONLY)
    private String collectionId;

    /**
     * Creates an instance of Collection class.
     *
     * @param collectionId the collectionId value to set.
     */
    @JsonCreator
    public Collection(
            @JsonProperty(value = "collectionId", required = true, access = JsonProperty.Access.WRITE_ONLY)
                    String collectionId) {
        this.collectionId = collectionId;
    }

    /**
     * Get the collectionId property: The collectionId property.
     *
     * @return the collectionId value.
     */
    public String getCollectionId() {
        return this.collectionId;
    }
}
