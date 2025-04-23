// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.api.v2.marketdata

import com.dinari.api.TestServerExtension
import com.dinari.api.client.okhttp.DinariOkHttpClient
import com.dinari.api.models.api.v2.marketdata.stocks.StockListParams
import com.dinari.api.models.api.v2.marketdata.stocks.StockRetrieveDividendsParams
import com.dinari.api.models.api.v2.marketdata.stocks.StockRetrieveHistoricalPricesParams
import com.dinari.api.models.api.v2.marketdata.stocks.StockRetrieveNewsParams
import com.dinari.api.models.api.v2.marketdata.stocks.StockRetrieveQuoteParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class StockServiceTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun list() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val stockService = client.api().v2().marketData().stocks()

        val stocks =
            stockService.list(
                StockListParams.builder().page(1L).pageSize(1L).addSymbol("string").build()
            )

        stocks.forEach { it.validate() }
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieveDividends() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val stockService = client.api().v2().marketData().stocks()

        val response =
            stockService.retrieveDividends(
                StockRetrieveDividendsParams.builder().stockId("stock_id").build()
            )

        response.forEach { it.validate() }
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieveHistoricalPrices() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val stockService = client.api().v2().marketData().stocks()

        val response =
            stockService.retrieveHistoricalPrices(
                StockRetrieveHistoricalPricesParams.builder()
                    .stockId("stock_id")
                    .timespan(StockRetrieveHistoricalPricesParams.Timespan.DAY)
                    .build()
            )

        response.forEach { it.validate() }
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieveNews() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val stockService = client.api().v2().marketData().stocks()

        val response =
            stockService.retrieveNews(
                StockRetrieveNewsParams.builder().stockId("stock_id").limit(1L).build()
            )

        response.forEach { it.validate() }
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieveQuote() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val stockService = client.api().v2().marketData().stocks()

        val response =
            stockService.retrieveQuote(
                StockRetrieveQuoteParams.builder().stockId("stock_id").build()
            )

        response.validate()
    }
}
