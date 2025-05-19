// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.api.v2

import com.dinari.api.TestServerExtension
import com.dinari.api.client.okhttp.DinariOkHttpClientAsync
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class MarketDataServiceAsyncTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun getMarketHours() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .secret("My Secret")
                .build()
        val marketDataServiceAsync = client.api().v2().marketData()

        val responseFuture = marketDataServiceAsync.getMarketHours()

        val response = responseFuture.get()
        response.validate()
    }
}
