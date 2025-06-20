// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package fixtures.constants.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The ModelAsStringRequiredTwoValueNoDefault model.
 */
@Fluent
public final class ModelAsStringRequiredTwoValueNoDefault
    implements JsonSerializable<ModelAsStringRequiredTwoValueNoDefault> {
    /*
     * The parameter property.
     */
    @Generated
    private ModelAsStringRequiredTwoValueNoDefaultEnum parameter;

    /**
     * Creates an instance of ModelAsStringRequiredTwoValueNoDefault class.
     */
    @Generated
    public ModelAsStringRequiredTwoValueNoDefault() {
    }

    /**
     * Get the parameter property: The parameter property.
     * 
     * @return the parameter value.
     */
    @Generated
    public ModelAsStringRequiredTwoValueNoDefaultEnum getParameter() {
        return this.parameter;
    }

    /**
     * Set the parameter property: The parameter property.
     * 
     * @param parameter the parameter value to set.
     * @return the ModelAsStringRequiredTwoValueNoDefault object itself.
     */
    @Generated
    public ModelAsStringRequiredTwoValueNoDefault setParameter(ModelAsStringRequiredTwoValueNoDefaultEnum parameter) {
        this.parameter = parameter;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (getParameter() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property parameter in model ModelAsStringRequiredTwoValueNoDefault"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(ModelAsStringRequiredTwoValueNoDefault.class);

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("parameter", this.parameter == null ? null : this.parameter.toString());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ModelAsStringRequiredTwoValueNoDefault from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ModelAsStringRequiredTwoValueNoDefault if the JsonReader was pointing to an instance of
     * it, or null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ModelAsStringRequiredTwoValueNoDefault.
     */
    @Generated
    public static ModelAsStringRequiredTwoValueNoDefault fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ModelAsStringRequiredTwoValueNoDefault deserializedModelAsStringRequiredTwoValueNoDefault
                = new ModelAsStringRequiredTwoValueNoDefault();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("parameter".equals(fieldName)) {
                    deserializedModelAsStringRequiredTwoValueNoDefault.parameter
                        = ModelAsStringRequiredTwoValueNoDefaultEnum.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedModelAsStringRequiredTwoValueNoDefault;
        });
    }
}
