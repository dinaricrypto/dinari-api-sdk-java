// File generated from our OpenAPI spec by Stainless.

package com.dinari.services.async.v2

import com.dinari.core.ClientOptions
import com.dinari.core.RequestOptions
import com.dinari.core.http.HttpResponseFor
import com.dinari.models.v2.marketdata.MarketDataRetrieveMarketHoursParams
import com.dinari.models.v2.marketdata.MarketDataRetrieveMarketHoursResponse
import com.dinari.services.async.v2.marketdata.StockServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface MarketDataServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): MarketDataServiceAsync

    fun stocks(): StockServiceAsync

    /** Get the market hours for the current trading session and next open trading session. */
    fun retrieveMarketHours(): CompletableFuture<MarketDataRetrieveMarketHoursResponse> =
        retrieveMarketHours(MarketDataRetrieveMarketHoursParams.none())

    /** @see [retrieveMarketHours] */
    fun retrieveMarketHours(
        params: MarketDataRetrieveMarketHoursParams = MarketDataRetrieveMarketHoursParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MarketDataRetrieveMarketHoursResponse>

    /** @see [retrieveMarketHours] */
    fun retrieveMarketHours(
        params: MarketDataRetrieveMarketHoursParams = MarketDataRetrieveMarketHoursParams.none()
    ): CompletableFuture<MarketDataRetrieveMarketHoursResponse> =
        retrieveMarketHours(params, RequestOptions.none())

    /** @see [retrieveMarketHours] */
    fun retrieveMarketHours(
        requestOptions: RequestOptions
    ): CompletableFuture<MarketDataRetrieveMarketHoursResponse> =
        retrieveMarketHours(MarketDataRetrieveMarketHoursParams.none(), requestOptions)

    /**
     * A view of [MarketDataServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): MarketDataServiceAsync.WithRawResponse

        fun stocks(): StockServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v2/market_data/market_hours/`, but is otherwise
         * the same as [MarketDataServiceAsync.retrieveMarketHours].
         */
        fun retrieveMarketHours():
            CompletableFuture<HttpResponseFor<MarketDataRetrieveMarketHoursResponse>> =
            retrieveMarketHours(MarketDataRetrieveMarketHoursParams.none())

        /** @see [retrieveMarketHours] */
        fun retrieveMarketHours(
            params: MarketDataRetrieveMarketHoursParams =
                MarketDataRetrieveMarketHoursParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MarketDataRetrieveMarketHoursResponse>>

        /** @see [retrieveMarketHours] */
        fun retrieveMarketHours(
            params: MarketDataRetrieveMarketHoursParams = MarketDataRetrieveMarketHoursParams.none()
        ): CompletableFuture<HttpResponseFor<MarketDataRetrieveMarketHoursResponse>> =
            retrieveMarketHours(params, RequestOptions.none())

        /** @see [retrieveMarketHours] */
        fun retrieveMarketHours(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<MarketDataRetrieveMarketHoursResponse>> =
            retrieveMarketHours(MarketDataRetrieveMarketHoursParams.none(), requestOptions)
    }
}
