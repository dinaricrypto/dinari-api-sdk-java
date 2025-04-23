// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.api.v2.marketdata.stocks

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class StockRetrieveHistoricalPricesResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val stockRetrieveHistoricalPricesResponse =
            StockRetrieveHistoricalPricesResponse.builder()
                .close(0.0)
                .high(0.0)
                .low(0.0)
                .open(0.0)
                .timestamp(0L)
                .build()

        assertThat(stockRetrieveHistoricalPricesResponse.close()).isEqualTo(0.0)
        assertThat(stockRetrieveHistoricalPricesResponse.high()).isEqualTo(0.0)
        assertThat(stockRetrieveHistoricalPricesResponse.low()).isEqualTo(0.0)
        assertThat(stockRetrieveHistoricalPricesResponse.open()).isEqualTo(0.0)
        assertThat(stockRetrieveHistoricalPricesResponse.timestamp()).isEqualTo(0L)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val stockRetrieveHistoricalPricesResponse =
            StockRetrieveHistoricalPricesResponse.builder()
                .close(0.0)
                .high(0.0)
                .low(0.0)
                .open(0.0)
                .timestamp(0L)
                .build()

        val roundtrippedStockRetrieveHistoricalPricesResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(stockRetrieveHistoricalPricesResponse),
                jacksonTypeRef<StockRetrieveHistoricalPricesResponse>(),
            )

        assertThat(roundtrippedStockRetrieveHistoricalPricesResponse)
            .isEqualTo(stockRetrieveHistoricalPricesResponse)
    }
}
