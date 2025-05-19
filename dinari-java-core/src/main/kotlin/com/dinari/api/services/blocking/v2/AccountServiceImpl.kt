// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.JsonValue
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.checkRequired
import com.dinari.api.core.handlers.emptyHandler
import com.dinari.api.core.handlers.errorHandler
import com.dinari.api.core.handlers.jsonHandler
import com.dinari.api.core.handlers.withErrorHandler
import com.dinari.api.core.http.HttpMethod
import com.dinari.api.core.http.HttpRequest
import com.dinari.api.core.http.HttpResponse
import com.dinari.api.core.http.HttpResponse.Handler
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.core.http.json
import com.dinari.api.core.http.parseable
import com.dinari.api.core.prepare
import com.dinari.api.models.v2.accounts.AccountDeactivateParams
import com.dinari.api.models.v2.accounts.AccountGetCashBalancesParams
import com.dinari.api.models.v2.accounts.AccountGetCashBalancesResponse
import com.dinari.api.models.v2.accounts.AccountGetDividendPaymentsParams
import com.dinari.api.models.v2.accounts.AccountGetDividendPaymentsResponse
import com.dinari.api.models.v2.accounts.AccountGetInterestPaymentsParams
import com.dinari.api.models.v2.accounts.AccountGetInterestPaymentsResponse
import com.dinari.api.models.v2.accounts.AccountGetPortfolioParams
import com.dinari.api.models.v2.accounts.AccountGetPortfolioResponse
import com.dinari.api.models.v2.accounts.AccountMintSandboxTokensParams
import com.dinari.api.models.v2.accounts.AccountRetrieveParams
import com.dinari.api.models.v2.entities.accounts.Account
import com.dinari.api.services.blocking.v2.accounts.OrderFulfillmentService
import com.dinari.api.services.blocking.v2.accounts.OrderFulfillmentServiceImpl
import com.dinari.api.services.blocking.v2.accounts.OrderRequestService
import com.dinari.api.services.blocking.v2.accounts.OrderRequestServiceImpl
import com.dinari.api.services.blocking.v2.accounts.OrderService
import com.dinari.api.services.blocking.v2.accounts.OrderServiceImpl
import com.dinari.api.services.blocking.v2.accounts.WalletService
import com.dinari.api.services.blocking.v2.accounts.WalletServiceImpl
import com.dinari.api.services.blocking.v2.accounts.WithdrawalRequestService
import com.dinari.api.services.blocking.v2.accounts.WithdrawalRequestServiceImpl
import com.dinari.api.services.blocking.v2.accounts.WithdrawalService
import com.dinari.api.services.blocking.v2.accounts.WithdrawalServiceImpl
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

    private val withdrawalRequests: WithdrawalRequestService by lazy {
        WithdrawalRequestServiceImpl(clientOptions)
    }

    private val withdrawals: WithdrawalService by lazy { WithdrawalServiceImpl(clientOptions) }

    override fun withRawResponse(): AccountService.WithRawResponse = withRawResponse

    override fun wallet(): WalletService = wallet

    override fun orders(): OrderService = orders

    override fun orderFulfillments(): OrderFulfillmentService = orderFulfillments

    override fun orderRequests(): OrderRequestService = orderRequests

    override fun withdrawalRequests(): WithdrawalRequestService = withdrawalRequests

    override fun withdrawals(): WithdrawalService = withdrawals

    override fun retrieve(params: AccountRetrieveParams, requestOptions: RequestOptions): Account =
        // get /api/v2/accounts/{account_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun deactivate(
        params: AccountDeactivateParams,
        requestOptions: RequestOptions,
    ): Account =
        // post /api/v2/accounts/{account_id}/deactivate
        withRawResponse().deactivate(params, requestOptions).parse()

    override fun getCashBalances(
        params: AccountGetCashBalancesParams,
        requestOptions: RequestOptions,
    ): List<AccountGetCashBalancesResponse> =
        // get /api/v2/accounts/{account_id}/cash
        withRawResponse().getCashBalances(params, requestOptions).parse()

    override fun getDividendPayments(
        params: AccountGetDividendPaymentsParams,
        requestOptions: RequestOptions,
    ): List<AccountGetDividendPaymentsResponse> =
        // get /api/v2/accounts/{account_id}/dividend_payments
        withRawResponse().getDividendPayments(params, requestOptions).parse()

    override fun getInterestPayments(
        params: AccountGetInterestPaymentsParams,
        requestOptions: RequestOptions,
    ): List<AccountGetInterestPaymentsResponse> =
        // get /api/v2/accounts/{account_id}/interest_payments
        withRawResponse().getInterestPayments(params, requestOptions).parse()

    override fun getPortfolio(
        params: AccountGetPortfolioParams,
        requestOptions: RequestOptions,
    ): AccountGetPortfolioResponse =
        // get /api/v2/accounts/{account_id}/portfolio
        withRawResponse().getPortfolio(params, requestOptions).parse()

    override fun mintSandboxTokens(
        params: AccountMintSandboxTokensParams,
        requestOptions: RequestOptions,
    ) {
        // post /api/v2/accounts/{account_id}/faucet
        withRawResponse().mintSandboxTokens(params, requestOptions)
    }

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

        private val withdrawalRequests: WithdrawalRequestService.WithRawResponse by lazy {
            WithdrawalRequestServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val withdrawals: WithdrawalService.WithRawResponse by lazy {
            WithdrawalServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun wallet(): WalletService.WithRawResponse = wallet

        override fun orders(): OrderService.WithRawResponse = orders

        override fun orderFulfillments(): OrderFulfillmentService.WithRawResponse =
            orderFulfillments

        override fun orderRequests(): OrderRequestService.WithRawResponse = orderRequests

        override fun withdrawalRequests(): WithdrawalRequestService.WithRawResponse =
            withdrawalRequests

        override fun withdrawals(): WithdrawalService.WithRawResponse = withdrawals

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

        private val getCashBalancesHandler: Handler<List<AccountGetCashBalancesResponse>> =
            jsonHandler<List<AccountGetCashBalancesResponse>>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun getCashBalances(
            params: AccountGetCashBalancesParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<AccountGetCashBalancesResponse>> {
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
                    .use { getCashBalancesHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.forEach { it.validate() }
                        }
                    }
            }
        }

        private val getDividendPaymentsHandler: Handler<List<AccountGetDividendPaymentsResponse>> =
            jsonHandler<List<AccountGetDividendPaymentsResponse>>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun getDividendPayments(
            params: AccountGetDividendPaymentsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<AccountGetDividendPaymentsResponse>> {
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
                    .use { getDividendPaymentsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.forEach { it.validate() }
                        }
                    }
            }
        }

        private val getInterestPaymentsHandler: Handler<List<AccountGetInterestPaymentsResponse>> =
            jsonHandler<List<AccountGetInterestPaymentsResponse>>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun getInterestPayments(
            params: AccountGetInterestPaymentsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<AccountGetInterestPaymentsResponse>> {
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
                    .use { getInterestPaymentsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.forEach { it.validate() }
                        }
                    }
            }
        }

        private val getPortfolioHandler: Handler<AccountGetPortfolioResponse> =
            jsonHandler<AccountGetPortfolioResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun getPortfolio(
            params: AccountGetPortfolioParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AccountGetPortfolioResponse> {
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
                    .use { getPortfolioHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val mintSandboxTokensHandler: Handler<Void?> =
            emptyHandler().withErrorHandler(errorHandler)

        override fun mintSandboxTokens(
            params: AccountMintSandboxTokensParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("accountId", params.accountId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("api", "v2", "accounts", params._pathParam(0), "faucet")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable { response.use { mintSandboxTokensHandler.handle(it) } }
        }
    }
}
