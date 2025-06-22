// File generated from our OpenAPI spec by Stainless.

package com.dinari.services.async.v2.marketdata.stocks

import com.dinari.core.ClientOptions
import com.dinari.core.JsonValue
import com.dinari.core.RequestOptions
import com.dinari.core.checkRequired
import com.dinari.core.handlers.errorHandler
import com.dinari.core.handlers.jsonHandler
import com.dinari.core.handlers.withErrorHandler
import com.dinari.core.http.HttpMethod
import com.dinari.core.http.HttpRequest
import com.dinari.core.http.HttpResponse.Handler
import com.dinari.core.http.HttpResponseFor
import com.dinari.core.http.parseable
import com.dinari.core.prepareAsync
import com.dinari.models.v2.marketdata.stocks.splits.SplitListForStockParams
import com.dinari.models.v2.marketdata.stocks.splits.SplitListParams
import com.dinari.models.v2.marketdata.stocks.splits.StockSplit
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class SplitServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    SplitServiceAsync {

    private val withRawResponse: SplitServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): SplitServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): SplitServiceAsync =
        SplitServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun list(
        params: SplitListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<StockSplit>> =
        // get /api/v2/market_data/stocks/splits
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun listForStock(
        params: SplitListForStockParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<StockSplit>> =
        // get /api/v2/market_data/stocks/{stock_id}/splits
        withRawResponse().listForStock(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SplitServiceAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SplitServiceAsync.WithRawResponse =
            SplitServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val listHandler: Handler<List<StockSplit>> =
            jsonHandler<List<StockSplit>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun list(
            params: SplitListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<StockSplit>>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
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

        private val listForStockHandler: Handler<List<StockSplit>> =
            jsonHandler<List<StockSplit>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun listForStock(
            params: SplitListForStockParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<StockSplit>>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("stockId", params.stockId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
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
                            .use { listForStockHandler.handle(it) }
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
