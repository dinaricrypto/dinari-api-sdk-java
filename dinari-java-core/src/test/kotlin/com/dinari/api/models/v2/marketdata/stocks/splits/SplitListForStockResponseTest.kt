// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.marketdata.stocks.splits

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.LocalDate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SplitListForStockResponseTest {

    @Test
    fun create() {
        val splitListForStockResponse =
            SplitListForStockResponse.builder()
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
                    SplitListForStockResponse.PaginationMetadata.builder()
                        .next("next")
                        .previous("previous")
                        .build()
                )
                ._sv(SplitListForStockResponse._Sv.PAGINATED_STOCK_SPLIT_RESPONSE_V1)
                .build()

        assertThat(splitListForStockResponse.data())
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
        assertThat(splitListForStockResponse.paginationMetadata())
            .isEqualTo(
                SplitListForStockResponse.PaginationMetadata.builder()
                    .next("next")
                    .previous("previous")
                    .build()
            )
        assertThat(splitListForStockResponse._sv())
            .contains(SplitListForStockResponse._Sv.PAGINATED_STOCK_SPLIT_RESPONSE_V1)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val splitListForStockResponse =
            SplitListForStockResponse.builder()
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
                    SplitListForStockResponse.PaginationMetadata.builder()
                        .next("next")
                        .previous("previous")
                        .build()
                )
                ._sv(SplitListForStockResponse._Sv.PAGINATED_STOCK_SPLIT_RESPONSE_V1)
                .build()

        val roundtrippedSplitListForStockResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(splitListForStockResponse),
                jacksonTypeRef<SplitListForStockResponse>(),
            )

        assertThat(roundtrippedSplitListForStockResponse).isEqualTo(splitListForStockResponse)
    }
}
