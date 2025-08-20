// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.client

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.getPackageVersion
import com.dinari.api.services.blocking.V2Service
import com.dinari.api.services.blocking.V2ServiceImpl
import java.util.function.Consumer

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

    private val v2: V2Service by lazy { V2ServiceImpl(clientOptionsWithUserAgent) }

    override fun async(): DinariClientAsync = async

    override fun withRawResponse(): DinariClient.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): DinariClient =
        DinariClientImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun v2(): V2Service = v2

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        DinariClient.WithRawResponse {

        private val v2: V2Service.WithRawResponse by lazy {
            V2ServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): DinariClient.WithRawResponse =
            DinariClientImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun v2(): V2Service.WithRawResponse = v2
    }
}
