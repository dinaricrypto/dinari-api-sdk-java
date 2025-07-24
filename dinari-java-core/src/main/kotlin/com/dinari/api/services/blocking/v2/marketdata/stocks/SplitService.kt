// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.marketdata.stocks

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.v2.marketdata.stocks.splits.SplitListForStockParams
import com.dinari.api.models.v2.marketdata.stocks.splits.SplitListParams
import com.dinari.api.models.v2.marketdata.stocks.splits.StockSplit
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface SplitService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SplitService

    /**
     * Get a list of stock splits for `Stocks` available for trade via Dinari. The splits are
     * ordered by the date they were created, with the most recent split first.
     *
     * In an example 10-for-1 stock split, trading will be halted for the stock at the end of the
     * `payable_date`, as the split transitions from `PENDING` to `IN_PROGRESS`. This usually occurs
     * over a weekend to minimize trading disruptions. Each share of stock owned by a shareholder
     * will then be converted into 10 shares, and the split becomes `COMPLETE` as trading resumes on
     * the `ex_date` with new split-adjusted prices.
     */
    fun list(): List<StockSplit> = list(SplitListParams.none())

    /** @see list */
    fun list(
        params: SplitListParams = SplitListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<StockSplit>

    /** @see list */
    fun list(params: SplitListParams = SplitListParams.none()): List<StockSplit> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): List<StockSplit> =
        list(SplitListParams.none(), requestOptions)

    /**
     * Get a list of stock splits for a specific `Stock`. The splits are ordered by the date they
     * were created, with the most recent split first.
     *
     * In an example 10-for-1 stock split, trading will be halted for the stock at the end of the
     * `payable_date`, as the split transitions from `PENDING` to `IN_PROGRESS`. This usually occurs
     * over a weekend to minimize trading disruptions. Each share of stock owned by a shareholder
     * will then be converted into 10 shares, and the split becomes `COMPLETE` as trading resumes on
     * the `ex_date` with new split-adjusted prices.
     */
    fun listForStock(stockId: String): List<StockSplit> =
        listForStock(stockId, SplitListForStockParams.none())

    /** @see listForStock */
    fun listForStock(
        stockId: String,
        params: SplitListForStockParams = SplitListForStockParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<StockSplit> = listForStock(params.toBuilder().stockId(stockId).build(), requestOptions)

    /** @see listForStock */
    fun listForStock(
        stockId: String,
        params: SplitListForStockParams = SplitListForStockParams.none(),
    ): List<StockSplit> = listForStock(stockId, params, RequestOptions.none())

    /** @see listForStock */
    fun listForStock(
        params: SplitListForStockParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<StockSplit>

    /** @see listForStock */
    fun listForStock(params: SplitListForStockParams): List<StockSplit> =
        listForStock(params, RequestOptions.none())

    /** @see listForStock */
    fun listForStock(stockId: String, requestOptions: RequestOptions): List<StockSplit> =
        listForStock(stockId, SplitListForStockParams.none(), requestOptions)

    /** A view of [SplitService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): SplitService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v2/market_data/stocks/splits`, but is otherwise
         * the same as [SplitService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<List<StockSplit>> = list(SplitListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: SplitListParams = SplitListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<StockSplit>>

        /** @see list */
        @MustBeClosed
        fun list(
            params: SplitListParams = SplitListParams.none()
        ): HttpResponseFor<List<StockSplit>> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<List<StockSplit>> =
            list(SplitListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v2/market_data/stocks/{stock_id}/splits`, but
         * is otherwise the same as [SplitService.listForStock].
         */
        @MustBeClosed
        fun listForStock(stockId: String): HttpResponseFor<List<StockSplit>> =
            listForStock(stockId, SplitListForStockParams.none())

        /** @see listForStock */
        @MustBeClosed
        fun listForStock(
            stockId: String,
            params: SplitListForStockParams = SplitListForStockParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<StockSplit>> =
            listForStock(params.toBuilder().stockId(stockId).build(), requestOptions)

        /** @see listForStock */
        @MustBeClosed
        fun listForStock(
            stockId: String,
            params: SplitListForStockParams = SplitListForStockParams.none(),
        ): HttpResponseFor<List<StockSplit>> = listForStock(stockId, params, RequestOptions.none())

        /** @see listForStock */
        @MustBeClosed
        fun listForStock(
            params: SplitListForStockParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<StockSplit>>

        /** @see listForStock */
        @MustBeClosed
        fun listForStock(params: SplitListForStockParams): HttpResponseFor<List<StockSplit>> =
            listForStock(params, RequestOptions.none())

        /** @see listForStock */
        @MustBeClosed
        fun listForStock(
            stockId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<StockSplit>> =
            listForStock(stockId, SplitListForStockParams.none(), requestOptions)
    }
}
