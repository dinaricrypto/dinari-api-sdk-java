// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.api.v2.marketdata.stocks

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
import com.dinari.api.core.prepare
import com.dinari.api.models.api.v2.marketdata.stocks.splits.SplitListParams
import com.dinari.api.models.api.v2.marketdata.stocks.splits.SplitRetrieveParams
import com.dinari.api.models.api.v2.marketdata.stocks.splits.StockSplit

class SplitServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    SplitService {

    private val withRawResponse: SplitService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): SplitService.WithRawResponse = withRawResponse

    override fun retrieve(
        params: SplitRetrieveParams,
        requestOptions: RequestOptions,
    ): List<StockSplit> =
        // get /api/v2/market_data/stocks/{stock_id}/splits
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun list(params: SplitListParams, requestOptions: RequestOptions): List<StockSplit> =
        // get /api/v2/market_data/stocks/splits
        withRawResponse().list(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SplitService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val retrieveHandler: Handler<List<StockSplit>> =
            jsonHandler<List<StockSplit>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun retrieve(
            params: SplitRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<StockSplit>> {
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.forEach { it.validate() }
                        }
                    }
            }
        }

        private val listHandler: Handler<List<StockSplit>> =
            jsonHandler<List<StockSplit>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun list(
            params: SplitListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<StockSplit>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
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
    }
}
