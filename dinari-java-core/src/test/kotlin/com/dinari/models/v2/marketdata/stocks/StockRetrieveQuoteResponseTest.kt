// File generated from our OpenAPI spec by Stainless.

package com.dinari.models.v2.marketdata.stocks

import com.dinari.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class StockRetrieveQuoteResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val stockRetrieveQuoteResponse =
            StockRetrieveQuoteResponse.builder()
                .price(0.0)
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .change(0.0)
                .changePercent(0.0)
                .close(0.0)
                .high(0.0)
                .low(0.0)
                .marketCap(0L)
                .open(0.0)
                .previousClose(0.0)
                .volume(0.0)
                .weightedSharesOutstanding(0L)
                .build()

        assertThat(stockRetrieveQuoteResponse.price()).isEqualTo(0.0)
        assertThat(stockRetrieveQuoteResponse.stockId())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(stockRetrieveQuoteResponse.change()).contains(0.0)
        assertThat(stockRetrieveQuoteResponse.changePercent()).contains(0.0)
        assertThat(stockRetrieveQuoteResponse.close()).contains(0.0)
        assertThat(stockRetrieveQuoteResponse.high()).contains(0.0)
        assertThat(stockRetrieveQuoteResponse.low()).contains(0.0)
        assertThat(stockRetrieveQuoteResponse.marketCap()).contains(0L)
        assertThat(stockRetrieveQuoteResponse.open()).contains(0.0)
        assertThat(stockRetrieveQuoteResponse.previousClose()).contains(0.0)
        assertThat(stockRetrieveQuoteResponse.volume()).contains(0.0)
        assertThat(stockRetrieveQuoteResponse.weightedSharesOutstanding()).contains(0L)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val stockRetrieveQuoteResponse =
            StockRetrieveQuoteResponse.builder()
                .price(0.0)
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .change(0.0)
                .changePercent(0.0)
                .close(0.0)
                .high(0.0)
                .low(0.0)
                .marketCap(0L)
                .open(0.0)
                .previousClose(0.0)
                .volume(0.0)
                .weightedSharesOutstanding(0L)
                .build()

        val roundtrippedStockRetrieveQuoteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(stockRetrieveQuoteResponse),
                jacksonTypeRef<StockRetrieveQuoteResponse>(),
            )

        assertThat(roundtrippedStockRetrieveQuoteResponse).isEqualTo(stockRetrieveQuoteResponse)
    }
}
