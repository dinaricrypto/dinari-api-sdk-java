// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.api.v2.accounts

import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.api.v2.accounts.wallet.Wallet
import com.dinari.api.models.api.v2.accounts.wallet.WalletRetrieveParams
import com.dinari.api.services.blocking.api.v2.accounts.wallet.ExternalService
import com.google.errorprone.annotations.MustBeClosed

interface WalletService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun external(): ExternalService

    /** Retrieves details of the wallet connected to the account. */
    fun retrieve(accountId: String): Wallet = retrieve(accountId, WalletRetrieveParams.none())

    /** @see [retrieve] */
    fun retrieve(
        accountId: String,
        params: WalletRetrieveParams = WalletRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Wallet = retrieve(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [retrieve] */
    fun retrieve(
        accountId: String,
        params: WalletRetrieveParams = WalletRetrieveParams.none(),
    ): Wallet = retrieve(accountId, params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: WalletRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Wallet

    /** @see [retrieve] */
    fun retrieve(params: WalletRetrieveParams): Wallet = retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(accountId: String, requestOptions: RequestOptions): Wallet =
        retrieve(accountId, WalletRetrieveParams.none(), requestOptions)

    /** A view of [WalletService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun external(): ExternalService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/wallet`, but is
         * otherwise the same as [WalletService.retrieve].
         */
        @MustBeClosed
        fun retrieve(accountId: String): HttpResponseFor<Wallet> =
            retrieve(accountId, WalletRetrieveParams.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            accountId: String,
            params: WalletRetrieveParams = WalletRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Wallet> =
            retrieve(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            accountId: String,
            params: WalletRetrieveParams = WalletRetrieveParams.none(),
        ): HttpResponseFor<Wallet> = retrieve(accountId, params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: WalletRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Wallet>

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(params: WalletRetrieveParams): HttpResponseFor<Wallet> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(accountId: String, requestOptions: RequestOptions): HttpResponseFor<Wallet> =
            retrieve(accountId, WalletRetrieveParams.none(), requestOptions)
    }
}
