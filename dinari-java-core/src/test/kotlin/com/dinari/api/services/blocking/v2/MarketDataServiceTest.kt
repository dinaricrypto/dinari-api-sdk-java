// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2

import com.dinari.api.client.okhttp.DinariOkHttpClient
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class MarketDataServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveMarketHours() {
        val client =
            DinariOkHttpClient.builder()
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val marketDataService = client.v2().marketData()

        val response = marketDataService.retrieveMarketHours()

        response.validate()
    }
}
