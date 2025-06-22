// File generated from our OpenAPI spec by Stainless.

package com.dinari.services.blocking.v2.accounts

import com.dinari.core.ClientOptions
import com.dinari.core.JsonValue
import com.dinari.core.RequestOptions
import com.dinari.core.checkRequired
import com.dinari.core.handlers.errorHandler
import com.dinari.core.handlers.jsonHandler
import com.dinari.core.handlers.withErrorHandler
import com.dinari.core.http.HttpMethod
import com.dinari.core.http.HttpRequest
import com.dinari.core.http.HttpResponse.Handler
import com.dinari.core.http.HttpResponseFor
import com.dinari.core.http.parseable
import com.dinari.core.prepare
import com.dinari.models.v2.accounts.orderfulfillments.Fulfillment
import com.dinari.models.v2.accounts.orderfulfillments.OrderFulfillmentQueryParams
import com.dinari.models.v2.accounts.orderfulfillments.OrderFulfillmentRetrieveParams
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class OrderFulfillmentServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    OrderFulfillmentService {

    private val withRawResponse: OrderFulfillmentService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): OrderFulfillmentService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): OrderFulfillmentService =
        OrderFulfillmentServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieve(
        params: OrderFulfillmentRetrieveParams,
        requestOptions: RequestOptions,
    ): Fulfillment =
        // get /api/v2/accounts/{account_id}/order_fulfillments/{order_fulfillment_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun query(
        params: OrderFulfillmentQueryParams,
        requestOptions: RequestOptions,
    ): List<Fulfillment> =
        // get /api/v2/accounts/{account_id}/order_fulfillments
        withRawResponse().query(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        OrderFulfillmentService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): OrderFulfillmentService.WithRawResponse =
            OrderFulfillmentServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveHandler: Handler<Fulfillment> =
            jsonHandler<Fulfillment>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun retrieve(
            params: OrderFulfillmentRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Fulfillment> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("orderFulfillmentId", params.orderFulfillmentId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "api",
                        "v2",
                        "accounts",
                        params._pathParam(0),
                        "order_fulfillments",
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

        private val queryHandler: Handler<List<Fulfillment>> =
            jsonHandler<List<Fulfillment>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun query(
            params: OrderFulfillmentQueryParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<Fulfillment>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("accountId", params.accountId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "api",
                        "v2",
                        "accounts",
                        params._pathParam(0),
                        "order_fulfillments",
                    )
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
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
