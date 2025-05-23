// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.api.v2

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
import com.dinari.api.models.api.v2.marketdata.MarketDataGetMarketHoursParams
import com.dinari.api.models.api.v2.marketdata.MarketDataGetMarketHoursResponse
import com.dinari.api.services.async.api.v2.marketdata.StockServiceAsync
import com.dinari.api.services.async.api.v2.marketdata.StockServiceAsyncImpl
import java.util.concurrent.CompletableFuture

class MarketDataServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    MarketDataServiceAsync {

    private val withRawResponse: MarketDataServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val stocks: StockServiceAsync by lazy { StockServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): MarketDataServiceAsync.WithRawResponse = withRawResponse

    override fun stocks(): StockServiceAsync = stocks

    override fun getMarketHours(
        params: MarketDataGetMarketHoursParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<MarketDataGetMarketHoursResponse> =
        // get /api/v2/market_data/market_hours/
        withRawResponse().getMarketHours(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        MarketDataServiceAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val stocks: StockServiceAsync.WithRawResponse by lazy {
            StockServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun stocks(): StockServiceAsync.WithRawResponse = stocks

        private val getMarketHoursHandler: Handler<MarketDataGetMarketHoursResponse> =
            jsonHandler<MarketDataGetMarketHoursResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun getMarketHours(
            params: MarketDataGetMarketHoursParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<MarketDataGetMarketHoursResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("api", "v2", "market_data", "market_hours", "")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { getMarketHoursHandler.handle(it) }
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
