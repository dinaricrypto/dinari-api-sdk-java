// File generated from our OpenAPI spec by Stainless.

package com.dinari.services.async.v2.accounts

import com.dinari.core.ClientOptions
import com.dinari.core.RequestOptions
import com.dinari.core.http.HttpResponseFor
import com.dinari.models.v2.accounts.orderfulfillments.Fulfillment
import com.dinari.models.v2.accounts.orderfulfillments.OrderFulfillmentQueryParams
import com.dinari.models.v2.accounts.orderfulfillments.OrderFulfillmentRetrieveParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface OrderFulfillmentServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): OrderFulfillmentServiceAsync

    /** Get a specific `OrderFulfillment` by its ID. */
    fun retrieve(
        orderFulfillmentId: String,
        params: OrderFulfillmentRetrieveParams,
    ): CompletableFuture<Fulfillment> = retrieve(orderFulfillmentId, params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        orderFulfillmentId: String,
        params: OrderFulfillmentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Fulfillment> =
        retrieve(params.toBuilder().orderFulfillmentId(orderFulfillmentId).build(), requestOptions)

    /** @see [retrieve] */
    fun retrieve(params: OrderFulfillmentRetrieveParams): CompletableFuture<Fulfillment> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: OrderFulfillmentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Fulfillment>

    /** Query `OrderFulfillments` under the `Account`. */
    fun query(accountId: String): CompletableFuture<List<Fulfillment>> =
        query(accountId, OrderFulfillmentQueryParams.none())

    /** @see [query] */
    fun query(
        accountId: String,
        params: OrderFulfillmentQueryParams = OrderFulfillmentQueryParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Fulfillment>> =
        query(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [query] */
    fun query(
        accountId: String,
        params: OrderFulfillmentQueryParams = OrderFulfillmentQueryParams.none(),
    ): CompletableFuture<List<Fulfillment>> = query(accountId, params, RequestOptions.none())

    /** @see [query] */
    fun query(
        params: OrderFulfillmentQueryParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Fulfillment>>

    /** @see [query] */
    fun query(params: OrderFulfillmentQueryParams): CompletableFuture<List<Fulfillment>> =
        query(params, RequestOptions.none())

    /** @see [query] */
    fun query(
        accountId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<Fulfillment>> =
        query(accountId, OrderFulfillmentQueryParams.none(), requestOptions)

    /**
     * A view of [OrderFulfillmentServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): OrderFulfillmentServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get
         * /api/v2/accounts/{account_id}/order_fulfillments/{order_fulfillment_id}`, but is
         * otherwise the same as [OrderFulfillmentServiceAsync.retrieve].
         */
        fun retrieve(
            orderFulfillmentId: String,
            params: OrderFulfillmentRetrieveParams,
        ): CompletableFuture<HttpResponseFor<Fulfillment>> =
            retrieve(orderFulfillmentId, params, RequestOptions.none())

        /** @see [retrieve] */
        fun retrieve(
            orderFulfillmentId: String,
            params: OrderFulfillmentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Fulfillment>> =
            retrieve(
                params.toBuilder().orderFulfillmentId(orderFulfillmentId).build(),
                requestOptions,
            )

        /** @see [retrieve] */
        fun retrieve(
            params: OrderFulfillmentRetrieveParams
        ): CompletableFuture<HttpResponseFor<Fulfillment>> = retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        fun retrieve(
            params: OrderFulfillmentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Fulfillment>>

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/order_fulfillments`,
         * but is otherwise the same as [OrderFulfillmentServiceAsync.query].
         */
        fun query(accountId: String): CompletableFuture<HttpResponseFor<List<Fulfillment>>> =
            query(accountId, OrderFulfillmentQueryParams.none())

        /** @see [query] */
        fun query(
            accountId: String,
            params: OrderFulfillmentQueryParams = OrderFulfillmentQueryParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Fulfillment>>> =
            query(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [query] */
        fun query(
            accountId: String,
            params: OrderFulfillmentQueryParams = OrderFulfillmentQueryParams.none(),
        ): CompletableFuture<HttpResponseFor<List<Fulfillment>>> =
            query(accountId, params, RequestOptions.none())

        /** @see [query] */
        fun query(
            params: OrderFulfillmentQueryParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Fulfillment>>>

        /** @see [query] */
        fun query(
            params: OrderFulfillmentQueryParams
        ): CompletableFuture<HttpResponseFor<List<Fulfillment>>> =
            query(params, RequestOptions.none())

        /** @see [query] */
        fun query(
            accountId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<Fulfillment>>> =
            query(accountId, OrderFulfillmentQueryParams.none(), requestOptions)
    }
}
