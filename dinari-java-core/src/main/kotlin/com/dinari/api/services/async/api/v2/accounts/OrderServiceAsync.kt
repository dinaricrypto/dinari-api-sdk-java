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
    fun retrieve(orderId: String, params: OrderRetrieveParams): CompletableFuture<Order> =
        retrieve(orderId, params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        orderId: String,
        params: OrderRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Order> =
        retrieve(params.toBuilder().orderId(orderId).build(), requestOptions)

    /** @see [retrieve] */
    fun retrieve(params: OrderRetrieveParams): CompletableFuture<Order> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: OrderRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Order>

    /** Lists all orders under the account. */
    fun list(accountId: String): CompletableFuture<List<Order>> =
        list(accountId, OrderListParams.none())

    /** @see [list] */
    fun list(
        accountId: String,
        params: OrderListParams = OrderListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Order>> =
        list(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [list] */
    fun list(
        accountId: String,
        params: OrderListParams = OrderListParams.none(),
    ): CompletableFuture<List<Order>> = list(accountId, params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: OrderListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Order>>

    /** @see [list] */
    fun list(params: OrderListParams): CompletableFuture<List<Order>> =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(accountId: String, requestOptions: RequestOptions): CompletableFuture<List<Order>> =
        list(accountId, OrderListParams.none(), requestOptions)

    /**
     * Cancels an order by its ID. Note that this requires the order ID, not the order request ID.
     */
    fun cancel(orderId: String, params: OrderCancelParams): CompletableFuture<Order> =
        cancel(orderId, params, RequestOptions.none())

    /** @see [cancel] */
    fun cancel(
        orderId: String,
        params: OrderCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Order> =
        cancel(params.toBuilder().orderId(orderId).build(), requestOptions)

    /** @see [cancel] */
    fun cancel(params: OrderCancelParams): CompletableFuture<Order> =
        cancel(params, RequestOptions.none())

    /** @see [cancel] */
    fun cancel(
        params: OrderCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Order>

    /** Gets estimated fee data for an order to be placed directly through our contracts. */
    fun getEstimatedFee(
        accountId: String,
        params: OrderGetEstimatedFeeParams,
    ): CompletableFuture<OrderGetEstimatedFeeResponse> =
        getEstimatedFee(accountId, params, RequestOptions.none())

    /** @see [getEstimatedFee] */
    fun getEstimatedFee(
        accountId: String,
        params: OrderGetEstimatedFeeParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrderGetEstimatedFeeResponse> =
        getEstimatedFee(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [getEstimatedFee] */
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
        orderId: String,
        params: OrderRetrieveFulfillmentsParams,
    ): CompletableFuture<List<OrderFulfillment>> =
        retrieveFulfillments(orderId, params, RequestOptions.none())

    /** @see [retrieveFulfillments] */
    fun retrieveFulfillments(
        orderId: String,
        params: OrderRetrieveFulfillmentsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<OrderFulfillment>> =
        retrieveFulfillments(params.toBuilder().orderId(orderId).build(), requestOptions)

    /** @see [retrieveFulfillments] */
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
        fun retrieve(
            orderId: String,
            params: OrderRetrieveParams,
        ): CompletableFuture<HttpResponseFor<Order>> =
            retrieve(orderId, params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            orderId: String,
            params: OrderRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Order>> =
            retrieve(params.toBuilder().orderId(orderId).build(), requestOptions)

        /** @see [retrieve] */
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
        fun list(accountId: String): CompletableFuture<HttpResponseFor<List<Order>>> =
            list(accountId, OrderListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            accountId: String,
            params: OrderListParams = OrderListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Order>>> =
            list(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [list] */
        @MustBeClosed
        fun list(
            accountId: String,
            params: OrderListParams = OrderListParams.none(),
        ): CompletableFuture<HttpResponseFor<List<Order>>> =
            list(accountId, params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: OrderListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Order>>>

        /** @see [list] */
        @MustBeClosed
        fun list(params: OrderListParams): CompletableFuture<HttpResponseFor<List<Order>>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            accountId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<Order>>> =
            list(accountId, OrderListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post
         * /api/v2/accounts/{account_id}/orders/{order_id}/cancel`, but is otherwise the same as
         * [OrderServiceAsync.cancel].
         */
        @MustBeClosed
        fun cancel(
            orderId: String,
            params: OrderCancelParams,
        ): CompletableFuture<HttpResponseFor<Order>> =
            cancel(orderId, params, RequestOptions.none())

        /** @see [cancel] */
        @MustBeClosed
        fun cancel(
            orderId: String,
            params: OrderCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Order>> =
            cancel(params.toBuilder().orderId(orderId).build(), requestOptions)

        /** @see [cancel] */
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
            accountId: String,
            params: OrderGetEstimatedFeeParams,
        ): CompletableFuture<HttpResponseFor<OrderGetEstimatedFeeResponse>> =
            getEstimatedFee(accountId, params, RequestOptions.none())

        /** @see [getEstimatedFee] */
        @MustBeClosed
        fun getEstimatedFee(
            accountId: String,
            params: OrderGetEstimatedFeeParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrderGetEstimatedFeeResponse>> =
            getEstimatedFee(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [getEstimatedFee] */
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
            orderId: String,
            params: OrderRetrieveFulfillmentsParams,
        ): CompletableFuture<HttpResponseFor<List<OrderFulfillment>>> =
            retrieveFulfillments(orderId, params, RequestOptions.none())

        /** @see [retrieveFulfillments] */
        @MustBeClosed
        fun retrieveFulfillments(
            orderId: String,
            params: OrderRetrieveFulfillmentsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<OrderFulfillment>>> =
            retrieveFulfillments(params.toBuilder().orderId(orderId).build(), requestOptions)

        /** @see [retrieveFulfillments] */
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
