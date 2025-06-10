// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.accounts.orders

import com.dinari.api.core.ClientOptions
import com.dinari.api.services.blocking.v2.accounts.orders.stocks.Eip155Service
import com.dinari.api.services.blocking.v2.accounts.orders.stocks.Eip155ServiceImpl

class StockServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    StockService {

    private val withRawResponse: StockService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val eip155: Eip155Service by lazy { Eip155ServiceImpl(clientOptions) }

    override fun withRawResponse(): StockService.WithRawResponse = withRawResponse

    override fun eip155(): Eip155Service = eip155

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        StockService.WithRawResponse {

        private val eip155: Eip155Service.WithRawResponse by lazy {
            Eip155ServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun eip155(): Eip155Service.WithRawResponse = eip155
    }
}
