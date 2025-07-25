// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.core

import com.dinari.api.core.http.Headers
import com.dinari.api.core.http.HttpClient
import com.dinari.api.core.http.PhantomReachableClosingHttpClient
import com.dinari.api.core.http.QueryParams
import com.dinari.api.core.http.RetryingHttpClient
import com.fasterxml.jackson.databind.json.JsonMapper
import java.time.Clock
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class ClientOptions
private constructor(
    private val originalHttpClient: HttpClient,
    @get:JvmName("httpClient") val httpClient: HttpClient,
    @get:JvmName("checkJacksonVersionCompatibility") val checkJacksonVersionCompatibility: Boolean,
    @get:JvmName("jsonMapper") val jsonMapper: JsonMapper,
    @get:JvmName("clock") val clock: Clock,
    private val baseUrl: String?,
    @get:JvmName("headers") val headers: Headers,
    @get:JvmName("queryParams") val queryParams: QueryParams,
    @get:JvmName("responseValidation") val responseValidation: Boolean,
    @get:JvmName("timeout") val timeout: Timeout,
    @get:JvmName("maxRetries") val maxRetries: Int,
    @get:JvmName("apiKeyId") val apiKeyId: String,
    @get:JvmName("apiSecretKey") val apiSecretKey: String,
) {

    init {
        if (checkJacksonVersionCompatibility) {
            checkJacksonVersionCompatibility()
        }
    }

    fun baseUrl(): String = baseUrl ?: PRODUCTION_URL

    fun toBuilder() = Builder().from(this)

    companion object {

        const val PRODUCTION_URL = "https://api-enterprise.sbt.dinari.com"

        const val SANDBOX_URL = "https://api-enterprise.sandbox.dinari.com"

        /**
         * Returns a mutable builder for constructing an instance of [ClientOptions].
         *
         * The following fields are required:
         * ```java
         * .httpClient()
         * .apiKeyId()
         * .apiSecretKey()
         * ```
         */
        @JvmStatic fun builder() = Builder()

        @JvmStatic fun fromEnv(): ClientOptions = builder().fromEnv().build()
    }

    /** A builder for [ClientOptions]. */
    class Builder internal constructor() {

        private var httpClient: HttpClient? = null
        private var checkJacksonVersionCompatibility: Boolean = true
        private var jsonMapper: JsonMapper = jsonMapper()
        private var clock: Clock = Clock.systemUTC()
        private var baseUrl: String? = null
        private var headers: Headers.Builder = Headers.builder()
        private var queryParams: QueryParams.Builder = QueryParams.builder()
        private var responseValidation: Boolean = false
        private var timeout: Timeout = Timeout.default()
        private var maxRetries: Int = 2
        private var apiKeyId: String? = null
        private var apiSecretKey: String? = null

        @JvmSynthetic
        internal fun from(clientOptions: ClientOptions) = apply {
            httpClient = clientOptions.originalHttpClient
            checkJacksonVersionCompatibility = clientOptions.checkJacksonVersionCompatibility
            jsonMapper = clientOptions.jsonMapper
            clock = clientOptions.clock
            baseUrl = clientOptions.baseUrl
            headers = clientOptions.headers.toBuilder()
            queryParams = clientOptions.queryParams.toBuilder()
            responseValidation = clientOptions.responseValidation
            timeout = clientOptions.timeout
            maxRetries = clientOptions.maxRetries
            apiKeyId = clientOptions.apiKeyId
            apiSecretKey = clientOptions.apiSecretKey
        }

        fun httpClient(httpClient: HttpClient) = apply { this.httpClient = httpClient }

        fun checkJacksonVersionCompatibility(checkJacksonVersionCompatibility: Boolean) = apply {
            this.checkJacksonVersionCompatibility = checkJacksonVersionCompatibility
        }

        fun jsonMapper(jsonMapper: JsonMapper) = apply { this.jsonMapper = jsonMapper }

        fun clock(clock: Clock) = apply { this.clock = clock }

        fun baseUrl(baseUrl: String?) = apply { this.baseUrl = baseUrl }

        /** Alias for calling [Builder.baseUrl] with `baseUrl.orElse(null)`. */
        fun baseUrl(baseUrl: Optional<String>) = baseUrl(baseUrl.getOrNull())

        fun responseValidation(responseValidation: Boolean) = apply {
            this.responseValidation = responseValidation
        }

        fun timeout(timeout: Timeout) = apply { this.timeout = timeout }

        fun maxRetries(maxRetries: Int) = apply { this.maxRetries = maxRetries }

        fun apiKeyId(apiKeyId: String) = apply { this.apiKeyId = apiKeyId }

        fun apiSecretKey(apiSecretKey: String) = apply { this.apiSecretKey = apiSecretKey }

        fun headers(headers: Headers) = apply {
            this.headers.clear()
            putAllHeaders(headers)
        }

        fun headers(headers: Map<String, Iterable<String>>) = apply {
            this.headers.clear()
            putAllHeaders(headers)
        }

        fun putHeader(name: String, value: String) = apply { headers.put(name, value) }

        fun putHeaders(name: String, values: Iterable<String>) = apply { headers.put(name, values) }

        fun putAllHeaders(headers: Headers) = apply { this.headers.putAll(headers) }

        fun putAllHeaders(headers: Map<String, Iterable<String>>) = apply {
            this.headers.putAll(headers)
        }

        fun replaceHeaders(name: String, value: String) = apply { headers.replace(name, value) }

        fun replaceHeaders(name: String, values: Iterable<String>) = apply {
            headers.replace(name, values)
        }

        fun replaceAllHeaders(headers: Headers) = apply { this.headers.replaceAll(headers) }

        fun replaceAllHeaders(headers: Map<String, Iterable<String>>) = apply {
            this.headers.replaceAll(headers)
        }

        fun removeHeaders(name: String) = apply { headers.remove(name) }

        fun removeAllHeaders(names: Set<String>) = apply { headers.removeAll(names) }

        fun queryParams(queryParams: QueryParams) = apply {
            this.queryParams.clear()
            putAllQueryParams(queryParams)
        }

        fun queryParams(queryParams: Map<String, Iterable<String>>) = apply {
            this.queryParams.clear()
            putAllQueryParams(queryParams)
        }

        fun putQueryParam(key: String, value: String) = apply { queryParams.put(key, value) }

        fun putQueryParams(key: String, values: Iterable<String>) = apply {
            queryParams.put(key, values)
        }

        fun putAllQueryParams(queryParams: QueryParams) = apply {
            this.queryParams.putAll(queryParams)
        }

        fun putAllQueryParams(queryParams: Map<String, Iterable<String>>) = apply {
            this.queryParams.putAll(queryParams)
        }

        fun replaceQueryParams(key: String, value: String) = apply {
            queryParams.replace(key, value)
        }

        fun replaceQueryParams(key: String, values: Iterable<String>) = apply {
            queryParams.replace(key, values)
        }

        fun replaceAllQueryParams(queryParams: QueryParams) = apply {
            this.queryParams.replaceAll(queryParams)
        }

        fun replaceAllQueryParams(queryParams: Map<String, Iterable<String>>) = apply {
            this.queryParams.replaceAll(queryParams)
        }

        fun removeQueryParams(key: String) = apply { queryParams.remove(key) }

        fun removeAllQueryParams(keys: Set<String>) = apply { queryParams.removeAll(keys) }

        fun fromEnv() = apply {
            System.getenv("DINARI_BASE_URL")?.let { baseUrl(it) }
            System.getenv("DINARI_API_KEY_ID")?.let { apiKeyId(it) }
            System.getenv("DINARI_API_SECRET_KEY")?.let { apiSecretKey(it) }
        }

        /**
         * Returns an immutable instance of [ClientOptions].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .httpClient()
         * .apiKeyId()
         * .apiSecretKey()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ClientOptions {
            val httpClient = checkRequired("httpClient", httpClient)
            val apiKeyId = checkRequired("apiKeyId", apiKeyId)
            val apiSecretKey = checkRequired("apiSecretKey", apiSecretKey)

            val headers = Headers.builder()
            val queryParams = QueryParams.builder()
            headers.put("X-Stainless-Lang", "java")
            headers.put("X-Stainless-Arch", getOsArch())
            headers.put("X-Stainless-OS", getOsName())
            headers.put("X-Stainless-OS-Version", getOsVersion())
            headers.put("X-Stainless-Package-Version", getPackageVersion())
            headers.put("X-Stainless-Runtime", "JRE")
            headers.put("X-Stainless-Runtime-Version", getJavaVersion())
            apiKeyId.let {
                if (!it.isEmpty()) {
                    headers.put("X-API-Key-Id", it)
                }
            }
            apiSecretKey.let {
                if (!it.isEmpty()) {
                    headers.put("X-API-Secret-Key", it)
                }
            }
            headers.replaceAll(this.headers.build())
            queryParams.replaceAll(this.queryParams.build())

            return ClientOptions(
                httpClient,
                PhantomReachableClosingHttpClient(
                    RetryingHttpClient.builder()
                        .httpClient(httpClient)
                        .clock(clock)
                        .maxRetries(maxRetries)
                        .build()
                ),
                checkJacksonVersionCompatibility,
                jsonMapper,
                clock,
                baseUrl,
                headers.build(),
                queryParams.build(),
                responseValidation,
                timeout,
                maxRetries,
                apiKeyId,
                apiSecretKey,
            )
        }
    }
}
