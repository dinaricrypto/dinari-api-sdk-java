// File generated from our OpenAPI spec by Stainless.

package com.dinari.services.blocking.v2

import com.dinari.core.ClientOptions
import com.dinari.core.RequestOptions
import com.dinari.core.http.HttpResponseFor
import com.dinari.models.v2.marketdata.MarketDataRetrieveMarketHoursParams
import com.dinari.models.v2.marketdata.MarketDataRetrieveMarketHoursResponse
import com.dinari.services.blocking.v2.marketdata.StockService
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface MarketDataService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): MarketDataService

    fun stocks(): StockService

    /** Get the market hours for the current trading session and next open trading session. */
    fun retrieveMarketHours(): MarketDataRetrieveMarketHoursResponse =
        retrieveMarketHours(MarketDataRetrieveMarketHoursParams.none())

    /** @see [retrieveMarketHours] */
    fun retrieveMarketHours(
        params: MarketDataRetrieveMarketHoursParams = MarketDataRetrieveMarketHoursParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MarketDataRetrieveMarketHoursResponse

    /** @see [retrieveMarketHours] */
    fun retrieveMarketHours(
        params: MarketDataRetrieveMarketHoursParams = MarketDataRetrieveMarketHoursParams.none()
    ): MarketDataRetrieveMarketHoursResponse = retrieveMarketHours(params, RequestOptions.none())

    /** @see [retrieveMarketHours] */
    fun retrieveMarketHours(requestOptions: RequestOptions): MarketDataRetrieveMarketHoursResponse =
        retrieveMarketHours(MarketDataRetrieveMarketHoursParams.none(), requestOptions)

    /** A view of [MarketDataService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): MarketDataService.WithRawResponse

        fun stocks(): StockService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v2/market_data/market_hours/`, but is otherwise
         * the same as [MarketDataService.retrieveMarketHours].
         */
        @MustBeClosed
        fun retrieveMarketHours(): HttpResponseFor<MarketDataRetrieveMarketHoursResponse> =
            retrieveMarketHours(MarketDataRetrieveMarketHoursParams.none())

        /** @see [retrieveMarketHours] */
        @MustBeClosed
        fun retrieveMarketHours(
            params: MarketDataRetrieveMarketHoursParams =
                MarketDataRetrieveMarketHoursParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MarketDataRetrieveMarketHoursResponse>

        /** @see [retrieveMarketHours] */
        @MustBeClosed
        fun retrieveMarketHours(
            params: MarketDataRetrieveMarketHoursParams = MarketDataRetrieveMarketHoursParams.none()
        ): HttpResponseFor<MarketDataRetrieveMarketHoursResponse> =
            retrieveMarketHours(params, RequestOptions.none())

        /** @see [retrieveMarketHours] */
        @MustBeClosed
        fun retrieveMarketHours(
            requestOptions: RequestOptions
        ): HttpResponseFor<MarketDataRetrieveMarketHoursResponse> =
            retrieveMarketHours(MarketDataRetrieveMarketHoursParams.none(), requestOptions)
    }
}
