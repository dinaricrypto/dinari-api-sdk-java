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
    fun retrieve(params: AccountRetrieveParams): Account = retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: AccountRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Account

    /** Sets the account to be inactive. */
    fun deactivate(params: AccountDeactivateParams): Account =
        deactivate(params, RequestOptions.none())

    /** @see [deactivate] */
    fun deactivate(
        params: AccountDeactivateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Account

    /** Retrieves the cash amount in the account. */
    fun retrieveCash(params: AccountRetrieveCashParams): AccountRetrieveCashResponse =
        retrieveCash(params, RequestOptions.none())

    /** @see [retrieveCash] */
    fun retrieveCash(
        params: AccountRetrieveCashParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccountRetrieveCashResponse

    /** Retrieves dividend payments made to the account. */
    fun retrieveDividendPayments(
        params: AccountRetrieveDividendPaymentsParams
    ): List<AccountRetrieveDividendPaymentsResponse> =
        retrieveDividendPayments(params, RequestOptions.none())

    /** @see [retrieveDividendPayments] */
    fun retrieveDividendPayments(
        params: AccountRetrieveDividendPaymentsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<AccountRetrieveDividendPaymentsResponse>

    /** Retrieves interest payments made to the account. */
    fun retrieveInterestPayments(
        params: AccountRetrieveInterestPaymentsParams
    ): List<AccountRetrieveInterestPaymentsResponse> =
        retrieveInterestPayments(params, RequestOptions.none())

    /** @see [retrieveInterestPayments] */
    fun retrieveInterestPayments(
        params: AccountRetrieveInterestPaymentsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<AccountRetrieveInterestPaymentsResponse>

    /** Retrieves the portfolio of the account, sans cash equivalents. */
    fun retrievePortfolio(
        params: AccountRetrievePortfolioParams
    ): AccountRetrievePortfolioResponse = retrievePortfolio(params, RequestOptions.none())

    /** @see [retrievePortfolio] */
    fun retrievePortfolio(
        params: AccountRetrievePortfolioParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccountRetrievePortfolioResponse

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
        fun retrieve(params: AccountRetrieveParams): HttpResponseFor<Account> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: AccountRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Account>

        /**
         * Returns a raw HTTP response for `post /api/v2/accounts/{account_id}/deactivate`, but is
         * otherwise the same as [AccountService.deactivate].
         */
        @MustBeClosed
        fun deactivate(params: AccountDeactivateParams): HttpResponseFor<Account> =
            deactivate(params, RequestOptions.none())

        /** @see [deactivate] */
        @MustBeClosed
        fun deactivate(
            params: AccountDeactivateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Account>

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/cash`, but is
         * otherwise the same as [AccountService.retrieveCash].
         */
        @MustBeClosed
        fun retrieveCash(
            params: AccountRetrieveCashParams
        ): HttpResponseFor<AccountRetrieveCashResponse> =
            retrieveCash(params, RequestOptions.none())

        /** @see [retrieveCash] */
        @MustBeClosed
        fun retrieveCash(
            params: AccountRetrieveCashParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccountRetrieveCashResponse>

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/dividend_payments`,
         * but is otherwise the same as [AccountService.retrieveDividendPayments].
         */
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
            params: AccountRetrievePortfolioParams
        ): HttpResponseFor<AccountRetrievePortfolioResponse> =
            retrievePortfolio(params, RequestOptions.none())

        /** @see [retrievePortfolio] */
        @MustBeClosed
        fun retrievePortfolio(
            params: AccountRetrievePortfolioParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccountRetrievePortfolioResponse>
    }
}
