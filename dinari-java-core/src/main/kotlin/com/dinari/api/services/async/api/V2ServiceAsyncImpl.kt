// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.api

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.JsonValue
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.handlers.errorHandler
import com.dinari.api.core.handlers.jsonHandler
import com.dinari.api.core.handlers.withErrorHandler
import com.dinari.api.core.http.HttpMethod
import com.dinari.api.core.http.HttpRequest
import com.dinari.api.core.http.HttpResponse.Handler
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.core.http.parseable
import com.dinari.api.core.prepareAsync
import com.dinari.api.models.api.v2.V2GetHealthParams
import com.dinari.api.models.api.v2.V2GetHealthResponse
import com.dinari.api.services.async.api.v2.AccountServiceAsync
import com.dinari.api.services.async.api.v2.AccountServiceAsyncImpl
import com.dinari.api.services.async.api.v2.EntityServiceAsync
import com.dinari.api.services.async.api.v2.EntityServiceAsyncImpl
import com.dinari.api.services.async.api.v2.MarketDataServiceAsync
import com.dinari.api.services.async.api.v2.MarketDataServiceAsyncImpl
import java.util.concurrent.CompletableFuture

class V2ServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    V2ServiceAsync {

    private val withRawResponse: V2ServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val marketData: MarketDataServiceAsync by lazy {
        MarketDataServiceAsyncImpl(clientOptions)
    }

    private val entities: EntityServiceAsync by lazy { EntityServiceAsyncImpl(clientOptions) }

    private val accounts: AccountServiceAsync by lazy { AccountServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): V2ServiceAsync.WithRawResponse = withRawResponse

    override fun marketData(): MarketDataServiceAsync = marketData

    override fun entities(): EntityServiceAsync = entities

    override fun accounts(): AccountServiceAsync = accounts

    override fun getHealth(
        params: V2GetHealthParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<V2GetHealthResponse> =
        // get /api/v2/_health/
        withRawResponse().getHealth(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        V2ServiceAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val marketData: MarketDataServiceAsync.WithRawResponse by lazy {
            MarketDataServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val entities: EntityServiceAsync.WithRawResponse by lazy {
            EntityServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val accounts: AccountServiceAsync.WithRawResponse by lazy {
            AccountServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun marketData(): MarketDataServiceAsync.WithRawResponse = marketData

        override fun entities(): EntityServiceAsync.WithRawResponse = entities

        override fun accounts(): AccountServiceAsync.WithRawResponse = accounts

        private val getHealthHandler: Handler<V2GetHealthResponse> =
            jsonHandler<V2GetHealthResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun getHealth(
            params: V2GetHealthParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<V2GetHealthResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("api", "v2", "_health", "")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { getHealthHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }
    }
}
