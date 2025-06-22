// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.accounts.orderrequests

import com.dinari.api.core.ClientOptions
import com.dinari.api.services.blocking.v2.accounts.orderrequests.stocks.Eip155Service
import java.util.function.Consumer

interface StockService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): StockService

    fun eip155(): Eip155Service

    /** A view of [StockService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): StockService.WithRawResponse

        fun eip155(): Eip155Service.WithRawResponse
    }
}
