// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.marketdata

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.v2.marketdata.alloys.AlloyListParams
import com.dinari.api.models.v2.marketdata.alloys.AlloyListResponse
import com.dinari.api.models.v2.marketdata.alloys.AlloyRetrieveCurrentPriceParams
import com.dinari.api.models.v2.marketdata.alloys.AlloyRetrieveCurrentPriceResponse
import com.dinari.api.models.v2.marketdata.alloys.AlloyRetrieveHistoricalPricesParams
import com.dinari.api.models.v2.marketdata.alloys.AlloyRetrieveHistoricalPricesResponse
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

/**
 * **Dinari provides basic market data for `Stocks` and `Alloys` that are available to transact
 * on.**
 *
 * This data is provided on a best-effort basis and we recommend using a dedicated provider for more
 * intensive market data needs.
 */
interface AlloyService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AlloyService

    /** Returns available `Alloys` with cursor-based pagination. */
    fun list(): AlloyListResponse = list(AlloyListParams.none())

    /** @see list */
    fun list(
        params: AlloyListParams = AlloyListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AlloyListResponse

    /** @see list */
    fun list(params: AlloyListParams = AlloyListParams.none()): AlloyListResponse =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): AlloyListResponse =
        list(AlloyListParams.none(), requestOptions)

    /** Get the current price for a specified `Alloy`. */
    fun retrieveCurrentPrice(alloyId: String): AlloyRetrieveCurrentPriceResponse =
        retrieveCurrentPrice(alloyId, AlloyRetrieveCurrentPriceParams.none())

    /** @see retrieveCurrentPrice */
    fun retrieveCurrentPrice(
        alloyId: String,
        params: AlloyRetrieveCurrentPriceParams = AlloyRetrieveCurrentPriceParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AlloyRetrieveCurrentPriceResponse =
        retrieveCurrentPrice(params.toBuilder().alloyId(alloyId).build(), requestOptions)

    /** @see retrieveCurrentPrice */
    fun retrieveCurrentPrice(
        alloyId: String,
        params: AlloyRetrieveCurrentPriceParams = AlloyRetrieveCurrentPriceParams.none(),
    ): AlloyRetrieveCurrentPriceResponse =
        retrieveCurrentPrice(alloyId, params, RequestOptions.none())

    /** @see retrieveCurrentPrice */
    fun retrieveCurrentPrice(
        params: AlloyRetrieveCurrentPriceParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AlloyRetrieveCurrentPriceResponse

    /** @see retrieveCurrentPrice */
    fun retrieveCurrentPrice(
        params: AlloyRetrieveCurrentPriceParams
    ): AlloyRetrieveCurrentPriceResponse = retrieveCurrentPrice(params, RequestOptions.none())

    /** @see retrieveCurrentPrice */
    fun retrieveCurrentPrice(
        alloyId: String,
        requestOptions: RequestOptions,
    ): AlloyRetrieveCurrentPriceResponse =
        retrieveCurrentPrice(alloyId, AlloyRetrieveCurrentPriceParams.none(), requestOptions)

    /**
     * Get historical price data for a specified `Alloy`. Each index in the array represents a
     * single tick in a price chart.
     */
    fun retrieveHistoricalPrices(
        alloyId: String,
        params: AlloyRetrieveHistoricalPricesParams,
    ): List<AlloyRetrieveHistoricalPricesResponse> =
        retrieveHistoricalPrices(alloyId, params, RequestOptions.none())

    /** @see retrieveHistoricalPrices */
    fun retrieveHistoricalPrices(
        alloyId: String,
        params: AlloyRetrieveHistoricalPricesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<AlloyRetrieveHistoricalPricesResponse> =
        retrieveHistoricalPrices(params.toBuilder().alloyId(alloyId).build(), requestOptions)

    /** @see retrieveHistoricalPrices */
    fun retrieveHistoricalPrices(
        params: AlloyRetrieveHistoricalPricesParams
    ): List<AlloyRetrieveHistoricalPricesResponse> =
        retrieveHistoricalPrices(params, RequestOptions.none())

    /** @see retrieveHistoricalPrices */
    fun retrieveHistoricalPrices(
        params: AlloyRetrieveHistoricalPricesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<AlloyRetrieveHistoricalPricesResponse>

    /** A view of [AlloyService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): AlloyService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v2/market_data/alloys/`, but is otherwise the
         * same as [AlloyService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<AlloyListResponse> = list(AlloyListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: AlloyListParams = AlloyListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AlloyListResponse>

        /** @see list */
        @MustBeClosed
        fun list(
            params: AlloyListParams = AlloyListParams.none()
        ): HttpResponseFor<AlloyListResponse> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<AlloyListResponse> =
            list(AlloyListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get
         * /api/v2/market_data/alloys/{alloy_id}/current_price`, but is otherwise the same as
         * [AlloyService.retrieveCurrentPrice].
         */
        @MustBeClosed
        fun retrieveCurrentPrice(
            alloyId: String
        ): HttpResponseFor<AlloyRetrieveCurrentPriceResponse> =
            retrieveCurrentPrice(alloyId, AlloyRetrieveCurrentPriceParams.none())

        /** @see retrieveCurrentPrice */
        @MustBeClosed
        fun retrieveCurrentPrice(
            alloyId: String,
            params: AlloyRetrieveCurrentPriceParams = AlloyRetrieveCurrentPriceParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AlloyRetrieveCurrentPriceResponse> =
            retrieveCurrentPrice(params.toBuilder().alloyId(alloyId).build(), requestOptions)

        /** @see retrieveCurrentPrice */
        @MustBeClosed
        fun retrieveCurrentPrice(
            alloyId: String,
            params: AlloyRetrieveCurrentPriceParams = AlloyRetrieveCurrentPriceParams.none(),
        ): HttpResponseFor<AlloyRetrieveCurrentPriceResponse> =
            retrieveCurrentPrice(alloyId, params, RequestOptions.none())

        /** @see retrieveCurrentPrice */
        @MustBeClosed
        fun retrieveCurrentPrice(
            params: AlloyRetrieveCurrentPriceParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AlloyRetrieveCurrentPriceResponse>

        /** @see retrieveCurrentPrice */
        @MustBeClosed
        fun retrieveCurrentPrice(
            params: AlloyRetrieveCurrentPriceParams
        ): HttpResponseFor<AlloyRetrieveCurrentPriceResponse> =
            retrieveCurrentPrice(params, RequestOptions.none())

        /** @see retrieveCurrentPrice */
        @MustBeClosed
        fun retrieveCurrentPrice(
            alloyId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AlloyRetrieveCurrentPriceResponse> =
            retrieveCurrentPrice(alloyId, AlloyRetrieveCurrentPriceParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get
         * /api/v2/market_data/alloys/{alloy_id}/historical_prices/`, but is otherwise the same as
         * [AlloyService.retrieveHistoricalPrices].
         */
        @MustBeClosed
        fun retrieveHistoricalPrices(
            alloyId: String,
            params: AlloyRetrieveHistoricalPricesParams,
        ): HttpResponseFor<List<AlloyRetrieveHistoricalPricesResponse>> =
            retrieveHistoricalPrices(alloyId, params, RequestOptions.none())

        /** @see retrieveHistoricalPrices */
        @MustBeClosed
        fun retrieveHistoricalPrices(
            alloyId: String,
            params: AlloyRetrieveHistoricalPricesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<AlloyRetrieveHistoricalPricesResponse>> =
            retrieveHistoricalPrices(params.toBuilder().alloyId(alloyId).build(), requestOptions)

        /** @see retrieveHistoricalPrices */
        @MustBeClosed
        fun retrieveHistoricalPrices(
            params: AlloyRetrieveHistoricalPricesParams
        ): HttpResponseFor<List<AlloyRetrieveHistoricalPricesResponse>> =
            retrieveHistoricalPrices(params, RequestOptions.none())

        /** @see retrieveHistoricalPrices */
        @MustBeClosed
        fun retrieveHistoricalPrices(
            params: AlloyRetrieveHistoricalPricesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<AlloyRetrieveHistoricalPricesResponse>>
    }
}
