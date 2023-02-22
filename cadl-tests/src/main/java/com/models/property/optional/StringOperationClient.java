// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.models.property.optional;

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
import com.models.property.optional.models.StringProperty;

/** Initializes a new instance of the synchronous OptionalClient type. */
@ServiceClient(builder = OptionalClientBuilder.class)
public final class StringOperationClient {
    @Generated private final StringOperationAsyncClient client;

    /**
     * Initializes an instance of StringOperationClient class.
     *
     * @param client the async client.
     */
    @Generated
    StringOperationClient(StringOperationAsyncClient client) {
        this.client = client;
    }

    /**
     * Get models that will return all properties in the model.
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     property: String (Optional)
     * }
     * }</pre>
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return models that will return all properties in the model along with {@link Response}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<BinaryData> getAllWithResponse(RequestOptions requestOptions) {
        return this.client.getAllWithResponse(requestOptions).block();
    }

    /**
     * Get models that will return the default object.
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     property: String (Optional)
     * }
     * }</pre>
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return models that will return the default object along with {@link Response}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<BinaryData> getDefaultWithResponse(RequestOptions requestOptions) {
        return this.client.getDefaultWithResponse(requestOptions).block();
    }

    /**
     * Put a body with all properties present.
     *
     * <p><strong>Request Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     property: String (Optional)
     * }
     * }</pre>
     *
     * @param body Template type for testing models with optional property. Pass in the type of the property you are
     *     looking for.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the {@link Response}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Void> putAllWithResponse(BinaryData body, RequestOptions requestOptions) {
        return this.client.putAllWithResponse(body, requestOptions).block();
    }

    /**
     * Put a body with default properties.
     *
     * <p><strong>Request Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     property: String (Optional)
     * }
     * }</pre>
     *
     * @param body Template type for testing models with optional property. Pass in the type of the property you are
     *     looking for.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the {@link Response}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Void> putDefaultWithResponse(BinaryData body, RequestOptions requestOptions) {
        return this.client.putDefaultWithResponse(body, requestOptions).block();
    }

    /**
     * Get models that will return all properties in the model.
     *
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return models that will return all properties in the model.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public StringProperty getAll() {
        // Generated convenience method for getAllWithResponse
        RequestOptions requestOptions = new RequestOptions();
        return getAllWithResponse(requestOptions).getValue().toObject(StringProperty.class);
    }

    /**
     * Get models that will return the default object.
     *
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return models that will return the default object.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public StringProperty getDefault() {
        // Generated convenience method for getDefaultWithResponse
        RequestOptions requestOptions = new RequestOptions();
        return getDefaultWithResponse(requestOptions).getValue().toObject(StringProperty.class);
    }

    /**
     * Put a body with all properties present.
     *
     * @param body Template type for testing models with optional property. Pass in the type of the property you are
     *     looking for.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void putAll(StringProperty body) {
        // Generated convenience method for putAllWithResponse
        RequestOptions requestOptions = new RequestOptions();
        putAllWithResponse(BinaryData.fromObject(body), requestOptions).getValue();
    }

    /**
     * Put a body with default properties.
     *
     * @param body Template type for testing models with optional property. Pass in the type of the property you are
     *     looking for.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void putDefault(StringProperty body) {
        // Generated convenience method for putDefaultWithResponse
        RequestOptions requestOptions = new RequestOptions();
        putDefaultWithResponse(BinaryData.fromObject(body), requestOptions).getValue();
    }
}
