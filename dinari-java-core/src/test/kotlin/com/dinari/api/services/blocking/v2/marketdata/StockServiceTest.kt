// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.marketdata

import com.dinari.api.client.okhttp.DinariOkHttpClient
import com.dinari.api.models.v2.marketdata.stocks.StockListParams
import com.dinari.api.models.v2.marketdata.stocks.StockRetrieveCurrentQuoteParams
import com.dinari.api.models.v2.marketdata.stocks.StockRetrieveHistoricalPricesParams
import com.dinari.api.models.v2.marketdata.stocks.StockRetrieveNewsParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class StockServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            DinariOkHttpClient.builder()
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val stockService = client.v2().marketData().stocks()

        val stocks =
            stockService.list(
                StockListParams.builder()
                    .limit(20L)
                    .next("next")
                    .order(StockListParams.Order.ASC)
                    .page(1L)
                    .pageSize(1L)
                    .previous("previous")
                    .addSymbol("string")
                    .build()
            )

        stocks.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveCurrentPrice() {
        val client =
            DinariOkHttpClient.builder()
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val stockService = client.v2().marketData().stocks()

        val response = stockService.retrieveCurrentPrice("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveCurrentQuote() {
        val client =
            DinariOkHttpClient.builder()
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val stockService = client.v2().marketData().stocks()

        val response =
            stockService.retrieveCurrentQuote(
                StockRetrieveCurrentQuoteParams.builder()
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .feed(StockRetrieveCurrentQuoteParams.Feed.SIP)
                    .xApiVersion("X-API-Version")
                    .build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveDividends() {
        val client =
            DinariOkHttpClient.builder()
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val stockService = client.v2().marketData().stocks()

        val response = stockService.retrieveDividends("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        response.forEach { it.validate() }
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveHistoricalPrices() {
        val client =
            DinariOkHttpClient.builder()
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

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveNews() {
        val client =
            DinariOkHttpClient.builder()
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
