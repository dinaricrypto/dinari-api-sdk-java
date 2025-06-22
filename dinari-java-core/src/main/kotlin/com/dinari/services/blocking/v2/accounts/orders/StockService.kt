// File generated from our OpenAPI spec by Stainless.

package com.dinari.services.blocking.v2.accounts.orders

import com.dinari.core.ClientOptions
import com.dinari.services.blocking.v2.accounts.orders.stocks.Eip155Service
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
