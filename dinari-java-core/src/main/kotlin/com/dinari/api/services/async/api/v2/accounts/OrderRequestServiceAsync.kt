// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.api.v2.accounts

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
import java.util.concurrent.CompletableFuture

interface OrderRequestServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Retrieves details of a specific managed order request by its ID. */
    fun retrieve(
        requestId: String,
        params: OrderRequestRetrieveParams,
    ): CompletableFuture<OrderRequest> = retrieve(requestId, params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        requestId: String,
        params: OrderRequestRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrderRequest> =
        retrieve(params.toBuilder().requestId(requestId).build(), requestOptions)

    /** @see [retrieve] */
    fun retrieve(params: OrderRequestRetrieveParams): CompletableFuture<OrderRequest> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: OrderRequestRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrderRequest>

    /** Lists managed order requests. */
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

    /** Creates a managed limit buy request. */
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

    /** Creates a managed limit sell request. */
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

    /** Creates a managed market buy request. */
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

    /** Creates a managed market sell request. */
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
         * /api/v2/accounts/{account_id}/order_requests/{request_id}`, but is otherwise the same as
         * [OrderRequestServiceAsync.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            requestId: String,
            params: OrderRequestRetrieveParams,
        ): CompletableFuture<HttpResponseFor<OrderRequest>> =
            retrieve(requestId, params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            requestId: String,
            params: OrderRequestRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrderRequest>> =
            retrieve(params.toBuilder().requestId(requestId).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: OrderRequestRetrieveParams
        ): CompletableFuture<HttpResponseFor<OrderRequest>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: OrderRequestRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrderRequest>>

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/order_requests`, but
         * is otherwise the same as [OrderRequestServiceAsync.list].
         */
        @MustBeClosed
        fun list(accountId: String): CompletableFuture<HttpResponseFor<List<OrderRequest>>> =
            list(accountId, OrderRequestListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            accountId: String,
            params: OrderRequestListParams = OrderRequestListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<OrderRequest>>> =
            list(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [list] */
        @MustBeClosed
        fun list(
            accountId: String,
            params: OrderRequestListParams = OrderRequestListParams.none(),
        ): CompletableFuture<HttpResponseFor<List<OrderRequest>>> =
            list(accountId, params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: OrderRequestListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<OrderRequest>>>

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: OrderRequestListParams
        ): CompletableFuture<HttpResponseFor<List<OrderRequest>>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
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
        @MustBeClosed
        fun createLimitBuy(
            accountId: String,
            params: OrderRequestCreateLimitBuyParams,
        ): CompletableFuture<HttpResponseFor<OrderRequest>> =
            createLimitBuy(accountId, params, RequestOptions.none())

        /** @see [createLimitBuy] */
        @MustBeClosed
        fun createLimitBuy(
            accountId: String,
            params: OrderRequestCreateLimitBuyParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrderRequest>> =
            createLimitBuy(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [createLimitBuy] */
        @MustBeClosed
        fun createLimitBuy(
            params: OrderRequestCreateLimitBuyParams
        ): CompletableFuture<HttpResponseFor<OrderRequest>> =
            createLimitBuy(params, RequestOptions.none())

        /** @see [createLimitBuy] */
        @MustBeClosed
        fun createLimitBuy(
            params: OrderRequestCreateLimitBuyParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrderRequest>>

        /**
         * Returns a raw HTTP response for `post
         * /api/v2/accounts/{account_id}/order_requests/limit_sell`, but is otherwise the same as
         * [OrderRequestServiceAsync.createLimitSell].
         */
        @MustBeClosed
        fun createLimitSell(
            accountId: String,
            params: OrderRequestCreateLimitSellParams,
        ): CompletableFuture<HttpResponseFor<OrderRequest>> =
            createLimitSell(accountId, params, RequestOptions.none())

        /** @see [createLimitSell] */
        @MustBeClosed
        fun createLimitSell(
            accountId: String,
            params: OrderRequestCreateLimitSellParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrderRequest>> =
            createLimitSell(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [createLimitSell] */
        @MustBeClosed
        fun createLimitSell(
            params: OrderRequestCreateLimitSellParams
        ): CompletableFuture<HttpResponseFor<OrderRequest>> =
            createLimitSell(params, RequestOptions.none())

        /** @see [createLimitSell] */
        @MustBeClosed
        fun createLimitSell(
            params: OrderRequestCreateLimitSellParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrderRequest>>

        /**
         * Returns a raw HTTP response for `post
         * /api/v2/accounts/{account_id}/order_requests/market_buy`, but is otherwise the same as
         * [OrderRequestServiceAsync.createMarketBuy].
         */
        @MustBeClosed
        fun createMarketBuy(
            accountId: String,
            params: OrderRequestCreateMarketBuyParams,
        ): CompletableFuture<HttpResponseFor<OrderRequest>> =
            createMarketBuy(accountId, params, RequestOptions.none())

        /** @see [createMarketBuy] */
        @MustBeClosed
        fun createMarketBuy(
            accountId: String,
            params: OrderRequestCreateMarketBuyParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrderRequest>> =
            createMarketBuy(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [createMarketBuy] */
        @MustBeClosed
        fun createMarketBuy(
            params: OrderRequestCreateMarketBuyParams
        ): CompletableFuture<HttpResponseFor<OrderRequest>> =
            createMarketBuy(params, RequestOptions.none())

        /** @see [createMarketBuy] */
        @MustBeClosed
        fun createMarketBuy(
            params: OrderRequestCreateMarketBuyParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrderRequest>>

        /**
         * Returns a raw HTTP response for `post
         * /api/v2/accounts/{account_id}/order_requests/market_sell`, but is otherwise the same as
         * [OrderRequestServiceAsync.createMarketSell].
         */
        @MustBeClosed
        fun createMarketSell(
            accountId: String,
            params: OrderRequestCreateMarketSellParams,
        ): CompletableFuture<HttpResponseFor<OrderRequest>> =
            createMarketSell(accountId, params, RequestOptions.none())

        /** @see [createMarketSell] */
        @MustBeClosed
        fun createMarketSell(
            accountId: String,
            params: OrderRequestCreateMarketSellParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrderRequest>> =
            createMarketSell(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [createMarketSell] */
        @MustBeClosed
        fun createMarketSell(
            params: OrderRequestCreateMarketSellParams
        ): CompletableFuture<HttpResponseFor<OrderRequest>> =
            createMarketSell(params, RequestOptions.none())

        /** @see [createMarketSell] */
        @MustBeClosed
        fun createMarketSell(
            params: OrderRequestCreateMarketSellParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrderRequest>>
    }
}
