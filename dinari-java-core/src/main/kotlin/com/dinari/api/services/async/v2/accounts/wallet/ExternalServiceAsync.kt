// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.v2.accounts.wallet

import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.v2.accounts.wallet.Wallet
import com.dinari.api.models.v2.accounts.wallet.external.ExternalConnectParams
import com.dinari.api.models.v2.accounts.wallet.external.ExternalGetNonceParams
import com.dinari.api.models.v2.accounts.wallet.external.ExternalGetNonceResponse
import java.util.concurrent.CompletableFuture

interface ExternalServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Connect a `Wallet` to the `Account` after verifying the signature. */
    fun connect(accountId: String, params: ExternalConnectParams): CompletableFuture<Wallet> =
        connect(accountId, params, RequestOptions.none())

    /** @see [connect] */
    fun connect(
        accountId: String,
        params: ExternalConnectParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Wallet> =
        connect(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [connect] */
    fun connect(params: ExternalConnectParams): CompletableFuture<Wallet> =
        connect(params, RequestOptions.none())

    /** @see [connect] */
    fun connect(
        params: ExternalConnectParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Wallet>

    /** Get a nonce and message to be signed in order to verify `Wallet` ownership. */
    fun getNonce(
        accountId: String,
        params: ExternalGetNonceParams,
    ): CompletableFuture<ExternalGetNonceResponse> =
        getNonce(accountId, params, RequestOptions.none())

    /** @see [getNonce] */
    fun getNonce(
        accountId: String,
        params: ExternalGetNonceParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ExternalGetNonceResponse> =
        getNonce(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [getNonce] */
    fun getNonce(params: ExternalGetNonceParams): CompletableFuture<ExternalGetNonceResponse> =
        getNonce(params, RequestOptions.none())

    /** @see [getNonce] */
    fun getNonce(
        params: ExternalGetNonceParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ExternalGetNonceResponse>

    /**
     * A view of [ExternalServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /api/v2/accounts/{account_id}/wallet/external`, but
         * is otherwise the same as [ExternalServiceAsync.connect].
         */
        fun connect(
            accountId: String,
            params: ExternalConnectParams,
        ): CompletableFuture<HttpResponseFor<Wallet>> =
            connect(accountId, params, RequestOptions.none())

        /** @see [connect] */
        fun connect(
            accountId: String,
            params: ExternalConnectParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Wallet>> =
            connect(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [connect] */
        fun connect(params: ExternalConnectParams): CompletableFuture<HttpResponseFor<Wallet>> =
            connect(params, RequestOptions.none())

        /** @see [connect] */
        fun connect(
            params: ExternalConnectParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Wallet>>

        /**
         * Returns a raw HTTP response for `get
         * /api/v2/accounts/{account_id}/wallet/external/nonce`, but is otherwise the same as
         * [ExternalServiceAsync.getNonce].
         */
        fun getNonce(
            accountId: String,
            params: ExternalGetNonceParams,
        ): CompletableFuture<HttpResponseFor<ExternalGetNonceResponse>> =
            getNonce(accountId, params, RequestOptions.none())

        /** @see [getNonce] */
        fun getNonce(
            accountId: String,
            params: ExternalGetNonceParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ExternalGetNonceResponse>> =
            getNonce(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [getNonce] */
        fun getNonce(
            params: ExternalGetNonceParams
        ): CompletableFuture<HttpResponseFor<ExternalGetNonceResponse>> =
            getNonce(params, RequestOptions.none())

        /** @see [getNonce] */
        fun getNonce(
            params: ExternalGetNonceParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ExternalGetNonceResponse>>
    }
}
