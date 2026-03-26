// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.v2.marketdata

import com.dinari.api.client.okhttp.DinariOkHttpClientAsync
import com.dinari.api.models.v2.marketdata.alloys.AlloyListParams
import com.dinari.api.models.v2.marketdata.alloys.AlloyRetrieveHistoricalPricesParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class AlloyServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            DinariOkHttpClientAsync.builder()
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val alloyServiceAsync = client.v2().marketData().alloys()

        val alloysFuture =
            alloyServiceAsync.list(
                AlloyListParams.builder()
                    .limit(20L)
                    .next("next")
                    .order(AlloyListParams.Order.ASC)
                    .previous("previous")
                    .addSymbol("string")
                    .build()
            )

        val alloys = alloysFuture.get()
        alloys.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveCurrentPrice() {
        val client =
            DinariOkHttpClientAsync.builder()
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val alloyServiceAsync = client.v2().marketData().alloys()

        val responseFuture =
            alloyServiceAsync.retrieveCurrentPrice("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveHistoricalPrices() {
        val client =
            DinariOkHttpClientAsync.builder()
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val alloyServiceAsync = client.v2().marketData().alloys()

        val responseFuture =
            alloyServiceAsync.retrieveHistoricalPrices(
                AlloyRetrieveHistoricalPricesParams.builder()
                    .alloyId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .timespan(AlloyRetrieveHistoricalPricesParams.Timespan.DAY)
                    .build()
            )

        val response = responseFuture.get()
        response.forEach { it.validate() }
    }
}
