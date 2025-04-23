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
    fun retrieve(params: WalletRetrieveParams): Wallet = retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: WalletRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Wallet

    /** A view of [WalletService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun external(): ExternalService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/wallet`, but is
         * otherwise the same as [WalletService.retrieve].
         */
        @MustBeClosed
        fun retrieve(params: WalletRetrieveParams): HttpResponseFor<Wallet> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: WalletRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Wallet>
    }
}
