// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.accounts

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
import com.dinari.api.core.http.json
import com.dinari.api.core.http.parseable
import com.dinari.api.core.prepare
import com.dinari.api.models.v2.accounts.orderfulfillments.Fulfillment
import com.dinari.api.models.v2.accounts.orders.Order
import com.dinari.api.models.v2.accounts.orders.OrderCancelParams
import com.dinari.api.models.v2.accounts.orders.OrderGetFulfillmentsParams
import com.dinari.api.models.v2.accounts.orders.OrderListParams
import com.dinari.api.models.v2.accounts.orders.OrderRetrieveParams
import com.dinari.api.services.blocking.v2.accounts.orders.StockService
import com.dinari.api.services.blocking.v2.accounts.orders.StockServiceImpl
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class OrderServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    OrderService {

    private val withRawResponse: OrderService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val stocks: StockService by lazy { StockServiceImpl(clientOptions) }

    override fun withRawResponse(): OrderService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): OrderService =
        OrderServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun stocks(): StockService = stocks

    override fun retrieve(params: OrderRetrieveParams, requestOptions: RequestOptions): Order =
        // get /api/v2/accounts/{account_id}/orders/{order_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun list(params: OrderListParams, requestOptions: RequestOptions): List<Order> =
        // get /api/v2/accounts/{account_id}/orders
        withRawResponse().list(params, requestOptions).parse()

    override fun cancel(params: OrderCancelParams, requestOptions: RequestOptions): Order =
        // post /api/v2/accounts/{account_id}/orders/{order_id}/cancel
        withRawResponse().cancel(params, requestOptions).parse()

    override fun getFulfillments(
        params: OrderGetFulfillmentsParams,
        requestOptions: RequestOptions,
    ): List<Fulfillment> =
        // get /api/v2/accounts/{account_id}/orders/{order_id}/fulfillments
        withRawResponse().getFulfillments(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        OrderService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val stocks: StockService.WithRawResponse by lazy {
            StockServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): OrderService.WithRawResponse =
            OrderServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun stocks(): StockService.WithRawResponse = stocks

        private val retrieveHandler: Handler<Order> = jsonHandler<Order>(clientOptions.jsonMapper)

        override fun retrieve(
            params: OrderRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Order> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("orderId", params.orderId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "api",
                        "v2",
                        "accounts",
                        params._pathParam(0),
                        "orders",
                        params._pathParam(1),
                    )
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<List<Order>> =
            jsonHandler<List<Order>>(clientOptions.jsonMapper)

        override fun list(
            params: OrderListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<Order>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("accountId", params.accountId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v2", "accounts", params._pathParam(0), "orders")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.forEach { it.validate() }
                        }
                    }
            }
        }

        private val cancelHandler: Handler<Order> = jsonHandler<Order>(clientOptions.jsonMapper)

        override fun cancel(
            params: OrderCancelParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Order> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("orderId", params.orderId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "api",
                        "v2",
                        "accounts",
                        params._pathParam(0),
                        "orders",
                        params._pathParam(1),
                        "cancel",
                    )
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { cancelHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val getFulfillmentsHandler: Handler<List<Fulfillment>> =
            jsonHandler<List<Fulfillment>>(clientOptions.jsonMapper)

        override fun getFulfillments(
            params: OrderGetFulfillmentsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<Fulfillment>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("orderId", params.orderId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "api",
                        "v2",
                        "accounts",
                        params._pathParam(0),
                        "orders",
                        params._pathParam(1),
                        "fulfillments",
                    )
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { getFulfillmentsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.forEach { it.validate() }
                        }
                    }
            }
        }
    }
}
