// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.api.v2.entities

import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.api.v2.entities.accounts.Account
import com.dinari.api.models.api.v2.entities.accounts.AccountCreateParams
import com.dinari.api.models.api.v2.entities.accounts.AccountListParams
import com.google.errorprone.annotations.MustBeClosed

interface AccountService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Creates a new Account for the given Entity. */
    fun create(entityId: String): Account = create(entityId, AccountCreateParams.none())

    /** @see [create] */
    fun create(
        entityId: String,
        params: AccountCreateParams = AccountCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Account = create(params.toBuilder().entityId(entityId).build(), requestOptions)

    /** @see [create] */
    fun create(
        entityId: String,
        params: AccountCreateParams = AccountCreateParams.none(),
    ): Account = create(entityId, params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: AccountCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Account

    /** @see [create] */
    fun create(params: AccountCreateParams): Account = create(params, RequestOptions.none())

    /** @see [create] */
    fun create(entityId: String, requestOptions: RequestOptions): Account =
        create(entityId, AccountCreateParams.none(), requestOptions)

    /** Retrieves a list of Accounts that belong to a specific Entity. */
    fun list(entityId: String): List<Account> = list(entityId, AccountListParams.none())

    /** @see [list] */
    fun list(
        entityId: String,
        params: AccountListParams = AccountListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Account> = list(params.toBuilder().entityId(entityId).build(), requestOptions)

    /** @see [list] */
    fun list(
        entityId: String,
        params: AccountListParams = AccountListParams.none(),
    ): List<Account> = list(entityId, params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: AccountListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Account>

    /** @see [list] */
    fun list(params: AccountListParams): List<Account> = list(params, RequestOptions.none())

    /** @see [list] */
    fun list(entityId: String, requestOptions: RequestOptions): List<Account> =
        list(entityId, AccountListParams.none(), requestOptions)

    /** A view of [AccountService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /api/v2/entities/{entity_id}/accounts`, but is
         * otherwise the same as [AccountService.create].
         */
        @MustBeClosed
        fun create(entityId: String): HttpResponseFor<Account> =
            create(entityId, AccountCreateParams.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            entityId: String,
            params: AccountCreateParams = AccountCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Account> =
            create(params.toBuilder().entityId(entityId).build(), requestOptions)

        /** @see [create] */
        @MustBeClosed
        fun create(
            entityId: String,
            params: AccountCreateParams = AccountCreateParams.none(),
        ): HttpResponseFor<Account> = create(entityId, params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: AccountCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Account>

        /** @see [create] */
        @MustBeClosed
        fun create(params: AccountCreateParams): HttpResponseFor<Account> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(entityId: String, requestOptions: RequestOptions): HttpResponseFor<Account> =
            create(entityId, AccountCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v2/entities/{entity_id}/accounts`, but is
         * otherwise the same as [AccountService.list].
         */
        @MustBeClosed
        fun list(entityId: String): HttpResponseFor<List<Account>> =
            list(entityId, AccountListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            entityId: String,
            params: AccountListParams = AccountListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Account>> =
            list(params.toBuilder().entityId(entityId).build(), requestOptions)

        /** @see [list] */
        @MustBeClosed
        fun list(
            entityId: String,
            params: AccountListParams = AccountListParams.none(),
        ): HttpResponseFor<List<Account>> = list(entityId, params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: AccountListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Account>>

        /** @see [list] */
        @MustBeClosed
        fun list(params: AccountListParams): HttpResponseFor<List<Account>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(entityId: String, requestOptions: RequestOptions): HttpResponseFor<List<Account>> =
            list(entityId, AccountListParams.none(), requestOptions)
    }
}
