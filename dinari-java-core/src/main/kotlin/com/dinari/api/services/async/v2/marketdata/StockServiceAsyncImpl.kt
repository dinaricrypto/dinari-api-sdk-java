// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.v2.marketdata

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.JsonValue
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.checkRequired
import com.dinari.api.core.handlers.errorHandler
import com.dinari.api.core.handlers.jsonHandler
import com.dinari.api.core.handlers.withErrorHandler
import com.dinari.api.core.http.HttpMethod
import com.dinari.api.core.http.HttpRequest
import com.dinari.api.core.http.HttpResponse.Handler
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.core.http.parseable
import com.dinari.api.core.prepareAsync
import com.dinari.api.models.v2.marketdata.stocks.StockListParams
import com.dinari.api.models.v2.marketdata.stocks.StockListResponse
import com.dinari.api.models.v2.marketdata.stocks.StockRetrieveCurrentPriceParams
import com.dinari.api.models.v2.marketdata.stocks.StockRetrieveCurrentPriceResponse
import com.dinari.api.models.v2.marketdata.stocks.StockRetrieveCurrentQuoteParams
import com.dinari.api.models.v2.marketdata.stocks.StockRetrieveCurrentQuoteResponse
import com.dinari.api.models.v2.marketdata.stocks.StockRetrieveDividendsParams
import com.dinari.api.models.v2.marketdata.stocks.StockRetrieveDividendsResponse
import com.dinari.api.models.v2.marketdata.stocks.StockRetrieveHistoricalPricesParams
import com.dinari.api.models.v2.marketdata.stocks.StockRetrieveHistoricalPricesResponse
import com.dinari.api.models.v2.marketdata.stocks.StockRetrieveNewsParams
import com.dinari.api.models.v2.marketdata.stocks.StockRetrieveNewsResponse
import com.dinari.api.services.async.v2.marketdata.stocks.SplitServiceAsync
import com.dinari.api.services.async.v2.marketdata.stocks.SplitServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class StockServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    StockServiceAsync {

    private val withRawResponse: StockServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val splits: SplitServiceAsync by lazy { SplitServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): StockServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): StockServiceAsync =
        StockServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun splits(): SplitServiceAsync = splits

    override fun list(
        params: StockListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<StockListResponse>> =
        // get /api/v2/market_data/stocks/
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun retrieveCurrentPrice(
        params: StockRetrieveCurrentPriceParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<StockRetrieveCurrentPriceResponse> =
        // get /api/v2/market_data/stocks/{stock_id}/current_price
        withRawResponse().retrieveCurrentPrice(params, requestOptions).thenApply { it.parse() }

    override fun retrieveCurrentQuote(
        params: StockRetrieveCurrentQuoteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<StockRetrieveCurrentQuoteResponse> =
        // get /api/v2/market_data/stocks/{stock_id}/current_quote
        withRawResponse().retrieveCurrentQuote(params, requestOptions).thenApply { it.parse() }

    override fun retrieveDividends(
        params: StockRetrieveDividendsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<StockRetrieveDividendsResponse>> =
        // get /api/v2/market_data/stocks/{stock_id}/dividends
        withRawResponse().retrieveDividends(params, requestOptions).thenApply { it.parse() }

    override fun retrieveHistoricalPrices(
        params: StockRetrieveHistoricalPricesParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<StockRetrieveHistoricalPricesResponse>> =
        // get /api/v2/market_data/stocks/{stock_id}/historical_prices/
        withRawResponse().retrieveHistoricalPrices(params, requestOptions).thenApply { it.parse() }

    override fun retrieveNews(
        params: StockRetrieveNewsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<StockRetrieveNewsResponse>> =
        // get /api/v2/market_data/stocks/{stock_id}/news
        withRawResponse().retrieveNews(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        StockServiceAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val splits: SplitServiceAsync.WithRawResponse by lazy {
            SplitServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): StockServiceAsync.WithRawResponse =
            StockServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun splits(): SplitServiceAsync.WithRawResponse = splits

        private val listHandler: Handler<List<StockListResponse>> =
            jsonHandler<List<StockListResponse>>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun list(
            params: StockListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<StockListResponse>>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v2", "market_data", "stocks", "")
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

        private val retrieveCurrentPriceHandler: Handler<StockRetrieveCurrentPriceResponse> =
            jsonHandler<StockRetrieveCurrentPriceResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun retrieveCurrentPrice(
            params: StockRetrieveCurrentPriceParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<StockRetrieveCurrentPriceResponse>> {
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
                        "current_price",
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { retrieveCurrentPriceHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val retrieveCurrentQuoteHandler: Handler<StockRetrieveCurrentQuoteResponse> =
            jsonHandler<StockRetrieveCurrentQuoteResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun retrieveCurrentQuote(
            params: StockRetrieveCurrentQuoteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<StockRetrieveCurrentQuoteResponse>> {
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
                        "current_quote",
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { retrieveCurrentQuoteHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val retrieveDividendsHandler: Handler<List<StockRetrieveDividendsResponse>> =
            jsonHandler<List<StockRetrieveDividendsResponse>>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun retrieveDividends(
            params: StockRetrieveDividendsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<StockRetrieveDividendsResponse>>> {
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
                        "dividends",
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { retrieveDividendsHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.forEach { it.validate() }
                                }
                            }
                    }
                }
        }

        private val retrieveHistoricalPricesHandler:
            Handler<List<StockRetrieveHistoricalPricesResponse>> =
            jsonHandler<List<StockRetrieveHistoricalPricesResponse>>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun retrieveHistoricalPrices(
            params: StockRetrieveHistoricalPricesParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<StockRetrieveHistoricalPricesResponse>>> {
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
                        "historical_prices",
                        "",
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { retrieveHistoricalPricesHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.forEach { it.validate() }
                                }
                            }
                    }
                }
        }

        private val retrieveNewsHandler: Handler<List<StockRetrieveNewsResponse>> =
            jsonHandler<List<StockRetrieveNewsResponse>>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun retrieveNews(
            params: StockRetrieveNewsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<StockRetrieveNewsResponse>>> {
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
                        "news",
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { retrieveNewsHandler.handle(it) }
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
