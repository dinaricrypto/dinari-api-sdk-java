// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.accounts.orders

import com.dinari.api.services.blocking.v2.accounts.orders.stocks.Eip155Service

interface StockService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun eip155(): Eip155Service

    /** A view of [StockService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun eip155(): Eip155Service.WithRawResponse
    }
}
