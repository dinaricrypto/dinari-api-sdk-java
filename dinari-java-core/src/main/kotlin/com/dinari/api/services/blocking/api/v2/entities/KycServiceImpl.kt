// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.api.v2.entities

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
import com.dinari.api.core.prepare
import com.dinari.api.models.api.v2.entities.kyc.KycGetUrlParams
import com.dinari.api.models.api.v2.entities.kyc.KycGetUrlResponse
import com.dinari.api.models.api.v2.entities.kyc.KycInfo
import com.dinari.api.models.api.v2.entities.kyc.KycRetrieveParams
import com.dinari.api.models.api.v2.entities.kyc.KycSubmitParams
import com.dinari.api.models.api.v2.entities.kyc.KycUploadDocumentParams
import com.dinari.api.models.api.v2.entities.kyc.KycUploadDocumentResponse
import kotlin.jvm.optionals.getOrNull

class KycServiceImpl internal constructor(private val clientOptions: ClientOptions) : KycService {

    private val withRawResponse: KycService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): KycService.WithRawResponse = withRawResponse

    override fun retrieve(params: KycRetrieveParams, requestOptions: RequestOptions): KycInfo =
        // get /api/v2/entities/{entity_id}/kyc
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun getUrl(
        params: KycGetUrlParams,
        requestOptions: RequestOptions,
    ): KycGetUrlResponse =
        // get /api/v2/entities/{entity_id}/kyc/url
        withRawResponse().getUrl(params, requestOptions).parse()

    override fun submit(params: KycSubmitParams, requestOptions: RequestOptions): KycInfo =
        // post /api/v2/entities/{entity_id}/kyc
        withRawResponse().submit(params, requestOptions).parse()

    override fun uploadDocument(
        params: KycUploadDocumentParams,
        requestOptions: RequestOptions,
    ): KycUploadDocumentResponse =
        // post /api/v2/entities/{entity_id}/kyc/{kyc_id}/document
        withRawResponse().uploadDocument(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        KycService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val retrieveHandler: Handler<KycInfo> =
            jsonHandler<KycInfo>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun retrieve(
            params: KycRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<KycInfo> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("entityId", params.entityId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("api", "v2", "entities", params._pathParam(0), "kyc")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val getUrlHandler: Handler<KycGetUrlResponse> =
            jsonHandler<KycGetUrlResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun getUrl(
            params: KycGetUrlParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<KycGetUrlResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("entityId", params.entityId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("api", "v2", "entities", params._pathParam(0), "kyc", "url")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { getUrlHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val submitHandler: Handler<KycInfo> =
            jsonHandler<KycInfo>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun submit(
            params: KycSubmitParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<KycInfo> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("entityId", params.entityId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("api", "v2", "entities", params._pathParam(0), "kyc")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { submitHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
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
        ): HttpResponseFor<KycUploadDocumentResponse> {
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
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
