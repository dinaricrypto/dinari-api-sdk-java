// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking

import com.dinari.api.core.ClientOptions
import com.dinari.api.services.blocking.v2.AccountService
import com.dinari.api.services.blocking.v2.AccountServiceImpl
import com.dinari.api.services.blocking.v2.EntityService
import com.dinari.api.services.blocking.v2.EntityServiceImpl
import com.dinari.api.services.blocking.v2.MarketDataService
import com.dinari.api.services.blocking.v2.MarketDataServiceImpl

class V2ServiceImpl internal constructor(private val clientOptions: ClientOptions) : V2Service {

    private val withRawResponse: V2Service.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val marketData: MarketDataService by lazy { MarketDataServiceImpl(clientOptions) }

    private val entities: EntityService by lazy { EntityServiceImpl(clientOptions) }

    private val accounts: AccountService by lazy { AccountServiceImpl(clientOptions) }

    override fun withRawResponse(): V2Service.WithRawResponse = withRawResponse

    override fun marketData(): MarketDataService = marketData

    override fun entities(): EntityService = entities

    override fun accounts(): AccountService = accounts

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        V2Service.WithRawResponse {

        private val marketData: MarketDataService.WithRawResponse by lazy {
            MarketDataServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val entities: EntityService.WithRawResponse by lazy {
            EntityServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val accounts: AccountService.WithRawResponse by lazy {
            AccountServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun marketData(): MarketDataService.WithRawResponse = marketData

        override fun entities(): EntityService.WithRawResponse = entities

        override fun accounts(): AccountService.WithRawResponse = accounts
    }
}
