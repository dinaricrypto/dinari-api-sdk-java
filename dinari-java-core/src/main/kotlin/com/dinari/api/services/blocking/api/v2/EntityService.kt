// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.api.v2

import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.api.v2.entities.Entity
import com.dinari.api.models.api.v2.entities.EntityCreateParams
import com.dinari.api.models.api.v2.entities.EntityListParams
import com.dinari.api.models.api.v2.entities.EntityRetrieveCurrentParams
import com.dinari.api.models.api.v2.entities.EntityRetrieveParams
import com.dinari.api.services.blocking.api.v2.entities.AccountService
import com.dinari.api.services.blocking.api.v2.entities.KycService
import com.google.errorprone.annotations.MustBeClosed

interface EntityService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun accounts(): AccountService

    fun kyc(): KycService

    /**
     * Creates a new Entity to be managed by your organization. The Entity represents an individual
     * customer of your organization.
     */
    fun create(params: EntityCreateParams): Entity = create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: EntityCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Entity

    /** Retrieves a specific customer Entity of your organization by their ID. */
    fun retrieve(entityId: String): Entity = retrieve(entityId, EntityRetrieveParams.none())

    /** @see [retrieve] */
    fun retrieve(
        entityId: String,
        params: EntityRetrieveParams = EntityRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Entity = retrieve(params.toBuilder().entityId(entityId).build(), requestOptions)

    /** @see [retrieve] */
    fun retrieve(
        entityId: String,
        params: EntityRetrieveParams = EntityRetrieveParams.none(),
    ): Entity = retrieve(entityId, params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: EntityRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Entity

    /** @see [retrieve] */
    fun retrieve(params: EntityRetrieveParams): Entity = retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(entityId: String, requestOptions: RequestOptions): Entity =
        retrieve(entityId, EntityRetrieveParams.none(), requestOptions)

    /**
     * Returns a list of all direct Entities your organization manages. An Entity represents an
     * individual customer of your organization.
     */
    fun list(): List<Entity> = list(EntityListParams.none())

    /** @see [list] */
    fun list(
        params: EntityListParams = EntityListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Entity>

    /** @see [list] */
    fun list(params: EntityListParams = EntityListParams.none()): List<Entity> =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(requestOptions: RequestOptions): List<Entity> =
        list(EntityListParams.none(), requestOptions)

    /** Returns the current authenticated Entity. */
    fun retrieveCurrent(): Entity = retrieveCurrent(EntityRetrieveCurrentParams.none())

    /** @see [retrieveCurrent] */
    fun retrieveCurrent(
        params: EntityRetrieveCurrentParams = EntityRetrieveCurrentParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Entity

    /** @see [retrieveCurrent] */
    fun retrieveCurrent(
        params: EntityRetrieveCurrentParams = EntityRetrieveCurrentParams.none()
    ): Entity = retrieveCurrent(params, RequestOptions.none())

    /** @see [retrieveCurrent] */
    fun retrieveCurrent(requestOptions: RequestOptions): Entity =
        retrieveCurrent(EntityRetrieveCurrentParams.none(), requestOptions)

    /** A view of [EntityService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun accounts(): AccountService.WithRawResponse

        fun kyc(): KycService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v2/entities/`, but is otherwise the same as
         * [EntityService.create].
         */
        @MustBeClosed
        fun create(params: EntityCreateParams): HttpResponseFor<Entity> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: EntityCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Entity>

        /**
         * Returns a raw HTTP response for `get /api/v2/entities/{entity_id}`, but is otherwise the
         * same as [EntityService.retrieve].
         */
        @MustBeClosed
        fun retrieve(entityId: String): HttpResponseFor<Entity> =
            retrieve(entityId, EntityRetrieveParams.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            entityId: String,
            params: EntityRetrieveParams = EntityRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Entity> =
            retrieve(params.toBuilder().entityId(entityId).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            entityId: String,
            params: EntityRetrieveParams = EntityRetrieveParams.none(),
        ): HttpResponseFor<Entity> = retrieve(entityId, params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: EntityRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Entity>

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(params: EntityRetrieveParams): HttpResponseFor<Entity> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(entityId: String, requestOptions: RequestOptions): HttpResponseFor<Entity> =
            retrieve(entityId, EntityRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v2/entities/`, but is otherwise the same as
         * [EntityService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<List<Entity>> = list(EntityListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: EntityListParams = EntityListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Entity>>

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: EntityListParams = EntityListParams.none()
        ): HttpResponseFor<List<Entity>> = list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<List<Entity>> =
            list(EntityListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v2/entities/me`, but is otherwise the same as
         * [EntityService.retrieveCurrent].
         */
        @MustBeClosed
        fun retrieveCurrent(): HttpResponseFor<Entity> =
            retrieveCurrent(EntityRetrieveCurrentParams.none())

        /** @see [retrieveCurrent] */
        @MustBeClosed
        fun retrieveCurrent(
            params: EntityRetrieveCurrentParams = EntityRetrieveCurrentParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Entity>

        /** @see [retrieveCurrent] */
        @MustBeClosed
        fun retrieveCurrent(
            params: EntityRetrieveCurrentParams = EntityRetrieveCurrentParams.none()
        ): HttpResponseFor<Entity> = retrieveCurrent(params, RequestOptions.none())

        /** @see [retrieveCurrent] */
        @MustBeClosed
        fun retrieveCurrent(requestOptions: RequestOptions): HttpResponseFor<Entity> =
            retrieveCurrent(EntityRetrieveCurrentParams.none(), requestOptions)
    }
}
