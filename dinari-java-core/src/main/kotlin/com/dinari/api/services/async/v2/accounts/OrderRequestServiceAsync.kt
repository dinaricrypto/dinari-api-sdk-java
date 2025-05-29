// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.v2.accounts

import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequest
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestCreateLimitBuyParams
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestCreateLimitSellParams
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestCreateMarketBuyParams
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestCreateMarketSellParams
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestListParams
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestRetrieveParams
import java.util.concurrent.CompletableFuture

interface OrderRequestServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Get a specific managed `OrderRequest` by its ID. */
    fun retrieve(
        orderRequestId: String,
        params: OrderRequestRetrieveParams,
    ): CompletableFuture<OrderRequest> = retrieve(orderRequestId, params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        orderRequestId: String,
        params: OrderRequestRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrderRequest> =
        retrieve(params.toBuilder().orderRequestId(orderRequestId).build(), requestOptions)

    /** @see [retrieve] */
    fun retrieve(params: OrderRequestRetrieveParams): CompletableFuture<OrderRequest> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: OrderRequestRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrderRequest>

    /** Lists managed `OrderRequests`. */
    fun list(accountId: String): CompletableFuture<List<OrderRequest>> =
        list(accountId, OrderRequestListParams.none())

    /** @see [list] */
    fun list(
        accountId: String,
        params: OrderRequestListParams = OrderRequestListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<OrderRequest>> =
        list(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [list] */
    fun list(
        accountId: String,
        params: OrderRequestListParams = OrderRequestListParams.none(),
    ): CompletableFuture<List<OrderRequest>> = list(accountId, params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: OrderRequestListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<OrderRequest>>

    /** @see [list] */
    fun list(params: OrderRequestListParams): CompletableFuture<List<OrderRequest>> =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(
        accountId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<OrderRequest>> =
        list(accountId, OrderRequestListParams.none(), requestOptions)

    /** Create a managed limit buy `OrderRequest`. */
    fun createLimitBuy(
        accountId: String,
        params: OrderRequestCreateLimitBuyParams,
    ): CompletableFuture<OrderRequest> = createLimitBuy(accountId, params, RequestOptions.none())

    /** @see [createLimitBuy] */
    fun createLimitBuy(
        accountId: String,
        params: OrderRequestCreateLimitBuyParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrderRequest> =
        createLimitBuy(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [createLimitBuy] */
    fun createLimitBuy(params: OrderRequestCreateLimitBuyParams): CompletableFuture<OrderRequest> =
        createLimitBuy(params, RequestOptions.none())

    /** @see [createLimitBuy] */
    fun createLimitBuy(
        params: OrderRequestCreateLimitBuyParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrderRequest>

    /** Create a managed limit sell `OrderRequest`. */
    fun createLimitSell(
        accountId: String,
        params: OrderRequestCreateLimitSellParams,
    ): CompletableFuture<OrderRequest> = createLimitSell(accountId, params, RequestOptions.none())

    /** @see [createLimitSell] */
    fun createLimitSell(
        accountId: String,
        params: OrderRequestCreateLimitSellParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrderRequest> =
        createLimitSell(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [createLimitSell] */
    fun createLimitSell(
        params: OrderRequestCreateLimitSellParams
    ): CompletableFuture<OrderRequest> = createLimitSell(params, RequestOptions.none())

    /** @see [createLimitSell] */
    fun createLimitSell(
        params: OrderRequestCreateLimitSellParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrderRequest>

    /** Create a managed market buy `OrderRequest`. */
    fun createMarketBuy(
        accountId: String,
        params: OrderRequestCreateMarketBuyParams,
    ): CompletableFuture<OrderRequest> = createMarketBuy(accountId, params, RequestOptions.none())

    /** @see [createMarketBuy] */
    fun createMarketBuy(
        accountId: String,
        params: OrderRequestCreateMarketBuyParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrderRequest> =
        createMarketBuy(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [createMarketBuy] */
    fun createMarketBuy(
        params: OrderRequestCreateMarketBuyParams
    ): CompletableFuture<OrderRequest> = createMarketBuy(params, RequestOptions.none())

    /** @see [createMarketBuy] */
    fun createMarketBuy(
        params: OrderRequestCreateMarketBuyParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrderRequest>

    /** Create a managed market sell `OrderRequest`. */
    fun createMarketSell(
        accountId: String,
        params: OrderRequestCreateMarketSellParams,
    ): CompletableFuture<OrderRequest> = createMarketSell(accountId, params, RequestOptions.none())

    /** @see [createMarketSell] */
    fun createMarketSell(
        accountId: String,
        params: OrderRequestCreateMarketSellParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrderRequest> =
        createMarketSell(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [createMarketSell] */
    fun createMarketSell(
        params: OrderRequestCreateMarketSellParams
    ): CompletableFuture<OrderRequest> = createMarketSell(params, RequestOptions.none())

    /** @see [createMarketSell] */
    fun createMarketSell(
        params: OrderRequestCreateMarketSellParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrderRequest>

    /**
     * A view of [OrderRequestServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get
         * /api/v2/accounts/{account_id}/order_requests/{order_request_id}`, but is otherwise the
         * same as [OrderRequestServiceAsync.retrieve].
         */
        fun retrieve(
            orderRequestId: String,
            params: OrderRequestRetrieveParams,
        ): CompletableFuture<HttpResponseFor<OrderRequest>> =
            retrieve(orderRequestId, params, RequestOptions.none())

        /** @see [retrieve] */
        fun retrieve(
            orderRequestId: String,
            params: OrderRequestRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrderRequest>> =
            retrieve(params.toBuilder().orderRequestId(orderRequestId).build(), requestOptions)

        /** @see [retrieve] */
        fun retrieve(
            params: OrderRequestRetrieveParams
        ): CompletableFuture<HttpResponseFor<OrderRequest>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        fun retrieve(
            params: OrderRequestRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrderRequest>>

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/order_requests`, but
         * is otherwise the same as [OrderRequestServiceAsync.list].
         */
        fun list(accountId: String): CompletableFuture<HttpResponseFor<List<OrderRequest>>> =
            list(accountId, OrderRequestListParams.none())

        /** @see [list] */
        fun list(
            accountId: String,
            params: OrderRequestListParams = OrderRequestListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<OrderRequest>>> =
            list(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [list] */
        fun list(
            accountId: String,
            params: OrderRequestListParams = OrderRequestListParams.none(),
        ): CompletableFuture<HttpResponseFor<List<OrderRequest>>> =
            list(accountId, params, RequestOptions.none())

        /** @see [list] */
        fun list(
            params: OrderRequestListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<OrderRequest>>>

        /** @see [list] */
        fun list(
            params: OrderRequestListParams
        ): CompletableFuture<HttpResponseFor<List<OrderRequest>>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        fun list(
            accountId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<OrderRequest>>> =
            list(accountId, OrderRequestListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post
         * /api/v2/accounts/{account_id}/order_requests/limit_buy`, but is otherwise the same as
         * [OrderRequestServiceAsync.createLimitBuy].
         */
        fun createLimitBuy(
            accountId: String,
            params: OrderRequestCreateLimitBuyParams,
        ): CompletableFuture<HttpResponseFor<OrderRequest>> =
            createLimitBuy(accountId, params, RequestOptions.none())

        /** @see [createLimitBuy] */
        fun createLimitBuy(
            accountId: String,
            params: OrderRequestCreateLimitBuyParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrderRequest>> =
            createLimitBuy(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [createLimitBuy] */
        fun createLimitBuy(
            params: OrderRequestCreateLimitBuyParams
        ): CompletableFuture<HttpResponseFor<OrderRequest>> =
            createLimitBuy(params, RequestOptions.none())

        /** @see [createLimitBuy] */
        fun createLimitBuy(
            params: OrderRequestCreateLimitBuyParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrderRequest>>

        /**
         * Returns a raw HTTP response for `post
         * /api/v2/accounts/{account_id}/order_requests/limit_sell`, but is otherwise the same as
         * [OrderRequestServiceAsync.createLimitSell].
         */
        fun createLimitSell(
            accountId: String,
            params: OrderRequestCreateLimitSellParams,
        ): CompletableFuture<HttpResponseFor<OrderRequest>> =
            createLimitSell(accountId, params, RequestOptions.none())

        /** @see [createLimitSell] */
        fun createLimitSell(
            accountId: String,
            params: OrderRequestCreateLimitSellParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrderRequest>> =
            createLimitSell(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [createLimitSell] */
        fun createLimitSell(
            params: OrderRequestCreateLimitSellParams
        ): CompletableFuture<HttpResponseFor<OrderRequest>> =
            createLimitSell(params, RequestOptions.none())

        /** @see [createLimitSell] */
        fun createLimitSell(
            params: OrderRequestCreateLimitSellParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrderRequest>>

        /**
         * Returns a raw HTTP response for `post
         * /api/v2/accounts/{account_id}/order_requests/market_buy`, but is otherwise the same as
         * [OrderRequestServiceAsync.createMarketBuy].
         */
        fun createMarketBuy(
            accountId: String,
            params: OrderRequestCreateMarketBuyParams,
        ): CompletableFuture<HttpResponseFor<OrderRequest>> =
            createMarketBuy(accountId, params, RequestOptions.none())

        /** @see [createMarketBuy] */
        fun createMarketBuy(
            accountId: String,
            params: OrderRequestCreateMarketBuyParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrderRequest>> =
            createMarketBuy(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [createMarketBuy] */
        fun createMarketBuy(
            params: OrderRequestCreateMarketBuyParams
        ): CompletableFuture<HttpResponseFor<OrderRequest>> =
            createMarketBuy(params, RequestOptions.none())

        /** @see [createMarketBuy] */
        fun createMarketBuy(
            params: OrderRequestCreateMarketBuyParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrderRequest>>

        /**
         * Returns a raw HTTP response for `post
         * /api/v2/accounts/{account_id}/order_requests/market_sell`, but is otherwise the same as
         * [OrderRequestServiceAsync.createMarketSell].
         */
        fun createMarketSell(
            accountId: String,
            params: OrderRequestCreateMarketSellParams,
        ): CompletableFuture<HttpResponseFor<OrderRequest>> =
            createMarketSell(accountId, params, RequestOptions.none())

        /** @see [createMarketSell] */
        fun createMarketSell(
            accountId: String,
            params: OrderRequestCreateMarketSellParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrderRequest>> =
            createMarketSell(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [createMarketSell] */
        fun createMarketSell(
            params: OrderRequestCreateMarketSellParams
        ): CompletableFuture<HttpResponseFor<OrderRequest>> =
            createMarketSell(params, RequestOptions.none())

        /** @see [createMarketSell] */
        fun createMarketSell(
            params: OrderRequestCreateMarketSellParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrderRequest>>
    }
}
