// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.api

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.JsonValue
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.handlers.errorHandler
import com.dinari.api.core.handlers.jsonHandler
import com.dinari.api.core.handlers.withErrorHandler
import com.dinari.api.core.http.HttpMethod
import com.dinari.api.core.http.HttpRequest
import com.dinari.api.core.http.HttpResponse.Handler
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.core.http.parseable
import com.dinari.api.core.prepare
import com.dinari.api.models.api.v2.V2GetHealthParams
import com.dinari.api.models.api.v2.V2GetHealthResponse
import com.dinari.api.services.blocking.api.v2.AccountService
import com.dinari.api.services.blocking.api.v2.AccountServiceImpl
import com.dinari.api.services.blocking.api.v2.EntityService
import com.dinari.api.services.blocking.api.v2.EntityServiceImpl
import com.dinari.api.services.blocking.api.v2.MarketDataService
import com.dinari.api.services.blocking.api.v2.MarketDataServiceImpl

class V2ServiceImpl internal constructor(private val clientOptions: ClientOptions) : V2Service {

    private val withRawResponse: V2Service.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val marketData: MarketDataService by lazy { MarketDataServiceImpl(clientOptions) }

    private val entities: EntityService by lazy { EntityServiceImpl(clientOptions) }

    private val accounts: AccountService by lazy { AccountServiceImpl(clientOptions) }

    override fun withRawResponse(): V2Service.WithRawResponse = withRawResponse

    override fun marketData(): MarketDataService = marketData

    override fun entities(): EntityService = entities

    override fun accounts(): AccountService = accounts

    override fun getHealth(
        params: V2GetHealthParams,
        requestOptions: RequestOptions,
    ): V2GetHealthResponse =
        // get /api/v2/_health/
        withRawResponse().getHealth(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        V2Service.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val marketData: MarketDataService.WithRawResponse by lazy {
            MarketDataServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val entities: EntityService.WithRawResponse by lazy {
            EntityServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val accounts: AccountService.WithRawResponse by lazy {
            AccountServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun marketData(): MarketDataService.WithRawResponse = marketData

        override fun entities(): EntityService.WithRawResponse = entities

        override fun accounts(): AccountService.WithRawResponse = accounts

        private val getHealthHandler: Handler<V2GetHealthResponse> =
            jsonHandler<V2GetHealthResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun getHealth(
            params: V2GetHealthParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<V2GetHealthResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("api", "v2", "_health", "")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { getHealthHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
