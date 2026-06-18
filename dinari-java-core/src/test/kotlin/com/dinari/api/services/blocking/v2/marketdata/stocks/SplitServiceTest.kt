// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.marketdata.stocks

import com.dinari.api.client.okhttp.DinariOkHttpClient
import com.dinari.api.models.v2.marketdata.stocks.splits.SplitListForStockParams
import com.dinari.api.models.v2.marketdata.stocks.splits.SplitListParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class SplitServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            DinariOkHttpClient.builder()
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val splitService = client.v2().marketData().stocks().splits()

        val splits =
            splitService.list(
                SplitListParams.builder()
                    .limit(20L)
                    .next("next")
                    .order(SplitListParams.Order.ASC)
                    .previous("previous")
                    .build()
            )

        splits.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun listForStock() {
        val client =
            DinariOkHttpClient.builder()
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val splitService = client.v2().marketData().stocks().splits()

        val response =
            splitService.listForStock(
                SplitListForStockParams.builder()
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .limit(20L)
                    .next("next")
                    .order(SplitListForStockParams.Order.ASC)
                    .previous("previous")
                    .build()
            )

        response.validate()
    }
}
