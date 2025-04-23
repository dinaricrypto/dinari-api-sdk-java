// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.api.v2.marketdata.stocks

import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.api.v2.marketdata.stocks.splits.SplitListParams
import com.dinari.api.models.api.v2.marketdata.stocks.splits.SplitRetrieveParams
import com.dinari.api.models.api.v2.marketdata.stocks.splits.StockSplit
import com.google.errorprone.annotations.MustBeClosed
import java.util.concurrent.CompletableFuture

interface SplitServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a list of stock splits for a given stock id. The splits are ordered by the date they
     * were created, with the most recent split first.
     *
     * In an example 10-for-1 stock split, trading will be halted for the stock at the end of the
     * `payable_date`, as the split transitions from `PENDING` to `IN_PROGRESS`. This usually occurs
     * over a weekend to minimize trading disruptions. Each share of stock owned by a shareholder
     * will then be converted into 10 shares, and the split becomes `COMPLETE` as trading resumes on
     * the `ex_date` with new split-adjusted prices.
     */
    fun retrieve(params: SplitRetrieveParams): CompletableFuture<List<StockSplit>> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: SplitRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<StockSplit>>

    /**
     * Returns a list of stock splits. The splits are ordered by the date they were created, with
     * the most recent split first.
     *
     * In an example 10-for-1 stock split, trading will be halted for the stock at the end of the
     * `payable_date`, as the split transitions from `PENDING` to `IN_PROGRESS`. This usually occurs
     * over a weekend to minimize trading disruptions. Each share of stock owned by a shareholder
     * will then be converted into 10 shares, and the split becomes `COMPLETE` as trading resumes on
     * the `ex_date` with new split-adjusted prices.
     */
    fun list(): CompletableFuture<List<StockSplit>> = list(SplitListParams.none())

    /** @see [list] */
    fun list(
        params: SplitListParams = SplitListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<StockSplit>>

    /** @see [list] */
    fun list(
        params: SplitListParams = SplitListParams.none()
    ): CompletableFuture<List<StockSplit>> = list(params, RequestOptions.none())

    /** @see [list] */
    fun list(requestOptions: RequestOptions): CompletableFuture<List<StockSplit>> =
        list(SplitListParams.none(), requestOptions)

    /** A view of [SplitServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /api/v2/market_data/stocks/{stock_id}/splits`, but
         * is otherwise the same as [SplitServiceAsync.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            params: SplitRetrieveParams
        ): CompletableFuture<HttpResponseFor<List<StockSplit>>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: SplitRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<StockSplit>>>

        /**
         * Returns a raw HTTP response for `get /api/v2/market_data/stocks/splits`, but is otherwise
         * the same as [SplitServiceAsync.list].
         */
        @MustBeClosed
        fun list(): CompletableFuture<HttpResponseFor<List<StockSplit>>> =
            list(SplitListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: SplitListParams = SplitListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<StockSplit>>>

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: SplitListParams = SplitListParams.none()
        ): CompletableFuture<HttpResponseFor<List<StockSplit>>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<List<StockSplit>>> =
            list(SplitListParams.none(), requestOptions)
    }
}
