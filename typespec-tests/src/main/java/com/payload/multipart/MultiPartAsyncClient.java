// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.payload.multipart;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceClient;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.exception.ClientAuthenticationException;
import com.azure.core.exception.HttpResponseException;
import com.azure.core.exception.ResourceModifiedException;
import com.azure.core.exception.ResourceNotFoundException;
import com.azure.core.http.rest.RequestOptions;
import com.azure.core.http.rest.Response;
import com.azure.core.util.BinaryData;
import com.payload.multipart.implementation.MultiPartClientImpl;
import reactor.core.publisher.Mono;

/**
 * Initializes a new instance of the asynchronous MultiPartClient type.
 */
@ServiceClient(builder = MultiPartClientBuilder.class, isAsync = true)
public final class MultiPartAsyncClient {
    @Generated
    private final MultiPartClientImpl serviceClient;

    /**
     * Initializes an instance of MultiPartAsyncClient class.
     * 
     * @param serviceClient the service client implementation.
     */
    @Generated
    MultiPartAsyncClient(MultiPartClientImpl serviceClient) {
        this.serviceClient = serviceClient;
    }

    /**
     * Test content-type: multipart/form-data.
     * <p>
     * <strong>Request Body Schema</strong>
     * </p>
     * <pre>{@code
     * {
     *     id: String (Required)
     *     profileImage: byte[] (Required)
     * }
     * }</pre>
     * 
     * @param body The body parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<Void>> basicWithResponse(BinaryData body, RequestOptions requestOptions) {
        // Protocol API requires serialization of parts with content-disposition and data, as operation 'basic' is
        // 'multipart/form-data'
        return this.serviceClient.basicWithResponseAsync(body, requestOptions);
    }
}