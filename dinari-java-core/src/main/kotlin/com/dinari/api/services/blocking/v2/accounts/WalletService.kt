// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.accounts

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.v2.accounts.wallet.Wallet
import com.dinari.api.models.v2.accounts.wallet.WalletGetParams
import com.dinari.api.services.blocking.v2.accounts.wallet.ExternalService
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface WalletService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): WalletService

    fun external(): ExternalService

    /** Get the wallet connected to the `Account`. */
    fun get(accountId: String): Wallet = get(accountId, WalletGetParams.none())

    /** @see [get] */
    fun get(
        accountId: String,
        params: WalletGetParams = WalletGetParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Wallet = get(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [get] */
    fun get(accountId: String, params: WalletGetParams = WalletGetParams.none()): Wallet =
        get(accountId, params, RequestOptions.none())

    /** @see [get] */
    fun get(params: WalletGetParams, requestOptions: RequestOptions = RequestOptions.none()): Wallet

    /** @see [get] */
    fun get(params: WalletGetParams): Wallet = get(params, RequestOptions.none())

    /** @see [get] */
    fun get(accountId: String, requestOptions: RequestOptions): Wallet =
        get(accountId, WalletGetParams.none(), requestOptions)

    /** A view of [WalletService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): WalletService.WithRawResponse

        fun external(): ExternalService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/wallet`, but is
         * otherwise the same as [WalletService.get].
         */
        @MustBeClosed
        fun get(accountId: String): HttpResponseFor<Wallet> = get(accountId, WalletGetParams.none())

        /** @see [get] */
        @MustBeClosed
        fun get(
            accountId: String,
            params: WalletGetParams = WalletGetParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Wallet> =
            get(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [get] */
        @MustBeClosed
        fun get(
            accountId: String,
            params: WalletGetParams = WalletGetParams.none(),
        ): HttpResponseFor<Wallet> = get(accountId, params, RequestOptions.none())

        /** @see [get] */
        @MustBeClosed
        fun get(
            params: WalletGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Wallet>

        /** @see [get] */
        @MustBeClosed
        fun get(params: WalletGetParams): HttpResponseFor<Wallet> =
            get(params, RequestOptions.none())

        /** @see [get] */
        @MustBeClosed
        fun get(accountId: String, requestOptions: RequestOptions): HttpResponseFor<Wallet> =
            get(accountId, WalletGetParams.none(), requestOptions)
    }
}
