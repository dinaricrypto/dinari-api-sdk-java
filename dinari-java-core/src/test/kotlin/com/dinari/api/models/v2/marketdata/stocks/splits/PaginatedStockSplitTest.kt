// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.marketdata.stocks.splits

import com.dinari.api.core.jsonMapper
import com.dinari.api.models.v2.marketdata.alloys.PaginationMetadata
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.LocalDate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PaginatedStockSplitTest {

    @Test
    fun create() {
        val paginatedStockSplit =
            PaginatedStockSplit.builder()
                .addData(
                    StockSplit.builder()
                        .id("8e3ad59e-a4fa-48ab-9cc2-0a296aa670a6")
                        .exDate(LocalDate.parse("2024-06-10"))
                        .payableDate(LocalDate.parse("2024-06-07"))
                        .recordDate(LocalDate.parse("2024-06-06"))
                        .splitFrom(0.0)
                        .splitTo(0.0)
                        .status(StockSplit.Status.PENDING)
                        .stockId("60cc8f91-21d0-4975-bb81-3d737fc2f923")
                        .build()
                )
                .paginationMetadata(
                    PaginationMetadata.builder().next("next").previous("previous").build()
                )
                ._sv(PaginatedStockSplit._Sv.PAGINATED_STOCK_SPLIT_RESPONSE_V1)
                .build()

        assertThat(paginatedStockSplit.data())
            .containsExactly(
                StockSplit.builder()
                    .id("8e3ad59e-a4fa-48ab-9cc2-0a296aa670a6")
                    .exDate(LocalDate.parse("2024-06-10"))
                    .payableDate(LocalDate.parse("2024-06-07"))
                    .recordDate(LocalDate.parse("2024-06-06"))
                    .splitFrom(0.0)
                    .splitTo(0.0)
                    .status(StockSplit.Status.PENDING)
                    .stockId("60cc8f91-21d0-4975-bb81-3d737fc2f923")
                    .build()
            )
        assertThat(paginatedStockSplit.paginationMetadata())
            .isEqualTo(PaginationMetadata.builder().next("next").previous("previous").build())
        assertThat(paginatedStockSplit._sv())
            .contains(PaginatedStockSplit._Sv.PAGINATED_STOCK_SPLIT_RESPONSE_V1)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val paginatedStockSplit =
            PaginatedStockSplit.builder()
                .addData(
                    StockSplit.builder()
                        .id("8e3ad59e-a4fa-48ab-9cc2-0a296aa670a6")
                        .exDate(LocalDate.parse("2024-06-10"))
                        .payableDate(LocalDate.parse("2024-06-07"))
                        .recordDate(LocalDate.parse("2024-06-06"))
                        .splitFrom(0.0)
                        .splitTo(0.0)
                        .status(StockSplit.Status.PENDING)
                        .stockId("60cc8f91-21d0-4975-bb81-3d737fc2f923")
                        .build()
                )
                .paginationMetadata(
                    PaginationMetadata.builder().next("next").previous("previous").build()
                )
                ._sv(PaginatedStockSplit._Sv.PAGINATED_STOCK_SPLIT_RESPONSE_V1)
                .build()

        val roundtrippedPaginatedStockSplit =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(paginatedStockSplit),
                jacksonTypeRef<PaginatedStockSplit>(),
            )

        assertThat(roundtrippedPaginatedStockSplit).isEqualTo(paginatedStockSplit)
    }
}
