// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.handlers.errorBodyHandler
import com.dinari.api.core.handlers.errorHandler
import com.dinari.api.core.handlers.jsonHandler
import com.dinari.api.core.http.HttpMethod
import com.dinari.api.core.http.HttpRequest
import com.dinari.api.core.http.HttpResponse
import com.dinari.api.core.http.HttpResponse.Handler
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.core.http.parseable
import com.dinari.api.core.prepare
import com.dinari.api.models.v2.V2ListOrdersParams
import com.dinari.api.models.v2.V2ListOrdersResponse
import com.dinari.api.services.blocking.v2.AccountService
import com.dinari.api.services.blocking.v2.AccountServiceImpl
import com.dinari.api.services.blocking.v2.EntityService
import com.dinari.api.services.blocking.v2.EntityServiceImpl
import com.dinari.api.services.blocking.v2.MarketDataService
import com.dinari.api.services.blocking.v2.MarketDataServiceImpl
import java.util.function.Consumer

class V2ServiceImpl internal constructor(private val clientOptions: ClientOptions) : V2Service {

    private val withRawResponse: V2Service.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val marketData: MarketDataService by lazy { MarketDataServiceImpl(clientOptions) }

    private val entities: EntityService by lazy { EntityServiceImpl(clientOptions) }

    private val accounts: AccountService by lazy { AccountServiceImpl(clientOptions) }

    override fun withRawResponse(): V2Service.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): V2Service =
        V2ServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun marketData(): MarketDataService = marketData

    override fun entities(): EntityService = entities

    override fun accounts(): AccountService = accounts

    override fun listOrders(
        params: V2ListOrdersParams,
        requestOptions: RequestOptions,
    ): List<V2ListOrdersResponse> =
        // get /api/v2/orders/
        withRawResponse().listOrders(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        V2Service.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val marketData: MarketDataService.WithRawResponse by lazy {
            MarketDataServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val entities: EntityService.WithRawResponse by lazy {
            EntityServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val accounts: AccountService.WithRawResponse by lazy {
            AccountServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): V2Service.WithRawResponse =
            V2ServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun marketData(): MarketDataService.WithRawResponse = marketData

        override fun entities(): EntityService.WithRawResponse = entities

        override fun accounts(): AccountService.WithRawResponse = accounts

        private val listOrdersHandler: Handler<List<V2ListOrdersResponse>> =
            jsonHandler<List<V2ListOrdersResponse>>(clientOptions.jsonMapper)

        override fun listOrders(
            params: V2ListOrdersParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<V2ListOrdersResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v2", "orders", "")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listOrdersHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.forEach { it.validate() }
                        }
                    }
            }
        }
    }
}
