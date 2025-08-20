// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.accounts

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.v2.accounts.tokentransfers.TokenTransfer
import com.dinari.api.models.v2.accounts.tokentransfers.TokenTransferCreateParams
import com.dinari.api.models.v2.accounts.tokentransfers.TokenTransferListParams
import com.dinari.api.models.v2.accounts.tokentransfers.TokenTransferRetrieveParams
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface TokenTransferService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): TokenTransferService

    /**
     * Creates a `TokenTransfer` from this `Account`.
     *
     * A `TokenTransfer` represents a transfer of tokens through the Dinari platform from one
     * `Account` to another. As such, only `Account`s that are connected to Dinari-managed `Wallet`s
     * can initiate `TokenTransfer`s.
     */
    fun create(accountId: String, params: TokenTransferCreateParams): TokenTransfer =
        create(accountId, params, RequestOptions.none())

    /** @see create */
    fun create(
        accountId: String,
        params: TokenTransferCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TokenTransfer = create(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see create */
    fun create(params: TokenTransferCreateParams): TokenTransfer =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: TokenTransferCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TokenTransfer

    /**
     * Get a specific `TokenTransfer` made from this `Account` by its ID.
     *
     * A `TokenTransfer` represents a transfer of tokens through the Dinari platform from one
     * `Account` to another. As such, only `Account`s that are connected to Dinari-managed `Wallet`s
     * can initiate `TokenTransfer`s.
     */
    fun retrieve(transferId: String, params: TokenTransferRetrieveParams): TokenTransfer =
        retrieve(transferId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        transferId: String,
        params: TokenTransferRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TokenTransfer = retrieve(params.toBuilder().transferId(transferId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: TokenTransferRetrieveParams): TokenTransfer =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: TokenTransferRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TokenTransfer

    /**
     * Get `TokenTransfer`s made from this `Account`.
     *
     * A `TokenTransfer` represents a transfer of tokens through the Dinari platform from one
     * `Account` to another. As such, only `Account`s that are connected to Dinari-managed `Wallet`s
     * can initiate `TokenTransfer`s.
     */
    fun list(accountId: String): List<TokenTransfer> =
        list(accountId, TokenTransferListParams.none())

    /** @see list */
    fun list(
        accountId: String,
        params: TokenTransferListParams = TokenTransferListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<TokenTransfer> = list(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see list */
    fun list(
        accountId: String,
        params: TokenTransferListParams = TokenTransferListParams.none(),
    ): List<TokenTransfer> = list(accountId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: TokenTransferListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<TokenTransfer>

    /** @see list */
    fun list(params: TokenTransferListParams): List<TokenTransfer> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(accountId: String, requestOptions: RequestOptions): List<TokenTransfer> =
        list(accountId, TokenTransferListParams.none(), requestOptions)

    /**
     * A view of [TokenTransferService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): TokenTransferService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v2/accounts/{account_id}/token_transfers`, but
         * is otherwise the same as [TokenTransferService.create].
         */
        @MustBeClosed
        fun create(
            accountId: String,
            params: TokenTransferCreateParams,
        ): HttpResponseFor<TokenTransfer> = create(accountId, params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            accountId: String,
            params: TokenTransferCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TokenTransfer> =
            create(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see create */
        @MustBeClosed
        fun create(params: TokenTransferCreateParams): HttpResponseFor<TokenTransfer> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: TokenTransferCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TokenTransfer>

        /**
         * Returns a raw HTTP response for `get
         * /api/v2/accounts/{account_id}/token_transfers/{transfer_id}`, but is otherwise the same
         * as [TokenTransferService.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            transferId: String,
            params: TokenTransferRetrieveParams,
        ): HttpResponseFor<TokenTransfer> = retrieve(transferId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            transferId: String,
            params: TokenTransferRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TokenTransfer> =
            retrieve(params.toBuilder().transferId(transferId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: TokenTransferRetrieveParams): HttpResponseFor<TokenTransfer> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: TokenTransferRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TokenTransfer>

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/token_transfers`, but
         * is otherwise the same as [TokenTransferService.list].
         */
        @MustBeClosed
        fun list(accountId: String): HttpResponseFor<List<TokenTransfer>> =
            list(accountId, TokenTransferListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            accountId: String,
            params: TokenTransferListParams = TokenTransferListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<TokenTransfer>> =
            list(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            accountId: String,
            params: TokenTransferListParams = TokenTransferListParams.none(),
        ): HttpResponseFor<List<TokenTransfer>> = list(accountId, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: TokenTransferListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<TokenTransfer>>

        /** @see list */
        @MustBeClosed
        fun list(params: TokenTransferListParams): HttpResponseFor<List<TokenTransfer>> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            accountId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<TokenTransfer>> =
            list(accountId, TokenTransferListParams.none(), requestOptions)
    }
}
