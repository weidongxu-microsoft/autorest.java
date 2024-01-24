// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.autorest.util;

import com.azure.autorest.extension.base.model.codemodel.ApiVersion;
import com.azure.autorest.extension.base.model.codemodel.Client;
import com.azure.autorest.extension.base.model.codemodel.CodeModel;
import com.azure.autorest.extension.base.model.codemodel.ConstantSchema;
import com.azure.autorest.extension.base.model.codemodel.KnownMediaType;
import com.azure.autorest.extension.base.model.codemodel.Language;
import com.azure.autorest.extension.base.model.codemodel.Languages;
import com.azure.autorest.extension.base.model.codemodel.ObjectSchema;
import com.azure.autorest.extension.base.model.codemodel.OperationGroup;
import com.azure.autorest.extension.base.model.codemodel.Parameter;
import com.azure.autorest.extension.base.plugin.JavaSettings;
import com.azure.autorest.mapper.Mappers;
import com.azure.autorest.model.clientmodel.AsyncSyncClient;
import com.azure.autorest.model.clientmodel.ClassType;
import com.azure.autorest.model.clientmodel.ClientMethod;
import com.azure.autorest.model.clientmodel.ClientModel;
import com.azure.autorest.model.clientmodel.ClientModelProperty;
import com.azure.autorest.model.clientmodel.ClientModelPropertyAccess;
import com.azure.autorest.model.clientmodel.ClientModelPropertyReference;
import com.azure.autorest.model.clientmodel.ClientModels;
import com.azure.autorest.model.clientmodel.ConvenienceMethod;
import com.azure.autorest.model.clientmodel.GenericType;
import com.azure.autorest.model.clientmodel.IType;
import com.azure.autorest.model.clientmodel.ImplementationDetails;
import com.azure.autorest.model.clientmodel.MethodGroupClient;
import com.azure.autorest.model.clientmodel.ServiceClient;
import com.azure.autorest.model.javamodel.JavaVisibility;
import com.azure.core.util.CoreUtils;

import java.net.URI;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Utilities for client model.
 */
public class ClientModelUtil {

    public static final String MULTI_PART_FORM_DATA_HELPER_CLASS_NAME = "MultipartFormDataHelper";

    public static final String CORE_TO_CODEGEN_BRIDGE_UTILS_CLASS_NAME = "CoreToCodegenBridgeUtils";

    private static final Pattern SPACE = Pattern.compile("\\s");
    private static final Pattern SPLIT_FLATTEN_PROPERTY_PATTERN = Pattern.compile("((?<!\\\\))\\.");

    public static final String JSON_MERGE_PATCH_HELPER_CLASS_NAME = "JsonMergePatchHelper";

    /**
     * Prepare async/sync clients for service client.
     *
     * @param serviceClient the service client.
     * @param asyncClients output, the async clients.
     * @param syncClients output, the sync client.
     */
    public static void getAsyncSyncClients(Client client, ServiceClient serviceClient,
                                           List<AsyncSyncClient> asyncClients, List<AsyncSyncClient> syncClients) {
        String packageName = getAsyncSyncClientPackageName(serviceClient);
        boolean generateAsyncMethods = JavaSettings.getInstance().isGenerateAsyncMethods();
        boolean generateSyncMethods = JavaSettings.getInstance().isGenerateSyncMethods();

        if (serviceClient.getProxy() != null) {
            AsyncSyncClient.Builder builder = new AsyncSyncClient.Builder()
                    .packageName(packageName)
                    .serviceClient(serviceClient)
                    .crossLanguageDefinitionId(client.getCrossLanguageDefinitionId());

            final List<ConvenienceMethod> convenienceMethods = client.getOperationGroups().stream()
                    .filter(og -> CoreUtils.isNullOrEmpty(og.getLanguage().getJava().getName()))    // no resource group
                    .findAny()
                    .map(og -> getConvenienceMethods(serviceClient::getClientMethods, og))
                    .orElse(Collections.emptyList());
            builder.convenienceMethods(convenienceMethods);

            if (generateAsyncMethods) {
                String asyncClassName = clientNameToAsyncClientName(serviceClient.getClientBaseName());
                asyncClients.add(builder.className(asyncClassName).build());
            }

            if (generateSyncMethods) {
                String syncClassName =
                        serviceClient.getClientBaseName().endsWith("Client")
                                ? serviceClient.getClientBaseName()
                                : serviceClient.getClientBaseName() + "Client";
                syncClients.add(builder.className(syncClassName).build());
            }
        }

        final int count = serviceClient.getMethodGroupClients().size() + asyncClients.size();
        for (MethodGroupClient methodGroupClient : serviceClient.getMethodGroupClients()) {
            AsyncSyncClient.Builder builder = new AsyncSyncClient.Builder()
                    .packageName(packageName)
                    .serviceClient(serviceClient)
                    .methodGroupClient(methodGroupClient);

            final List<ConvenienceMethod> convenienceMethods = client.getOperationGroups().stream()
                    .filter(og -> methodGroupClient.getClassBaseName().equals(og.getLanguage().getJava().getName()))
                    .findAny()
                    .map(og -> getConvenienceMethods(methodGroupClient::getClientMethods, og))
                    .orElse(Collections.emptyList());
            builder.convenienceMethods(convenienceMethods);

            if (count == 1) {
                // if it is the only method group, use service client name as base.

                if (generateAsyncMethods) {
                    String asyncClassName = clientNameToAsyncClientName(serviceClient.getClientBaseName());
                    asyncClients.add(builder.className(asyncClassName).build());
                }

                if (generateSyncMethods) {
                    String syncClassName =
                            serviceClient.getClientBaseName().endsWith("Client")
                                    ? serviceClient.getClientBaseName()
                                    : serviceClient.getClientBaseName() + "Client";
                    syncClients.add(builder.className(syncClassName).build());
                }
            } else {
                if (generateAsyncMethods) {
                    String asyncClassName = clientNameToAsyncClientName(methodGroupClient.getClassBaseName());
                    asyncClients.add(builder.className(asyncClassName).build());
                }

                if (generateSyncMethods) {
                    String syncClassName =
                            methodGroupClient.getClassBaseName().endsWith("Client")
                                    ? methodGroupClient.getClassBaseName()
                                    : methodGroupClient.getClassBaseName() + "Client";
                    syncClients.add(builder.className(syncClassName).build());
                }
            }
        }
    }

    private static List<ConvenienceMethod> getConvenienceMethods(Supplier<List<ClientMethod>> clientMethods, OperationGroup og) {
        return og.getOperations().stream()
                .filter(o -> o.getConvenienceApi() != null)
                .flatMap(o -> {
                    List<ClientMethod> cMethods = Mappers.getClientMethodMapper().map(o, false)
                            .stream()
                            .filter(m -> m.getMethodVisibility() == JavaVisibility.Public)
                            .collect(Collectors.toList());
                    if (!cMethods.isEmpty()) {
                        // sync stack generates additional proxy methods with name suffix "Sync"
                        String proxyMethodBaseName = cMethods.iterator().next().getProxyMethod().getBaseName();
                        return clientMethods.get().stream()
                                .filter(m ->
                                        proxyMethodBaseName.equals(m.getProxyMethod().getBaseName())
                                                && m.getMethodVisibility() == JavaVisibility.Public)
                                .map(m -> new ConvenienceMethod(m, cMethods));
                    } else {
                        return Stream.empty();
                    }
                }).collect(Collectors.toList());
    }

    /**
     * @param codeModel the code model
     * @return the interface name of service client.
     */
    public static String getClientInterfaceName(Client codeModel) {
        JavaSettings settings = JavaSettings.getInstance();
        String serviceClientInterfaceName = (settings.getClientTypePrefix() == null ? "" : settings.getClientTypePrefix())
                + codeModel.getLanguage().getJava().getName();
        if (settings.isDataPlaneClient()) {
            // mandate ending Client for LLC
            if (!serviceClientInterfaceName.endsWith("Client")) {
                String serviceName = settings.getServiceName();
                if (serviceName != null && codeModel instanceof CodeModel) {
                    serviceName = SPACE.matcher(serviceName).replaceAll("");
                    serviceClientInterfaceName = serviceName.endsWith("Client") ? serviceName : (serviceName + "Client");
                } else {
                    serviceClientInterfaceName += "Client";
                }
            }
        }
        return serviceClientInterfaceName;
    }

    /**
     * @param codeModel the code model
     * @return the class name of service client implementation.
     */
    public static String getClientImplementClassName(Client codeModel) {
        String serviceClientInterfaceName = getClientInterfaceName(codeModel);
        return getClientImplementClassName(serviceClientInterfaceName);
    }

    /**
     * @param serviceClientInterfaceName the interface name of service client
     * @return the class name of service client implementation.
     */
    public static String getClientImplementClassName(String serviceClientInterfaceName) {
        JavaSettings settings = JavaSettings.getInstance();
        String serviceClientClassName = serviceClientInterfaceName;
        if (settings.isGenerateClientAsImpl()) {
            serviceClientClassName += "Impl";
        }
        return serviceClientClassName;
    }

    /**
     * @param serviceClientInterfaceName the interface name of service client
     * @return the class name of service version.
     */
    public static String getServiceVersionClassName(String serviceClientInterfaceName) {
        JavaSettings settings = JavaSettings.getInstance();
        String serviceName;
        if (settings.getServiceName() == null) {
            if (serviceClientInterfaceName.endsWith("Client")) {
                // remove ending Client
                serviceName = serviceClientInterfaceName.substring(0, serviceClientInterfaceName.length() - "Client".length());
            } else {
                serviceName = serviceClientInterfaceName;
            }
        } else {
            serviceName = SPACE.matcher(settings.getServiceName()).replaceAll("");
        }
        return serviceName + (serviceName.endsWith("Service") ? "Version" : "ServiceVersion");
    }

    /**
     * Gets the suffix of the builder class.
     * <p>
     * The class name of the Builder is usually the service client interface name + builder suffix.
     *
     * @return the suffix of the builder class.
     */
    public static String getBuilderSuffix() {
        JavaSettings settings = JavaSettings.getInstance();
        StringBuilder builderSuffix = new StringBuilder();
        if (!settings.isFluent()
                && settings.isGenerateClientAsImpl()
                && !settings.isGenerateSyncAsyncClients()
                && !settings.isDataPlaneClient()) {
            builderSuffix.append("Impl");
        }
        builderSuffix.append("Builder");
        return builderSuffix.toString();
    }

    public static String getServiceClientBuilderPackageName(ServiceClient serviceClient) {
        JavaSettings settings = JavaSettings.getInstance();
        String builderPackage = serviceClient.getPackage();
        if ((settings.isGenerateSyncAsyncClients() || settings.isDataPlaneClient()) && !settings.isFluent()) {
            builderPackage = settings.getPackage();
        } else if (settings.isFluent()) {
            builderPackage = settings.getPackage(settings.getImplementationSubpackage());
        }
        return builderPackage;
    }

    public static String getServiceClientPackageName(String serviceClientClassName) {
        JavaSettings settings = JavaSettings.getInstance();
        String subpackage = settings.isGenerateClientAsImpl() ? settings.getImplementationSubpackage() : null;
        if (settings.isFluent()) {
            if (settings.isGenerateSyncAsyncClients() || settings.isGenerateClientInterfaces()) {
                subpackage = settings.getImplementationSubpackage();
            } else {
                subpackage = settings.getFluentSubpackage();
            }
        }
        if (settings.isCustomType(serviceClientClassName)) {
            subpackage = settings.getCustomTypesSubpackage();
        }
        return settings.getPackage(subpackage);
    }

    public static String getAsyncSyncClientPackageName(ServiceClient serviceClient) {
        JavaSettings settings = JavaSettings.getInstance();
        if (settings.isFluent()) {
            return settings.getPackage(settings.getFluentSubpackage());
        } else {
            return getServiceClientBuilderPackageName(serviceClient);
        }
    }

    public static String getServiceClientInterfacePackageName() {
        JavaSettings settings = JavaSettings.getInstance();
        if (settings.isFluent()) {
            return settings.getPackage(settings.getFluentSubpackage());
        } else {
            return settings.getPackage();
        }
    }

    public static String getClientDefaultValueOrConstantValue(Parameter parameter) {
        String clientDefaultValueOrConstantValue = parameter.getClientDefaultValue();
        if (clientDefaultValueOrConstantValue == null) {
            if (parameter.getSchema() != null && parameter.getSchema() instanceof ConstantSchema) {
                ConstantSchema constantSchema = (ConstantSchema) parameter.getSchema();
                if (constantSchema.getValue() != null) {
                    clientDefaultValueOrConstantValue = constantSchema.getValue().getValue().toString();
                }
            }
        }
        return clientDefaultValueOrConstantValue;
    }

    private static String getFirstApiVersionFromOperation(CodeModel codeModel) {
        return codeModel.getOperationGroups().stream()
                .flatMap(og -> og.getOperations().stream())
                .filter(o -> o.getApiVersions() != null)
                .flatMap(o -> o.getApiVersions().stream())
                .filter(Objects::nonNull)
                .map(ApiVersion::getVersion)
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(null);
    }

    public static List<String> getApiVersions(CodeModel codeModel) {
        List<String> versions = codeModel.getClients().stream()
                .filter(c -> !CoreUtils.isNullOrEmpty(c.getApiVersions()))
                .map(c -> c.getApiVersions().stream().map(ApiVersion::getVersion).collect(Collectors.toList()))
                .findFirst().orElse(null);
        if (versions == null) {
            String version = getFirstApiVersionFromOperation(codeModel);
            if (version != null) {
                versions = Collections.singletonList(version);
            } else {
                versions = Collections.emptyList();
            }
        }
        return versions;
    }

    public static String getArtifactId() {
        JavaSettings settings = JavaSettings.getInstance();
        String artifactId = settings.getArtifactId();
        if (settings.isDataPlaneClient() && CoreUtils.isNullOrEmpty(artifactId)) {
            // convert package/namespace to artifact
            artifactId = settings.getPackage().toLowerCase(Locale.ROOT)
                    .replace("com.", "")
                    .replace(".", "-");
        }
        return artifactId;
    }

    public static String clientNameToAsyncClientName(String clientName) {
        if (clientName.endsWith("Client")) {
            clientName = clientName.substring(0, clientName.length() - "Client".length()) + "AsyncClient";
        } else {
            clientName += "AsyncClient";
        }
        return clientName;
    }

    /**
     * Split and unescape the possible flattened serialized property name to its components.
     *
     * @param serializedName the serialized property name belongs to either model or property that has {@code @JsonFlatten} annotation.
     * @return the components of the serialized property names
     */
    public static List<String> splitFlattenedSerializedName(String serializedName) {
        if (serializedName == null) {
            return Collections.emptyList();
        }

        String[] values = SPLIT_FLATTEN_PROPERTY_PATTERN.split(serializedName);
        for (int i = 0; i < values.length; ++i) {
            values[i] = values[i].replace("\\\\.", ".");
        }
        return Arrays.asList(values);
    }

    private static Function<String, ClientModel> getClientModelFunction = name -> ClientModels.getInstance().getModel(name);

    /**
     * Replace the default function of getting ClientModel by name.
     * <p>
     * Used in Fluent for providing additional ClientModel that exists in azure-core-management,
     * e.g. Resource, ManagementError
     *
     * @param function the function of getting ClientModel by name
     */
    public static void setGetClientModelFunction(Function<String, ClientModel> function) {
        getClientModelFunction = function;
    }

    /**
     * Get ClientModel by name.
     *
     * @param name the name of the ClientModel (without package)
     * @return the ClientModel instance. <code>null</code> if not found.
     */
    public static ClientModel getClientModel(String name) {
        return getClientModelFunction.apply(name);
    }

    /**
     * Check if the type is a ClientModel.
     *
     * @param type the type
     * @return whether the type is a ClientModel.
     */
    public static boolean isClientModel(IType type) {
        if (type instanceof ClassType) {
            ClassType classType = (ClassType) type;
            return classType.getPackage().startsWith(JavaSettings.getInstance().getPackage())
                    && getClientModel(classType.getName()) != null;
        } else {
            return false;
        }
    }

    /**
     * Check if the type is an external model.
     *
     * @param type the type
     * @return whether the type is an external model.
     */
    public static boolean isExternalModel(IType type) {
        if (type instanceof ClassType) {
            ClassType classType = (ClassType) type;
            ClientModel model = getClientModel(classType.getName());
            return model != null && model.getImplementationDetails() != null && model.getImplementationDetails().getUsages() != null
                    && model.getImplementationDetails().getUsages().contains(ImplementationDetails.Usage.EXTERNAL);
        } else {
            return false;
        }
    }

    /**
     * Check if the type is an output only model.
     * <p>
     * A model is considered output only if and only if the model's usages contain either
     * {@link ImplementationDetails#isOutput()} or {@link ImplementationDetails#isException()} and do not contain
     * {@link ImplementationDetails#isInput()}.
     *
     * @param model the client model.
     * @return whether the type is an output only model.
     */
    public static boolean isOutputOnly(ClientModel model) {
        ImplementationDetails details = model.getImplementationDetails();
        if (details == null || details.getUsages() == null) {
            return false;
        }

        return (details.isOutput() || details.isException()) && !details.isInput();
    }

    /**
     * Check if the model is used in json-merge-patch operation
     */
    public static boolean isJsonMergePatchModel(ClientModel model) {
        return model.getImplementationDetails() != null && model.getImplementationDetails().getUsages() != null
                && model.getImplementationDetails().getUsages().contains(ImplementationDetails.Usage.JSON_MERGE_PATCH);
    }

    /**
     * Gets all parent properties.
     *
     * @param model The client model.
     * @return Returns all properties that are defined by super types of the client model.
     */
    public static List<ClientModelProperty> getParentProperties(ClientModel model) {
        String lastParentName = model.getName();
        ClientModel parentModel = getClientModel(model.getParentModelName());
        List<ClientModelProperty> parentProperties = new ArrayList<>();
        while (parentModel != null && !lastParentName.equals(parentModel.getName())) {
            // Add the properties in inverse order as they be reverse at the end.
            List<ClientModelProperty> parentProps = new ArrayList<>(parentModel.getProperties());
            for (int i = parentProps.size() - 1; i >= 0; i--) {
                parentProperties.add(parentProps.get(i));
            }

            lastParentName = parentModel.getName();
            parentModel = getClientModel(parentModel.getParentModelName());
        }
        Collections.reverse(parentProperties);
        return parentProperties;
    }

    public static List<ClientModelProperty> getRequiredWritableParentProperties(ClientModel model) {
        String lastParentName = model.getName();
        ClientModel parentModel = getClientModel(model.getParentModelName());
        List<ClientModelProperty> requiredParentProperties = new ArrayList<>();
        while (parentModel != null && !lastParentName.equals(parentModel.getName())) {
            // Add the properties in inverse order as they be reverse at the end.
            List<ClientModelProperty> ctorArgs = parentModel.getProperties().stream()
                .filter(property -> property.isRequired() && !property.isConstant() && !property.isReadOnly())
                .collect(Collectors.toList());

            for (int i = ctorArgs.size() - 1; i >= 0; i--) {
                requiredParentProperties.add(ctorArgs.get(i));
            }

            lastParentName = parentModel.getName();
            parentModel = getClientModel(parentModel.getParentModelName());
        }
        Collections.reverse(requiredParentProperties);
        return requiredParentProperties;
    }

    /**
     * Indicates whether the property will have a setter method generated for it.
     *
     * @param property The client model property, or a reference.
     * @param settings Autorest generation settings.
     * @return Whether the property will have a setter method.
     */
    public static boolean hasSetter(ClientModelPropertyAccess property, JavaSettings settings) {
        // If the property isn't read-only or required and part of the constructor, and it isn't private,
        // add a setter.
        return !isReadOnlyOrInConstructor(property, settings) && !isPrivateAccess(property);
    }

    // A property has private access when it is to be flattened.
    // Only applies to mgmt, no effect on vanilla or DPG.
    private static boolean isPrivateAccess(ClientModelPropertyAccess property) {
        boolean privateAccess = false;
        // ClientModelPropertyReference never refers to a private access property, so only check ClientModelProperty here.
        if (property instanceof ClientModelProperty) {
            privateAccess = ((ClientModelProperty) property).getClientFlatten();
        }
        return privateAccess;
    }

    private static boolean isReadOnlyOrInConstructor(ClientModelPropertyAccess property, JavaSettings settings) {
        return property.isReadOnly() || (settings.isRequiredFieldsAsConstructorArgs() && property.isRequired());
    }

    /**
     * Determines whether the {@link ClientModelProperty} should be included in the model's constructor.
     * <p>
     * {@link ClientModelProperty Properties} are included in the constructor if the following hold true
     * <ul>
     * <li>{@link ClientModelProperty#isRequired()} is true</li>
     * <li>{@link JavaSettings#isRequiredFieldsAsConstructorArgs()} is true</li>
     * <li>{@link ClientModelProperty#isReadOnly()} is false or {@link JavaSettings#isIncludeReadOnlyInConstructorArgs()} is true</li>
     * </ul>
     *
     * @param property The {@link ClientModelProperty}
     * @param settings The Autorest generation settings.
     * @return Whether the {@code property} should be included in the model's constructor.
     */
    public static boolean includePropertyInConstructor(ClientModelProperty property, JavaSettings settings) {
        return property.isRequired() && settings.isRequiredFieldsAsConstructorArgs()
            && (!property.isReadOnly() || settings.isIncludeReadOnlyInConstructorArgs());
    }

    /**
     * Checks whether wire type and client type mismatch on this client model property.
     *
     * @param clientModelProperty the client model property.
     * @param ignoreGenericType whether to ignore the mismatch, if both wire type and client type is generic type.
     *                          <p>For example, ignore the case of {@code List<OffsetDateTime>} vs {@code List<Long>}.
     * @return whether wire type and client type mismatch.
     */
    public static boolean isWireTypeMismatch(ClientModelProperty clientModelProperty, boolean ignoreGenericType) {
        if (clientModelProperty.getClientType() == clientModelProperty.getWireType()) {
            // same type
            return false;
        } else {
            // type mismatch
            if (ignoreGenericType
                    && clientModelProperty.getClientType() instanceof GenericType
                    && clientModelProperty.getWireType() instanceof GenericType) {
                // at present, ignore generic type, as type erasure causes conflict of 2 constructors
                return false;
            } else {
                return true;
            }
        }
    }

    /**
     * Checks where {@code CoreToCodegenBridgeUtils} should be generated.
     * <p>
     * At this time it is required if {@link JavaSettings#isStreamStyleSerialization()} is true and the model uses
     * either {@code ResponseError} or {@link Duration} as both types have special serialization requirements that
     * aren't exposed by azure-core.
     *
     * @param model the model
     * @param settings Java settings
     * @return Whether to generate the {@code CoreToCodegenBridgeUtils} utility class.
     */
    public static boolean generateCoreToCodegenBridgeUtils(ClientModel model, JavaSettings settings) {
        if (!settings.isStreamStyleSerialization()) {
            return false;
        }

        // If any of the properties are ResponseError generate the bridge utils.
        // Or if any of the properties are Duration or contain Duration as a generic generate the bridge utils.
        if (model.getProperties().stream().anyMatch(p -> p.getClientType() == ClassType.RESPONSE_ERROR
            || p.getClientType() == ClassType.DURATION || p.getClientType().contains(ClassType.DURATION))) {
            return true;
        }

        // flatten properties
        if (settings.getClientFlattenAnnotationTarget() == JavaSettings.ClientFlattenAnnotationTarget.NONE) {
            return model.getPropertyReferences().stream()
                .filter(ClientModelPropertyReference::isFromFlattenedProperty)
                .anyMatch(p -> p.getClientType() == ClassType.RESPONSE_ERROR || p.getClientType() == ClassType.DURATION);
        }

        return false;
    }

    /**
     * Gets a mapping of XML namespace to constant name for XML namespaces used in the model.
     *
     * @param model The model to get the XML namespaces from.
     * @return A mapping of XML namespace to constant name.
     */
    public static Map<String, String> xmlNamespaceToConstantMapping(ClientModel model) {
        Map<String, String> xmlNamespaceConstantMap = new LinkedHashMap<>();
        ClientModel rootModel = getRootParent(model);
        if (rootModel.getXmlNamespace() != null) {
            xmlNamespaceConstantMap.put(rootModel.getXmlNamespace(), xmlNamespaceToConstant(rootModel.getXmlNamespace()));
        }

        for (ClientModelProperty property : ClientModelUtil.getParentProperties(model)) {
            if (property.getXmlNamespace() != null) {
                xmlNamespaceConstantMap.put(property.getXmlNamespace(),
                    xmlNamespaceToConstant(property.getXmlNamespace()));
            }
        }

        for (ClientModelProperty property : model.getProperties()) {
            if (property.getXmlNamespace() != null) {
                xmlNamespaceConstantMap.put(property.getXmlNamespace(),
                    xmlNamespaceToConstant(property.getXmlNamespace()));
            }
        }

        return xmlNamespaceConstantMap;
    }

    private static String xmlNamespaceToConstant(String xmlNamespace) {
        URI uri = URI.create(xmlNamespace);
        String host = CodeNamer.getEnumMemberName(uri.getHost());
        String path = uri.getPath();
        String[] segments = path.split("/");

        // XML namespaces are URIs, use the host and the last two segments of the path as the constant.
        if (segments.length >= 2) {
            // More than two path segments, use HOST_SEGMENT[COUNT - 2]_SEGMENT[COUNT - 1]
            return host + "_" + CodeNamer.getEnumMemberName(segments[segments.length - 2]) + "_"
                + CodeNamer.getEnumMemberName(segments[segments.length - 1]);
        } else if (segments.length == 1) {
            // Only one path segment, use HOST_SEGMENT[0]
            return host + "_" + CodeNamer.getEnumMemberName(segments[0]);
        } else {
            // No path segments, just use HOST
            return host;
        }
    }

    /**
     * Gets the root parent of the given model.
     * <p>
     * If the model isn't polymorphic or is the root parent the passed model will be returned.
     *
     * @param model The model to get the root parent of.
     * @return The root parent of the given model, or the model itself if it's either not polymorphic or the root
     * parent.
     */
    public static ClientModel getRootParent(ClientModel model) {
        if (!model.isPolymorphic()) {
            return model;
        }

        while (model.getParentModelName() != null) {
            model = getClientModel(model.getParentModelName());
        }

        return model;
    }

    public static Set<String> getExternalPackageNamesUsedInClient(List<ClientModel> models, CodeModel codeModel) {
        // models
        Set<String> externalPackageNames = models == null ? new HashSet<>() : models.stream()
                .filter(m -> m.getImplementationDetails() != null && m.getImplementationDetails().getUsages() != null
                        && m.getImplementationDetails().getUsages().contains(ImplementationDetails.Usage.EXTERNAL))
                .map(ClientModel::getPackage)
                .collect(Collectors.toSet());

        // LongRunningMetadata in methods
        if (!CoreUtils.isNullOrEmpty(codeModel.getClients())) {
            for (Client client : codeModel.getClients()) {
                if (!CoreUtils.isNullOrEmpty(client.getOperationGroups())) {
                    for (OperationGroup og : client.getOperationGroups()) {
                        if (!CoreUtils.isNullOrEmpty(og.getOperations())) {
                            externalPackageNames.addAll(og.getOperations().stream()
                                    .filter(o -> o.getLroMetadata() != null && o.getLroMetadata().getPollingStrategy() != null && o.getLroMetadata().getPollingStrategy().getLanguage() != null && o.getLroMetadata().getPollingStrategy().getLanguage().getJava() != null)
                                    .map(o -> o.getLroMetadata().getPollingStrategy().getLanguage().getJava().getNamespace())
                                    .filter(Objects::nonNull)
                                    .collect(Collectors.toSet()));
                        }
                    }
                }
            }
        }

        return externalPackageNames;
    }

    /**
     * Gets or creates a new ##FileDetails model for a multipart/form-data request
     *
     * @param compositeType the object schema of the multipart/form-data request model.
     * @param filePropertyName the property name of the file in the multipart/form-data request model.
     * @return the ##FileDetails model
     */
    public static IType getMultipartFileDetailsModel(
            ObjectSchema compositeType,
            String filePropertyName) {
        String fileDetailsModelName = com.azure.autorest.preprocessor.namer.CodeNamer.getTypeName(
                filePropertyName.toLowerCase(Locale.ROOT).endsWith("file")
                        ? filePropertyName + "Details"
                        : filePropertyName + "FileDetails");
        ClientModel clientModel = ClientModelUtil.getClientModel(fileDetailsModelName);
        if (clientModel != null) {
            return clientModel.getType();
        }

        // create ClassType
        ObjectSchema objectSchema = new ObjectSchema();
        objectSchema.setLanguage(new Languages());
        objectSchema.getLanguage().setJava(new Language());
        objectSchema.getLanguage().getJava().setName(fileDetailsModelName);
        objectSchema.setUsage(compositeType.getUsage());
        ClassType type = Mappers.getObjectMapper().map(objectSchema);

        // create ClientModel
        List<ClientModelProperty> properties = new ArrayList<>();
        properties.add(new ClientModelProperty.Builder()
                .name("content")
                .description("The content of the file")
                .required(true)
                .readOnly(false)
                .wireType(ClassType.BINARY_DATA)
                .clientType(ClassType.BINARY_DATA)
                .build());
        properties.add(new ClientModelProperty.Builder()
                .name("filename")
                .description("The filename of the file")
                .required(false)
                .readOnly(false)
                .wireType(ClassType.STRING)
                .clientType(ClassType.STRING)
                .build());
        properties.add(new ClientModelProperty.Builder()
                .name("contentType")
                .description("The content-type of the file")
                .required(false)
                .readOnly(false)
                .wireType(ClassType.STRING)
                .clientType(ClassType.STRING)
                .defaultValue("\"application/octet-stream\"")
                .build());
        clientModel = new ClientModel.Builder()
                .name(fileDetailsModelName)
                .description("The file details model for the " + filePropertyName)
                .packageName(type.getPackage())
                .type(type)
                .serializationFormats(Set.of(KnownMediaType.MULTIPART.value()))
                // let it inherit the usage (PUBLIC/INTERNAL) from the multipart/form-data request model
                .implementationDetails(new ImplementationDetails.Builder()
                        .usages(SchemaUtil.mapSchemaContext(compositeType.getUsage()))
                        .build())
                .properties(properties)
                .build();
        ClientModels.getInstance().addModel(clientModel);
        return clientModel.getType();
    }

    public static boolean isMultipartModel(ClientModel model) {
        return model.getSerializationFormats().contains(KnownMediaType.MULTIPART.value());
    }
}
