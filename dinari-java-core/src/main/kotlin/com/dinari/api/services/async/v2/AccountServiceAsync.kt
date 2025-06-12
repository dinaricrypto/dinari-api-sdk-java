// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.v2

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponse
import com.dinari.api.core.http.HttpResponseFor
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
import com.dinari.api.services.async.v2.accounts.OrderFulfillmentServiceAsync
import com.dinari.api.services.async.v2.accounts.OrderRequestServiceAsync
import com.dinari.api.services.async.v2.accounts.OrderServiceAsync
import com.dinari.api.services.async.v2.accounts.WalletServiceAsync
import com.dinari.api.services.async.v2.accounts.WithdrawalRequestServiceAsync
import com.dinari.api.services.async.v2.accounts.WithdrawalServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface AccountServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AccountServiceAsync

    fun wallet(): WalletServiceAsync

    fun orders(): OrderServiceAsync

    fun orderFulfillments(): OrderFulfillmentServiceAsync

    fun orderRequests(): OrderRequestServiceAsync

    fun withdrawalRequests(): WithdrawalRequestServiceAsync

    fun withdrawals(): WithdrawalServiceAsync

    /** Get a specific `Account` by its ID. */
    fun retrieve(accountId: String): CompletableFuture<Account> =
        retrieve(accountId, AccountRetrieveParams.none())

    /** @see [retrieve] */
    fun retrieve(
        accountId: String,
        params: AccountRetrieveParams = AccountRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Account> =
        retrieve(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [retrieve] */
    fun retrieve(
        accountId: String,
        params: AccountRetrieveParams = AccountRetrieveParams.none(),
    ): CompletableFuture<Account> = retrieve(accountId, params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: AccountRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Account>

    /** @see [retrieve] */
    fun retrieve(params: AccountRetrieveParams): CompletableFuture<Account> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(accountId: String, requestOptions: RequestOptions): CompletableFuture<Account> =
        retrieve(accountId, AccountRetrieveParams.none(), requestOptions)

    /** Set the `Account` to be inactive. Inactive accounts cannot be used for trading. */
    fun deactivate(accountId: String): CompletableFuture<Account> =
        deactivate(accountId, AccountDeactivateParams.none())

    /** @see [deactivate] */
    fun deactivate(
        accountId: String,
        params: AccountDeactivateParams = AccountDeactivateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Account> =
        deactivate(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [deactivate] */
    fun deactivate(
        accountId: String,
        params: AccountDeactivateParams = AccountDeactivateParams.none(),
    ): CompletableFuture<Account> = deactivate(accountId, params, RequestOptions.none())

    /** @see [deactivate] */
    fun deactivate(
        params: AccountDeactivateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Account>

    /** @see [deactivate] */
    fun deactivate(params: AccountDeactivateParams): CompletableFuture<Account> =
        deactivate(params, RequestOptions.none())

    /** @see [deactivate] */
    fun deactivate(accountId: String, requestOptions: RequestOptions): CompletableFuture<Account> =
        deactivate(accountId, AccountDeactivateParams.none(), requestOptions)

    /** Get the cash balances of the `Account`, including stablecoins and other cash equivalents. */
    fun getCashBalances(
        accountId: String
    ): CompletableFuture<List<AccountGetCashBalancesResponse>> =
        getCashBalances(accountId, AccountGetCashBalancesParams.none())

    /** @see [getCashBalances] */
    fun getCashBalances(
        accountId: String,
        params: AccountGetCashBalancesParams = AccountGetCashBalancesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<AccountGetCashBalancesResponse>> =
        getCashBalances(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [getCashBalances] */
    fun getCashBalances(
        accountId: String,
        params: AccountGetCashBalancesParams = AccountGetCashBalancesParams.none(),
    ): CompletableFuture<List<AccountGetCashBalancesResponse>> =
        getCashBalances(accountId, params, RequestOptions.none())

    /** @see [getCashBalances] */
    fun getCashBalances(
        params: AccountGetCashBalancesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<AccountGetCashBalancesResponse>>

    /** @see [getCashBalances] */
    fun getCashBalances(
        params: AccountGetCashBalancesParams
    ): CompletableFuture<List<AccountGetCashBalancesResponse>> =
        getCashBalances(params, RequestOptions.none())

    /** @see [getCashBalances] */
    fun getCashBalances(
        accountId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<AccountGetCashBalancesResponse>> =
        getCashBalances(accountId, AccountGetCashBalancesParams.none(), requestOptions)

    /** Get dividend payments made to the `Account` from dividend-bearing stock holdings. */
    fun getDividendPayments(
        accountId: String,
        params: AccountGetDividendPaymentsParams,
    ): CompletableFuture<List<AccountGetDividendPaymentsResponse>> =
        getDividendPayments(accountId, params, RequestOptions.none())

    /** @see [getDividendPayments] */
    fun getDividendPayments(
        accountId: String,
        params: AccountGetDividendPaymentsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<AccountGetDividendPaymentsResponse>> =
        getDividendPayments(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [getDividendPayments] */
    fun getDividendPayments(
        params: AccountGetDividendPaymentsParams
    ): CompletableFuture<List<AccountGetDividendPaymentsResponse>> =
        getDividendPayments(params, RequestOptions.none())

    /** @see [getDividendPayments] */
    fun getDividendPayments(
        params: AccountGetDividendPaymentsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<AccountGetDividendPaymentsResponse>>

    /**
     * Get interest payments made to the `Account` from yield-bearing cash holdings.
     *
     * Currently, the only yield-bearing stablecoin accepted by Dinari is
     * [USD+](https://usd.dinari.com/).
     */
    fun getInterestPayments(
        accountId: String,
        params: AccountGetInterestPaymentsParams,
    ): CompletableFuture<List<AccountGetInterestPaymentsResponse>> =
        getInterestPayments(accountId, params, RequestOptions.none())

    /** @see [getInterestPayments] */
    fun getInterestPayments(
        accountId: String,
        params: AccountGetInterestPaymentsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<AccountGetInterestPaymentsResponse>> =
        getInterestPayments(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [getInterestPayments] */
    fun getInterestPayments(
        params: AccountGetInterestPaymentsParams
    ): CompletableFuture<List<AccountGetInterestPaymentsResponse>> =
        getInterestPayments(params, RequestOptions.none())

    /** @see [getInterestPayments] */
    fun getInterestPayments(
        params: AccountGetInterestPaymentsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<AccountGetInterestPaymentsResponse>>

    /** Get the portfolio of the `Account`, excluding cash equivalents such as stablecoins. */
    fun getPortfolio(accountId: String): CompletableFuture<AccountGetPortfolioResponse> =
        getPortfolio(accountId, AccountGetPortfolioParams.none())

    /** @see [getPortfolio] */
    fun getPortfolio(
        accountId: String,
        params: AccountGetPortfolioParams = AccountGetPortfolioParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AccountGetPortfolioResponse> =
        getPortfolio(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [getPortfolio] */
    fun getPortfolio(
        accountId: String,
        params: AccountGetPortfolioParams = AccountGetPortfolioParams.none(),
    ): CompletableFuture<AccountGetPortfolioResponse> =
        getPortfolio(accountId, params, RequestOptions.none())

    /** @see [getPortfolio] */
    fun getPortfolio(
        params: AccountGetPortfolioParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AccountGetPortfolioResponse>

    /** @see [getPortfolio] */
    fun getPortfolio(
        params: AccountGetPortfolioParams
    ): CompletableFuture<AccountGetPortfolioResponse> = getPortfolio(params, RequestOptions.none())

    /** @see [getPortfolio] */
    fun getPortfolio(
        accountId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<AccountGetPortfolioResponse> =
        getPortfolio(accountId, AccountGetPortfolioParams.none(), requestOptions)

    /**
     * Mints 1,000 mockUSD sandbox payment tokens to the `Wallet` connected to the `Account`.
     *
     * This feature is only supported in sandbox mode.
     */
    fun mintSandboxTokens(accountId: String): CompletableFuture<Void?> =
        mintSandboxTokens(accountId, AccountMintSandboxTokensParams.none())

    /** @see [mintSandboxTokens] */
    fun mintSandboxTokens(
        accountId: String,
        params: AccountMintSandboxTokensParams = AccountMintSandboxTokensParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> =
        mintSandboxTokens(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [mintSandboxTokens] */
    fun mintSandboxTokens(
        accountId: String,
        params: AccountMintSandboxTokensParams = AccountMintSandboxTokensParams.none(),
    ): CompletableFuture<Void?> = mintSandboxTokens(accountId, params, RequestOptions.none())

    /** @see [mintSandboxTokens] */
    fun mintSandboxTokens(
        params: AccountMintSandboxTokensParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /** @see [mintSandboxTokens] */
    fun mintSandboxTokens(params: AccountMintSandboxTokensParams): CompletableFuture<Void?> =
        mintSandboxTokens(params, RequestOptions.none())

    /** @see [mintSandboxTokens] */
    fun mintSandboxTokens(
        accountId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<Void?> =
        mintSandboxTokens(accountId, AccountMintSandboxTokensParams.none(), requestOptions)

    /**
     * A view of [AccountServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AccountServiceAsync.WithRawResponse

        fun wallet(): WalletServiceAsync.WithRawResponse

        fun orders(): OrderServiceAsync.WithRawResponse

        fun orderFulfillments(): OrderFulfillmentServiceAsync.WithRawResponse

        fun orderRequests(): OrderRequestServiceAsync.WithRawResponse

        fun withdrawalRequests(): WithdrawalRequestServiceAsync.WithRawResponse

        fun withdrawals(): WithdrawalServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}`, but is otherwise the
         * same as [AccountServiceAsync.retrieve].
         */
        fun retrieve(accountId: String): CompletableFuture<HttpResponseFor<Account>> =
            retrieve(accountId, AccountRetrieveParams.none())

        /** @see [retrieve] */
        fun retrieve(
            accountId: String,
            params: AccountRetrieveParams = AccountRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Account>> =
            retrieve(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [retrieve] */
        fun retrieve(
            accountId: String,
            params: AccountRetrieveParams = AccountRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<Account>> =
            retrieve(accountId, params, RequestOptions.none())

        /** @see [retrieve] */
        fun retrieve(
            params: AccountRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Account>>

        /** @see [retrieve] */
        fun retrieve(params: AccountRetrieveParams): CompletableFuture<HttpResponseFor<Account>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        fun retrieve(
            accountId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Account>> =
            retrieve(accountId, AccountRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /api/v2/accounts/{account_id}/deactivate`, but is
         * otherwise the same as [AccountServiceAsync.deactivate].
         */
        fun deactivate(accountId: String): CompletableFuture<HttpResponseFor<Account>> =
            deactivate(accountId, AccountDeactivateParams.none())

        /** @see [deactivate] */
        fun deactivate(
            accountId: String,
            params: AccountDeactivateParams = AccountDeactivateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Account>> =
            deactivate(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [deactivate] */
        fun deactivate(
            accountId: String,
            params: AccountDeactivateParams = AccountDeactivateParams.none(),
        ): CompletableFuture<HttpResponseFor<Account>> =
            deactivate(accountId, params, RequestOptions.none())

        /** @see [deactivate] */
        fun deactivate(
            params: AccountDeactivateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Account>>

        /** @see [deactivate] */
        fun deactivate(
            params: AccountDeactivateParams
        ): CompletableFuture<HttpResponseFor<Account>> = deactivate(params, RequestOptions.none())

        /** @see [deactivate] */
        fun deactivate(
            accountId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Account>> =
            deactivate(accountId, AccountDeactivateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/cash`, but is
         * otherwise the same as [AccountServiceAsync.getCashBalances].
         */
        fun getCashBalances(
            accountId: String
        ): CompletableFuture<HttpResponseFor<List<AccountGetCashBalancesResponse>>> =
            getCashBalances(accountId, AccountGetCashBalancesParams.none())

        /** @see [getCashBalances] */
        fun getCashBalances(
            accountId: String,
            params: AccountGetCashBalancesParams = AccountGetCashBalancesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<AccountGetCashBalancesResponse>>> =
            getCashBalances(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [getCashBalances] */
        fun getCashBalances(
            accountId: String,
            params: AccountGetCashBalancesParams = AccountGetCashBalancesParams.none(),
        ): CompletableFuture<HttpResponseFor<List<AccountGetCashBalancesResponse>>> =
            getCashBalances(accountId, params, RequestOptions.none())

        /** @see [getCashBalances] */
        fun getCashBalances(
            params: AccountGetCashBalancesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<AccountGetCashBalancesResponse>>>

        /** @see [getCashBalances] */
        fun getCashBalances(
            params: AccountGetCashBalancesParams
        ): CompletableFuture<HttpResponseFor<List<AccountGetCashBalancesResponse>>> =
            getCashBalances(params, RequestOptions.none())

        /** @see [getCashBalances] */
        fun getCashBalances(
            accountId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<AccountGetCashBalancesResponse>>> =
            getCashBalances(accountId, AccountGetCashBalancesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/dividend_payments`,
         * but is otherwise the same as [AccountServiceAsync.getDividendPayments].
         */
        fun getDividendPayments(
            accountId: String,
            params: AccountGetDividendPaymentsParams,
        ): CompletableFuture<HttpResponseFor<List<AccountGetDividendPaymentsResponse>>> =
            getDividendPayments(accountId, params, RequestOptions.none())

        /** @see [getDividendPayments] */
        fun getDividendPayments(
            accountId: String,
            params: AccountGetDividendPaymentsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<AccountGetDividendPaymentsResponse>>> =
            getDividendPayments(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [getDividendPayments] */
        fun getDividendPayments(
            params: AccountGetDividendPaymentsParams
        ): CompletableFuture<HttpResponseFor<List<AccountGetDividendPaymentsResponse>>> =
            getDividendPayments(params, RequestOptions.none())

        /** @see [getDividendPayments] */
        fun getDividendPayments(
            params: AccountGetDividendPaymentsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<AccountGetDividendPaymentsResponse>>>

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/interest_payments`,
         * but is otherwise the same as [AccountServiceAsync.getInterestPayments].
         */
        fun getInterestPayments(
            accountId: String,
            params: AccountGetInterestPaymentsParams,
        ): CompletableFuture<HttpResponseFor<List<AccountGetInterestPaymentsResponse>>> =
            getInterestPayments(accountId, params, RequestOptions.none())

        /** @see [getInterestPayments] */
        fun getInterestPayments(
            accountId: String,
            params: AccountGetInterestPaymentsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<AccountGetInterestPaymentsResponse>>> =
            getInterestPayments(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [getInterestPayments] */
        fun getInterestPayments(
            params: AccountGetInterestPaymentsParams
        ): CompletableFuture<HttpResponseFor<List<AccountGetInterestPaymentsResponse>>> =
            getInterestPayments(params, RequestOptions.none())

        /** @see [getInterestPayments] */
        fun getInterestPayments(
            params: AccountGetInterestPaymentsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<AccountGetInterestPaymentsResponse>>>

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/portfolio`, but is
         * otherwise the same as [AccountServiceAsync.getPortfolio].
         */
        fun getPortfolio(
            accountId: String
        ): CompletableFuture<HttpResponseFor<AccountGetPortfolioResponse>> =
            getPortfolio(accountId, AccountGetPortfolioParams.none())

        /** @see [getPortfolio] */
        fun getPortfolio(
            accountId: String,
            params: AccountGetPortfolioParams = AccountGetPortfolioParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AccountGetPortfolioResponse>> =
            getPortfolio(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [getPortfolio] */
        fun getPortfolio(
            accountId: String,
            params: AccountGetPortfolioParams = AccountGetPortfolioParams.none(),
        ): CompletableFuture<HttpResponseFor<AccountGetPortfolioResponse>> =
            getPortfolio(accountId, params, RequestOptions.none())

        /** @see [getPortfolio] */
        fun getPortfolio(
            params: AccountGetPortfolioParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AccountGetPortfolioResponse>>

        /** @see [getPortfolio] */
        fun getPortfolio(
            params: AccountGetPortfolioParams
        ): CompletableFuture<HttpResponseFor<AccountGetPortfolioResponse>> =
            getPortfolio(params, RequestOptions.none())

        /** @see [getPortfolio] */
        fun getPortfolio(
            accountId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<AccountGetPortfolioResponse>> =
            getPortfolio(accountId, AccountGetPortfolioParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /api/v2/accounts/{account_id}/faucet`, but is
         * otherwise the same as [AccountServiceAsync.mintSandboxTokens].
         */
        fun mintSandboxTokens(accountId: String): CompletableFuture<HttpResponse> =
            mintSandboxTokens(accountId, AccountMintSandboxTokensParams.none())

        /** @see [mintSandboxTokens] */
        fun mintSandboxTokens(
            accountId: String,
            params: AccountMintSandboxTokensParams = AccountMintSandboxTokensParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            mintSandboxTokens(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [mintSandboxTokens] */
        fun mintSandboxTokens(
            accountId: String,
            params: AccountMintSandboxTokensParams = AccountMintSandboxTokensParams.none(),
        ): CompletableFuture<HttpResponse> =
            mintSandboxTokens(accountId, params, RequestOptions.none())

        /** @see [mintSandboxTokens] */
        fun mintSandboxTokens(
            params: AccountMintSandboxTokensParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /** @see [mintSandboxTokens] */
        fun mintSandboxTokens(
            params: AccountMintSandboxTokensParams
        ): CompletableFuture<HttpResponse> = mintSandboxTokens(params, RequestOptions.none())

        /** @see [mintSandboxTokens] */
        fun mintSandboxTokens(
            accountId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> =
            mintSandboxTokens(accountId, AccountMintSandboxTokensParams.none(), requestOptions)
    }
}
