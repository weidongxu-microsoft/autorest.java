// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.cadl.specialchars;

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
import com.cadl.specialchars.implementation.SpecialCharsClientImpl;
import com.cadl.specialchars.models.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Initializes a new instance of the synchronous SpecialCharsClient type.
 */
@ServiceClient(builder = SpecialCharsClientBuilder.class)
public final class SpecialCharsClient {
    @Generated
    private final SpecialCharsClientImpl serviceClient;

    /**
     * Initializes an instance of SpecialCharsClient class.
     * 
     * @param serviceClient the service client implementation.
     */
    @Generated
    SpecialCharsClient(SpecialCharsClientImpl serviceClient) {
        this.serviceClient = serviceClient;
    }

    /**
     * The read operation.
     * <p>
     * <strong>Request Body Schema</strong>
     * </p>
     * <pre>{@code
     * {
     *     id: String (Required)
     * }
     * }</pre>
     * <p>
     * <strong>Response Body Schema</strong>
     * </p>
     * <pre>{@code
     * {
     *     id: String (Required)
     *     aggregate: String (Optional)
     *     condition: String (Optional)
     *     requestName: String (Optional)
     *     value: Double (Optional)
     * }
     * }</pre>
     * 
     * @param request The request parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the response body along with {@link Response}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<BinaryData> readWithResponse(BinaryData request, RequestOptions requestOptions) {
        return this.serviceClient.readWithResponse(request, requestOptions);
    }

    /**
     * The read operation.
     * 
     * @param id A sequence of textual characters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Resource read(String id) {
        // Generated convenience method for readWithResponse
        RequestOptions requestOptions = new RequestOptions();
        Map<String, Object> requestObj = new HashMap<>();
        requestObj.put("id", id);
        BinaryData request = BinaryData.fromObject(requestObj);
        return readWithResponse(request, requestOptions).getValue().toObject(Resource.class);
    }
}
