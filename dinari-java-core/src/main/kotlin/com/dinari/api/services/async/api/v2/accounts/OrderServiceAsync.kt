// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.api.v2.accounts

import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.api.v2.accounts.orderfulfillments.OrderFulfillment
import com.dinari.api.models.api.v2.accounts.orders.Order
import com.dinari.api.models.api.v2.accounts.orders.OrderCancelParams
import com.dinari.api.models.api.v2.accounts.orders.OrderGetEstimatedFeeParams
import com.dinari.api.models.api.v2.accounts.orders.OrderGetEstimatedFeeResponse
import com.dinari.api.models.api.v2.accounts.orders.OrderListParams
import com.dinari.api.models.api.v2.accounts.orders.OrderRetrieveFulfillmentsParams
import com.dinari.api.models.api.v2.accounts.orders.OrderRetrieveParams
import com.google.errorprone.annotations.MustBeClosed
import java.util.concurrent.CompletableFuture

interface OrderServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Retrieves details of a specific order by its ID. */
    fun retrieve(params: OrderRetrieveParams): CompletableFuture<Order> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: OrderRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Order>

    /** Lists all orders under the account. */
    fun list(params: OrderListParams): CompletableFuture<List<Order>> =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: OrderListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Order>>

    /**
     * Cancels an order by its ID. Note that this requires the order ID, not the order request ID.
     */
    fun cancel(params: OrderCancelParams): CompletableFuture<Order> =
        cancel(params, RequestOptions.none())

    /** @see [cancel] */
    fun cancel(
        params: OrderCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Order>

    /** Gets estimated fee data for an order to be placed directly through our contracts. */
    fun getEstimatedFee(
        params: OrderGetEstimatedFeeParams
    ): CompletableFuture<OrderGetEstimatedFeeResponse> =
        getEstimatedFee(params, RequestOptions.none())

    /** @see [getEstimatedFee] */
    fun getEstimatedFee(
        params: OrderGetEstimatedFeeParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrderGetEstimatedFeeResponse>

    /** Retrieves order fulfillments for a specific order. */
    fun retrieveFulfillments(
        params: OrderRetrieveFulfillmentsParams
    ): CompletableFuture<List<OrderFulfillment>> =
        retrieveFulfillments(params, RequestOptions.none())

    /** @see [retrieveFulfillments] */
    fun retrieveFulfillments(
        params: OrderRetrieveFulfillmentsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<OrderFulfillment>>

    /** A view of [OrderServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/orders/{order_id}`,
         * but is otherwise the same as [OrderServiceAsync.retrieve].
         */
        @MustBeClosed
        fun retrieve(params: OrderRetrieveParams): CompletableFuture<HttpResponseFor<Order>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: OrderRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Order>>

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/orders`, but is
         * otherwise the same as [OrderServiceAsync.list].
         */
        @MustBeClosed
        fun list(params: OrderListParams): CompletableFuture<HttpResponseFor<List<Order>>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: OrderListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Order>>>

        /**
         * Returns a raw HTTP response for `post
         * /api/v2/accounts/{account_id}/orders/{order_id}/cancel`, but is otherwise the same as
         * [OrderServiceAsync.cancel].
         */
        @MustBeClosed
        fun cancel(params: OrderCancelParams): CompletableFuture<HttpResponseFor<Order>> =
            cancel(params, RequestOptions.none())

        /** @see [cancel] */
        @MustBeClosed
        fun cancel(
            params: OrderCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Order>>

        /**
         * Returns a raw HTTP response for `post
         * /api/v2/accounts/{account_id}/orders/estimated_fee`, but is otherwise the same as
         * [OrderServiceAsync.getEstimatedFee].
         */
        @MustBeClosed
        fun getEstimatedFee(
            params: OrderGetEstimatedFeeParams
        ): CompletableFuture<HttpResponseFor<OrderGetEstimatedFeeResponse>> =
            getEstimatedFee(params, RequestOptions.none())

        /** @see [getEstimatedFee] */
        @MustBeClosed
        fun getEstimatedFee(
            params: OrderGetEstimatedFeeParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrderGetEstimatedFeeResponse>>

        /**
         * Returns a raw HTTP response for `get
         * /api/v2/accounts/{account_id}/orders/{order_id}/fulfillments`, but is otherwise the same
         * as [OrderServiceAsync.retrieveFulfillments].
         */
        @MustBeClosed
        fun retrieveFulfillments(
            params: OrderRetrieveFulfillmentsParams
        ): CompletableFuture<HttpResponseFor<List<OrderFulfillment>>> =
            retrieveFulfillments(params, RequestOptions.none())

        /** @see [retrieveFulfillments] */
        @MustBeClosed
        fun retrieveFulfillments(
            params: OrderRetrieveFulfillmentsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<OrderFulfillment>>>
    }
}
