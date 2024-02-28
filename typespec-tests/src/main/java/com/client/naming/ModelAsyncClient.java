// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.client.naming;

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
import com.azure.core.util.FluxUtil;
import com.client.naming.implementation.ModelsImpl;
import com.client.naming.models.ClientModel;
import com.client.naming.models.JavaModel;
import reactor.core.publisher.Mono;

/**
 * Initializes a new instance of the asynchronous NamingClient type.
 */
@ServiceClient(builder = NamingClientBuilder.class, isAsync = true)
public final class ModelAsyncClient {
    @Generated
    private final ModelsImpl serviceClient;

    /**
     * Initializes an instance of ModelAsyncClient class.
     * 
     * @param serviceClient the service client implementation.
     */
    @Generated
    ModelAsyncClient(ModelsImpl serviceClient) {
        this.serviceClient = serviceClient;
    }

    /**
     * The client operation.
     * <p>
     * <strong>Request Body Schema</strong>
     * </p>
     * <pre>{@code
     * {
     *     defaultName: boolean (Required)
     * }
     * }</pre>
     * 
     * @param clientModel The clientModel parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> clientWithResponse(BinaryData clientModel, RequestOptions requestOptions) {
        return this.serviceClient.clientWithResponseAsync(clientModel, requestOptions);
    }

    /**
     * The language operation.
     * <p>
     * <strong>Request Body Schema</strong>
     * </p>
     * <pre>{@code
     * {
     *     defaultName: boolean (Required)
     * }
     * }</pre>
     * 
     * @param javaModel The javaModel parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> languageWithResponse(BinaryData javaModel, RequestOptions requestOptions) {
        return this.serviceClient.languageWithResponseAsync(javaModel, requestOptions);
    }

    /**
     * The client operation.
     * 
     * @param clientModel The clientModel parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return A {@link Mono} that completes when a successful response is received.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> client(ClientModel clientModel) {
        // Generated convenience method for clientWithResponse
        RequestOptions requestOptions = new RequestOptions();
        return clientWithResponse(BinaryData.fromObject(clientModel), requestOptions).flatMap(FluxUtil::toMono);
    }

    /**
     * The language operation.
     * 
     * @param javaModel The javaModel parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return A {@link Mono} that completes when a successful response is received.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> language(JavaModel javaModel) {
        // Generated convenience method for languageWithResponse
        RequestOptions requestOptions = new RequestOptions();
        return languageWithResponse(BinaryData.fromObject(javaModel), requestOptions).flatMap(FluxUtil::toMono);
    }
}
