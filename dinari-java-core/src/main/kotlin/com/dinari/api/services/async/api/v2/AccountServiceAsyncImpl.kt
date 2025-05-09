// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.api.v2

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
import com.dinari.api.core.prepareAsync
import com.dinari.api.models.api.v2.accounts.AccountDeactivateParams
import com.dinari.api.models.api.v2.accounts.AccountRetrieveCashParams
import com.dinari.api.models.api.v2.accounts.AccountRetrieveCashResponse
import com.dinari.api.models.api.v2.accounts.AccountRetrieveDividendPaymentsParams
import com.dinari.api.models.api.v2.accounts.AccountRetrieveDividendPaymentsResponse
import com.dinari.api.models.api.v2.accounts.AccountRetrieveInterestPaymentsParams
import com.dinari.api.models.api.v2.accounts.AccountRetrieveInterestPaymentsResponse
import com.dinari.api.models.api.v2.accounts.AccountRetrieveParams
import com.dinari.api.models.api.v2.accounts.AccountRetrievePortfolioParams
import com.dinari.api.models.api.v2.accounts.AccountRetrievePortfolioResponse
import com.dinari.api.models.api.v2.entities.accounts.Account
import com.dinari.api.services.async.api.v2.accounts.OrderFulfillmentServiceAsync
import com.dinari.api.services.async.api.v2.accounts.OrderFulfillmentServiceAsyncImpl
import com.dinari.api.services.async.api.v2.accounts.OrderRequestServiceAsync
import com.dinari.api.services.async.api.v2.accounts.OrderRequestServiceAsyncImpl
import com.dinari.api.services.async.api.v2.accounts.OrderServiceAsync
import com.dinari.api.services.async.api.v2.accounts.OrderServiceAsyncImpl
import com.dinari.api.services.async.api.v2.accounts.WalletServiceAsync
import com.dinari.api.services.async.api.v2.accounts.WalletServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import kotlin.jvm.optionals.getOrNull

class AccountServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    AccountServiceAsync {

    private val withRawResponse: AccountServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val wallet: WalletServiceAsync by lazy { WalletServiceAsyncImpl(clientOptions) }

    private val orders: OrderServiceAsync by lazy { OrderServiceAsyncImpl(clientOptions) }

    private val orderFulfillments: OrderFulfillmentServiceAsync by lazy {
        OrderFulfillmentServiceAsyncImpl(clientOptions)
    }

    private val orderRequests: OrderRequestServiceAsync by lazy {
        OrderRequestServiceAsyncImpl(clientOptions)
    }

    override fun withRawResponse(): AccountServiceAsync.WithRawResponse = withRawResponse

    override fun wallet(): WalletServiceAsync = wallet

    override fun orders(): OrderServiceAsync = orders

    override fun orderFulfillments(): OrderFulfillmentServiceAsync = orderFulfillments

    override fun orderRequests(): OrderRequestServiceAsync = orderRequests

    override fun retrieve(
        params: AccountRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Account> =
        // get /api/v2/accounts/{account_id}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun deactivate(
        params: AccountDeactivateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Account> =
        // post /api/v2/accounts/{account_id}/deactivate
        withRawResponse().deactivate(params, requestOptions).thenApply { it.parse() }

    override fun retrieveCash(
        params: AccountRetrieveCashParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<AccountRetrieveCashResponse> =
        // get /api/v2/accounts/{account_id}/cash
        withRawResponse().retrieveCash(params, requestOptions).thenApply { it.parse() }

    override fun retrieveDividendPayments(
        params: AccountRetrieveDividendPaymentsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<AccountRetrieveDividendPaymentsResponse>> =
        // get /api/v2/accounts/{account_id}/dividend_payments
        withRawResponse().retrieveDividendPayments(params, requestOptions).thenApply { it.parse() }

    override fun retrieveInterestPayments(
        params: AccountRetrieveInterestPaymentsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<AccountRetrieveInterestPaymentsResponse>> =
        // get /api/v2/accounts/{account_id}/interest_payments
        withRawResponse().retrieveInterestPayments(params, requestOptions).thenApply { it.parse() }

    override fun retrievePortfolio(
        params: AccountRetrievePortfolioParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<AccountRetrievePortfolioResponse> =
        // get /api/v2/accounts/{account_id}/portfolio
        withRawResponse().retrievePortfolio(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AccountServiceAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val wallet: WalletServiceAsync.WithRawResponse by lazy {
            WalletServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val orders: OrderServiceAsync.WithRawResponse by lazy {
            OrderServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val orderFulfillments: OrderFulfillmentServiceAsync.WithRawResponse by lazy {
            OrderFulfillmentServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val orderRequests: OrderRequestServiceAsync.WithRawResponse by lazy {
            OrderRequestServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun wallet(): WalletServiceAsync.WithRawResponse = wallet

        override fun orders(): OrderServiceAsync.WithRawResponse = orders

        override fun orderFulfillments(): OrderFulfillmentServiceAsync.WithRawResponse =
            orderFulfillments

        override fun orderRequests(): OrderRequestServiceAsync.WithRawResponse = orderRequests

        private val retrieveHandler: Handler<Account> =
            jsonHandler<Account>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun retrieve(
            params: AccountRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Account>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("accountId", params.accountId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("api", "v2", "accounts", params._pathParam(0))
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

        private val deactivateHandler: Handler<Account> =
            jsonHandler<Account>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun deactivate(
            params: AccountDeactivateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Account>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("accountId", params.accountId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("api", "v2", "accounts", params._pathParam(0), "deactivate")
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { deactivateHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val retrieveCashHandler: Handler<AccountRetrieveCashResponse> =
            jsonHandler<AccountRetrieveCashResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun retrieveCash(
            params: AccountRetrieveCashParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<AccountRetrieveCashResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("accountId", params.accountId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("api", "v2", "accounts", params._pathParam(0), "cash")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { retrieveCashHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val retrieveDividendPaymentsHandler:
            Handler<List<AccountRetrieveDividendPaymentsResponse>> =
            jsonHandler<List<AccountRetrieveDividendPaymentsResponse>>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun retrieveDividendPayments(
            params: AccountRetrieveDividendPaymentsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<AccountRetrieveDividendPaymentsResponse>>> {
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
                        "dividend_payments",
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { retrieveDividendPaymentsHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.forEach { it.validate() }
                                }
                            }
                    }
                }
        }

        private val retrieveInterestPaymentsHandler:
            Handler<List<AccountRetrieveInterestPaymentsResponse>> =
            jsonHandler<List<AccountRetrieveInterestPaymentsResponse>>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun retrieveInterestPayments(
            params: AccountRetrieveInterestPaymentsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<AccountRetrieveInterestPaymentsResponse>>> {
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
                        "interest_payments",
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { retrieveInterestPaymentsHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.forEach { it.validate() }
                                }
                            }
                    }
                }
        }

        private val retrievePortfolioHandler: Handler<AccountRetrievePortfolioResponse> =
            jsonHandler<AccountRetrievePortfolioResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun retrievePortfolio(
            params: AccountRetrievePortfolioParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<AccountRetrievePortfolioResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("accountId", params.accountId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("api", "v2", "accounts", params._pathParam(0), "portfolio")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { retrievePortfolioHandler.handle(it) }
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
