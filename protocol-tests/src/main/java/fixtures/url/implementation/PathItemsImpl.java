// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package fixtures.url.implementation;

import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.Get;
import com.azure.core.annotation.HeaderParam;
import com.azure.core.annotation.Host;
import com.azure.core.annotation.HostParam;
import com.azure.core.annotation.PathParam;
import com.azure.core.annotation.QueryParam;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceInterface;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.annotation.UnexpectedResponseExceptionType;
import com.azure.core.exception.ClientAuthenticationException;
import com.azure.core.exception.HttpResponseException;
import com.azure.core.exception.ResourceModifiedException;
import com.azure.core.exception.ResourceNotFoundException;
import com.azure.core.http.rest.RequestOptions;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.RestProxy;
import com.azure.core.util.Context;
import com.azure.core.util.FluxUtil;
import reactor.core.publisher.Mono;

/**
 * An instance of this class provides access to all the operations defined in PathItems.
 */
public final class PathItemsImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final PathItemsService service;

    /**
     * The service client containing this operation class.
     */
    private final AutoRestUrlTestServiceClientImpl client;

    /**
     * Initializes an instance of PathItemsImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    PathItemsImpl(AutoRestUrlTestServiceClientImpl client) {
        this.service
            = RestProxy.create(PathItemsService.class, client.getHttpPipeline(), client.getSerializerAdapter());
        this.client = client;
    }

    /**
     * The interface defining all the services for AutoRestUrlTestServicePathItems to be used by the proxy service to
     * perform REST calls.
     */
    @Host("{$host}")
    @ServiceInterface(name = "AutoRestUrlTestServi")
    public interface PathItemsService {
        @Get("/pathitem/nullable/globalStringPath/{globalStringPath}/pathItemStringPath/{pathItemStringPath}/localStringPath/{localStringPath}/globalStringQuery/pathItemStringQuery/localStringQuery")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(value = ClientAuthenticationException.class, code = { 401 })
        @UnexpectedResponseExceptionType(value = ResourceNotFoundException.class, code = { 404 })
        @UnexpectedResponseExceptionType(value = ResourceModifiedException.class, code = { 409 })
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Mono<Response<Void>> getAllWithValues(@HostParam("$host") String host,
            @PathParam("pathItemStringPath") String pathItemStringPath,
            @PathParam("globalStringPath") String globalStringPath,
            @QueryParam("globalStringQuery") String globalStringQuery,
            @PathParam("localStringPath") String localStringPath, @HeaderParam("Accept") String accept,
            RequestOptions requestOptions, Context context);

        @Get("/pathitem/nullable/globalStringPath/{globalStringPath}/pathItemStringPath/{pathItemStringPath}/localStringPath/{localStringPath}/globalStringQuery/pathItemStringQuery/localStringQuery")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(value = ClientAuthenticationException.class, code = { 401 })
        @UnexpectedResponseExceptionType(value = ResourceNotFoundException.class, code = { 404 })
        @UnexpectedResponseExceptionType(value = ResourceModifiedException.class, code = { 409 })
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Response<Void> getAllWithValuesSync(@HostParam("$host") String host,
            @PathParam("pathItemStringPath") String pathItemStringPath,
            @PathParam("globalStringPath") String globalStringPath,
            @QueryParam("globalStringQuery") String globalStringQuery,
            @PathParam("localStringPath") String localStringPath, @HeaderParam("Accept") String accept,
            RequestOptions requestOptions, Context context);

        @Get("/pathitem/nullable/globalStringPath/{globalStringPath}/pathItemStringPath/{pathItemStringPath}/localStringPath/{localStringPath}/null/pathItemStringQuery/localStringQuery")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(value = ClientAuthenticationException.class, code = { 401 })
        @UnexpectedResponseExceptionType(value = ResourceNotFoundException.class, code = { 404 })
        @UnexpectedResponseExceptionType(value = ResourceModifiedException.class, code = { 409 })
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Mono<Response<Void>> getGlobalQueryNull(@HostParam("$host") String host,
            @PathParam("pathItemStringPath") String pathItemStringPath,
            @PathParam("globalStringPath") String globalStringPath,
            @QueryParam("globalStringQuery") String globalStringQuery,
            @PathParam("localStringPath") String localStringPath, @HeaderParam("Accept") String accept,
            RequestOptions requestOptions, Context context);

        @Get("/pathitem/nullable/globalStringPath/{globalStringPath}/pathItemStringPath/{pathItemStringPath}/localStringPath/{localStringPath}/null/pathItemStringQuery/localStringQuery")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(value = ClientAuthenticationException.class, code = { 401 })
        @UnexpectedResponseExceptionType(value = ResourceNotFoundException.class, code = { 404 })
        @UnexpectedResponseExceptionType(value = ResourceModifiedException.class, code = { 409 })
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Response<Void> getGlobalQueryNullSync(@HostParam("$host") String host,
            @PathParam("pathItemStringPath") String pathItemStringPath,
            @PathParam("globalStringPath") String globalStringPath,
            @QueryParam("globalStringQuery") String globalStringQuery,
            @PathParam("localStringPath") String localStringPath, @HeaderParam("Accept") String accept,
            RequestOptions requestOptions, Context context);

        @Get("/pathitem/nullable/globalStringPath/{globalStringPath}/pathItemStringPath/{pathItemStringPath}/localStringPath/{localStringPath}/null/pathItemStringQuery/null")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(value = ClientAuthenticationException.class, code = { 401 })
        @UnexpectedResponseExceptionType(value = ResourceNotFoundException.class, code = { 404 })
        @UnexpectedResponseExceptionType(value = ResourceModifiedException.class, code = { 409 })
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Mono<Response<Void>> getGlobalAndLocalQueryNull(@HostParam("$host") String host,
            @PathParam("pathItemStringPath") String pathItemStringPath,
            @PathParam("globalStringPath") String globalStringPath,
            @QueryParam("globalStringQuery") String globalStringQuery,
            @PathParam("localStringPath") String localStringPath, @HeaderParam("Accept") String accept,
            RequestOptions requestOptions, Context context);

        @Get("/pathitem/nullable/globalStringPath/{globalStringPath}/pathItemStringPath/{pathItemStringPath}/localStringPath/{localStringPath}/null/pathItemStringQuery/null")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(value = ClientAuthenticationException.class, code = { 401 })
        @UnexpectedResponseExceptionType(value = ResourceNotFoundException.class, code = { 404 })
        @UnexpectedResponseExceptionType(value = ResourceModifiedException.class, code = { 409 })
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Response<Void> getGlobalAndLocalQueryNullSync(@HostParam("$host") String host,
            @PathParam("pathItemStringPath") String pathItemStringPath,
            @PathParam("globalStringPath") String globalStringPath,
            @QueryParam("globalStringQuery") String globalStringQuery,
            @PathParam("localStringPath") String localStringPath, @HeaderParam("Accept") String accept,
            RequestOptions requestOptions, Context context);

        @Get("/pathitem/nullable/globalStringPath/{globalStringPath}/pathItemStringPath/{pathItemStringPath}/localStringPath/{localStringPath}/globalStringQuery/null/null")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(value = ClientAuthenticationException.class, code = { 401 })
        @UnexpectedResponseExceptionType(value = ResourceNotFoundException.class, code = { 404 })
        @UnexpectedResponseExceptionType(value = ResourceModifiedException.class, code = { 409 })
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Mono<Response<Void>> getLocalPathItemQueryNull(@HostParam("$host") String host,
            @PathParam("pathItemStringPath") String pathItemStringPath,
            @PathParam("globalStringPath") String globalStringPath,
            @QueryParam("globalStringQuery") String globalStringQuery,
            @PathParam("localStringPath") String localStringPath, @HeaderParam("Accept") String accept,
            RequestOptions requestOptions, Context context);

        @Get("/pathitem/nullable/globalStringPath/{globalStringPath}/pathItemStringPath/{pathItemStringPath}/localStringPath/{localStringPath}/globalStringQuery/null/null")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(value = ClientAuthenticationException.class, code = { 401 })
        @UnexpectedResponseExceptionType(value = ResourceNotFoundException.class, code = { 404 })
        @UnexpectedResponseExceptionType(value = ResourceModifiedException.class, code = { 409 })
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Response<Void> getLocalPathItemQueryNullSync(@HostParam("$host") String host,
            @PathParam("pathItemStringPath") String pathItemStringPath,
            @PathParam("globalStringPath") String globalStringPath,
            @QueryParam("globalStringQuery") String globalStringQuery,
            @PathParam("localStringPath") String localStringPath, @HeaderParam("Accept") String accept,
            RequestOptions requestOptions, Context context);
    }

    /**
     * send globalStringPath='globalStringPath', pathItemStringPath='pathItemStringPath',
     * localStringPath='localStringPath', globalStringQuery='globalStringQuery',
     * pathItemStringQuery='pathItemStringQuery', localStringQuery='localStringQuery'.
     * <p>
     * <strong>Query Parameters</strong>
     * </p>
     * <table border="1">
     * <caption>Query Parameters</caption>
     * <tr>
     * <th>Name</th>
     * <th>Type</th>
     * <th>Required</th>
     * <th>Description</th>
     * </tr>
     * <tr>
     * <td>pathItemStringQuery</td>
     * <td>String</td>
     * <td>No</td>
     * <td>A string value 'pathItemStringQuery' that appears as a query parameter</td>
     * </tr>
     * <tr>
     * <td>localStringQuery</td>
     * <td>String</td>
     * <td>No</td>
     * <td>should contain value 'localStringQuery'</td>
     * </tr>
     * </table>
     * You can add these to a request with {@link RequestOptions#addQueryParam}
     * 
     * @param pathItemStringPath A string value 'pathItemStringPath' that appears in the path.
     * @param localStringPath should contain value 'localStringPath'.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> getAllWithValuesWithResponseAsync(String pathItemStringPath, String localStringPath,
        RequestOptions requestOptions) {
        final String accept = "application/json";
        return FluxUtil.withContext(context -> service.getAllWithValues(this.client.getHost(), pathItemStringPath,
            this.client.getGlobalStringPath(), this.client.getGlobalStringQuery(), localStringPath, accept,
            requestOptions, context));
    }

    /**
     * send globalStringPath='globalStringPath', pathItemStringPath='pathItemStringPath',
     * localStringPath='localStringPath', globalStringQuery='globalStringQuery',
     * pathItemStringQuery='pathItemStringQuery', localStringQuery='localStringQuery'.
     * <p>
     * <strong>Query Parameters</strong>
     * </p>
     * <table border="1">
     * <caption>Query Parameters</caption>
     * <tr>
     * <th>Name</th>
     * <th>Type</th>
     * <th>Required</th>
     * <th>Description</th>
     * </tr>
     * <tr>
     * <td>pathItemStringQuery</td>
     * <td>String</td>
     * <td>No</td>
     * <td>A string value 'pathItemStringQuery' that appears as a query parameter</td>
     * </tr>
     * <tr>
     * <td>localStringQuery</td>
     * <td>String</td>
     * <td>No</td>
     * <td>should contain value 'localStringQuery'</td>
     * </tr>
     * </table>
     * You can add these to a request with {@link RequestOptions#addQueryParam}
     * 
     * @param pathItemStringPath A string value 'pathItemStringPath' that appears in the path.
     * @param localStringPath should contain value 'localStringPath'.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Void> getAllWithValuesWithResponse(String pathItemStringPath, String localStringPath,
        RequestOptions requestOptions) {
        final String accept = "application/json";
        return service.getAllWithValuesSync(this.client.getHost(), pathItemStringPath,
            this.client.getGlobalStringPath(), this.client.getGlobalStringQuery(), localStringPath, accept,
            requestOptions, Context.NONE);
    }

    /**
     * send globalStringPath='globalStringPath', pathItemStringPath='pathItemStringPath',
     * localStringPath='localStringPath', globalStringQuery=null, pathItemStringQuery='pathItemStringQuery',
     * localStringQuery='localStringQuery'.
     * <p>
     * <strong>Query Parameters</strong>
     * </p>
     * <table border="1">
     * <caption>Query Parameters</caption>
     * <tr>
     * <th>Name</th>
     * <th>Type</th>
     * <th>Required</th>
     * <th>Description</th>
     * </tr>
     * <tr>
     * <td>pathItemStringQuery</td>
     * <td>String</td>
     * <td>No</td>
     * <td>A string value 'pathItemStringQuery' that appears as a query parameter</td>
     * </tr>
     * <tr>
     * <td>localStringQuery</td>
     * <td>String</td>
     * <td>No</td>
     * <td>should contain value 'localStringQuery'</td>
     * </tr>
     * </table>
     * You can add these to a request with {@link RequestOptions#addQueryParam}
     * 
     * @param pathItemStringPath A string value 'pathItemStringPath' that appears in the path.
     * @param localStringPath should contain value 'localStringPath'.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> getGlobalQueryNullWithResponseAsync(String pathItemStringPath, String localStringPath,
        RequestOptions requestOptions) {
        final String accept = "application/json";
        return FluxUtil.withContext(context -> service.getGlobalQueryNull(this.client.getHost(), pathItemStringPath,
            this.client.getGlobalStringPath(), this.client.getGlobalStringQuery(), localStringPath, accept,
            requestOptions, context));
    }

    /**
     * send globalStringPath='globalStringPath', pathItemStringPath='pathItemStringPath',
     * localStringPath='localStringPath', globalStringQuery=null, pathItemStringQuery='pathItemStringQuery',
     * localStringQuery='localStringQuery'.
     * <p>
     * <strong>Query Parameters</strong>
     * </p>
     * <table border="1">
     * <caption>Query Parameters</caption>
     * <tr>
     * <th>Name</th>
     * <th>Type</th>
     * <th>Required</th>
     * <th>Description</th>
     * </tr>
     * <tr>
     * <td>pathItemStringQuery</td>
     * <td>String</td>
     * <td>No</td>
     * <td>A string value 'pathItemStringQuery' that appears as a query parameter</td>
     * </tr>
     * <tr>
     * <td>localStringQuery</td>
     * <td>String</td>
     * <td>No</td>
     * <td>should contain value 'localStringQuery'</td>
     * </tr>
     * </table>
     * You can add these to a request with {@link RequestOptions#addQueryParam}
     * 
     * @param pathItemStringPath A string value 'pathItemStringPath' that appears in the path.
     * @param localStringPath should contain value 'localStringPath'.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Void> getGlobalQueryNullWithResponse(String pathItemStringPath, String localStringPath,
        RequestOptions requestOptions) {
        final String accept = "application/json";
        return service.getGlobalQueryNullSync(this.client.getHost(), pathItemStringPath,
            this.client.getGlobalStringPath(), this.client.getGlobalStringQuery(), localStringPath, accept,
            requestOptions, Context.NONE);
    }

    /**
     * send globalStringPath=globalStringPath, pathItemStringPath='pathItemStringPath',
     * localStringPath='localStringPath', globalStringQuery=null, pathItemStringQuery='pathItemStringQuery',
     * localStringQuery=null.
     * <p>
     * <strong>Query Parameters</strong>
     * </p>
     * <table border="1">
     * <caption>Query Parameters</caption>
     * <tr>
     * <th>Name</th>
     * <th>Type</th>
     * <th>Required</th>
     * <th>Description</th>
     * </tr>
     * <tr>
     * <td>pathItemStringQuery</td>
     * <td>String</td>
     * <td>No</td>
     * <td>A string value 'pathItemStringQuery' that appears as a query parameter</td>
     * </tr>
     * <tr>
     * <td>localStringQuery</td>
     * <td>String</td>
     * <td>No</td>
     * <td>should contain null value</td>
     * </tr>
     * </table>
     * You can add these to a request with {@link RequestOptions#addQueryParam}
     * 
     * @param pathItemStringPath A string value 'pathItemStringPath' that appears in the path.
     * @param localStringPath should contain value 'localStringPath'.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> getGlobalAndLocalQueryNullWithResponseAsync(String pathItemStringPath,
        String localStringPath, RequestOptions requestOptions) {
        final String accept = "application/json";
        return FluxUtil.withContext(context -> service.getGlobalAndLocalQueryNull(this.client.getHost(),
            pathItemStringPath, this.client.getGlobalStringPath(), this.client.getGlobalStringQuery(), localStringPath,
            accept, requestOptions, context));
    }

    /**
     * send globalStringPath=globalStringPath, pathItemStringPath='pathItemStringPath',
     * localStringPath='localStringPath', globalStringQuery=null, pathItemStringQuery='pathItemStringQuery',
     * localStringQuery=null.
     * <p>
     * <strong>Query Parameters</strong>
     * </p>
     * <table border="1">
     * <caption>Query Parameters</caption>
     * <tr>
     * <th>Name</th>
     * <th>Type</th>
     * <th>Required</th>
     * <th>Description</th>
     * </tr>
     * <tr>
     * <td>pathItemStringQuery</td>
     * <td>String</td>
     * <td>No</td>
     * <td>A string value 'pathItemStringQuery' that appears as a query parameter</td>
     * </tr>
     * <tr>
     * <td>localStringQuery</td>
     * <td>String</td>
     * <td>No</td>
     * <td>should contain null value</td>
     * </tr>
     * </table>
     * You can add these to a request with {@link RequestOptions#addQueryParam}
     * 
     * @param pathItemStringPath A string value 'pathItemStringPath' that appears in the path.
     * @param localStringPath should contain value 'localStringPath'.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Void> getGlobalAndLocalQueryNullWithResponse(String pathItemStringPath, String localStringPath,
        RequestOptions requestOptions) {
        final String accept = "application/json";
        return service.getGlobalAndLocalQueryNullSync(this.client.getHost(), pathItemStringPath,
            this.client.getGlobalStringPath(), this.client.getGlobalStringQuery(), localStringPath, accept,
            requestOptions, Context.NONE);
    }

    /**
     * send globalStringPath='globalStringPath', pathItemStringPath='pathItemStringPath',
     * localStringPath='localStringPath', globalStringQuery='globalStringQuery', pathItemStringQuery=null,
     * localStringQuery=null.
     * <p>
     * <strong>Query Parameters</strong>
     * </p>
     * <table border="1">
     * <caption>Query Parameters</caption>
     * <tr>
     * <th>Name</th>
     * <th>Type</th>
     * <th>Required</th>
     * <th>Description</th>
     * </tr>
     * <tr>
     * <td>pathItemStringQuery</td>
     * <td>String</td>
     * <td>No</td>
     * <td>should contain value null</td>
     * </tr>
     * <tr>
     * <td>localStringQuery</td>
     * <td>String</td>
     * <td>No</td>
     * <td>should contain value null</td>
     * </tr>
     * </table>
     * You can add these to a request with {@link RequestOptions#addQueryParam}
     * 
     * @param pathItemStringPath A string value 'pathItemStringPath' that appears in the path.
     * @param localStringPath should contain value 'localStringPath'.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> getLocalPathItemQueryNullWithResponseAsync(String pathItemStringPath,
        String localStringPath, RequestOptions requestOptions) {
        final String accept = "application/json";
        return FluxUtil.withContext(context -> service.getLocalPathItemQueryNull(this.client.getHost(),
            pathItemStringPath, this.client.getGlobalStringPath(), this.client.getGlobalStringQuery(), localStringPath,
            accept, requestOptions, context));
    }

    /**
     * send globalStringPath='globalStringPath', pathItemStringPath='pathItemStringPath',
     * localStringPath='localStringPath', globalStringQuery='globalStringQuery', pathItemStringQuery=null,
     * localStringQuery=null.
     * <p>
     * <strong>Query Parameters</strong>
     * </p>
     * <table border="1">
     * <caption>Query Parameters</caption>
     * <tr>
     * <th>Name</th>
     * <th>Type</th>
     * <th>Required</th>
     * <th>Description</th>
     * </tr>
     * <tr>
     * <td>pathItemStringQuery</td>
     * <td>String</td>
     * <td>No</td>
     * <td>should contain value null</td>
     * </tr>
     * <tr>
     * <td>localStringQuery</td>
     * <td>String</td>
     * <td>No</td>
     * <td>should contain value null</td>
     * </tr>
     * </table>
     * You can add these to a request with {@link RequestOptions#addQueryParam}
     * 
     * @param pathItemStringPath A string value 'pathItemStringPath' that appears in the path.
     * @param localStringPath should contain value 'localStringPath'.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Void> getLocalPathItemQueryNullWithResponse(String pathItemStringPath, String localStringPath,
        RequestOptions requestOptions) {
        final String accept = "application/json";
        return service.getLocalPathItemQueryNullSync(this.client.getHost(), pathItemStringPath,
            this.client.getGlobalStringPath(), this.client.getGlobalStringQuery(), localStringPath, accept,
            requestOptions, Context.NONE);
    }
}
