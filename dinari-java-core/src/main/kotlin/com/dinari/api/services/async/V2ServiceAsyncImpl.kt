// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async

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
import com.dinari.api.core.prepareAsync
import com.dinari.api.models.v2.V2ListOrdersParams
import com.dinari.api.models.v2.V2ListOrdersResponse
import com.dinari.api.services.async.v2.AccountServiceAsync
import com.dinari.api.services.async.v2.AccountServiceAsyncImpl
import com.dinari.api.services.async.v2.EntityServiceAsync
import com.dinari.api.services.async.v2.EntityServiceAsyncImpl
import com.dinari.api.services.async.v2.MarketDataServiceAsync
import com.dinari.api.services.async.v2.MarketDataServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/**
 * **`Orders` represent the buying and selling of assets under an `Account`.**
 *
 * For `Accounts` using self-custodied `Wallets`, `Orders` are created and fulfilled by making calls
 * to Dinari's smart contracts, or using the *Proxied Orders* methods.
 *
 * For `Accounts` using managed `Wallets`, `Orders` are created and fulfilled by using the `Managed
 * Orders` methods, which then create the corresponding transactions on the blockchain.
 */
class V2ServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    V2ServiceAsync {

    private val withRawResponse: V2ServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val marketData: MarketDataServiceAsync by lazy {
        MarketDataServiceAsyncImpl(clientOptions)
    }

    private val entities: EntityServiceAsync by lazy { EntityServiceAsyncImpl(clientOptions) }

    private val accounts: AccountServiceAsync by lazy { AccountServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): V2ServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): V2ServiceAsync =
        V2ServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    /**
     * **Dinari provides basic market data for `Stocks` and `Alloys` that are available to transact
     * on.**
     *
     * This data is provided on a best-effort basis and we recommend using a dedicated provider for
     * more intensive market data needs.
     */
    override fun marketData(): MarketDataServiceAsync = marketData

    /**
     * **`Entities` represent a business or organization that uses the API, and their customers.**
     *
     * Dinari Partners are represented as an organization `Entity` in the API, with their own
     * accounts. Individual customers of Partner `Entities` are also represented as `Entities` in
     * the API, which are managed by the Partner `Entity`.
     */
    override fun entities(): EntityServiceAsync = entities

    /**
     * **`Accounts` represent the financial accounts of an `Entity`.**
     *
     * `Orders`, dividends, and other transactions are associated with an `Account`.
     */
    override fun accounts(): AccountServiceAsync = accounts

    override fun listOrders(
        params: V2ListOrdersParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<V2ListOrdersResponse> =
        // get /api/v2/orders/
        withRawResponse().listOrders(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        V2ServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val marketData: MarketDataServiceAsync.WithRawResponse by lazy {
            MarketDataServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val entities: EntityServiceAsync.WithRawResponse by lazy {
            EntityServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val accounts: AccountServiceAsync.WithRawResponse by lazy {
            AccountServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): V2ServiceAsync.WithRawResponse =
            V2ServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        /**
         * **Dinari provides basic market data for `Stocks` and `Alloys` that are available to
         * transact on.**
         *
         * This data is provided on a best-effort basis and we recommend using a dedicated provider
         * for more intensive market data needs.
         */
        override fun marketData(): MarketDataServiceAsync.WithRawResponse = marketData

        /**
         * **`Entities` represent a business or organization that uses the API, and their
         * customers.**
         *
         * Dinari Partners are represented as an organization `Entity` in the API, with their own
         * accounts. Individual customers of Partner `Entities` are also represented as `Entities`
         * in the API, which are managed by the Partner `Entity`.
         */
        override fun entities(): EntityServiceAsync.WithRawResponse = entities

        /**
         * **`Accounts` represent the financial accounts of an `Entity`.**
         *
         * `Orders`, dividends, and other transactions are associated with an `Account`.
         */
        override fun accounts(): AccountServiceAsync.WithRawResponse = accounts

        private val listOrdersHandler: Handler<V2ListOrdersResponse> =
            jsonHandler<V2ListOrdersResponse>(clientOptions.jsonMapper)

        override fun listOrders(
            params: V2ListOrdersParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<V2ListOrdersResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v2", "orders", "")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { listOrdersHandler.handle(it) }
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
