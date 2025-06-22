// File generated from our OpenAPI spec by Stainless.

package com.dinari.services.async.v2.accounts.orders.stocks

import com.dinari.core.ClientOptions
import com.dinari.core.RequestOptions
import com.dinari.core.http.HttpResponseFor
import com.dinari.models.v2.accounts.orders.stocks.eip155.Eip155GetFeeQuoteParams
import com.dinari.models.v2.accounts.orders.stocks.eip155.Eip155GetFeeQuoteResponse
import com.dinari.models.v2.accounts.orders.stocks.eip155.Eip155PrepareOrderParams
import com.dinari.models.v2.accounts.orders.stocks.eip155.Eip155PrepareOrderResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface Eip155ServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): Eip155ServiceAsync

    /**
     * Get fee quote data for an `Order` to be placed on Dinari's EVM smart contracts.
     *
     * Dinari's EVM smart contracts require a fee quote to be provided when placing an `Order`. Use
     * this method to retrieve the quote.
     *
     * The `order_fee_contract_object` property contains the opaque fee quote structure to be used.
     */
    fun getFeeQuote(
        accountId: String,
        params: Eip155GetFeeQuoteParams,
    ): CompletableFuture<Eip155GetFeeQuoteResponse> =
        getFeeQuote(accountId, params, RequestOptions.none())

    /** @see [getFeeQuote] */
    fun getFeeQuote(
        accountId: String,
        params: Eip155GetFeeQuoteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Eip155GetFeeQuoteResponse> =
        getFeeQuote(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [getFeeQuote] */
    fun getFeeQuote(params: Eip155GetFeeQuoteParams): CompletableFuture<Eip155GetFeeQuoteResponse> =
        getFeeQuote(params, RequestOptions.none())

    /** @see [getFeeQuote] */
    fun getFeeQuote(
        params: Eip155GetFeeQuoteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Eip155GetFeeQuoteResponse>

    /**
     * Create a set of transactions to create an `Order` using Dinari's EVM smart contracts.
     *
     * This is a convenience method to prepare the transactions needed to create an `Order` using
     * Dinari's EVM smart contracts. Once signed, the transactions can be sent to the EVM network to
     * create the order. Note that the fee quote is already included in the transactions, so no
     * additional fee quote lookup is needed.
     */
    fun prepareOrder(
        accountId: String,
        params: Eip155PrepareOrderParams,
    ): CompletableFuture<Eip155PrepareOrderResponse> =
        prepareOrder(accountId, params, RequestOptions.none())

    /** @see [prepareOrder] */
    fun prepareOrder(
        accountId: String,
        params: Eip155PrepareOrderParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Eip155PrepareOrderResponse> =
        prepareOrder(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [prepareOrder] */
    fun prepareOrder(
        params: Eip155PrepareOrderParams
    ): CompletableFuture<Eip155PrepareOrderResponse> = prepareOrder(params, RequestOptions.none())

    /** @see [prepareOrder] */
    fun prepareOrder(
        params: Eip155PrepareOrderParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Eip155PrepareOrderResponse>

    /**
     * A view of [Eip155ServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): Eip155ServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post
         * /api/v2/accounts/{account_id}/orders/stocks/eip155/fee_quote`, but is otherwise the same
         * as [Eip155ServiceAsync.getFeeQuote].
         */
        fun getFeeQuote(
            accountId: String,
            params: Eip155GetFeeQuoteParams,
        ): CompletableFuture<HttpResponseFor<Eip155GetFeeQuoteResponse>> =
            getFeeQuote(accountId, params, RequestOptions.none())

        /** @see [getFeeQuote] */
        fun getFeeQuote(
            accountId: String,
            params: Eip155GetFeeQuoteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Eip155GetFeeQuoteResponse>> =
            getFeeQuote(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [getFeeQuote] */
        fun getFeeQuote(
            params: Eip155GetFeeQuoteParams
        ): CompletableFuture<HttpResponseFor<Eip155GetFeeQuoteResponse>> =
            getFeeQuote(params, RequestOptions.none())

        /** @see [getFeeQuote] */
        fun getFeeQuote(
            params: Eip155GetFeeQuoteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Eip155GetFeeQuoteResponse>>

        /**
         * Returns a raw HTTP response for `post
         * /api/v2/accounts/{account_id}/orders/stocks/eip155/prepare`, but is otherwise the same as
         * [Eip155ServiceAsync.prepareOrder].
         */
        fun prepareOrder(
            accountId: String,
            params: Eip155PrepareOrderParams,
        ): CompletableFuture<HttpResponseFor<Eip155PrepareOrderResponse>> =
            prepareOrder(accountId, params, RequestOptions.none())

        /** @see [prepareOrder] */
        fun prepareOrder(
            accountId: String,
            params: Eip155PrepareOrderParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Eip155PrepareOrderResponse>> =
            prepareOrder(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [prepareOrder] */
        fun prepareOrder(
            params: Eip155PrepareOrderParams
        ): CompletableFuture<HttpResponseFor<Eip155PrepareOrderResponse>> =
            prepareOrder(params, RequestOptions.none())

        /** @see [prepareOrder] */
        fun prepareOrder(
            params: Eip155PrepareOrderParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Eip155PrepareOrderResponse>>
    }
}
