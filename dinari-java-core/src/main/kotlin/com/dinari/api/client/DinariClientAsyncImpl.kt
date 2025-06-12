// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.client

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.getPackageVersion
import com.dinari.api.services.async.V2ServiceAsync
import com.dinari.api.services.async.V2ServiceAsyncImpl
import java.util.function.Consumer

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

    private val v2: V2ServiceAsync by lazy { V2ServiceAsyncImpl(clientOptionsWithUserAgent) }

    override fun sync(): DinariClient = sync

    override fun withRawResponse(): DinariClientAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): DinariClientAsync =
        DinariClientAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun v2(): V2ServiceAsync = v2

    override fun close() = clientOptions.httpClient.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        DinariClientAsync.WithRawResponse {

        private val v2: V2ServiceAsync.WithRawResponse by lazy {
            V2ServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): DinariClientAsync.WithRawResponse =
            DinariClientAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun v2(): V2ServiceAsync.WithRawResponse = v2
    }
}
