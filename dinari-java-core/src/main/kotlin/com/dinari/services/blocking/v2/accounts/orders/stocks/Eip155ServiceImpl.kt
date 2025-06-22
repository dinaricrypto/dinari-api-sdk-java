// File generated from our OpenAPI spec by Stainless.

package com.dinari.services.blocking.v2.accounts.orders.stocks

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
import com.dinari.core.http.json
import com.dinari.core.http.parseable
import com.dinari.core.prepare
import com.dinari.models.v2.accounts.orders.stocks.eip155.Eip155GetFeeQuoteParams
import com.dinari.models.v2.accounts.orders.stocks.eip155.Eip155GetFeeQuoteResponse
import com.dinari.models.v2.accounts.orders.stocks.eip155.Eip155PrepareOrderParams
import com.dinari.models.v2.accounts.orders.stocks.eip155.Eip155PrepareOrderResponse
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class Eip155ServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    Eip155Service {

    private val withRawResponse: Eip155Service.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): Eip155Service.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): Eip155Service =
        Eip155ServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun getFeeQuote(
        params: Eip155GetFeeQuoteParams,
        requestOptions: RequestOptions,
    ): Eip155GetFeeQuoteResponse =
        // post /api/v2/accounts/{account_id}/orders/stocks/eip155/fee_quote
        withRawResponse().getFeeQuote(params, requestOptions).parse()

    override fun prepareOrder(
        params: Eip155PrepareOrderParams,
        requestOptions: RequestOptions,
    ): Eip155PrepareOrderResponse =
        // post /api/v2/accounts/{account_id}/orders/stocks/eip155/prepare
        withRawResponse().prepareOrder(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        Eip155Service.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): Eip155Service.WithRawResponse =
            Eip155ServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val getFeeQuoteHandler: Handler<Eip155GetFeeQuoteResponse> =
            jsonHandler<Eip155GetFeeQuoteResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun getFeeQuote(
            params: Eip155GetFeeQuoteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Eip155GetFeeQuoteResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("accountId", params.accountId().getOrNull())
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
                        "stocks",
                        "eip155",
                        "fee_quote",
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { getFeeQuoteHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val prepareOrderHandler: Handler<Eip155PrepareOrderResponse> =
            jsonHandler<Eip155PrepareOrderResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun prepareOrder(
            params: Eip155PrepareOrderParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Eip155PrepareOrderResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("accountId", params.accountId().getOrNull())
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
                        "stocks",
                        "eip155",
                        "prepare",
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { prepareOrderHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
