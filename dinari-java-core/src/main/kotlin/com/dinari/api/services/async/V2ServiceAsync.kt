// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.v2.V2ListOrdersParams
import com.dinari.api.models.v2.V2ListOrdersResponse
import com.dinari.api.services.async.v2.AccountServiceAsync
import com.dinari.api.services.async.v2.EntityServiceAsync
import com.dinari.api.services.async.v2.MarketDataServiceAsync
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
interface V2ServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): V2ServiceAsync

    /**
     * **Dinari provides basic market data for `Stocks` that are available to transact on.**
     *
     * This data is provided on a best-effort basis and we recommend using a dedicated provider for
     * more intensive market data needs.
     */
    fun marketData(): MarketDataServiceAsync

    /**
     * **`Entities` represent a business or organization that uses the API, and their customers.**
     *
     * Dinari Partners are represented as an organization `Entity` in the API, with their own
     * accounts. Individual customers of Partner `Entities` are also represented as `Entities` in
     * the API, which are managed by the Partner `Entity`.
     */
    fun entities(): EntityServiceAsync

    /**
     * **`Accounts` represent the financial accounts of an `Entity`.**
     *
     * `Orders`, dividends, and other transactions are associated with an `Account`.
     */
    fun accounts(): AccountServiceAsync

    /**
     * Get a list of all `Orders` under the `Entity`.<br>Optionally `Orders` can be transaction hash
     * or fulfillment transaction hash.
     */
    fun listOrders(): CompletableFuture<List<V2ListOrdersResponse>> =
        listOrders(V2ListOrdersParams.none())

    /** @see listOrders */
    fun listOrders(
        params: V2ListOrdersParams = V2ListOrdersParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<V2ListOrdersResponse>>

    /** @see listOrders */
    fun listOrders(
        params: V2ListOrdersParams = V2ListOrdersParams.none()
    ): CompletableFuture<List<V2ListOrdersResponse>> = listOrders(params, RequestOptions.none())

    /** @see listOrders */
    fun listOrders(requestOptions: RequestOptions): CompletableFuture<List<V2ListOrdersResponse>> =
        listOrders(V2ListOrdersParams.none(), requestOptions)

    /** A view of [V2ServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): V2ServiceAsync.WithRawResponse

        /**
         * **Dinari provides basic market data for `Stocks` that are available to transact on.**
         *
         * This data is provided on a best-effort basis and we recommend using a dedicated provider
         * for more intensive market data needs.
         */
        fun marketData(): MarketDataServiceAsync.WithRawResponse

        /**
         * **`Entities` represent a business or organization that uses the API, and their
         * customers.**
         *
         * Dinari Partners are represented as an organization `Entity` in the API, with their own
         * accounts. Individual customers of Partner `Entities` are also represented as `Entities`
         * in the API, which are managed by the Partner `Entity`.
         */
        fun entities(): EntityServiceAsync.WithRawResponse

        /**
         * **`Accounts` represent the financial accounts of an `Entity`.**
         *
         * `Orders`, dividends, and other transactions are associated with an `Account`.
         */
        fun accounts(): AccountServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v2/orders/`, but is otherwise the same as
         * [V2ServiceAsync.listOrders].
         */
        fun listOrders(): CompletableFuture<HttpResponseFor<List<V2ListOrdersResponse>>> =
            listOrders(V2ListOrdersParams.none())

        /** @see listOrders */
        fun listOrders(
            params: V2ListOrdersParams = V2ListOrdersParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<V2ListOrdersResponse>>>

        /** @see listOrders */
        fun listOrders(
            params: V2ListOrdersParams = V2ListOrdersParams.none()
        ): CompletableFuture<HttpResponseFor<List<V2ListOrdersResponse>>> =
            listOrders(params, RequestOptions.none())

        /** @see listOrders */
        fun listOrders(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<List<V2ListOrdersResponse>>> =
            listOrders(V2ListOrdersParams.none(), requestOptions)
    }
}
