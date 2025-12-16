// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.v2.accounts.orders.stocks

import com.dinari.api.core.ClientOptions
import java.util.function.Consumer

class Eip155ServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    Eip155ServiceAsync {

    private val withRawResponse: Eip155ServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): Eip155ServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): Eip155ServiceAsync =
        Eip155ServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        Eip155ServiceAsync.WithRawResponse {

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): Eip155ServiceAsync.WithRawResponse =
            Eip155ServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )
    }
}
