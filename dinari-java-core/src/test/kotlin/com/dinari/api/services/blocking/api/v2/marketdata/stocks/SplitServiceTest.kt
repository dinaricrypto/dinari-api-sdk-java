// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.api.v2.marketdata.stocks

import com.dinari.api.TestServerExtension
import com.dinari.api.client.okhttp.DinariOkHttpClient
import com.dinari.api.models.api.v2.marketdata.stocks.splits.SplitListParams
import com.dinari.api.models.api.v2.marketdata.stocks.splits.SplitRetrieveParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class SplitServiceTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieve() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val splitService = client.api().v2().marketData().stocks().splits()

        val stockSplits =
            splitService.retrieve(
                SplitRetrieveParams.builder().stockId("stock_id").page(1L).pageSize(1L).build()
            )

        stockSplits.forEach { it.validate() }
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun list() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val splitService = client.api().v2().marketData().stocks().splits()

        val stockSplits = splitService.list(SplitListParams.builder().page(1L).pageSize(1L).build())

        stockSplits.forEach { it.validate() }
    }
}
