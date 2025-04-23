// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.api.v2.accounts

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
import com.dinari.api.core.http.json
import com.dinari.api.core.http.parseable
import com.dinari.api.core.prepare
import com.dinari.api.models.api.v2.accounts.orderfulfillments.OrderFulfillment
import com.dinari.api.models.api.v2.accounts.orders.Order
import com.dinari.api.models.api.v2.accounts.orders.OrderCancelParams
import com.dinari.api.models.api.v2.accounts.orders.OrderGetEstimatedFeeParams
import com.dinari.api.models.api.v2.accounts.orders.OrderGetEstimatedFeeResponse
import com.dinari.api.models.api.v2.accounts.orders.OrderListParams
import com.dinari.api.models.api.v2.accounts.orders.OrderRetrieveFulfillmentsParams
import com.dinari.api.models.api.v2.accounts.orders.OrderRetrieveParams

class OrderServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    OrderService {

    private val withRawResponse: OrderService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): OrderService.WithRawResponse = withRawResponse

    override fun retrieve(params: OrderRetrieveParams, requestOptions: RequestOptions): Order =
        // get /api/v2/accounts/{account_id}/orders/{order_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun list(params: OrderListParams, requestOptions: RequestOptions): List<Order> =
        // get /api/v2/accounts/{account_id}/orders
        withRawResponse().list(params, requestOptions).parse()

    override fun cancel(params: OrderCancelParams, requestOptions: RequestOptions): Order =
        // post /api/v2/accounts/{account_id}/orders/{order_id}/cancel
        withRawResponse().cancel(params, requestOptions).parse()

    override fun getEstimatedFee(
        params: OrderGetEstimatedFeeParams,
        requestOptions: RequestOptions,
    ): OrderGetEstimatedFeeResponse =
        // post /api/v2/accounts/{account_id}/orders/estimated_fee
        withRawResponse().getEstimatedFee(params, requestOptions).parse()

    override fun retrieveFulfillments(
        params: OrderRetrieveFulfillmentsParams,
        requestOptions: RequestOptions,
    ): List<OrderFulfillment> =
        // get /api/v2/accounts/{account_id}/orders/{order_id}/fulfillments
        withRawResponse().retrieveFulfillments(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        OrderService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val retrieveHandler: Handler<Order> =
            jsonHandler<Order>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun retrieve(
            params: OrderRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Order> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
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
            return response.parseable {
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
            jsonHandler<List<Order>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun list(
            params: OrderListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<Order>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("api", "v2", "accounts", params._pathParam(0), "orders")
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

        private val cancelHandler: Handler<Order> =
            jsonHandler<Order>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun cancel(
            params: OrderCancelParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Order> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
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
            return response.parseable {
                response
                    .use { cancelHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val getEstimatedFeeHandler: Handler<OrderGetEstimatedFeeResponse> =
            jsonHandler<OrderGetEstimatedFeeResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun getEstimatedFee(
            params: OrderGetEstimatedFeeParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<OrderGetEstimatedFeeResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments(
                        "api",
                        "v2",
                        "accounts",
                        params._pathParam(0),
                        "orders",
                        "estimated_fee",
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { getEstimatedFeeHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveFulfillmentsHandler: Handler<List<OrderFulfillment>> =
            jsonHandler<List<OrderFulfillment>>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun retrieveFulfillments(
            params: OrderRetrieveFulfillmentsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<OrderFulfillment>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
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
            return response.parseable {
                response
                    .use { retrieveFulfillmentsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.forEach { it.validate() }
                        }
                    }
            }
        }
    }
}
