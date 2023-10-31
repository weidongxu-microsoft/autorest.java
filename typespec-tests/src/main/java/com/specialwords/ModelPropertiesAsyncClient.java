// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.specialwords;

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
import com.specialwords.implementation.ModelPropertiesImpl;
import com.specialwords.models.SameAsModel;
import reactor.core.publisher.Mono;

/**
 * Initializes a new instance of the asynchronous SpecialWordsClient type.
 */
@ServiceClient(builder = SpecialWordsClientBuilder.class, isAsync = true)
public final class ModelPropertiesAsyncClient {
    @Generated
    private final ModelPropertiesImpl serviceClient;

    /**
     * Initializes an instance of ModelPropertiesAsyncClient class.
     * 
     * @param serviceClient the service client implementation.
     */
    @Generated
    ModelPropertiesAsyncClient(ModelPropertiesImpl serviceClient) {
        this.serviceClient = serviceClient;
    }

    /**
     * The sameAsModel operation.
     * <p>
     * <strong>Request Body Schema</strong>
     * </p>
     * <pre>{@code
     * {
     *     SameAsModel: String (Required)
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
    public Mono<Response<Void>> sameAsModelWithResponse(BinaryData body, RequestOptions requestOptions) {
        return this.serviceClient.sameAsModelWithResponseAsync(body, requestOptions);
    }

    /**
     * The sameAsModel operation.
     * 
     * @param body The body parameter.
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
    public Mono<Void> sameAsModel(SameAsModel body) {
        // Generated convenience method for sameAsModelWithResponse
        RequestOptions requestOptions = new RequestOptions();
        return sameAsModelWithResponse(BinaryData.fromObject(body), requestOptions).flatMap(FluxUtil::toMono);
    }
}
