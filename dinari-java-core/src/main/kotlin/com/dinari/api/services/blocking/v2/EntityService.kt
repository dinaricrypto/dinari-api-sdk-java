// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.v2.entities.Entity
import com.dinari.api.models.v2.entities.EntityCreateParams
import com.dinari.api.models.v2.entities.EntityListParams
import com.dinari.api.models.v2.entities.EntityRetrieveByIdParams
import com.dinari.api.models.v2.entities.EntityRetrieveCurrentParams
import com.dinari.api.services.blocking.v2.entities.AccountService
import com.dinari.api.services.blocking.v2.entities.KycService
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface EntityService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): EntityService

    fun accounts(): AccountService

    fun kyc(): KycService

    /**
     * Create a new `Entity` to be managed by your organization. This `Entity` represents an
     * individual customer of your organization.
     */
    fun create(params: EntityCreateParams): Entity = create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: EntityCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Entity

    /**
     * Get a list of all direct `Entities` your organization manages. These `Entities` represent
     * individual customers of your organization.
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

    /** Get a specific customer `Entity` of your organization by their ID. */
    fun retrieveById(entityId: String): Entity =
        retrieveById(entityId, EntityRetrieveByIdParams.none())

    /** @see [retrieveById] */
    fun retrieveById(
        entityId: String,
        params: EntityRetrieveByIdParams = EntityRetrieveByIdParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Entity = retrieveById(params.toBuilder().entityId(entityId).build(), requestOptions)

    /** @see [retrieveById] */
    fun retrieveById(
        entityId: String,
        params: EntityRetrieveByIdParams = EntityRetrieveByIdParams.none(),
    ): Entity = retrieveById(entityId, params, RequestOptions.none())

    /** @see [retrieveById] */
    fun retrieveById(
        params: EntityRetrieveByIdParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Entity

    /** @see [retrieveById] */
    fun retrieveById(params: EntityRetrieveByIdParams): Entity =
        retrieveById(params, RequestOptions.none())

    /** @see [retrieveById] */
    fun retrieveById(entityId: String, requestOptions: RequestOptions): Entity =
        retrieveById(entityId, EntityRetrieveByIdParams.none(), requestOptions)

    /** Get the current authenticated `Entity`, which represents your organization. */
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

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): EntityService.WithRawResponse

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
         * Returns a raw HTTP response for `get /api/v2/entities/{entity_id}`, but is otherwise the
         * same as [EntityService.retrieveById].
         */
        @MustBeClosed
        fun retrieveById(entityId: String): HttpResponseFor<Entity> =
            retrieveById(entityId, EntityRetrieveByIdParams.none())

        /** @see [retrieveById] */
        @MustBeClosed
        fun retrieveById(
            entityId: String,
            params: EntityRetrieveByIdParams = EntityRetrieveByIdParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Entity> =
            retrieveById(params.toBuilder().entityId(entityId).build(), requestOptions)

        /** @see [retrieveById] */
        @MustBeClosed
        fun retrieveById(
            entityId: String,
            params: EntityRetrieveByIdParams = EntityRetrieveByIdParams.none(),
        ): HttpResponseFor<Entity> = retrieveById(entityId, params, RequestOptions.none())

        /** @see [retrieveById] */
        @MustBeClosed
        fun retrieveById(
            params: EntityRetrieveByIdParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Entity>

        /** @see [retrieveById] */
        @MustBeClosed
        fun retrieveById(params: EntityRetrieveByIdParams): HttpResponseFor<Entity> =
            retrieveById(params, RequestOptions.none())

        /** @see [retrieveById] */
        @MustBeClosed
        fun retrieveById(
            entityId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Entity> =
            retrieveById(entityId, EntityRetrieveByIdParams.none(), requestOptions)

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
