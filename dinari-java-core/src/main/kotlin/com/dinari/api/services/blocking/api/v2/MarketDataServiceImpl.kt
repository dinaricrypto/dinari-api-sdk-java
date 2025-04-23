// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.api.v2

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
import com.dinari.api.models.api.v2.marketdata.MarketDataGetMarketHoursParams
import com.dinari.api.models.api.v2.marketdata.MarketDataGetMarketHoursResponse
import com.dinari.api.services.blocking.api.v2.marketdata.StockService
import com.dinari.api.services.blocking.api.v2.marketdata.StockServiceImpl

class MarketDataServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    MarketDataService {

    private val withRawResponse: MarketDataService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val stocks: StockService by lazy { StockServiceImpl(clientOptions) }

    override fun withRawResponse(): MarketDataService.WithRawResponse = withRawResponse

    override fun stocks(): StockService = stocks

    override fun getMarketHours(
        params: MarketDataGetMarketHoursParams,
        requestOptions: RequestOptions,
    ): MarketDataGetMarketHoursResponse =
        // get /api/v2/market_data/market_hours/
        withRawResponse().getMarketHours(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        MarketDataService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val stocks: StockService.WithRawResponse by lazy {
            StockServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun stocks(): StockService.WithRawResponse = stocks

        private val getMarketHoursHandler: Handler<MarketDataGetMarketHoursResponse> =
            jsonHandler<MarketDataGetMarketHoursResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun getMarketHours(
            params: MarketDataGetMarketHoursParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MarketDataGetMarketHoursResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("api", "v2", "market_data", "market_hours", "")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
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
