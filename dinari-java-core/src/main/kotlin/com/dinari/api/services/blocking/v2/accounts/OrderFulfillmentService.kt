// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.accounts

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.v2.accounts.orderfulfillments.Fulfillment
import com.dinari.api.models.v2.accounts.orderfulfillments.OrderFulfillmentQueryParams
import com.dinari.api.models.v2.accounts.orderfulfillments.OrderFulfillmentRetrieveParams
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface OrderFulfillmentService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): OrderFulfillmentService

    /** Get a specific `OrderFulfillment` by its ID. */
    fun retrieve(orderFulfillmentId: String, params: OrderFulfillmentRetrieveParams): Fulfillment =
        retrieve(orderFulfillmentId, params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        orderFulfillmentId: String,
        params: OrderFulfillmentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Fulfillment =
        retrieve(params.toBuilder().orderFulfillmentId(orderFulfillmentId).build(), requestOptions)

    /** @see [retrieve] */
    fun retrieve(params: OrderFulfillmentRetrieveParams): Fulfillment =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: OrderFulfillmentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Fulfillment

    /** Query `OrderFulfillments` under the `Account`. */
    fun query(accountId: String): List<Fulfillment> =
        query(accountId, OrderFulfillmentQueryParams.none())

    /** @see [query] */
    fun query(
        accountId: String,
        params: OrderFulfillmentQueryParams = OrderFulfillmentQueryParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Fulfillment> = query(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [query] */
    fun query(
        accountId: String,
        params: OrderFulfillmentQueryParams = OrderFulfillmentQueryParams.none(),
    ): List<Fulfillment> = query(accountId, params, RequestOptions.none())

    /** @see [query] */
    fun query(
        params: OrderFulfillmentQueryParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Fulfillment>

    /** @see [query] */
    fun query(params: OrderFulfillmentQueryParams): List<Fulfillment> =
        query(params, RequestOptions.none())

    /** @see [query] */
    fun query(accountId: String, requestOptions: RequestOptions): List<Fulfillment> =
        query(accountId, OrderFulfillmentQueryParams.none(), requestOptions)

    /**
     * A view of [OrderFulfillmentService] that provides access to raw HTTP responses for each
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
        ): OrderFulfillmentService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get
         * /api/v2/accounts/{account_id}/order_fulfillments/{order_fulfillment_id}`, but is
         * otherwise the same as [OrderFulfillmentService.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            orderFulfillmentId: String,
            params: OrderFulfillmentRetrieveParams,
        ): HttpResponseFor<Fulfillment> =
            retrieve(orderFulfillmentId, params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            orderFulfillmentId: String,
            params: OrderFulfillmentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Fulfillment> =
            retrieve(
                params.toBuilder().orderFulfillmentId(orderFulfillmentId).build(),
                requestOptions,
            )

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(params: OrderFulfillmentRetrieveParams): HttpResponseFor<Fulfillment> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: OrderFulfillmentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Fulfillment>

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/order_fulfillments`,
         * but is otherwise the same as [OrderFulfillmentService.query].
         */
        @MustBeClosed
        fun query(accountId: String): HttpResponseFor<List<Fulfillment>> =
            query(accountId, OrderFulfillmentQueryParams.none())

        /** @see [query] */
        @MustBeClosed
        fun query(
            accountId: String,
            params: OrderFulfillmentQueryParams = OrderFulfillmentQueryParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Fulfillment>> =
            query(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [query] */
        @MustBeClosed
        fun query(
            accountId: String,
            params: OrderFulfillmentQueryParams = OrderFulfillmentQueryParams.none(),
        ): HttpResponseFor<List<Fulfillment>> = query(accountId, params, RequestOptions.none())

        /** @see [query] */
        @MustBeClosed
        fun query(
            params: OrderFulfillmentQueryParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Fulfillment>>

        /** @see [query] */
        @MustBeClosed
        fun query(params: OrderFulfillmentQueryParams): HttpResponseFor<List<Fulfillment>> =
            query(params, RequestOptions.none())

        /** @see [query] */
        @MustBeClosed
        fun query(
            accountId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<Fulfillment>> =
            query(accountId, OrderFulfillmentQueryParams.none(), requestOptions)
    }
}
