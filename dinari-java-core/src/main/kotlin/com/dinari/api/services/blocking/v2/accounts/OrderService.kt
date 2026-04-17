// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.accounts

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.v2.accounts.orders.Order
import com.dinari.api.models.v2.accounts.orders.OrderBatchCancelParams
import com.dinari.api.models.v2.accounts.orders.OrderBatchCancelResponse
import com.dinari.api.models.v2.accounts.orders.OrderCancelParams
import com.dinari.api.models.v2.accounts.orders.OrderGetFulfillmentsParams
import com.dinari.api.models.v2.accounts.orders.OrderGetFulfillmentsResponse
import com.dinari.api.models.v2.accounts.orders.OrderListParams
import com.dinari.api.models.v2.accounts.orders.OrderListResponse
import com.dinari.api.models.v2.accounts.orders.OrderRetrieveParams
import com.google.errorprone.annotations.MustBeClosed
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
     * Get a list of all `Orders` under the `Account`.<br>Optionally `Orders` can be filtered by
     * chain ID, transaction hash, or client order ID.
     */
    fun list(accountId: String): OrderListResponse = list(accountId, OrderListParams.none())

    /** @see list */
    fun list(
        accountId: String,
        params: OrderListParams = OrderListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrderListResponse = list(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see list */
    fun list(
        accountId: String,
        params: OrderListParams = OrderListParams.none(),
    ): OrderListResponse = list(accountId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: OrderListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrderListResponse

    /** @see list */
    fun list(params: OrderListParams): OrderListResponse = list(params, RequestOptions.none())

    /** @see list */
    fun list(accountId: String, requestOptions: RequestOptions): OrderListResponse =
        list(accountId, OrderListParams.none(), requestOptions)

    /**
     * Cancel multiple `Orders` by their IDs in a single request. Note that this requires the
     * `Order` IDs, not the `OrderRequest` IDs. Once you submit a cancellation request, it cannot be
     * undone. Be advised that orders with a status of PENDING_FILL, PENDING_ESCROW, FILLED,
     * REJECTED, or CANCELLED cannot be cancelled.
     *
     * `Order` cancellation is not guaranteed nor is it immediate. The `Orders` may still be
     * executed if the cancellation request is not received in time.
     *
     * The response will indicate which orders were successfully queued to cancel and which failed
     * to queue. Check the status using the "Get Order by ID" endpoint to confirm whether individual
     * `Orders` have been cancelled.
     */
    fun batchCancel(accountId: String, params: OrderBatchCancelParams): OrderBatchCancelResponse =
        batchCancel(accountId, params, RequestOptions.none())

    /** @see batchCancel */
    fun batchCancel(
        accountId: String,
        params: OrderBatchCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrderBatchCancelResponse =
        batchCancel(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see batchCancel */
    fun batchCancel(params: OrderBatchCancelParams): OrderBatchCancelResponse =
        batchCancel(params, RequestOptions.none())

    /** @see batchCancel */
    fun batchCancel(
        params: OrderBatchCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrderBatchCancelResponse

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
    fun getFulfillments(
        orderId: String,
        params: OrderGetFulfillmentsParams,
    ): OrderGetFulfillmentsResponse = getFulfillments(orderId, params, RequestOptions.none())

    /** @see getFulfillments */
    fun getFulfillments(
        orderId: String,
        params: OrderGetFulfillmentsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrderGetFulfillmentsResponse =
        getFulfillments(params.toBuilder().orderId(orderId).build(), requestOptions)

    /** @see getFulfillments */
    fun getFulfillments(params: OrderGetFulfillmentsParams): OrderGetFulfillmentsResponse =
        getFulfillments(params, RequestOptions.none())

    /** @see getFulfillments */
    fun getFulfillments(
        params: OrderGetFulfillmentsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrderGetFulfillmentsResponse

    /** A view of [OrderService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): OrderService.WithRawResponse

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
        fun list(accountId: String): HttpResponseFor<OrderListResponse> =
            list(accountId, OrderListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            accountId: String,
            params: OrderListParams = OrderListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrderListResponse> =
            list(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            accountId: String,
            params: OrderListParams = OrderListParams.none(),
        ): HttpResponseFor<OrderListResponse> = list(accountId, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: OrderListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrderListResponse>

        /** @see list */
        @MustBeClosed
        fun list(params: OrderListParams): HttpResponseFor<OrderListResponse> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            accountId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<OrderListResponse> =
            list(accountId, OrderListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /api/v2/accounts/{account_id}/orders/cancel`, but
         * is otherwise the same as [OrderService.batchCancel].
         */
        @MustBeClosed
        fun batchCancel(
            accountId: String,
            params: OrderBatchCancelParams,
        ): HttpResponseFor<OrderBatchCancelResponse> =
            batchCancel(accountId, params, RequestOptions.none())

        /** @see batchCancel */
        @MustBeClosed
        fun batchCancel(
            accountId: String,
            params: OrderBatchCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrderBatchCancelResponse> =
            batchCancel(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see batchCancel */
        @MustBeClosed
        fun batchCancel(params: OrderBatchCancelParams): HttpResponseFor<OrderBatchCancelResponse> =
            batchCancel(params, RequestOptions.none())

        /** @see batchCancel */
        @MustBeClosed
        fun batchCancel(
            params: OrderBatchCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrderBatchCancelResponse>

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
        ): HttpResponseFor<OrderGetFulfillmentsResponse> =
            getFulfillments(orderId, params, RequestOptions.none())

        /** @see getFulfillments */
        @MustBeClosed
        fun getFulfillments(
            orderId: String,
            params: OrderGetFulfillmentsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrderGetFulfillmentsResponse> =
            getFulfillments(params.toBuilder().orderId(orderId).build(), requestOptions)

        /** @see getFulfillments */
        @MustBeClosed
        fun getFulfillments(
            params: OrderGetFulfillmentsParams
        ): HttpResponseFor<OrderGetFulfillmentsResponse> =
            getFulfillments(params, RequestOptions.none())

        /** @see getFulfillments */
        @MustBeClosed
        fun getFulfillments(
            params: OrderGetFulfillmentsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrderGetFulfillmentsResponse>
    }
}
