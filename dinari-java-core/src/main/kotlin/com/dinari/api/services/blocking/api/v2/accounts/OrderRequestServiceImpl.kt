// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.api.v2.accounts

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
import com.dinari.api.core.http.json
import com.dinari.api.core.http.parseable
import com.dinari.api.core.prepare
import com.dinari.api.models.api.v2.accounts.orderrequests.OrderRequest
import com.dinari.api.models.api.v2.accounts.orderrequests.OrderRequestCreateLimitBuyParams
import com.dinari.api.models.api.v2.accounts.orderrequests.OrderRequestCreateLimitSellParams
import com.dinari.api.models.api.v2.accounts.orderrequests.OrderRequestCreateMarketBuyParams
import com.dinari.api.models.api.v2.accounts.orderrequests.OrderRequestCreateMarketSellParams
import com.dinari.api.models.api.v2.accounts.orderrequests.OrderRequestListParams
import kotlin.jvm.optionals.getOrNull

class OrderRequestServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    OrderRequestService {

    private val withRawResponse: OrderRequestService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): OrderRequestService.WithRawResponse = withRawResponse

    override fun list(
        params: OrderRequestListParams,
        requestOptions: RequestOptions,
    ): List<OrderRequest> =
        // get /api/v2/accounts/{account_id}/order_requests
        withRawResponse().list(params, requestOptions).parse()

    override fun createLimitBuy(
        params: OrderRequestCreateLimitBuyParams,
        requestOptions: RequestOptions,
    ): OrderRequest =
        // post /api/v2/accounts/{account_id}/order_requests/limit_buy
        withRawResponse().createLimitBuy(params, requestOptions).parse()

    override fun createLimitSell(
        params: OrderRequestCreateLimitSellParams,
        requestOptions: RequestOptions,
    ): OrderRequest =
        // post /api/v2/accounts/{account_id}/order_requests/limit_sell
        withRawResponse().createLimitSell(params, requestOptions).parse()

    override fun createMarketBuy(
        params: OrderRequestCreateMarketBuyParams,
        requestOptions: RequestOptions,
    ): OrderRequest =
        // post /api/v2/accounts/{account_id}/order_requests/market_buy
        withRawResponse().createMarketBuy(params, requestOptions).parse()

    override fun createMarketSell(
        params: OrderRequestCreateMarketSellParams,
        requestOptions: RequestOptions,
    ): OrderRequest =
        // post /api/v2/accounts/{account_id}/order_requests/market_sell
        withRawResponse().createMarketSell(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        OrderRequestService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val listHandler: Handler<List<OrderRequest>> =
            jsonHandler<List<OrderRequest>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun list(
            params: OrderRequestListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<OrderRequest>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("accountId", params.accountId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "api",
                        "v2",
                        "accounts",
                        params._pathParam(0),
                        "order_requests",
                    )
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

        private val createLimitBuyHandler: Handler<OrderRequest> =
            jsonHandler<OrderRequest>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun createLimitBuy(
            params: OrderRequestCreateLimitBuyParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<OrderRequest> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("accountId", params.accountId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments(
                        "api",
                        "v2",
                        "accounts",
                        params._pathParam(0),
                        "order_requests",
                        "limit_buy",
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { createLimitBuyHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val createLimitSellHandler: Handler<OrderRequest> =
            jsonHandler<OrderRequest>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun createLimitSell(
            params: OrderRequestCreateLimitSellParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<OrderRequest> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("accountId", params.accountId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments(
                        "api",
                        "v2",
                        "accounts",
                        params._pathParam(0),
                        "order_requests",
                        "limit_sell",
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { createLimitSellHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val createMarketBuyHandler: Handler<OrderRequest> =
            jsonHandler<OrderRequest>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun createMarketBuy(
            params: OrderRequestCreateMarketBuyParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<OrderRequest> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("accountId", params.accountId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments(
                        "api",
                        "v2",
                        "accounts",
                        params._pathParam(0),
                        "order_requests",
                        "market_buy",
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { createMarketBuyHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val createMarketSellHandler: Handler<OrderRequest> =
            jsonHandler<OrderRequest>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun createMarketSell(
            params: OrderRequestCreateMarketSellParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<OrderRequest> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("accountId", params.accountId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments(
                        "api",
                        "v2",
                        "accounts",
                        params._pathParam(0),
                        "order_requests",
                        "market_sell",
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { createMarketSellHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
