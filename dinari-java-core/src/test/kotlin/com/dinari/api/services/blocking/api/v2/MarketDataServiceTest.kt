// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.api.v2

import com.dinari.api.TestServerExtension
import com.dinari.api.client.okhttp.DinariOkHttpClient
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class MarketDataServiceTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun getMarketHours() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .secret("My Secret")
                .build()
        val marketDataService = client.api().v2().marketData()

        val response = marketDataService.getMarketHours()

        response.validate()
    }
}
