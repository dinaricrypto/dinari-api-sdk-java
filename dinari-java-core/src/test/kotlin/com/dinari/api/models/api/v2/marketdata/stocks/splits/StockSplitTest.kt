// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.api.v2.marketdata.stocks.splits

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.LocalDate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class StockSplitTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val stockSplit =
            StockSplit.builder()
                .id("1")
                .exDate(LocalDate.parse("2024-06-10"))
                .payableDate(LocalDate.parse("2024-06-07"))
                .recordDate(LocalDate.parse("2024-06-06"))
                .splitFrom(0.0)
                .splitTo(0.0)
                .status(StockSplit.Status.PENDING)
                .stockId("8")
                .build()

        assertThat(stockSplit.id()).isEqualTo("1")
        assertThat(stockSplit.exDate()).isEqualTo(LocalDate.parse("2024-06-10"))
        assertThat(stockSplit.payableDate()).isEqualTo(LocalDate.parse("2024-06-07"))
        assertThat(stockSplit.recordDate()).isEqualTo(LocalDate.parse("2024-06-06"))
        assertThat(stockSplit.splitFrom()).isEqualTo(0.0)
        assertThat(stockSplit.splitTo()).isEqualTo(0.0)
        assertThat(stockSplit.status()).isEqualTo(StockSplit.Status.PENDING)
        assertThat(stockSplit.stockId()).isEqualTo("8")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val stockSplit =
            StockSplit.builder()
                .id("1")
                .exDate(LocalDate.parse("2024-06-10"))
                .payableDate(LocalDate.parse("2024-06-07"))
                .recordDate(LocalDate.parse("2024-06-06"))
                .splitFrom(0.0)
                .splitTo(0.0)
                .status(StockSplit.Status.PENDING)
                .stockId("8")
                .build()

        val roundtrippedStockSplit =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(stockSplit),
                jacksonTypeRef<StockSplit>(),
            )

        assertThat(roundtrippedStockSplit).isEqualTo(stockSplit)
    }
}
