// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.cadl.enumservice.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The Operation model. */
@Immutable
public final class Operation {
    /*
     * The name property.
     */
    @Generated
    @JsonProperty(value = "name")
    private OperationNameModel name;

    /*
     * The best property.
     */
    @Generated
    @JsonProperty(value = "best")
    private boolean best = true;

    /*
     * The age property.
     */
    @Generated
    @JsonProperty(value = "age")
    private long age = 50L;

    /*
     * The priority property.
     */
    @Generated
    @JsonProperty(value = "priority")
    private Priority priority;

    /*
     * The color property.
     */
    @Generated
    @JsonProperty(value = "color")
    private ColorModel color;

    /*
     * The priorityValue property.
     */
    @Generated
    @JsonProperty(value = "priorityValue")
    private Priority priorityValue = Priority.LOW;

    /*
     * The colorValue property.
     */
    @Generated
    @JsonProperty(value = "colorValue")
    private Color colorValue = Color.GREEN;

    /*
     * The colorModelValue property.
     */
    @Generated
    @JsonProperty(value = "colorModelValue")
    private ColorModel colorModelValue = ColorModel.BLUE;

    /**
     * Creates an instance of Operation class.
     *
     * @param name the name value to set.
     * @param priority the priority value to set.
     * @param color the color value to set.
     */
    @Generated
    @JsonCreator
    private Operation(
            @JsonProperty(value = "name") OperationNameModel name,
            @JsonProperty(value = "priority") Priority priority,
            @JsonProperty(value = "color") ColorModel color) {
        best = true;
        age = 50L;
        priorityValue = Priority.LOW;
        colorValue = Color.GREEN;
        colorModelValue = ColorModel.BLUE;
        this.name = name;
        this.priority = priority;
        this.color = color;
    }

    /**
     * Get the name property: The name property.
     *
     * @return the name value.
     */
    @Generated
    public OperationNameModel getName() {
        return this.name;
    }

    /**
     * Get the best property: The best property.
     *
     * @return the best value.
     */
    @Generated
    public boolean isBest() {
        return this.best;
    }

    /**
     * Get the age property: The age property.
     *
     * @return the age value.
     */
    @Generated
    public long getAge() {
        return this.age;
    }

    /**
     * Get the priority property: The priority property.
     *
     * @return the priority value.
     */
    @Generated
    public Priority getPriority() {
        return this.priority;
    }

    /**
     * Get the color property: The color property.
     *
     * @return the color value.
     */
    @Generated
    public ColorModel getColor() {
        return this.color;
    }

    /**
     * Get the priorityValue property: The priorityValue property.
     *
     * @return the priorityValue value.
     */
    @Generated
    public Priority getPriorityValue() {
        return this.priorityValue;
    }

    /**
     * Get the colorValue property: The colorValue property.
     *
     * @return the colorValue value.
     */
    @Generated
    public Color getColorValue() {
        return this.colorValue;
    }

    /**
     * Get the colorModelValue property: The colorModelValue property.
     *
     * @return the colorModelValue value.
     */
    @Generated
    public ColorModel getColorModelValue() {
        return this.colorModelValue;
    }
}
