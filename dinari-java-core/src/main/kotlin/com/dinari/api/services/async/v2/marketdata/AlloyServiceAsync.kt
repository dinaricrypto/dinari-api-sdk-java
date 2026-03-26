// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.v2.marketdata

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.v2.marketdata.alloys.AlloyListParams
import com.dinari.api.models.v2.marketdata.alloys.AlloyListResponse
import com.dinari.api.models.v2.marketdata.alloys.AlloyRetrieveCurrentPriceParams
import com.dinari.api.models.v2.marketdata.alloys.AlloyRetrieveCurrentPriceResponse
import com.dinari.api.models.v2.marketdata.alloys.AlloyRetrieveHistoricalPricesParams
import com.dinari.api.models.v2.marketdata.alloys.AlloyRetrieveHistoricalPricesResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/**
 * **Dinari provides basic market data for `Stocks` and `Alloys` that are available to transact
 * on.**
 *
 * This data is provided on a best-effort basis and we recommend using a dedicated provider for more
 * intensive market data needs.
 */
interface AlloyServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AlloyServiceAsync

    /** Returns available `Alloys` with cursor-based pagination. */
    fun list(): CompletableFuture<AlloyListResponse> = list(AlloyListParams.none())

    /** @see list */
    fun list(
        params: AlloyListParams = AlloyListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AlloyListResponse>

    /** @see list */
    fun list(
        params: AlloyListParams = AlloyListParams.none()
    ): CompletableFuture<AlloyListResponse> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<AlloyListResponse> =
        list(AlloyListParams.none(), requestOptions)

    /** Get the current price for a specified `Alloy`. */
    fun retrieveCurrentPrice(
        alloyId: String
    ): CompletableFuture<AlloyRetrieveCurrentPriceResponse> =
        retrieveCurrentPrice(alloyId, AlloyRetrieveCurrentPriceParams.none())

    /** @see retrieveCurrentPrice */
    fun retrieveCurrentPrice(
        alloyId: String,
        params: AlloyRetrieveCurrentPriceParams = AlloyRetrieveCurrentPriceParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AlloyRetrieveCurrentPriceResponse> =
        retrieveCurrentPrice(params.toBuilder().alloyId(alloyId).build(), requestOptions)

    /** @see retrieveCurrentPrice */
    fun retrieveCurrentPrice(
        alloyId: String,
        params: AlloyRetrieveCurrentPriceParams = AlloyRetrieveCurrentPriceParams.none(),
    ): CompletableFuture<AlloyRetrieveCurrentPriceResponse> =
        retrieveCurrentPrice(alloyId, params, RequestOptions.none())

    /** @see retrieveCurrentPrice */
    fun retrieveCurrentPrice(
        params: AlloyRetrieveCurrentPriceParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AlloyRetrieveCurrentPriceResponse>

    /** @see retrieveCurrentPrice */
    fun retrieveCurrentPrice(
        params: AlloyRetrieveCurrentPriceParams
    ): CompletableFuture<AlloyRetrieveCurrentPriceResponse> =
        retrieveCurrentPrice(params, RequestOptions.none())

    /** @see retrieveCurrentPrice */
    fun retrieveCurrentPrice(
        alloyId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<AlloyRetrieveCurrentPriceResponse> =
        retrieveCurrentPrice(alloyId, AlloyRetrieveCurrentPriceParams.none(), requestOptions)

    /**
     * Get historical price data for a specified `Alloy`. Each index in the array represents a
     * single tick in a price chart.
     */
    fun retrieveHistoricalPrices(
        alloyId: String,
        params: AlloyRetrieveHistoricalPricesParams,
    ): CompletableFuture<List<AlloyRetrieveHistoricalPricesResponse>> =
        retrieveHistoricalPrices(alloyId, params, RequestOptions.none())

    /** @see retrieveHistoricalPrices */
    fun retrieveHistoricalPrices(
        alloyId: String,
        params: AlloyRetrieveHistoricalPricesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<AlloyRetrieveHistoricalPricesResponse>> =
        retrieveHistoricalPrices(params.toBuilder().alloyId(alloyId).build(), requestOptions)

    /** @see retrieveHistoricalPrices */
    fun retrieveHistoricalPrices(
        params: AlloyRetrieveHistoricalPricesParams
    ): CompletableFuture<List<AlloyRetrieveHistoricalPricesResponse>> =
        retrieveHistoricalPrices(params, RequestOptions.none())

    /** @see retrieveHistoricalPrices */
    fun retrieveHistoricalPrices(
        params: AlloyRetrieveHistoricalPricesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<AlloyRetrieveHistoricalPricesResponse>>

    /** A view of [AlloyServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AlloyServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v2/market_data/alloys/`, but is otherwise the
         * same as [AlloyServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<AlloyListResponse>> =
            list(AlloyListParams.none())

        /** @see list */
        fun list(
            params: AlloyListParams = AlloyListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AlloyListResponse>>

        /** @see list */
        fun list(
            params: AlloyListParams = AlloyListParams.none()
        ): CompletableFuture<HttpResponseFor<AlloyListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<AlloyListResponse>> =
            list(AlloyListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get
         * /api/v2/market_data/alloys/{alloy_id}/current_price`, but is otherwise the same as
         * [AlloyServiceAsync.retrieveCurrentPrice].
         */
        fun retrieveCurrentPrice(
            alloyId: String
        ): CompletableFuture<HttpResponseFor<AlloyRetrieveCurrentPriceResponse>> =
            retrieveCurrentPrice(alloyId, AlloyRetrieveCurrentPriceParams.none())

        /** @see retrieveCurrentPrice */
        fun retrieveCurrentPrice(
            alloyId: String,
            params: AlloyRetrieveCurrentPriceParams = AlloyRetrieveCurrentPriceParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AlloyRetrieveCurrentPriceResponse>> =
            retrieveCurrentPrice(params.toBuilder().alloyId(alloyId).build(), requestOptions)

        /** @see retrieveCurrentPrice */
        fun retrieveCurrentPrice(
            alloyId: String,
            params: AlloyRetrieveCurrentPriceParams = AlloyRetrieveCurrentPriceParams.none(),
        ): CompletableFuture<HttpResponseFor<AlloyRetrieveCurrentPriceResponse>> =
            retrieveCurrentPrice(alloyId, params, RequestOptions.none())

        /** @see retrieveCurrentPrice */
        fun retrieveCurrentPrice(
            params: AlloyRetrieveCurrentPriceParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AlloyRetrieveCurrentPriceResponse>>

        /** @see retrieveCurrentPrice */
        fun retrieveCurrentPrice(
            params: AlloyRetrieveCurrentPriceParams
        ): CompletableFuture<HttpResponseFor<AlloyRetrieveCurrentPriceResponse>> =
            retrieveCurrentPrice(params, RequestOptions.none())

        /** @see retrieveCurrentPrice */
        fun retrieveCurrentPrice(
            alloyId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<AlloyRetrieveCurrentPriceResponse>> =
            retrieveCurrentPrice(alloyId, AlloyRetrieveCurrentPriceParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get
         * /api/v2/market_data/alloys/{alloy_id}/historical_prices/`, but is otherwise the same as
         * [AlloyServiceAsync.retrieveHistoricalPrices].
         */
        fun retrieveHistoricalPrices(
            alloyId: String,
            params: AlloyRetrieveHistoricalPricesParams,
        ): CompletableFuture<HttpResponseFor<List<AlloyRetrieveHistoricalPricesResponse>>> =
            retrieveHistoricalPrices(alloyId, params, RequestOptions.none())

        /** @see retrieveHistoricalPrices */
        fun retrieveHistoricalPrices(
            alloyId: String,
            params: AlloyRetrieveHistoricalPricesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<AlloyRetrieveHistoricalPricesResponse>>> =
            retrieveHistoricalPrices(params.toBuilder().alloyId(alloyId).build(), requestOptions)

        /** @see retrieveHistoricalPrices */
        fun retrieveHistoricalPrices(
            params: AlloyRetrieveHistoricalPricesParams
        ): CompletableFuture<HttpResponseFor<List<AlloyRetrieveHistoricalPricesResponse>>> =
            retrieveHistoricalPrices(params, RequestOptions.none())

        /** @see retrieveHistoricalPrices */
        fun retrieveHistoricalPrices(
            params: AlloyRetrieveHistoricalPricesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<AlloyRetrieveHistoricalPricesResponse>>>
    }
}
