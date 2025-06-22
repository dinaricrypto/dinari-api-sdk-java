// File generated from our OpenAPI spec by Stainless.

package com.dinari.services.blocking.v2.entities.kyc

import com.dinari.core.ClientOptions
import com.dinari.core.RequestOptions
import com.dinari.core.http.HttpResponseFor
import com.dinari.models.v2.entities.kyc.document.DocumentRetrieveParams
import com.dinari.models.v2.entities.kyc.document.DocumentUploadParams
import com.dinari.models.v2.entities.kyc.document.KycDocument
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface DocumentService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): DocumentService

    /** Get uploaded documents for a KYC check */
    fun retrieve(kycId: String, params: DocumentRetrieveParams): List<KycDocument> =
        retrieve(kycId, params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        kycId: String,
        params: DocumentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<KycDocument> = retrieve(params.toBuilder().kycId(kycId).build(), requestOptions)

    /** @see [retrieve] */
    fun retrieve(params: DocumentRetrieveParams): List<KycDocument> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: DocumentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<KycDocument>

    /**
     * Upload KYC-related documentation for partners that are provisioned to provide their own KYC
     * data.
     */
    fun upload(kycId: String, params: DocumentUploadParams): KycDocument =
        upload(kycId, params, RequestOptions.none())

    /** @see [upload] */
    fun upload(
        kycId: String,
        params: DocumentUploadParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): KycDocument = upload(params.toBuilder().kycId(kycId).build(), requestOptions)

    /** @see [upload] */
    fun upload(params: DocumentUploadParams): KycDocument = upload(params, RequestOptions.none())

    /** @see [upload] */
    fun upload(
        params: DocumentUploadParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): KycDocument

    /** A view of [DocumentService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): DocumentService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v2/entities/{entity_id}/kyc/{kyc_id}/document`,
         * but is otherwise the same as [DocumentService.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            kycId: String,
            params: DocumentRetrieveParams,
        ): HttpResponseFor<List<KycDocument>> = retrieve(kycId, params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            kycId: String,
            params: DocumentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<KycDocument>> =
            retrieve(params.toBuilder().kycId(kycId).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(params: DocumentRetrieveParams): HttpResponseFor<List<KycDocument>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: DocumentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<KycDocument>>

        /**
         * Returns a raw HTTP response for `post
         * /api/v2/entities/{entity_id}/kyc/{kyc_id}/document`, but is otherwise the same as
         * [DocumentService.upload].
         */
        @MustBeClosed
        fun upload(kycId: String, params: DocumentUploadParams): HttpResponseFor<KycDocument> =
            upload(kycId, params, RequestOptions.none())

        /** @see [upload] */
        @MustBeClosed
        fun upload(
            kycId: String,
            params: DocumentUploadParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<KycDocument> =
            upload(params.toBuilder().kycId(kycId).build(), requestOptions)

        /** @see [upload] */
        @MustBeClosed
        fun upload(params: DocumentUploadParams): HttpResponseFor<KycDocument> =
            upload(params, RequestOptions.none())

        /** @see [upload] */
        @MustBeClosed
        fun upload(
            params: DocumentUploadParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<KycDocument>
    }
}
