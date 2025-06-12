// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.v2.accounts.orders

import com.dinari.api.core.ClientOptions
import com.dinari.api.services.async.v2.accounts.orders.stocks.Eip155ServiceAsync
import java.util.function.Consumer

interface StockServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): StockServiceAsync

    fun eip155(): Eip155ServiceAsync

    /** A view of [StockServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): StockServiceAsync.WithRawResponse

        fun eip155(): Eip155ServiceAsync.WithRawResponse
    }
}
