// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.accounts

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.v2.accounts.orderfulfillments.Fulfillment
import com.dinari.api.models.v2.accounts.orders.Order
import com.dinari.api.models.v2.accounts.orders.OrderCancelParams
import com.dinari.api.models.v2.accounts.orders.OrderGetFulfillmentsParams
import com.dinari.api.models.v2.accounts.orders.OrderListParams
import com.dinari.api.models.v2.accounts.orders.OrderRetrieveParams
import com.dinari.api.services.blocking.v2.accounts.orders.StockService
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface OrderService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): OrderService

    fun stocks(): StockService

    /** Get a specific `Order` by its ID. */
    fun retrieve(orderId: String, params: OrderRetrieveParams): Order =
        retrieve(orderId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        orderId: String,
        params: OrderRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Order = retrieve(params.toBuilder().orderId(orderId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: OrderRetrieveParams): Order = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: OrderRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Order

    /**
     * Get a list of all `Orders` under the `Account`. Optionally `Orders` can be filtered by chain
     * ID or transaction hash.
     */
    fun list(accountId: String): List<Order> = list(accountId, OrderListParams.none())

    /** @see list */
    fun list(
        accountId: String,
        params: OrderListParams = OrderListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Order> = list(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see list */
    fun list(accountId: String, params: OrderListParams = OrderListParams.none()): List<Order> =
        list(accountId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: OrderListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Order>

    /** @see list */
    fun list(params: OrderListParams): List<Order> = list(params, RequestOptions.none())

    /** @see list */
    fun list(accountId: String, requestOptions: RequestOptions): List<Order> =
        list(accountId, OrderListParams.none(), requestOptions)

    /**
     * Cancel an `Order` by its ID. Note that this requires the `Order` ID, not the `OrderRequest`
     * ID. Once you submit a cancellation request, it cannot be undone. Be advised that orders with
     * a status of PENDING_FILL, PENDING_ESCROW, FILLED, REJECTED, or CANCELLED cannot be cancelled.
     *
     * `Order` cancellation is not guaranteed nor is it immediate. The `Order` may still be executed
     * if the cancellation request is not received in time.
     *
     * Check the status using the "Get Order by ID" endpoint to confirm whether the `Order` has been
     * cancelled.
     */
    fun cancel(orderId: String, params: OrderCancelParams): Order =
        cancel(orderId, params, RequestOptions.none())

    /** @see cancel */
    fun cancel(
        orderId: String,
        params: OrderCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Order = cancel(params.toBuilder().orderId(orderId).build(), requestOptions)

    /** @see cancel */
    fun cancel(params: OrderCancelParams): Order = cancel(params, RequestOptions.none())

    /** @see cancel */
    fun cancel(
        params: OrderCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Order

    /** Get `OrderFulfillments` for a specific `Order`. */
    fun getFulfillments(orderId: String, params: OrderGetFulfillmentsParams): List<Fulfillment> =
        getFulfillments(orderId, params, RequestOptions.none())

    /** @see getFulfillments */
    fun getFulfillments(
        orderId: String,
        params: OrderGetFulfillmentsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Fulfillment> =
        getFulfillments(params.toBuilder().orderId(orderId).build(), requestOptions)

    /** @see getFulfillments */
    fun getFulfillments(params: OrderGetFulfillmentsParams): List<Fulfillment> =
        getFulfillments(params, RequestOptions.none())

    /** @see getFulfillments */
    fun getFulfillments(
        params: OrderGetFulfillmentsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Fulfillment>

    /** A view of [OrderService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): OrderService.WithRawResponse

        fun stocks(): StockService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/orders/{order_id}`,
         * but is otherwise the same as [OrderService.retrieve].
         */
        @MustBeClosed
        fun retrieve(orderId: String, params: OrderRetrieveParams): HttpResponseFor<Order> =
            retrieve(orderId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            orderId: String,
            params: OrderRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Order> =
            retrieve(params.toBuilder().orderId(orderId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: OrderRetrieveParams): HttpResponseFor<Order> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: OrderRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Order>

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/orders`, but is
         * otherwise the same as [OrderService.list].
         */
        @MustBeClosed
        fun list(accountId: String): HttpResponseFor<List<Order>> =
            list(accountId, OrderListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            accountId: String,
            params: OrderListParams = OrderListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Order>> =
            list(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            accountId: String,
            params: OrderListParams = OrderListParams.none(),
        ): HttpResponseFor<List<Order>> = list(accountId, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: OrderListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Order>>

        /** @see list */
        @MustBeClosed
        fun list(params: OrderListParams): HttpResponseFor<List<Order>> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(accountId: String, requestOptions: RequestOptions): HttpResponseFor<List<Order>> =
            list(accountId, OrderListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post
         * /api/v2/accounts/{account_id}/orders/{order_id}/cancel`, but is otherwise the same as
         * [OrderService.cancel].
         */
        @MustBeClosed
        fun cancel(orderId: String, params: OrderCancelParams): HttpResponseFor<Order> =
            cancel(orderId, params, RequestOptions.none())

        /** @see cancel */
        @MustBeClosed
        fun cancel(
            orderId: String,
            params: OrderCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Order> =
            cancel(params.toBuilder().orderId(orderId).build(), requestOptions)

        /** @see cancel */
        @MustBeClosed
        fun cancel(params: OrderCancelParams): HttpResponseFor<Order> =
            cancel(params, RequestOptions.none())

        /** @see cancel */
        @MustBeClosed
        fun cancel(
            params: OrderCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Order>

        /**
         * Returns a raw HTTP response for `get
         * /api/v2/accounts/{account_id}/orders/{order_id}/fulfillments`, but is otherwise the same
         * as [OrderService.getFulfillments].
         */
        @MustBeClosed
        fun getFulfillments(
            orderId: String,
            params: OrderGetFulfillmentsParams,
        ): HttpResponseFor<List<Fulfillment>> =
            getFulfillments(orderId, params, RequestOptions.none())

        /** @see getFulfillments */
        @MustBeClosed
        fun getFulfillments(
            orderId: String,
            params: OrderGetFulfillmentsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Fulfillment>> =
            getFulfillments(params.toBuilder().orderId(orderId).build(), requestOptions)

        /** @see getFulfillments */
        @MustBeClosed
        fun getFulfillments(
            params: OrderGetFulfillmentsParams
        ): HttpResponseFor<List<Fulfillment>> = getFulfillments(params, RequestOptions.none())

        /** @see getFulfillments */
        @MustBeClosed
        fun getFulfillments(
            params: OrderGetFulfillmentsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Fulfillment>>
    }
}
