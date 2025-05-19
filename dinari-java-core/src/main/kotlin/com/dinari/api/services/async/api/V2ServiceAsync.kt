// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.api

import com.dinari.api.services.async.api.v2.AccountServiceAsync
import com.dinari.api.services.async.api.v2.EntityServiceAsync
import com.dinari.api.services.async.api.v2.MarketDataServiceAsync

interface V2ServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun marketData(): MarketDataServiceAsync

    fun entities(): EntityServiceAsync

    fun accounts(): AccountServiceAsync

    /** A view of [V2ServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun marketData(): MarketDataServiceAsync.WithRawResponse

        fun entities(): EntityServiceAsync.WithRawResponse

        fun accounts(): AccountServiceAsync.WithRawResponse
    }
}
