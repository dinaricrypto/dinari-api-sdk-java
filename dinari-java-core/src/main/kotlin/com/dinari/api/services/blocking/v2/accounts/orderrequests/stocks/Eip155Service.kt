// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.accounts.orderrequests.stocks

import com.dinari.api.core.ClientOptions
import java.util.function.Consumer

interface Eip155Service {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): Eip155Service

    /** A view of [Eip155Service] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): Eip155Service.WithRawResponse
    }
}
