// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.v2.accounts.orderrequests.stocks

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequest
import com.dinari.api.models.v2.accounts.orderrequests.stocks.eip155.Eip155CreateProxiedOrderParams
import com.dinari.api.models.v2.accounts.orderrequests.stocks.eip155.Eip155PrepareProxiedOrderParams
import com.dinari.api.models.v2.accounts.orderrequests.stocks.eip155.Eip155PrepareProxiedOrderResponse
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
     * Create a proxied order on EVM from a prepared proxied order. An `OrderRequest` representing
     * the proxied order is returned.
     */
    fun createProxiedOrder(
        accountId: String,
        params: Eip155CreateProxiedOrderParams,
    ): CompletableFuture<OrderRequest> =
        createProxiedOrder(accountId, params, RequestOptions.none())

    /** @see [createProxiedOrder] */
    fun createProxiedOrder(
        accountId: String,
        params: Eip155CreateProxiedOrderParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrderRequest> =
        createProxiedOrder(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [createProxiedOrder] */
    fun createProxiedOrder(
        params: Eip155CreateProxiedOrderParams
    ): CompletableFuture<OrderRequest> = createProxiedOrder(params, RequestOptions.none())

    /** @see [createProxiedOrder] */
    fun createProxiedOrder(
        params: Eip155CreateProxiedOrderParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrderRequest>

    /**
     * Prepare a proxied order to be placed on EVM. The returned structure contains the necessary
     * data to create an `OrderRequest` with a `Wallet` that is not Dinari-managed.
     */
    fun prepareProxiedOrder(
        accountId: String,
        params: Eip155PrepareProxiedOrderParams,
    ): CompletableFuture<Eip155PrepareProxiedOrderResponse> =
        prepareProxiedOrder(accountId, params, RequestOptions.none())

    /** @see [prepareProxiedOrder] */
    fun prepareProxiedOrder(
        accountId: String,
        params: Eip155PrepareProxiedOrderParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Eip155PrepareProxiedOrderResponse> =
        prepareProxiedOrder(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [prepareProxiedOrder] */
    fun prepareProxiedOrder(
        params: Eip155PrepareProxiedOrderParams
    ): CompletableFuture<Eip155PrepareProxiedOrderResponse> =
        prepareProxiedOrder(params, RequestOptions.none())

    /** @see [prepareProxiedOrder] */
    fun prepareProxiedOrder(
        params: Eip155PrepareProxiedOrderParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Eip155PrepareProxiedOrderResponse>

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
         * /api/v2/accounts/{account_id}/order_requests/stocks/eip155`, but is otherwise the same as
         * [Eip155ServiceAsync.createProxiedOrder].
         */
        fun createProxiedOrder(
            accountId: String,
            params: Eip155CreateProxiedOrderParams,
        ): CompletableFuture<HttpResponseFor<OrderRequest>> =
            createProxiedOrder(accountId, params, RequestOptions.none())

        /** @see [createProxiedOrder] */
        fun createProxiedOrder(
            accountId: String,
            params: Eip155CreateProxiedOrderParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrderRequest>> =
            createProxiedOrder(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [createProxiedOrder] */
        fun createProxiedOrder(
            params: Eip155CreateProxiedOrderParams
        ): CompletableFuture<HttpResponseFor<OrderRequest>> =
            createProxiedOrder(params, RequestOptions.none())

        /** @see [createProxiedOrder] */
        fun createProxiedOrder(
            params: Eip155CreateProxiedOrderParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrderRequest>>

        /**
         * Returns a raw HTTP response for `post
         * /api/v2/accounts/{account_id}/order_requests/stocks/eip155/prepare`, but is otherwise the
         * same as [Eip155ServiceAsync.prepareProxiedOrder].
         */
        fun prepareProxiedOrder(
            accountId: String,
            params: Eip155PrepareProxiedOrderParams,
        ): CompletableFuture<HttpResponseFor<Eip155PrepareProxiedOrderResponse>> =
            prepareProxiedOrder(accountId, params, RequestOptions.none())

        /** @see [prepareProxiedOrder] */
        fun prepareProxiedOrder(
            accountId: String,
            params: Eip155PrepareProxiedOrderParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Eip155PrepareProxiedOrderResponse>> =
            prepareProxiedOrder(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [prepareProxiedOrder] */
        fun prepareProxiedOrder(
            params: Eip155PrepareProxiedOrderParams
        ): CompletableFuture<HttpResponseFor<Eip155PrepareProxiedOrderResponse>> =
            prepareProxiedOrder(params, RequestOptions.none())

        /** @see [prepareProxiedOrder] */
        fun prepareProxiedOrder(
            params: Eip155PrepareProxiedOrderParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Eip155PrepareProxiedOrderResponse>>
    }
}
