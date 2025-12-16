// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.v2.accounts.orderrequests.stocks

import com.dinari.api.core.ClientOptions
import java.util.function.Consumer

interface Eip155ServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): Eip155ServiceAsync

    /**
     * A view of [Eip155ServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): Eip155ServiceAsync.WithRawResponse
    }
}
