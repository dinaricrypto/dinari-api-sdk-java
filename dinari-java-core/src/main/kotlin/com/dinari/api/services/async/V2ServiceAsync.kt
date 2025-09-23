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

    fun marketData(): MarketDataServiceAsync

    fun entities(): EntityServiceAsync

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

        fun marketData(): MarketDataServiceAsync.WithRawResponse

        fun entities(): EntityServiceAsync.WithRawResponse

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
