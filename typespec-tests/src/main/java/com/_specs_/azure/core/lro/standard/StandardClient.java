// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com._specs_.azure.core.lro.standard;

import com._specs_.azure.core.lro.standard.implementation.StandardClientImpl;
import com._specs_.azure.core.lro.standard.models.ExportedUser;
import com._specs_.azure.core.lro.standard.models.User;
import com.azure.core.annotation.Generated;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceClient;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.exception.ClientAuthenticationException;
import com.azure.core.exception.HttpResponseException;
import com.azure.core.exception.ResourceModifiedException;
import com.azure.core.exception.ResourceNotFoundException;
import com.azure.core.http.rest.RequestOptions;
import com.azure.core.util.BinaryData;
import com.azure.core.util.polling.PollOperationDetails;
import com.azure.core.util.polling.SyncPoller;

/**
 * Initializes a new instance of the synchronous StandardClient type.
 */
@ServiceClient(builder = StandardClientBuilder.class)
public final class StandardClient {
    @Generated
    private final StandardClientImpl serviceClient;

    /**
     * Initializes an instance of StandardClient class.
     * 
     * @param serviceClient the service client implementation.
     */
    @Generated
    StandardClient(StandardClientImpl serviceClient) {
        this.serviceClient = serviceClient;
    }

    /**
     * Adds a user or replaces a user's fields.
     * 
     * Creates or replaces a User.
     * <p>
     * <strong>Request Body Schema</strong>
     * </p>
     * <pre>{@code
     * {
     *     name: String (Required)
     *     role: String (Required)
     * }
     * }</pre>
     * <p>
     * <strong>Response Body Schema</strong>
     * </p>
     * <pre>{@code
     * {
     *     name: String (Required)
     *     role: String (Required)
     * }
     * }</pre>
     * 
     * @param name The name of user.
     * @param resource The resource instance.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the {@link SyncPoller} for polling of details about a user.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    public SyncPoller<BinaryData, BinaryData> beginCreateOrReplace(String name, BinaryData resource,
        RequestOptions requestOptions) {
        return this.serviceClient.beginCreateOrReplace(name, resource, requestOptions);
    }

    /**
     * Deletes a user.
     * 
     * Deletes a User.
     * <p>
     * <strong>Response Body Schema</strong>
     * </p>
     * <pre>{@code
     * {
     *     id: String (Required)
     *     status: String(NotStarted/Running/Succeeded/Failed/Canceled) (Required)
     *     error (Optional): {
     *         code: String (Required)
     *         message: String (Required)
     *         target: String (Optional)
     *         details (Optional): [
     *             (recursive schema, see above)
     *         ]
     *     }
     * }
     * }</pre>
     * 
     * @param name The name of user.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the {@link SyncPoller} for polling of provides status details for long running operations.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    public SyncPoller<BinaryData, Void> beginDelete(String name, RequestOptions requestOptions) {
        return this.serviceClient.beginDelete(name, requestOptions);
    }

    /**
     * Exports a user.
     * 
     * Exports a User.
     * <p>
     * <strong>Response Body Schema</strong>
     * </p>
     * <pre>{@code
     * {
     *     id: String (Required)
     *     status: String (Required)
     *     error (Optional): {
     *         code: String (Required)
     *         message: String (Required)
     *         target: String (Optional)
     *         details (Optional): [
     *             (recursive schema, see above)
     *         ]
     *     }
     * }
     * }</pre>
     * 
     * @param name The name of user.
     * @param format The format of the data.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the {@link SyncPoller} for polling of status details for long running operations.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    public SyncPoller<BinaryData, BinaryData> beginExport(String name, String format, RequestOptions requestOptions) {
        return this.serviceClient.beginExport(name, format, requestOptions);
    }

    /**
     * Adds a user or replaces a user's fields.
     * 
     * Creates or replaces a User.
     * 
     * @param name The name of user.
     * @param resource The resource instance.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of details about a user.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    public SyncPoller<PollOperationDetails, User> beginCreateOrReplace(String name, User resource) {
        // Generated convenience method for beginCreateOrReplaceWithModel
        RequestOptions requestOptions = new RequestOptions();
        return serviceClient.beginCreateOrReplaceWithModel(name, BinaryData.fromObject(resource), requestOptions);
    }

    /**
     * Deletes a user.
     * 
     * Deletes a User.
     * 
     * @param name The name of user.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of provides status details for long running operations.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    public SyncPoller<PollOperationDetails, Void> beginDelete(String name) {
        // Generated convenience method for beginDeleteWithModel
        RequestOptions requestOptions = new RequestOptions();
        return serviceClient.beginDeleteWithModel(name, requestOptions);
    }

    /**
     * Exports a user.
     * 
     * Exports a User.
     * 
     * @param name The name of user.
     * @param format The format of the data.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of status details for long running operations.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    public SyncPoller<PollOperationDetails, ExportedUser> beginExport(String name, String format) {
        // Generated convenience method for beginExportWithModel
        RequestOptions requestOptions = new RequestOptions();
        return serviceClient.beginExportWithModel(name, format, requestOptions);
    }
}
