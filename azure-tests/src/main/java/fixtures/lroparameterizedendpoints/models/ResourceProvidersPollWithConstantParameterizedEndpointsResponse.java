package fixtures.lroparameterizedendpoints.models;

import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.rest.ResponseBase;

/** Contains all response data for the pollWithConstantParameterizedEndpoints operation. */
public final class ResourceProvidersPollWithConstantParameterizedEndpointsResponse
    extends ResponseBase<ResourceProvidersPollWithConstantParameterizedEndpointsHeaders, String> {
    /**
     * Creates an instance of ResourceProvidersPollWithConstantParameterizedEndpointsResponse.
     *
     * @param request the request which resulted in this
     *     ResourceProvidersPollWithConstantParameterizedEndpointsResponse.
     * @param statusCode the status code of the HTTP response.
     * @param rawHeaders the raw headers of the HTTP response.
     * @param value the deserialized value of the HTTP response.
     * @param headers the deserialized headers of the HTTP response.
     */
    public ResourceProvidersPollWithConstantParameterizedEndpointsResponse(
        HttpRequest request,
        int statusCode,
        HttpHeaders rawHeaders,
        String value,
        ResourceProvidersPollWithConstantParameterizedEndpointsHeaders headers) {
        super(request, statusCode, rawHeaders, value, headers);
    }

    /** @return the deserialized response body. */
    @Override
    public String getValue() {
        return super.getValue();
    }
}