// File generated from our OpenAPI spec by Stainless.

package com.dinari.services.async.v2.marketdata

import com.dinari.core.ClientOptions
import com.dinari.core.RequestOptions
import com.dinari.core.http.HttpResponseFor
import com.dinari.models.v2.marketdata.stocks.StockListParams
import com.dinari.models.v2.marketdata.stocks.StockListResponse
import com.dinari.models.v2.marketdata.stocks.StockRetrieveDividendsParams
import com.dinari.models.v2.marketdata.stocks.StockRetrieveDividendsResponse
import com.dinari.models.v2.marketdata.stocks.StockRetrieveHistoricalPricesParams
import com.dinari.models.v2.marketdata.stocks.StockRetrieveHistoricalPricesResponse
import com.dinari.models.v2.marketdata.stocks.StockRetrieveNewsParams
import com.dinari.models.v2.marketdata.stocks.StockRetrieveNewsResponse
import com.dinari.models.v2.marketdata.stocks.StockRetrieveQuoteParams
import com.dinari.models.v2.marketdata.stocks.StockRetrieveQuoteResponse
import com.dinari.services.async.v2.marketdata.stocks.SplitServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface StockServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): StockServiceAsync

    fun splits(): SplitServiceAsync

    /** Get a list of `Stocks`. */
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
     * Get a list of announced stock dividend details for a specified `Stock`.
     *
     * Note that this data applies only to actual stocks. Yield received for holding tokenized
     * shares may differ from this.
     */
    fun retrieveDividends(
        stockId: String
    ): CompletableFuture<List<StockRetrieveDividendsResponse>> =
        retrieveDividends(stockId, StockRetrieveDividendsParams.none())

    /** @see [retrieveDividends] */
    fun retrieveDividends(
        stockId: String,
        params: StockRetrieveDividendsParams = StockRetrieveDividendsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<StockRetrieveDividendsResponse>> =
        retrieveDividends(params.toBuilder().stockId(stockId).build(), requestOptions)

    /** @see [retrieveDividends] */
    fun retrieveDividends(
        stockId: String,
        params: StockRetrieveDividendsParams = StockRetrieveDividendsParams.none(),
    ): CompletableFuture<List<StockRetrieveDividendsResponse>> =
        retrieveDividends(stockId, params, RequestOptions.none())

    /** @see [retrieveDividends] */
    fun retrieveDividends(
        params: StockRetrieveDividendsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<StockRetrieveDividendsResponse>>

    /** @see [retrieveDividends] */
    fun retrieveDividends(
        params: StockRetrieveDividendsParams
    ): CompletableFuture<List<StockRetrieveDividendsResponse>> =
        retrieveDividends(params, RequestOptions.none())

    /** @see [retrieveDividends] */
    fun retrieveDividends(
        stockId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<StockRetrieveDividendsResponse>> =
        retrieveDividends(stockId, StockRetrieveDividendsParams.none(), requestOptions)

    /**
     * Get historical price data for a specified `Stock`. Each index in the array represents a
     * single tick in a price chart.
     */
    fun retrieveHistoricalPrices(
        stockId: String,
        params: StockRetrieveHistoricalPricesParams,
    ): CompletableFuture<List<StockRetrieveHistoricalPricesResponse>> =
        retrieveHistoricalPrices(stockId, params, RequestOptions.none())

    /** @see [retrieveHistoricalPrices] */
    fun retrieveHistoricalPrices(
        stockId: String,
        params: StockRetrieveHistoricalPricesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<StockRetrieveHistoricalPricesResponse>> =
        retrieveHistoricalPrices(params.toBuilder().stockId(stockId).build(), requestOptions)

    /** @see [retrieveHistoricalPrices] */
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
     * Get the most recent news articles relating to a `Stock`, including a summary of the article
     * and a link to the original source.
     */
    fun retrieveNews(stockId: String): CompletableFuture<List<StockRetrieveNewsResponse>> =
        retrieveNews(stockId, StockRetrieveNewsParams.none())

    /** @see [retrieveNews] */
    fun retrieveNews(
        stockId: String,
        params: StockRetrieveNewsParams = StockRetrieveNewsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<StockRetrieveNewsResponse>> =
        retrieveNews(params.toBuilder().stockId(stockId).build(), requestOptions)

    /** @see [retrieveNews] */
    fun retrieveNews(
        stockId: String,
        params: StockRetrieveNewsParams = StockRetrieveNewsParams.none(),
    ): CompletableFuture<List<StockRetrieveNewsResponse>> =
        retrieveNews(stockId, params, RequestOptions.none())

    /** @see [retrieveNews] */
    fun retrieveNews(
        params: StockRetrieveNewsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<StockRetrieveNewsResponse>>

    /** @see [retrieveNews] */
    fun retrieveNews(
        params: StockRetrieveNewsParams
    ): CompletableFuture<List<StockRetrieveNewsResponse>> =
        retrieveNews(params, RequestOptions.none())

    /** @see [retrieveNews] */
    fun retrieveNews(
        stockId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<StockRetrieveNewsResponse>> =
        retrieveNews(stockId, StockRetrieveNewsParams.none(), requestOptions)

    /** Get quote for a specified `Stock`. */
    fun retrieveQuote(stockId: String): CompletableFuture<StockRetrieveQuoteResponse> =
        retrieveQuote(stockId, StockRetrieveQuoteParams.none())

    /** @see [retrieveQuote] */
    fun retrieveQuote(
        stockId: String,
        params: StockRetrieveQuoteParams = StockRetrieveQuoteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<StockRetrieveQuoteResponse> =
        retrieveQuote(params.toBuilder().stockId(stockId).build(), requestOptions)

    /** @see [retrieveQuote] */
    fun retrieveQuote(
        stockId: String,
        params: StockRetrieveQuoteParams = StockRetrieveQuoteParams.none(),
    ): CompletableFuture<StockRetrieveQuoteResponse> =
        retrieveQuote(stockId, params, RequestOptions.none())

    /** @see [retrieveQuote] */
    fun retrieveQuote(
        params: StockRetrieveQuoteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<StockRetrieveQuoteResponse>

    /** @see [retrieveQuote] */
    fun retrieveQuote(
        params: StockRetrieveQuoteParams
    ): CompletableFuture<StockRetrieveQuoteResponse> = retrieveQuote(params, RequestOptions.none())

    /** @see [retrieveQuote] */
    fun retrieveQuote(
        stockId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<StockRetrieveQuoteResponse> =
        retrieveQuote(stockId, StockRetrieveQuoteParams.none(), requestOptions)

    /** A view of [StockServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): StockServiceAsync.WithRawResponse

        fun splits(): SplitServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v2/market_data/stocks/`, but is otherwise the
         * same as [StockServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<List<StockListResponse>>> =
            list(StockListParams.none())

        /** @see [list] */
        fun list(
            params: StockListParams = StockListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<StockListResponse>>>

        /** @see [list] */
        fun list(
            params: StockListParams = StockListParams.none()
        ): CompletableFuture<HttpResponseFor<List<StockListResponse>>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<List<StockListResponse>>> =
            list(StockListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v2/market_data/stocks/{stock_id}/dividends`,
         * but is otherwise the same as [StockServiceAsync.retrieveDividends].
         */
        fun retrieveDividends(
            stockId: String
        ): CompletableFuture<HttpResponseFor<List<StockRetrieveDividendsResponse>>> =
            retrieveDividends(stockId, StockRetrieveDividendsParams.none())

        /** @see [retrieveDividends] */
        fun retrieveDividends(
            stockId: String,
            params: StockRetrieveDividendsParams = StockRetrieveDividendsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<StockRetrieveDividendsResponse>>> =
            retrieveDividends(params.toBuilder().stockId(stockId).build(), requestOptions)

        /** @see [retrieveDividends] */
        fun retrieveDividends(
            stockId: String,
            params: StockRetrieveDividendsParams = StockRetrieveDividendsParams.none(),
        ): CompletableFuture<HttpResponseFor<List<StockRetrieveDividendsResponse>>> =
            retrieveDividends(stockId, params, RequestOptions.none())

        /** @see [retrieveDividends] */
        fun retrieveDividends(
            params: StockRetrieveDividendsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<StockRetrieveDividendsResponse>>>

        /** @see [retrieveDividends] */
        fun retrieveDividends(
            params: StockRetrieveDividendsParams
        ): CompletableFuture<HttpResponseFor<List<StockRetrieveDividendsResponse>>> =
            retrieveDividends(params, RequestOptions.none())

        /** @see [retrieveDividends] */
        fun retrieveDividends(
            stockId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<StockRetrieveDividendsResponse>>> =
            retrieveDividends(stockId, StockRetrieveDividendsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get
         * /api/v2/market_data/stocks/{stock_id}/historical_prices/`, but is otherwise the same as
         * [StockServiceAsync.retrieveHistoricalPrices].
         */
        fun retrieveHistoricalPrices(
            stockId: String,
            params: StockRetrieveHistoricalPricesParams,
        ): CompletableFuture<HttpResponseFor<List<StockRetrieveHistoricalPricesResponse>>> =
            retrieveHistoricalPrices(stockId, params, RequestOptions.none())

        /** @see [retrieveHistoricalPrices] */
        fun retrieveHistoricalPrices(
            stockId: String,
            params: StockRetrieveHistoricalPricesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<StockRetrieveHistoricalPricesResponse>>> =
            retrieveHistoricalPrices(params.toBuilder().stockId(stockId).build(), requestOptions)

        /** @see [retrieveHistoricalPrices] */
        fun retrieveHistoricalPrices(
            params: StockRetrieveHistoricalPricesParams
        ): CompletableFuture<HttpResponseFor<List<StockRetrieveHistoricalPricesResponse>>> =
            retrieveHistoricalPrices(params, RequestOptions.none())

        /** @see [retrieveHistoricalPrices] */
        fun retrieveHistoricalPrices(
            params: StockRetrieveHistoricalPricesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<StockRetrieveHistoricalPricesResponse>>>

        /**
         * Returns a raw HTTP response for `get /api/v2/market_data/stocks/{stock_id}/news`, but is
         * otherwise the same as [StockServiceAsync.retrieveNews].
         */
        fun retrieveNews(
            stockId: String
        ): CompletableFuture<HttpResponseFor<List<StockRetrieveNewsResponse>>> =
            retrieveNews(stockId, StockRetrieveNewsParams.none())

        /** @see [retrieveNews] */
        fun retrieveNews(
            stockId: String,
            params: StockRetrieveNewsParams = StockRetrieveNewsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<StockRetrieveNewsResponse>>> =
            retrieveNews(params.toBuilder().stockId(stockId).build(), requestOptions)

        /** @see [retrieveNews] */
        fun retrieveNews(
            stockId: String,
            params: StockRetrieveNewsParams = StockRetrieveNewsParams.none(),
        ): CompletableFuture<HttpResponseFor<List<StockRetrieveNewsResponse>>> =
            retrieveNews(stockId, params, RequestOptions.none())

        /** @see [retrieveNews] */
        fun retrieveNews(
            params: StockRetrieveNewsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<StockRetrieveNewsResponse>>>

        /** @see [retrieveNews] */
        fun retrieveNews(
            params: StockRetrieveNewsParams
        ): CompletableFuture<HttpResponseFor<List<StockRetrieveNewsResponse>>> =
            retrieveNews(params, RequestOptions.none())

        /** @see [retrieveNews] */
        fun retrieveNews(
            stockId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<StockRetrieveNewsResponse>>> =
            retrieveNews(stockId, StockRetrieveNewsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v2/market_data/stocks/{stock_id}/quote`, but is
         * otherwise the same as [StockServiceAsync.retrieveQuote].
         */
        fun retrieveQuote(
            stockId: String
        ): CompletableFuture<HttpResponseFor<StockRetrieveQuoteResponse>> =
            retrieveQuote(stockId, StockRetrieveQuoteParams.none())

        /** @see [retrieveQuote] */
        fun retrieveQuote(
            stockId: String,
            params: StockRetrieveQuoteParams = StockRetrieveQuoteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StockRetrieveQuoteResponse>> =
            retrieveQuote(params.toBuilder().stockId(stockId).build(), requestOptions)

        /** @see [retrieveQuote] */
        fun retrieveQuote(
            stockId: String,
            params: StockRetrieveQuoteParams = StockRetrieveQuoteParams.none(),
        ): CompletableFuture<HttpResponseFor<StockRetrieveQuoteResponse>> =
            retrieveQuote(stockId, params, RequestOptions.none())

        /** @see [retrieveQuote] */
        fun retrieveQuote(
            params: StockRetrieveQuoteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StockRetrieveQuoteResponse>>

        /** @see [retrieveQuote] */
        fun retrieveQuote(
            params: StockRetrieveQuoteParams
        ): CompletableFuture<HttpResponseFor<StockRetrieveQuoteResponse>> =
            retrieveQuote(params, RequestOptions.none())

        /** @see [retrieveQuote] */
        fun retrieveQuote(
            stockId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<StockRetrieveQuoteResponse>> =
            retrieveQuote(stockId, StockRetrieveQuoteParams.none(), requestOptions)
    }
}
