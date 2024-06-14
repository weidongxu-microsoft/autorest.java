// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.cadl.armstreamstyleserialization.fluent.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * The second level model in polymorphic multiple levels inheritance which contains references to other polymorphic
 * instances.
 */
@Immutable
public final class SalmonInner extends FishInner {
    /*
     * Discriminator property for Fish.
     */
    private String kind = "salmon";

    /*
     * The friends property.
     */
    private List<FishInner> friends;

    /*
     * The hate property.
     */
    private Map<String, FishInner> hate;

    /*
     * The partner property.
     */
    private FishInner partner;

    /*
     * The age property.
     */
    private int age;

    /*
     * The dna property.
     */
    private String dna;

    /**
     * Creates an instance of SalmonInner class.
     */
    private SalmonInner() {
    }

    /**
     * Get the kind property: Discriminator property for Fish.
     * 
     * @return the kind value.
     */
    @Override
    public String kind() {
        return this.kind;
    }

    /**
     * Get the friends property: The friends property.
     * 
     * @return the friends value.
     */
    public List<FishInner> friends() {
        return this.friends;
    }

    /**
     * Get the hate property: The hate property.
     * 
     * @return the hate value.
     */
    public Map<String, FishInner> hate() {
        return this.hate;
    }

    /**
     * Get the partner property: The partner property.
     * 
     * @return the partner value.
     */
    public FishInner partner() {
        return this.partner;
    }

    /**
     * Get the age property: The age property.
     * 
     * @return the age value.
     */
    @Override
    public int age() {
        return this.age;
    }

    /**
     * Get the dna property: The dna property.
     * 
     * @return the dna value.
     */
    @Override
    public String dna() {
        return this.dna;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
        if (friends() != null) {
            friends().forEach(e -> e.validate());
        }
        if (hate() != null) {
            hate().values().forEach(e -> {
                if (e != null) {
                    e.validate();
                }
            });
        }
        if (partner() != null) {
            partner().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeIntField("age", age());
        jsonWriter.writeStringField("dna", dna());
        jsonWriter.writeStringField("kind", this.kind);
        jsonWriter.writeArrayField("friends", this.friends, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeMapField("hate", this.hate, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeJsonField("partner", this.partner);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of SalmonInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of SalmonInner if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the SalmonInner.
     */
    public static SalmonInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            SalmonInner deserializedSalmonInner = new SalmonInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("age".equals(fieldName)) {
                    deserializedSalmonInner.age = reader.getInt();
                } else if ("dna".equals(fieldName)) {
                    deserializedSalmonInner.dna = reader.getString();
                } else if ("kind".equals(fieldName)) {
                    deserializedSalmonInner.kind = reader.getString();
                } else if ("friends".equals(fieldName)) {
                    List<FishInner> friends = reader.readArray(reader1 -> FishInner.fromJson(reader1));
                    deserializedSalmonInner.friends = friends;
                } else if ("hate".equals(fieldName)) {
                    Map<String, FishInner> hate = reader.readMap(reader1 -> FishInner.fromJson(reader1));
                    deserializedSalmonInner.hate = hate;
                } else if ("partner".equals(fieldName)) {
                    deserializedSalmonInner.partner = FishInner.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedSalmonInner;
        });
    }
}
