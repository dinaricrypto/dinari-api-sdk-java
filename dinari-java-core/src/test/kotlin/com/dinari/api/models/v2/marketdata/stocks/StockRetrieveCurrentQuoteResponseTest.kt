// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.marketdata.stocks

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class StockRetrieveCurrentQuoteResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val stockRetrieveCurrentQuoteResponse =
            StockRetrieveCurrentQuoteResponse.builder()
                .askPrice(0.0)
                .askSize(0.0)
                .bidPrice(0.0)
                .bidSize(0.0)
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        assertThat(stockRetrieveCurrentQuoteResponse.askPrice()).isEqualTo(0.0)
        assertThat(stockRetrieveCurrentQuoteResponse.askSize()).isEqualTo(0.0)
        assertThat(stockRetrieveCurrentQuoteResponse.bidPrice()).isEqualTo(0.0)
        assertThat(stockRetrieveCurrentQuoteResponse.bidSize()).isEqualTo(0.0)
        assertThat(stockRetrieveCurrentQuoteResponse.stockId())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(stockRetrieveCurrentQuoteResponse.timestamp())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val stockRetrieveCurrentQuoteResponse =
            StockRetrieveCurrentQuoteResponse.builder()
                .askPrice(0.0)
                .askSize(0.0)
                .bidPrice(0.0)
                .bidSize(0.0)
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val roundtrippedStockRetrieveCurrentQuoteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(stockRetrieveCurrentQuoteResponse),
                jacksonTypeRef<StockRetrieveCurrentQuoteResponse>(),
            )

        assertThat(roundtrippedStockRetrieveCurrentQuoteResponse)
            .isEqualTo(stockRetrieveCurrentQuoteResponse)
    }
}
