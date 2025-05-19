// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.api.v2

import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
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
import com.dinari.api.services.async.api.v2.accounts.OrderRequestServiceAsync
import com.dinari.api.services.async.api.v2.accounts.OrderServiceAsync
import com.dinari.api.services.async.api.v2.accounts.WalletServiceAsync
import com.google.errorprone.annotations.MustBeClosed
import java.util.concurrent.CompletableFuture

interface AccountServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun wallet(): WalletServiceAsync

    fun orders(): OrderServiceAsync

    fun orderFulfillments(): OrderFulfillmentServiceAsync

    fun orderRequests(): OrderRequestServiceAsync

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
    fun retrieveCash(accountId: String): CompletableFuture<List<AccountRetrieveCashResponse>> =
        retrieveCash(accountId, AccountRetrieveCashParams.none())

    /** @see [retrieveCash] */
    fun retrieveCash(
        accountId: String,
        params: AccountRetrieveCashParams = AccountRetrieveCashParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<AccountRetrieveCashResponse>> =
        retrieveCash(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [retrieveCash] */
    fun retrieveCash(
        accountId: String,
        params: AccountRetrieveCashParams = AccountRetrieveCashParams.none(),
    ): CompletableFuture<List<AccountRetrieveCashResponse>> =
        retrieveCash(accountId, params, RequestOptions.none())

    /** @see [retrieveCash] */
    fun retrieveCash(
        params: AccountRetrieveCashParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<AccountRetrieveCashResponse>>

    /** @see [retrieveCash] */
    fun retrieveCash(
        params: AccountRetrieveCashParams
    ): CompletableFuture<List<AccountRetrieveCashResponse>> =
        retrieveCash(params, RequestOptions.none())

    /** @see [retrieveCash] */
    fun retrieveCash(
        accountId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<AccountRetrieveCashResponse>> =
        retrieveCash(accountId, AccountRetrieveCashParams.none(), requestOptions)

    /** Get dividend payments made to the `Account` from dividend-bearing stock holdings. */
    fun retrieveDividendPayments(
        accountId: String,
        params: AccountRetrieveDividendPaymentsParams,
    ): CompletableFuture<List<AccountRetrieveDividendPaymentsResponse>> =
        retrieveDividendPayments(accountId, params, RequestOptions.none())

    /** @see [retrieveDividendPayments] */
    fun retrieveDividendPayments(
        accountId: String,
        params: AccountRetrieveDividendPaymentsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<AccountRetrieveDividendPaymentsResponse>> =
        retrieveDividendPayments(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [retrieveDividendPayments] */
    fun retrieveDividendPayments(
        params: AccountRetrieveDividendPaymentsParams
    ): CompletableFuture<List<AccountRetrieveDividendPaymentsResponse>> =
        retrieveDividendPayments(params, RequestOptions.none())

    /** @see [retrieveDividendPayments] */
    fun retrieveDividendPayments(
        params: AccountRetrieveDividendPaymentsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<AccountRetrieveDividendPaymentsResponse>>

    /**
     * Get interest payments made to the `Account` from yield-bearing cash holdings.
     *
     * Currently, the only yield-bearing stablecoin accepted by Dinari is
     * [USD+](https://usd.dinari.com/).
     */
    fun retrieveInterestPayments(
        accountId: String,
        params: AccountRetrieveInterestPaymentsParams,
    ): CompletableFuture<List<AccountRetrieveInterestPaymentsResponse>> =
        retrieveInterestPayments(accountId, params, RequestOptions.none())

    /** @see [retrieveInterestPayments] */
    fun retrieveInterestPayments(
        accountId: String,
        params: AccountRetrieveInterestPaymentsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<AccountRetrieveInterestPaymentsResponse>> =
        retrieveInterestPayments(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [retrieveInterestPayments] */
    fun retrieveInterestPayments(
        params: AccountRetrieveInterestPaymentsParams
    ): CompletableFuture<List<AccountRetrieveInterestPaymentsResponse>> =
        retrieveInterestPayments(params, RequestOptions.none())

    /** @see [retrieveInterestPayments] */
    fun retrieveInterestPayments(
        params: AccountRetrieveInterestPaymentsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<AccountRetrieveInterestPaymentsResponse>>

    /** Get the portfolio of the `Account`, excluding cash equivalents such as stablecoins. */
    fun retrievePortfolio(accountId: String): CompletableFuture<AccountRetrievePortfolioResponse> =
        retrievePortfolio(accountId, AccountRetrievePortfolioParams.none())

    /** @see [retrievePortfolio] */
    fun retrievePortfolio(
        accountId: String,
        params: AccountRetrievePortfolioParams = AccountRetrievePortfolioParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AccountRetrievePortfolioResponse> =
        retrievePortfolio(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [retrievePortfolio] */
    fun retrievePortfolio(
        accountId: String,
        params: AccountRetrievePortfolioParams = AccountRetrievePortfolioParams.none(),
    ): CompletableFuture<AccountRetrievePortfolioResponse> =
        retrievePortfolio(accountId, params, RequestOptions.none())

    /** @see [retrievePortfolio] */
    fun retrievePortfolio(
        params: AccountRetrievePortfolioParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AccountRetrievePortfolioResponse>

    /** @see [retrievePortfolio] */
    fun retrievePortfolio(
        params: AccountRetrievePortfolioParams
    ): CompletableFuture<AccountRetrievePortfolioResponse> =
        retrievePortfolio(params, RequestOptions.none())

    /** @see [retrievePortfolio] */
    fun retrievePortfolio(
        accountId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<AccountRetrievePortfolioResponse> =
        retrievePortfolio(accountId, AccountRetrievePortfolioParams.none(), requestOptions)

    /**
     * A view of [AccountServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        fun wallet(): WalletServiceAsync.WithRawResponse

        fun orders(): OrderServiceAsync.WithRawResponse

        fun orderFulfillments(): OrderFulfillmentServiceAsync.WithRawResponse

        fun orderRequests(): OrderRequestServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}`, but is otherwise the
         * same as [AccountServiceAsync.retrieve].
         */
        @MustBeClosed
        fun retrieve(accountId: String): CompletableFuture<HttpResponseFor<Account>> =
            retrieve(accountId, AccountRetrieveParams.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            accountId: String,
            params: AccountRetrieveParams = AccountRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Account>> =
            retrieve(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            accountId: String,
            params: AccountRetrieveParams = AccountRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<Account>> =
            retrieve(accountId, params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: AccountRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Account>>

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(params: AccountRetrieveParams): CompletableFuture<HttpResponseFor<Account>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            accountId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Account>> =
            retrieve(accountId, AccountRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /api/v2/accounts/{account_id}/deactivate`, but is
         * otherwise the same as [AccountServiceAsync.deactivate].
         */
        @MustBeClosed
        fun deactivate(accountId: String): CompletableFuture<HttpResponseFor<Account>> =
            deactivate(accountId, AccountDeactivateParams.none())

        /** @see [deactivate] */
        @MustBeClosed
        fun deactivate(
            accountId: String,
            params: AccountDeactivateParams = AccountDeactivateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Account>> =
            deactivate(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [deactivate] */
        @MustBeClosed
        fun deactivate(
            accountId: String,
            params: AccountDeactivateParams = AccountDeactivateParams.none(),
        ): CompletableFuture<HttpResponseFor<Account>> =
            deactivate(accountId, params, RequestOptions.none())

        /** @see [deactivate] */
        @MustBeClosed
        fun deactivate(
            params: AccountDeactivateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Account>>

        /** @see [deactivate] */
        @MustBeClosed
        fun deactivate(
            params: AccountDeactivateParams
        ): CompletableFuture<HttpResponseFor<Account>> = deactivate(params, RequestOptions.none())

        /** @see [deactivate] */
        @MustBeClosed
        fun deactivate(
            accountId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Account>> =
            deactivate(accountId, AccountDeactivateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/cash`, but is
         * otherwise the same as [AccountServiceAsync.retrieveCash].
         */
        @MustBeClosed
        fun retrieveCash(
            accountId: String
        ): CompletableFuture<HttpResponseFor<List<AccountRetrieveCashResponse>>> =
            retrieveCash(accountId, AccountRetrieveCashParams.none())

        /** @see [retrieveCash] */
        @MustBeClosed
        fun retrieveCash(
            accountId: String,
            params: AccountRetrieveCashParams = AccountRetrieveCashParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<AccountRetrieveCashResponse>>> =
            retrieveCash(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [retrieveCash] */
        @MustBeClosed
        fun retrieveCash(
            accountId: String,
            params: AccountRetrieveCashParams = AccountRetrieveCashParams.none(),
        ): CompletableFuture<HttpResponseFor<List<AccountRetrieveCashResponse>>> =
            retrieveCash(accountId, params, RequestOptions.none())

        /** @see [retrieveCash] */
        @MustBeClosed
        fun retrieveCash(
            params: AccountRetrieveCashParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<AccountRetrieveCashResponse>>>

        /** @see [retrieveCash] */
        @MustBeClosed
        fun retrieveCash(
            params: AccountRetrieveCashParams
        ): CompletableFuture<HttpResponseFor<List<AccountRetrieveCashResponse>>> =
            retrieveCash(params, RequestOptions.none())

        /** @see [retrieveCash] */
        @MustBeClosed
        fun retrieveCash(
            accountId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<AccountRetrieveCashResponse>>> =
            retrieveCash(accountId, AccountRetrieveCashParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/dividend_payments`,
         * but is otherwise the same as [AccountServiceAsync.retrieveDividendPayments].
         */
        @MustBeClosed
        fun retrieveDividendPayments(
            accountId: String,
            params: AccountRetrieveDividendPaymentsParams,
        ): CompletableFuture<HttpResponseFor<List<AccountRetrieveDividendPaymentsResponse>>> =
            retrieveDividendPayments(accountId, params, RequestOptions.none())

        /** @see [retrieveDividendPayments] */
        @MustBeClosed
        fun retrieveDividendPayments(
            accountId: String,
            params: AccountRetrieveDividendPaymentsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<AccountRetrieveDividendPaymentsResponse>>> =
            retrieveDividendPayments(
                params.toBuilder().accountId(accountId).build(),
                requestOptions,
            )

        /** @see [retrieveDividendPayments] */
        @MustBeClosed
        fun retrieveDividendPayments(
            params: AccountRetrieveDividendPaymentsParams
        ): CompletableFuture<HttpResponseFor<List<AccountRetrieveDividendPaymentsResponse>>> =
            retrieveDividendPayments(params, RequestOptions.none())

        /** @see [retrieveDividendPayments] */
        @MustBeClosed
        fun retrieveDividendPayments(
            params: AccountRetrieveDividendPaymentsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<AccountRetrieveDividendPaymentsResponse>>>

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/interest_payments`,
         * but is otherwise the same as [AccountServiceAsync.retrieveInterestPayments].
         */
        @MustBeClosed
        fun retrieveInterestPayments(
            accountId: String,
            params: AccountRetrieveInterestPaymentsParams,
        ): CompletableFuture<HttpResponseFor<List<AccountRetrieveInterestPaymentsResponse>>> =
            retrieveInterestPayments(accountId, params, RequestOptions.none())

        /** @see [retrieveInterestPayments] */
        @MustBeClosed
        fun retrieveInterestPayments(
            accountId: String,
            params: AccountRetrieveInterestPaymentsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<AccountRetrieveInterestPaymentsResponse>>> =
            retrieveInterestPayments(
                params.toBuilder().accountId(accountId).build(),
                requestOptions,
            )

        /** @see [retrieveInterestPayments] */
        @MustBeClosed
        fun retrieveInterestPayments(
            params: AccountRetrieveInterestPaymentsParams
        ): CompletableFuture<HttpResponseFor<List<AccountRetrieveInterestPaymentsResponse>>> =
            retrieveInterestPayments(params, RequestOptions.none())

        /** @see [retrieveInterestPayments] */
        @MustBeClosed
        fun retrieveInterestPayments(
            params: AccountRetrieveInterestPaymentsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<AccountRetrieveInterestPaymentsResponse>>>

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/portfolio`, but is
         * otherwise the same as [AccountServiceAsync.retrievePortfolio].
         */
        @MustBeClosed
        fun retrievePortfolio(
            accountId: String
        ): CompletableFuture<HttpResponseFor<AccountRetrievePortfolioResponse>> =
            retrievePortfolio(accountId, AccountRetrievePortfolioParams.none())

        /** @see [retrievePortfolio] */
        @MustBeClosed
        fun retrievePortfolio(
            accountId: String,
            params: AccountRetrievePortfolioParams = AccountRetrievePortfolioParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AccountRetrievePortfolioResponse>> =
            retrievePortfolio(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [retrievePortfolio] */
        @MustBeClosed
        fun retrievePortfolio(
            accountId: String,
            params: AccountRetrievePortfolioParams = AccountRetrievePortfolioParams.none(),
        ): CompletableFuture<HttpResponseFor<AccountRetrievePortfolioResponse>> =
            retrievePortfolio(accountId, params, RequestOptions.none())

        /** @see [retrievePortfolio] */
        @MustBeClosed
        fun retrievePortfolio(
            params: AccountRetrievePortfolioParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AccountRetrievePortfolioResponse>>

        /** @see [retrievePortfolio] */
        @MustBeClosed
        fun retrievePortfolio(
            params: AccountRetrievePortfolioParams
        ): CompletableFuture<HttpResponseFor<AccountRetrievePortfolioResponse>> =
            retrievePortfolio(params, RequestOptions.none())

        /** @see [retrievePortfolio] */
        @MustBeClosed
        fun retrievePortfolio(
            accountId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<AccountRetrievePortfolioResponse>> =
            retrievePortfolio(accountId, AccountRetrievePortfolioParams.none(), requestOptions)
    }
}
