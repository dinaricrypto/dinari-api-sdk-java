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

    /** Retrieves a specific account by its ID. */
    fun retrieve(params: AccountRetrieveParams): CompletableFuture<Account> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: AccountRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Account>

    /** Sets the account to be inactive. */
    fun deactivate(params: AccountDeactivateParams): CompletableFuture<Account> =
        deactivate(params, RequestOptions.none())

    /** @see [deactivate] */
    fun deactivate(
        params: AccountDeactivateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Account>

    /** Retrieves the cash amount in the account. */
    fun retrieveCash(
        params: AccountRetrieveCashParams
    ): CompletableFuture<AccountRetrieveCashResponse> = retrieveCash(params, RequestOptions.none())

    /** @see [retrieveCash] */
    fun retrieveCash(
        params: AccountRetrieveCashParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AccountRetrieveCashResponse>

    /** Retrieves dividend payments made to the account. */
    fun retrieveDividendPayments(
        params: AccountRetrieveDividendPaymentsParams
    ): CompletableFuture<List<AccountRetrieveDividendPaymentsResponse>> =
        retrieveDividendPayments(params, RequestOptions.none())

    /** @see [retrieveDividendPayments] */
    fun retrieveDividendPayments(
        params: AccountRetrieveDividendPaymentsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<AccountRetrieveDividendPaymentsResponse>>

    /** Retrieves interest payments made to the account. */
    fun retrieveInterestPayments(
        params: AccountRetrieveInterestPaymentsParams
    ): CompletableFuture<List<AccountRetrieveInterestPaymentsResponse>> =
        retrieveInterestPayments(params, RequestOptions.none())

    /** @see [retrieveInterestPayments] */
    fun retrieveInterestPayments(
        params: AccountRetrieveInterestPaymentsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<AccountRetrieveInterestPaymentsResponse>>

    /** Retrieves the portfolio of the account, sans cash equivalents. */
    fun retrievePortfolio(
        params: AccountRetrievePortfolioParams
    ): CompletableFuture<AccountRetrievePortfolioResponse> =
        retrievePortfolio(params, RequestOptions.none())

    /** @see [retrievePortfolio] */
    fun retrievePortfolio(
        params: AccountRetrievePortfolioParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AccountRetrievePortfolioResponse>

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
        fun retrieve(params: AccountRetrieveParams): CompletableFuture<HttpResponseFor<Account>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: AccountRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Account>>

        /**
         * Returns a raw HTTP response for `post /api/v2/accounts/{account_id}/deactivate`, but is
         * otherwise the same as [AccountServiceAsync.deactivate].
         */
        @MustBeClosed
        fun deactivate(
            params: AccountDeactivateParams
        ): CompletableFuture<HttpResponseFor<Account>> = deactivate(params, RequestOptions.none())

        /** @see [deactivate] */
        @MustBeClosed
        fun deactivate(
            params: AccountDeactivateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Account>>

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/cash`, but is
         * otherwise the same as [AccountServiceAsync.retrieveCash].
         */
        @MustBeClosed
        fun retrieveCash(
            params: AccountRetrieveCashParams
        ): CompletableFuture<HttpResponseFor<AccountRetrieveCashResponse>> =
            retrieveCash(params, RequestOptions.none())

        /** @see [retrieveCash] */
        @MustBeClosed
        fun retrieveCash(
            params: AccountRetrieveCashParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AccountRetrieveCashResponse>>

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/dividend_payments`,
         * but is otherwise the same as [AccountServiceAsync.retrieveDividendPayments].
         */
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
            params: AccountRetrievePortfolioParams
        ): CompletableFuture<HttpResponseFor<AccountRetrievePortfolioResponse>> =
            retrievePortfolio(params, RequestOptions.none())

        /** @see [retrievePortfolio] */
        @MustBeClosed
        fun retrievePortfolio(
            params: AccountRetrievePortfolioParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AccountRetrievePortfolioResponse>>
    }
}
