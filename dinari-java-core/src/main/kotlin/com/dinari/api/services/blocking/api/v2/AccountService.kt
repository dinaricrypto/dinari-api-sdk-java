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

    /** Retrieves a specific account by its ID. */
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

    /** Sets the account to be inactive. */
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

    /** Retrieves the cash amount in the account. */
    fun retrieveCash(accountId: String): AccountRetrieveCashResponse =
        retrieveCash(accountId, AccountRetrieveCashParams.none())

    /** @see [retrieveCash] */
    fun retrieveCash(
        accountId: String,
        params: AccountRetrieveCashParams = AccountRetrieveCashParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccountRetrieveCashResponse =
        retrieveCash(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [retrieveCash] */
    fun retrieveCash(
        accountId: String,
        params: AccountRetrieveCashParams = AccountRetrieveCashParams.none(),
    ): AccountRetrieveCashResponse = retrieveCash(accountId, params, RequestOptions.none())

    /** @see [retrieveCash] */
    fun retrieveCash(
        params: AccountRetrieveCashParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccountRetrieveCashResponse

    /** @see [retrieveCash] */
    fun retrieveCash(params: AccountRetrieveCashParams): AccountRetrieveCashResponse =
        retrieveCash(params, RequestOptions.none())

    /** @see [retrieveCash] */
    fun retrieveCash(
        accountId: String,
        requestOptions: RequestOptions,
    ): AccountRetrieveCashResponse =
        retrieveCash(accountId, AccountRetrieveCashParams.none(), requestOptions)

    /** Retrieves dividend payments made to the account. */
    fun retrieveDividendPayments(accountId: String): List<AccountRetrieveDividendPaymentsResponse> =
        retrieveDividendPayments(accountId, AccountRetrieveDividendPaymentsParams.none())

    /** @see [retrieveDividendPayments] */
    fun retrieveDividendPayments(
        accountId: String,
        params: AccountRetrieveDividendPaymentsParams =
            AccountRetrieveDividendPaymentsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<AccountRetrieveDividendPaymentsResponse> =
        retrieveDividendPayments(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [retrieveDividendPayments] */
    fun retrieveDividendPayments(
        accountId: String,
        params: AccountRetrieveDividendPaymentsParams = AccountRetrieveDividendPaymentsParams.none(),
    ): List<AccountRetrieveDividendPaymentsResponse> =
        retrieveDividendPayments(accountId, params, RequestOptions.none())

    /** @see [retrieveDividendPayments] */
    fun retrieveDividendPayments(
        params: AccountRetrieveDividendPaymentsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<AccountRetrieveDividendPaymentsResponse>

    /** @see [retrieveDividendPayments] */
    fun retrieveDividendPayments(
        params: AccountRetrieveDividendPaymentsParams
    ): List<AccountRetrieveDividendPaymentsResponse> =
        retrieveDividendPayments(params, RequestOptions.none())

    /** @see [retrieveDividendPayments] */
    fun retrieveDividendPayments(
        accountId: String,
        requestOptions: RequestOptions,
    ): List<AccountRetrieveDividendPaymentsResponse> =
        retrieveDividendPayments(
            accountId,
            AccountRetrieveDividendPaymentsParams.none(),
            requestOptions,
        )

    /** Retrieves interest payments made to the account. */
    fun retrieveInterestPayments(accountId: String): List<AccountRetrieveInterestPaymentsResponse> =
        retrieveInterestPayments(accountId, AccountRetrieveInterestPaymentsParams.none())

    /** @see [retrieveInterestPayments] */
    fun retrieveInterestPayments(
        accountId: String,
        params: AccountRetrieveInterestPaymentsParams =
            AccountRetrieveInterestPaymentsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<AccountRetrieveInterestPaymentsResponse> =
        retrieveInterestPayments(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [retrieveInterestPayments] */
    fun retrieveInterestPayments(
        accountId: String,
        params: AccountRetrieveInterestPaymentsParams = AccountRetrieveInterestPaymentsParams.none(),
    ): List<AccountRetrieveInterestPaymentsResponse> =
        retrieveInterestPayments(accountId, params, RequestOptions.none())

    /** @see [retrieveInterestPayments] */
    fun retrieveInterestPayments(
        params: AccountRetrieveInterestPaymentsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<AccountRetrieveInterestPaymentsResponse>

    /** @see [retrieveInterestPayments] */
    fun retrieveInterestPayments(
        params: AccountRetrieveInterestPaymentsParams
    ): List<AccountRetrieveInterestPaymentsResponse> =
        retrieveInterestPayments(params, RequestOptions.none())

    /** @see [retrieveInterestPayments] */
    fun retrieveInterestPayments(
        accountId: String,
        requestOptions: RequestOptions,
    ): List<AccountRetrieveInterestPaymentsResponse> =
        retrieveInterestPayments(
            accountId,
            AccountRetrieveInterestPaymentsParams.none(),
            requestOptions,
        )

    /** Retrieves the portfolio of the account, sans cash equivalents. */
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
        fun retrieveCash(accountId: String): HttpResponseFor<AccountRetrieveCashResponse> =
            retrieveCash(accountId, AccountRetrieveCashParams.none())

        /** @see [retrieveCash] */
        @MustBeClosed
        fun retrieveCash(
            accountId: String,
            params: AccountRetrieveCashParams = AccountRetrieveCashParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccountRetrieveCashResponse> =
            retrieveCash(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [retrieveCash] */
        @MustBeClosed
        fun retrieveCash(
            accountId: String,
            params: AccountRetrieveCashParams = AccountRetrieveCashParams.none(),
        ): HttpResponseFor<AccountRetrieveCashResponse> =
            retrieveCash(accountId, params, RequestOptions.none())

        /** @see [retrieveCash] */
        @MustBeClosed
        fun retrieveCash(
            params: AccountRetrieveCashParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccountRetrieveCashResponse>

        /** @see [retrieveCash] */
        @MustBeClosed
        fun retrieveCash(
            params: AccountRetrieveCashParams
        ): HttpResponseFor<AccountRetrieveCashResponse> =
            retrieveCash(params, RequestOptions.none())

        /** @see [retrieveCash] */
        @MustBeClosed
        fun retrieveCash(
            accountId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AccountRetrieveCashResponse> =
            retrieveCash(accountId, AccountRetrieveCashParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/dividend_payments`,
         * but is otherwise the same as [AccountService.retrieveDividendPayments].
         */
        @MustBeClosed
        fun retrieveDividendPayments(
            accountId: String
        ): HttpResponseFor<List<AccountRetrieveDividendPaymentsResponse>> =
            retrieveDividendPayments(accountId, AccountRetrieveDividendPaymentsParams.none())

        /** @see [retrieveDividendPayments] */
        @MustBeClosed
        fun retrieveDividendPayments(
            accountId: String,
            params: AccountRetrieveDividendPaymentsParams =
                AccountRetrieveDividendPaymentsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<AccountRetrieveDividendPaymentsResponse>> =
            retrieveDividendPayments(
                params.toBuilder().accountId(accountId).build(),
                requestOptions,
            )

        /** @see [retrieveDividendPayments] */
        @MustBeClosed
        fun retrieveDividendPayments(
            accountId: String,
            params: AccountRetrieveDividendPaymentsParams =
                AccountRetrieveDividendPaymentsParams.none(),
        ): HttpResponseFor<List<AccountRetrieveDividendPaymentsResponse>> =
            retrieveDividendPayments(accountId, params, RequestOptions.none())

        /** @see [retrieveDividendPayments] */
        @MustBeClosed
        fun retrieveDividendPayments(
            params: AccountRetrieveDividendPaymentsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<AccountRetrieveDividendPaymentsResponse>>

        /** @see [retrieveDividendPayments] */
        @MustBeClosed
        fun retrieveDividendPayments(
            params: AccountRetrieveDividendPaymentsParams
        ): HttpResponseFor<List<AccountRetrieveDividendPaymentsResponse>> =
            retrieveDividendPayments(params, RequestOptions.none())

        /** @see [retrieveDividendPayments] */
        @MustBeClosed
        fun retrieveDividendPayments(
            accountId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<AccountRetrieveDividendPaymentsResponse>> =
            retrieveDividendPayments(
                accountId,
                AccountRetrieveDividendPaymentsParams.none(),
                requestOptions,
            )

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/interest_payments`,
         * but is otherwise the same as [AccountService.retrieveInterestPayments].
         */
        @MustBeClosed
        fun retrieveInterestPayments(
            accountId: String
        ): HttpResponseFor<List<AccountRetrieveInterestPaymentsResponse>> =
            retrieveInterestPayments(accountId, AccountRetrieveInterestPaymentsParams.none())

        /** @see [retrieveInterestPayments] */
        @MustBeClosed
        fun retrieveInterestPayments(
            accountId: String,
            params: AccountRetrieveInterestPaymentsParams =
                AccountRetrieveInterestPaymentsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<AccountRetrieveInterestPaymentsResponse>> =
            retrieveInterestPayments(
                params.toBuilder().accountId(accountId).build(),
                requestOptions,
            )

        /** @see [retrieveInterestPayments] */
        @MustBeClosed
        fun retrieveInterestPayments(
            accountId: String,
            params: AccountRetrieveInterestPaymentsParams =
                AccountRetrieveInterestPaymentsParams.none(),
        ): HttpResponseFor<List<AccountRetrieveInterestPaymentsResponse>> =
            retrieveInterestPayments(accountId, params, RequestOptions.none())

        /** @see [retrieveInterestPayments] */
        @MustBeClosed
        fun retrieveInterestPayments(
            params: AccountRetrieveInterestPaymentsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<AccountRetrieveInterestPaymentsResponse>>

        /** @see [retrieveInterestPayments] */
        @MustBeClosed
        fun retrieveInterestPayments(
            params: AccountRetrieveInterestPaymentsParams
        ): HttpResponseFor<List<AccountRetrieveInterestPaymentsResponse>> =
            retrieveInterestPayments(params, RequestOptions.none())

        /** @see [retrieveInterestPayments] */
        @MustBeClosed
        fun retrieveInterestPayments(
            accountId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<AccountRetrieveInterestPaymentsResponse>> =
            retrieveInterestPayments(
                accountId,
                AccountRetrieveInterestPaymentsParams.none(),
                requestOptions,
            )

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
