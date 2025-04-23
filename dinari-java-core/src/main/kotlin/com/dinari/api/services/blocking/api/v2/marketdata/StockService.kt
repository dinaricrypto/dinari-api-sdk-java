// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.api.v2.marketdata

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
import com.dinari.api.services.blocking.api.v2.marketdata.stocks.SplitService
import com.google.errorprone.annotations.MustBeClosed

interface StockService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun splits(): SplitService

    /** Returns a list of stocks available for trading. */
    fun list(): List<StockListResponse> = list(StockListParams.none())

    /** @see [list] */
    fun list(
        params: StockListParams = StockListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<StockListResponse>

    /** @see [list] */
    fun list(params: StockListParams = StockListParams.none()): List<StockListResponse> =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(requestOptions: RequestOptions): List<StockListResponse> =
        list(StockListParams.none(), requestOptions)

    /**
     * Returns a list of announced stock dividend details for a specified stock. Note that this data
     * applies only to actual stocks. Yield received for holding dShares may differ from this.
     */
    fun retrieveDividends(
        params: StockRetrieveDividendsParams
    ): List<StockRetrieveDividendsResponse> = retrieveDividends(params, RequestOptions.none())

    /** @see [retrieveDividends] */
    fun retrieveDividends(
        params: StockRetrieveDividendsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<StockRetrieveDividendsResponse>

    /**
     * Returns a list of historical prices for a specified stock. Each index in the array represents
     * a single tick in a price chart.
     */
    fun retrieveHistoricalPrices(
        params: StockRetrieveHistoricalPricesParams
    ): List<StockRetrieveHistoricalPricesResponse> =
        retrieveHistoricalPrices(params, RequestOptions.none())

    /** @see [retrieveHistoricalPrices] */
    fun retrieveHistoricalPrices(
        params: StockRetrieveHistoricalPricesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<StockRetrieveHistoricalPricesResponse>

    /**
     * Get the most recent news articles relating to a stock, including a summary of the article and
     * a link to the original source
     */
    fun retrieveNews(params: StockRetrieveNewsParams): List<StockRetrieveNewsResponse> =
        retrieveNews(params, RequestOptions.none())

    /** @see [retrieveNews] */
    fun retrieveNews(
        params: StockRetrieveNewsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<StockRetrieveNewsResponse>

    /** Returns a stock quote for a specified stock. */
    fun retrieveQuote(params: StockRetrieveQuoteParams): StockRetrieveQuoteResponse =
        retrieveQuote(params, RequestOptions.none())

    /** @see [retrieveQuote] */
    fun retrieveQuote(
        params: StockRetrieveQuoteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StockRetrieveQuoteResponse

    /** A view of [StockService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun splits(): SplitService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v2/market_data/stocks/`, but is otherwise the
         * same as [StockService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<List<StockListResponse>> = list(StockListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: StockListParams = StockListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<StockListResponse>>

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: StockListParams = StockListParams.none()
        ): HttpResponseFor<List<StockListResponse>> = list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<List<StockListResponse>> =
            list(StockListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v2/market_data/stocks/{stock_id}/dividends`,
         * but is otherwise the same as [StockService.retrieveDividends].
         */
        @MustBeClosed
        fun retrieveDividends(
            params: StockRetrieveDividendsParams
        ): HttpResponseFor<List<StockRetrieveDividendsResponse>> =
            retrieveDividends(params, RequestOptions.none())

        /** @see [retrieveDividends] */
        @MustBeClosed
        fun retrieveDividends(
            params: StockRetrieveDividendsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<StockRetrieveDividendsResponse>>

        /**
         * Returns a raw HTTP response for `get
         * /api/v2/market_data/stocks/{stock_id}/historical_prices/`, but is otherwise the same as
         * [StockService.retrieveHistoricalPrices].
         */
        @MustBeClosed
        fun retrieveHistoricalPrices(
            params: StockRetrieveHistoricalPricesParams
        ): HttpResponseFor<List<StockRetrieveHistoricalPricesResponse>> =
            retrieveHistoricalPrices(params, RequestOptions.none())

        /** @see [retrieveHistoricalPrices] */
        @MustBeClosed
        fun retrieveHistoricalPrices(
            params: StockRetrieveHistoricalPricesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<StockRetrieveHistoricalPricesResponse>>

        /**
         * Returns a raw HTTP response for `get /api/v2/market_data/stocks/{stock_id}/news`, but is
         * otherwise the same as [StockService.retrieveNews].
         */
        @MustBeClosed
        fun retrieveNews(
            params: StockRetrieveNewsParams
        ): HttpResponseFor<List<StockRetrieveNewsResponse>> =
            retrieveNews(params, RequestOptions.none())

        /** @see [retrieveNews] */
        @MustBeClosed
        fun retrieveNews(
            params: StockRetrieveNewsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<StockRetrieveNewsResponse>>

        /**
         * Returns a raw HTTP response for `get /api/v2/market_data/stocks/{stock_id}/quote`, but is
         * otherwise the same as [StockService.retrieveQuote].
         */
        @MustBeClosed
        fun retrieveQuote(
            params: StockRetrieveQuoteParams
        ): HttpResponseFor<StockRetrieveQuoteResponse> =
            retrieveQuote(params, RequestOptions.none())

        /** @see [retrieveQuote] */
        @MustBeClosed
        fun retrieveQuote(
            params: StockRetrieveQuoteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StockRetrieveQuoteResponse>
    }
}
