// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.v2.accounts.orders

import com.dinari.api.services.async.v2.accounts.orders.stocks.Eip155ServiceAsync

interface StockServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun eip155(): Eip155ServiceAsync

    /** A view of [StockServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun eip155(): Eip155ServiceAsync.WithRawResponse
    }
}
