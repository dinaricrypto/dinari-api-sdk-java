// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.api.v2.marketdata.stocks

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
import com.dinari.api.models.api.v2.marketdata.stocks.splits.SplitListParams
import com.dinari.api.models.api.v2.marketdata.stocks.splits.SplitRetrieveParams
import com.dinari.api.models.api.v2.marketdata.stocks.splits.StockSplit
import java.util.concurrent.CompletableFuture

class SplitServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    SplitServiceAsync {

    private val withRawResponse: SplitServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): SplitServiceAsync.WithRawResponse = withRawResponse

    override fun retrieve(
        params: SplitRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<StockSplit>> =
        // get /api/v2/market_data/stocks/{stock_id}/splits
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: SplitListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<StockSplit>> =
        // get /api/v2/market_data/stocks/splits
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SplitServiceAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val retrieveHandler: Handler<List<StockSplit>> =
            jsonHandler<List<StockSplit>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun retrieve(
            params: SplitRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<StockSplit>>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "api",
                        "v2",
                        "market_data",
                        "stocks",
                        params._pathParam(0),
                        "splits",
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { retrieveHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.forEach { it.validate() }
                                }
                            }
                    }
                }
        }

        private val listHandler: Handler<List<StockSplit>> =
            jsonHandler<List<StockSplit>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun list(
            params: SplitListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<StockSplit>>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("api", "v2", "market_data", "stocks", "splits")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { listHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.forEach { it.validate() }
                                }
                            }
                    }
                }
        }
    }
}
