// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2

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
import com.dinari.api.models.v2.entities.Entity
import com.dinari.api.models.v2.entities.EntityCreateParams
import com.dinari.api.models.v2.entities.EntityListParams
import com.dinari.api.models.v2.entities.EntityRetrieveByIdParams
import com.dinari.api.models.v2.entities.EntityRetrieveCurrentParams
import com.dinari.api.services.blocking.v2.entities.AccountService
import com.dinari.api.services.blocking.v2.entities.AccountServiceImpl
import com.dinari.api.services.blocking.v2.entities.KycService
import com.dinari.api.services.blocking.v2.entities.KycServiceImpl
import kotlin.jvm.optionals.getOrNull

class EntityServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    EntityService {

    private val withRawResponse: EntityService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val accounts: AccountService by lazy { AccountServiceImpl(clientOptions) }

    private val kyc: KycService by lazy { KycServiceImpl(clientOptions) }

    override fun withRawResponse(): EntityService.WithRawResponse = withRawResponse

    override fun accounts(): AccountService = accounts

    override fun kyc(): KycService = kyc

    override fun create(params: EntityCreateParams, requestOptions: RequestOptions): Entity =
        // post /api/v2/entities/
        withRawResponse().create(params, requestOptions).parse()

    override fun list(params: EntityListParams, requestOptions: RequestOptions): List<Entity> =
        // get /api/v2/entities/
        withRawResponse().list(params, requestOptions).parse()

    override fun retrieveById(
        params: EntityRetrieveByIdParams,
        requestOptions: RequestOptions,
    ): Entity =
        // get /api/v2/entities/{entity_id}
        withRawResponse().retrieveById(params, requestOptions).parse()

    override fun retrieveCurrent(
        params: EntityRetrieveCurrentParams,
        requestOptions: RequestOptions,
    ): Entity =
        // get /api/v2/entities/me
        withRawResponse().retrieveCurrent(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        EntityService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val accounts: AccountService.WithRawResponse by lazy {
            AccountServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val kyc: KycService.WithRawResponse by lazy {
            KycServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun accounts(): AccountService.WithRawResponse = accounts

        override fun kyc(): KycService.WithRawResponse = kyc

        private val createHandler: Handler<Entity> =
            jsonHandler<Entity>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun create(
            params: EntityCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Entity> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("api", "v2", "entities", "")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<List<Entity>> =
            jsonHandler<List<Entity>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun list(
            params: EntityListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<Entity>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("api", "v2", "entities", "")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.forEach { it.validate() }
                        }
                    }
            }
        }

        private val retrieveByIdHandler: Handler<Entity> =
            jsonHandler<Entity>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun retrieveById(
            params: EntityRetrieveByIdParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Entity> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("entityId", params.entityId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("api", "v2", "entities", params._pathParam(0))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { retrieveByIdHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveCurrentHandler: Handler<Entity> =
            jsonHandler<Entity>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun retrieveCurrent(
            params: EntityRetrieveCurrentParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Entity> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("api", "v2", "entities", "me")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { retrieveCurrentHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
