// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking

import com.dinari.api.services.blocking.api.V2Service

interface ApiService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun v2(): V2Service

    /** A view of [ApiService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun v2(): V2Service.WithRawResponse
    }
}
