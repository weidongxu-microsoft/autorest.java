// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License. See License.txt in the project root for license information.

package com.azure.autorest.extension.base.plugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;


/**
 Settings that are used by the Java AutoRest Generator.
 */
public class JavaSettings
{
    private static String version = "4.0.0";

    private static JavaSettings _instance;

    private static NewPlugin host;

    private static String _header;
    static void setHeader(String value) {
        if ("MICROSOFT_MIT".equals(value))
        {
            _header = MicrosoftMitLicenseHeader + "\n" + String.format(DefaultCodeGenerationHeader, version);
        }
        else if ("MICROSOFT_APACHE".equals(value))
        {
            _header = MicrosoftApacheLicenseHeader + "\n" + String.format(DefaultCodeGenerationHeader, version);
        }
        else if ("MICROSOFT_MIT_NO_VERSION".equals(value))
        {
            _header = MicrosoftMitLicenseHeader + "\n" + DefaultCodeGenerationHeaderWithoutVersion;
        }
        else if ("MICROSOFT_APACHE_NO_VERSION".equals(value))
        {
            _header = MicrosoftApacheLicenseHeader + "\n" + DefaultCodeGenerationHeaderWithoutVersion;
        }
        else if ("MICROSOFT_MIT_NO_CODEGEN".equals(value))
        {
            _header = MicrosoftMitLicenseHeader + "\n" + "Code generated by Microsoft (R) AutoRest Code Generator.";
        }
        else if ("NONE".equals(value))
        {
            _header = "";
        } else if ("MICROSOFT_MIT_SMALL".equals(value)) {
            _header = MicrosoftMitSmallLicenseHeader + "Code generated by Microsoft (R) AutoRest Code Generator.";
        } else if ("MICROSOFT_MIT_SMALL_NO_CODEGEN".equals(value)) {
            _header = MicrosoftMitSmallLicenseHeader;
        }
        else
        {
            _header = value;
        }
    }

    static void setHost(NewPlugin host) {
        JavaSettings.host = host;
    }

    public static JavaSettings getInstance()
    {
        if (_instance == null)
        {
            String syncMethodsDefault = "essential";
            boolean addContextParameterDefault = false;
            boolean contextClientMethodParameterDefault = false;
            boolean clientSideValidationsDefault = false;
            boolean clientLoggerDefault = false;
            boolean generateClientInterfacesDefault = false;
            boolean requiredParameterClientMethodsDefault = false;
            boolean modelOverrideSetterFromSuperclassDefault = false;

            String fluentSetting = host.getStringValue("fluent");
            if (fluentSetting != null) {
                syncMethodsDefault = "all";
                addContextParameterDefault = true;
                contextClientMethodParameterDefault = true;
                clientSideValidationsDefault = true;
                clientLoggerDefault = true;
                generateClientInterfacesDefault = true;
                requiredParameterClientMethodsDefault = true;
                modelOverrideSetterFromSuperclassDefault = true;
            }

            setHeader(host.getStringValue("license-header"));
            _instance = new JavaSettings(
                    host.getBooleanValue("azure-arm", false),
                    fluentSetting,
                    host.getBooleanValue("regenerate-pom", false),
                    _header,
                    80,
                    host.getStringValue("service-name"),
                    host.getStringValue("namespace", "").toLowerCase(),
                    host.getBooleanValue("enable-xml", false),
                    host.getBooleanValue("non-null-annotations", false),
                    host.getBooleanValue("client-side-validations", clientSideValidationsDefault),
                    host.getStringValue("client-type-prefix"),
                    host.getBooleanValue("generate-client-interfaces", generateClientInterfacesDefault),
                    host.getBooleanValue("generate-client-as-impl", false),
                    host.getStringValue("implementation-subpackage", "implementation"),
                    host.getStringValue("models-subpackage", "models"),
                    host.getStringValue("custom-types", ""),
                    host.getStringValue("custom-types-subpackage", ""),
                    host.getStringValue("fluent-subpackage", "fluent"),
                    host.getBooleanValue("required-parameter-client-methods", requiredParameterClientMethodsDefault),
                    host.getBooleanValue("add-context-parameter", addContextParameterDefault),
                    host.getBooleanValue("context-client-method-parameter", contextClientMethodParameterDefault),
                    host.getBooleanValue("generate-sync-async-clients", false),
                    host.getStringValue("sync-methods", syncMethodsDefault),
                    host.getBooleanValue("client-logger", clientLoggerDefault),
                    host.getBooleanValue("required-fields-as-ctor-args", false),
                    host.getBooleanValue("service-interface-as-public", false),
                    host.getStringValue("artifact-id", ""),
                    host.getStringValue("credential-types", "none"),
                    host.getStringValue("credential-scopes"),
                    host.getStringValue("customization-jar-path"),
                    host.getStringValue("customization-class"),
                    host.getBooleanValue("model-override-setter-from-superclass", modelOverrideSetterFromSuperclassDefault));
        }
        return _instance;
    }

    /**
     Create a new JavaSettings object with the provided properties.

     @param azure
     @param fluent
     @param regeneratePom
     @param fileHeaderText
     @param maximumJavadocCommentWidth
     @param serviceName
     @param shouldGenerateXmlSerialization
     @param nonNullAnnotations Whether or not to add the @NotNull annotation to required parameters in client methods.
     @param clientTypePrefix The prefix that will be added to each generated client type.
     @param generateClientInterfaces Whether or not interfaces will be generated for Service and Method Group clients.
     @param implementationSubpackage The sub-package that the Service and Method Group client implementation classes will be put into.
     @param modelsSubpackage The sub-package that Enums, Exceptions, and Model types will be put into.
     @param requiredParameterClientMethods Whether or not Service and Method Group client method overloads that omit optional parameters will be created.
     @param serviceInterfaceAsPublic If set to true, proxy method service interface will be marked as public.
     */
    private JavaSettings(boolean azure,
                         String fluent,
                         boolean regeneratePom,
                         String fileHeaderText,
                         int maximumJavadocCommentWidth,
                         String serviceName,
                         String package_Keyword,
                         boolean shouldGenerateXmlSerialization,
                         boolean nonNullAnnotations,
                         boolean clientSideValidations,
                         String clientTypePrefix,
                         boolean generateClientInterfaces,
                         boolean generateClientAsImpl,
                         String implementationSubpackage,
                         String modelsSubpackage,
                         String customTypes,
                         String customTypesSubpackage,
                         String fluentSubpackage,
                         boolean requiredParameterClientMethods,
                         boolean addContextParameter,
                         boolean contextClientMethodParameter,
                         boolean generateSyncAsyncClients,
                         String syncMethods,
                         boolean clientLogger,
                         boolean requiredFieldsAsConstructorArgs,
                         boolean serviceInterfaceAsPublic,
                         String artifactId,
                         String credentialType,
                         String credentialScopes,
                         String customizationJarPath,
                         String customizationClass,
                         boolean overrideSetterFromSuperclass)
    {
        this.azure = azure;
        this.fluent = fluent == null ? Fluent.NONE : (fluent.isEmpty() || fluent.equalsIgnoreCase("true") ? Fluent.PREMIUM : Fluent.valueOf(fluent.toUpperCase(Locale.ROOT)));
        this.regeneratePom = regeneratePom;
        this.fileHeaderText = fileHeaderText;
        this.maximumJavadocCommentWidth = maximumJavadocCommentWidth;
        this.serviceName = serviceName;
        this.packageName = package_Keyword;
        this.shouldGenerateXmlSerialization = shouldGenerateXmlSerialization;
        this.nonNullAnnotations = nonNullAnnotations;
        this.clientSideValidations = clientSideValidations;
        this.clientTypePrefix = clientTypePrefix;
        this.generateClientInterfaces = generateClientInterfaces;
        this.generateClientAsImpl = generateClientAsImpl || generateSyncAsyncClients || generateClientInterfaces;
        this.implementationSubpackage = implementationSubpackage;
        this.modelsSubpackage = modelsSubpackage;
        this.customTypes = (customTypes == null || customTypes.isEmpty()) ? new ArrayList<>() : Arrays.asList(customTypes.split(","));
        this.customTypesSubpackage = customTypesSubpackage;
        this.fluentSubpackage = fluentSubpackage;
        this.requiredParameterClientMethods = requiredParameterClientMethods;
        this.addContextParameter = addContextParameter || contextClientMethodParameter;
        this.contextClientMethodParameter = contextClientMethodParameter;
        this.generateSyncAsyncClients = generateSyncAsyncClients;
        this.syncMethods =  SyncMethodsGeneration.fromValue(syncMethods);
        this.clientLogger = clientLogger;
        this.requiredFieldsAsConstructorArgs = requiredFieldsAsConstructorArgs;
        this.serviceInterfaceAsPublic = serviceInterfaceAsPublic;
        this.artifactId = artifactId;
        this.overrideSetterFromParent = overrideSetterFromSuperclass;

        if (credentialType != null) {
            String[] splits = credentialType.split(",");
            this.credentialTypes = Arrays.stream(splits)
                    .map(split -> split.trim())
                    .map(type -> CredentialType.fromValue(credentialType))
                    .collect(Collectors.toSet());
        }
        if (credentialScopes != null) {
            String[] splits = credentialScopes.split(",");
            this.credentialScopes = Arrays.stream(splits)
                    .map(split -> split.trim())
                    .map(split -> {
                        if (!split.startsWith("\"")) {
                            split = String.format("\"%s\"", split);
                        }
                        return split;
                    })
                    .collect(Collectors.toSet());
        }
        this.customizationJarPath = customizationJarPath;
        this.customizationClass = customizationClass;
    }

    private Set<CredentialType> credentialTypes;
    public Set<CredentialType> getCredentialTypes() {
        return credentialTypes;
    }

    private Set<String> credentialScopes;
    public Set<String> getCredentialScopes() {
        return credentialScopes;
    }

    private boolean azure;
    public final boolean isAzure()
    {
        return azure;
    }

    private String artifactId;

    public String getArtifactId() {
        return artifactId;
    }

    public enum Fluent {
        NONE, LITE, PREMIUM
    }
    private Fluent fluent;
    public final boolean isFluent()
    {
        return fluent != Fluent.NONE;
    }
    public final boolean isFluentLite()
    {
        return fluent == Fluent.LITE;
    }
    public final boolean isFluentPremium()
    {
        return fluent == Fluent.PREMIUM;
    }
    public final boolean isAzureOrFluent()
    {
        return isAzure() || isFluent();
    }

    private boolean regeneratePom;
    public final boolean shouldRegeneratePom()
    {
        return regeneratePom;
    }

    private String fileHeaderText;
    public final String getFileHeaderText()
    {
        return fileHeaderText;
    }

    private int maximumJavadocCommentWidth;
    public final int getMaximumJavadocCommentWidth()
    {
        return maximumJavadocCommentWidth;
    }

    private String serviceName;
    public final String getServiceName()
    {
        return serviceName;
    }

    private String packageName;
    public final String getPackage()
    {
        return packageName;
    }
    public final String getPackage(String... packageSuffixes) {
        StringBuilder packageBuilder = new StringBuilder(packageName);
        if (packageSuffixes != null) {
            for (String packageSuffix : packageSuffixes) {
                if (packageSuffix != null && !packageSuffix.isEmpty()) {
                    packageBuilder.append(".").append(packageSuffix
                            .replaceAll("\\.$", "")
                            .replaceAll("^\\.", ""));
                }
            }
        }
        return packageBuilder.toString();
    }

    private boolean shouldGenerateXmlSerialization;
    public final boolean shouldGenerateXmlSerialization()
    {
        return shouldGenerateXmlSerialization;
    }

    /**
     Whether or not to add the @NotNull annotation to required parameters in client methods.
     */
    private boolean nonNullAnnotations;
    public final boolean shouldNonNullAnnotations()
    {
        return nonNullAnnotations;
    }

    private boolean clientSideValidations;
    public final boolean shouldClientSideValidations()
    {
        return clientSideValidations;
    }

    /**
     The prefix that will be added to each generated client type.
     */
    private String clientTypePrefix;
    public final String getClientTypePrefix()
    {
        return clientTypePrefix;
    }

    /**
     Whether or not interfaces will be generated for Service and Method Group clients.
     */
    private boolean generateClientInterfaces;
    public final boolean shouldGenerateClientInterfaces()
    {
        return generateClientInterfaces;
    }

    /**
     Whether or not interfaces will be generated for Service and Method Group clients.
     */
    private boolean generateClientAsImpl;
    public final boolean shouldGenerateClientAsImpl()
    {
        return generateClientAsImpl;
    }

    /**
     The sub-package that the Service and Method Group client implementation classes will be put into.
     */
    private String implementationSubpackage;
    public final String getImplementationSubpackage()
    {
        return implementationSubpackage;
    }

    /**
     The sub-package that Enums, Exceptions, and Model types will be put into.
     */
    private String modelsSubpackage;
    public final String getModelsSubpackage()
    {
        return modelsSubpackage;
    }

    private String fluentSubpackage;
    /**
     * @return The sub-package specific to Fluent SDK.
     */
    public final String getFluentSubpackage() {
        return fluentSubpackage;
    }

    /**
     Whether or not Service and Method Group client method overloads that omit optional parameters will be created.
     */
    private boolean requiredParameterClientMethods;
    public final boolean getRequiredParameterClientMethods()
    {
        return requiredParameterClientMethods;
    }

    /**
     Indicates whether the leading com.microsoft.rest.v3.Context parameter should be included in generated methods.
     */
    private boolean addContextParameter;
    public final boolean getAddContextParameter() {
        return addContextParameter;
    }

    private boolean contextClientMethodParameter;
    public final boolean isContextClientMethodParameter() {
        return contextClientMethodParameter;
    }

    private boolean generateSyncAsyncClients;
    public final boolean shouldGenerateSyncAsyncClients() {
        return generateSyncAsyncClients;
    }

    private SyncMethodsGeneration syncMethods = SyncMethodsGeneration.NONE; // no sync methods are generated by default
    public final SyncMethodsGeneration getSyncMethods() {
        return syncMethods;
    }

    private boolean requiredFieldsAsConstructorArgs;
    public boolean isRequiredFieldsAsConstructorArgs() {
        return requiredFieldsAsConstructorArgs;
    }

    private boolean serviceInterfaceAsPublic;
    public boolean isServiceInterfaceAsPublic() {
        return serviceInterfaceAsPublic;
    }
    public enum SyncMethodsGeneration {
        ALL,
        ESSENTIAL,
        NONE;

        public static SyncMethodsGeneration fromValue(String value) {
            if (value == null) {
                return null;
            } else if (value.equals("all")) {
                return ALL;
            } else if (value.equals("essential")) {
                return ESSENTIAL;
            } else if (value.equals("none")) {
                return NONE;
            }
            return null;
        }
    }

    private List<String> customTypes;

    public List<String> getCustomTypes() {
        return customTypes;
    }

    public boolean isCustomType(String typeName) {
        return customTypes.contains(typeName);
    }

    private String customTypesSubpackage;
    public final String getCustomTypesSubpackage()
    {
        return customTypesSubpackage;
    }

    public enum CredentialType {
        TOKEN_CREDENTIAL,
        AZURE_KEY_CREDENTIAL,
        NONE;

        public static CredentialType fromValue(String value) {
            if (value == null) {
                return null;
            } else if (value.equals("tokencredential")) {
                return TOKEN_CREDENTIAL;
            } else if (value.equals("azurekeycredential")) {
                return AZURE_KEY_CREDENTIAL;
            } else if (value.equals("none")) {
                return NONE;
            }
            return NONE;
        }
    }

    private boolean clientLogger;
    public final boolean shouldClientLogger() {
        return clientLogger;
    }

    private String customizationJarPath;
    public final String getCustomizationJarPath() {
        return customizationJarPath;
    }

    private String customizationClass;
    public final String getCustomizationClass() {
        return customizationClass;
    }

    boolean overrideSetterFromParent;

    /**
     * @return whether to override superclass setter method in model.
     */
    public boolean isOverrideSetterFromSuperclass() {
        return overrideSetterFromParent;
    }

    public static final String DefaultCodeGenerationHeader = "Code generated by Microsoft (R) AutoRest Code Generator %s" + "\r\n" +
            "Changes may cause incorrect behavior and will be lost if the code is regenerated.";

    public static final String DefaultCodeGenerationHeaderWithoutVersion = "Code generated by Microsoft (R) AutoRest Code Generator." + "\r\n" +
            "Changes may cause incorrect behavior and will be lost if the code is regenerated.";

    public static final String MicrosoftApacheLicenseHeader = "Copyright (c) Microsoft and contributors.  All rights reserved." + "\r\n" +
            "\r\n" +
            "Licensed under the Apache License, Version 2.0 (the \"License\");" + "\r\n" +
            "you may not use this file except in compliance with the License." + "\r\n" +
            "You may obtain a copy of the License at" + "\r\n" +
            "  http://www.apache.org/licenses/LICENSE-2.0" + "\r\n" +
            "\r\n" +
            "Unless required by applicable law or agreed to in writing, software" + "\r\n" +
            "distributed under the License is distributed on an \"AS IS\" BASIS," + "\r\n" +
            "WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied." + "\r\n" +
            "\r\n" +
            "See the License for the specific language governing permissions and" + "\r\n" +
            "limitations under the License." + "\r\n" +
            "";

    public static final String MicrosoftMitLicenseHeader = "Copyright (c) Microsoft Corporation. All rights reserved." + "\r\n" +
            "Licensed under the MIT License. See License.txt in the project root for license information." + "\r\n" +
            "";

    public static final String MicrosoftMitSmallLicenseHeader = "Copyright (c) Microsoft Corporation. All rights reserved." + "\r\n" +
            "Licensed under the MIT License." + "\r\n" +
            "";
}