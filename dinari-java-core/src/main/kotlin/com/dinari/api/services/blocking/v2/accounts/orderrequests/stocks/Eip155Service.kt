// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.accounts.orderrequests.stocks

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.v2.accounts.orderrequests.stocks.eip155.Eip155PrepareProxiedOrderParams
import com.dinari.api.models.v2.accounts.orderrequests.stocks.eip155.Eip155PrepareProxiedOrderResponse
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface Eip155Service {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): Eip155Service

    /**
     * Prepare a proxied order to be placed on EVM. The returned structure contains the necessary
     * data to create an `OrderRequest` with a `Wallet` that is not Dinari-managed.
     *
     * **⚠️ This endpoint will be deprecated on 2025-12-15.**
     */
    @Deprecated("deprecated")
    fun prepareProxiedOrder(
        accountId: String,
        params: Eip155PrepareProxiedOrderParams,
    ): Eip155PrepareProxiedOrderResponse =
        prepareProxiedOrder(accountId, params, RequestOptions.none())

    /** @see prepareProxiedOrder */
    @Deprecated("deprecated")
    fun prepareProxiedOrder(
        accountId: String,
        params: Eip155PrepareProxiedOrderParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Eip155PrepareProxiedOrderResponse =
        prepareProxiedOrder(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see prepareProxiedOrder */
    @Deprecated("deprecated")
    fun prepareProxiedOrder(
        params: Eip155PrepareProxiedOrderParams
    ): Eip155PrepareProxiedOrderResponse = prepareProxiedOrder(params, RequestOptions.none())

    /** @see prepareProxiedOrder */
    @Deprecated("deprecated")
    fun prepareProxiedOrder(
        params: Eip155PrepareProxiedOrderParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Eip155PrepareProxiedOrderResponse

    /** A view of [Eip155Service] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): Eip155Service.WithRawResponse

        /**
         * Returns a raw HTTP response for `post
         * /api/v2/accounts/{account_id}/order_requests/stocks/eip155/prepare`, but is otherwise the
         * same as [Eip155Service.prepareProxiedOrder].
         */
        @Deprecated("deprecated")
        @MustBeClosed
        fun prepareProxiedOrder(
            accountId: String,
            params: Eip155PrepareProxiedOrderParams,
        ): HttpResponseFor<Eip155PrepareProxiedOrderResponse> =
            prepareProxiedOrder(accountId, params, RequestOptions.none())

        /** @see prepareProxiedOrder */
        @Deprecated("deprecated")
        @MustBeClosed
        fun prepareProxiedOrder(
            accountId: String,
            params: Eip155PrepareProxiedOrderParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Eip155PrepareProxiedOrderResponse> =
            prepareProxiedOrder(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see prepareProxiedOrder */
        @Deprecated("deprecated")
        @MustBeClosed
        fun prepareProxiedOrder(
            params: Eip155PrepareProxiedOrderParams
        ): HttpResponseFor<Eip155PrepareProxiedOrderResponse> =
            prepareProxiedOrder(params, RequestOptions.none())

        /** @see prepareProxiedOrder */
        @Deprecated("deprecated")
        @MustBeClosed
        fun prepareProxiedOrder(
            params: Eip155PrepareProxiedOrderParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Eip155PrepareProxiedOrderResponse>
    }
}
