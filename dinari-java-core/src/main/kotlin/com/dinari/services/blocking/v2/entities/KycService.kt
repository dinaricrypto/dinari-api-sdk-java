// File generated from our OpenAPI spec by Stainless.

package com.dinari.services.blocking.v2.entities

import com.dinari.core.ClientOptions
import com.dinari.core.RequestOptions
import com.dinari.core.http.HttpResponseFor
import com.dinari.models.v2.entities.kyc.KycCreateManagedCheckParams
import com.dinari.models.v2.entities.kyc.KycCreateManagedCheckResponse
import com.dinari.models.v2.entities.kyc.KycInfo
import com.dinari.models.v2.entities.kyc.KycRetrieveParams
import com.dinari.models.v2.entities.kyc.KycSubmitParams
import com.dinari.services.blocking.v2.entities.kyc.DocumentService
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface KycService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): KycService

    fun document(): DocumentService

    /**
     * Get most recent KYC data of the `Entity`.
     *
     * If there are any completed KYC checks, data from the most recent one will be returned. If
     * there are no completed KYC checks, the most recent KYC check information, regardless of
     * status, will be returned.
     */
    fun retrieve(entityId: String): KycInfo = retrieve(entityId, KycRetrieveParams.none())

    /** @see [retrieve] */
    fun retrieve(
        entityId: String,
        params: KycRetrieveParams = KycRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): KycInfo = retrieve(params.toBuilder().entityId(entityId).build(), requestOptions)

    /** @see [retrieve] */
    fun retrieve(entityId: String, params: KycRetrieveParams = KycRetrieveParams.none()): KycInfo =
        retrieve(entityId, params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: KycRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): KycInfo

    /** @see [retrieve] */
    fun retrieve(params: KycRetrieveParams): KycInfo = retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(entityId: String, requestOptions: RequestOptions): KycInfo =
        retrieve(entityId, KycRetrieveParams.none(), requestOptions)

    /**
     * Create a Dinari-managed KYC Check and get a URL for your end customer to interact with.
     *
     * The URL points to a web-based KYC interface that can be presented to the end customer for KYC
     * verification. Once the customer completes this KYC flow, the KYC check will be created and
     * available in the KYC API.
     */
    fun createManagedCheck(entityId: String): KycCreateManagedCheckResponse =
        createManagedCheck(entityId, KycCreateManagedCheckParams.none())

    /** @see [createManagedCheck] */
    fun createManagedCheck(
        entityId: String,
        params: KycCreateManagedCheckParams = KycCreateManagedCheckParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): KycCreateManagedCheckResponse =
        createManagedCheck(params.toBuilder().entityId(entityId).build(), requestOptions)

    /** @see [createManagedCheck] */
    fun createManagedCheck(
        entityId: String,
        params: KycCreateManagedCheckParams = KycCreateManagedCheckParams.none(),
    ): KycCreateManagedCheckResponse = createManagedCheck(entityId, params, RequestOptions.none())

    /** @see [createManagedCheck] */
    fun createManagedCheck(
        params: KycCreateManagedCheckParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): KycCreateManagedCheckResponse

    /** @see [createManagedCheck] */
    fun createManagedCheck(params: KycCreateManagedCheckParams): KycCreateManagedCheckResponse =
        createManagedCheck(params, RequestOptions.none())

    /** @see [createManagedCheck] */
    fun createManagedCheck(
        entityId: String,
        requestOptions: RequestOptions,
    ): KycCreateManagedCheckResponse =
        createManagedCheck(entityId, KycCreateManagedCheckParams.none(), requestOptions)

    /**
     * Submit KYC data directly, for partners that are provisioned to provide their own KYC data.
     *
     * This feature is available for everyone in sandbox mode, and for specifically provisioned
     * partners in production.
     */
    fun submit(entityId: String, params: KycSubmitParams): KycInfo =
        submit(entityId, params, RequestOptions.none())

    /** @see [submit] */
    fun submit(
        entityId: String,
        params: KycSubmitParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): KycInfo = submit(params.toBuilder().entityId(entityId).build(), requestOptions)

    /** @see [submit] */
    fun submit(params: KycSubmitParams): KycInfo = submit(params, RequestOptions.none())

    /** @see [submit] */
    fun submit(
        params: KycSubmitParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): KycInfo

    /** A view of [KycService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): KycService.WithRawResponse

        fun document(): DocumentService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v2/entities/{entity_id}/kyc`, but is otherwise
         * the same as [KycService.retrieve].
         */
        @MustBeClosed
        fun retrieve(entityId: String): HttpResponseFor<KycInfo> =
            retrieve(entityId, KycRetrieveParams.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            entityId: String,
            params: KycRetrieveParams = KycRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<KycInfo> =
            retrieve(params.toBuilder().entityId(entityId).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            entityId: String,
            params: KycRetrieveParams = KycRetrieveParams.none(),
        ): HttpResponseFor<KycInfo> = retrieve(entityId, params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: KycRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<KycInfo>

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(params: KycRetrieveParams): HttpResponseFor<KycInfo> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(entityId: String, requestOptions: RequestOptions): HttpResponseFor<KycInfo> =
            retrieve(entityId, KycRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /api/v2/entities/{entity_id}/kyc/url`, but is
         * otherwise the same as [KycService.createManagedCheck].
         */
        @MustBeClosed
        fun createManagedCheck(entityId: String): HttpResponseFor<KycCreateManagedCheckResponse> =
            createManagedCheck(entityId, KycCreateManagedCheckParams.none())

        /** @see [createManagedCheck] */
        @MustBeClosed
        fun createManagedCheck(
            entityId: String,
            params: KycCreateManagedCheckParams = KycCreateManagedCheckParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<KycCreateManagedCheckResponse> =
            createManagedCheck(params.toBuilder().entityId(entityId).build(), requestOptions)

        /** @see [createManagedCheck] */
        @MustBeClosed
        fun createManagedCheck(
            entityId: String,
            params: KycCreateManagedCheckParams = KycCreateManagedCheckParams.none(),
        ): HttpResponseFor<KycCreateManagedCheckResponse> =
            createManagedCheck(entityId, params, RequestOptions.none())

        /** @see [createManagedCheck] */
        @MustBeClosed
        fun createManagedCheck(
            params: KycCreateManagedCheckParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<KycCreateManagedCheckResponse>

        /** @see [createManagedCheck] */
        @MustBeClosed
        fun createManagedCheck(
            params: KycCreateManagedCheckParams
        ): HttpResponseFor<KycCreateManagedCheckResponse> =
            createManagedCheck(params, RequestOptions.none())

        /** @see [createManagedCheck] */
        @MustBeClosed
        fun createManagedCheck(
            entityId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<KycCreateManagedCheckResponse> =
            createManagedCheck(entityId, KycCreateManagedCheckParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /api/v2/entities/{entity_id}/kyc`, but is otherwise
         * the same as [KycService.submit].
         */
        @MustBeClosed
        fun submit(entityId: String, params: KycSubmitParams): HttpResponseFor<KycInfo> =
            submit(entityId, params, RequestOptions.none())

        /** @see [submit] */
        @MustBeClosed
        fun submit(
            entityId: String,
            params: KycSubmitParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<KycInfo> =
            submit(params.toBuilder().entityId(entityId).build(), requestOptions)

        /** @see [submit] */
        @MustBeClosed
        fun submit(params: KycSubmitParams): HttpResponseFor<KycInfo> =
            submit(params, RequestOptions.none())

        /** @see [submit] */
        @MustBeClosed
        fun submit(
            params: KycSubmitParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<KycInfo>
    }
}
