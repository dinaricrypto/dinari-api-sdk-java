// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async

import com.dinari.api.core.ClientOptions
import com.dinari.api.services.async.v2.AccountServiceAsync
import com.dinari.api.services.async.v2.AccountServiceAsyncImpl
import com.dinari.api.services.async.v2.EntityServiceAsync
import com.dinari.api.services.async.v2.EntityServiceAsyncImpl
import com.dinari.api.services.async.v2.MarketDataServiceAsync
import com.dinari.api.services.async.v2.MarketDataServiceAsyncImpl
import java.util.function.Consumer

class V2ServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    V2ServiceAsync {

    private val withRawResponse: V2ServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val marketData: MarketDataServiceAsync by lazy {
        MarketDataServiceAsyncImpl(clientOptions)
    }

    private val entities: EntityServiceAsync by lazy { EntityServiceAsyncImpl(clientOptions) }

    private val accounts: AccountServiceAsync by lazy { AccountServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): V2ServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): V2ServiceAsync =
        V2ServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun marketData(): MarketDataServiceAsync = marketData

    override fun entities(): EntityServiceAsync = entities

    override fun accounts(): AccountServiceAsync = accounts

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        V2ServiceAsync.WithRawResponse {

        private val marketData: MarketDataServiceAsync.WithRawResponse by lazy {
            MarketDataServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val entities: EntityServiceAsync.WithRawResponse by lazy {
            EntityServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val accounts: AccountServiceAsync.WithRawResponse by lazy {
            AccountServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): V2ServiceAsync.WithRawResponse =
            V2ServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun marketData(): MarketDataServiceAsync.WithRawResponse = marketData

        override fun entities(): EntityServiceAsync.WithRawResponse = entities

        override fun accounts(): AccountServiceAsync.WithRawResponse = accounts
    }
}
