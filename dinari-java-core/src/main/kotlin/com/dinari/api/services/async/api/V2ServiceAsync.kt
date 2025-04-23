// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.api

import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.api.v2.V2GetHealthParams
import com.dinari.api.models.api.v2.V2GetHealthResponse
import com.dinari.api.services.async.api.v2.AccountServiceAsync
import com.dinari.api.services.async.api.v2.EntityServiceAsync
import com.dinari.api.services.async.api.v2.MarketDataServiceAsync
import com.google.errorprone.annotations.MustBeClosed
import java.util.concurrent.CompletableFuture

interface V2ServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun marketData(): MarketDataServiceAsync

    fun entities(): EntityServiceAsync

    fun accounts(): AccountServiceAsync

    /** Get Health Status */
    fun getHealth(): CompletableFuture<V2GetHealthResponse> = getHealth(V2GetHealthParams.none())

    /** @see [getHealth] */
    fun getHealth(
        params: V2GetHealthParams = V2GetHealthParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<V2GetHealthResponse>

    /** @see [getHealth] */
    fun getHealth(
        params: V2GetHealthParams = V2GetHealthParams.none()
    ): CompletableFuture<V2GetHealthResponse> = getHealth(params, RequestOptions.none())

    /** @see [getHealth] */
    fun getHealth(requestOptions: RequestOptions): CompletableFuture<V2GetHealthResponse> =
        getHealth(V2GetHealthParams.none(), requestOptions)

    /** A view of [V2ServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun marketData(): MarketDataServiceAsync.WithRawResponse

        fun entities(): EntityServiceAsync.WithRawResponse

        fun accounts(): AccountServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v2/_health/`, but is otherwise the same as
         * [V2ServiceAsync.getHealth].
         */
        @MustBeClosed
        fun getHealth(): CompletableFuture<HttpResponseFor<V2GetHealthResponse>> =
            getHealth(V2GetHealthParams.none())

        /** @see [getHealth] */
        @MustBeClosed
        fun getHealth(
            params: V2GetHealthParams = V2GetHealthParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<V2GetHealthResponse>>

        /** @see [getHealth] */
        @MustBeClosed
        fun getHealth(
            params: V2GetHealthParams = V2GetHealthParams.none()
        ): CompletableFuture<HttpResponseFor<V2GetHealthResponse>> =
            getHealth(params, RequestOptions.none())

        /** @see [getHealth] */
        @MustBeClosed
        fun getHealth(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<V2GetHealthResponse>> =
            getHealth(V2GetHealthParams.none(), requestOptions)
    }
}
