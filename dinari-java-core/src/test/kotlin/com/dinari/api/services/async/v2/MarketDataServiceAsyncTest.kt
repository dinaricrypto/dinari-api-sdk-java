// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.v2

import com.dinari.api.TestServerExtension
import com.dinari.api.client.okhttp.DinariOkHttpClientAsync
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class MarketDataServiceAsyncTest {

    @Disabled("Prism tests are disabled")
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
