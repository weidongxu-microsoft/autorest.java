// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package fixtures.specialheader;

import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.Get;
import com.azure.core.annotation.HeaderParam;
import com.azure.core.annotation.Host;
import com.azure.core.annotation.HostParam;
import com.azure.core.annotation.PathParam;
import com.azure.core.annotation.Post;
import com.azure.core.annotation.Put;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceInterface;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.annotation.UnexpectedResponseExceptionType;
import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.PagedResponse;
import com.azure.core.http.rest.PagedResponseBase;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.RestProxy;
import com.azure.core.util.Context;
import com.azure.core.util.DateTimeRfc1123;
import com.azure.core.util.FluxUtil;
import fixtures.specialheader.models.ErrorException;
import fixtures.specialheader.models.ProductResultValue;
import java.time.OffsetDateTime;
import java.util.UUID;
import reactor.core.publisher.Mono;

/**
 * An instance of this class provides access to all the operations defined in Headers.
 */
public final class Headers {
    /**
     * The proxy service used to perform REST calls.
     */
    private final HeadersService service;

    /**
     * The service client containing this operation class.
     */
    private final SpecialHeader client;

    /**
     * Initializes an instance of Headers.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    Headers(SpecialHeader client) {
        this.service = RestProxy.create(HeadersService.class, client.getHttpPipeline(), client.getSerializerAdapter());
        this.client = client;
    }

    /**
     * The interface defining all the services for SpecialHeaderHeaders to be used by the proxy service to perform REST
     * calls.
     */
    @Host("{$host}")
    @ServiceInterface(name = "SpecialHeaderHeaders")
    public interface HeadersService {
        @Post("/status/500")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(ErrorException.class)
        Mono<Response<Object>> paramRepeatabilityRequest(@HostParam("$host") String host,
            @HeaderParam("Accept") String accept,
            @HeaderParam("repeatability-request-id") String repeatabilityRequestId,
            @HeaderParam("repeatability-first-sent") String repeatabilityFirstSent, Context context);

        @Put("/status/500")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(ErrorException.class)
        Mono<Response<Object>> paramRepeatabilityRequestPut(@HostParam("$host") String host,
            @HeaderParam("Accept") String accept,
            @HeaderParam("repeatability-request-id") String repeatabilityRequestId,
            @HeaderParam("repeatability-first-sent") String repeatabilityFirstSent, Context context);

        @Get("/status/500")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(ErrorException.class)
        Mono<Response<Object>> paramRepeatabilityRequestGet(@HostParam("$host") String host,
            @HeaderParam("Accept") String accept, Context context);

        @Post("/specialHeader/repeatabilityRequestLRO")
        @ExpectedResponses({ 200, 202 })
        @UnexpectedResponseExceptionType(ErrorException.class)
        Mono<Response<Object>> paramRepeatabilityRequestLRO(@HostParam("$host") String host,
            @HeaderParam("Accept") String accept,
            @HeaderParam("repeatability-request-id") String repeatabilityRequestId,
            @HeaderParam("repeatability-first-sent") String repeatabilityFirstSent, Context context);

        @Post("/specialHeader/repeatabilityRequestPageable")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(ErrorException.class)
        Mono<Response<ProductResultValue>> paramRepeatabilityRequestPageable(@HostParam("$host") String host,
            @HeaderParam("Accept") String accept,
            @HeaderParam("repeatability-request-id") String repeatabilityRequestId,
            @HeaderParam("repeatability-first-sent") String repeatabilityFirstSent, Context context);

        @Get("{nextLink}")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(ErrorException.class)
        Mono<Response<ProductResultValue>> paramRepeatabilityRequestPageableNext(
            @PathParam(value = "nextLink", encoded = true) String nextLink, @HostParam("$host") String host,
            @HeaderParam("Accept") String accept, Context context);
    }

    /**
     * Send a post request with header Repeatability-Request-ID and Repeatability-First-Sent.
     * 
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return any object along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Object>> paramRepeatabilityRequestWithResponseAsync() {
        if (this.client.getHost() == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter this.client.getHost() is required and cannot be null."));
        }
        final String accept = "application/json";
        String repeatabilityRequestId = UUID.randomUUID().toString();
        String repeatabilityFirstSent = DateTimeRfc1123.toRfc1123String(OffsetDateTime.now());
        return FluxUtil.withContext(context -> service.paramRepeatabilityRequest(this.client.getHost(), accept,
            repeatabilityRequestId, repeatabilityFirstSent, context));
    }

    /**
     * Send a post request with header Repeatability-Request-ID and Repeatability-First-Sent.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return any object along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Object>> paramRepeatabilityRequestWithResponseAsync(Context context) {
        if (this.client.getHost() == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter this.client.getHost() is required and cannot be null."));
        }
        final String accept = "application/json";
        String repeatabilityRequestId = UUID.randomUUID().toString();
        String repeatabilityFirstSent = DateTimeRfc1123.toRfc1123String(OffsetDateTime.now());
        return service.paramRepeatabilityRequest(this.client.getHost(), accept, repeatabilityRequestId,
            repeatabilityFirstSent, context);
    }

    /**
     * Send a post request with header Repeatability-Request-ID and Repeatability-First-Sent.
     * 
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return any object on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Object> paramRepeatabilityRequestAsync() {
        return paramRepeatabilityRequestWithResponseAsync().flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Send a post request with header Repeatability-Request-ID and Repeatability-First-Sent.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return any object on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Object> paramRepeatabilityRequestAsync(Context context) {
        return paramRepeatabilityRequestWithResponseAsync(context).flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Send a post request with header Repeatability-Request-ID and Repeatability-First-Sent.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return any object along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Object> paramRepeatabilityRequestWithResponse(Context context) {
        return paramRepeatabilityRequestWithResponseAsync(context).block();
    }

    /**
     * Send a post request with header Repeatability-Request-ID and Repeatability-First-Sent.
     * 
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return any object.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Object paramRepeatabilityRequest() {
        return paramRepeatabilityRequestWithResponse(Context.NONE).getValue();
    }

    /**
     * Send a put request with header Repeatability-Request-ID and Repeatability-First-Sent.
     * 
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return any object along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Object>> paramRepeatabilityRequestPutWithResponseAsync() {
        if (this.client.getHost() == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter this.client.getHost() is required and cannot be null."));
        }
        final String accept = "application/json";
        String repeatabilityRequestId = UUID.randomUUID().toString();
        String repeatabilityFirstSent = DateTimeRfc1123.toRfc1123String(OffsetDateTime.now());
        return FluxUtil.withContext(context -> service.paramRepeatabilityRequestPut(this.client.getHost(), accept,
            repeatabilityRequestId, repeatabilityFirstSent, context));
    }

    /**
     * Send a put request with header Repeatability-Request-ID and Repeatability-First-Sent.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return any object along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Object>> paramRepeatabilityRequestPutWithResponseAsync(Context context) {
        if (this.client.getHost() == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter this.client.getHost() is required and cannot be null."));
        }
        final String accept = "application/json";
        String repeatabilityRequestId = UUID.randomUUID().toString();
        String repeatabilityFirstSent = DateTimeRfc1123.toRfc1123String(OffsetDateTime.now());
        return service.paramRepeatabilityRequestPut(this.client.getHost(), accept, repeatabilityRequestId,
            repeatabilityFirstSent, context);
    }

    /**
     * Send a put request with header Repeatability-Request-ID and Repeatability-First-Sent.
     * 
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return any object on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Object> paramRepeatabilityRequestPutAsync() {
        return paramRepeatabilityRequestPutWithResponseAsync().flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Send a put request with header Repeatability-Request-ID and Repeatability-First-Sent.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return any object on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Object> paramRepeatabilityRequestPutAsync(Context context) {
        return paramRepeatabilityRequestPutWithResponseAsync(context).flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Send a put request with header Repeatability-Request-ID and Repeatability-First-Sent.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return any object along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Object> paramRepeatabilityRequestPutWithResponse(Context context) {
        return paramRepeatabilityRequestPutWithResponseAsync(context).block();
    }

    /**
     * Send a put request with header Repeatability-Request-ID and Repeatability-First-Sent.
     * 
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return any object.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Object paramRepeatabilityRequestPut() {
        return paramRepeatabilityRequestPutWithResponse(Context.NONE).getValue();
    }

    /**
     * Send a get request without header Repeatability-Request-ID and Repeatability-First-Sent.
     * 
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return any object along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Object>> paramRepeatabilityRequestGetWithResponseAsync() {
        if (this.client.getHost() == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter this.client.getHost() is required and cannot be null."));
        }
        final String accept = "application/json";
        return FluxUtil
            .withContext(context -> service.paramRepeatabilityRequestGet(this.client.getHost(), accept, context));
    }

    /**
     * Send a get request without header Repeatability-Request-ID and Repeatability-First-Sent.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return any object along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Object>> paramRepeatabilityRequestGetWithResponseAsync(Context context) {
        if (this.client.getHost() == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter this.client.getHost() is required and cannot be null."));
        }
        final String accept = "application/json";
        return service.paramRepeatabilityRequestGet(this.client.getHost(), accept, context);
    }

    /**
     * Send a get request without header Repeatability-Request-ID and Repeatability-First-Sent.
     * 
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return any object on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Object> paramRepeatabilityRequestGetAsync() {
        return paramRepeatabilityRequestGetWithResponseAsync().flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Send a get request without header Repeatability-Request-ID and Repeatability-First-Sent.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return any object on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Object> paramRepeatabilityRequestGetAsync(Context context) {
        return paramRepeatabilityRequestGetWithResponseAsync(context).flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Send a get request without header Repeatability-Request-ID and Repeatability-First-Sent.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return any object along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Object> paramRepeatabilityRequestGetWithResponse(Context context) {
        return paramRepeatabilityRequestGetWithResponseAsync(context).block();
    }

    /**
     * Send a get request without header Repeatability-Request-ID and Repeatability-First-Sent.
     * 
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return any object.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Object paramRepeatabilityRequestGet() {
        return paramRepeatabilityRequestGetWithResponse(Context.NONE).getValue();
    }

    /**
     * Send a post request with header Repeatability-Request-ID and Repeatability-First-Sent.
     * 
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return any object along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Object>> paramRepeatabilityRequestLROWithResponseAsync() {
        if (this.client.getHost() == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter this.client.getHost() is required and cannot be null."));
        }
        final String accept = "application/json";
        String repeatabilityRequestId = UUID.randomUUID().toString();
        String repeatabilityFirstSent = DateTimeRfc1123.toRfc1123String(OffsetDateTime.now());
        return FluxUtil.withContext(context -> service.paramRepeatabilityRequestLRO(this.client.getHost(), accept,
            repeatabilityRequestId, repeatabilityFirstSent, context));
    }

    /**
     * Send a post request with header Repeatability-Request-ID and Repeatability-First-Sent.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return any object along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Object>> paramRepeatabilityRequestLROWithResponseAsync(Context context) {
        if (this.client.getHost() == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter this.client.getHost() is required and cannot be null."));
        }
        final String accept = "application/json";
        String repeatabilityRequestId = UUID.randomUUID().toString();
        String repeatabilityFirstSent = DateTimeRfc1123.toRfc1123String(OffsetDateTime.now());
        return service.paramRepeatabilityRequestLRO(this.client.getHost(), accept, repeatabilityRequestId,
            repeatabilityFirstSent, context);
    }

    /**
     * Send a post request with header Repeatability-Request-ID and Repeatability-First-Sent.
     * 
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return any object on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Object> paramRepeatabilityRequestLROAsync() {
        return paramRepeatabilityRequestLROWithResponseAsync().flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Send a post request with header Repeatability-Request-ID and Repeatability-First-Sent.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return any object on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Object> paramRepeatabilityRequestLROAsync(Context context) {
        return paramRepeatabilityRequestLROWithResponseAsync(context).flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Send a post request with header Repeatability-Request-ID and Repeatability-First-Sent.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return any object along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Object> paramRepeatabilityRequestLROWithResponse(Context context) {
        return paramRepeatabilityRequestLROWithResponseAsync(context).block();
    }

    /**
     * Send a post request with header Repeatability-Request-ID and Repeatability-First-Sent.
     * 
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return any object.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Object paramRepeatabilityRequestLRO() {
        return paramRepeatabilityRequestLROWithResponse(Context.NONE).getValue();
    }

    /**
     * Send a post request with header Repeatability-Request-ID and Repeatability-First-Sent.
     * 
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response body along with {@link PagedResponse} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<Object>> paramRepeatabilityRequestPageableSinglePageAsync() {
        if (this.client.getHost() == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter this.client.getHost() is required and cannot be null."));
        }
        final String accept = "application/json";
        String repeatabilityRequestId = UUID.randomUUID().toString();
        String repeatabilityFirstSent = DateTimeRfc1123.toRfc1123String(OffsetDateTime.now());
        return FluxUtil
            .withContext(context -> service.paramRepeatabilityRequestPageable(this.client.getHost(), accept,
                repeatabilityRequestId, repeatabilityFirstSent, context))
            .map(res -> new PagedResponseBase<>(res.getRequest(), res.getStatusCode(), res.getHeaders(),
                res.getValue().getValue(), res.getValue().getNextLink(), null));
    }

    /**
     * Send a post request with header Repeatability-Request-ID and Repeatability-First-Sent.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response body along with {@link PagedResponse} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<Object>> paramRepeatabilityRequestPageableSinglePageAsync(Context context) {
        if (this.client.getHost() == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter this.client.getHost() is required and cannot be null."));
        }
        final String accept = "application/json";
        String repeatabilityRequestId = UUID.randomUUID().toString();
        String repeatabilityFirstSent = DateTimeRfc1123.toRfc1123String(OffsetDateTime.now());
        return service
            .paramRepeatabilityRequestPageable(this.client.getHost(), accept, repeatabilityRequestId,
                repeatabilityFirstSent, context)
            .map(res -> new PagedResponseBase<>(res.getRequest(), res.getStatusCode(), res.getHeaders(),
                res.getValue().getValue(), res.getValue().getNextLink(), null));
    }

    /**
     * Send a post request with header Repeatability-Request-ID and Repeatability-First-Sent.
     * 
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the paginated response with {@link PagedFlux}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<Object> paramRepeatabilityRequestPageableAsync() {
        return new PagedFlux<>(() -> paramRepeatabilityRequestPageableSinglePageAsync(),
            nextLink -> paramRepeatabilityRequestPageableNextSinglePageAsync(nextLink));
    }

    /**
     * Send a post request with header Repeatability-Request-ID and Repeatability-First-Sent.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the paginated response with {@link PagedFlux}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<Object> paramRepeatabilityRequestPageableAsync(Context context) {
        return new PagedFlux<>(() -> paramRepeatabilityRequestPageableSinglePageAsync(context),
            nextLink -> paramRepeatabilityRequestPageableNextSinglePageAsync(nextLink, context));
    }

    /**
     * Send a post request with header Repeatability-Request-ID and Repeatability-First-Sent.
     * 
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response body along with {@link PagedResponse}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public PagedResponse<Object> paramRepeatabilityRequestPageableSinglePage() {
        return paramRepeatabilityRequestPageableSinglePageAsync().block();
    }

    /**
     * Send a post request with header Repeatability-Request-ID and Repeatability-First-Sent.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response body along with {@link PagedResponse}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public PagedResponse<Object> paramRepeatabilityRequestPageableSinglePage(Context context) {
        return paramRepeatabilityRequestPageableSinglePageAsync(context).block();
    }

    /**
     * Send a post request with header Repeatability-Request-ID and Repeatability-First-Sent.
     * 
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<Object> paramRepeatabilityRequestPageable() {
        return new PagedIterable<>(paramRepeatabilityRequestPageableAsync());
    }

    /**
     * Send a post request with header Repeatability-Request-ID and Repeatability-First-Sent.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<Object> paramRepeatabilityRequestPageable(Context context) {
        return new PagedIterable<>(paramRepeatabilityRequestPageableAsync(context));
    }

    /**
     * Get the next page of items.
     * 
     * @param nextLink The URL to get the next list of items
     * 
     * The nextLink parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response body along with {@link PagedResponse} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<Object>> paramRepeatabilityRequestPageableNextSinglePageAsync(String nextLink) {
        if (nextLink == null) {
            return Mono.error(new IllegalArgumentException("Parameter nextLink is required and cannot be null."));
        }
        if (this.client.getHost() == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter this.client.getHost() is required and cannot be null."));
        }
        final String accept = "application/json";
        return FluxUtil.withContext(
            context -> service.paramRepeatabilityRequestPageableNext(nextLink, this.client.getHost(), accept, context))
            .map(res -> new PagedResponseBase<>(res.getRequest(), res.getStatusCode(), res.getHeaders(),
                res.getValue().getValue(), res.getValue().getNextLink(), null));
    }

    /**
     * Get the next page of items.
     * 
     * @param nextLink The URL to get the next list of items
     * 
     * The nextLink parameter.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response body along with {@link PagedResponse} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<Object>> paramRepeatabilityRequestPageableNextSinglePageAsync(String nextLink,
        Context context) {
        if (nextLink == null) {
            return Mono.error(new IllegalArgumentException("Parameter nextLink is required and cannot be null."));
        }
        if (this.client.getHost() == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter this.client.getHost() is required and cannot be null."));
        }
        final String accept = "application/json";
        return service.paramRepeatabilityRequestPageableNext(nextLink, this.client.getHost(), accept, context)
            .map(res -> new PagedResponseBase<>(res.getRequest(), res.getStatusCode(), res.getHeaders(),
                res.getValue().getValue(), res.getValue().getNextLink(), null));
    }

    /**
     * Get the next page of items.
     * 
     * @param nextLink The URL to get the next list of items
     * 
     * The nextLink parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response body along with {@link PagedResponse}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public PagedResponse<Object> paramRepeatabilityRequestPageableNextSinglePage(String nextLink) {
        return paramRepeatabilityRequestPageableNextSinglePageAsync(nextLink).block();
    }

    /**
     * Get the next page of items.
     * 
     * @param nextLink The URL to get the next list of items
     * 
     * The nextLink parameter.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response body along with {@link PagedResponse}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public PagedResponse<Object> paramRepeatabilityRequestPageableNextSinglePage(String nextLink, Context context) {
        return paramRepeatabilityRequestPageableNextSinglePageAsync(nextLink, context).block();
    }
}
