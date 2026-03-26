// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.handlers.errorBodyHandler
import com.dinari.api.core.handlers.errorHandler
import com.dinari.api.core.handlers.jsonHandler
import com.dinari.api.core.http.HttpMethod
import com.dinari.api.core.http.HttpRequest
import com.dinari.api.core.http.HttpResponse
import com.dinari.api.core.http.HttpResponse.Handler
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.core.http.parseable
import com.dinari.api.core.prepare
import com.dinari.api.models.v2.marketdata.MarketDataRetrieveMarketHoursParams
import com.dinari.api.models.v2.marketdata.MarketDataRetrieveMarketHoursResponse
import com.dinari.api.services.blocking.v2.marketdata.AlloyService
import com.dinari.api.services.blocking.v2.marketdata.AlloyServiceImpl
import com.dinari.api.services.blocking.v2.marketdata.StockService
import com.dinari.api.services.blocking.v2.marketdata.StockServiceImpl
import java.util.function.Consumer

/**
 * **Dinari provides basic market data for `Stocks` and `Alloys` that are available to transact
 * on.**
 *
 * This data is provided on a best-effort basis and we recommend using a dedicated provider for more
 * intensive market data needs.
 */
class MarketDataServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    MarketDataService {

    private val withRawResponse: MarketDataService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val stocks: StockService by lazy { StockServiceImpl(clientOptions) }

    private val alloys: AlloyService by lazy { AlloyServiceImpl(clientOptions) }

    override fun withRawResponse(): MarketDataService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): MarketDataService =
        MarketDataServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun stocks(): StockService = stocks

    /**
     * **Dinari provides basic market data for `Stocks` and `Alloys` that are available to transact
     * on.**
     *
     * This data is provided on a best-effort basis and we recommend using a dedicated provider for
     * more intensive market data needs.
     */
    override fun alloys(): AlloyService = alloys

    override fun retrieveMarketHours(
        params: MarketDataRetrieveMarketHoursParams,
        requestOptions: RequestOptions,
    ): MarketDataRetrieveMarketHoursResponse =
        // get /api/v2/market_data/market_hours/
        withRawResponse().retrieveMarketHours(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        MarketDataService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val stocks: StockService.WithRawResponse by lazy {
            StockServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val alloys: AlloyService.WithRawResponse by lazy {
            AlloyServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): MarketDataService.WithRawResponse =
            MarketDataServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun stocks(): StockService.WithRawResponse = stocks

        /**
         * **Dinari provides basic market data for `Stocks` and `Alloys` that are available to
         * transact on.**
         *
         * This data is provided on a best-effort basis and we recommend using a dedicated provider
         * for more intensive market data needs.
         */
        override fun alloys(): AlloyService.WithRawResponse = alloys

        private val retrieveMarketHoursHandler: Handler<MarketDataRetrieveMarketHoursResponse> =
            jsonHandler<MarketDataRetrieveMarketHoursResponse>(clientOptions.jsonMapper)

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
            return errorHandler.handle(response).parseable {
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
