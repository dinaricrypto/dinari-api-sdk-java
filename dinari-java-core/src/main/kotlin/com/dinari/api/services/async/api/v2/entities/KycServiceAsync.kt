// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.api.v2.entities

import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.api.v2.entities.kyc.KycInfo
import com.dinari.api.models.api.v2.entities.kyc.KycRetrieveParams
import com.dinari.api.models.api.v2.entities.kyc.KycSubmitParams
import com.dinari.api.models.api.v2.entities.kyc.KycUploadDocumentParams
import com.dinari.api.models.api.v2.entities.kyc.KycUploadDocumentResponse
import com.google.errorprone.annotations.MustBeClosed
import java.util.concurrent.CompletableFuture

interface KycServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

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

    /**
     * Upload KYC-related documentation for partners that are provisioned to provide their own KYC
     * data.
     */
    fun uploadDocument(
        kycId: String,
        params: KycUploadDocumentParams,
    ): CompletableFuture<KycUploadDocumentResponse> =
        uploadDocument(kycId, params, RequestOptions.none())

    /** @see [uploadDocument] */
    fun uploadDocument(
        kycId: String,
        params: KycUploadDocumentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<KycUploadDocumentResponse> =
        uploadDocument(params.toBuilder().kycId(kycId).build(), requestOptions)

    /** @see [uploadDocument] */
    fun uploadDocument(
        params: KycUploadDocumentParams
    ): CompletableFuture<KycUploadDocumentResponse> = uploadDocument(params, RequestOptions.none())

    /** @see [uploadDocument] */
    fun uploadDocument(
        params: KycUploadDocumentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<KycUploadDocumentResponse>

    /** A view of [KycServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /api/v2/entities/{entity_id}/kyc`, but is otherwise
         * the same as [KycServiceAsync.retrieve].
         */
        @MustBeClosed
        fun retrieve(entityId: String): CompletableFuture<HttpResponseFor<KycInfo>> =
            retrieve(entityId, KycRetrieveParams.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            entityId: String,
            params: KycRetrieveParams = KycRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<KycInfo>> =
            retrieve(params.toBuilder().entityId(entityId).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            entityId: String,
            params: KycRetrieveParams = KycRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<KycInfo>> =
            retrieve(entityId, params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: KycRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<KycInfo>>

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(params: KycRetrieveParams): CompletableFuture<HttpResponseFor<KycInfo>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            entityId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<KycInfo>> =
            retrieve(entityId, KycRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /api/v2/entities/{entity_id}/kyc`, but is otherwise
         * the same as [KycServiceAsync.submit].
         */
        @MustBeClosed
        fun submit(
            entityId: String,
            params: KycSubmitParams,
        ): CompletableFuture<HttpResponseFor<KycInfo>> =
            submit(entityId, params, RequestOptions.none())

        /** @see [submit] */
        @MustBeClosed
        fun submit(
            entityId: String,
            params: KycSubmitParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<KycInfo>> =
            submit(params.toBuilder().entityId(entityId).build(), requestOptions)

        /** @see [submit] */
        @MustBeClosed
        fun submit(params: KycSubmitParams): CompletableFuture<HttpResponseFor<KycInfo>> =
            submit(params, RequestOptions.none())

        /** @see [submit] */
        @MustBeClosed
        fun submit(
            params: KycSubmitParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<KycInfo>>

        /**
         * Returns a raw HTTP response for `post
         * /api/v2/entities/{entity_id}/kyc/{kyc_id}/document`, but is otherwise the same as
         * [KycServiceAsync.uploadDocument].
         */
        @MustBeClosed
        fun uploadDocument(
            kycId: String,
            params: KycUploadDocumentParams,
        ): CompletableFuture<HttpResponseFor<KycUploadDocumentResponse>> =
            uploadDocument(kycId, params, RequestOptions.none())

        /** @see [uploadDocument] */
        @MustBeClosed
        fun uploadDocument(
            kycId: String,
            params: KycUploadDocumentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<KycUploadDocumentResponse>> =
            uploadDocument(params.toBuilder().kycId(kycId).build(), requestOptions)

        /** @see [uploadDocument] */
        @MustBeClosed
        fun uploadDocument(
            params: KycUploadDocumentParams
        ): CompletableFuture<HttpResponseFor<KycUploadDocumentResponse>> =
            uploadDocument(params, RequestOptions.none())

        /** @see [uploadDocument] */
        @MustBeClosed
        fun uploadDocument(
            params: KycUploadDocumentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<KycUploadDocumentResponse>>
    }
}
