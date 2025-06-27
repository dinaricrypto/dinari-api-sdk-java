// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.v2.V2ListOrdersParams
import com.dinari.api.models.v2.V2ListOrdersResponse
import com.dinari.api.services.blocking.v2.AccountService
import com.dinari.api.services.blocking.v2.EntityService
import com.dinari.api.services.blocking.v2.MarketDataService
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface V2Service {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): V2Service

    fun marketData(): MarketDataService

    fun entities(): EntityService

    fun accounts(): AccountService

    /**
     * Get a list of all `Orders` under the `Entity`. Optionally `Orders` can be transaction hash or
     * fulfillment transaction hash.
     */
    fun listOrders(params: V2ListOrdersParams): List<V2ListOrdersResponse> =
        listOrders(params, RequestOptions.none())

    /** @see [listOrders] */
    fun listOrders(
        params: V2ListOrdersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<V2ListOrdersResponse>

    /** A view of [V2Service] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): V2Service.WithRawResponse

        fun marketData(): MarketDataService.WithRawResponse

        fun entities(): EntityService.WithRawResponse

        fun accounts(): AccountService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v2/orders/`, but is otherwise the same as
         * [V2Service.listOrders].
         */
        @MustBeClosed
        fun listOrders(params: V2ListOrdersParams): HttpResponseFor<List<V2ListOrdersResponse>> =
            listOrders(params, RequestOptions.none())

        /** @see [listOrders] */
        @MustBeClosed
        fun listOrders(
            params: V2ListOrdersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<V2ListOrdersResponse>>
    }
}
