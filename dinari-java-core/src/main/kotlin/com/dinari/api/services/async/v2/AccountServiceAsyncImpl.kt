// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.v2

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.checkRequired
import com.dinari.api.core.handlers.emptyHandler
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
import com.dinari.api.services.async.v2.accounts.ActivityServiceAsync
import com.dinari.api.services.async.v2.accounts.ActivityServiceAsyncImpl
import com.dinari.api.services.async.v2.accounts.OrderFulfillmentServiceAsync
import com.dinari.api.services.async.v2.accounts.OrderFulfillmentServiceAsyncImpl
import com.dinari.api.services.async.v2.accounts.OrderRequestServiceAsync
import com.dinari.api.services.async.v2.accounts.OrderRequestServiceAsyncImpl
import com.dinari.api.services.async.v2.accounts.OrderServiceAsync
import com.dinari.api.services.async.v2.accounts.OrderServiceAsyncImpl
import com.dinari.api.services.async.v2.accounts.TokenTransferServiceAsync
import com.dinari.api.services.async.v2.accounts.TokenTransferServiceAsyncImpl
import com.dinari.api.services.async.v2.accounts.WalletServiceAsync
import com.dinari.api.services.async.v2.accounts.WalletServiceAsyncImpl
import com.dinari.api.services.async.v2.accounts.WithdrawalRequestServiceAsync
import com.dinari.api.services.async.v2.accounts.WithdrawalRequestServiceAsyncImpl
import com.dinari.api.services.async.v2.accounts.WithdrawalServiceAsync
import com.dinari.api.services.async.v2.accounts.WithdrawalServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

/**
 * **`Accounts` represent the financial accounts of an `Entity`.**
 *
 * `Orders`, dividends, and other transactions are associated with an `Account`.
 */
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

    private val withdrawalRequests: WithdrawalRequestServiceAsync by lazy {
        WithdrawalRequestServiceAsyncImpl(clientOptions)
    }

    private val withdrawals: WithdrawalServiceAsync by lazy {
        WithdrawalServiceAsyncImpl(clientOptions)
    }

    private val tokenTransfers: TokenTransferServiceAsync by lazy {
        TokenTransferServiceAsyncImpl(clientOptions)
    }

    private val activities: ActivityServiceAsync by lazy { ActivityServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): AccountServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): AccountServiceAsync =
        AccountServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    /**
     * **`Wallets` represent the blockchain wallet that holds the assets of an `Account`.**
     *
     * An `Account` may be connected to a single `Wallet`.
     *
     * Individual `Entities` can connect their self-custodied `Wallets` by proving ownership of the
     * `Wallet` address. For Dinari Partners, a Dinari-managed `Wallet` can be created for the
     * Partner `Entity` in the [Dinari Partners Portal](https://Partners.dinari.com/). This may be
     * used in omnibus accounting for self-managing customers' assets.
     */
    override fun wallet(): WalletServiceAsync = wallet

    /**
     * **`Orders` represent the buying and selling of assets under an `Account`.**
     *
     * For `Accounts` using self-custodied `Wallets`, `Orders` are created and fulfilled by making
     * calls to Dinari's smart contracts, or using the *Proxied Orders* methods.
     *
     * For `Accounts` using managed `Wallets`, `Orders` are created and fulfilled by using the
     * `Managed Orders` methods, which then create the corresponding transactions on the blockchain.
     */
    override fun orders(): OrderServiceAsync = orders

    /**
     * **`Orders` represent the buying and selling of assets under an `Account`.**
     *
     * For `Accounts` using self-custodied `Wallets`, `Orders` are created and fulfilled by making
     * calls to Dinari's smart contracts, or using the *Proxied Orders* methods.
     *
     * For `Accounts` using managed `Wallets`, `Orders` are created and fulfilled by using the
     * `Managed Orders` methods, which then create the corresponding transactions on the blockchain.
     */
    override fun orderFulfillments(): OrderFulfillmentServiceAsync = orderFulfillments

    override fun orderRequests(): OrderRequestServiceAsync = orderRequests

    /**
     * **`Withdrawals` represent the transfer of stablecoins from an `Account` connected to a
     * managed `Wallet` to another `Account` that is owned by the `Entity`.**
     *
     * Since the `Account` is backed by a managed `Wallet`, the `Withdrawal` must be processed by
     * Dinari and the corresponding transaction is submitted on chain.
     *
     * Upon requesting a withdrawal, a `WithdrawalRequest` is created, which is then submitted on
     * chain by Dinari. Once the transfer is submitted on chain, the corresponding `Withdrawal` is
     * created.
     *
     * Currently, withdrawals are made in USDC on the Arbitrum network (Chain ID `eip155:42161`).
     */
    override fun withdrawalRequests(): WithdrawalRequestServiceAsync = withdrawalRequests

    /**
     * **`Withdrawals` represent the transfer of stablecoins from an `Account` connected to a
     * managed `Wallet` to another `Account` that is owned by the `Entity`.**
     *
     * Since the `Account` is backed by a managed `Wallet`, the `Withdrawal` must be processed by
     * Dinari and the corresponding transaction is submitted on chain.
     *
     * Upon requesting a withdrawal, a `WithdrawalRequest` is created, which is then submitted on
     * chain by Dinari. Once the transfer is submitted on chain, the corresponding `Withdrawal` is
     * created.
     *
     * Currently, withdrawals are made in USDC on the Arbitrum network (Chain ID `eip155:42161`).
     */
    override fun withdrawals(): WithdrawalServiceAsync = withdrawals

    /**
     * **`Accounts` represent the financial accounts of an `Entity`.**
     *
     * `Orders`, dividends, and other transactions are associated with an `Account`.
     */
    override fun tokenTransfers(): TokenTransferServiceAsync = tokenTransfers

    /**
     * **`Accounts` represent the financial accounts of an `Entity`.**
     *
     * `Orders`, dividends, and other transactions are associated with an `Account`.
     */
    override fun activities(): ActivityServiceAsync = activities

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

    override fun getCashBalances(
        params: AccountGetCashBalancesParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<AccountGetCashBalancesResponse>> =
        // get /api/v2/accounts/{account_id}/cash
        withRawResponse().getCashBalances(params, requestOptions).thenApply { it.parse() }

    override fun getDividendPayments(
        params: AccountGetDividendPaymentsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<AccountGetDividendPaymentsResponse> =
        // get /api/v2/accounts/{account_id}/dividend_payments
        withRawResponse().getDividendPayments(params, requestOptions).thenApply { it.parse() }

    override fun getInterestPayments(
        params: AccountGetInterestPaymentsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<AccountGetInterestPaymentsResponse> =
        // get /api/v2/accounts/{account_id}/interest_payments
        withRawResponse().getInterestPayments(params, requestOptions).thenApply { it.parse() }

    override fun getPortfolio(
        params: AccountGetPortfolioParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<AccountGetPortfolioResponse> =
        // get /api/v2/accounts/{account_id}/portfolio
        withRawResponse().getPortfolio(params, requestOptions).thenApply { it.parse() }

    override fun mintSandboxTokens(
        params: AccountMintSandboxTokensParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Void?> =
        // post /api/v2/accounts/{account_id}/faucet
        withRawResponse().mintSandboxTokens(params, requestOptions).thenAccept {}

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AccountServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

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

        private val withdrawalRequests: WithdrawalRequestServiceAsync.WithRawResponse by lazy {
            WithdrawalRequestServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val withdrawals: WithdrawalServiceAsync.WithRawResponse by lazy {
            WithdrawalServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val tokenTransfers: TokenTransferServiceAsync.WithRawResponse by lazy {
            TokenTransferServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val activities: ActivityServiceAsync.WithRawResponse by lazy {
            ActivityServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AccountServiceAsync.WithRawResponse =
            AccountServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        /**
         * **`Wallets` represent the blockchain wallet that holds the assets of an `Account`.**
         *
         * An `Account` may be connected to a single `Wallet`.
         *
         * Individual `Entities` can connect their self-custodied `Wallets` by proving ownership of
         * the `Wallet` address. For Dinari Partners, a Dinari-managed `Wallet` can be created for
         * the Partner `Entity` in the [Dinari Partners Portal](https://Partners.dinari.com/). This
         * may be used in omnibus accounting for self-managing customers' assets.
         */
        override fun wallet(): WalletServiceAsync.WithRawResponse = wallet

        /**
         * **`Orders` represent the buying and selling of assets under an `Account`.**
         *
         * For `Accounts` using self-custodied `Wallets`, `Orders` are created and fulfilled by
         * making calls to Dinari's smart contracts, or using the *Proxied Orders* methods.
         *
         * For `Accounts` using managed `Wallets`, `Orders` are created and fulfilled by using the
         * `Managed Orders` methods, which then create the corresponding transactions on the
         * blockchain.
         */
        override fun orders(): OrderServiceAsync.WithRawResponse = orders

        /**
         * **`Orders` represent the buying and selling of assets under an `Account`.**
         *
         * For `Accounts` using self-custodied `Wallets`, `Orders` are created and fulfilled by
         * making calls to Dinari's smart contracts, or using the *Proxied Orders* methods.
         *
         * For `Accounts` using managed `Wallets`, `Orders` are created and fulfilled by using the
         * `Managed Orders` methods, which then create the corresponding transactions on the
         * blockchain.
         */
        override fun orderFulfillments(): OrderFulfillmentServiceAsync.WithRawResponse =
            orderFulfillments

        override fun orderRequests(): OrderRequestServiceAsync.WithRawResponse = orderRequests

        /**
         * **`Withdrawals` represent the transfer of stablecoins from an `Account` connected to a
         * managed `Wallet` to another `Account` that is owned by the `Entity`.**
         *
         * Since the `Account` is backed by a managed `Wallet`, the `Withdrawal` must be processed
         * by Dinari and the corresponding transaction is submitted on chain.
         *
         * Upon requesting a withdrawal, a `WithdrawalRequest` is created, which is then submitted
         * on chain by Dinari. Once the transfer is submitted on chain, the corresponding
         * `Withdrawal` is created.
         *
         * Currently, withdrawals are made in USDC on the Arbitrum network (Chain ID
         * `eip155:42161`).
         */
        override fun withdrawalRequests(): WithdrawalRequestServiceAsync.WithRawResponse =
            withdrawalRequests

        /**
         * **`Withdrawals` represent the transfer of stablecoins from an `Account` connected to a
         * managed `Wallet` to another `Account` that is owned by the `Entity`.**
         *
         * Since the `Account` is backed by a managed `Wallet`, the `Withdrawal` must be processed
         * by Dinari and the corresponding transaction is submitted on chain.
         *
         * Upon requesting a withdrawal, a `WithdrawalRequest` is created, which is then submitted
         * on chain by Dinari. Once the transfer is submitted on chain, the corresponding
         * `Withdrawal` is created.
         *
         * Currently, withdrawals are made in USDC on the Arbitrum network (Chain ID
         * `eip155:42161`).
         */
        override fun withdrawals(): WithdrawalServiceAsync.WithRawResponse = withdrawals

        /**
         * **`Accounts` represent the financial accounts of an `Entity`.**
         *
         * `Orders`, dividends, and other transactions are associated with an `Account`.
         */
        override fun tokenTransfers(): TokenTransferServiceAsync.WithRawResponse = tokenTransfers

        /**
         * **`Accounts` represent the financial accounts of an `Entity`.**
         *
         * `Orders`, dividends, and other transactions are associated with an `Account`.
         */
        override fun activities(): ActivityServiceAsync.WithRawResponse = activities

        private val retrieveHandler: Handler<Account> =
            jsonHandler<Account>(clientOptions.jsonMapper)

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
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v2", "accounts", params._pathParam(0))
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

        private val deactivateHandler: Handler<Account> =
            jsonHandler<Account>(clientOptions.jsonMapper)

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
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v2", "accounts", params._pathParam(0), "deactivate")
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
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

        private val getCashBalancesHandler: Handler<List<AccountGetCashBalancesResponse>> =
            jsonHandler<List<AccountGetCashBalancesResponse>>(clientOptions.jsonMapper)

        override fun getCashBalances(
            params: AccountGetCashBalancesParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<AccountGetCashBalancesResponse>>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("accountId", params.accountId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v2", "accounts", params._pathParam(0), "cash")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { getCashBalancesHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.forEach { it.validate() }
                                }
                            }
                    }
                }
        }

        private val getDividendPaymentsHandler: Handler<AccountGetDividendPaymentsResponse> =
            jsonHandler<AccountGetDividendPaymentsResponse>(clientOptions.jsonMapper)

        override fun getDividendPayments(
            params: AccountGetDividendPaymentsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<AccountGetDividendPaymentsResponse>> {
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
                        "dividend_payments",
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { getDividendPaymentsHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val getInterestPaymentsHandler: Handler<AccountGetInterestPaymentsResponse> =
            jsonHandler<AccountGetInterestPaymentsResponse>(clientOptions.jsonMapper)

        override fun getInterestPayments(
            params: AccountGetInterestPaymentsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<AccountGetInterestPaymentsResponse>> {
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
                        "interest_payments",
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { getInterestPaymentsHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val getPortfolioHandler: Handler<AccountGetPortfolioResponse> =
            jsonHandler<AccountGetPortfolioResponse>(clientOptions.jsonMapper)

        override fun getPortfolio(
            params: AccountGetPortfolioParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<AccountGetPortfolioResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("accountId", params.accountId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v2", "accounts", params._pathParam(0), "portfolio")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { getPortfolioHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val mintSandboxTokensHandler: Handler<Void?> = emptyHandler()

        override fun mintSandboxTokens(
            params: AccountMintSandboxTokensParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("accountId", params.accountId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v2", "accounts", params._pathParam(0), "faucet")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response.use { mintSandboxTokensHandler.handle(it) }
                    }
                }
        }
    }
}
