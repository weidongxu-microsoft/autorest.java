// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.encode.datetime.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.azure.core.util.DateTimeRfc1123;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

/** The Rfc7231DatetimeProperty model. */
@Immutable
public final class Rfc7231DatetimeProperty {
    /*
     * The value property.
     */
    @Generated
    @JsonProperty(value = "value")
    private DateTimeRfc1123 value;

    /**
     * Creates an instance of Rfc7231DatetimeProperty class.
     *
     * @param value the value value to set.
     */
    @Generated
    @JsonCreator
    public Rfc7231DatetimeProperty(@JsonProperty(value = "value") OffsetDateTime value) {
        this.value = new DateTimeRfc1123(value);
    }

    /**
     * Get the value property: The value property.
     *
     * @return the value value.
     */
    @Generated
    public OffsetDateTime getValue() {
        if (this.value == null) {
            return null;
        }
        return this.value.getDateTime();
    }
}