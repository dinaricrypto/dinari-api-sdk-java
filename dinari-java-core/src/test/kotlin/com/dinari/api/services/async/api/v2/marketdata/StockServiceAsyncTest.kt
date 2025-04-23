// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.api.v2.marketdata

import com.dinari.api.TestServerExtension
import com.dinari.api.client.okhttp.DinariOkHttpClientAsync
import com.dinari.api.models.api.v2.marketdata.stocks.StockListParams
import com.dinari.api.models.api.v2.marketdata.stocks.StockRetrieveDividendsParams
import com.dinari.api.models.api.v2.marketdata.stocks.StockRetrieveHistoricalPricesParams
import com.dinari.api.models.api.v2.marketdata.stocks.StockRetrieveNewsParams
import com.dinari.api.models.api.v2.marketdata.stocks.StockRetrieveQuoteParams
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
                .apiKey("My API Key")
                .build()
        val stockServiceAsync = client.api().v2().marketData().stocks()

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
                .apiKey("My API Key")
                .build()
        val stockServiceAsync = client.api().v2().marketData().stocks()

        val responseFuture =
            stockServiceAsync.retrieveDividends(
                StockRetrieveDividendsParams.builder().stockId("stock_id").build()
            )

        val response = responseFuture.get()
        response.forEach { it.validate() }
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieveHistoricalPrices() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val stockServiceAsync = client.api().v2().marketData().stocks()

        val responseFuture =
            stockServiceAsync.retrieveHistoricalPrices(
                StockRetrieveHistoricalPricesParams.builder()
                    .stockId("stock_id")
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
                .apiKey("My API Key")
                .build()
        val stockServiceAsync = client.api().v2().marketData().stocks()

        val responseFuture =
            stockServiceAsync.retrieveNews(
                StockRetrieveNewsParams.builder().stockId("stock_id").limit(1L).build()
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
                .apiKey("My API Key")
                .build()
        val stockServiceAsync = client.api().v2().marketData().stocks()

        val responseFuture =
            stockServiceAsync.retrieveQuote(
                StockRetrieveQuoteParams.builder().stockId("stock_id").build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
