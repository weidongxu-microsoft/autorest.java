// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.security.confidentialledger;

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
import com.azure.security.confidentialledger.implementation.ConfidentialLedgerIdentityServicesImpl;
import reactor.core.publisher.Mono;

/** Initializes a new instance of the asynchronous ConfidentialLedgerServiceClient type. */
@ServiceClient(builder = ConfidentialLedgerIdentityServiceClientBuilder.class, isAsync = true)
public final class ConfidentialLedgerIdentityServiceAsyncClient {
    @Generated private final ConfidentialLedgerIdentityServicesImpl serviceClient;

    /**
     * Initializes an instance of ConfidentialLedgerIdentityServiceAsyncClient class.
     *
     * @param serviceClient the service client implementation.
     */
    @Generated
    ConfidentialLedgerIdentityServiceAsyncClient(ConfidentialLedgerIdentityServicesImpl serviceClient) {
        this.serviceClient = serviceClient;
    }

    /**
     * <strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * double
     * }</pre>
     *
     * @param ledgerId Id of the Confidential Ledger instance to get information for.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the response body along with {@link Response} on successful completion of {@link Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Double>> getLedgerIdentityWithResponse(String ledgerId, RequestOptions requestOptions) {
        return this.serviceClient.getLedgerIdentityWithResponseAsync(ledgerId, requestOptions);
    }
}
