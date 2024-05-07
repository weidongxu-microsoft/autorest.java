// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.parameters.basic;

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
import com.parameters.basic.implementation.ExplicitBodiesImpl;
import com.parameters.basic.models.User;

/**
 * Initializes a new instance of the synchronous BasicClient type.
 */
@ServiceClient(builder = BasicClientBuilder.class)
public final class ExplicitBodyClient {
    @Generated
    private final ExplicitBodiesImpl serviceClient;

    /**
     * Initializes an instance of ExplicitBodyClient class.
     * 
     * @param serviceClient the service client implementation.
     */
    @Generated
    ExplicitBodyClient(ExplicitBodiesImpl serviceClient) {
        this.serviceClient = serviceClient;
    }

    /**
     * The simple operation.
     * <p><strong>Request Body Schema</strong></p>
     * 
     * <pre>{@code
     * {
     *     name: String (Required)
     * }
     * }</pre>
     * 
     * @param body This is a simple model.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the {@link Response}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Void> simpleWithResponse(BinaryData body, RequestOptions requestOptions) {
        return this.serviceClient.simpleWithResponse(body, requestOptions);
    }

    /**
     * The simple operation.
     * 
     * @param body This is a simple model.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void simple(User body) {
        // Generated convenience method for simpleWithResponse
        RequestOptions requestOptions = new RequestOptions();
        simpleWithResponse(BinaryData.fromObject(body), requestOptions).getValue();
    }
}