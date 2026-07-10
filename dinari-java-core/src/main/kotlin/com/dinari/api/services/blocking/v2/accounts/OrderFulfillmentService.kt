// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.accounts

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.v2.accounts.orderfulfillments.Fulfillment
import com.dinari.api.models.v2.accounts.orderfulfillments.OrderFulfillmentQueryParams
import com.dinari.api.models.v2.accounts.orderfulfillments.OrderFulfillmentRetrieveParams
import com.dinari.api.models.v2.accounts.orderfulfillments.PaginatedOrderFulfillment
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

    /** @see retrieve */
    fun retrieve(
        orderFulfillmentId: String,
        params: OrderFulfillmentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Fulfillment =
        retrieve(params.toBuilder().orderFulfillmentId(orderFulfillmentId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: OrderFulfillmentRetrieveParams): Fulfillment =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: OrderFulfillmentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Fulfillment

    /** Query `OrderFulfillments` under the `Account`. */
    fun query(accountId: String): PaginatedOrderFulfillment =
        query(accountId, OrderFulfillmentQueryParams.none())

    /** @see query */
    fun query(
        accountId: String,
        params: OrderFulfillmentQueryParams = OrderFulfillmentQueryParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedOrderFulfillment =
        query(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see query */
    fun query(
        accountId: String,
        params: OrderFulfillmentQueryParams = OrderFulfillmentQueryParams.none(),
    ): PaginatedOrderFulfillment = query(accountId, params, RequestOptions.none())

    /** @see query */
    fun query(
        params: OrderFulfillmentQueryParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedOrderFulfillment

    /** @see query */
    fun query(params: OrderFulfillmentQueryParams): PaginatedOrderFulfillment =
        query(params, RequestOptions.none())

    /** @see query */
    fun query(accountId: String, requestOptions: RequestOptions): PaginatedOrderFulfillment =
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

        /** @see retrieve */
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

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: OrderFulfillmentRetrieveParams): HttpResponseFor<Fulfillment> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
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
        fun query(accountId: String): HttpResponseFor<PaginatedOrderFulfillment> =
            query(accountId, OrderFulfillmentQueryParams.none())

        /** @see query */
        @MustBeClosed
        fun query(
            accountId: String,
            params: OrderFulfillmentQueryParams = OrderFulfillmentQueryParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedOrderFulfillment> =
            query(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see query */
        @MustBeClosed
        fun query(
            accountId: String,
            params: OrderFulfillmentQueryParams = OrderFulfillmentQueryParams.none(),
        ): HttpResponseFor<PaginatedOrderFulfillment> =
            query(accountId, params, RequestOptions.none())

        /** @see query */
        @MustBeClosed
        fun query(
            params: OrderFulfillmentQueryParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedOrderFulfillment>

        /** @see query */
        @MustBeClosed
        fun query(params: OrderFulfillmentQueryParams): HttpResponseFor<PaginatedOrderFulfillment> =
            query(params, RequestOptions.none())

        /** @see query */
        @MustBeClosed
        fun query(
            accountId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PaginatedOrderFulfillment> =
            query(accountId, OrderFulfillmentQueryParams.none(), requestOptions)
    }
}
