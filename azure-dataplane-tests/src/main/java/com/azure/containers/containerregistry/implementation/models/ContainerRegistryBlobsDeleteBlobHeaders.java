// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.containers.containerregistry.implementation.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.http.HttpHeaderName;
import com.azure.core.http.HttpHeaders;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The ContainerRegistryBlobsDeleteBlobHeaders model. */
@Fluent
public final class ContainerRegistryBlobsDeleteBlobHeaders {
    /*
     * The Docker-Content-Digest property.
     */
    @JsonProperty(value = "Docker-Content-Digest")
    private String dockerContentDigest;

    private static final HttpHeaderName DOCKER_CONTENT_DIGEST = HttpHeaderName.fromString("Docker-Content-Digest");

    // HttpHeaders containing the raw property values.
    /**
     * Creates an instance of ContainerRegistryBlobsDeleteBlobHeaders class.
     *
     * @param rawHeaders The raw HttpHeaders that will be used to create the property values.
     */
    public ContainerRegistryBlobsDeleteBlobHeaders(HttpHeaders rawHeaders) {
        this.dockerContentDigest = rawHeaders.getValue(DOCKER_CONTENT_DIGEST);
    }

    /**
     * Get the dockerContentDigest property: The Docker-Content-Digest property.
     *
     * @return the dockerContentDigest value.
     */
    public String getDockerContentDigest() {
        return this.dockerContentDigest;
    }

    /**
     * Set the dockerContentDigest property: The Docker-Content-Digest property.
     *
     * @param dockerContentDigest the dockerContentDigest value to set.
     * @return the ContainerRegistryBlobsDeleteBlobHeaders object itself.
     */
    public ContainerRegistryBlobsDeleteBlobHeaders setDockerContentDigest(String dockerContentDigest) {
        this.dockerContentDigest = dockerContentDigest;
        return this;
    }
}