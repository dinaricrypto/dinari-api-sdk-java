// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.v2.entities.kyc

import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.v2.entities.kyc.document.DocumentRetrieveParams
import com.dinari.api.models.v2.entities.kyc.document.DocumentUploadParams
import com.dinari.api.models.v2.entities.kyc.document.KycDocument
import com.google.errorprone.annotations.MustBeClosed
import java.util.concurrent.CompletableFuture

interface DocumentServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Get uploaded documents for a KYC check */
    fun retrieve(
        kycId: String,
        params: DocumentRetrieveParams,
    ): CompletableFuture<List<KycDocument>> = retrieve(kycId, params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        kycId: String,
        params: DocumentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<KycDocument>> =
        retrieve(params.toBuilder().kycId(kycId).build(), requestOptions)

    /** @see [retrieve] */
    fun retrieve(params: DocumentRetrieveParams): CompletableFuture<List<KycDocument>> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: DocumentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<KycDocument>>

    /**
     * Upload KYC-related documentation for partners that are provisioned to provide their own KYC
     * data.
     */
    fun upload(kycId: String, params: DocumentUploadParams): CompletableFuture<KycDocument> =
        upload(kycId, params, RequestOptions.none())

    /** @see [upload] */
    fun upload(
        kycId: String,
        params: DocumentUploadParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<KycDocument> =
        upload(params.toBuilder().kycId(kycId).build(), requestOptions)

    /** @see [upload] */
    fun upload(params: DocumentUploadParams): CompletableFuture<KycDocument> =
        upload(params, RequestOptions.none())

    /** @see [upload] */
    fun upload(
        params: DocumentUploadParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<KycDocument>

    /**
     * A view of [DocumentServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /api/v2/entities/{entity_id}/kyc/{kyc_id}/document`,
         * but is otherwise the same as [DocumentServiceAsync.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            kycId: String,
            params: DocumentRetrieveParams,
        ): CompletableFuture<HttpResponseFor<List<KycDocument>>> =
            retrieve(kycId, params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            kycId: String,
            params: DocumentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<KycDocument>>> =
            retrieve(params.toBuilder().kycId(kycId).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: DocumentRetrieveParams
        ): CompletableFuture<HttpResponseFor<List<KycDocument>>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: DocumentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<KycDocument>>>

        /**
         * Returns a raw HTTP response for `post
         * /api/v2/entities/{entity_id}/kyc/{kyc_id}/document`, but is otherwise the same as
         * [DocumentServiceAsync.upload].
         */
        @MustBeClosed
        fun upload(
            kycId: String,
            params: DocumentUploadParams,
        ): CompletableFuture<HttpResponseFor<KycDocument>> =
            upload(kycId, params, RequestOptions.none())

        /** @see [upload] */
        @MustBeClosed
        fun upload(
            kycId: String,
            params: DocumentUploadParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<KycDocument>> =
            upload(params.toBuilder().kycId(kycId).build(), requestOptions)

        /** @see [upload] */
        @MustBeClosed
        fun upload(params: DocumentUploadParams): CompletableFuture<HttpResponseFor<KycDocument>> =
            upload(params, RequestOptions.none())

        /** @see [upload] */
        @MustBeClosed
        fun upload(
            params: DocumentUploadParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<KycDocument>>
    }
}
