// File generated from our OpenAPI spec by Stainless.

package com.dinari.services.blocking.v2.entities

import com.dinari.core.ClientOptions
import com.dinari.core.RequestOptions
import com.dinari.core.http.HttpResponseFor
import com.dinari.models.v2.entities.accounts.Account
import com.dinari.models.v2.entities.accounts.AccountCreateParams
import com.dinari.models.v2.entities.accounts.AccountListParams
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface AccountService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AccountService

    /**
     * Create a new `Account` for a specific `Entity`. This `Entity` represents your organization
     * itself, or an individual customer of your organization.
     */
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

    /**
     * Get a list of all `Accounts` that belong to a specific `Entity`. This `Entity` represents
     * your organization itself, or an individual customer of your organization.
     */
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
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): AccountService.WithRawResponse

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
