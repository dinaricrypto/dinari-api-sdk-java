// File generated from our OpenAPI spec by Stainless.

package com.dinari.services.async.v2.accounts.orderrequests.stocks

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
import com.dinari.core.prepareAsync
import com.dinari.models.v2.accounts.orderrequests.OrderRequest
import com.dinari.models.v2.accounts.orderrequests.stocks.eip155.Eip155CreateProxiedOrderParams
import com.dinari.models.v2.accounts.orderrequests.stocks.eip155.Eip155PrepareProxiedOrderParams
import com.dinari.models.v2.accounts.orderrequests.stocks.eip155.Eip155PrepareProxiedOrderResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class Eip155ServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    Eip155ServiceAsync {

    private val withRawResponse: Eip155ServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): Eip155ServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): Eip155ServiceAsync =
        Eip155ServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun createProxiedOrder(
        params: Eip155CreateProxiedOrderParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<OrderRequest> =
        // post /api/v2/accounts/{account_id}/order_requests/stocks/eip155
        withRawResponse().createProxiedOrder(params, requestOptions).thenApply { it.parse() }

    override fun prepareProxiedOrder(
        params: Eip155PrepareProxiedOrderParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Eip155PrepareProxiedOrderResponse> =
        // post /api/v2/accounts/{account_id}/order_requests/stocks/eip155/prepare
        withRawResponse().prepareProxiedOrder(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        Eip155ServiceAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): Eip155ServiceAsync.WithRawResponse =
            Eip155ServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createProxiedOrderHandler: Handler<OrderRequest> =
            jsonHandler<OrderRequest>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun createProxiedOrder(
            params: Eip155CreateProxiedOrderParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<OrderRequest>> {
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
                        "order_requests",
                        "stocks",
                        "eip155",
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { createProxiedOrderHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val prepareProxiedOrderHandler: Handler<Eip155PrepareProxiedOrderResponse> =
            jsonHandler<Eip155PrepareProxiedOrderResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun prepareProxiedOrder(
            params: Eip155PrepareProxiedOrderParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Eip155PrepareProxiedOrderResponse>> {
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
                        "order_requests",
                        "stocks",
                        "eip155",
                        "prepare",
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { prepareProxiedOrderHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }
    }
}
