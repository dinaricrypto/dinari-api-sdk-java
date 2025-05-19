// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.entities

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
import com.dinari.api.models.v2.entities.kyc.KycCreateManagedCheckParams
import com.dinari.api.models.v2.entities.kyc.KycCreateManagedCheckResponse
import com.dinari.api.models.v2.entities.kyc.KycInfo
import com.dinari.api.models.v2.entities.kyc.KycRetrieveParams
import com.dinari.api.models.v2.entities.kyc.KycSubmitParams
import com.dinari.api.services.blocking.v2.entities.kyc.DocumentService
import com.dinari.api.services.blocking.v2.entities.kyc.DocumentServiceImpl
import kotlin.jvm.optionals.getOrNull

class KycServiceImpl internal constructor(private val clientOptions: ClientOptions) : KycService {

    private val withRawResponse: KycService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val document: DocumentService by lazy { DocumentServiceImpl(clientOptions) }

    override fun withRawResponse(): KycService.WithRawResponse = withRawResponse

    override fun document(): DocumentService = document

    override fun retrieve(params: KycRetrieveParams, requestOptions: RequestOptions): KycInfo =
        // get /api/v2/entities/{entity_id}/kyc
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun createManagedCheck(
        params: KycCreateManagedCheckParams,
        requestOptions: RequestOptions,
    ): KycCreateManagedCheckResponse =
        // post /api/v2/entities/{entity_id}/kyc/url
        withRawResponse().createManagedCheck(params, requestOptions).parse()

    override fun submit(params: KycSubmitParams, requestOptions: RequestOptions): KycInfo =
        // post /api/v2/entities/{entity_id}/kyc
        withRawResponse().submit(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        KycService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val document: DocumentService.WithRawResponse by lazy {
            DocumentServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun document(): DocumentService.WithRawResponse = document

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

        private val createManagedCheckHandler: Handler<KycCreateManagedCheckResponse> =
            jsonHandler<KycCreateManagedCheckResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun createManagedCheck(
            params: KycCreateManagedCheckParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<KycCreateManagedCheckResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("entityId", params.entityId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("api", "v2", "entities", params._pathParam(0), "kyc", "url")
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { createManagedCheckHandler.handle(it) }
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
    }
}
