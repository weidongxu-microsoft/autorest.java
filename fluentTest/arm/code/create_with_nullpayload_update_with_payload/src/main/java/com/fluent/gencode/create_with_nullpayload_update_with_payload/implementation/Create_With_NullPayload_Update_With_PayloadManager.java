/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.fluent.gencode.create_with_nullpayload_update_with_payload.implementation;

import com.microsoft.azure.AzureEnvironment;
import com.microsoft.azure.AzureResponseBuilder;
import com.microsoft.azure.credentials.AzureTokenCredentials;
import com.microsoft.azure.management.apigeneration.Beta;
import com.microsoft.azure.management.apigeneration.Beta.SinceVersion;
import com.microsoft.azure.arm.resources.AzureConfigurable;
import com.microsoft.azure.serializer.AzureJacksonAdapter;
import com.microsoft.rest.RestClient;
import com.fluent.gencode.create_with_nullpayload_update_with_payload.Dogs;
import com.microsoft.azure.arm.resources.implementation.AzureConfigurableCoreImpl;
import com.microsoft.azure.arm.resources.implementation.ManagerCore;

/**
 * Entry point to Azure Pets resource management.
 */
public final class Create_With_NullPayload_Update_With_PayloadManager extends ManagerCore<Create_With_NullPayload_Update_With_PayloadManager, PetResourceProviderClientImpl> {
    private Dogs dogs;
    /**
    * Get a Configurable instance that can be used to create Create_With_NullPayload_Update_With_PayloadManager with optional configuration.
    *
    * @return the instance allowing configurations
    */
    public static Configurable configure() {
        return new Create_With_NullPayload_Update_With_PayloadManager.ConfigurableImpl();
    }
    /**
    * Creates an instance of Create_With_NullPayload_Update_With_PayloadManager that exposes Pets resource management API entry points.
    *
    * @param credentials the credentials to use
    * @param subscriptionId the subscription UUID
    * @return the Create_With_NullPayload_Update_With_PayloadManager
    */
    public static Create_With_NullPayload_Update_With_PayloadManager authenticate(AzureTokenCredentials credentials, String subscriptionId) {
        return new Create_With_NullPayload_Update_With_PayloadManager(new RestClient.Builder()
            .withBaseUrl(credentials.environment(), AzureEnvironment.Endpoint.RESOURCE_MANAGER)
            .withCredentials(credentials)
            .withSerializerAdapter(new AzureJacksonAdapter())
            .withResponseBuilderFactory(new AzureResponseBuilder.Factory())
            .build(), subscriptionId);
    }
    /**
    * Creates an instance of Create_With_NullPayload_Update_With_PayloadManager that exposes Pets resource management API entry points.
    *
    * @param restClient the RestClient to be used for API calls.
    * @param subscriptionId the subscription UUID
    * @return the Create_With_NullPayload_Update_With_PayloadManager
    */
    public static Create_With_NullPayload_Update_With_PayloadManager authenticate(RestClient restClient, String subscriptionId) {
        return new Create_With_NullPayload_Update_With_PayloadManager(restClient, subscriptionId);
    }
    /**
    * The interface allowing configurations to be set.
    */
    public interface Configurable extends AzureConfigurable<Configurable> {
        /**
        * Creates an instance of Create_With_NullPayload_Update_With_PayloadManager that exposes Pets management API entry points.
        *
        * @param credentials the credentials to use
        * @param subscriptionId the subscription UUID
        * @return the interface exposing Pets management API entry points that work across subscriptions
        */
        Create_With_NullPayload_Update_With_PayloadManager authenticate(AzureTokenCredentials credentials, String subscriptionId);
    }

    /**
     * @return Entry point to manage Dogs.
     */
    public Dogs dogs() {
        if (this.dogs == null) {
            this.dogs = new DogsImpl(this);
        }
        return this.dogs;
    }

    /**
    * The implementation for Configurable interface.
    */
    private static final class ConfigurableImpl extends AzureConfigurableCoreImpl<Configurable> implements Configurable {
        public Create_With_NullPayload_Update_With_PayloadManager authenticate(AzureTokenCredentials credentials, String subscriptionId) {
           return Create_With_NullPayload_Update_With_PayloadManager.authenticate(buildRestClient(credentials), subscriptionId);
        }
     }
    private Create_With_NullPayload_Update_With_PayloadManager(RestClient restClient, String subscriptionId) {
        super(
            restClient,
            subscriptionId,
            new PetResourceProviderClientImpl(restClient).withSubscriptionId(subscriptionId));
    }
}