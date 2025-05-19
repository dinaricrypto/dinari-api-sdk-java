// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.api.v2

import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.api.v2.marketdata.MarketDataGetMarketHoursParams
import com.dinari.api.models.api.v2.marketdata.MarketDataGetMarketHoursResponse
import com.dinari.api.services.blocking.api.v2.marketdata.StockService
import com.google.errorprone.annotations.MustBeClosed

interface MarketDataService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun stocks(): StockService

    /** Get the market hours for the current trading session and next open trading session. */
    fun getMarketHours(): MarketDataGetMarketHoursResponse =
        getMarketHours(MarketDataGetMarketHoursParams.none())

    /** @see [getMarketHours] */
    fun getMarketHours(
        params: MarketDataGetMarketHoursParams = MarketDataGetMarketHoursParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MarketDataGetMarketHoursResponse

    /** @see [getMarketHours] */
    fun getMarketHours(
        params: MarketDataGetMarketHoursParams = MarketDataGetMarketHoursParams.none()
    ): MarketDataGetMarketHoursResponse = getMarketHours(params, RequestOptions.none())

    /** @see [getMarketHours] */
    fun getMarketHours(requestOptions: RequestOptions): MarketDataGetMarketHoursResponse =
        getMarketHours(MarketDataGetMarketHoursParams.none(), requestOptions)

    /** A view of [MarketDataService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun stocks(): StockService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v2/market_data/market_hours/`, but is otherwise
         * the same as [MarketDataService.getMarketHours].
         */
        @MustBeClosed
        fun getMarketHours(): HttpResponseFor<MarketDataGetMarketHoursResponse> =
            getMarketHours(MarketDataGetMarketHoursParams.none())

        /** @see [getMarketHours] */
        @MustBeClosed
        fun getMarketHours(
            params: MarketDataGetMarketHoursParams = MarketDataGetMarketHoursParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MarketDataGetMarketHoursResponse>

        /** @see [getMarketHours] */
        @MustBeClosed
        fun getMarketHours(
            params: MarketDataGetMarketHoursParams = MarketDataGetMarketHoursParams.none()
        ): HttpResponseFor<MarketDataGetMarketHoursResponse> =
            getMarketHours(params, RequestOptions.none())

        /** @see [getMarketHours] */
        @MustBeClosed
        fun getMarketHours(
            requestOptions: RequestOptions
        ): HttpResponseFor<MarketDataGetMarketHoursResponse> =
            getMarketHours(MarketDataGetMarketHoursParams.none(), requestOptions)
    }
}
