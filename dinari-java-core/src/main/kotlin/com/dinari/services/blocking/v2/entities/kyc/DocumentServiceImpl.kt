// File generated from our OpenAPI spec by Stainless.

package com.dinari.services.blocking.v2.entities.kyc

import com.dinari.core.ClientOptions
import com.dinari.core.JsonValue
import com.dinari.core.RequestOptions
import com.dinari.core.checkRequired
import com.dinari.core.handlers.errorHandler
import com.dinari.core.handlers.jsonHandler
import com.dinari.core.handlers.withErrorHandler
import com.dinari.core.http.HttpMethod
import com.dinari.core.http.HttpRequest
import com.dinari.core.http.HttpResponse.Handler
import com.dinari.core.http.HttpResponseFor
import com.dinari.core.http.multipartFormData
import com.dinari.core.http.parseable
import com.dinari.core.prepare
import com.dinari.models.v2.entities.kyc.document.DocumentRetrieveParams
import com.dinari.models.v2.entities.kyc.document.DocumentUploadParams
import com.dinari.models.v2.entities.kyc.document.KycDocument
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class DocumentServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    DocumentService {

    private val withRawResponse: DocumentService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): DocumentService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): DocumentService =
        DocumentServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieve(
        params: DocumentRetrieveParams,
        requestOptions: RequestOptions,
    ): List<KycDocument> =
        // get /api/v2/entities/{entity_id}/kyc/{kyc_id}/document
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun upload(params: DocumentUploadParams, requestOptions: RequestOptions): KycDocument =
        // post /api/v2/entities/{entity_id}/kyc/{kyc_id}/document
        withRawResponse().upload(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        DocumentService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): DocumentService.WithRawResponse =
            DocumentServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveHandler: Handler<List<KycDocument>> =
            jsonHandler<List<KycDocument>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun retrieve(
            params: DocumentRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<KycDocument>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("kycId", params.kycId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "api",
                        "v2",
                        "entities",
                        params._pathParam(0),
                        "kyc",
                        params._pathParam(1),
                        "document",
                    )
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.forEach { it.validate() }
                        }
                    }
            }
        }

        private val uploadHandler: Handler<KycDocument> =
            jsonHandler<KycDocument>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun upload(
            params: DocumentUploadParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<KycDocument> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("kycId", params.kycId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "api",
                        "v2",
                        "entities",
                        params._pathParam(0),
                        "kyc",
                        params._pathParam(1),
                        "document",
                    )
                    .body(multipartFormData(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { uploadHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
