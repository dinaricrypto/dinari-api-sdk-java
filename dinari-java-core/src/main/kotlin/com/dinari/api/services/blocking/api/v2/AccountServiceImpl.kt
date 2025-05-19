// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.api.v2

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
import com.dinari.api.services.blocking.api.v2.accounts.OrderFulfillmentService
import com.dinari.api.services.blocking.api.v2.accounts.OrderFulfillmentServiceImpl
import com.dinari.api.services.blocking.api.v2.accounts.OrderRequestService
import com.dinari.api.services.blocking.api.v2.accounts.OrderRequestServiceImpl
import com.dinari.api.services.blocking.api.v2.accounts.OrderService
import com.dinari.api.services.blocking.api.v2.accounts.OrderServiceImpl
import com.dinari.api.services.blocking.api.v2.accounts.WalletService
import com.dinari.api.services.blocking.api.v2.accounts.WalletServiceImpl
import kotlin.jvm.optionals.getOrNull

class AccountServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    AccountService {

    private val withRawResponse: AccountService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val wallet: WalletService by lazy { WalletServiceImpl(clientOptions) }

    private val orders: OrderService by lazy { OrderServiceImpl(clientOptions) }

    private val orderFulfillments: OrderFulfillmentService by lazy {
        OrderFulfillmentServiceImpl(clientOptions)
    }

    private val orderRequests: OrderRequestService by lazy {
        OrderRequestServiceImpl(clientOptions)
    }

    override fun withRawResponse(): AccountService.WithRawResponse = withRawResponse

    override fun wallet(): WalletService = wallet

    override fun orders(): OrderService = orders

    override fun orderFulfillments(): OrderFulfillmentService = orderFulfillments

    override fun orderRequests(): OrderRequestService = orderRequests

    override fun retrieve(params: AccountRetrieveParams, requestOptions: RequestOptions): Account =
        // get /api/v2/accounts/{account_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun deactivate(
        params: AccountDeactivateParams,
        requestOptions: RequestOptions,
    ): Account =
        // post /api/v2/accounts/{account_id}/deactivate
        withRawResponse().deactivate(params, requestOptions).parse()

    override fun retrieveCash(
        params: AccountRetrieveCashParams,
        requestOptions: RequestOptions,
    ): List<AccountRetrieveCashResponse> =
        // get /api/v2/accounts/{account_id}/cash
        withRawResponse().retrieveCash(params, requestOptions).parse()

    override fun retrieveDividendPayments(
        params: AccountRetrieveDividendPaymentsParams,
        requestOptions: RequestOptions,
    ): List<AccountRetrieveDividendPaymentsResponse> =
        // get /api/v2/accounts/{account_id}/dividend_payments
        withRawResponse().retrieveDividendPayments(params, requestOptions).parse()

    override fun retrieveInterestPayments(
        params: AccountRetrieveInterestPaymentsParams,
        requestOptions: RequestOptions,
    ): List<AccountRetrieveInterestPaymentsResponse> =
        // get /api/v2/accounts/{account_id}/interest_payments
        withRawResponse().retrieveInterestPayments(params, requestOptions).parse()

    override fun retrievePortfolio(
        params: AccountRetrievePortfolioParams,
        requestOptions: RequestOptions,
    ): AccountRetrievePortfolioResponse =
        // get /api/v2/accounts/{account_id}/portfolio
        withRawResponse().retrievePortfolio(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AccountService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val wallet: WalletService.WithRawResponse by lazy {
            WalletServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val orders: OrderService.WithRawResponse by lazy {
            OrderServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val orderFulfillments: OrderFulfillmentService.WithRawResponse by lazy {
            OrderFulfillmentServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val orderRequests: OrderRequestService.WithRawResponse by lazy {
            OrderRequestServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun wallet(): WalletService.WithRawResponse = wallet

        override fun orders(): OrderService.WithRawResponse = orders

        override fun orderFulfillments(): OrderFulfillmentService.WithRawResponse =
            orderFulfillments

        override fun orderRequests(): OrderRequestService.WithRawResponse = orderRequests

        private val retrieveHandler: Handler<Account> =
            jsonHandler<Account>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun retrieve(
            params: AccountRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Account> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("accountId", params.accountId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("api", "v2", "accounts", params._pathParam(0))
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

        private val deactivateHandler: Handler<Account> =
            jsonHandler<Account>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun deactivate(
            params: AccountDeactivateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Account> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("accountId", params.accountId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("api", "v2", "accounts", params._pathParam(0), "deactivate")
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { deactivateHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveCashHandler: Handler<List<AccountRetrieveCashResponse>> =
            jsonHandler<List<AccountRetrieveCashResponse>>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun retrieveCash(
            params: AccountRetrieveCashParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<AccountRetrieveCashResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("accountId", params.accountId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("api", "v2", "accounts", params._pathParam(0), "cash")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { retrieveCashHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.forEach { it.validate() }
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
        ): HttpResponseFor<List<AccountRetrieveDividendPaymentsResponse>> {
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { retrieveDividendPaymentsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.forEach { it.validate() }
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
        ): HttpResponseFor<List<AccountRetrieveInterestPaymentsResponse>> {
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { retrieveInterestPaymentsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.forEach { it.validate() }
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
        ): HttpResponseFor<AccountRetrievePortfolioResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("accountId", params.accountId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("api", "v2", "accounts", params._pathParam(0), "portfolio")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
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
