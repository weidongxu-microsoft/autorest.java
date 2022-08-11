// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.cadl.server;

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
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.BinaryData;
import com.azure.core.util.Context;

/** Initializes a new instance of the synchronous ServerClient type. */
@ServiceClient(builder = ServerClientBuilder.class)
public final class ServerClient {
    @Generated private final ServerAsyncClient client;

    /**
     * Initializes an instance of ServerClient class.
     *
     * @param client the async client.
     */
    @Generated
    ServerClient(ServerAsyncClient client) {
        this.client = client;
    }

    /**
     * The status operation.
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * Object
     * }</pre>
     *
     * @param code The code parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the response body along with {@link Response}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<BinaryData> statusWithResponse(long code, RequestOptions requestOptions) {
        return this.client.statusWithResponse(code, requestOptions).block();
    }

    /*
     * Generated convenience method for statusWithResponse
     */
    /**
     * The status operation.
     *
     * @param code The code parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.exception.HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    public Object status(long code) {
        RequestOptions requestOptions = new RequestOptions();
        return statusWithResponse(code, requestOptions).getValue();
    }

    /*
     * Generated convenience method for statusWithResponse
     */
    /**
     * The status operation.
     *
     * @param code The code parameter.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.exception.HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response body along with {@link Response}.
     */
    public Response<Object> statusWithResponse(long code, Context context) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.setContext(context);
        Response<BinaryData> protocolMethodResponse = statusWithResponse(code, requestOptions);
        return new SimpleResponse<>(protocolMethodResponse, protocolMethodResponse.getValue());
    }
}
