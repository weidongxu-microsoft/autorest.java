// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.language.textanalytics.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for Status. */
public final class Status extends ExpandableStringEnum<Status> {
    /** Static value notStarted for Status. */
    public static final Status NOT_STARTED = fromString("notStarted");

    /** Static value running for Status. */
    public static final Status RUNNING = fromString("running");

    /** Static value succeeded for Status. */
    public static final Status SUCCEEDED = fromString("succeeded");

    /** Static value partiallySucceeded for Status. */
    public static final Status PARTIALLY_SUCCEEDED = fromString("partiallySucceeded");

    /** Static value failed for Status. */
    public static final Status FAILED = fromString("failed");

    /** Static value cancelled for Status. */
    public static final Status CANCELLED = fromString("cancelled");

    /** Static value cancelling for Status. */
    public static final Status CANCELLING = fromString("cancelling");

    /**
     * Creates or finds a Status from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding Status.
     */
    @JsonCreator
    public static Status fromString(String name) {
        return fromString(name, Status.class);
    }

    /**
     * Gets known Status values.
     *
     * @return known Status values.
     */
    public static Collection<Status> values() {
        return values(Status.class);
    }
}
