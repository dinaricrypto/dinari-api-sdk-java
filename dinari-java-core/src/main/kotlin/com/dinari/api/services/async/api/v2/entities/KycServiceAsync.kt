// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.api.v2.entities

import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.api.v2.entities.kyc.KycGetUrlParams
import com.dinari.api.models.api.v2.entities.kyc.KycGetUrlResponse
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

    /** Retrieves KYC data of the entity. */
    fun retrieve(params: KycRetrieveParams): CompletableFuture<KycInfo> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: KycRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<KycInfo>

    /** Gets an iframe URL for managed (self-service) KYC. */
    fun getUrl(params: KycGetUrlParams): CompletableFuture<KycGetUrlResponse> =
        getUrl(params, RequestOptions.none())

    /** @see [getUrl] */
    fun getUrl(
        params: KycGetUrlParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<KycGetUrlResponse>

    /** Submits KYC data manually (for Partner KYC-enabled entities). */
    fun submit(params: KycSubmitParams): CompletableFuture<KycInfo> =
        submit(params, RequestOptions.none())

    /** @see [submit] */
    fun submit(
        params: KycSubmitParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<KycInfo>

    /** Uploads KYC-related documentation (for Partner KYC-enabled entities). */
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
        fun retrieve(params: KycRetrieveParams): CompletableFuture<HttpResponseFor<KycInfo>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: KycRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<KycInfo>>

        /**
         * Returns a raw HTTP response for `get /api/v2/entities/{entity_id}/kyc/url`, but is
         * otherwise the same as [KycServiceAsync.getUrl].
         */
        @MustBeClosed
        fun getUrl(params: KycGetUrlParams): CompletableFuture<HttpResponseFor<KycGetUrlResponse>> =
            getUrl(params, RequestOptions.none())

        /** @see [getUrl] */
        @MustBeClosed
        fun getUrl(
            params: KycGetUrlParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<KycGetUrlResponse>>

        /**
         * Returns a raw HTTP response for `post /api/v2/entities/{entity_id}/kyc`, but is otherwise
         * the same as [KycServiceAsync.submit].
         */
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
