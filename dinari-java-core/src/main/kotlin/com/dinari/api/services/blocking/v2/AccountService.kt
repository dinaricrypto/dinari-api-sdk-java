// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2

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
import com.dinari.api.services.blocking.v2.accounts.OrderFulfillmentService
import com.dinari.api.services.blocking.v2.accounts.OrderRequestService
import com.dinari.api.services.blocking.v2.accounts.OrderService
import com.dinari.api.services.blocking.v2.accounts.TokenTransferService
import com.dinari.api.services.blocking.v2.accounts.WalletService
import com.dinari.api.services.blocking.v2.accounts.WithdrawalRequestService
import com.dinari.api.services.blocking.v2.accounts.WithdrawalService
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface AccountService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AccountService

    fun wallet(): WalletService

    fun orders(): OrderService

    fun orderFulfillments(): OrderFulfillmentService

    fun orderRequests(): OrderRequestService

    fun withdrawalRequests(): WithdrawalRequestService

    fun withdrawals(): WithdrawalService

    fun tokenTransfers(): TokenTransferService

    /** Get a specific `Account` by its ID. */
    fun retrieve(accountId: String): Account = retrieve(accountId, AccountRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        accountId: String,
        params: AccountRetrieveParams = AccountRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Account = retrieve(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        accountId: String,
        params: AccountRetrieveParams = AccountRetrieveParams.none(),
    ): Account = retrieve(accountId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: AccountRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Account

    /** @see retrieve */
    fun retrieve(params: AccountRetrieveParams): Account = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(accountId: String, requestOptions: RequestOptions): Account =
        retrieve(accountId, AccountRetrieveParams.none(), requestOptions)

    /** Set the `Account` to be inactive. Inactive accounts cannot be used for trading. */
    fun deactivate(accountId: String): Account =
        deactivate(accountId, AccountDeactivateParams.none())

    /** @see deactivate */
    fun deactivate(
        accountId: String,
        params: AccountDeactivateParams = AccountDeactivateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Account = deactivate(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see deactivate */
    fun deactivate(
        accountId: String,
        params: AccountDeactivateParams = AccountDeactivateParams.none(),
    ): Account = deactivate(accountId, params, RequestOptions.none())

    /** @see deactivate */
    fun deactivate(
        params: AccountDeactivateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Account

    /** @see deactivate */
    fun deactivate(params: AccountDeactivateParams): Account =
        deactivate(params, RequestOptions.none())

    /** @see deactivate */
    fun deactivate(accountId: String, requestOptions: RequestOptions): Account =
        deactivate(accountId, AccountDeactivateParams.none(), requestOptions)

    /** Get the cash balances of the `Account`, including stablecoins and other cash equivalents. */
    fun getCashBalances(accountId: String): List<AccountGetCashBalancesResponse> =
        getCashBalances(accountId, AccountGetCashBalancesParams.none())

    /** @see getCashBalances */
    fun getCashBalances(
        accountId: String,
        params: AccountGetCashBalancesParams = AccountGetCashBalancesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<AccountGetCashBalancesResponse> =
        getCashBalances(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see getCashBalances */
    fun getCashBalances(
        accountId: String,
        params: AccountGetCashBalancesParams = AccountGetCashBalancesParams.none(),
    ): List<AccountGetCashBalancesResponse> =
        getCashBalances(accountId, params, RequestOptions.none())

    /** @see getCashBalances */
    fun getCashBalances(
        params: AccountGetCashBalancesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<AccountGetCashBalancesResponse>

    /** @see getCashBalances */
    fun getCashBalances(
        params: AccountGetCashBalancesParams
    ): List<AccountGetCashBalancesResponse> = getCashBalances(params, RequestOptions.none())

    /** @see getCashBalances */
    fun getCashBalances(
        accountId: String,
        requestOptions: RequestOptions,
    ): List<AccountGetCashBalancesResponse> =
        getCashBalances(accountId, AccountGetCashBalancesParams.none(), requestOptions)

    /** Get dividend payments made to the `Account` from dividend-bearing stock holdings. */
    fun getDividendPayments(
        accountId: String,
        params: AccountGetDividendPaymentsParams,
    ): List<AccountGetDividendPaymentsResponse> =
        getDividendPayments(accountId, params, RequestOptions.none())

    /** @see getDividendPayments */
    fun getDividendPayments(
        accountId: String,
        params: AccountGetDividendPaymentsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<AccountGetDividendPaymentsResponse> =
        getDividendPayments(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see getDividendPayments */
    fun getDividendPayments(
        params: AccountGetDividendPaymentsParams
    ): List<AccountGetDividendPaymentsResponse> = getDividendPayments(params, RequestOptions.none())

    /** @see getDividendPayments */
    fun getDividendPayments(
        params: AccountGetDividendPaymentsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<AccountGetDividendPaymentsResponse>

    /**
     * Get interest payments made to the `Account` from yield-bearing cash holdings.
     *
     * Currently, the only yield-bearing stablecoin accepted by Dinari is
     * [USD+](https://usd.dinari.com/).
     */
    fun getInterestPayments(
        accountId: String,
        params: AccountGetInterestPaymentsParams,
    ): List<AccountGetInterestPaymentsResponse> =
        getInterestPayments(accountId, params, RequestOptions.none())

    /** @see getInterestPayments */
    fun getInterestPayments(
        accountId: String,
        params: AccountGetInterestPaymentsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<AccountGetInterestPaymentsResponse> =
        getInterestPayments(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see getInterestPayments */
    fun getInterestPayments(
        params: AccountGetInterestPaymentsParams
    ): List<AccountGetInterestPaymentsResponse> = getInterestPayments(params, RequestOptions.none())

    /** @see getInterestPayments */
    fun getInterestPayments(
        params: AccountGetInterestPaymentsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<AccountGetInterestPaymentsResponse>

    /** Get the portfolio of the `Account`, excluding cash equivalents such as stablecoins. */
    fun getPortfolio(accountId: String): AccountGetPortfolioResponse =
        getPortfolio(accountId, AccountGetPortfolioParams.none())

    /** @see getPortfolio */
    fun getPortfolio(
        accountId: String,
        params: AccountGetPortfolioParams = AccountGetPortfolioParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccountGetPortfolioResponse =
        getPortfolio(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see getPortfolio */
    fun getPortfolio(
        accountId: String,
        params: AccountGetPortfolioParams = AccountGetPortfolioParams.none(),
    ): AccountGetPortfolioResponse = getPortfolio(accountId, params, RequestOptions.none())

    /** @see getPortfolio */
    fun getPortfolio(
        params: AccountGetPortfolioParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccountGetPortfolioResponse

    /** @see getPortfolio */
    fun getPortfolio(params: AccountGetPortfolioParams): AccountGetPortfolioResponse =
        getPortfolio(params, RequestOptions.none())

    /** @see getPortfolio */
    fun getPortfolio(
        accountId: String,
        requestOptions: RequestOptions,
    ): AccountGetPortfolioResponse =
        getPortfolio(accountId, AccountGetPortfolioParams.none(), requestOptions)

    /**
     * Mints 1,000 mockUSD sandbox payment tokens to the `Wallet` connected to the `Account`.
     *
     * This feature is only supported in sandbox mode.
     */
    fun mintSandboxTokens(accountId: String) =
        mintSandboxTokens(accountId, AccountMintSandboxTokensParams.none())

    /** @see mintSandboxTokens */
    fun mintSandboxTokens(
        accountId: String,
        params: AccountMintSandboxTokensParams = AccountMintSandboxTokensParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = mintSandboxTokens(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see mintSandboxTokens */
    fun mintSandboxTokens(
        accountId: String,
        params: AccountMintSandboxTokensParams = AccountMintSandboxTokensParams.none(),
    ) = mintSandboxTokens(accountId, params, RequestOptions.none())

    /** @see mintSandboxTokens */
    fun mintSandboxTokens(
        params: AccountMintSandboxTokensParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** @see mintSandboxTokens */
    fun mintSandboxTokens(params: AccountMintSandboxTokensParams) =
        mintSandboxTokens(params, RequestOptions.none())

    /** @see mintSandboxTokens */
    fun mintSandboxTokens(accountId: String, requestOptions: RequestOptions) =
        mintSandboxTokens(accountId, AccountMintSandboxTokensParams.none(), requestOptions)

    /** A view of [AccountService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): AccountService.WithRawResponse

        fun wallet(): WalletService.WithRawResponse

        fun orders(): OrderService.WithRawResponse

        fun orderFulfillments(): OrderFulfillmentService.WithRawResponse

        fun orderRequests(): OrderRequestService.WithRawResponse

        fun withdrawalRequests(): WithdrawalRequestService.WithRawResponse

        fun withdrawals(): WithdrawalService.WithRawResponse

        fun tokenTransfers(): TokenTransferService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}`, but is otherwise the
         * same as [AccountService.retrieve].
         */
        @MustBeClosed
        fun retrieve(accountId: String): HttpResponseFor<Account> =
            retrieve(accountId, AccountRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            accountId: String,
            params: AccountRetrieveParams = AccountRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Account> =
            retrieve(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            accountId: String,
            params: AccountRetrieveParams = AccountRetrieveParams.none(),
        ): HttpResponseFor<Account> = retrieve(accountId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: AccountRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Account>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: AccountRetrieveParams): HttpResponseFor<Account> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(accountId: String, requestOptions: RequestOptions): HttpResponseFor<Account> =
            retrieve(accountId, AccountRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /api/v2/accounts/{account_id}/deactivate`, but is
         * otherwise the same as [AccountService.deactivate].
         */
        @MustBeClosed
        fun deactivate(accountId: String): HttpResponseFor<Account> =
            deactivate(accountId, AccountDeactivateParams.none())

        /** @see deactivate */
        @MustBeClosed
        fun deactivate(
            accountId: String,
            params: AccountDeactivateParams = AccountDeactivateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Account> =
            deactivate(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see deactivate */
        @MustBeClosed
        fun deactivate(
            accountId: String,
            params: AccountDeactivateParams = AccountDeactivateParams.none(),
        ): HttpResponseFor<Account> = deactivate(accountId, params, RequestOptions.none())

        /** @see deactivate */
        @MustBeClosed
        fun deactivate(
            params: AccountDeactivateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Account>

        /** @see deactivate */
        @MustBeClosed
        fun deactivate(params: AccountDeactivateParams): HttpResponseFor<Account> =
            deactivate(params, RequestOptions.none())

        /** @see deactivate */
        @MustBeClosed
        fun deactivate(
            accountId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Account> =
            deactivate(accountId, AccountDeactivateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/cash`, but is
         * otherwise the same as [AccountService.getCashBalances].
         */
        @MustBeClosed
        fun getCashBalances(
            accountId: String
        ): HttpResponseFor<List<AccountGetCashBalancesResponse>> =
            getCashBalances(accountId, AccountGetCashBalancesParams.none())

        /** @see getCashBalances */
        @MustBeClosed
        fun getCashBalances(
            accountId: String,
            params: AccountGetCashBalancesParams = AccountGetCashBalancesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<AccountGetCashBalancesResponse>> =
            getCashBalances(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see getCashBalances */
        @MustBeClosed
        fun getCashBalances(
            accountId: String,
            params: AccountGetCashBalancesParams = AccountGetCashBalancesParams.none(),
        ): HttpResponseFor<List<AccountGetCashBalancesResponse>> =
            getCashBalances(accountId, params, RequestOptions.none())

        /** @see getCashBalances */
        @MustBeClosed
        fun getCashBalances(
            params: AccountGetCashBalancesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<AccountGetCashBalancesResponse>>

        /** @see getCashBalances */
        @MustBeClosed
        fun getCashBalances(
            params: AccountGetCashBalancesParams
        ): HttpResponseFor<List<AccountGetCashBalancesResponse>> =
            getCashBalances(params, RequestOptions.none())

        /** @see getCashBalances */
        @MustBeClosed
        fun getCashBalances(
            accountId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<AccountGetCashBalancesResponse>> =
            getCashBalances(accountId, AccountGetCashBalancesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/dividend_payments`,
         * but is otherwise the same as [AccountService.getDividendPayments].
         */
        @MustBeClosed
        fun getDividendPayments(
            accountId: String,
            params: AccountGetDividendPaymentsParams,
        ): HttpResponseFor<List<AccountGetDividendPaymentsResponse>> =
            getDividendPayments(accountId, params, RequestOptions.none())

        /** @see getDividendPayments */
        @MustBeClosed
        fun getDividendPayments(
            accountId: String,
            params: AccountGetDividendPaymentsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<AccountGetDividendPaymentsResponse>> =
            getDividendPayments(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see getDividendPayments */
        @MustBeClosed
        fun getDividendPayments(
            params: AccountGetDividendPaymentsParams
        ): HttpResponseFor<List<AccountGetDividendPaymentsResponse>> =
            getDividendPayments(params, RequestOptions.none())

        /** @see getDividendPayments */
        @MustBeClosed
        fun getDividendPayments(
            params: AccountGetDividendPaymentsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<AccountGetDividendPaymentsResponse>>

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/interest_payments`,
         * but is otherwise the same as [AccountService.getInterestPayments].
         */
        @MustBeClosed
        fun getInterestPayments(
            accountId: String,
            params: AccountGetInterestPaymentsParams,
        ): HttpResponseFor<List<AccountGetInterestPaymentsResponse>> =
            getInterestPayments(accountId, params, RequestOptions.none())

        /** @see getInterestPayments */
        @MustBeClosed
        fun getInterestPayments(
            accountId: String,
            params: AccountGetInterestPaymentsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<AccountGetInterestPaymentsResponse>> =
            getInterestPayments(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see getInterestPayments */
        @MustBeClosed
        fun getInterestPayments(
            params: AccountGetInterestPaymentsParams
        ): HttpResponseFor<List<AccountGetInterestPaymentsResponse>> =
            getInterestPayments(params, RequestOptions.none())

        /** @see getInterestPayments */
        @MustBeClosed
        fun getInterestPayments(
            params: AccountGetInterestPaymentsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<AccountGetInterestPaymentsResponse>>

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/portfolio`, but is
         * otherwise the same as [AccountService.getPortfolio].
         */
        @MustBeClosed
        fun getPortfolio(accountId: String): HttpResponseFor<AccountGetPortfolioResponse> =
            getPortfolio(accountId, AccountGetPortfolioParams.none())

        /** @see getPortfolio */
        @MustBeClosed
        fun getPortfolio(
            accountId: String,
            params: AccountGetPortfolioParams = AccountGetPortfolioParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccountGetPortfolioResponse> =
            getPortfolio(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see getPortfolio */
        @MustBeClosed
        fun getPortfolio(
            accountId: String,
            params: AccountGetPortfolioParams = AccountGetPortfolioParams.none(),
        ): HttpResponseFor<AccountGetPortfolioResponse> =
            getPortfolio(accountId, params, RequestOptions.none())

        /** @see getPortfolio */
        @MustBeClosed
        fun getPortfolio(
            params: AccountGetPortfolioParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccountGetPortfolioResponse>

        /** @see getPortfolio */
        @MustBeClosed
        fun getPortfolio(
            params: AccountGetPortfolioParams
        ): HttpResponseFor<AccountGetPortfolioResponse> =
            getPortfolio(params, RequestOptions.none())

        /** @see getPortfolio */
        @MustBeClosed
        fun getPortfolio(
            accountId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AccountGetPortfolioResponse> =
            getPortfolio(accountId, AccountGetPortfolioParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /api/v2/accounts/{account_id}/faucet`, but is
         * otherwise the same as [AccountService.mintSandboxTokens].
         */
        @MustBeClosed
        fun mintSandboxTokens(accountId: String): HttpResponse =
            mintSandboxTokens(accountId, AccountMintSandboxTokensParams.none())

        /** @see mintSandboxTokens */
        @MustBeClosed
        fun mintSandboxTokens(
            accountId: String,
            params: AccountMintSandboxTokensParams = AccountMintSandboxTokensParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse =
            mintSandboxTokens(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see mintSandboxTokens */
        @MustBeClosed
        fun mintSandboxTokens(
            accountId: String,
            params: AccountMintSandboxTokensParams = AccountMintSandboxTokensParams.none(),
        ): HttpResponse = mintSandboxTokens(accountId, params, RequestOptions.none())

        /** @see mintSandboxTokens */
        @MustBeClosed
        fun mintSandboxTokens(
            params: AccountMintSandboxTokensParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see mintSandboxTokens */
        @MustBeClosed
        fun mintSandboxTokens(params: AccountMintSandboxTokensParams): HttpResponse =
            mintSandboxTokens(params, RequestOptions.none())

        /** @see mintSandboxTokens */
        @MustBeClosed
        fun mintSandboxTokens(accountId: String, requestOptions: RequestOptions): HttpResponse =
            mintSandboxTokens(accountId, AccountMintSandboxTokensParams.none(), requestOptions)
    }
}
