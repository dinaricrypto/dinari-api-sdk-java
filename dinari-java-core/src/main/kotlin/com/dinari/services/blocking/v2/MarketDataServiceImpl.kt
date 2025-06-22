// File generated from our OpenAPI spec by Stainless.

package com.dinari.services.blocking.v2

import com.dinari.core.ClientOptions
import com.dinari.core.JsonValue
import com.dinari.core.RequestOptions
import com.dinari.core.handlers.errorHandler
import com.dinari.core.handlers.jsonHandler
import com.dinari.core.handlers.withErrorHandler
import com.dinari.core.http.HttpMethod
import com.dinari.core.http.HttpRequest
import com.dinari.core.http.HttpResponse.Handler
import com.dinari.core.http.HttpResponseFor
import com.dinari.core.http.parseable
import com.dinari.core.prepare
import com.dinari.models.v2.marketdata.MarketDataRetrieveMarketHoursParams
import com.dinari.models.v2.marketdata.MarketDataRetrieveMarketHoursResponse
import com.dinari.services.blocking.v2.marketdata.StockService
import com.dinari.services.blocking.v2.marketdata.StockServiceImpl
import java.util.function.Consumer

class MarketDataServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    MarketDataService {

    private val withRawResponse: MarketDataService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val stocks: StockService by lazy { StockServiceImpl(clientOptions) }

    override fun withRawResponse(): MarketDataService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): MarketDataService =
        MarketDataServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun stocks(): StockService = stocks

    override fun retrieveMarketHours(
        params: MarketDataRetrieveMarketHoursParams,
        requestOptions: RequestOptions,
    ): MarketDataRetrieveMarketHoursResponse =
        // get /api/v2/market_data/market_hours/
        withRawResponse().retrieveMarketHours(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        MarketDataService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val stocks: StockService.WithRawResponse by lazy {
            StockServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): MarketDataService.WithRawResponse =
            MarketDataServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun stocks(): StockService.WithRawResponse = stocks

        private val retrieveMarketHoursHandler: Handler<MarketDataRetrieveMarketHoursResponse> =
            jsonHandler<MarketDataRetrieveMarketHoursResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun retrieveMarketHours(
            params: MarketDataRetrieveMarketHoursParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MarketDataRetrieveMarketHoursResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v2", "market_data", "market_hours", "")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { retrieveMarketHoursHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
