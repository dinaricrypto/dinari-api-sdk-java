// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.client

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.getPackageVersion
import com.dinari.api.services.async.ApiServiceAsync
import com.dinari.api.services.async.ApiServiceAsyncImpl

class DinariClientAsyncImpl(private val clientOptions: ClientOptions) : DinariClientAsync {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val sync: DinariClient by lazy { DinariClientImpl(clientOptions) }

    private val withRawResponse: DinariClientAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val api: ApiServiceAsync by lazy { ApiServiceAsyncImpl(clientOptionsWithUserAgent) }

    override fun sync(): DinariClient = sync

    override fun withRawResponse(): DinariClientAsync.WithRawResponse = withRawResponse

    override fun api(): ApiServiceAsync = api

    override fun close() = clientOptions.httpClient.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        DinariClientAsync.WithRawResponse {

        private val api: ApiServiceAsync.WithRawResponse by lazy {
            ApiServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun api(): ApiServiceAsync.WithRawResponse = api
    }
}
