// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.marketdata

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
import com.dinari.api.core.prepare
import com.dinari.api.models.v2.marketdata.stocks.StockListParams
import com.dinari.api.models.v2.marketdata.stocks.StockListResponse
import com.dinari.api.models.v2.marketdata.stocks.StockRetrieveDividendsParams
import com.dinari.api.models.v2.marketdata.stocks.StockRetrieveDividendsResponse
import com.dinari.api.models.v2.marketdata.stocks.StockRetrieveHistoricalPricesParams
import com.dinari.api.models.v2.marketdata.stocks.StockRetrieveHistoricalPricesResponse
import com.dinari.api.models.v2.marketdata.stocks.StockRetrieveNewsParams
import com.dinari.api.models.v2.marketdata.stocks.StockRetrieveNewsResponse
import com.dinari.api.models.v2.marketdata.stocks.StockRetrieveQuoteParams
import com.dinari.api.models.v2.marketdata.stocks.StockRetrieveQuoteResponse
import com.dinari.api.services.blocking.v2.marketdata.stocks.SplitService
import com.dinari.api.services.blocking.v2.marketdata.stocks.SplitServiceImpl
import kotlin.jvm.optionals.getOrNull

class StockServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    StockService {

    private val withRawResponse: StockService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val splits: SplitService by lazy { SplitServiceImpl(clientOptions) }

    override fun withRawResponse(): StockService.WithRawResponse = withRawResponse

    override fun splits(): SplitService = splits

    override fun list(
        params: StockListParams,
        requestOptions: RequestOptions,
    ): List<StockListResponse> =
        // get /api/v2/market_data/stocks/
        withRawResponse().list(params, requestOptions).parse()

    override fun retrieveDividends(
        params: StockRetrieveDividendsParams,
        requestOptions: RequestOptions,
    ): List<StockRetrieveDividendsResponse> =
        // get /api/v2/market_data/stocks/{stock_id}/dividends
        withRawResponse().retrieveDividends(params, requestOptions).parse()

    override fun retrieveHistoricalPrices(
        params: StockRetrieveHistoricalPricesParams,
        requestOptions: RequestOptions,
    ): List<StockRetrieveHistoricalPricesResponse> =
        // get /api/v2/market_data/stocks/{stock_id}/historical_prices/
        withRawResponse().retrieveHistoricalPrices(params, requestOptions).parse()

    override fun retrieveNews(
        params: StockRetrieveNewsParams,
        requestOptions: RequestOptions,
    ): List<StockRetrieveNewsResponse> =
        // get /api/v2/market_data/stocks/{stock_id}/news
        withRawResponse().retrieveNews(params, requestOptions).parse()

    override fun retrieveQuote(
        params: StockRetrieveQuoteParams,
        requestOptions: RequestOptions,
    ): StockRetrieveQuoteResponse =
        // get /api/v2/market_data/stocks/{stock_id}/quote
        withRawResponse().retrieveQuote(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        StockService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val splits: SplitService.WithRawResponse by lazy {
            SplitServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun splits(): SplitService.WithRawResponse = splits

        private val listHandler: Handler<List<StockListResponse>> =
            jsonHandler<List<StockListResponse>>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun list(
            params: StockListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<StockListResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v2", "market_data", "stocks", "")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.forEach { it.validate() }
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
        ): HttpResponseFor<List<StockRetrieveDividendsResponse>> {
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { retrieveDividendsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.forEach { it.validate() }
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
        ): HttpResponseFor<List<StockRetrieveHistoricalPricesResponse>> {
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { retrieveHistoricalPricesHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.forEach { it.validate() }
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
        ): HttpResponseFor<List<StockRetrieveNewsResponse>> {
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { retrieveNewsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.forEach { it.validate() }
                        }
                    }
            }
        }

        private val retrieveQuoteHandler: Handler<StockRetrieveQuoteResponse> =
            jsonHandler<StockRetrieveQuoteResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun retrieveQuote(
            params: StockRetrieveQuoteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<StockRetrieveQuoteResponse> {
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
                        "quote",
                    )
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { retrieveQuoteHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
