package fixtures.url;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceClient;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.RequestOptions;
import com.azure.core.http.rest.Response;
import fixtures.url.implementation.PathsImpl;
import reactor.core.publisher.Mono;

/** Initializes a new instance of the asynchronous AutoRestUrlTestService type. */
@ServiceClient(builder = AutoRestUrlTestServiceBuilder.class, isAsync = true)
public final class PathsAsyncClient {
    private final PathsImpl serviceClient;

    /**
     * Initializes an instance of Paths client.
     *
     * @param serviceClient the service client implementation.
     */
    PathsAsyncClient(PathsImpl serviceClient) {
        this.serviceClient = serviceClient;
    }

    /**
     * Get true Boolean value on path.
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return true Boolean value on path.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> getBooleanTrueWithResponse(RequestOptions requestOptions) {
        return this.serviceClient.getBooleanTrueWithResponseAsync(requestOptions);
    }

    /**
     * Get true Boolean value on path.
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return true Boolean value on path.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> getBooleanTrue(RequestOptions requestOptions) {
        return this.serviceClient.getBooleanTrueAsync(requestOptions);
    }

    /**
     * Get false Boolean value on path.
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return false Boolean value on path.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> getBooleanFalseWithResponse(RequestOptions requestOptions) {
        return this.serviceClient.getBooleanFalseWithResponseAsync(requestOptions);
    }

    /**
     * Get false Boolean value on path.
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return false Boolean value on path.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> getBooleanFalse(RequestOptions requestOptions) {
        return this.serviceClient.getBooleanFalseAsync(requestOptions);
    }

    /**
     * Get '1000000' integer value.
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return '1000000' integer value.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> getIntOneMillionWithResponse(RequestOptions requestOptions) {
        return this.serviceClient.getIntOneMillionWithResponseAsync(requestOptions);
    }

    /**
     * Get '1000000' integer value.
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return '1000000' integer value.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> getIntOneMillion(RequestOptions requestOptions) {
        return this.serviceClient.getIntOneMillionAsync(requestOptions);
    }

    /**
     * Get '-1000000' integer value.
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return '-1000000' integer value.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> getIntNegativeOneMillionWithResponse(RequestOptions requestOptions) {
        return this.serviceClient.getIntNegativeOneMillionWithResponseAsync(requestOptions);
    }

    /**
     * Get '-1000000' integer value.
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return '-1000000' integer value.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> getIntNegativeOneMillion(RequestOptions requestOptions) {
        return this.serviceClient.getIntNegativeOneMillionAsync(requestOptions);
    }

    /**
     * Get '10000000000' 64 bit integer value.
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return '10000000000' 64 bit integer value.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> getTenBillionWithResponse(RequestOptions requestOptions) {
        return this.serviceClient.getTenBillionWithResponseAsync(requestOptions);
    }

    /**
     * Get '10000000000' 64 bit integer value.
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return '10000000000' 64 bit integer value.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> getTenBillion(RequestOptions requestOptions) {
        return this.serviceClient.getTenBillionAsync(requestOptions);
    }

    /**
     * Get '-10000000000' 64 bit integer value.
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return '-10000000000' 64 bit integer value.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> getNegativeTenBillionWithResponse(RequestOptions requestOptions) {
        return this.serviceClient.getNegativeTenBillionWithResponseAsync(requestOptions);
    }

    /**
     * Get '-10000000000' 64 bit integer value.
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return '-10000000000' 64 bit integer value.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> getNegativeTenBillion(RequestOptions requestOptions) {
        return this.serviceClient.getNegativeTenBillionAsync(requestOptions);
    }

    /**
     * Get '1.034E+20' numeric value.
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return '1.034E+20' numeric value.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> floatScientificPositiveWithResponse(RequestOptions requestOptions) {
        return this.serviceClient.floatScientificPositiveWithResponseAsync(requestOptions);
    }

    /**
     * Get '1.034E+20' numeric value.
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return '1.034E+20' numeric value.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> floatScientificPositive(RequestOptions requestOptions) {
        return this.serviceClient.floatScientificPositiveAsync(requestOptions);
    }

    /**
     * Get '-1.034E-20' numeric value.
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return '-1.034E-20' numeric value.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> floatScientificNegativeWithResponse(RequestOptions requestOptions) {
        return this.serviceClient.floatScientificNegativeWithResponseAsync(requestOptions);
    }

    /**
     * Get '-1.034E-20' numeric value.
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return '-1.034E-20' numeric value.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> floatScientificNegative(RequestOptions requestOptions) {
        return this.serviceClient.floatScientificNegativeAsync(requestOptions);
    }

    /**
     * Get '9999999.999' numeric value.
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return '9999999.999' numeric value.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> doubleDecimalPositiveWithResponse(RequestOptions requestOptions) {
        return this.serviceClient.doubleDecimalPositiveWithResponseAsync(requestOptions);
    }

    /**
     * Get '9999999.999' numeric value.
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return '9999999.999' numeric value.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> doubleDecimalPositive(RequestOptions requestOptions) {
        return this.serviceClient.doubleDecimalPositiveAsync(requestOptions);
    }

    /**
     * Get '-9999999.999' numeric value.
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return '-9999999.999' numeric value.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> doubleDecimalNegativeWithResponse(RequestOptions requestOptions) {
        return this.serviceClient.doubleDecimalNegativeWithResponseAsync(requestOptions);
    }

    /**
     * Get '-9999999.999' numeric value.
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return '-9999999.999' numeric value.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> doubleDecimalNegative(RequestOptions requestOptions) {
        return this.serviceClient.doubleDecimalNegativeAsync(requestOptions);
    }

    /**
     * Get '啊齄丂狛狜隣郎隣兀﨩' multi-byte string value.
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return '啊齄丂狛狜隣郎隣兀﨩' multi-byte string value.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> stringUnicodeWithResponse(RequestOptions requestOptions) {
        return this.serviceClient.stringUnicodeWithResponseAsync(requestOptions);
    }

    /**
     * Get '啊齄丂狛狜隣郎隣兀﨩' multi-byte string value.
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return '啊齄丂狛狜隣郎隣兀﨩' multi-byte string value.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> stringUnicode(RequestOptions requestOptions) {
        return this.serviceClient.stringUnicodeAsync(requestOptions);
    }

    /**
     * Get 'begin!*'();:@ &amp;=+$,/?#[]end.
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return 'begin!*'();:@ &amp;=+$,/?#[]end.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> stringUrlEncodedWithResponse(RequestOptions requestOptions) {
        return this.serviceClient.stringUrlEncodedWithResponseAsync(requestOptions);
    }

    /**
     * Get 'begin!*'();:@ &amp;=+$,/?#[]end.
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return 'begin!*'();:@ &amp;=+$,/?#[]end.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> stringUrlEncoded(RequestOptions requestOptions) {
        return this.serviceClient.stringUrlEncodedAsync(requestOptions);
    }

    /**
     * https://tools.ietf.org/html/rfc3986#appendix-A 'path' accept any 'pchar' not encoded.
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> stringUrlNonEncodedWithResponse(RequestOptions requestOptions) {
        return this.serviceClient.stringUrlNonEncodedWithResponseAsync(requestOptions);
    }

    /**
     * https://tools.ietf.org/html/rfc3986#appendix-A 'path' accept any 'pchar' not encoded.
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> stringUrlNonEncoded(RequestOptions requestOptions) {
        return this.serviceClient.stringUrlNonEncodedAsync(requestOptions);
    }

    /**
     * Get ''.
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return ''.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> stringEmptyWithResponse(RequestOptions requestOptions) {
        return this.serviceClient.stringEmptyWithResponseAsync(requestOptions);
    }

    /**
     * Get ''.
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return ''.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> stringEmpty(RequestOptions requestOptions) {
        return this.serviceClient.stringEmptyAsync(requestOptions);
    }

    /**
     * Get null (should throw).
     *
     * @param stringPath null string value.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return null (should throw).
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> stringNullWithResponse(String stringPath, RequestOptions requestOptions) {
        return this.serviceClient.stringNullWithResponseAsync(stringPath, requestOptions);
    }

    /**
     * Get null (should throw).
     *
     * @param stringPath null string value.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return null (should throw).
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> stringNull(String stringPath, RequestOptions requestOptions) {
        return this.serviceClient.stringNullAsync(stringPath, requestOptions);
    }

    /**
     * Get using uri with 'green color' in path parameter.
     *
     * @param enumPath send the value green.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return using uri with 'green color' in path parameter.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> enumValidWithResponse(String enumPath, RequestOptions requestOptions) {
        return this.serviceClient.enumValidWithResponseAsync(enumPath, requestOptions);
    }

    /**
     * Get using uri with 'green color' in path parameter.
     *
     * @param enumPath send the value green.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return using uri with 'green color' in path parameter.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> enumValid(String enumPath, RequestOptions requestOptions) {
        return this.serviceClient.enumValidAsync(enumPath, requestOptions);
    }

    /**
     * Get null (should throw on the client before the request is sent on wire).
     *
     * @param enumPath send null should throw.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return null (should throw on the client before the request is sent on wire).
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> enumNullWithResponse(String enumPath, RequestOptions requestOptions) {
        return this.serviceClient.enumNullWithResponseAsync(enumPath, requestOptions);
    }

    /**
     * Get null (should throw on the client before the request is sent on wire).
     *
     * @param enumPath send null should throw.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return null (should throw on the client before the request is sent on wire).
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> enumNull(String enumPath, RequestOptions requestOptions) {
        return this.serviceClient.enumNullAsync(enumPath, requestOptions);
    }

    /**
     * Get '啊齄丂狛狜隣郎隣兀﨩' multibyte value as utf-8 encoded byte array.
     *
     * @param bytePath '啊齄丂狛狜隣郎隣兀﨩' multibyte value as utf-8 encoded byte array.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return '啊齄丂狛狜隣郎隣兀﨩' multibyte value as utf-8 encoded byte array.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> byteMultiByteWithResponse(String bytePath, RequestOptions requestOptions) {
        return this.serviceClient.byteMultiByteWithResponseAsync(bytePath, requestOptions);
    }

    /**
     * Get '啊齄丂狛狜隣郎隣兀﨩' multibyte value as utf-8 encoded byte array.
     *
     * @param bytePath '啊齄丂狛狜隣郎隣兀﨩' multibyte value as utf-8 encoded byte array.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return '啊齄丂狛狜隣郎隣兀﨩' multibyte value as utf-8 encoded byte array.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> byteMultiByte(String bytePath, RequestOptions requestOptions) {
        return this.serviceClient.byteMultiByteAsync(bytePath, requestOptions);
    }

    /**
     * Get '' as byte array.
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return '' as byte array.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> byteEmptyWithResponse(RequestOptions requestOptions) {
        return this.serviceClient.byteEmptyWithResponseAsync(requestOptions);
    }

    /**
     * Get '' as byte array.
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return '' as byte array.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> byteEmpty(RequestOptions requestOptions) {
        return this.serviceClient.byteEmptyAsync(requestOptions);
    }

    /**
     * Get null as byte array (should throw).
     *
     * @param bytePath null as byte array (should throw).
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return null as byte array (should throw).
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> byteNullWithResponse(String bytePath, RequestOptions requestOptions) {
        return this.serviceClient.byteNullWithResponseAsync(bytePath, requestOptions);
    }

    /**
     * Get null as byte array (should throw).
     *
     * @param bytePath null as byte array (should throw).
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return null as byte array (should throw).
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> byteNull(String bytePath, RequestOptions requestOptions) {
        return this.serviceClient.byteNullAsync(bytePath, requestOptions);
    }

    /**
     * Get '2012-01-01' as date.
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return '2012-01-01' as date.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> dateValidWithResponse(RequestOptions requestOptions) {
        return this.serviceClient.dateValidWithResponseAsync(requestOptions);
    }

    /**
     * Get '2012-01-01' as date.
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return '2012-01-01' as date.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> dateValid(RequestOptions requestOptions) {
        return this.serviceClient.dateValidAsync(requestOptions);
    }

    /**
     * Get null as date - this should throw or be unusable on the client side, depending on date representation.
     *
     * @param datePath null as date (should throw).
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return null as date - this should throw or be unusable on the client side, depending on date representation.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> dateNullWithResponse(String datePath, RequestOptions requestOptions) {
        return this.serviceClient.dateNullWithResponseAsync(datePath, requestOptions);
    }

    /**
     * Get null as date - this should throw or be unusable on the client side, depending on date representation.
     *
     * @param datePath null as date (should throw).
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return null as date - this should throw or be unusable on the client side, depending on date representation.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> dateNull(String datePath, RequestOptions requestOptions) {
        return this.serviceClient.dateNullAsync(datePath, requestOptions);
    }

    /**
     * Get '2012-01-01T01:01:01Z' as date-time.
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return '2012-01-01T01:01:01Z' as date-time.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> dateTimeValidWithResponse(RequestOptions requestOptions) {
        return this.serviceClient.dateTimeValidWithResponseAsync(requestOptions);
    }

    /**
     * Get '2012-01-01T01:01:01Z' as date-time.
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return '2012-01-01T01:01:01Z' as date-time.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> dateTimeValid(RequestOptions requestOptions) {
        return this.serviceClient.dateTimeValidAsync(requestOptions);
    }

    /**
     * Get null as date-time, should be disallowed or throw depending on representation of date-time.
     *
     * @param dateTimePath null as date-time.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return null as date-time, should be disallowed or throw depending on representation of date-time.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> dateTimeNullWithResponse(String dateTimePath, RequestOptions requestOptions) {
        return this.serviceClient.dateTimeNullWithResponseAsync(dateTimePath, requestOptions);
    }

    /**
     * Get null as date-time, should be disallowed or throw depending on representation of date-time.
     *
     * @param dateTimePath null as date-time.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return null as date-time, should be disallowed or throw depending on representation of date-time.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> dateTimeNull(String dateTimePath, RequestOptions requestOptions) {
        return this.serviceClient.dateTimeNullAsync(dateTimePath, requestOptions);
    }

    /**
     * Get 'lorem' encoded value as 'bG9yZW0' (base64url).
     *
     * @param base64UrlPath base64url encoded value.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return 'lorem' encoded value as 'bG9yZW0' (base64url).
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> base64UrlWithResponse(String base64UrlPath, RequestOptions requestOptions) {
        return this.serviceClient.base64UrlWithResponseAsync(base64UrlPath, requestOptions);
    }

    /**
     * Get 'lorem' encoded value as 'bG9yZW0' (base64url).
     *
     * @param base64UrlPath base64url encoded value.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return 'lorem' encoded value as 'bG9yZW0' (base64url).
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> base64Url(String base64UrlPath, RequestOptions requestOptions) {
        return this.serviceClient.base64UrlAsync(base64UrlPath, requestOptions);
    }

    /**
     * Get an array of string ['ArrayPath1', 'begin!*'();:@ &amp;=+$,/?#[]end' , null, ''] using the csv-array format.
     *
     * @param arrayPath an array of string ['ArrayPath1', 'begin!*'();:@ &amp;amp;=+$,/?#[]end' , null, ''] using the
     *     csv-array format.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return an array of string ['ArrayPath1', 'begin!*'();:@ &amp;=+$,/?#[]end' , null, ''] using the csv-array
     *     format.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> arrayCsvInPathWithResponse(String arrayPath, RequestOptions requestOptions) {
        return this.serviceClient.arrayCsvInPathWithResponseAsync(arrayPath, requestOptions);
    }

    /**
     * Get an array of string ['ArrayPath1', 'begin!*'();:@ &amp;=+$,/?#[]end' , null, ''] using the csv-array format.
     *
     * @param arrayPath an array of string ['ArrayPath1', 'begin!*'();:@ &amp;amp;=+$,/?#[]end' , null, ''] using the
     *     csv-array format.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return an array of string ['ArrayPath1', 'begin!*'();:@ &amp;=+$,/?#[]end' , null, ''] using the csv-array
     *     format.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> arrayCsvInPath(String arrayPath, RequestOptions requestOptions) {
        return this.serviceClient.arrayCsvInPathAsync(arrayPath, requestOptions);
    }

    /**
     * Get the date 2016-04-13 encoded value as '1460505600' (Unix time).
     *
     * @param unixTimeUrlPath Unix time encoded value.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return the date 2016-04-13 encoded value as '1460505600' (Unix time).
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> unixTimeUrlWithResponse(long unixTimeUrlPath, RequestOptions requestOptions) {
        return this.serviceClient.unixTimeUrlWithResponseAsync(unixTimeUrlPath, requestOptions);
    }

    /**
     * Get the date 2016-04-13 encoded value as '1460505600' (Unix time).
     *
     * @param unixTimeUrlPath Unix time encoded value.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @return the date 2016-04-13 encoded value as '1460505600' (Unix time).
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> unixTimeUrl(long unixTimeUrlPath, RequestOptions requestOptions) {
        return this.serviceClient.unixTimeUrlAsync(unixTimeUrlPath, requestOptions);
    }
}
