// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async

import com.dinari.api.services.async.api.V2ServiceAsync

interface ApiServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun v2(): V2ServiceAsync

    /** A view of [ApiServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun v2(): V2ServiceAsync.WithRawResponse
    }
}
