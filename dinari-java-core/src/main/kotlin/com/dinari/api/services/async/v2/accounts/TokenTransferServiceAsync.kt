// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.v2.accounts

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.v2.accounts.tokentransfers.TokenTransfer
import com.dinari.api.models.v2.accounts.tokentransfers.TokenTransferCreateParams
import com.dinari.api.models.v2.accounts.tokentransfers.TokenTransferListParams
import com.dinari.api.models.v2.accounts.tokentransfers.TokenTransferRetrieveParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface TokenTransferServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): TokenTransferServiceAsync

    /**
     * Creates a `TokenTransfer` from this `Account`.
     *
     * A `TokenTransfer` represents a transfer of tokens through the Dinari platform from one
     * `Account` to another. As such, only `Account`s that are connected to Dinari-managed `Wallet`s
     * can initiate `TokenTransfer`s.
     */
    fun create(
        accountId: String,
        params: TokenTransferCreateParams,
    ): CompletableFuture<TokenTransfer> = create(accountId, params, RequestOptions.none())

    /** @see create */
    fun create(
        accountId: String,
        params: TokenTransferCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TokenTransfer> =
        create(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see create */
    fun create(params: TokenTransferCreateParams): CompletableFuture<TokenTransfer> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: TokenTransferCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TokenTransfer>

    /**
     * Get a specific `TokenTransfer` made from this `Account` by its ID.
     *
     * A `TokenTransfer` represents a transfer of tokens through the Dinari platform from one
     * `Account` to another. As such, only `Account`s that are connected to Dinari-managed `Wallet`s
     * can initiate `TokenTransfer`s.
     */
    fun retrieve(
        transferId: String,
        params: TokenTransferRetrieveParams,
    ): CompletableFuture<TokenTransfer> = retrieve(transferId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        transferId: String,
        params: TokenTransferRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TokenTransfer> =
        retrieve(params.toBuilder().transferId(transferId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: TokenTransferRetrieveParams): CompletableFuture<TokenTransfer> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: TokenTransferRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TokenTransfer>

    /**
     * Get `TokenTransfer`s made from this `Account`.
     *
     * A `TokenTransfer` represents a transfer of tokens through the Dinari platform from one
     * `Account` to another. As such, only `Account`s that are connected to Dinari-managed `Wallet`s
     * can initiate `TokenTransfer`s.
     */
    fun list(accountId: String): CompletableFuture<List<TokenTransfer>> =
        list(accountId, TokenTransferListParams.none())

    /** @see list */
    fun list(
        accountId: String,
        params: TokenTransferListParams = TokenTransferListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<TokenTransfer>> =
        list(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see list */
    fun list(
        accountId: String,
        params: TokenTransferListParams = TokenTransferListParams.none(),
    ): CompletableFuture<List<TokenTransfer>> = list(accountId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: TokenTransferListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<TokenTransfer>>

    /** @see list */
    fun list(params: TokenTransferListParams): CompletableFuture<List<TokenTransfer>> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        accountId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<TokenTransfer>> =
        list(accountId, TokenTransferListParams.none(), requestOptions)

    /**
     * A view of [TokenTransferServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): TokenTransferServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v2/accounts/{account_id}/token_transfers`, but
         * is otherwise the same as [TokenTransferServiceAsync.create].
         */
        fun create(
            accountId: String,
            params: TokenTransferCreateParams,
        ): CompletableFuture<HttpResponseFor<TokenTransfer>> =
            create(accountId, params, RequestOptions.none())

        /** @see create */
        fun create(
            accountId: String,
            params: TokenTransferCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TokenTransfer>> =
            create(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see create */
        fun create(
            params: TokenTransferCreateParams
        ): CompletableFuture<HttpResponseFor<TokenTransfer>> = create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: TokenTransferCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TokenTransfer>>

        /**
         * Returns a raw HTTP response for `get
         * /api/v2/accounts/{account_id}/token_transfers/{transfer_id}`, but is otherwise the same
         * as [TokenTransferServiceAsync.retrieve].
         */
        fun retrieve(
            transferId: String,
            params: TokenTransferRetrieveParams,
        ): CompletableFuture<HttpResponseFor<TokenTransfer>> =
            retrieve(transferId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            transferId: String,
            params: TokenTransferRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TokenTransfer>> =
            retrieve(params.toBuilder().transferId(transferId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            params: TokenTransferRetrieveParams
        ): CompletableFuture<HttpResponseFor<TokenTransfer>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: TokenTransferRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TokenTransfer>>

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/token_transfers`, but
         * is otherwise the same as [TokenTransferServiceAsync.list].
         */
        fun list(accountId: String): CompletableFuture<HttpResponseFor<List<TokenTransfer>>> =
            list(accountId, TokenTransferListParams.none())

        /** @see list */
        fun list(
            accountId: String,
            params: TokenTransferListParams = TokenTransferListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<TokenTransfer>>> =
            list(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see list */
        fun list(
            accountId: String,
            params: TokenTransferListParams = TokenTransferListParams.none(),
        ): CompletableFuture<HttpResponseFor<List<TokenTransfer>>> =
            list(accountId, params, RequestOptions.none())

        /** @see list */
        fun list(
            params: TokenTransferListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<TokenTransfer>>>

        /** @see list */
        fun list(
            params: TokenTransferListParams
        ): CompletableFuture<HttpResponseFor<List<TokenTransfer>>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            accountId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<TokenTransfer>>> =
            list(accountId, TokenTransferListParams.none(), requestOptions)
    }
}
