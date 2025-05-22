// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.v2.accounts

import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.v2.accounts.orderfulfillments.Fulfillment
import com.dinari.api.models.v2.accounts.orders.Order
import com.dinari.api.models.v2.accounts.orders.OrderCancelParams
import com.dinari.api.models.v2.accounts.orders.OrderGetFeeQuoteParams
import com.dinari.api.models.v2.accounts.orders.OrderGetFeeQuoteResponse
import com.dinari.api.models.v2.accounts.orders.OrderGetFulfillmentsParams
import com.dinari.api.models.v2.accounts.orders.OrderListParams
import com.dinari.api.models.v2.accounts.orders.OrderRetrieveParams
import com.google.errorprone.annotations.MustBeClosed
import java.util.concurrent.CompletableFuture

interface OrderServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Get a specific `Order` by its ID. */
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

    /** Get a list of all `Orders` under the `Account`. */
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

    /**
     * Get fee quote data for an `Order`.
     *
     * The `order_fee_contract_object` property contains the fee quote structure to be used verbatim
     * when placing an `Order` directly through our Contracts.
     */
    fun getFeeQuote(
        accountId: String,
        params: OrderGetFeeQuoteParams,
    ): CompletableFuture<OrderGetFeeQuoteResponse> =
        getFeeQuote(accountId, params, RequestOptions.none())

    /** @see [getFeeQuote] */
    fun getFeeQuote(
        accountId: String,
        params: OrderGetFeeQuoteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrderGetFeeQuoteResponse> =
        getFeeQuote(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [getFeeQuote] */
    fun getFeeQuote(params: OrderGetFeeQuoteParams): CompletableFuture<OrderGetFeeQuoteResponse> =
        getFeeQuote(params, RequestOptions.none())

    /** @see [getFeeQuote] */
    fun getFeeQuote(
        params: OrderGetFeeQuoteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrderGetFeeQuoteResponse>

    /** Get `OrderFulfillments` for a specific `Order`. */
    fun getFulfillments(
        orderId: String,
        params: OrderGetFulfillmentsParams,
    ): CompletableFuture<List<Fulfillment>> =
        getFulfillments(orderId, params, RequestOptions.none())

    /** @see [getFulfillments] */
    fun getFulfillments(
        orderId: String,
        params: OrderGetFulfillmentsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Fulfillment>> =
        getFulfillments(params.toBuilder().orderId(orderId).build(), requestOptions)

    /** @see [getFulfillments] */
    fun getFulfillments(params: OrderGetFulfillmentsParams): CompletableFuture<List<Fulfillment>> =
        getFulfillments(params, RequestOptions.none())

    /** @see [getFulfillments] */
    fun getFulfillments(
        params: OrderGetFulfillmentsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Fulfillment>>

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
         * Returns a raw HTTP response for `post /api/v2/accounts/{account_id}/orders/fee_quote`,
         * but is otherwise the same as [OrderServiceAsync.getFeeQuote].
         */
        @MustBeClosed
        fun getFeeQuote(
            accountId: String,
            params: OrderGetFeeQuoteParams,
        ): CompletableFuture<HttpResponseFor<OrderGetFeeQuoteResponse>> =
            getFeeQuote(accountId, params, RequestOptions.none())

        /** @see [getFeeQuote] */
        @MustBeClosed
        fun getFeeQuote(
            accountId: String,
            params: OrderGetFeeQuoteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrderGetFeeQuoteResponse>> =
            getFeeQuote(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [getFeeQuote] */
        @MustBeClosed
        fun getFeeQuote(
            params: OrderGetFeeQuoteParams
        ): CompletableFuture<HttpResponseFor<OrderGetFeeQuoteResponse>> =
            getFeeQuote(params, RequestOptions.none())

        /** @see [getFeeQuote] */
        @MustBeClosed
        fun getFeeQuote(
            params: OrderGetFeeQuoteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrderGetFeeQuoteResponse>>

        /**
         * Returns a raw HTTP response for `get
         * /api/v2/accounts/{account_id}/orders/{order_id}/fulfillments`, but is otherwise the same
         * as [OrderServiceAsync.getFulfillments].
         */
        @MustBeClosed
        fun getFulfillments(
            orderId: String,
            params: OrderGetFulfillmentsParams,
        ): CompletableFuture<HttpResponseFor<List<Fulfillment>>> =
            getFulfillments(orderId, params, RequestOptions.none())

        /** @see [getFulfillments] */
        @MustBeClosed
        fun getFulfillments(
            orderId: String,
            params: OrderGetFulfillmentsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Fulfillment>>> =
            getFulfillments(params.toBuilder().orderId(orderId).build(), requestOptions)

        /** @see [getFulfillments] */
        @MustBeClosed
        fun getFulfillments(
            params: OrderGetFulfillmentsParams
        ): CompletableFuture<HttpResponseFor<List<Fulfillment>>> =
            getFulfillments(params, RequestOptions.none())

        /** @see [getFulfillments] */
        @MustBeClosed
        fun getFulfillments(
            params: OrderGetFulfillmentsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Fulfillment>>>
    }
}
