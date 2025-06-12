// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async

import com.dinari.api.core.ClientOptions
import com.dinari.api.services.async.v2.AccountServiceAsync
import com.dinari.api.services.async.v2.EntityServiceAsync
import com.dinari.api.services.async.v2.MarketDataServiceAsync
import java.util.function.Consumer

interface V2ServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): V2ServiceAsync

    fun marketData(): MarketDataServiceAsync

    fun entities(): EntityServiceAsync

    fun accounts(): AccountServiceAsync

    /** A view of [V2ServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): V2ServiceAsync.WithRawResponse

        fun marketData(): MarketDataServiceAsync.WithRawResponse

        fun entities(): EntityServiceAsync.WithRawResponse

        fun accounts(): AccountServiceAsync.WithRawResponse
    }
}
