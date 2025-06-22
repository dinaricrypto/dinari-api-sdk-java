// File generated from our OpenAPI spec by Stainless.

package com.dinari.services.async.v2.entities

import com.dinari.core.ClientOptions
import com.dinari.core.RequestOptions
import com.dinari.core.http.HttpResponseFor
import com.dinari.models.v2.entities.kyc.KycCreateManagedCheckParams
import com.dinari.models.v2.entities.kyc.KycCreateManagedCheckResponse
import com.dinari.models.v2.entities.kyc.KycInfo
import com.dinari.models.v2.entities.kyc.KycRetrieveParams
import com.dinari.models.v2.entities.kyc.KycSubmitParams
import com.dinari.services.async.v2.entities.kyc.DocumentServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface KycServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): KycServiceAsync

    fun document(): DocumentServiceAsync

    /**
     * Get most recent KYC data of the `Entity`.
     *
     * If there are any completed KYC checks, data from the most recent one will be returned. If
     * there are no completed KYC checks, the most recent KYC check information, regardless of
     * status, will be returned.
     */
    fun retrieve(entityId: String): CompletableFuture<KycInfo> =
        retrieve(entityId, KycRetrieveParams.none())

    /** @see [retrieve] */
    fun retrieve(
        entityId: String,
        params: KycRetrieveParams = KycRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<KycInfo> =
        retrieve(params.toBuilder().entityId(entityId).build(), requestOptions)

    /** @see [retrieve] */
    fun retrieve(
        entityId: String,
        params: KycRetrieveParams = KycRetrieveParams.none(),
    ): CompletableFuture<KycInfo> = retrieve(entityId, params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: KycRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<KycInfo>

    /** @see [retrieve] */
    fun retrieve(params: KycRetrieveParams): CompletableFuture<KycInfo> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(entityId: String, requestOptions: RequestOptions): CompletableFuture<KycInfo> =
        retrieve(entityId, KycRetrieveParams.none(), requestOptions)

    /**
     * Create a Dinari-managed KYC Check and get a URL for your end customer to interact with.
     *
     * The URL points to a web-based KYC interface that can be presented to the end customer for KYC
     * verification. Once the customer completes this KYC flow, the KYC check will be created and
     * available in the KYC API.
     */
    fun createManagedCheck(entityId: String): CompletableFuture<KycCreateManagedCheckResponse> =
        createManagedCheck(entityId, KycCreateManagedCheckParams.none())

    /** @see [createManagedCheck] */
    fun createManagedCheck(
        entityId: String,
        params: KycCreateManagedCheckParams = KycCreateManagedCheckParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<KycCreateManagedCheckResponse> =
        createManagedCheck(params.toBuilder().entityId(entityId).build(), requestOptions)

    /** @see [createManagedCheck] */
    fun createManagedCheck(
        entityId: String,
        params: KycCreateManagedCheckParams = KycCreateManagedCheckParams.none(),
    ): CompletableFuture<KycCreateManagedCheckResponse> =
        createManagedCheck(entityId, params, RequestOptions.none())

    /** @see [createManagedCheck] */
    fun createManagedCheck(
        params: KycCreateManagedCheckParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<KycCreateManagedCheckResponse>

    /** @see [createManagedCheck] */
    fun createManagedCheck(
        params: KycCreateManagedCheckParams
    ): CompletableFuture<KycCreateManagedCheckResponse> =
        createManagedCheck(params, RequestOptions.none())

    /** @see [createManagedCheck] */
    fun createManagedCheck(
        entityId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<KycCreateManagedCheckResponse> =
        createManagedCheck(entityId, KycCreateManagedCheckParams.none(), requestOptions)

    /**
     * Submit KYC data directly, for partners that are provisioned to provide their own KYC data.
     *
     * This feature is available for everyone in sandbox mode, and for specifically provisioned
     * partners in production.
     */
    fun submit(entityId: String, params: KycSubmitParams): CompletableFuture<KycInfo> =
        submit(entityId, params, RequestOptions.none())

    /** @see [submit] */
    fun submit(
        entityId: String,
        params: KycSubmitParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<KycInfo> =
        submit(params.toBuilder().entityId(entityId).build(), requestOptions)

    /** @see [submit] */
    fun submit(params: KycSubmitParams): CompletableFuture<KycInfo> =
        submit(params, RequestOptions.none())

    /** @see [submit] */
    fun submit(
        params: KycSubmitParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<KycInfo>

    /** A view of [KycServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): KycServiceAsync.WithRawResponse

        fun document(): DocumentServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v2/entities/{entity_id}/kyc`, but is otherwise
         * the same as [KycServiceAsync.retrieve].
         */
        fun retrieve(entityId: String): CompletableFuture<HttpResponseFor<KycInfo>> =
            retrieve(entityId, KycRetrieveParams.none())

        /** @see [retrieve] */
        fun retrieve(
            entityId: String,
            params: KycRetrieveParams = KycRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<KycInfo>> =
            retrieve(params.toBuilder().entityId(entityId).build(), requestOptions)

        /** @see [retrieve] */
        fun retrieve(
            entityId: String,
            params: KycRetrieveParams = KycRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<KycInfo>> =
            retrieve(entityId, params, RequestOptions.none())

        /** @see [retrieve] */
        fun retrieve(
            params: KycRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<KycInfo>>

        /** @see [retrieve] */
        fun retrieve(params: KycRetrieveParams): CompletableFuture<HttpResponseFor<KycInfo>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        fun retrieve(
            entityId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<KycInfo>> =
            retrieve(entityId, KycRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /api/v2/entities/{entity_id}/kyc/url`, but is
         * otherwise the same as [KycServiceAsync.createManagedCheck].
         */
        fun createManagedCheck(
            entityId: String
        ): CompletableFuture<HttpResponseFor<KycCreateManagedCheckResponse>> =
            createManagedCheck(entityId, KycCreateManagedCheckParams.none())

        /** @see [createManagedCheck] */
        fun createManagedCheck(
            entityId: String,
            params: KycCreateManagedCheckParams = KycCreateManagedCheckParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<KycCreateManagedCheckResponse>> =
            createManagedCheck(params.toBuilder().entityId(entityId).build(), requestOptions)

        /** @see [createManagedCheck] */
        fun createManagedCheck(
            entityId: String,
            params: KycCreateManagedCheckParams = KycCreateManagedCheckParams.none(),
        ): CompletableFuture<HttpResponseFor<KycCreateManagedCheckResponse>> =
            createManagedCheck(entityId, params, RequestOptions.none())

        /** @see [createManagedCheck] */
        fun createManagedCheck(
            params: KycCreateManagedCheckParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<KycCreateManagedCheckResponse>>

        /** @see [createManagedCheck] */
        fun createManagedCheck(
            params: KycCreateManagedCheckParams
        ): CompletableFuture<HttpResponseFor<KycCreateManagedCheckResponse>> =
            createManagedCheck(params, RequestOptions.none())

        /** @see [createManagedCheck] */
        fun createManagedCheck(
            entityId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<KycCreateManagedCheckResponse>> =
            createManagedCheck(entityId, KycCreateManagedCheckParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /api/v2/entities/{entity_id}/kyc`, but is otherwise
         * the same as [KycServiceAsync.submit].
         */
        fun submit(
            entityId: String,
            params: KycSubmitParams,
        ): CompletableFuture<HttpResponseFor<KycInfo>> =
            submit(entityId, params, RequestOptions.none())

        /** @see [submit] */
        fun submit(
            entityId: String,
            params: KycSubmitParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<KycInfo>> =
            submit(params.toBuilder().entityId(entityId).build(), requestOptions)

        /** @see [submit] */
        fun submit(params: KycSubmitParams): CompletableFuture<HttpResponseFor<KycInfo>> =
            submit(params, RequestOptions.none())

        /** @see [submit] */
        fun submit(
            params: KycSubmitParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<KycInfo>>
    }
}
