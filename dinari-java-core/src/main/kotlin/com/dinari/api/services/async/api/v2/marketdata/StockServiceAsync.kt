// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.api.v2.marketdata

import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.api.v2.marketdata.stocks.StockListParams
import com.dinari.api.models.api.v2.marketdata.stocks.StockListResponse
import com.dinari.api.models.api.v2.marketdata.stocks.StockRetrieveDividendsParams
import com.dinari.api.models.api.v2.marketdata.stocks.StockRetrieveDividendsResponse
import com.dinari.api.models.api.v2.marketdata.stocks.StockRetrieveHistoricalPricesParams
import com.dinari.api.models.api.v2.marketdata.stocks.StockRetrieveHistoricalPricesResponse
import com.dinari.api.models.api.v2.marketdata.stocks.StockRetrieveNewsParams
import com.dinari.api.models.api.v2.marketdata.stocks.StockRetrieveNewsResponse
import com.dinari.api.models.api.v2.marketdata.stocks.StockRetrieveQuoteParams
import com.dinari.api.models.api.v2.marketdata.stocks.StockRetrieveQuoteResponse
import com.dinari.api.services.async.api.v2.marketdata.stocks.SplitServiceAsync
import com.google.errorprone.annotations.MustBeClosed
import java.util.concurrent.CompletableFuture

interface StockServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun splits(): SplitServiceAsync

    /** Returns a list of stocks available for trading. */
    fun list(): CompletableFuture<List<StockListResponse>> = list(StockListParams.none())

    /** @see [list] */
    fun list(
        params: StockListParams = StockListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<StockListResponse>>

    /** @see [list] */
    fun list(
        params: StockListParams = StockListParams.none()
    ): CompletableFuture<List<StockListResponse>> = list(params, RequestOptions.none())

    /** @see [list] */
    fun list(requestOptions: RequestOptions): CompletableFuture<List<StockListResponse>> =
        list(StockListParams.none(), requestOptions)

    /**
     * Returns a list of announced stock dividend details for a specified stock. Note that this data
     * applies only to actual stocks. Yield received for holding dShares may differ from this.
     */
    fun retrieveDividends(
        params: StockRetrieveDividendsParams
    ): CompletableFuture<List<StockRetrieveDividendsResponse>> =
        retrieveDividends(params, RequestOptions.none())

    /** @see [retrieveDividends] */
    fun retrieveDividends(
        params: StockRetrieveDividendsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<StockRetrieveDividendsResponse>>

    /**
     * Returns a list of historical prices for a specified stock. Each index in the array represents
     * a single tick in a price chart.
     */
    fun retrieveHistoricalPrices(
        params: StockRetrieveHistoricalPricesParams
    ): CompletableFuture<List<StockRetrieveHistoricalPricesResponse>> =
        retrieveHistoricalPrices(params, RequestOptions.none())

    /** @see [retrieveHistoricalPrices] */
    fun retrieveHistoricalPrices(
        params: StockRetrieveHistoricalPricesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<StockRetrieveHistoricalPricesResponse>>

    /**
     * Get the most recent news articles relating to a stock, including a summary of the article and
     * a link to the original source
     */
    fun retrieveNews(
        params: StockRetrieveNewsParams
    ): CompletableFuture<List<StockRetrieveNewsResponse>> =
        retrieveNews(params, RequestOptions.none())

    /** @see [retrieveNews] */
    fun retrieveNews(
        params: StockRetrieveNewsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<StockRetrieveNewsResponse>>

    /** Returns a stock quote for a specified stock. */
    fun retrieveQuote(
        params: StockRetrieveQuoteParams
    ): CompletableFuture<StockRetrieveQuoteResponse> = retrieveQuote(params, RequestOptions.none())

    /** @see [retrieveQuote] */
    fun retrieveQuote(
        params: StockRetrieveQuoteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<StockRetrieveQuoteResponse>

    /** A view of [StockServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun splits(): SplitServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v2/market_data/stocks/`, but is otherwise the
         * same as [StockServiceAsync.list].
         */
        @MustBeClosed
        fun list(): CompletableFuture<HttpResponseFor<List<StockListResponse>>> =
            list(StockListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: StockListParams = StockListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<StockListResponse>>>

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: StockListParams = StockListParams.none()
        ): CompletableFuture<HttpResponseFor<List<StockListResponse>>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<List<StockListResponse>>> =
            list(StockListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v2/market_data/stocks/{stock_id}/dividends`,
         * but is otherwise the same as [StockServiceAsync.retrieveDividends].
         */
        @MustBeClosed
        fun retrieveDividends(
            params: StockRetrieveDividendsParams
        ): CompletableFuture<HttpResponseFor<List<StockRetrieveDividendsResponse>>> =
            retrieveDividends(params, RequestOptions.none())

        /** @see [retrieveDividends] */
        @MustBeClosed
        fun retrieveDividends(
            params: StockRetrieveDividendsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<StockRetrieveDividendsResponse>>>

        /**
         * Returns a raw HTTP response for `get
         * /api/v2/market_data/stocks/{stock_id}/historical_prices/`, but is otherwise the same as
         * [StockServiceAsync.retrieveHistoricalPrices].
         */
        @MustBeClosed
        fun retrieveHistoricalPrices(
            params: StockRetrieveHistoricalPricesParams
        ): CompletableFuture<HttpResponseFor<List<StockRetrieveHistoricalPricesResponse>>> =
            retrieveHistoricalPrices(params, RequestOptions.none())

        /** @see [retrieveHistoricalPrices] */
        @MustBeClosed
        fun retrieveHistoricalPrices(
            params: StockRetrieveHistoricalPricesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<StockRetrieveHistoricalPricesResponse>>>

        /**
         * Returns a raw HTTP response for `get /api/v2/market_data/stocks/{stock_id}/news`, but is
         * otherwise the same as [StockServiceAsync.retrieveNews].
         */
        @MustBeClosed
        fun retrieveNews(
            params: StockRetrieveNewsParams
        ): CompletableFuture<HttpResponseFor<List<StockRetrieveNewsResponse>>> =
            retrieveNews(params, RequestOptions.none())

        /** @see [retrieveNews] */
        @MustBeClosed
        fun retrieveNews(
            params: StockRetrieveNewsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<StockRetrieveNewsResponse>>>

        /**
         * Returns a raw HTTP response for `get /api/v2/market_data/stocks/{stock_id}/quote`, but is
         * otherwise the same as [StockServiceAsync.retrieveQuote].
         */
        @MustBeClosed
        fun retrieveQuote(
            params: StockRetrieveQuoteParams
        ): CompletableFuture<HttpResponseFor<StockRetrieveQuoteResponse>> =
            retrieveQuote(params, RequestOptions.none())

        /** @see [retrieveQuote] */
        @MustBeClosed
        fun retrieveQuote(
            params: StockRetrieveQuoteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StockRetrieveQuoteResponse>>
    }
}
