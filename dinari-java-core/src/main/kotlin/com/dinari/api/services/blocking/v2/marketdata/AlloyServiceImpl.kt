// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.marketdata

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.checkRequired
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
import com.dinari.api.models.v2.marketdata.alloys.AlloyListParams
import com.dinari.api.models.v2.marketdata.alloys.AlloyListResponse
import com.dinari.api.models.v2.marketdata.alloys.AlloyRetrieveCurrentPriceParams
import com.dinari.api.models.v2.marketdata.alloys.AlloyRetrieveCurrentPriceResponse
import com.dinari.api.models.v2.marketdata.alloys.AlloyRetrieveHistoricalPricesParams
import com.dinari.api.models.v2.marketdata.alloys.AlloyRetrieveHistoricalPricesResponse
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

/**
 * **Dinari provides basic market data for `Stocks` and `Alloys` that are available to transact
 * on.**
 *
 * This data is provided on a best-effort basis and we recommend using a dedicated provider for more
 * intensive market data needs.
 */
class AlloyServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    AlloyService {

    private val withRawResponse: AlloyService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): AlloyService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): AlloyService =
        AlloyServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun list(params: AlloyListParams, requestOptions: RequestOptions): AlloyListResponse =
        // get /api/v2/market_data/alloys/
        withRawResponse().list(params, requestOptions).parse()

    override fun retrieveCurrentPrice(
        params: AlloyRetrieveCurrentPriceParams,
        requestOptions: RequestOptions,
    ): AlloyRetrieveCurrentPriceResponse =
        // get /api/v2/market_data/alloys/{alloy_id}/current_price
        withRawResponse().retrieveCurrentPrice(params, requestOptions).parse()

    override fun retrieveHistoricalPrices(
        params: AlloyRetrieveHistoricalPricesParams,
        requestOptions: RequestOptions,
    ): List<AlloyRetrieveHistoricalPricesResponse> =
        // get /api/v2/market_data/alloys/{alloy_id}/historical_prices/
        withRawResponse().retrieveHistoricalPrices(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AlloyService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AlloyService.WithRawResponse =
            AlloyServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val listHandler: Handler<AlloyListResponse> =
            jsonHandler<AlloyListResponse>(clientOptions.jsonMapper)

        override fun list(
            params: AlloyListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AlloyListResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v2", "market_data", "alloys", "")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveCurrentPriceHandler: Handler<AlloyRetrieveCurrentPriceResponse> =
            jsonHandler<AlloyRetrieveCurrentPriceResponse>(clientOptions.jsonMapper)

        override fun retrieveCurrentPrice(
            params: AlloyRetrieveCurrentPriceParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AlloyRetrieveCurrentPriceResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("alloyId", params.alloyId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "api",
                        "v2",
                        "market_data",
                        "alloys",
                        params._pathParam(0),
                        "current_price",
                    )
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveCurrentPriceHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveHistoricalPricesHandler:
            Handler<List<AlloyRetrieveHistoricalPricesResponse>> =
            jsonHandler<List<AlloyRetrieveHistoricalPricesResponse>>(clientOptions.jsonMapper)

        override fun retrieveHistoricalPrices(
            params: AlloyRetrieveHistoricalPricesParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<AlloyRetrieveHistoricalPricesResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("alloyId", params.alloyId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "api",
                        "v2",
                        "market_data",
                        "alloys",
                        params._pathParam(0),
                        "historical_prices",
                        "",
                    )
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
}
