// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.v2.entities.EntityCreateParams
import com.dinari.api.models.v2.entities.EntityCreateResponse
import com.dinari.api.models.v2.entities.EntityListParams
import com.dinari.api.models.v2.entities.EntityListResponse
import com.dinari.api.models.v2.entities.EntityRetrieveByIdParams
import com.dinari.api.models.v2.entities.EntityRetrieveByIdResponse
import com.dinari.api.models.v2.entities.EntityRetrieveCurrentParams
import com.dinari.api.models.v2.entities.EntityRetrieveCurrentResponse
import com.dinari.api.models.v2.entities.EntityUpdateParams
import com.dinari.api.models.v2.entities.EntityUpdateResponse
import com.dinari.api.services.blocking.v2.entities.AccountService
import com.dinari.api.services.blocking.v2.entities.KycService
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

/**
 * **`Entities` represent a business or organization that uses the API, and their customers.**
 *
 * Dinari Partners are represented as an organization `Entity` in the API, with their own accounts.
 * Individual customers of Partner `Entities` are also represented as `Entities` in the API, which
 * are managed by the Partner `Entity`.
 */
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

    /**
     * **`Accounts` represent the financial accounts of an `Entity`.**
     *
     * `Orders`, dividends, and other transactions are associated with an `Account`.
     */
    fun accounts(): AccountService

    /**
     * **KYC (Know Your Customer) is a process of verifying the identity of customer `Entities`.**
     *
     * KYC is required for all customer `Entities` that transact on Dinari's platform.
     *
     * Dinari provides a managed KYC process for its Partners, which provides a convenient KYC flow
     * URL to present to the end customer.
     *
     * For Dinari Partners that supply their own KYC data, the API provides a way to record a
     * customer's KYC information using the Partner's KYC data. This requires an existing KYC
     * agreement between Dinari and the Partner.
     */
    fun kyc(): KycService

    /**
     * Create a new `Entity` to be managed by your organization. This `Entity` represents an
     * individual customer of your organization.
     */
    fun create(params: EntityCreateParams): EntityCreateResponse =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: EntityCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EntityCreateResponse

    /** Update a specific customer `Entity` of your organization. */
    fun update(entityId: String): EntityUpdateResponse = update(entityId, EntityUpdateParams.none())

    /** @see update */
    fun update(
        entityId: String,
        params: EntityUpdateParams = EntityUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EntityUpdateResponse = update(params.toBuilder().entityId(entityId).build(), requestOptions)

    /** @see update */
    fun update(
        entityId: String,
        params: EntityUpdateParams = EntityUpdateParams.none(),
    ): EntityUpdateResponse = update(entityId, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: EntityUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EntityUpdateResponse

    /** @see update */
    fun update(params: EntityUpdateParams): EntityUpdateResponse =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(entityId: String, requestOptions: RequestOptions): EntityUpdateResponse =
        update(entityId, EntityUpdateParams.none(), requestOptions)

    /**
     * Get a list of direct `Entities` your organization manages. These `Entities` represent
     * individual customers of your organization.
     */
    fun list(): EntityListResponse = list(EntityListParams.none())

    /** @see list */
    fun list(
        params: EntityListParams = EntityListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EntityListResponse

    /** @see list */
    fun list(params: EntityListParams = EntityListParams.none()): EntityListResponse =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): EntityListResponse =
        list(EntityListParams.none(), requestOptions)

    /** Get a specific customer `Entity` of your organization by their ID. */
    fun retrieveById(entityId: String): EntityRetrieveByIdResponse =
        retrieveById(entityId, EntityRetrieveByIdParams.none())

    /** @see retrieveById */
    fun retrieveById(
        entityId: String,
        params: EntityRetrieveByIdParams = EntityRetrieveByIdParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EntityRetrieveByIdResponse =
        retrieveById(params.toBuilder().entityId(entityId).build(), requestOptions)

    /** @see retrieveById */
    fun retrieveById(
        entityId: String,
        params: EntityRetrieveByIdParams = EntityRetrieveByIdParams.none(),
    ): EntityRetrieveByIdResponse = retrieveById(entityId, params, RequestOptions.none())

    /** @see retrieveById */
    fun retrieveById(
        params: EntityRetrieveByIdParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EntityRetrieveByIdResponse

    /** @see retrieveById */
    fun retrieveById(params: EntityRetrieveByIdParams): EntityRetrieveByIdResponse =
        retrieveById(params, RequestOptions.none())

    /** @see retrieveById */
    fun retrieveById(entityId: String, requestOptions: RequestOptions): EntityRetrieveByIdResponse =
        retrieveById(entityId, EntityRetrieveByIdParams.none(), requestOptions)

    /** Get the current authenticated `Entity`, which represents your organization. */
    fun retrieveCurrent(): EntityRetrieveCurrentResponse =
        retrieveCurrent(EntityRetrieveCurrentParams.none())

    /** @see retrieveCurrent */
    fun retrieveCurrent(
        params: EntityRetrieveCurrentParams = EntityRetrieveCurrentParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EntityRetrieveCurrentResponse

    /** @see retrieveCurrent */
    fun retrieveCurrent(
        params: EntityRetrieveCurrentParams = EntityRetrieveCurrentParams.none()
    ): EntityRetrieveCurrentResponse = retrieveCurrent(params, RequestOptions.none())

    /** @see retrieveCurrent */
    fun retrieveCurrent(requestOptions: RequestOptions): EntityRetrieveCurrentResponse =
        retrieveCurrent(EntityRetrieveCurrentParams.none(), requestOptions)

    /** A view of [EntityService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): EntityService.WithRawResponse

        /**
         * **`Accounts` represent the financial accounts of an `Entity`.**
         *
         * `Orders`, dividends, and other transactions are associated with an `Account`.
         */
        fun accounts(): AccountService.WithRawResponse

        /**
         * **KYC (Know Your Customer) is a process of verifying the identity of customer
         * `Entities`.**
         *
         * KYC is required for all customer `Entities` that transact on Dinari's platform.
         *
         * Dinari provides a managed KYC process for its Partners, which provides a convenient KYC
         * flow URL to present to the end customer.
         *
         * For Dinari Partners that supply their own KYC data, the API provides a way to record a
         * customer's KYC information using the Partner's KYC data. This requires an existing KYC
         * agreement between Dinari and the Partner.
         */
        fun kyc(): KycService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v2/entities/`, but is otherwise the same as
         * [EntityService.create].
         */
        @MustBeClosed
        fun create(params: EntityCreateParams): HttpResponseFor<EntityCreateResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: EntityCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EntityCreateResponse>

        /**
         * Returns a raw HTTP response for `patch /api/v2/entities/{entity_id}`, but is otherwise
         * the same as [EntityService.update].
         */
        @MustBeClosed
        fun update(entityId: String): HttpResponseFor<EntityUpdateResponse> =
            update(entityId, EntityUpdateParams.none())

        /** @see update */
        @MustBeClosed
        fun update(
            entityId: String,
            params: EntityUpdateParams = EntityUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EntityUpdateResponse> =
            update(params.toBuilder().entityId(entityId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(
            entityId: String,
            params: EntityUpdateParams = EntityUpdateParams.none(),
        ): HttpResponseFor<EntityUpdateResponse> = update(entityId, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: EntityUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EntityUpdateResponse>

        /** @see update */
        @MustBeClosed
        fun update(params: EntityUpdateParams): HttpResponseFor<EntityUpdateResponse> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            entityId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EntityUpdateResponse> =
            update(entityId, EntityUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v2/entities/`, but is otherwise the same as
         * [EntityService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<EntityListResponse> = list(EntityListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: EntityListParams = EntityListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EntityListResponse>

        /** @see list */
        @MustBeClosed
        fun list(
            params: EntityListParams = EntityListParams.none()
        ): HttpResponseFor<EntityListResponse> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<EntityListResponse> =
            list(EntityListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v2/entities/{entity_id}`, but is otherwise the
         * same as [EntityService.retrieveById].
         */
        @MustBeClosed
        fun retrieveById(entityId: String): HttpResponseFor<EntityRetrieveByIdResponse> =
            retrieveById(entityId, EntityRetrieveByIdParams.none())

        /** @see retrieveById */
        @MustBeClosed
        fun retrieveById(
            entityId: String,
            params: EntityRetrieveByIdParams = EntityRetrieveByIdParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EntityRetrieveByIdResponse> =
            retrieveById(params.toBuilder().entityId(entityId).build(), requestOptions)

        /** @see retrieveById */
        @MustBeClosed
        fun retrieveById(
            entityId: String,
            params: EntityRetrieveByIdParams = EntityRetrieveByIdParams.none(),
        ): HttpResponseFor<EntityRetrieveByIdResponse> =
            retrieveById(entityId, params, RequestOptions.none())

        /** @see retrieveById */
        @MustBeClosed
        fun retrieveById(
            params: EntityRetrieveByIdParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EntityRetrieveByIdResponse>

        /** @see retrieveById */
        @MustBeClosed
        fun retrieveById(
            params: EntityRetrieveByIdParams
        ): HttpResponseFor<EntityRetrieveByIdResponse> = retrieveById(params, RequestOptions.none())

        /** @see retrieveById */
        @MustBeClosed
        fun retrieveById(
            entityId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EntityRetrieveByIdResponse> =
            retrieveById(entityId, EntityRetrieveByIdParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v2/entities/me`, but is otherwise the same as
         * [EntityService.retrieveCurrent].
         */
        @MustBeClosed
        fun retrieveCurrent(): HttpResponseFor<EntityRetrieveCurrentResponse> =
            retrieveCurrent(EntityRetrieveCurrentParams.none())

        /** @see retrieveCurrent */
        @MustBeClosed
        fun retrieveCurrent(
            params: EntityRetrieveCurrentParams = EntityRetrieveCurrentParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EntityRetrieveCurrentResponse>

        /** @see retrieveCurrent */
        @MustBeClosed
        fun retrieveCurrent(
            params: EntityRetrieveCurrentParams = EntityRetrieveCurrentParams.none()
        ): HttpResponseFor<EntityRetrieveCurrentResponse> =
            retrieveCurrent(params, RequestOptions.none())

        /** @see retrieveCurrent */
        @MustBeClosed
        fun retrieveCurrent(
            requestOptions: RequestOptions
        ): HttpResponseFor<EntityRetrieveCurrentResponse> =
            retrieveCurrent(EntityRetrieveCurrentParams.none(), requestOptions)
    }
}
