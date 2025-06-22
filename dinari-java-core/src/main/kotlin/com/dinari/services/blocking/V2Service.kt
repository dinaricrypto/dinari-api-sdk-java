// File generated from our OpenAPI spec by Stainless.

package com.dinari.services.blocking

import com.dinari.core.ClientOptions
import com.dinari.services.blocking.v2.AccountService
import com.dinari.services.blocking.v2.EntityService
import com.dinari.services.blocking.v2.MarketDataService
import java.util.function.Consumer

interface V2Service {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): V2Service

    fun marketData(): MarketDataService

    fun entities(): EntityService

    fun accounts(): AccountService

    /** A view of [V2Service] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): V2Service.WithRawResponse

        fun marketData(): MarketDataService.WithRawResponse

        fun entities(): EntityService.WithRawResponse

        fun accounts(): AccountService.WithRawResponse
    }
}
