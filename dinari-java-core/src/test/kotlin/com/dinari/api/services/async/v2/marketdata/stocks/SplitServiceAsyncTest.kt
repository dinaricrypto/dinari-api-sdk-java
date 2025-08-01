// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.v2.marketdata.stocks

import com.dinari.api.TestServerExtension
import com.dinari.api.client.okhttp.DinariOkHttpClientAsync
import com.dinari.api.models.v2.marketdata.stocks.splits.SplitListForStockParams
import com.dinari.api.models.v2.marketdata.stocks.splits.SplitListParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class SplitServiceAsyncTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun list() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val splitServiceAsync = client.v2().marketData().stocks().splits()

        val stockSplitsFuture =
            splitServiceAsync.list(SplitListParams.builder().page(1L).pageSize(1L).build())

        val stockSplits = stockSplitsFuture.get()
        stockSplits.forEach { it.validate() }
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun listForStock() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val splitServiceAsync = client.v2().marketData().stocks().splits()

        val stockSplitsFuture =
            splitServiceAsync.listForStock(
                SplitListForStockParams.builder()
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .page(1L)
                    .pageSize(1L)
                    .build()
            )

        val stockSplits = stockSplitsFuture.get()
        stockSplits.forEach { it.validate() }
    }
}
