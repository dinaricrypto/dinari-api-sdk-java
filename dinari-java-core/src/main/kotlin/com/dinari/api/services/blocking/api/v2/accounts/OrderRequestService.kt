// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.api.v2.accounts

import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.api.v2.accounts.orderrequests.OrderRequest
import com.dinari.api.models.api.v2.accounts.orderrequests.OrderRequestCreateLimitBuyParams
import com.dinari.api.models.api.v2.accounts.orderrequests.OrderRequestCreateLimitSellParams
import com.dinari.api.models.api.v2.accounts.orderrequests.OrderRequestCreateMarketBuyParams
import com.dinari.api.models.api.v2.accounts.orderrequests.OrderRequestCreateMarketSellParams
import com.dinari.api.models.api.v2.accounts.orderrequests.OrderRequestListParams
import com.dinari.api.models.api.v2.accounts.orderrequests.OrderRequestRetrieveParams
import com.google.errorprone.annotations.MustBeClosed

interface OrderRequestService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Retrieves details of a specific managed order request by its ID. */
    fun retrieve(requestId: String, params: OrderRequestRetrieveParams): OrderRequest =
        retrieve(requestId, params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        requestId: String,
        params: OrderRequestRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrderRequest = retrieve(params.toBuilder().requestId(requestId).build(), requestOptions)

    /** @see [retrieve] */
    fun retrieve(params: OrderRequestRetrieveParams): OrderRequest =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: OrderRequestRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrderRequest

    /** Lists managed order requests. */
    fun list(accountId: String): List<OrderRequest> = list(accountId, OrderRequestListParams.none())

    /** @see [list] */
    fun list(
        accountId: String,
        params: OrderRequestListParams = OrderRequestListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<OrderRequest> = list(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [list] */
    fun list(
        accountId: String,
        params: OrderRequestListParams = OrderRequestListParams.none(),
    ): List<OrderRequest> = list(accountId, params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: OrderRequestListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<OrderRequest>

    /** @see [list] */
    fun list(params: OrderRequestListParams): List<OrderRequest> =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(accountId: String, requestOptions: RequestOptions): List<OrderRequest> =
        list(accountId, OrderRequestListParams.none(), requestOptions)

    /** Creates a managed limit buy request. */
    fun createLimitBuy(accountId: String, params: OrderRequestCreateLimitBuyParams): OrderRequest =
        createLimitBuy(accountId, params, RequestOptions.none())

    /** @see [createLimitBuy] */
    fun createLimitBuy(
        accountId: String,
        params: OrderRequestCreateLimitBuyParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrderRequest =
        createLimitBuy(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [createLimitBuy] */
    fun createLimitBuy(params: OrderRequestCreateLimitBuyParams): OrderRequest =
        createLimitBuy(params, RequestOptions.none())

    /** @see [createLimitBuy] */
    fun createLimitBuy(
        params: OrderRequestCreateLimitBuyParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrderRequest

    /** Creates a managed limit sell request. */
    fun createLimitSell(
        accountId: String,
        params: OrderRequestCreateLimitSellParams,
    ): OrderRequest = createLimitSell(accountId, params, RequestOptions.none())

    /** @see [createLimitSell] */
    fun createLimitSell(
        accountId: String,
        params: OrderRequestCreateLimitSellParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrderRequest =
        createLimitSell(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [createLimitSell] */
    fun createLimitSell(params: OrderRequestCreateLimitSellParams): OrderRequest =
        createLimitSell(params, RequestOptions.none())

    /** @see [createLimitSell] */
    fun createLimitSell(
        params: OrderRequestCreateLimitSellParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrderRequest

    /** Creates a managed market buy request. */
    fun createMarketBuy(
        accountId: String,
        params: OrderRequestCreateMarketBuyParams,
    ): OrderRequest = createMarketBuy(accountId, params, RequestOptions.none())

    /** @see [createMarketBuy] */
    fun createMarketBuy(
        accountId: String,
        params: OrderRequestCreateMarketBuyParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrderRequest =
        createMarketBuy(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [createMarketBuy] */
    fun createMarketBuy(params: OrderRequestCreateMarketBuyParams): OrderRequest =
        createMarketBuy(params, RequestOptions.none())

    /** @see [createMarketBuy] */
    fun createMarketBuy(
        params: OrderRequestCreateMarketBuyParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrderRequest

    /** Creates a managed market sell request. */
    fun createMarketSell(
        accountId: String,
        params: OrderRequestCreateMarketSellParams,
    ): OrderRequest = createMarketSell(accountId, params, RequestOptions.none())

    /** @see [createMarketSell] */
    fun createMarketSell(
        accountId: String,
        params: OrderRequestCreateMarketSellParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrderRequest =
        createMarketSell(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [createMarketSell] */
    fun createMarketSell(params: OrderRequestCreateMarketSellParams): OrderRequest =
        createMarketSell(params, RequestOptions.none())

    /** @see [createMarketSell] */
    fun createMarketSell(
        params: OrderRequestCreateMarketSellParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrderRequest

    /**
     * A view of [OrderRequestService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get
         * /api/v2/accounts/{account_id}/order_requests/{request_id}`, but is otherwise the same as
         * [OrderRequestService.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            requestId: String,
            params: OrderRequestRetrieveParams,
        ): HttpResponseFor<OrderRequest> = retrieve(requestId, params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            requestId: String,
            params: OrderRequestRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrderRequest> =
            retrieve(params.toBuilder().requestId(requestId).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(params: OrderRequestRetrieveParams): HttpResponseFor<OrderRequest> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: OrderRequestRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrderRequest>

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/order_requests`, but
         * is otherwise the same as [OrderRequestService.list].
         */
        @MustBeClosed
        fun list(accountId: String): HttpResponseFor<List<OrderRequest>> =
            list(accountId, OrderRequestListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            accountId: String,
            params: OrderRequestListParams = OrderRequestListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<OrderRequest>> =
            list(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [list] */
        @MustBeClosed
        fun list(
            accountId: String,
            params: OrderRequestListParams = OrderRequestListParams.none(),
        ): HttpResponseFor<List<OrderRequest>> = list(accountId, params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: OrderRequestListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<OrderRequest>>

        /** @see [list] */
        @MustBeClosed
        fun list(params: OrderRequestListParams): HttpResponseFor<List<OrderRequest>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            accountId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<OrderRequest>> =
            list(accountId, OrderRequestListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post
         * /api/v2/accounts/{account_id}/order_requests/limit_buy`, but is otherwise the same as
         * [OrderRequestService.createLimitBuy].
         */
        @MustBeClosed
        fun createLimitBuy(
            accountId: String,
            params: OrderRequestCreateLimitBuyParams,
        ): HttpResponseFor<OrderRequest> = createLimitBuy(accountId, params, RequestOptions.none())

        /** @see [createLimitBuy] */
        @MustBeClosed
        fun createLimitBuy(
            accountId: String,
            params: OrderRequestCreateLimitBuyParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrderRequest> =
            createLimitBuy(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [createLimitBuy] */
        @MustBeClosed
        fun createLimitBuy(
            params: OrderRequestCreateLimitBuyParams
        ): HttpResponseFor<OrderRequest> = createLimitBuy(params, RequestOptions.none())

        /** @see [createLimitBuy] */
        @MustBeClosed
        fun createLimitBuy(
            params: OrderRequestCreateLimitBuyParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrderRequest>

        /**
         * Returns a raw HTTP response for `post
         * /api/v2/accounts/{account_id}/order_requests/limit_sell`, but is otherwise the same as
         * [OrderRequestService.createLimitSell].
         */
        @MustBeClosed
        fun createLimitSell(
            accountId: String,
            params: OrderRequestCreateLimitSellParams,
        ): HttpResponseFor<OrderRequest> = createLimitSell(accountId, params, RequestOptions.none())

        /** @see [createLimitSell] */
        @MustBeClosed
        fun createLimitSell(
            accountId: String,
            params: OrderRequestCreateLimitSellParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrderRequest> =
            createLimitSell(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [createLimitSell] */
        @MustBeClosed
        fun createLimitSell(
            params: OrderRequestCreateLimitSellParams
        ): HttpResponseFor<OrderRequest> = createLimitSell(params, RequestOptions.none())

        /** @see [createLimitSell] */
        @MustBeClosed
        fun createLimitSell(
            params: OrderRequestCreateLimitSellParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrderRequest>

        /**
         * Returns a raw HTTP response for `post
         * /api/v2/accounts/{account_id}/order_requests/market_buy`, but is otherwise the same as
         * [OrderRequestService.createMarketBuy].
         */
        @MustBeClosed
        fun createMarketBuy(
            accountId: String,
            params: OrderRequestCreateMarketBuyParams,
        ): HttpResponseFor<OrderRequest> = createMarketBuy(accountId, params, RequestOptions.none())

        /** @see [createMarketBuy] */
        @MustBeClosed
        fun createMarketBuy(
            accountId: String,
            params: OrderRequestCreateMarketBuyParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrderRequest> =
            createMarketBuy(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [createMarketBuy] */
        @MustBeClosed
        fun createMarketBuy(
            params: OrderRequestCreateMarketBuyParams
        ): HttpResponseFor<OrderRequest> = createMarketBuy(params, RequestOptions.none())

        /** @see [createMarketBuy] */
        @MustBeClosed
        fun createMarketBuy(
            params: OrderRequestCreateMarketBuyParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrderRequest>

        /**
         * Returns a raw HTTP response for `post
         * /api/v2/accounts/{account_id}/order_requests/market_sell`, but is otherwise the same as
         * [OrderRequestService.createMarketSell].
         */
        @MustBeClosed
        fun createMarketSell(
            accountId: String,
            params: OrderRequestCreateMarketSellParams,
        ): HttpResponseFor<OrderRequest> =
            createMarketSell(accountId, params, RequestOptions.none())

        /** @see [createMarketSell] */
        @MustBeClosed
        fun createMarketSell(
            accountId: String,
            params: OrderRequestCreateMarketSellParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrderRequest> =
            createMarketSell(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [createMarketSell] */
        @MustBeClosed
        fun createMarketSell(
            params: OrderRequestCreateMarketSellParams
        ): HttpResponseFor<OrderRequest> = createMarketSell(params, RequestOptions.none())

        /** @see [createMarketSell] */
        @MustBeClosed
        fun createMarketSell(
            params: OrderRequestCreateMarketSellParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrderRequest>
    }
}
