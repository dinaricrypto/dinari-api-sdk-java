// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.api.v2

import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.api.v2.entities.Entity
import com.dinari.api.models.api.v2.entities.EntityCreateParams
import com.dinari.api.models.api.v2.entities.EntityListParams
import com.dinari.api.models.api.v2.entities.EntityRetrieveCurrentParams
import com.dinari.api.models.api.v2.entities.EntityRetrieveParams
import com.dinari.api.services.async.api.v2.entities.AccountServiceAsync
import com.dinari.api.services.async.api.v2.entities.KycServiceAsync
import com.google.errorprone.annotations.MustBeClosed
import java.util.concurrent.CompletableFuture

interface EntityServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun accounts(): AccountServiceAsync

    fun kyc(): KycServiceAsync

    /**
     * Creates a new Entity to be managed by your organization. The Entity represents an individual
     * customer of your organization.
     */
    fun create(params: EntityCreateParams): CompletableFuture<Entity> =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: EntityCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Entity>

    /** Retrieves a specific customer Entity of your organization by their ID. */
    fun retrieve(entityId: String): CompletableFuture<Entity> =
        retrieve(entityId, EntityRetrieveParams.none())

    /** @see [retrieve] */
    fun retrieve(
        entityId: String,
        params: EntityRetrieveParams = EntityRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Entity> =
        retrieve(params.toBuilder().entityId(entityId).build(), requestOptions)

    /** @see [retrieve] */
    fun retrieve(
        entityId: String,
        params: EntityRetrieveParams = EntityRetrieveParams.none(),
    ): CompletableFuture<Entity> = retrieve(entityId, params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: EntityRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Entity>

    /** @see [retrieve] */
    fun retrieve(params: EntityRetrieveParams): CompletableFuture<Entity> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(entityId: String, requestOptions: RequestOptions): CompletableFuture<Entity> =
        retrieve(entityId, EntityRetrieveParams.none(), requestOptions)

    /**
     * Returns a list of all direct Entities your organization manages. An Entity represents an
     * individual customer of your organization.
     */
    fun list(): CompletableFuture<List<Entity>> = list(EntityListParams.none())

    /** @see [list] */
    fun list(
        params: EntityListParams = EntityListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Entity>>

    /** @see [list] */
    fun list(params: EntityListParams = EntityListParams.none()): CompletableFuture<List<Entity>> =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(requestOptions: RequestOptions): CompletableFuture<List<Entity>> =
        list(EntityListParams.none(), requestOptions)

    /** Returns the current authenticated Entity. */
    fun retrieveCurrent(): CompletableFuture<Entity> =
        retrieveCurrent(EntityRetrieveCurrentParams.none())

    /** @see [retrieveCurrent] */
    fun retrieveCurrent(
        params: EntityRetrieveCurrentParams = EntityRetrieveCurrentParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Entity>

    /** @see [retrieveCurrent] */
    fun retrieveCurrent(
        params: EntityRetrieveCurrentParams = EntityRetrieveCurrentParams.none()
    ): CompletableFuture<Entity> = retrieveCurrent(params, RequestOptions.none())

    /** @see [retrieveCurrent] */
    fun retrieveCurrent(requestOptions: RequestOptions): CompletableFuture<Entity> =
        retrieveCurrent(EntityRetrieveCurrentParams.none(), requestOptions)

    /**
     * A view of [EntityServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        fun accounts(): AccountServiceAsync.WithRawResponse

        fun kyc(): KycServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v2/entities/`, but is otherwise the same as
         * [EntityServiceAsync.create].
         */
        @MustBeClosed
        fun create(params: EntityCreateParams): CompletableFuture<HttpResponseFor<Entity>> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: EntityCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Entity>>

        /**
         * Returns a raw HTTP response for `get /api/v2/entities/{entity_id}`, but is otherwise the
         * same as [EntityServiceAsync.retrieve].
         */
        @MustBeClosed
        fun retrieve(entityId: String): CompletableFuture<HttpResponseFor<Entity>> =
            retrieve(entityId, EntityRetrieveParams.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            entityId: String,
            params: EntityRetrieveParams = EntityRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Entity>> =
            retrieve(params.toBuilder().entityId(entityId).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            entityId: String,
            params: EntityRetrieveParams = EntityRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<Entity>> =
            retrieve(entityId, params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: EntityRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Entity>>

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(params: EntityRetrieveParams): CompletableFuture<HttpResponseFor<Entity>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            entityId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Entity>> =
            retrieve(entityId, EntityRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v2/entities/`, but is otherwise the same as
         * [EntityServiceAsync.list].
         */
        @MustBeClosed
        fun list(): CompletableFuture<HttpResponseFor<List<Entity>>> = list(EntityListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: EntityListParams = EntityListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Entity>>>

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: EntityListParams = EntityListParams.none()
        ): CompletableFuture<HttpResponseFor<List<Entity>>> = list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<List<Entity>>> =
            list(EntityListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v2/entities/me`, but is otherwise the same as
         * [EntityServiceAsync.retrieveCurrent].
         */
        @MustBeClosed
        fun retrieveCurrent(): CompletableFuture<HttpResponseFor<Entity>> =
            retrieveCurrent(EntityRetrieveCurrentParams.none())

        /** @see [retrieveCurrent] */
        @MustBeClosed
        fun retrieveCurrent(
            params: EntityRetrieveCurrentParams = EntityRetrieveCurrentParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Entity>>

        /** @see [retrieveCurrent] */
        @MustBeClosed
        fun retrieveCurrent(
            params: EntityRetrieveCurrentParams = EntityRetrieveCurrentParams.none()
        ): CompletableFuture<HttpResponseFor<Entity>> =
            retrieveCurrent(params, RequestOptions.none())

        /** @see [retrieveCurrent] */
        @MustBeClosed
        fun retrieveCurrent(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<Entity>> =
            retrieveCurrent(EntityRetrieveCurrentParams.none(), requestOptions)
    }
}
