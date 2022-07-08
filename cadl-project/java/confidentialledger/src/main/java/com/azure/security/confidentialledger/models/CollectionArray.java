// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.security.confidentialledger.models;

import com.azure.core.annotation.Immutable;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** A list of identifiers for ledger collections. */
@Immutable
public final class CollectionArray {
    /*
     * The items property.
     */
    @JsonProperty(value = "items", required = true, access = JsonProperty.Access.WRITE_ONLY)
    private List<Collection> items;

    /**
     * Creates an instance of CollectionArray class.
     *
     * @param items the items value to set.
     */
    @JsonCreator
    public CollectionArray(
            @JsonProperty(value = "items", required = true, access = JsonProperty.Access.WRITE_ONLY)
                    List<Collection> items) {
        this.items = items;
    }

    /**
     * Get the items property: The items property.
     *
     * @return the items value.
     */
    public List<Collection> getItems() {
        return this.items;
    }
}
