// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.api.v2.accounts.wallet

import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.api.v2.accounts.wallet.Wallet
import com.dinari.api.models.api.v2.accounts.wallet.external.ExternalConnectParams
import com.dinari.api.models.api.v2.accounts.wallet.external.ExternalGetNonceParams
import com.dinari.api.models.api.v2.accounts.wallet.external.ExternalGetNonceResponse
import com.google.errorprone.annotations.MustBeClosed

interface ExternalService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Connects a wallet to the account using the nonce and signature */
    fun connect(accountId: String, params: ExternalConnectParams): Wallet =
        connect(accountId, params, RequestOptions.none())

    /** @see [connect] */
    fun connect(
        accountId: String,
        params: ExternalConnectParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Wallet = connect(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [connect] */
    fun connect(params: ExternalConnectParams): Wallet = connect(params, RequestOptions.none())

    /** @see [connect] */
    fun connect(
        params: ExternalConnectParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Wallet

    /** Gets a nonce and message to be signed in order to verify wallet ownership. */
    fun getNonce(accountId: String, params: ExternalGetNonceParams): ExternalGetNonceResponse =
        getNonce(accountId, params, RequestOptions.none())

    /** @see [getNonce] */
    fun getNonce(
        accountId: String,
        params: ExternalGetNonceParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExternalGetNonceResponse =
        getNonce(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [getNonce] */
    fun getNonce(params: ExternalGetNonceParams): ExternalGetNonceResponse =
        getNonce(params, RequestOptions.none())

    /** @see [getNonce] */
    fun getNonce(
        params: ExternalGetNonceParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExternalGetNonceResponse

    /** A view of [ExternalService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /api/v2/accounts/{account_id}/wallet/external`, but
         * is otherwise the same as [ExternalService.connect].
         */
        @MustBeClosed
        fun connect(accountId: String, params: ExternalConnectParams): HttpResponseFor<Wallet> =
            connect(accountId, params, RequestOptions.none())

        /** @see [connect] */
        @MustBeClosed
        fun connect(
            accountId: String,
            params: ExternalConnectParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Wallet> =
            connect(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [connect] */
        @MustBeClosed
        fun connect(params: ExternalConnectParams): HttpResponseFor<Wallet> =
            connect(params, RequestOptions.none())

        /** @see [connect] */
        @MustBeClosed
        fun connect(
            params: ExternalConnectParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Wallet>

        /**
         * Returns a raw HTTP response for `get
         * /api/v2/accounts/{account_id}/wallet/external/nonce`, but is otherwise the same as
         * [ExternalService.getNonce].
         */
        @MustBeClosed
        fun getNonce(
            accountId: String,
            params: ExternalGetNonceParams,
        ): HttpResponseFor<ExternalGetNonceResponse> =
            getNonce(accountId, params, RequestOptions.none())

        /** @see [getNonce] */
        @MustBeClosed
        fun getNonce(
            accountId: String,
            params: ExternalGetNonceParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExternalGetNonceResponse> =
            getNonce(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [getNonce] */
        @MustBeClosed
        fun getNonce(params: ExternalGetNonceParams): HttpResponseFor<ExternalGetNonceResponse> =
            getNonce(params, RequestOptions.none())

        /** @see [getNonce] */
        @MustBeClosed
        fun getNonce(
            params: ExternalGetNonceParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExternalGetNonceResponse>
    }
}
