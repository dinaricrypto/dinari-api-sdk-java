// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.api.v2.accounts

import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.api.v2.accounts.orderfulfillments.OrderFulfillment
import com.dinari.api.models.api.v2.accounts.orderfulfillments.OrderFulfillmentQueryParams
import com.google.errorprone.annotations.MustBeClosed

interface OrderFulfillmentService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Query `OrderFulfillments` under the `Account`. */
    fun query(accountId: String): List<OrderFulfillment> =
        query(accountId, OrderFulfillmentQueryParams.none())

    /** @see [query] */
    fun query(
        accountId: String,
        params: OrderFulfillmentQueryParams = OrderFulfillmentQueryParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<OrderFulfillment> =
        query(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [query] */
    fun query(
        accountId: String,
        params: OrderFulfillmentQueryParams = OrderFulfillmentQueryParams.none(),
    ): List<OrderFulfillment> = query(accountId, params, RequestOptions.none())

    /** @see [query] */
    fun query(
        params: OrderFulfillmentQueryParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<OrderFulfillment>

    /** @see [query] */
    fun query(params: OrderFulfillmentQueryParams): List<OrderFulfillment> =
        query(params, RequestOptions.none())

    /** @see [query] */
    fun query(accountId: String, requestOptions: RequestOptions): List<OrderFulfillment> =
        query(accountId, OrderFulfillmentQueryParams.none(), requestOptions)

    /**
     * A view of [OrderFulfillmentService] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/order_fulfillments`,
         * but is otherwise the same as [OrderFulfillmentService.query].
         */
        @MustBeClosed
        fun query(accountId: String): HttpResponseFor<List<OrderFulfillment>> =
            query(accountId, OrderFulfillmentQueryParams.none())

        /** @see [query] */
        @MustBeClosed
        fun query(
            accountId: String,
            params: OrderFulfillmentQueryParams = OrderFulfillmentQueryParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<OrderFulfillment>> =
            query(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [query] */
        @MustBeClosed
        fun query(
            accountId: String,
            params: OrderFulfillmentQueryParams = OrderFulfillmentQueryParams.none(),
        ): HttpResponseFor<List<OrderFulfillment>> = query(accountId, params, RequestOptions.none())

        /** @see [query] */
        @MustBeClosed
        fun query(
            params: OrderFulfillmentQueryParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<OrderFulfillment>>

        /** @see [query] */
        @MustBeClosed
        fun query(params: OrderFulfillmentQueryParams): HttpResponseFor<List<OrderFulfillment>> =
            query(params, RequestOptions.none())

        /** @see [query] */
        @MustBeClosed
        fun query(
            accountId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<OrderFulfillment>> =
            query(accountId, OrderFulfillmentQueryParams.none(), requestOptions)
    }
}
