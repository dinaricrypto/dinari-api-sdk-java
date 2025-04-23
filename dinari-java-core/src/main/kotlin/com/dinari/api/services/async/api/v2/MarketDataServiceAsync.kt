// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.api.v2

import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.api.v2.marketdata.MarketDataGetMarketHoursParams
import com.dinari.api.models.api.v2.marketdata.MarketDataGetMarketHoursResponse
import com.dinari.api.services.async.api.v2.marketdata.StockServiceAsync
import com.google.errorprone.annotations.MustBeClosed
import java.util.concurrent.CompletableFuture

interface MarketDataServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun stocks(): StockServiceAsync

    /**
     * Returns an object containing the market hours for the current day and next open trading day.
     */
    fun getMarketHours(): CompletableFuture<MarketDataGetMarketHoursResponse> =
        getMarketHours(MarketDataGetMarketHoursParams.none())

    /** @see [getMarketHours] */
    fun getMarketHours(
        params: MarketDataGetMarketHoursParams = MarketDataGetMarketHoursParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MarketDataGetMarketHoursResponse>

    /** @see [getMarketHours] */
    fun getMarketHours(
        params: MarketDataGetMarketHoursParams = MarketDataGetMarketHoursParams.none()
    ): CompletableFuture<MarketDataGetMarketHoursResponse> =
        getMarketHours(params, RequestOptions.none())

    /** @see [getMarketHours] */
    fun getMarketHours(
        requestOptions: RequestOptions
    ): CompletableFuture<MarketDataGetMarketHoursResponse> =
        getMarketHours(MarketDataGetMarketHoursParams.none(), requestOptions)

    /**
     * A view of [MarketDataServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        fun stocks(): StockServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v2/market_data/market_hours/`, but is otherwise
         * the same as [MarketDataServiceAsync.getMarketHours].
         */
        @MustBeClosed
        fun getMarketHours(): CompletableFuture<HttpResponseFor<MarketDataGetMarketHoursResponse>> =
            getMarketHours(MarketDataGetMarketHoursParams.none())

        /** @see [getMarketHours] */
        @MustBeClosed
        fun getMarketHours(
            params: MarketDataGetMarketHoursParams = MarketDataGetMarketHoursParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MarketDataGetMarketHoursResponse>>

        /** @see [getMarketHours] */
        @MustBeClosed
        fun getMarketHours(
            params: MarketDataGetMarketHoursParams = MarketDataGetMarketHoursParams.none()
        ): CompletableFuture<HttpResponseFor<MarketDataGetMarketHoursResponse>> =
            getMarketHours(params, RequestOptions.none())

        /** @see [getMarketHours] */
        @MustBeClosed
        fun getMarketHours(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<MarketDataGetMarketHoursResponse>> =
            getMarketHours(MarketDataGetMarketHoursParams.none(), requestOptions)
    }
}
