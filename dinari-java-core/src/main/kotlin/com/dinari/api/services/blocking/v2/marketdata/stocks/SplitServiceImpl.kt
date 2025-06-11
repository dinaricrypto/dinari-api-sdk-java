// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.marketdata.stocks

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
import com.dinari.api.models.v2.marketdata.stocks.splits.SplitListForStockParams
import com.dinari.api.models.v2.marketdata.stocks.splits.SplitListParams
import com.dinari.api.models.v2.marketdata.stocks.splits.StockSplit
import kotlin.jvm.optionals.getOrNull

class SplitServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    SplitService {

    private val withRawResponse: SplitService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): SplitService.WithRawResponse = withRawResponse

    override fun list(params: SplitListParams, requestOptions: RequestOptions): List<StockSplit> =
        // get /api/v2/market_data/stocks/splits
        withRawResponse().list(params, requestOptions).parse()

    override fun listForStock(
        params: SplitListForStockParams,
        requestOptions: RequestOptions,
    ): List<StockSplit> =
        // get /api/v2/market_data/stocks/{stock_id}/splits
        withRawResponse().listForStock(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SplitService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val listHandler: Handler<List<StockSplit>> =
            jsonHandler<List<StockSplit>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun list(
            params: SplitListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<StockSplit>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v2", "market_data", "stocks", "splits")
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

        private val listForStockHandler: Handler<List<StockSplit>> =
            jsonHandler<List<StockSplit>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun listForStock(
            params: SplitListForStockParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<StockSplit>> {
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
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
