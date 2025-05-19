// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.api.v2

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
import com.dinari.api.services.blocking.api.v2.accounts.OrderFulfillmentService
import com.dinari.api.services.blocking.api.v2.accounts.OrderRequestService
import com.dinari.api.services.blocking.api.v2.accounts.OrderService
import com.dinari.api.services.blocking.api.v2.accounts.WalletService
import com.google.errorprone.annotations.MustBeClosed

interface AccountService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun wallet(): WalletService

    fun orders(): OrderService

    fun orderFulfillments(): OrderFulfillmentService

    fun orderRequests(): OrderRequestService

    /** Get a specific `Account` by its ID. */
    fun retrieve(accountId: String): Account = retrieve(accountId, AccountRetrieveParams.none())

    /** @see [retrieve] */
    fun retrieve(
        accountId: String,
        params: AccountRetrieveParams = AccountRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Account = retrieve(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [retrieve] */
    fun retrieve(
        accountId: String,
        params: AccountRetrieveParams = AccountRetrieveParams.none(),
    ): Account = retrieve(accountId, params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: AccountRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Account

    /** @see [retrieve] */
    fun retrieve(params: AccountRetrieveParams): Account = retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(accountId: String, requestOptions: RequestOptions): Account =
        retrieve(accountId, AccountRetrieveParams.none(), requestOptions)

    /** Set the `Account` to be inactive. Inactive accounts cannot be used for trading. */
    fun deactivate(accountId: String): Account =
        deactivate(accountId, AccountDeactivateParams.none())

    /** @see [deactivate] */
    fun deactivate(
        accountId: String,
        params: AccountDeactivateParams = AccountDeactivateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Account = deactivate(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [deactivate] */
    fun deactivate(
        accountId: String,
        params: AccountDeactivateParams = AccountDeactivateParams.none(),
    ): Account = deactivate(accountId, params, RequestOptions.none())

    /** @see [deactivate] */
    fun deactivate(
        params: AccountDeactivateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Account

    /** @see [deactivate] */
    fun deactivate(params: AccountDeactivateParams): Account =
        deactivate(params, RequestOptions.none())

    /** @see [deactivate] */
    fun deactivate(accountId: String, requestOptions: RequestOptions): Account =
        deactivate(accountId, AccountDeactivateParams.none(), requestOptions)

    /** Get the cash balances of the `Account`, including stablecoins and other cash equivalents. */
    fun retrieveCash(accountId: String): List<AccountRetrieveCashResponse> =
        retrieveCash(accountId, AccountRetrieveCashParams.none())

    /** @see [retrieveCash] */
    fun retrieveCash(
        accountId: String,
        params: AccountRetrieveCashParams = AccountRetrieveCashParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<AccountRetrieveCashResponse> =
        retrieveCash(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [retrieveCash] */
    fun retrieveCash(
        accountId: String,
        params: AccountRetrieveCashParams = AccountRetrieveCashParams.none(),
    ): List<AccountRetrieveCashResponse> = retrieveCash(accountId, params, RequestOptions.none())

    /** @see [retrieveCash] */
    fun retrieveCash(
        params: AccountRetrieveCashParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<AccountRetrieveCashResponse>

    /** @see [retrieveCash] */
    fun retrieveCash(params: AccountRetrieveCashParams): List<AccountRetrieveCashResponse> =
        retrieveCash(params, RequestOptions.none())

    /** @see [retrieveCash] */
    fun retrieveCash(
        accountId: String,
        requestOptions: RequestOptions,
    ): List<AccountRetrieveCashResponse> =
        retrieveCash(accountId, AccountRetrieveCashParams.none(), requestOptions)

    /** Get dividend payments made to the `Account` from dividend-bearing stock holdings. */
    fun retrieveDividendPayments(
        accountId: String,
        params: AccountRetrieveDividendPaymentsParams,
    ): List<AccountRetrieveDividendPaymentsResponse> =
        retrieveDividendPayments(accountId, params, RequestOptions.none())

    /** @see [retrieveDividendPayments] */
    fun retrieveDividendPayments(
        accountId: String,
        params: AccountRetrieveDividendPaymentsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<AccountRetrieveDividendPaymentsResponse> =
        retrieveDividendPayments(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [retrieveDividendPayments] */
    fun retrieveDividendPayments(
        params: AccountRetrieveDividendPaymentsParams
    ): List<AccountRetrieveDividendPaymentsResponse> =
        retrieveDividendPayments(params, RequestOptions.none())

    /** @see [retrieveDividendPayments] */
    fun retrieveDividendPayments(
        params: AccountRetrieveDividendPaymentsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<AccountRetrieveDividendPaymentsResponse>

    /**
     * Get interest payments made to the `Account` from yield-bearing cash holdings.
     *
     * Currently, the only yield-bearing stablecoin accepted by Dinari is
     * [USD+](https://usd.dinari.com/).
     */
    fun retrieveInterestPayments(
        accountId: String,
        params: AccountRetrieveInterestPaymentsParams,
    ): List<AccountRetrieveInterestPaymentsResponse> =
        retrieveInterestPayments(accountId, params, RequestOptions.none())

    /** @see [retrieveInterestPayments] */
    fun retrieveInterestPayments(
        accountId: String,
        params: AccountRetrieveInterestPaymentsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<AccountRetrieveInterestPaymentsResponse> =
        retrieveInterestPayments(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [retrieveInterestPayments] */
    fun retrieveInterestPayments(
        params: AccountRetrieveInterestPaymentsParams
    ): List<AccountRetrieveInterestPaymentsResponse> =
        retrieveInterestPayments(params, RequestOptions.none())

    /** @see [retrieveInterestPayments] */
    fun retrieveInterestPayments(
        params: AccountRetrieveInterestPaymentsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<AccountRetrieveInterestPaymentsResponse>

    /** Get the portfolio of the `Account`, excluding cash equivalents such as stablecoins. */
    fun retrievePortfolio(accountId: String): AccountRetrievePortfolioResponse =
        retrievePortfolio(accountId, AccountRetrievePortfolioParams.none())

    /** @see [retrievePortfolio] */
    fun retrievePortfolio(
        accountId: String,
        params: AccountRetrievePortfolioParams = AccountRetrievePortfolioParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccountRetrievePortfolioResponse =
        retrievePortfolio(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [retrievePortfolio] */
    fun retrievePortfolio(
        accountId: String,
        params: AccountRetrievePortfolioParams = AccountRetrievePortfolioParams.none(),
    ): AccountRetrievePortfolioResponse =
        retrievePortfolio(accountId, params, RequestOptions.none())

    /** @see [retrievePortfolio] */
    fun retrievePortfolio(
        params: AccountRetrievePortfolioParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccountRetrievePortfolioResponse

    /** @see [retrievePortfolio] */
    fun retrievePortfolio(
        params: AccountRetrievePortfolioParams
    ): AccountRetrievePortfolioResponse = retrievePortfolio(params, RequestOptions.none())

    /** @see [retrievePortfolio] */
    fun retrievePortfolio(
        accountId: String,
        requestOptions: RequestOptions,
    ): AccountRetrievePortfolioResponse =
        retrievePortfolio(accountId, AccountRetrievePortfolioParams.none(), requestOptions)

    /** A view of [AccountService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun wallet(): WalletService.WithRawResponse

        fun orders(): OrderService.WithRawResponse

        fun orderFulfillments(): OrderFulfillmentService.WithRawResponse

        fun orderRequests(): OrderRequestService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}`, but is otherwise the
         * same as [AccountService.retrieve].
         */
        @MustBeClosed
        fun retrieve(accountId: String): HttpResponseFor<Account> =
            retrieve(accountId, AccountRetrieveParams.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            accountId: String,
            params: AccountRetrieveParams = AccountRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Account> =
            retrieve(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            accountId: String,
            params: AccountRetrieveParams = AccountRetrieveParams.none(),
        ): HttpResponseFor<Account> = retrieve(accountId, params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: AccountRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Account>

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(params: AccountRetrieveParams): HttpResponseFor<Account> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
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

        /** @see [deactivate] */
        @MustBeClosed
        fun deactivate(
            accountId: String,
            params: AccountDeactivateParams = AccountDeactivateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Account> =
            deactivate(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [deactivate] */
        @MustBeClosed
        fun deactivate(
            accountId: String,
            params: AccountDeactivateParams = AccountDeactivateParams.none(),
        ): HttpResponseFor<Account> = deactivate(accountId, params, RequestOptions.none())

        /** @see [deactivate] */
        @MustBeClosed
        fun deactivate(
            params: AccountDeactivateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Account>

        /** @see [deactivate] */
        @MustBeClosed
        fun deactivate(params: AccountDeactivateParams): HttpResponseFor<Account> =
            deactivate(params, RequestOptions.none())

        /** @see [deactivate] */
        @MustBeClosed
        fun deactivate(
            accountId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Account> =
            deactivate(accountId, AccountDeactivateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/cash`, but is
         * otherwise the same as [AccountService.retrieveCash].
         */
        @MustBeClosed
        fun retrieveCash(accountId: String): HttpResponseFor<List<AccountRetrieveCashResponse>> =
            retrieveCash(accountId, AccountRetrieveCashParams.none())

        /** @see [retrieveCash] */
        @MustBeClosed
        fun retrieveCash(
            accountId: String,
            params: AccountRetrieveCashParams = AccountRetrieveCashParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<AccountRetrieveCashResponse>> =
            retrieveCash(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [retrieveCash] */
        @MustBeClosed
        fun retrieveCash(
            accountId: String,
            params: AccountRetrieveCashParams = AccountRetrieveCashParams.none(),
        ): HttpResponseFor<List<AccountRetrieveCashResponse>> =
            retrieveCash(accountId, params, RequestOptions.none())

        /** @see [retrieveCash] */
        @MustBeClosed
        fun retrieveCash(
            params: AccountRetrieveCashParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<AccountRetrieveCashResponse>>

        /** @see [retrieveCash] */
        @MustBeClosed
        fun retrieveCash(
            params: AccountRetrieveCashParams
        ): HttpResponseFor<List<AccountRetrieveCashResponse>> =
            retrieveCash(params, RequestOptions.none())

        /** @see [retrieveCash] */
        @MustBeClosed
        fun retrieveCash(
            accountId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<AccountRetrieveCashResponse>> =
            retrieveCash(accountId, AccountRetrieveCashParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/dividend_payments`,
         * but is otherwise the same as [AccountService.retrieveDividendPayments].
         */
        @MustBeClosed
        fun retrieveDividendPayments(
            accountId: String,
            params: AccountRetrieveDividendPaymentsParams,
        ): HttpResponseFor<List<AccountRetrieveDividendPaymentsResponse>> =
            retrieveDividendPayments(accountId, params, RequestOptions.none())

        /** @see [retrieveDividendPayments] */
        @MustBeClosed
        fun retrieveDividendPayments(
            accountId: String,
            params: AccountRetrieveDividendPaymentsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<AccountRetrieveDividendPaymentsResponse>> =
            retrieveDividendPayments(
                params.toBuilder().accountId(accountId).build(),
                requestOptions,
            )

        /** @see [retrieveDividendPayments] */
        @MustBeClosed
        fun retrieveDividendPayments(
            params: AccountRetrieveDividendPaymentsParams
        ): HttpResponseFor<List<AccountRetrieveDividendPaymentsResponse>> =
            retrieveDividendPayments(params, RequestOptions.none())

        /** @see [retrieveDividendPayments] */
        @MustBeClosed
        fun retrieveDividendPayments(
            params: AccountRetrieveDividendPaymentsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<AccountRetrieveDividendPaymentsResponse>>

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/interest_payments`,
         * but is otherwise the same as [AccountService.retrieveInterestPayments].
         */
        @MustBeClosed
        fun retrieveInterestPayments(
            accountId: String,
            params: AccountRetrieveInterestPaymentsParams,
        ): HttpResponseFor<List<AccountRetrieveInterestPaymentsResponse>> =
            retrieveInterestPayments(accountId, params, RequestOptions.none())

        /** @see [retrieveInterestPayments] */
        @MustBeClosed
        fun retrieveInterestPayments(
            accountId: String,
            params: AccountRetrieveInterestPaymentsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<AccountRetrieveInterestPaymentsResponse>> =
            retrieveInterestPayments(
                params.toBuilder().accountId(accountId).build(),
                requestOptions,
            )

        /** @see [retrieveInterestPayments] */
        @MustBeClosed
        fun retrieveInterestPayments(
            params: AccountRetrieveInterestPaymentsParams
        ): HttpResponseFor<List<AccountRetrieveInterestPaymentsResponse>> =
            retrieveInterestPayments(params, RequestOptions.none())

        /** @see [retrieveInterestPayments] */
        @MustBeClosed
        fun retrieveInterestPayments(
            params: AccountRetrieveInterestPaymentsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<AccountRetrieveInterestPaymentsResponse>>

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/portfolio`, but is
         * otherwise the same as [AccountService.retrievePortfolio].
         */
        @MustBeClosed
        fun retrievePortfolio(
            accountId: String
        ): HttpResponseFor<AccountRetrievePortfolioResponse> =
            retrievePortfolio(accountId, AccountRetrievePortfolioParams.none())

        /** @see [retrievePortfolio] */
        @MustBeClosed
        fun retrievePortfolio(
            accountId: String,
            params: AccountRetrievePortfolioParams = AccountRetrievePortfolioParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccountRetrievePortfolioResponse> =
            retrievePortfolio(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [retrievePortfolio] */
        @MustBeClosed
        fun retrievePortfolio(
            accountId: String,
            params: AccountRetrievePortfolioParams = AccountRetrievePortfolioParams.none(),
        ): HttpResponseFor<AccountRetrievePortfolioResponse> =
            retrievePortfolio(accountId, params, RequestOptions.none())

        /** @see [retrievePortfolio] */
        @MustBeClosed
        fun retrievePortfolio(
            params: AccountRetrievePortfolioParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccountRetrievePortfolioResponse>

        /** @see [retrievePortfolio] */
        @MustBeClosed
        fun retrievePortfolio(
            params: AccountRetrievePortfolioParams
        ): HttpResponseFor<AccountRetrievePortfolioResponse> =
            retrievePortfolio(params, RequestOptions.none())

        /** @see [retrievePortfolio] */
        @MustBeClosed
        fun retrievePortfolio(
            accountId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AccountRetrievePortfolioResponse> =
            retrievePortfolio(accountId, AccountRetrievePortfolioParams.none(), requestOptions)
    }
}
