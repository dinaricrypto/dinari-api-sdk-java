// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.api

import com.dinari.api.services.blocking.api.v2.AccountService
import com.dinari.api.services.blocking.api.v2.EntityService
import com.dinari.api.services.blocking.api.v2.MarketDataService

interface V2Service {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun marketData(): MarketDataService

    fun entities(): EntityService

    fun accounts(): AccountService

    /** A view of [V2Service] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun marketData(): MarketDataService.WithRawResponse

        fun entities(): EntityService.WithRawResponse

        fun accounts(): AccountService.WithRawResponse
    }
}
