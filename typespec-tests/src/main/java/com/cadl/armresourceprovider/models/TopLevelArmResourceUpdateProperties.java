// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.cadl.armresourceprovider.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

/**
 * The updatable properties of the TopLevelArmResource.
 */
@Fluent
public final class TopLevelArmResourceUpdateProperties {
    /*
     * The userName property.
     */
    @JsonProperty(value = "userName")
    private String userName;

    /*
     * The userNames property.
     */
    @JsonProperty(value = "userNames")
    private String userNames;

    /*
     * The accuserName property.
     */
    @JsonProperty(value = "accuserName")
    private String accuserName;

    /*
     * The startTimeStamp property.
     */
    @JsonProperty(value = "startTimeStamp")
    private OffsetDateTime startTimeStamp;

    /**
     * Creates an instance of TopLevelArmResourceUpdateProperties class.
     */
    public TopLevelArmResourceUpdateProperties() {
    }

    /**
     * Get the userName property: The userName property.
     * 
     * @return the userName value.
     */
    public String userName() {
        return this.userName;
    }

    /**
     * Set the userName property: The userName property.
     * 
     * @param userName the userName value to set.
     * @return the TopLevelArmResourceUpdateProperties object itself.
     */
    public TopLevelArmResourceUpdateProperties withUserName(String userName) {
        this.userName = userName;
        return this;
    }

    /**
     * Get the userNames property: The userNames property.
     * 
     * @return the userNames value.
     */
    public String userNames() {
        return this.userNames;
    }

    /**
     * Set the userNames property: The userNames property.
     * 
     * @param userNames the userNames value to set.
     * @return the TopLevelArmResourceUpdateProperties object itself.
     */
    public TopLevelArmResourceUpdateProperties withUserNames(String userNames) {
        this.userNames = userNames;
        return this;
    }

    /**
     * Get the accuserName property: The accuserName property.
     * 
     * @return the accuserName value.
     */
    public String accuserName() {
        return this.accuserName;
    }

    /**
     * Set the accuserName property: The accuserName property.
     * 
     * @param accuserName the accuserName value to set.
     * @return the TopLevelArmResourceUpdateProperties object itself.
     */
    public TopLevelArmResourceUpdateProperties withAccuserName(String accuserName) {
        this.accuserName = accuserName;
        return this;
    }

    /**
     * Get the startTimeStamp property: The startTimeStamp property.
     * 
     * @return the startTimeStamp value.
     */
    public OffsetDateTime startTimeStamp() {
        return this.startTimeStamp;
    }

    /**
     * Set the startTimeStamp property: The startTimeStamp property.
     * 
     * @param startTimeStamp the startTimeStamp value to set.
     * @return the TopLevelArmResourceUpdateProperties object itself.
     */
    public TopLevelArmResourceUpdateProperties withStartTimeStamp(OffsetDateTime startTimeStamp) {
        this.startTimeStamp = startTimeStamp;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}
