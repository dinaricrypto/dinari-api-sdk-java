// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.api.v2.entities

import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.api.v2.entities.accounts.Account
import com.dinari.api.models.api.v2.entities.accounts.AccountCreateParams
import com.dinari.api.models.api.v2.entities.accounts.AccountListParams
import com.google.errorprone.annotations.MustBeClosed
import java.util.concurrent.CompletableFuture

interface AccountServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Creates a new Account for the given Entity. */
    fun create(entityId: String): CompletableFuture<Account> =
        create(entityId, AccountCreateParams.none())

    /** @see [create] */
    fun create(
        entityId: String,
        params: AccountCreateParams = AccountCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Account> =
        create(params.toBuilder().entityId(entityId).build(), requestOptions)

    /** @see [create] */
    fun create(
        entityId: String,
        params: AccountCreateParams = AccountCreateParams.none(),
    ): CompletableFuture<Account> = create(entityId, params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: AccountCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Account>

    /** @see [create] */
    fun create(params: AccountCreateParams): CompletableFuture<Account> =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(entityId: String, requestOptions: RequestOptions): CompletableFuture<Account> =
        create(entityId, AccountCreateParams.none(), requestOptions)

    /** Retrieves a list of Accounts that belong to a specific Entity. */
    fun list(entityId: String): CompletableFuture<List<Account>> =
        list(entityId, AccountListParams.none())

    /** @see [list] */
    fun list(
        entityId: String,
        params: AccountListParams = AccountListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Account>> =
        list(params.toBuilder().entityId(entityId).build(), requestOptions)

    /** @see [list] */
    fun list(
        entityId: String,
        params: AccountListParams = AccountListParams.none(),
    ): CompletableFuture<List<Account>> = list(entityId, params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: AccountListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Account>>

    /** @see [list] */
    fun list(params: AccountListParams): CompletableFuture<List<Account>> =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(entityId: String, requestOptions: RequestOptions): CompletableFuture<List<Account>> =
        list(entityId, AccountListParams.none(), requestOptions)

    /**
     * A view of [AccountServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /api/v2/entities/{entity_id}/accounts`, but is
         * otherwise the same as [AccountServiceAsync.create].
         */
        @MustBeClosed
        fun create(entityId: String): CompletableFuture<HttpResponseFor<Account>> =
            create(entityId, AccountCreateParams.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            entityId: String,
            params: AccountCreateParams = AccountCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Account>> =
            create(params.toBuilder().entityId(entityId).build(), requestOptions)

        /** @see [create] */
        @MustBeClosed
        fun create(
            entityId: String,
            params: AccountCreateParams = AccountCreateParams.none(),
        ): CompletableFuture<HttpResponseFor<Account>> =
            create(entityId, params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: AccountCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Account>>

        /** @see [create] */
        @MustBeClosed
        fun create(params: AccountCreateParams): CompletableFuture<HttpResponseFor<Account>> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            entityId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Account>> =
            create(entityId, AccountCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v2/entities/{entity_id}/accounts`, but is
         * otherwise the same as [AccountServiceAsync.list].
         */
        @MustBeClosed
        fun list(entityId: String): CompletableFuture<HttpResponseFor<List<Account>>> =
            list(entityId, AccountListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            entityId: String,
            params: AccountListParams = AccountListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Account>>> =
            list(params.toBuilder().entityId(entityId).build(), requestOptions)

        /** @see [list] */
        @MustBeClosed
        fun list(
            entityId: String,
            params: AccountListParams = AccountListParams.none(),
        ): CompletableFuture<HttpResponseFor<List<Account>>> =
            list(entityId, params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: AccountListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Account>>>

        /** @see [list] */
        @MustBeClosed
        fun list(params: AccountListParams): CompletableFuture<HttpResponseFor<List<Account>>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            entityId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<Account>>> =
            list(entityId, AccountListParams.none(), requestOptions)
    }
}
