// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.microsoft.typespec.http.client.generator.mgmt.template;

import com.microsoft.typespec.http.client.generator.core.extension.model.codemodel.CodeModel;
import com.microsoft.typespec.http.client.generator.mgmt.FluentGen;
import com.microsoft.typespec.http.client.generator.mgmt.FluentGenAccessor;
import com.microsoft.typespec.http.client.generator.mgmt.TestUtils;
import com.microsoft.typespec.http.client.generator.mgmt.model.clientmodel.FluentClient;
import com.microsoft.typespec.http.client.generator.mgmt.model.clientmodel.FluentExample;
import com.microsoft.typespec.http.client.generator.mgmt.model.clientmodel.FluentStatic;
import com.microsoft.typespec.http.client.generator.mgmt.model.javamodel.FluentJavaPackage;
import com.microsoft.typespec.http.client.generator.core.model.clientmodel.Client;
import com.microsoft.typespec.http.client.generator.core.model.javamodel.JavaFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FluentExampleTests {

    private static FluentGenAccessor fluentgenAccessor;

    @BeforeAll
    public static void ensurePlugin() {
        FluentGen fluentgen = new TestUtils.MockFluentGen();
        fluentgenAccessor = new FluentGenAccessor(fluentgen);
    }

    @Test
    public void testLocks() {
        CodeModel codeModel = TestUtils.loadCodeModel(fluentgenAccessor, "code-model-fluentnamer-locks.yaml");
        Client client = FluentStatic.getClient();
        FluentJavaPackage javaPackage = fluentgenAccessor.handleTemplate(client);
        FluentClient fluentClient = fluentgenAccessor.handleFluentLite(codeModel, client, javaPackage);

        List<FluentExample> examples = fluentClient.getExamples();
        Assertions.assertFalse(examples.isEmpty());
        // TODO verification
    }

    @Test
    public void testStorage() {
        CodeModel codeModel = TestUtils.loadCodeModel(fluentgenAccessor, "code-model-fluentnamer-storage.yaml");
        Client client = FluentStatic.getClient();
        FluentJavaPackage javaPackage = fluentgenAccessor.handleTemplate(client);
        FluentClient fluentClient = fluentgenAccessor.handleFluentLite(codeModel, client, javaPackage);

        List<FluentExample> examples = fluentClient.getExamples();
        Assertions.assertFalse(examples.isEmpty());

        {
            FluentExample example = examples.stream()
                    .filter(e -> e.getClassName().equals("StorageAccountsCreateSamples"))
                    .findFirst().get();
            JavaFile javaFile = new JavaFile("dummy");
            FluentExampleTemplate.getInstance().write(example, javaFile);
            String content = javaFile.getContents().toString();
            // Map
            Assertions.assertTrue(content.contains(".withTags(mapOf(\"key1\","));
            // identity
            Assertions.assertTrue(content.contains(".withIdentity(new Identity().withType(IdentityType.USER_ASSIGNED).withUserAssignedIdentities(mapOf(\"/subscriptions/{subscription-id}/resourceGroups/res9101/providers/Microsoft.ManagedIdentity/userAssignedIdentities/{managed-identity-name}\", new UserAssignedIdentity())))"));
            // create
            Assertions.assertTrue(content.contains(".create()"));
        }

        {
            FluentExample example = examples.stream()
                    .filter(e -> e.getClassName().equals("BlobContainersCreateOrUpdateImmutabilityPolicySamples"))
                    .findFirst().get();
            JavaFile javaFile = new JavaFile("dummy");
            FluentExampleTemplate.getInstance().write(example, javaFile);
            String content = javaFile.getContents().toString();
            // optional property/parameter not provided in example
            Assertions.assertFalse(content.contains(".withIfMatch"));
            // create
            Assertions.assertTrue(content.contains(".create()"));
        }

        {
            FluentExample example = examples.stream()
                    .filter(e -> e.getClassName().equals("StorageAccountsUpdateSamples"))
                    .findFirst().get();
            JavaFile javaFile = new JavaFile("dummy");
            FluentExampleTemplate.getInstance().write(example, javaFile);
            String content = javaFile.getContents().toString();
            // get
            Assertions.assertTrue(content.contains("manager.storageAccounts().getByResourceGroup"));
            // update
            Assertions.assertTrue(content.contains("resource.update()"));
            // apply
            Assertions.assertTrue(content.contains(".apply()"));
        }
    }

    @Test
    public void testPolicy() {
        CodeModel codeModel = TestUtils.loadCodeModel(fluentgenAccessor, "code-model-fluentnamer-policy.yaml");
        Client client = FluentStatic.getClient();
        FluentJavaPackage javaPackage = fluentgenAccessor.handleTemplate(client);
        FluentClient fluentClient = fluentgenAccessor.handleFluentLite(codeModel, client, javaPackage);

        List<FluentExample> examples = fluentClient.getExamples();
        Assertions.assertFalse(examples.isEmpty());

        {
            FluentExample example = examples.stream()
                    .filter(e -> e.getClassName().equals("PolicyDefinitionsCreateOrUpdateAtManagementGroupSamples"))
                    .findFirst().get();
            JavaFile javaFile = new JavaFile("dummy");
            FluentExampleTemplate.getInstance().write(example, javaFile);
            String content = javaFile.getContents().toString();
            // policyRule and metadata is Object
            Assertions.assertTrue(content.contains(".withMetadata(SerializerFactory.createDefaultManagementSerializerAdapter().deserialize(\"{\\\"category\\\":\\\"Naming\\\"}\", Object.class, SerializerEncoding.JSON))"));
        }

        {
            FluentExample example = examples.stream()
                    .filter(e -> e.getClassName().equals("PolicyDefinitionsCreateOrUpdateSamples"))
                    .findFirst().get();
            JavaFile javaFile = new JavaFile("dummy");
            FluentExampleTemplate.getInstance().write(example, javaFile);
            String content = javaFile.getContents().toString();
            // allowedValues is array of Object
            Assertions.assertTrue(content.contains(".withAllowedValues(Arrays.asList(0, 30, 90, 180, 365))"));
            Assertions.assertTrue(content.contains(".withDefaultValue(365)"));
        }
    }
}