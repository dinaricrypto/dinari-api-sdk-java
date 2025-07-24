// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.v2.marketdata

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
import com.dinari.api.services.async.v2.marketdata.stocks.SplitServiceAsync
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

    /** @see list */
    fun list(
        params: StockListParams = StockListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<StockListResponse>>

    /** @see list */
    fun list(
        params: StockListParams = StockListParams.none()
    ): CompletableFuture<List<StockListResponse>> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<List<StockListResponse>> =
        list(StockListParams.none(), requestOptions)

    /** Get current price for a specified `Stock`. */
    fun retrieveCurrentPrice(
        stockId: String
    ): CompletableFuture<StockRetrieveCurrentPriceResponse> =
        retrieveCurrentPrice(stockId, StockRetrieveCurrentPriceParams.none())

    /** @see retrieveCurrentPrice */
    fun retrieveCurrentPrice(
        stockId: String,
        params: StockRetrieveCurrentPriceParams = StockRetrieveCurrentPriceParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<StockRetrieveCurrentPriceResponse> =
        retrieveCurrentPrice(params.toBuilder().stockId(stockId).build(), requestOptions)

    /** @see retrieveCurrentPrice */
    fun retrieveCurrentPrice(
        stockId: String,
        params: StockRetrieveCurrentPriceParams = StockRetrieveCurrentPriceParams.none(),
    ): CompletableFuture<StockRetrieveCurrentPriceResponse> =
        retrieveCurrentPrice(stockId, params, RequestOptions.none())

    /** @see retrieveCurrentPrice */
    fun retrieveCurrentPrice(
        params: StockRetrieveCurrentPriceParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<StockRetrieveCurrentPriceResponse>

    /** @see retrieveCurrentPrice */
    fun retrieveCurrentPrice(
        params: StockRetrieveCurrentPriceParams
    ): CompletableFuture<StockRetrieveCurrentPriceResponse> =
        retrieveCurrentPrice(params, RequestOptions.none())

    /** @see retrieveCurrentPrice */
    fun retrieveCurrentPrice(
        stockId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<StockRetrieveCurrentPriceResponse> =
        retrieveCurrentPrice(stockId, StockRetrieveCurrentPriceParams.none(), requestOptions)

    /** Get quote for a specified `Stock`. */
    fun retrieveCurrentQuote(
        stockId: String
    ): CompletableFuture<StockRetrieveCurrentQuoteResponse> =
        retrieveCurrentQuote(stockId, StockRetrieveCurrentQuoteParams.none())

    /** @see retrieveCurrentQuote */
    fun retrieveCurrentQuote(
        stockId: String,
        params: StockRetrieveCurrentQuoteParams = StockRetrieveCurrentQuoteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<StockRetrieveCurrentQuoteResponse> =
        retrieveCurrentQuote(params.toBuilder().stockId(stockId).build(), requestOptions)

    /** @see retrieveCurrentQuote */
    fun retrieveCurrentQuote(
        stockId: String,
        params: StockRetrieveCurrentQuoteParams = StockRetrieveCurrentQuoteParams.none(),
    ): CompletableFuture<StockRetrieveCurrentQuoteResponse> =
        retrieveCurrentQuote(stockId, params, RequestOptions.none())

    /** @see retrieveCurrentQuote */
    fun retrieveCurrentQuote(
        params: StockRetrieveCurrentQuoteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<StockRetrieveCurrentQuoteResponse>

    /** @see retrieveCurrentQuote */
    fun retrieveCurrentQuote(
        params: StockRetrieveCurrentQuoteParams
    ): CompletableFuture<StockRetrieveCurrentQuoteResponse> =
        retrieveCurrentQuote(params, RequestOptions.none())

    /** @see retrieveCurrentQuote */
    fun retrieveCurrentQuote(
        stockId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<StockRetrieveCurrentQuoteResponse> =
        retrieveCurrentQuote(stockId, StockRetrieveCurrentQuoteParams.none(), requestOptions)

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

    /** @see retrieveDividends */
    fun retrieveDividends(
        stockId: String,
        params: StockRetrieveDividendsParams = StockRetrieveDividendsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<StockRetrieveDividendsResponse>> =
        retrieveDividends(params.toBuilder().stockId(stockId).build(), requestOptions)

    /** @see retrieveDividends */
    fun retrieveDividends(
        stockId: String,
        params: StockRetrieveDividendsParams = StockRetrieveDividendsParams.none(),
    ): CompletableFuture<List<StockRetrieveDividendsResponse>> =
        retrieveDividends(stockId, params, RequestOptions.none())

    /** @see retrieveDividends */
    fun retrieveDividends(
        params: StockRetrieveDividendsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<StockRetrieveDividendsResponse>>

    /** @see retrieveDividends */
    fun retrieveDividends(
        params: StockRetrieveDividendsParams
    ): CompletableFuture<List<StockRetrieveDividendsResponse>> =
        retrieveDividends(params, RequestOptions.none())

    /** @see retrieveDividends */
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

    /** @see retrieveHistoricalPrices */
    fun retrieveHistoricalPrices(
        stockId: String,
        params: StockRetrieveHistoricalPricesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<StockRetrieveHistoricalPricesResponse>> =
        retrieveHistoricalPrices(params.toBuilder().stockId(stockId).build(), requestOptions)

    /** @see retrieveHistoricalPrices */
    fun retrieveHistoricalPrices(
        params: StockRetrieveHistoricalPricesParams
    ): CompletableFuture<List<StockRetrieveHistoricalPricesResponse>> =
        retrieveHistoricalPrices(params, RequestOptions.none())

    /** @see retrieveHistoricalPrices */
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

    /** @see retrieveNews */
    fun retrieveNews(
        stockId: String,
        params: StockRetrieveNewsParams = StockRetrieveNewsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<StockRetrieveNewsResponse>> =
        retrieveNews(params.toBuilder().stockId(stockId).build(), requestOptions)

    /** @see retrieveNews */
    fun retrieveNews(
        stockId: String,
        params: StockRetrieveNewsParams = StockRetrieveNewsParams.none(),
    ): CompletableFuture<List<StockRetrieveNewsResponse>> =
        retrieveNews(stockId, params, RequestOptions.none())

    /** @see retrieveNews */
    fun retrieveNews(
        params: StockRetrieveNewsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<StockRetrieveNewsResponse>>

    /** @see retrieveNews */
    fun retrieveNews(
        params: StockRetrieveNewsParams
    ): CompletableFuture<List<StockRetrieveNewsResponse>> =
        retrieveNews(params, RequestOptions.none())

    /** @see retrieveNews */
    fun retrieveNews(
        stockId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<StockRetrieveNewsResponse>> =
        retrieveNews(stockId, StockRetrieveNewsParams.none(), requestOptions)

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

        /** @see list */
        fun list(
            params: StockListParams = StockListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<StockListResponse>>>

        /** @see list */
        fun list(
            params: StockListParams = StockListParams.none()
        ): CompletableFuture<HttpResponseFor<List<StockListResponse>>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<List<StockListResponse>>> =
            list(StockListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get
         * /api/v2/market_data/stocks/{stock_id}/current_price`, but is otherwise the same as
         * [StockServiceAsync.retrieveCurrentPrice].
         */
        fun retrieveCurrentPrice(
            stockId: String
        ): CompletableFuture<HttpResponseFor<StockRetrieveCurrentPriceResponse>> =
            retrieveCurrentPrice(stockId, StockRetrieveCurrentPriceParams.none())

        /** @see retrieveCurrentPrice */
        fun retrieveCurrentPrice(
            stockId: String,
            params: StockRetrieveCurrentPriceParams = StockRetrieveCurrentPriceParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StockRetrieveCurrentPriceResponse>> =
            retrieveCurrentPrice(params.toBuilder().stockId(stockId).build(), requestOptions)

        /** @see retrieveCurrentPrice */
        fun retrieveCurrentPrice(
            stockId: String,
            params: StockRetrieveCurrentPriceParams = StockRetrieveCurrentPriceParams.none(),
        ): CompletableFuture<HttpResponseFor<StockRetrieveCurrentPriceResponse>> =
            retrieveCurrentPrice(stockId, params, RequestOptions.none())

        /** @see retrieveCurrentPrice */
        fun retrieveCurrentPrice(
            params: StockRetrieveCurrentPriceParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StockRetrieveCurrentPriceResponse>>

        /** @see retrieveCurrentPrice */
        fun retrieveCurrentPrice(
            params: StockRetrieveCurrentPriceParams
        ): CompletableFuture<HttpResponseFor<StockRetrieveCurrentPriceResponse>> =
            retrieveCurrentPrice(params, RequestOptions.none())

        /** @see retrieveCurrentPrice */
        fun retrieveCurrentPrice(
            stockId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<StockRetrieveCurrentPriceResponse>> =
            retrieveCurrentPrice(stockId, StockRetrieveCurrentPriceParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get
         * /api/v2/market_data/stocks/{stock_id}/current_quote`, but is otherwise the same as
         * [StockServiceAsync.retrieveCurrentQuote].
         */
        fun retrieveCurrentQuote(
            stockId: String
        ): CompletableFuture<HttpResponseFor<StockRetrieveCurrentQuoteResponse>> =
            retrieveCurrentQuote(stockId, StockRetrieveCurrentQuoteParams.none())

        /** @see retrieveCurrentQuote */
        fun retrieveCurrentQuote(
            stockId: String,
            params: StockRetrieveCurrentQuoteParams = StockRetrieveCurrentQuoteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StockRetrieveCurrentQuoteResponse>> =
            retrieveCurrentQuote(params.toBuilder().stockId(stockId).build(), requestOptions)

        /** @see retrieveCurrentQuote */
        fun retrieveCurrentQuote(
            stockId: String,
            params: StockRetrieveCurrentQuoteParams = StockRetrieveCurrentQuoteParams.none(),
        ): CompletableFuture<HttpResponseFor<StockRetrieveCurrentQuoteResponse>> =
            retrieveCurrentQuote(stockId, params, RequestOptions.none())

        /** @see retrieveCurrentQuote */
        fun retrieveCurrentQuote(
            params: StockRetrieveCurrentQuoteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StockRetrieveCurrentQuoteResponse>>

        /** @see retrieveCurrentQuote */
        fun retrieveCurrentQuote(
            params: StockRetrieveCurrentQuoteParams
        ): CompletableFuture<HttpResponseFor<StockRetrieveCurrentQuoteResponse>> =
            retrieveCurrentQuote(params, RequestOptions.none())

        /** @see retrieveCurrentQuote */
        fun retrieveCurrentQuote(
            stockId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<StockRetrieveCurrentQuoteResponse>> =
            retrieveCurrentQuote(stockId, StockRetrieveCurrentQuoteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v2/market_data/stocks/{stock_id}/dividends`,
         * but is otherwise the same as [StockServiceAsync.retrieveDividends].
         */
        fun retrieveDividends(
            stockId: String
        ): CompletableFuture<HttpResponseFor<List<StockRetrieveDividendsResponse>>> =
            retrieveDividends(stockId, StockRetrieveDividendsParams.none())

        /** @see retrieveDividends */
        fun retrieveDividends(
            stockId: String,
            params: StockRetrieveDividendsParams = StockRetrieveDividendsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<StockRetrieveDividendsResponse>>> =
            retrieveDividends(params.toBuilder().stockId(stockId).build(), requestOptions)

        /** @see retrieveDividends */
        fun retrieveDividends(
            stockId: String,
            params: StockRetrieveDividendsParams = StockRetrieveDividendsParams.none(),
        ): CompletableFuture<HttpResponseFor<List<StockRetrieveDividendsResponse>>> =
            retrieveDividends(stockId, params, RequestOptions.none())

        /** @see retrieveDividends */
        fun retrieveDividends(
            params: StockRetrieveDividendsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<StockRetrieveDividendsResponse>>>

        /** @see retrieveDividends */
        fun retrieveDividends(
            params: StockRetrieveDividendsParams
        ): CompletableFuture<HttpResponseFor<List<StockRetrieveDividendsResponse>>> =
            retrieveDividends(params, RequestOptions.none())

        /** @see retrieveDividends */
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

        /** @see retrieveHistoricalPrices */
        fun retrieveHistoricalPrices(
            stockId: String,
            params: StockRetrieveHistoricalPricesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<StockRetrieveHistoricalPricesResponse>>> =
            retrieveHistoricalPrices(params.toBuilder().stockId(stockId).build(), requestOptions)

        /** @see retrieveHistoricalPrices */
        fun retrieveHistoricalPrices(
            params: StockRetrieveHistoricalPricesParams
        ): CompletableFuture<HttpResponseFor<List<StockRetrieveHistoricalPricesResponse>>> =
            retrieveHistoricalPrices(params, RequestOptions.none())

        /** @see retrieveHistoricalPrices */
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

        /** @see retrieveNews */
        fun retrieveNews(
            stockId: String,
            params: StockRetrieveNewsParams = StockRetrieveNewsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<StockRetrieveNewsResponse>>> =
            retrieveNews(params.toBuilder().stockId(stockId).build(), requestOptions)

        /** @see retrieveNews */
        fun retrieveNews(
            stockId: String,
            params: StockRetrieveNewsParams = StockRetrieveNewsParams.none(),
        ): CompletableFuture<HttpResponseFor<List<StockRetrieveNewsResponse>>> =
            retrieveNews(stockId, params, RequestOptions.none())

        /** @see retrieveNews */
        fun retrieveNews(
            params: StockRetrieveNewsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<StockRetrieveNewsResponse>>>

        /** @see retrieveNews */
        fun retrieveNews(
            params: StockRetrieveNewsParams
        ): CompletableFuture<HttpResponseFor<List<StockRetrieveNewsResponse>>> =
            retrieveNews(params, RequestOptions.none())

        /** @see retrieveNews */
        fun retrieveNews(
            stockId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<StockRetrieveNewsResponse>>> =
            retrieveNews(stockId, StockRetrieveNewsParams.none(), requestOptions)
    }
}
