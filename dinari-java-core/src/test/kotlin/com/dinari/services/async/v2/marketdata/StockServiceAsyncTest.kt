// File generated from our OpenAPI spec by Stainless.

package com.dinari.services.async.v2.marketdata

import com.dinari.TestServerExtension
import com.dinari.client.okhttp.DinariOkHttpClientAsync
import com.dinari.models.v2.marketdata.stocks.StockListParams
import com.dinari.models.v2.marketdata.stocks.StockRetrieveHistoricalPricesParams
import com.dinari.models.v2.marketdata.stocks.StockRetrieveNewsParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class StockServiceAsyncTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun list() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val stockServiceAsync = client.v2().marketData().stocks()

        val stocksFuture =
            stockServiceAsync.list(
                StockListParams.builder().page(1L).pageSize(1L).addSymbol("string").build()
            )

        val stocks = stocksFuture.get()
        stocks.forEach { it.validate() }
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieveDividends() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val stockServiceAsync = client.v2().marketData().stocks()

        val responseFuture =
            stockServiceAsync.retrieveDividends("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        val response = responseFuture.get()
        response.forEach { it.validate() }
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieveHistoricalPrices() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val stockServiceAsync = client.v2().marketData().stocks()

        val responseFuture =
            stockServiceAsync.retrieveHistoricalPrices(
                StockRetrieveHistoricalPricesParams.builder()
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .timespan(StockRetrieveHistoricalPricesParams.Timespan.DAY)
                    .build()
            )

        val response = responseFuture.get()
        response.forEach { it.validate() }
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieveNews() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val stockServiceAsync = client.v2().marketData().stocks()

        val responseFuture =
            stockServiceAsync.retrieveNews(
                StockRetrieveNewsParams.builder()
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .limit(1L)
                    .build()
            )

        val response = responseFuture.get()
        response.forEach { it.validate() }
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieveQuote() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val stockServiceAsync = client.v2().marketData().stocks()

        val responseFuture = stockServiceAsync.retrieveQuote("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        val response = responseFuture.get()
        response.validate()
    }
}
