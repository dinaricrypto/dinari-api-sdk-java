// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.v2

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
import com.dinari.api.models.v2.entities.Entity
import com.dinari.api.models.v2.entities.EntityCreateParams
import com.dinari.api.models.v2.entities.EntityListParams
import com.dinari.api.models.v2.entities.EntityRetrieveByIdParams
import com.dinari.api.models.v2.entities.EntityRetrieveCurrentParams
import com.dinari.api.models.v2.entities.EntityUpdateParams
import com.dinari.api.services.async.v2.entities.AccountServiceAsync
import com.dinari.api.services.async.v2.entities.AccountServiceAsyncImpl
import com.dinari.api.services.async.v2.entities.KycServiceAsync
import com.dinari.api.services.async.v2.entities.KycServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class EntityServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    EntityServiceAsync {

    private val withRawResponse: EntityServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val accounts: AccountServiceAsync by lazy { AccountServiceAsyncImpl(clientOptions) }

    private val kyc: KycServiceAsync by lazy { KycServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): EntityServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): EntityServiceAsync =
        EntityServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun accounts(): AccountServiceAsync = accounts

    override fun kyc(): KycServiceAsync = kyc

    override fun create(
        params: EntityCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Entity> =
        // post /api/v2/entities/
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun update(
        params: EntityUpdateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Entity> =
        // patch /api/v2/entities/{entity_id}
        withRawResponse().update(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: EntityListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<Entity>> =
        // get /api/v2/entities/
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun retrieveById(
        params: EntityRetrieveByIdParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Entity> =
        // get /api/v2/entities/{entity_id}
        withRawResponse().retrieveById(params, requestOptions).thenApply { it.parse() }

    override fun retrieveCurrent(
        params: EntityRetrieveCurrentParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Entity> =
        // get /api/v2/entities/me
        withRawResponse().retrieveCurrent(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        EntityServiceAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val accounts: AccountServiceAsync.WithRawResponse by lazy {
            AccountServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val kyc: KycServiceAsync.WithRawResponse by lazy {
            KycServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): EntityServiceAsync.WithRawResponse =
            EntityServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun accounts(): AccountServiceAsync.WithRawResponse = accounts

        override fun kyc(): KycServiceAsync.WithRawResponse = kyc

        private val createHandler: Handler<Entity> =
            jsonHandler<Entity>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun create(
            params: EntityCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Entity>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v2", "entities", "")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { createHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val updateHandler: Handler<Entity> =
            jsonHandler<Entity>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun update(
            params: EntityUpdateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Entity>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("entityId", params.entityId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v2", "entities", params._pathParam(0))
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { updateHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val listHandler: Handler<List<Entity>> =
            jsonHandler<List<Entity>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun list(
            params: EntityListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<Entity>>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v2", "entities", "")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { listHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.forEach { it.validate() }
                                }
                            }
                    }
                }
        }

        private val retrieveByIdHandler: Handler<Entity> =
            jsonHandler<Entity>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun retrieveById(
            params: EntityRetrieveByIdParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Entity>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("entityId", params.entityId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v2", "entities", params._pathParam(0))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { retrieveByIdHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val retrieveCurrentHandler: Handler<Entity> =
            jsonHandler<Entity>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun retrieveCurrent(
            params: EntityRetrieveCurrentParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Entity>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v2", "entities", "me")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
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
}
