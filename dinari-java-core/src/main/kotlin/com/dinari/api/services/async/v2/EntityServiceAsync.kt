// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.v2

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.v2.entities.Entity
import com.dinari.api.models.v2.entities.EntityCreateParams
import com.dinari.api.models.v2.entities.EntityListParams
import com.dinari.api.models.v2.entities.EntityRetrieveByIdParams
import com.dinari.api.models.v2.entities.EntityRetrieveCurrentParams
import com.dinari.api.models.v2.entities.EntityUpdateParams
import com.dinari.api.services.async.v2.entities.AccountServiceAsync
import com.dinari.api.services.async.v2.entities.KycServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/**
 * **`Entities` represent a business or organization that uses the API, and their customers.**
 *
 * Dinari Partners are represented as an organization `Entity` in the API, with their own accounts.
 * Individual customers of Partner `Entities` are also represented as `Entities` in the API, which
 * are managed by the Partner `Entity`.
 */
interface EntityServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): EntityServiceAsync

    /**
     * **`Accounts` represent the financial accounts of an `Entity`.**
     *
     * `Orders`, dividends, and other transactions are associated with an `Account`.
     */
    fun accounts(): AccountServiceAsync

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
    fun kyc(): KycServiceAsync

    /**
     * Create a new `Entity` to be managed by your organization. This `Entity` represents an
     * individual customer of your organization.
     */
    fun create(params: EntityCreateParams): CompletableFuture<Entity> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: EntityCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Entity>

    /** Update a specific customer `Entity` of your organization. */
    fun update(entityId: String): CompletableFuture<Entity> =
        update(entityId, EntityUpdateParams.none())

    /** @see update */
    fun update(
        entityId: String,
        params: EntityUpdateParams = EntityUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Entity> =
        update(params.toBuilder().entityId(entityId).build(), requestOptions)

    /** @see update */
    fun update(
        entityId: String,
        params: EntityUpdateParams = EntityUpdateParams.none(),
    ): CompletableFuture<Entity> = update(entityId, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: EntityUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Entity>

    /** @see update */
    fun update(params: EntityUpdateParams): CompletableFuture<Entity> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(entityId: String, requestOptions: RequestOptions): CompletableFuture<Entity> =
        update(entityId, EntityUpdateParams.none(), requestOptions)

    /**
     * Get a list of direct `Entities` your organization manages. These `Entities` represent
     * individual customers of your organization.
     */
    fun list(): CompletableFuture<List<Entity>> = list(EntityListParams.none())

    /** @see list */
    fun list(
        params: EntityListParams = EntityListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Entity>>

    /** @see list */
    fun list(params: EntityListParams = EntityListParams.none()): CompletableFuture<List<Entity>> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<List<Entity>> =
        list(EntityListParams.none(), requestOptions)

    /** Get a specific customer `Entity` of your organization by their ID. */
    fun retrieveById(entityId: String): CompletableFuture<Entity> =
        retrieveById(entityId, EntityRetrieveByIdParams.none())

    /** @see retrieveById */
    fun retrieveById(
        entityId: String,
        params: EntityRetrieveByIdParams = EntityRetrieveByIdParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Entity> =
        retrieveById(params.toBuilder().entityId(entityId).build(), requestOptions)

    /** @see retrieveById */
    fun retrieveById(
        entityId: String,
        params: EntityRetrieveByIdParams = EntityRetrieveByIdParams.none(),
    ): CompletableFuture<Entity> = retrieveById(entityId, params, RequestOptions.none())

    /** @see retrieveById */
    fun retrieveById(
        params: EntityRetrieveByIdParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Entity>

    /** @see retrieveById */
    fun retrieveById(params: EntityRetrieveByIdParams): CompletableFuture<Entity> =
        retrieveById(params, RequestOptions.none())

    /** @see retrieveById */
    fun retrieveById(entityId: String, requestOptions: RequestOptions): CompletableFuture<Entity> =
        retrieveById(entityId, EntityRetrieveByIdParams.none(), requestOptions)

    /** Get the current authenticated `Entity`, which represents your organization. */
    fun retrieveCurrent(): CompletableFuture<Entity> =
        retrieveCurrent(EntityRetrieveCurrentParams.none())

    /** @see retrieveCurrent */
    fun retrieveCurrent(
        params: EntityRetrieveCurrentParams = EntityRetrieveCurrentParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Entity>

    /** @see retrieveCurrent */
    fun retrieveCurrent(
        params: EntityRetrieveCurrentParams = EntityRetrieveCurrentParams.none()
    ): CompletableFuture<Entity> = retrieveCurrent(params, RequestOptions.none())

    /** @see retrieveCurrent */
    fun retrieveCurrent(requestOptions: RequestOptions): CompletableFuture<Entity> =
        retrieveCurrent(EntityRetrieveCurrentParams.none(), requestOptions)

    /**
     * A view of [EntityServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): EntityServiceAsync.WithRawResponse

        /**
         * **`Accounts` represent the financial accounts of an `Entity`.**
         *
         * `Orders`, dividends, and other transactions are associated with an `Account`.
         */
        fun accounts(): AccountServiceAsync.WithRawResponse

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
        fun kyc(): KycServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v2/entities/`, but is otherwise the same as
         * [EntityServiceAsync.create].
         */
        fun create(params: EntityCreateParams): CompletableFuture<HttpResponseFor<Entity>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: EntityCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Entity>>

        /**
         * Returns a raw HTTP response for `patch /api/v2/entities/{entity_id}`, but is otherwise
         * the same as [EntityServiceAsync.update].
         */
        fun update(entityId: String): CompletableFuture<HttpResponseFor<Entity>> =
            update(entityId, EntityUpdateParams.none())

        /** @see update */
        fun update(
            entityId: String,
            params: EntityUpdateParams = EntityUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Entity>> =
            update(params.toBuilder().entityId(entityId).build(), requestOptions)

        /** @see update */
        fun update(
            entityId: String,
            params: EntityUpdateParams = EntityUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<Entity>> =
            update(entityId, params, RequestOptions.none())

        /** @see update */
        fun update(
            params: EntityUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Entity>>

        /** @see update */
        fun update(params: EntityUpdateParams): CompletableFuture<HttpResponseFor<Entity>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            entityId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Entity>> =
            update(entityId, EntityUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v2/entities/`, but is otherwise the same as
         * [EntityServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<List<Entity>>> = list(EntityListParams.none())

        /** @see list */
        fun list(
            params: EntityListParams = EntityListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Entity>>>

        /** @see list */
        fun list(
            params: EntityListParams = EntityListParams.none()
        ): CompletableFuture<HttpResponseFor<List<Entity>>> = list(params, RequestOptions.none())

        /** @see list */
        fun list(requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<List<Entity>>> =
            list(EntityListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v2/entities/{entity_id}`, but is otherwise the
         * same as [EntityServiceAsync.retrieveById].
         */
        fun retrieveById(entityId: String): CompletableFuture<HttpResponseFor<Entity>> =
            retrieveById(entityId, EntityRetrieveByIdParams.none())

        /** @see retrieveById */
        fun retrieveById(
            entityId: String,
            params: EntityRetrieveByIdParams = EntityRetrieveByIdParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Entity>> =
            retrieveById(params.toBuilder().entityId(entityId).build(), requestOptions)

        /** @see retrieveById */
        fun retrieveById(
            entityId: String,
            params: EntityRetrieveByIdParams = EntityRetrieveByIdParams.none(),
        ): CompletableFuture<HttpResponseFor<Entity>> =
            retrieveById(entityId, params, RequestOptions.none())

        /** @see retrieveById */
        fun retrieveById(
            params: EntityRetrieveByIdParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Entity>>

        /** @see retrieveById */
        fun retrieveById(
            params: EntityRetrieveByIdParams
        ): CompletableFuture<HttpResponseFor<Entity>> = retrieveById(params, RequestOptions.none())

        /** @see retrieveById */
        fun retrieveById(
            entityId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Entity>> =
            retrieveById(entityId, EntityRetrieveByIdParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v2/entities/me`, but is otherwise the same as
         * [EntityServiceAsync.retrieveCurrent].
         */
        fun retrieveCurrent(): CompletableFuture<HttpResponseFor<Entity>> =
            retrieveCurrent(EntityRetrieveCurrentParams.none())

        /** @see retrieveCurrent */
        fun retrieveCurrent(
            params: EntityRetrieveCurrentParams = EntityRetrieveCurrentParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Entity>>

        /** @see retrieveCurrent */
        fun retrieveCurrent(
            params: EntityRetrieveCurrentParams = EntityRetrieveCurrentParams.none()
        ): CompletableFuture<HttpResponseFor<Entity>> =
            retrieveCurrent(params, RequestOptions.none())

        /** @see retrieveCurrent */
        fun retrieveCurrent(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<Entity>> =
            retrieveCurrent(EntityRetrieveCurrentParams.none(), requestOptions)
    }
}
