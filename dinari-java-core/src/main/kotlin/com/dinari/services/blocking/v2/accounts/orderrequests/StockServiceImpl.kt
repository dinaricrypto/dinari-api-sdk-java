// File generated from our OpenAPI spec by Stainless.

package com.dinari.services.blocking.v2.accounts.orderrequests

import com.dinari.core.ClientOptions
import com.dinari.services.blocking.v2.accounts.orderrequests.stocks.Eip155Service
import com.dinari.services.blocking.v2.accounts.orderrequests.stocks.Eip155ServiceImpl
import java.util.function.Consumer

class StockServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    StockService {

    private val withRawResponse: StockService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val eip155: Eip155Service by lazy { Eip155ServiceImpl(clientOptions) }

    override fun withRawResponse(): StockService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): StockService =
        StockServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun eip155(): Eip155Service = eip155

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        StockService.WithRawResponse {

        private val eip155: Eip155Service.WithRawResponse by lazy {
            Eip155ServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): StockService.WithRawResponse =
            StockServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun eip155(): Eip155Service.WithRawResponse = eip155
    }
}
