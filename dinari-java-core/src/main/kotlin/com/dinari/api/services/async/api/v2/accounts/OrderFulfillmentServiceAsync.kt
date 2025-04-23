// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.api.v2.accounts

import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.api.v2.accounts.orderfulfillments.OrderFulfillment
import com.dinari.api.models.api.v2.accounts.orderfulfillments.OrderFulfillmentQueryParams
import com.dinari.api.models.api.v2.accounts.orderfulfillments.OrderFulfillmentRetrieveParams
import com.google.errorprone.annotations.MustBeClosed
import java.util.concurrent.CompletableFuture

interface OrderFulfillmentServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Retrieves details of a specific order fulfillment by its ID. */
    fun retrieve(params: OrderFulfillmentRetrieveParams): CompletableFuture<OrderFulfillment> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: OrderFulfillmentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrderFulfillment>

    /** Queries all order fulfillments under the account. */
    fun query(params: OrderFulfillmentQueryParams): CompletableFuture<List<OrderFulfillment>> =
        query(params, RequestOptions.none())

    /** @see [query] */
    fun query(
        params: OrderFulfillmentQueryParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<OrderFulfillment>>

    /**
     * A view of [OrderFulfillmentServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get
         * /api/v2/accounts/{account_id}/order_fulfillments/{fulfillment_id}`, but is otherwise the
         * same as [OrderFulfillmentServiceAsync.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            params: OrderFulfillmentRetrieveParams
        ): CompletableFuture<HttpResponseFor<OrderFulfillment>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: OrderFulfillmentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrderFulfillment>>

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/order_fulfillments`,
         * but is otherwise the same as [OrderFulfillmentServiceAsync.query].
         */
        @MustBeClosed
        fun query(
            params: OrderFulfillmentQueryParams
        ): CompletableFuture<HttpResponseFor<List<OrderFulfillment>>> =
            query(params, RequestOptions.none())

        /** @see [query] */
        @MustBeClosed
        fun query(
            params: OrderFulfillmentQueryParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<OrderFulfillment>>>
    }
}
