// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.marketdata

import com.dinari.api.TestServerExtension
import com.dinari.api.client.okhttp.DinariOkHttpClient
import com.dinari.api.models.v2.marketdata.stocks.StockListParams
import com.dinari.api.models.v2.marketdata.stocks.StockRetrieveHistoricalPricesParams
import com.dinari.api.models.v2.marketdata.stocks.StockRetrieveNewsParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class StockServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun list() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val stockService = client.v2().marketData().stocks()

        val stocks =
            stockService.list(
                StockListParams.builder().page(1L).pageSize(1L).addSymbol("string").build()
            )

        stocks.forEach { it.validate() }
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieveCurrentPrice() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val stockService = client.v2().marketData().stocks()

        val response = stockService.retrieveCurrentPrice("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        response.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieveCurrentQuote() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val stockService = client.v2().marketData().stocks()

        val response = stockService.retrieveCurrentQuote("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        response.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieveDividends() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val stockService = client.v2().marketData().stocks()

        val response = stockService.retrieveDividends("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        response.forEach { it.validate() }
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieveHistoricalPrices() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val stockService = client.v2().marketData().stocks()

        val response =
            stockService.retrieveHistoricalPrices(
                StockRetrieveHistoricalPricesParams.builder()
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .timespan(StockRetrieveHistoricalPricesParams.Timespan.DAY)
                    .build()
            )

        response.forEach { it.validate() }
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieveNews() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val stockService = client.v2().marketData().stocks()

        val response =
            stockService.retrieveNews(
                StockRetrieveNewsParams.builder()
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .limit(1L)
                    .build()
            )

        response.forEach { it.validate() }
    }
}
