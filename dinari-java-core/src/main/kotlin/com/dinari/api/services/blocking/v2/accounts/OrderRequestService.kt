// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.accounts

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequest
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestCreateLimitBuyParams
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestCreateLimitSellParams
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestCreateMarketBuyParams
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestCreateMarketSellParams
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestGetFeeQuoteParams
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestGetFeeQuoteResponse
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestListParams
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestRetrieveParams
import com.dinari.api.services.blocking.v2.accounts.orderrequests.StockService
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface OrderRequestService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): OrderRequestService

    fun stocks(): StockService

    /** Get a specific `OrderRequest` by its ID. */
    fun retrieve(orderRequestId: String, params: OrderRequestRetrieveParams): OrderRequest =
        retrieve(orderRequestId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        orderRequestId: String,
        params: OrderRequestRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrderRequest =
        retrieve(params.toBuilder().orderRequestId(orderRequestId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: OrderRequestRetrieveParams): OrderRequest =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: OrderRequestRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrderRequest

    /** Lists `OrderRequests`. */
    fun list(accountId: String): List<OrderRequest> = list(accountId, OrderRequestListParams.none())

    /** @see list */
    fun list(
        accountId: String,
        params: OrderRequestListParams = OrderRequestListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<OrderRequest> = list(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see list */
    fun list(
        accountId: String,
        params: OrderRequestListParams = OrderRequestListParams.none(),
    ): List<OrderRequest> = list(accountId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: OrderRequestListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<OrderRequest>

    /** @see list */
    fun list(params: OrderRequestListParams): List<OrderRequest> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(accountId: String, requestOptions: RequestOptions): List<OrderRequest> =
        list(accountId, OrderRequestListParams.none(), requestOptions)

    /** Create a managed `OrderRequest` to place a limit buy `Order`. */
    fun createLimitBuy(accountId: String, params: OrderRequestCreateLimitBuyParams): OrderRequest =
        createLimitBuy(accountId, params, RequestOptions.none())

    /** @see createLimitBuy */
    fun createLimitBuy(
        accountId: String,
        params: OrderRequestCreateLimitBuyParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrderRequest =
        createLimitBuy(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see createLimitBuy */
    fun createLimitBuy(params: OrderRequestCreateLimitBuyParams): OrderRequest =
        createLimitBuy(params, RequestOptions.none())

    /** @see createLimitBuy */
    fun createLimitBuy(
        params: OrderRequestCreateLimitBuyParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrderRequest

    /** Create a managed `OrderRequest` to place a limit sell `Order`. */
    fun createLimitSell(
        accountId: String,
        params: OrderRequestCreateLimitSellParams,
    ): OrderRequest = createLimitSell(accountId, params, RequestOptions.none())

    /** @see createLimitSell */
    fun createLimitSell(
        accountId: String,
        params: OrderRequestCreateLimitSellParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrderRequest =
        createLimitSell(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see createLimitSell */
    fun createLimitSell(params: OrderRequestCreateLimitSellParams): OrderRequest =
        createLimitSell(params, RequestOptions.none())

    /** @see createLimitSell */
    fun createLimitSell(
        params: OrderRequestCreateLimitSellParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrderRequest

    /**
     * Create a managed `OrderRequest` to place a market buy `Order`. Fees for the `Order` are
     * included in the transaction. Refer to our
     * [Fee Quote API](https://docs.dinari.com/reference/createproxiedorderfeequote#/) for fee
     * estimation.
     */
    fun createMarketBuy(
        accountId: String,
        params: OrderRequestCreateMarketBuyParams,
    ): OrderRequest = createMarketBuy(accountId, params, RequestOptions.none())

    /** @see createMarketBuy */
    fun createMarketBuy(
        accountId: String,
        params: OrderRequestCreateMarketBuyParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrderRequest =
        createMarketBuy(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see createMarketBuy */
    fun createMarketBuy(params: OrderRequestCreateMarketBuyParams): OrderRequest =
        createMarketBuy(params, RequestOptions.none())

    /** @see createMarketBuy */
    fun createMarketBuy(
        params: OrderRequestCreateMarketBuyParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrderRequest

    /** Create a managed `OrderRequest` to place a market sell `Order`. */
    fun createMarketSell(
        accountId: String,
        params: OrderRequestCreateMarketSellParams,
    ): OrderRequest = createMarketSell(accountId, params, RequestOptions.none())

    /** @see createMarketSell */
    fun createMarketSell(
        accountId: String,
        params: OrderRequestCreateMarketSellParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrderRequest =
        createMarketSell(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see createMarketSell */
    fun createMarketSell(params: OrderRequestCreateMarketSellParams): OrderRequest =
        createMarketSell(params, RequestOptions.none())

    /** @see createMarketSell */
    fun createMarketSell(
        params: OrderRequestCreateMarketSellParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrderRequest

    /**
     * Get fee quote data for an `Order Request`. This is provided primarily for informational
     * purposes.
     */
    fun getFeeQuote(
        accountId: String,
        params: OrderRequestGetFeeQuoteParams,
    ): OrderRequestGetFeeQuoteResponse = getFeeQuote(accountId, params, RequestOptions.none())

    /** @see getFeeQuote */
    fun getFeeQuote(
        accountId: String,
        params: OrderRequestGetFeeQuoteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrderRequestGetFeeQuoteResponse =
        getFeeQuote(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see getFeeQuote */
    fun getFeeQuote(params: OrderRequestGetFeeQuoteParams): OrderRequestGetFeeQuoteResponse =
        getFeeQuote(params, RequestOptions.none())

    /** @see getFeeQuote */
    fun getFeeQuote(
        params: OrderRequestGetFeeQuoteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrderRequestGetFeeQuoteResponse

    /**
     * A view of [OrderRequestService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): OrderRequestService.WithRawResponse

        fun stocks(): StockService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get
         * /api/v2/accounts/{account_id}/order_requests/{order_request_id}`, but is otherwise the
         * same as [OrderRequestService.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            orderRequestId: String,
            params: OrderRequestRetrieveParams,
        ): HttpResponseFor<OrderRequest> = retrieve(orderRequestId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            orderRequestId: String,
            params: OrderRequestRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrderRequest> =
            retrieve(params.toBuilder().orderRequestId(orderRequestId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: OrderRequestRetrieveParams): HttpResponseFor<OrderRequest> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
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

        /** @see list */
        @MustBeClosed
        fun list(
            accountId: String,
            params: OrderRequestListParams = OrderRequestListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<OrderRequest>> =
            list(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            accountId: String,
            params: OrderRequestListParams = OrderRequestListParams.none(),
        ): HttpResponseFor<List<OrderRequest>> = list(accountId, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: OrderRequestListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<OrderRequest>>

        /** @see list */
        @MustBeClosed
        fun list(params: OrderRequestListParams): HttpResponseFor<List<OrderRequest>> =
            list(params, RequestOptions.none())

        /** @see list */
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

        /** @see createLimitBuy */
        @MustBeClosed
        fun createLimitBuy(
            accountId: String,
            params: OrderRequestCreateLimitBuyParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrderRequest> =
            createLimitBuy(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see createLimitBuy */
        @MustBeClosed
        fun createLimitBuy(
            params: OrderRequestCreateLimitBuyParams
        ): HttpResponseFor<OrderRequest> = createLimitBuy(params, RequestOptions.none())

        /** @see createLimitBuy */
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

        /** @see createLimitSell */
        @MustBeClosed
        fun createLimitSell(
            accountId: String,
            params: OrderRequestCreateLimitSellParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrderRequest> =
            createLimitSell(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see createLimitSell */
        @MustBeClosed
        fun createLimitSell(
            params: OrderRequestCreateLimitSellParams
        ): HttpResponseFor<OrderRequest> = createLimitSell(params, RequestOptions.none())

        /** @see createLimitSell */
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

        /** @see createMarketBuy */
        @MustBeClosed
        fun createMarketBuy(
            accountId: String,
            params: OrderRequestCreateMarketBuyParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrderRequest> =
            createMarketBuy(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see createMarketBuy */
        @MustBeClosed
        fun createMarketBuy(
            params: OrderRequestCreateMarketBuyParams
        ): HttpResponseFor<OrderRequest> = createMarketBuy(params, RequestOptions.none())

        /** @see createMarketBuy */
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

        /** @see createMarketSell */
        @MustBeClosed
        fun createMarketSell(
            accountId: String,
            params: OrderRequestCreateMarketSellParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrderRequest> =
            createMarketSell(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see createMarketSell */
        @MustBeClosed
        fun createMarketSell(
            params: OrderRequestCreateMarketSellParams
        ): HttpResponseFor<OrderRequest> = createMarketSell(params, RequestOptions.none())

        /** @see createMarketSell */
        @MustBeClosed
        fun createMarketSell(
            params: OrderRequestCreateMarketSellParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrderRequest>

        /**
         * Returns a raw HTTP response for `post
         * /api/v2/accounts/{account_id}/order_requests/fee_quote`, but is otherwise the same as
         * [OrderRequestService.getFeeQuote].
         */
        @MustBeClosed
        fun getFeeQuote(
            accountId: String,
            params: OrderRequestGetFeeQuoteParams,
        ): HttpResponseFor<OrderRequestGetFeeQuoteResponse> =
            getFeeQuote(accountId, params, RequestOptions.none())

        /** @see getFeeQuote */
        @MustBeClosed
        fun getFeeQuote(
            accountId: String,
            params: OrderRequestGetFeeQuoteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrderRequestGetFeeQuoteResponse> =
            getFeeQuote(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see getFeeQuote */
        @MustBeClosed
        fun getFeeQuote(
            params: OrderRequestGetFeeQuoteParams
        ): HttpResponseFor<OrderRequestGetFeeQuoteResponse> =
            getFeeQuote(params, RequestOptions.none())

        /** @see getFeeQuote */
        @MustBeClosed
        fun getFeeQuote(
            params: OrderRequestGetFeeQuoteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrderRequestGetFeeQuoteResponse>
    }
}
