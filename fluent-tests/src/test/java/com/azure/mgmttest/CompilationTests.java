// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.mgmttest;

import com.azure.core.management.Resource;
import com.azure.core.management.SystemData;
import com.azure.core.management.exception.ManagementError;
import com.azure.core.management.exception.ManagementException;
import com.azure.mgmtlitetest.consumption.models.LegacyReservationRecommendation;
import com.azure.mgmtlitetest.schemacleanup.models.UserAssignedIdentity;
import com.azure.mgmttest.appservice.fluent.WebSiteManagementClient;
import com.azure.mgmttest.appservice.models.DefaultErrorResponseErrorException;
import com.azure.mgmttest.authorization.models.GraphError;
import com.azure.mgmttest.authorization.models.GraphErrorException;
import com.azure.mgmttest.azurestack.fluent.models.ExtendedProductInner;
import com.azure.mgmttest.compute.fluent.CloudServicesUpdateDomainsClient;
import com.azure.mgmttest.computegallery.fluent.models.SharedGalleryInner;
import com.azure.mgmttest.cosmos.models.SqlDatabaseGetPropertiesResource;
import com.azure.mgmttest.hybridnetwork.fluent.models.DeviceInner;
import com.azure.mgmttest.hybridnetwork.models.AzureStackEdgeFormat;
import com.azure.mgmttest.hybridnetwork.models.DevicePropertiesFormat;
import com.azure.mgmttest.iothub.models.ErrorDetails;
import com.azure.mgmttest.monitor.fluent.models.DataCollectionRuleResourceInner;
import com.azure.mgmttest.network.fluent.NetworkInterfacesClient;
import com.azure.mgmttest.network.fluent.models.NetworkInterfaceInner;
import com.azure.mgmttest.network.fluent.models.NetworkSecurityGroupInner;
import com.azure.mgmttest.networkwatcher.fluent.models.PacketCaptureResultInner;
import com.azure.mgmttest.nonstringexpandableenum.fluent.models.ScheduledQueryRuleProperties;
import com.azure.mgmttest.nonstringexpandableenum.models.AlertSeverity;
import com.azure.mgmttest.postgresqlhsc.fluent.models.ServerConfigurationInner;
import com.azure.mgmttest.resources.fluent.models.ResourceGroupInner;
import com.azure.mgmttest.resources.models.IdentityUserAssignedIdentities;
import com.azure.mgmttest.resourcewithwritablename.fluent.models.FirewallRuleInner;
import com.azure.mgmttest.storage.fluent.StorageAccountsClient;
import com.azure.mgmttest.storage.fluent.models.StorageAccountInner;
import com.azure.mgmttest.trafficmanager.fluent.models.EndpointInner;
import com.azure.resourcemanager.resources.fluentcore.collection.InnerSupportsGet;
import com.azure.resourcemanager.resources.fluentcore.collection.InnerSupportsListing;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.mock;

public class CompilationTests {

    // Verify method signature at compile time.

    public void testManagementClient() {
        // Operation group
        WebSiteManagementClient webSiteManagementClient = mock(WebSiteManagementClient.class);
        webSiteManagementClient.list();

        StorageAccountsClient storageAccountsClient = mock(StorageAccountsClient.class);
        storageAccountsClient.list();
    }

    public void testOperationName() {
        // ListAll -> list, List -> listByResourceGroup (spec -> code).
        NetworkInterfacesClient networkInterfaces = mock(NetworkInterfacesClient.class);
        networkInterfaces.list();
        networkInterfaces.listAsync();
        networkInterfaces.listByResourceGroup(anyString());
        networkInterfaces.listByResourceGroupAsync(anyString());
        networkInterfaces.getByResourceGroup(anyString(), anyString());
        networkInterfaces.getByResourceGroupAsync(anyString(), anyString());
    }

    public void testInnerSupport() {
        // Add InnerSupportsListing to class.
        InnerSupportsListing<StorageAccountInner> storageAccounts = mock(StorageAccountsClient.class);
        storageAccounts.list();

        // Add InnerSupportsGet to class.

        InnerSupportsGet<NetworkInterfaceInner> networkInterfaces = mock(NetworkInterfacesClient.class);
        networkInterfaces.getByResourceGroup(anyString(), anyString());
    }

    public void testResourceType() {
        // ResourceGroup is regarded as subclass of Resource.
        Resource resourceGroup = mock(ResourceGroupInner.class);
        resourceGroup.id();

        // NetworkSecurityGroup is subclass of Resource, but the id property from spec is not readonly,
        // hence it get pulled out from Resource.
        NetworkSecurityGroupInner networkSecurityGroup = mock(NetworkSecurityGroupInner.class);
        networkSecurityGroup.withId(anyString());
        networkSecurityGroup.id();
    }

    public void testAdditionalPropertyName() {
        IdentityUserAssignedIdentities identities = new IdentityUserAssignedIdentities();
    }

    public void testMultipleInheritance() {
        SqlDatabaseGetPropertiesResource sqlDatabaseGetPropertiesResource = new SqlDatabaseGetPropertiesResource();
        sqlDatabaseGetPropertiesResource.rid();
        sqlDatabaseGetPropertiesResource.colls();
    }

    public void testFlattenedParameter() {
        CloudServicesUpdateDomainsClient cloudServicesUpdateDomainsClient = mock(CloudServicesUpdateDomainsClient.class);
        cloudServicesUpdateDomainsClient.walkUpdateDomainWithResponseAsync(anyString(), anyString(), anyInt(), any());
    }

    public void testFlattenedModel() {
        SharedGalleryInner sharedGallery = mock(SharedGalleryInner.class);
        sharedGallery.withUniqueId(anyString());
        sharedGallery.uniqueId();
        sharedGallery.name();
        sharedGallery.location();

        PacketCaptureResultInner packetCaptureResult = mock(PacketCaptureResultInner.class);
        packetCaptureResult.withTarget(anyString());
        packetCaptureResult.target();

        // nested x-ms-flatten from superclass in ExtendedProduct
        ExtendedProductInner extendedProduct = mock(ExtendedProductInner.class);
        extendedProduct.uri();

        // do not flatten if polymorphic in DevicePropertiesFormat
        DeviceInner device = mock(DeviceInner.class);
        DevicePropertiesFormat devicePropertiesFormat = device.properties();
        DevicePropertiesFormat azureStackEdgeFormat = mock(AzureStackEdgeFormat.class);

        // flatten the empty model which has non-empty parent model
        DataCollectionRuleResourceInner dataCollectionRule = mock(DataCollectionRuleResourceInner.class);
        dataCollectionRule.dataSources();
    }

    public void testProxyResourceOverride() {
        EndpointInner endpointInner = new EndpointInner();
        endpointInner.withType(endpointInner.type());
        endpointInner.withId(endpointInner.id());
        endpointInner.withName(endpointInner.name());
    }

//    public void testIntEnum() {
//        ContainerServiceMasterProfile containerServiceMasterProfile = new ContainerServiceMasterProfile();
//        containerServiceMasterProfile.withCount(Count.THREE);
//        int countInt = containerServiceMasterProfile.count().toInt();
//    }

    public void testException() {
        ManagementException exception = new DefaultErrorResponseErrorException(anyString(), null);
        ManagementError error = exception.getValue();

        GraphErrorException graphException = new GraphErrorException(anyString(), null);
        GraphError graphError = graphException.getValue();
    }

    public void testPropertyExtractFromResource() {
        ServerConfigurationInner serverConfiguration = mock(ServerConfigurationInner.class);
        // systemData from ProxyResource > Resource
        SystemData systemData = serverConfiguration.systemData();
    }

    public void testSharedError() {
        ErrorDetails errorDetails = mock(ErrorDetails.class);
        errorDetails.getHttpStatusCode();
    }

    public void testPolymophicSubClass() {
        LegacyReservationRecommendation legacyReservationRecommendation = new LegacyReservationRecommendation();
    }

    public void testSchemaCleanup() {
        UserAssignedIdentity userAssignedIdentity = new UserAssignedIdentity();
    }

    public void testResourceWithWritableName() {
        FirewallRuleInner firewallRuleInner = new FirewallRuleInner();
    }

    public void testNonStringExpandableEnum() throws IOException {
        ScheduledQueryRuleProperties properties = new ScheduledQueryRuleProperties();
        String jsonString = properties.toJsonString();
    }
}
