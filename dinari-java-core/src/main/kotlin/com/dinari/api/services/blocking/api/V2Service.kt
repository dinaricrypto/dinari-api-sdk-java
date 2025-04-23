// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.api

import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.api.v2.V2GetHealthParams
import com.dinari.api.models.api.v2.V2GetHealthResponse
import com.dinari.api.services.blocking.api.v2.AccountService
import com.dinari.api.services.blocking.api.v2.EntityService
import com.dinari.api.services.blocking.api.v2.MarketDataService
import com.google.errorprone.annotations.MustBeClosed

interface V2Service {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun marketData(): MarketDataService

    fun entities(): EntityService

    fun accounts(): AccountService

    /** Get Health Status */
    fun getHealth(): V2GetHealthResponse = getHealth(V2GetHealthParams.none())

    /** @see [getHealth] */
    fun getHealth(
        params: V2GetHealthParams = V2GetHealthParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): V2GetHealthResponse

    /** @see [getHealth] */
    fun getHealth(params: V2GetHealthParams = V2GetHealthParams.none()): V2GetHealthResponse =
        getHealth(params, RequestOptions.none())

    /** @see [getHealth] */
    fun getHealth(requestOptions: RequestOptions): V2GetHealthResponse =
        getHealth(V2GetHealthParams.none(), requestOptions)

    /** A view of [V2Service] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun marketData(): MarketDataService.WithRawResponse

        fun entities(): EntityService.WithRawResponse

        fun accounts(): AccountService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v2/_health/`, but is otherwise the same as
         * [V2Service.getHealth].
         */
        @MustBeClosed
        fun getHealth(): HttpResponseFor<V2GetHealthResponse> = getHealth(V2GetHealthParams.none())

        /** @see [getHealth] */
        @MustBeClosed
        fun getHealth(
            params: V2GetHealthParams = V2GetHealthParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<V2GetHealthResponse>

        /** @see [getHealth] */
        @MustBeClosed
        fun getHealth(
            params: V2GetHealthParams = V2GetHealthParams.none()
        ): HttpResponseFor<V2GetHealthResponse> = getHealth(params, RequestOptions.none())

        /** @see [getHealth] */
        @MustBeClosed
        fun getHealth(requestOptions: RequestOptions): HttpResponseFor<V2GetHealthResponse> =
            getHealth(V2GetHealthParams.none(), requestOptions)
    }
}
