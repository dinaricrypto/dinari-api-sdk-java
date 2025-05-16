// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.api.v2.entities

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.JsonValue
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.checkRequired
import com.dinari.api.core.handlers.errorHandler
import com.dinari.api.core.handlers.jsonHandler
import com.dinari.api.core.handlers.withErrorHandler
import com.dinari.api.core.http.HttpMethod
import com.dinari.api.core.http.HttpRequest
import com.dinari.api.core.http.HttpResponse.Handler
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.core.http.json
import com.dinari.api.core.http.parseable
import com.dinari.api.core.prepareAsync
import com.dinari.api.models.api.v2.entities.kyc.KycGetUrlParams
import com.dinari.api.models.api.v2.entities.kyc.KycGetUrlResponse
import com.dinari.api.models.api.v2.entities.kyc.KycInfo
import com.dinari.api.models.api.v2.entities.kyc.KycRetrieveParams
import com.dinari.api.models.api.v2.entities.kyc.KycSubmitParams
import com.dinari.api.models.api.v2.entities.kyc.KycUploadDocumentParams
import com.dinari.api.models.api.v2.entities.kyc.KycUploadDocumentResponse
import java.util.concurrent.CompletableFuture
import kotlin.jvm.optionals.getOrNull

class KycServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    KycServiceAsync {

    private val withRawResponse: KycServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): KycServiceAsync.WithRawResponse = withRawResponse

    override fun retrieve(
        params: KycRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<KycInfo> =
        // get /api/v2/entities/{entity_id}/kyc
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun getUrl(
        params: KycGetUrlParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<KycGetUrlResponse> =
        // get /api/v2/entities/{entity_id}/kyc/url
        withRawResponse().getUrl(params, requestOptions).thenApply { it.parse() }

    override fun submit(
        params: KycSubmitParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<KycInfo> =
        // post /api/v2/entities/{entity_id}/kyc
        withRawResponse().submit(params, requestOptions).thenApply { it.parse() }

    override fun uploadDocument(
        params: KycUploadDocumentParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<KycUploadDocumentResponse> =
        // post /api/v2/entities/{entity_id}/kyc/{kyc_id}/document
        withRawResponse().uploadDocument(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        KycServiceAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val retrieveHandler: Handler<KycInfo> =
            jsonHandler<KycInfo>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun retrieve(
            params: KycRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<KycInfo>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("entityId", params.entityId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("api", "v2", "entities", params._pathParam(0), "kyc")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { retrieveHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val getUrlHandler: Handler<KycGetUrlResponse> =
            jsonHandler<KycGetUrlResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun getUrl(
            params: KycGetUrlParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<KycGetUrlResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("entityId", params.entityId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("api", "v2", "entities", params._pathParam(0), "kyc", "url")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { getUrlHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val submitHandler: Handler<KycInfo> =
            jsonHandler<KycInfo>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun submit(
            params: KycSubmitParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<KycInfo>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("entityId", params.entityId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("api", "v2", "entities", params._pathParam(0), "kyc")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { submitHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val uploadDocumentHandler: Handler<KycUploadDocumentResponse> =
            jsonHandler<KycUploadDocumentResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun uploadDocument(
            params: KycUploadDocumentParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<KycUploadDocumentResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("kycId", params.kycId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments(
                        "api",
                        "v2",
                        "entities",
                        params._pathParam(0),
                        "kyc",
                        params._pathParam(1),
                        "document",
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { uploadDocumentHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }
    }
}
