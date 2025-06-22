// File generated from our OpenAPI spec by Stainless.

package com.dinari.services.blocking.v2.marketdata.stocks

import com.dinari.TestServerExtension
import com.dinari.client.okhttp.DinariOkHttpClient
import com.dinari.models.v2.marketdata.stocks.splits.SplitListForStockParams
import com.dinari.models.v2.marketdata.stocks.splits.SplitListParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class SplitServiceTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun list() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val splitService = client.v2().marketData().stocks().splits()

        val stockSplits = splitService.list(SplitListParams.builder().page(1L).pageSize(1L).build())

        stockSplits.forEach { it.validate() }
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun listForStock() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val splitService = client.v2().marketData().stocks().splits()

        val stockSplits =
            splitService.listForStock(
                SplitListForStockParams.builder()
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .page(1L)
                    .pageSize(1L)
                    .build()
            )

        stockSplits.forEach { it.validate() }
    }
}
