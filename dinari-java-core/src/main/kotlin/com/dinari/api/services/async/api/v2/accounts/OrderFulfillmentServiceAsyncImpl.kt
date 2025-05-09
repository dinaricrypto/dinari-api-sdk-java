// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.api.v2.accounts

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
import com.dinari.api.core.prepareAsync
import com.dinari.api.models.api.v2.accounts.orderfulfillments.OrderFulfillment
import com.dinari.api.models.api.v2.accounts.orderfulfillments.OrderFulfillmentQueryParams
import com.dinari.api.models.api.v2.accounts.orderfulfillments.OrderFulfillmentRetrieveParams
import java.util.concurrent.CompletableFuture
import kotlin.jvm.optionals.getOrNull

class OrderFulfillmentServiceAsyncImpl
internal constructor(private val clientOptions: ClientOptions) : OrderFulfillmentServiceAsync {

    private val withRawResponse: OrderFulfillmentServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): OrderFulfillmentServiceAsync.WithRawResponse = withRawResponse

    override fun retrieve(
        params: OrderFulfillmentRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<OrderFulfillment> =
        // get /api/v2/accounts/{account_id}/order_fulfillments/{fulfillment_id}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun query(
        params: OrderFulfillmentQueryParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<OrderFulfillment>> =
        // get /api/v2/accounts/{account_id}/order_fulfillments
        withRawResponse().query(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        OrderFulfillmentServiceAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val retrieveHandler: Handler<OrderFulfillment> =
            jsonHandler<OrderFulfillment>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun retrieve(
            params: OrderFulfillmentRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<OrderFulfillment>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("fulfillmentId", params.fulfillmentId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "api",
                        "v2",
                        "accounts",
                        params._pathParam(0),
                        "order_fulfillments",
                        params._pathParam(1),
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { retrieveHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val queryHandler: Handler<List<OrderFulfillment>> =
            jsonHandler<List<OrderFulfillment>>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun query(
            params: OrderFulfillmentQueryParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<OrderFulfillment>>> {
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
                        "order_fulfillments",
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { queryHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.forEach { it.validate() }
                                }
                            }
                    }
                }
        }
    }
}
