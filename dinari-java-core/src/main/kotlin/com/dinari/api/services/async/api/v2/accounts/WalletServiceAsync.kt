// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.api.v2.accounts

import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.api.v2.accounts.wallet.Wallet
import com.dinari.api.models.api.v2.accounts.wallet.WalletRetrieveParams
import com.dinari.api.services.async.api.v2.accounts.wallet.ExternalServiceAsync
import com.google.errorprone.annotations.MustBeClosed
import java.util.concurrent.CompletableFuture

interface WalletServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun external(): ExternalServiceAsync

    /** Retrieves details of the wallet connected to the account. */
    fun retrieve(accountId: String): CompletableFuture<Wallet> =
        retrieve(accountId, WalletRetrieveParams.none())

    /** @see [retrieve] */
    fun retrieve(
        accountId: String,
        params: WalletRetrieveParams = WalletRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Wallet> =
        retrieve(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [retrieve] */
    fun retrieve(
        accountId: String,
        params: WalletRetrieveParams = WalletRetrieveParams.none(),
    ): CompletableFuture<Wallet> = retrieve(accountId, params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: WalletRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Wallet>

    /** @see [retrieve] */
    fun retrieve(params: WalletRetrieveParams): CompletableFuture<Wallet> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(accountId: String, requestOptions: RequestOptions): CompletableFuture<Wallet> =
        retrieve(accountId, WalletRetrieveParams.none(), requestOptions)

    /**
     * A view of [WalletServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        fun external(): ExternalServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/wallet`, but is
         * otherwise the same as [WalletServiceAsync.retrieve].
         */
        @MustBeClosed
        fun retrieve(accountId: String): CompletableFuture<HttpResponseFor<Wallet>> =
            retrieve(accountId, WalletRetrieveParams.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            accountId: String,
            params: WalletRetrieveParams = WalletRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Wallet>> =
            retrieve(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            accountId: String,
            params: WalletRetrieveParams = WalletRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<Wallet>> =
            retrieve(accountId, params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: WalletRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Wallet>>

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(params: WalletRetrieveParams): CompletableFuture<HttpResponseFor<Wallet>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            accountId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Wallet>> =
            retrieve(accountId, WalletRetrieveParams.none(), requestOptions)
    }
}
