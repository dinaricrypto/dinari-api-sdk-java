// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.client

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.getPackageVersion
import com.dinari.api.services.blocking.ApiService
import com.dinari.api.services.blocking.ApiServiceImpl

class DinariClientImpl(private val clientOptions: ClientOptions) : DinariClient {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val async: DinariClientAsync by lazy { DinariClientAsyncImpl(clientOptions) }

    private val withRawResponse: DinariClient.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val api: ApiService by lazy { ApiServiceImpl(clientOptionsWithUserAgent) }

    override fun async(): DinariClientAsync = async

    override fun withRawResponse(): DinariClient.WithRawResponse = withRawResponse

    override fun api(): ApiService = api

    override fun close() = clientOptions.httpClient.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        DinariClient.WithRawResponse {

        private val api: ApiService.WithRawResponse by lazy {
            ApiServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun api(): ApiService.WithRawResponse = api
    }
}
