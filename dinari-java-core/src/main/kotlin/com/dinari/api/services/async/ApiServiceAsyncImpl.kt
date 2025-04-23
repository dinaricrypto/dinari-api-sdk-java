// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async

import com.dinari.api.core.ClientOptions
import com.dinari.api.services.async.api.V2ServiceAsync
import com.dinari.api.services.async.api.V2ServiceAsyncImpl

class ApiServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ApiServiceAsync {

    private val withRawResponse: ApiServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val v2: V2ServiceAsync by lazy { V2ServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): ApiServiceAsync.WithRawResponse = withRawResponse

    override fun v2(): V2ServiceAsync = v2

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ApiServiceAsync.WithRawResponse {

        private val v2: V2ServiceAsync.WithRawResponse by lazy {
            V2ServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun v2(): V2ServiceAsync.WithRawResponse = v2
    }
}
