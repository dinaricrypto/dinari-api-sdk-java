// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.marketdata.stocks

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class StockRetrieveCurrentPriceResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val stockRetrieveCurrentPriceResponse =
            StockRetrieveCurrentPriceResponse.builder()
                .price(0.0)
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
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

        assertThat(stockRetrieveCurrentPriceResponse.price()).isEqualTo(0.0)
        assertThat(stockRetrieveCurrentPriceResponse.stockId())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(stockRetrieveCurrentPriceResponse.timestamp())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(stockRetrieveCurrentPriceResponse.change()).contains(0.0)
        assertThat(stockRetrieveCurrentPriceResponse.changePercent()).contains(0.0)
        assertThat(stockRetrieveCurrentPriceResponse.close()).contains(0.0)
        assertThat(stockRetrieveCurrentPriceResponse.high()).contains(0.0)
        assertThat(stockRetrieveCurrentPriceResponse.low()).contains(0.0)
        assertThat(stockRetrieveCurrentPriceResponse.marketCap()).contains(0L)
        assertThat(stockRetrieveCurrentPriceResponse.open()).contains(0.0)
        assertThat(stockRetrieveCurrentPriceResponse.previousClose()).contains(0.0)
        assertThat(stockRetrieveCurrentPriceResponse.volume()).contains(0.0)
        assertThat(stockRetrieveCurrentPriceResponse.weightedSharesOutstanding()).contains(0L)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val stockRetrieveCurrentPriceResponse =
            StockRetrieveCurrentPriceResponse.builder()
                .price(0.0)
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
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

        val roundtrippedStockRetrieveCurrentPriceResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(stockRetrieveCurrentPriceResponse),
                jacksonTypeRef<StockRetrieveCurrentPriceResponse>(),
            )

        assertThat(roundtrippedStockRetrieveCurrentPriceResponse)
            .isEqualTo(stockRetrieveCurrentPriceResponse)
    }
}
