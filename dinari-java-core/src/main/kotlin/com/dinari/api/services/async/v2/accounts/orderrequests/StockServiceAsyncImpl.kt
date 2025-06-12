// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.v2.accounts.orderrequests

import com.dinari.api.core.ClientOptions
import com.dinari.api.services.async.v2.accounts.orderrequests.stocks.Eip155ServiceAsync
import com.dinari.api.services.async.v2.accounts.orderrequests.stocks.Eip155ServiceAsyncImpl
import java.util.function.Consumer

class StockServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    StockServiceAsync {

    private val withRawResponse: StockServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val eip155: Eip155ServiceAsync by lazy { Eip155ServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): StockServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): StockServiceAsync =
        StockServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun eip155(): Eip155ServiceAsync = eip155

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        StockServiceAsync.WithRawResponse {

        private val eip155: Eip155ServiceAsync.WithRawResponse by lazy {
            Eip155ServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): StockServiceAsync.WithRawResponse =
            StockServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun eip155(): Eip155ServiceAsync.WithRawResponse = eip155
    }
}
