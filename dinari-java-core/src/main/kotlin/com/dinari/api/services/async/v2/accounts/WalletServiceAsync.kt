// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.v2.accounts

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.v2.accounts.wallet.Wallet
import com.dinari.api.models.v2.accounts.wallet.WalletGetParams
import com.dinari.api.services.async.v2.accounts.wallet.ExternalServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface WalletServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): WalletServiceAsync

    fun external(): ExternalServiceAsync

    /** Get the wallet connected to the `Account`. */
    fun get(accountId: String): CompletableFuture<Wallet> = get(accountId, WalletGetParams.none())

    /** @see [get] */
    fun get(
        accountId: String,
        params: WalletGetParams = WalletGetParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Wallet> =
        get(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [get] */
    fun get(
        accountId: String,
        params: WalletGetParams = WalletGetParams.none(),
    ): CompletableFuture<Wallet> = get(accountId, params, RequestOptions.none())

    /** @see [get] */
    fun get(
        params: WalletGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Wallet>

    /** @see [get] */
    fun get(params: WalletGetParams): CompletableFuture<Wallet> = get(params, RequestOptions.none())

    /** @see [get] */
    fun get(accountId: String, requestOptions: RequestOptions): CompletableFuture<Wallet> =
        get(accountId, WalletGetParams.none(), requestOptions)

    /**
     * A view of [WalletServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): WalletServiceAsync.WithRawResponse

        fun external(): ExternalServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/wallet`, but is
         * otherwise the same as [WalletServiceAsync.get].
         */
        fun get(accountId: String): CompletableFuture<HttpResponseFor<Wallet>> =
            get(accountId, WalletGetParams.none())

        /** @see [get] */
        fun get(
            accountId: String,
            params: WalletGetParams = WalletGetParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Wallet>> =
            get(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [get] */
        fun get(
            accountId: String,
            params: WalletGetParams = WalletGetParams.none(),
        ): CompletableFuture<HttpResponseFor<Wallet>> =
            get(accountId, params, RequestOptions.none())

        /** @see [get] */
        fun get(
            params: WalletGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Wallet>>

        /** @see [get] */
        fun get(params: WalletGetParams): CompletableFuture<HttpResponseFor<Wallet>> =
            get(params, RequestOptions.none())

        /** @see [get] */
        fun get(
            accountId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Wallet>> =
            get(accountId, WalletGetParams.none(), requestOptions)
    }
}
