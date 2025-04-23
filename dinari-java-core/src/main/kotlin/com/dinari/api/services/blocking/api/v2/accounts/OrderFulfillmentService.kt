// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.api.v2.accounts

import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.api.v2.accounts.orderfulfillments.OrderFulfillment
import com.dinari.api.models.api.v2.accounts.orderfulfillments.OrderFulfillmentQueryParams
import com.dinari.api.models.api.v2.accounts.orderfulfillments.OrderFulfillmentRetrieveParams
import com.google.errorprone.annotations.MustBeClosed

interface OrderFulfillmentService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Retrieves details of a specific order fulfillment by its ID. */
    fun retrieve(params: OrderFulfillmentRetrieveParams): OrderFulfillment =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: OrderFulfillmentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrderFulfillment

    /** Queries all order fulfillments under the account. */
    fun query(params: OrderFulfillmentQueryParams): List<OrderFulfillment> =
        query(params, RequestOptions.none())

    /** @see [query] */
    fun query(
        params: OrderFulfillmentQueryParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<OrderFulfillment>

    /**
     * A view of [OrderFulfillmentService] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get
         * /api/v2/accounts/{account_id}/order_fulfillments/{fulfillment_id}`, but is otherwise the
         * same as [OrderFulfillmentService.retrieve].
         */
        @MustBeClosed
        fun retrieve(params: OrderFulfillmentRetrieveParams): HttpResponseFor<OrderFulfillment> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: OrderFulfillmentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrderFulfillment>

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/order_fulfillments`,
         * but is otherwise the same as [OrderFulfillmentService.query].
         */
        @MustBeClosed
        fun query(params: OrderFulfillmentQueryParams): HttpResponseFor<List<OrderFulfillment>> =
            query(params, RequestOptions.none())

        /** @see [query] */
        @MustBeClosed
        fun query(
            params: OrderFulfillmentQueryParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<OrderFulfillment>>
    }
}
