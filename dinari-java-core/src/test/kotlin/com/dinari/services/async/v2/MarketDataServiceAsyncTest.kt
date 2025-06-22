// File generated from our OpenAPI spec by Stainless.

package com.dinari.services.async.v2

import com.dinari.TestServerExtension
import com.dinari.client.okhttp.DinariOkHttpClientAsync
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class MarketDataServiceAsyncTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieveMarketHours() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val marketDataServiceAsync = client.v2().marketData()

        val responseFuture = marketDataServiceAsync.retrieveMarketHours()

        val response = responseFuture.get()
        response.validate()
    }
}
