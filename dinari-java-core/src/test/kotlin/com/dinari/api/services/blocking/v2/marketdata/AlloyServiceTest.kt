// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.marketdata

import com.dinari.api.client.okhttp.DinariOkHttpClient
import com.dinari.api.models.v2.marketdata.alloys.AlloyListParams
import com.dinari.api.models.v2.marketdata.alloys.AlloyRetrieveHistoricalPricesParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class AlloyServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            DinariOkHttpClient.builder()
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val alloyService = client.v2().marketData().alloys()

        val alloys =
            alloyService.list(
                AlloyListParams.builder()
                    .limit(20L)
                    .next("next")
                    .order(AlloyListParams.Order.ASC)
                    .previous("previous")
                    .addSymbol("string")
                    .build()
            )

        alloys.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveCurrentPrice() {
        val client =
            DinariOkHttpClient.builder()
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val alloyService = client.v2().marketData().alloys()

        val response = alloyService.retrieveCurrentPrice("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveHistoricalPrices() {
        val client =
            DinariOkHttpClient.builder()
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val alloyService = client.v2().marketData().alloys()

        val response =
            alloyService.retrieveHistoricalPrices(
                AlloyRetrieveHistoricalPricesParams.builder()
                    .alloyId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .timespan(AlloyRetrieveHistoricalPricesParams.Timespan.DAY)
                    .build()
            )

        response.forEach { it.validate() }
    }
}
