// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.v2.accounts

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
import com.dinari.api.core.prepareAsync
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequest
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestCreateLimitBuyParams
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestCreateLimitSellParams
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestCreateMarketBuyParams
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestCreateMarketSellParams
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestGetFeeQuoteParams
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestGetFeeQuoteResponse
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestListParams
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestRetrieveParams
import com.dinari.api.services.async.v2.accounts.orderrequests.Eip155ServiceAsync
import com.dinari.api.services.async.v2.accounts.orderrequests.Eip155ServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class OrderRequestServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    OrderRequestServiceAsync {

    private val withRawResponse: OrderRequestServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val eip155: Eip155ServiceAsync by lazy { Eip155ServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): OrderRequestServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): OrderRequestServiceAsync =
        OrderRequestServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun eip155(): Eip155ServiceAsync = eip155

    override fun retrieve(
        params: OrderRequestRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<OrderRequest> =
        // get /api/v2/accounts/{account_id}/order_requests/{order_request_id}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: OrderRequestListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<OrderRequest>> =
        // get /api/v2/accounts/{account_id}/order_requests
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun createLimitBuy(
        params: OrderRequestCreateLimitBuyParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<OrderRequest> =
        // post /api/v2/accounts/{account_id}/order_requests/limit_buy
        withRawResponse().createLimitBuy(params, requestOptions).thenApply { it.parse() }

    override fun createLimitSell(
        params: OrderRequestCreateLimitSellParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<OrderRequest> =
        // post /api/v2/accounts/{account_id}/order_requests/limit_sell
        withRawResponse().createLimitSell(params, requestOptions).thenApply { it.parse() }

    override fun createMarketBuy(
        params: OrderRequestCreateMarketBuyParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<OrderRequest> =
        // post /api/v2/accounts/{account_id}/order_requests/market_buy
        withRawResponse().createMarketBuy(params, requestOptions).thenApply { it.parse() }

    override fun createMarketSell(
        params: OrderRequestCreateMarketSellParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<OrderRequest> =
        // post /api/v2/accounts/{account_id}/order_requests/market_sell
        withRawResponse().createMarketSell(params, requestOptions).thenApply { it.parse() }

    override fun getFeeQuote(
        params: OrderRequestGetFeeQuoteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<OrderRequestGetFeeQuoteResponse> =
        // post /api/v2/accounts/{account_id}/order_requests/fee_quote
        withRawResponse().getFeeQuote(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        OrderRequestServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val eip155: Eip155ServiceAsync.WithRawResponse by lazy {
            Eip155ServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): OrderRequestServiceAsync.WithRawResponse =
            OrderRequestServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun eip155(): Eip155ServiceAsync.WithRawResponse = eip155

        private val retrieveHandler: Handler<OrderRequest> =
            jsonHandler<OrderRequest>(clientOptions.jsonMapper)

        override fun retrieve(
            params: OrderRequestRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<OrderRequest>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("orderRequestId", params.orderRequestId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "api",
                        "v2",
                        "accounts",
                        params._pathParam(0),
                        "order_requests",
                        params._pathParam(1),
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
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

        private val listHandler: Handler<List<OrderRequest>> =
            jsonHandler<List<OrderRequest>>(clientOptions.jsonMapper)

        override fun list(
            params: OrderRequestListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<OrderRequest>>> {
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
                        "order_requests",
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { listHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.forEach { it.validate() }
                                }
                            }
                    }
                }
        }

        private val createLimitBuyHandler: Handler<OrderRequest> =
            jsonHandler<OrderRequest>(clientOptions.jsonMapper)

        override fun createLimitBuy(
            params: OrderRequestCreateLimitBuyParams,
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
                        "limit_buy",
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { createLimitBuyHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val createLimitSellHandler: Handler<OrderRequest> =
            jsonHandler<OrderRequest>(clientOptions.jsonMapper)

        override fun createLimitSell(
            params: OrderRequestCreateLimitSellParams,
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
                        "limit_sell",
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { createLimitSellHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val createMarketBuyHandler: Handler<OrderRequest> =
            jsonHandler<OrderRequest>(clientOptions.jsonMapper)

        override fun createMarketBuy(
            params: OrderRequestCreateMarketBuyParams,
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
                        "market_buy",
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { createMarketBuyHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val createMarketSellHandler: Handler<OrderRequest> =
            jsonHandler<OrderRequest>(clientOptions.jsonMapper)

        override fun createMarketSell(
            params: OrderRequestCreateMarketSellParams,
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
                        "market_sell",
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
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

        private val getFeeQuoteHandler: Handler<OrderRequestGetFeeQuoteResponse> =
            jsonHandler<OrderRequestGetFeeQuoteResponse>(clientOptions.jsonMapper)

        override fun getFeeQuote(
            params: OrderRequestGetFeeQuoteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<OrderRequestGetFeeQuoteResponse>> {
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
                        "fee_quote",
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { getFeeQuoteHandler.handle(it) }
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
