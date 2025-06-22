// File generated from our OpenAPI spec by Stainless.

package com.dinari.services.blocking.v2.accounts.wallet

import com.dinari.core.ClientOptions
import com.dinari.core.RequestOptions
import com.dinari.core.http.HttpResponseFor
import com.dinari.models.v2.accounts.wallet.Wallet
import com.dinari.models.v2.accounts.wallet.external.ExternalConnectParams
import com.dinari.models.v2.accounts.wallet.external.ExternalGetNonceParams
import com.dinari.models.v2.accounts.wallet.external.ExternalGetNonceResponse
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface ExternalService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ExternalService

    /** Connect a `Wallet` to the `Account` after verifying the signature. */
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

    /** Get a nonce and message to be signed in order to verify `Wallet` ownership. */
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
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ExternalService.WithRawResponse

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
