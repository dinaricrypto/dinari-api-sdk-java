// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.v2.marketdata.stocks

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.v2.marketdata.stocks.splits.SplitListForStockParams
import com.dinari.api.models.v2.marketdata.stocks.splits.SplitListForStockResponse
import com.dinari.api.models.v2.marketdata.stocks.splits.SplitListParams
import com.dinari.api.models.v2.marketdata.stocks.splits.SplitListResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/**
 * **Corporate actions are events that affect the ownership of a `Stock`.**
 *
 * Corporate actions include dividends and stock splits.
 */
interface SplitServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SplitServiceAsync

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
    fun list(): CompletableFuture<SplitListResponse> = list(SplitListParams.none())

    /** @see list */
    fun list(
        params: SplitListParams = SplitListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SplitListResponse>

    /** @see list */
    fun list(
        params: SplitListParams = SplitListParams.none()
    ): CompletableFuture<SplitListResponse> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<SplitListResponse> =
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
    fun listForStock(stockId: String): CompletableFuture<SplitListForStockResponse> =
        listForStock(stockId, SplitListForStockParams.none())

    /** @see listForStock */
    fun listForStock(
        stockId: String,
        params: SplitListForStockParams = SplitListForStockParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SplitListForStockResponse> =
        listForStock(params.toBuilder().stockId(stockId).build(), requestOptions)

    /** @see listForStock */
    fun listForStock(
        stockId: String,
        params: SplitListForStockParams = SplitListForStockParams.none(),
    ): CompletableFuture<SplitListForStockResponse> =
        listForStock(stockId, params, RequestOptions.none())

    /** @see listForStock */
    fun listForStock(
        params: SplitListForStockParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SplitListForStockResponse>

    /** @see listForStock */
    fun listForStock(
        params: SplitListForStockParams
    ): CompletableFuture<SplitListForStockResponse> = listForStock(params, RequestOptions.none())

    /** @see listForStock */
    fun listForStock(
        stockId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<SplitListForStockResponse> =
        listForStock(stockId, SplitListForStockParams.none(), requestOptions)

    /** A view of [SplitServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SplitServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v2/market_data/stocks/splits`, but is otherwise
         * the same as [SplitServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<SplitListResponse>> =
            list(SplitListParams.none())

        /** @see list */
        fun list(
            params: SplitListParams = SplitListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SplitListResponse>>

        /** @see list */
        fun list(
            params: SplitListParams = SplitListParams.none()
        ): CompletableFuture<HttpResponseFor<SplitListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<SplitListResponse>> =
            list(SplitListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v2/market_data/stocks/{stock_id}/splits`, but
         * is otherwise the same as [SplitServiceAsync.listForStock].
         */
        fun listForStock(
            stockId: String
        ): CompletableFuture<HttpResponseFor<SplitListForStockResponse>> =
            listForStock(stockId, SplitListForStockParams.none())

        /** @see listForStock */
        fun listForStock(
            stockId: String,
            params: SplitListForStockParams = SplitListForStockParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SplitListForStockResponse>> =
            listForStock(params.toBuilder().stockId(stockId).build(), requestOptions)

        /** @see listForStock */
        fun listForStock(
            stockId: String,
            params: SplitListForStockParams = SplitListForStockParams.none(),
        ): CompletableFuture<HttpResponseFor<SplitListForStockResponse>> =
            listForStock(stockId, params, RequestOptions.none())

        /** @see listForStock */
        fun listForStock(
            params: SplitListForStockParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SplitListForStockResponse>>

        /** @see listForStock */
        fun listForStock(
            params: SplitListForStockParams
        ): CompletableFuture<HttpResponseFor<SplitListForStockResponse>> =
            listForStock(params, RequestOptions.none())

        /** @see listForStock */
        fun listForStock(
            stockId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<SplitListForStockResponse>> =
            listForStock(stockId, SplitListForStockParams.none(), requestOptions)
    }
}
