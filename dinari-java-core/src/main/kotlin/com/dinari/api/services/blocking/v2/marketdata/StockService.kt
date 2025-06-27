// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.marketdata

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.v2.marketdata.stocks.StockListParams
import com.dinari.api.models.v2.marketdata.stocks.StockListResponse
import com.dinari.api.models.v2.marketdata.stocks.StockRetrieveCurrentPriceParams
import com.dinari.api.models.v2.marketdata.stocks.StockRetrieveCurrentPriceResponse
import com.dinari.api.models.v2.marketdata.stocks.StockRetrieveCurrentQuoteParams
import com.dinari.api.models.v2.marketdata.stocks.StockRetrieveCurrentQuoteResponse
import com.dinari.api.models.v2.marketdata.stocks.StockRetrieveDividendsParams
import com.dinari.api.models.v2.marketdata.stocks.StockRetrieveDividendsResponse
import com.dinari.api.models.v2.marketdata.stocks.StockRetrieveHistoricalPricesParams
import com.dinari.api.models.v2.marketdata.stocks.StockRetrieveHistoricalPricesResponse
import com.dinari.api.models.v2.marketdata.stocks.StockRetrieveNewsParams
import com.dinari.api.models.v2.marketdata.stocks.StockRetrieveNewsResponse
import com.dinari.api.services.blocking.v2.marketdata.stocks.SplitService
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface StockService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): StockService

    fun splits(): SplitService

    /** Get a list of `Stocks`. */
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

    /** Get current price for a specified `Stock`. */
    fun retrieveCurrentPrice(stockId: String): StockRetrieveCurrentPriceResponse =
        retrieveCurrentPrice(stockId, StockRetrieveCurrentPriceParams.none())

    /** @see [retrieveCurrentPrice] */
    fun retrieveCurrentPrice(
        stockId: String,
        params: StockRetrieveCurrentPriceParams = StockRetrieveCurrentPriceParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StockRetrieveCurrentPriceResponse =
        retrieveCurrentPrice(params.toBuilder().stockId(stockId).build(), requestOptions)

    /** @see [retrieveCurrentPrice] */
    fun retrieveCurrentPrice(
        stockId: String,
        params: StockRetrieveCurrentPriceParams = StockRetrieveCurrentPriceParams.none(),
    ): StockRetrieveCurrentPriceResponse =
        retrieveCurrentPrice(stockId, params, RequestOptions.none())

    /** @see [retrieveCurrentPrice] */
    fun retrieveCurrentPrice(
        params: StockRetrieveCurrentPriceParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StockRetrieveCurrentPriceResponse

    /** @see [retrieveCurrentPrice] */
    fun retrieveCurrentPrice(
        params: StockRetrieveCurrentPriceParams
    ): StockRetrieveCurrentPriceResponse = retrieveCurrentPrice(params, RequestOptions.none())

    /** @see [retrieveCurrentPrice] */
    fun retrieveCurrentPrice(
        stockId: String,
        requestOptions: RequestOptions,
    ): StockRetrieveCurrentPriceResponse =
        retrieveCurrentPrice(stockId, StockRetrieveCurrentPriceParams.none(), requestOptions)

    /** Get quote for a specified `Stock`. */
    fun retrieveCurrentQuote(stockId: String): StockRetrieveCurrentQuoteResponse =
        retrieveCurrentQuote(stockId, StockRetrieveCurrentQuoteParams.none())

    /** @see [retrieveCurrentQuote] */
    fun retrieveCurrentQuote(
        stockId: String,
        params: StockRetrieveCurrentQuoteParams = StockRetrieveCurrentQuoteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StockRetrieveCurrentQuoteResponse =
        retrieveCurrentQuote(params.toBuilder().stockId(stockId).build(), requestOptions)

    /** @see [retrieveCurrentQuote] */
    fun retrieveCurrentQuote(
        stockId: String,
        params: StockRetrieveCurrentQuoteParams = StockRetrieveCurrentQuoteParams.none(),
    ): StockRetrieveCurrentQuoteResponse =
        retrieveCurrentQuote(stockId, params, RequestOptions.none())

    /** @see [retrieveCurrentQuote] */
    fun retrieveCurrentQuote(
        params: StockRetrieveCurrentQuoteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StockRetrieveCurrentQuoteResponse

    /** @see [retrieveCurrentQuote] */
    fun retrieveCurrentQuote(
        params: StockRetrieveCurrentQuoteParams
    ): StockRetrieveCurrentQuoteResponse = retrieveCurrentQuote(params, RequestOptions.none())

    /** @see [retrieveCurrentQuote] */
    fun retrieveCurrentQuote(
        stockId: String,
        requestOptions: RequestOptions,
    ): StockRetrieveCurrentQuoteResponse =
        retrieveCurrentQuote(stockId, StockRetrieveCurrentQuoteParams.none(), requestOptions)

    /**
     * Get a list of announced stock dividend details for a specified `Stock`.
     *
     * Note that this data applies only to actual stocks. Yield received for holding tokenized
     * shares may differ from this.
     */
    fun retrieveDividends(stockId: String): List<StockRetrieveDividendsResponse> =
        retrieveDividends(stockId, StockRetrieveDividendsParams.none())

    /** @see [retrieveDividends] */
    fun retrieveDividends(
        stockId: String,
        params: StockRetrieveDividendsParams = StockRetrieveDividendsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<StockRetrieveDividendsResponse> =
        retrieveDividends(params.toBuilder().stockId(stockId).build(), requestOptions)

    /** @see [retrieveDividends] */
    fun retrieveDividends(
        stockId: String,
        params: StockRetrieveDividendsParams = StockRetrieveDividendsParams.none(),
    ): List<StockRetrieveDividendsResponse> =
        retrieveDividends(stockId, params, RequestOptions.none())

    /** @see [retrieveDividends] */
    fun retrieveDividends(
        params: StockRetrieveDividendsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<StockRetrieveDividendsResponse>

    /** @see [retrieveDividends] */
    fun retrieveDividends(
        params: StockRetrieveDividendsParams
    ): List<StockRetrieveDividendsResponse> = retrieveDividends(params, RequestOptions.none())

    /** @see [retrieveDividends] */
    fun retrieveDividends(
        stockId: String,
        requestOptions: RequestOptions,
    ): List<StockRetrieveDividendsResponse> =
        retrieveDividends(stockId, StockRetrieveDividendsParams.none(), requestOptions)

    /**
     * Get historical price data for a specified `Stock`. Each index in the array represents a
     * single tick in a price chart.
     */
    fun retrieveHistoricalPrices(
        stockId: String,
        params: StockRetrieveHistoricalPricesParams,
    ): List<StockRetrieveHistoricalPricesResponse> =
        retrieveHistoricalPrices(stockId, params, RequestOptions.none())

    /** @see [retrieveHistoricalPrices] */
    fun retrieveHistoricalPrices(
        stockId: String,
        params: StockRetrieveHistoricalPricesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<StockRetrieveHistoricalPricesResponse> =
        retrieveHistoricalPrices(params.toBuilder().stockId(stockId).build(), requestOptions)

    /** @see [retrieveHistoricalPrices] */
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
     * Get the most recent news articles relating to a `Stock`, including a summary of the article
     * and a link to the original source.
     */
    fun retrieveNews(stockId: String): List<StockRetrieveNewsResponse> =
        retrieveNews(stockId, StockRetrieveNewsParams.none())

    /** @see [retrieveNews] */
    fun retrieveNews(
        stockId: String,
        params: StockRetrieveNewsParams = StockRetrieveNewsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<StockRetrieveNewsResponse> =
        retrieveNews(params.toBuilder().stockId(stockId).build(), requestOptions)

    /** @see [retrieveNews] */
    fun retrieveNews(
        stockId: String,
        params: StockRetrieveNewsParams = StockRetrieveNewsParams.none(),
    ): List<StockRetrieveNewsResponse> = retrieveNews(stockId, params, RequestOptions.none())

    /** @see [retrieveNews] */
    fun retrieveNews(
        params: StockRetrieveNewsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<StockRetrieveNewsResponse>

    /** @see [retrieveNews] */
    fun retrieveNews(params: StockRetrieveNewsParams): List<StockRetrieveNewsResponse> =
        retrieveNews(params, RequestOptions.none())

    /** @see [retrieveNews] */
    fun retrieveNews(
        stockId: String,
        requestOptions: RequestOptions,
    ): List<StockRetrieveNewsResponse> =
        retrieveNews(stockId, StockRetrieveNewsParams.none(), requestOptions)

    /** A view of [StockService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): StockService.WithRawResponse

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
         * Returns a raw HTTP response for `get
         * /api/v2/market_data/stocks/{stock_id}/current_price`, but is otherwise the same as
         * [StockService.retrieveCurrentPrice].
         */
        @MustBeClosed
        fun retrieveCurrentPrice(
            stockId: String
        ): HttpResponseFor<StockRetrieveCurrentPriceResponse> =
            retrieveCurrentPrice(stockId, StockRetrieveCurrentPriceParams.none())

        /** @see [retrieveCurrentPrice] */
        @MustBeClosed
        fun retrieveCurrentPrice(
            stockId: String,
            params: StockRetrieveCurrentPriceParams = StockRetrieveCurrentPriceParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StockRetrieveCurrentPriceResponse> =
            retrieveCurrentPrice(params.toBuilder().stockId(stockId).build(), requestOptions)

        /** @see [retrieveCurrentPrice] */
        @MustBeClosed
        fun retrieveCurrentPrice(
            stockId: String,
            params: StockRetrieveCurrentPriceParams = StockRetrieveCurrentPriceParams.none(),
        ): HttpResponseFor<StockRetrieveCurrentPriceResponse> =
            retrieveCurrentPrice(stockId, params, RequestOptions.none())

        /** @see [retrieveCurrentPrice] */
        @MustBeClosed
        fun retrieveCurrentPrice(
            params: StockRetrieveCurrentPriceParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StockRetrieveCurrentPriceResponse>

        /** @see [retrieveCurrentPrice] */
        @MustBeClosed
        fun retrieveCurrentPrice(
            params: StockRetrieveCurrentPriceParams
        ): HttpResponseFor<StockRetrieveCurrentPriceResponse> =
            retrieveCurrentPrice(params, RequestOptions.none())

        /** @see [retrieveCurrentPrice] */
        @MustBeClosed
        fun retrieveCurrentPrice(
            stockId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<StockRetrieveCurrentPriceResponse> =
            retrieveCurrentPrice(stockId, StockRetrieveCurrentPriceParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get
         * /api/v2/market_data/stocks/{stock_id}/current_quote`, but is otherwise the same as
         * [StockService.retrieveCurrentQuote].
         */
        @MustBeClosed
        fun retrieveCurrentQuote(
            stockId: String
        ): HttpResponseFor<StockRetrieveCurrentQuoteResponse> =
            retrieveCurrentQuote(stockId, StockRetrieveCurrentQuoteParams.none())

        /** @see [retrieveCurrentQuote] */
        @MustBeClosed
        fun retrieveCurrentQuote(
            stockId: String,
            params: StockRetrieveCurrentQuoteParams = StockRetrieveCurrentQuoteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StockRetrieveCurrentQuoteResponse> =
            retrieveCurrentQuote(params.toBuilder().stockId(stockId).build(), requestOptions)

        /** @see [retrieveCurrentQuote] */
        @MustBeClosed
        fun retrieveCurrentQuote(
            stockId: String,
            params: StockRetrieveCurrentQuoteParams = StockRetrieveCurrentQuoteParams.none(),
        ): HttpResponseFor<StockRetrieveCurrentQuoteResponse> =
            retrieveCurrentQuote(stockId, params, RequestOptions.none())

        /** @see [retrieveCurrentQuote] */
        @MustBeClosed
        fun retrieveCurrentQuote(
            params: StockRetrieveCurrentQuoteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StockRetrieveCurrentQuoteResponse>

        /** @see [retrieveCurrentQuote] */
        @MustBeClosed
        fun retrieveCurrentQuote(
            params: StockRetrieveCurrentQuoteParams
        ): HttpResponseFor<StockRetrieveCurrentQuoteResponse> =
            retrieveCurrentQuote(params, RequestOptions.none())

        /** @see [retrieveCurrentQuote] */
        @MustBeClosed
        fun retrieveCurrentQuote(
            stockId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<StockRetrieveCurrentQuoteResponse> =
            retrieveCurrentQuote(stockId, StockRetrieveCurrentQuoteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v2/market_data/stocks/{stock_id}/dividends`,
         * but is otherwise the same as [StockService.retrieveDividends].
         */
        @MustBeClosed
        fun retrieveDividends(
            stockId: String
        ): HttpResponseFor<List<StockRetrieveDividendsResponse>> =
            retrieveDividends(stockId, StockRetrieveDividendsParams.none())

        /** @see [retrieveDividends] */
        @MustBeClosed
        fun retrieveDividends(
            stockId: String,
            params: StockRetrieveDividendsParams = StockRetrieveDividendsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<StockRetrieveDividendsResponse>> =
            retrieveDividends(params.toBuilder().stockId(stockId).build(), requestOptions)

        /** @see [retrieveDividends] */
        @MustBeClosed
        fun retrieveDividends(
            stockId: String,
            params: StockRetrieveDividendsParams = StockRetrieveDividendsParams.none(),
        ): HttpResponseFor<List<StockRetrieveDividendsResponse>> =
            retrieveDividends(stockId, params, RequestOptions.none())

        /** @see [retrieveDividends] */
        @MustBeClosed
        fun retrieveDividends(
            params: StockRetrieveDividendsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<StockRetrieveDividendsResponse>>

        /** @see [retrieveDividends] */
        @MustBeClosed
        fun retrieveDividends(
            params: StockRetrieveDividendsParams
        ): HttpResponseFor<List<StockRetrieveDividendsResponse>> =
            retrieveDividends(params, RequestOptions.none())

        /** @see [retrieveDividends] */
        @MustBeClosed
        fun retrieveDividends(
            stockId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<StockRetrieveDividendsResponse>> =
            retrieveDividends(stockId, StockRetrieveDividendsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get
         * /api/v2/market_data/stocks/{stock_id}/historical_prices/`, but is otherwise the same as
         * [StockService.retrieveHistoricalPrices].
         */
        @MustBeClosed
        fun retrieveHistoricalPrices(
            stockId: String,
            params: StockRetrieveHistoricalPricesParams,
        ): HttpResponseFor<List<StockRetrieveHistoricalPricesResponse>> =
            retrieveHistoricalPrices(stockId, params, RequestOptions.none())

        /** @see [retrieveHistoricalPrices] */
        @MustBeClosed
        fun retrieveHistoricalPrices(
            stockId: String,
            params: StockRetrieveHistoricalPricesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<StockRetrieveHistoricalPricesResponse>> =
            retrieveHistoricalPrices(params.toBuilder().stockId(stockId).build(), requestOptions)

        /** @see [retrieveHistoricalPrices] */
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
        fun retrieveNews(stockId: String): HttpResponseFor<List<StockRetrieveNewsResponse>> =
            retrieveNews(stockId, StockRetrieveNewsParams.none())

        /** @see [retrieveNews] */
        @MustBeClosed
        fun retrieveNews(
            stockId: String,
            params: StockRetrieveNewsParams = StockRetrieveNewsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<StockRetrieveNewsResponse>> =
            retrieveNews(params.toBuilder().stockId(stockId).build(), requestOptions)

        /** @see [retrieveNews] */
        @MustBeClosed
        fun retrieveNews(
            stockId: String,
            params: StockRetrieveNewsParams = StockRetrieveNewsParams.none(),
        ): HttpResponseFor<List<StockRetrieveNewsResponse>> =
            retrieveNews(stockId, params, RequestOptions.none())

        /** @see [retrieveNews] */
        @MustBeClosed
        fun retrieveNews(
            params: StockRetrieveNewsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<StockRetrieveNewsResponse>>

        /** @see [retrieveNews] */
        @MustBeClosed
        fun retrieveNews(
            params: StockRetrieveNewsParams
        ): HttpResponseFor<List<StockRetrieveNewsResponse>> =
            retrieveNews(params, RequestOptions.none())

        /** @see [retrieveNews] */
        @MustBeClosed
        fun retrieveNews(
            stockId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<StockRetrieveNewsResponse>> =
            retrieveNews(stockId, StockRetrieveNewsParams.none(), requestOptions)
    }
}
