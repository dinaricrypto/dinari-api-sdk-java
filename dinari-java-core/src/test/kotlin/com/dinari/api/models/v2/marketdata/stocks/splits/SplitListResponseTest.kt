// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.marketdata.stocks.splits

import com.dinari.api.core.JsonValue
import com.dinari.api.core.jsonMapper
import com.dinari.api.errors.DinariInvalidDataException
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.LocalDate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class SplitListResponseTest {

    @Test
    fun ofStockSplits() {
        val stockSplits =
            listOf(
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

        val splitListResponse = SplitListResponse.ofStockSplits(stockSplits)

        assertThat(splitListResponse.stockSplits()).contains(stockSplits)
        assertThat(splitListResponse.paginatedStockSplit()).isEmpty
    }

    @Test
    fun ofStockSplitsRoundtrip() {
        val jsonMapper = jsonMapper()
        val splitListResponse =
            SplitListResponse.ofStockSplits(
                listOf(
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
            )

        val roundtrippedSplitListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(splitListResponse),
                jacksonTypeRef<SplitListResponse>(),
            )

        assertThat(roundtrippedSplitListResponse).isEqualTo(splitListResponse)
    }

    @Test
    fun ofPaginatedStockSplit() {
        val paginatedStockSplit =
            SplitListResponse.PaginatedStockSplitResponse.builder()
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
                    SplitListResponse.PaginatedStockSplitResponse.PaginationMetadata.builder()
                        .next("next")
                        .previous("previous")
                        .build()
                )
                ._sv(
                    SplitListResponse.PaginatedStockSplitResponse._Sv
                        .PAGINATED_STOCK_SPLIT_RESPONSE_V1
                )
                .build()

        val splitListResponse = SplitListResponse.ofPaginatedStockSplit(paginatedStockSplit)

        assertThat(splitListResponse.stockSplits()).isEmpty
        assertThat(splitListResponse.paginatedStockSplit()).contains(paginatedStockSplit)
    }

    @Test
    fun ofPaginatedStockSplitRoundtrip() {
        val jsonMapper = jsonMapper()
        val splitListResponse =
            SplitListResponse.ofPaginatedStockSplit(
                SplitListResponse.PaginatedStockSplitResponse.builder()
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
                        SplitListResponse.PaginatedStockSplitResponse.PaginationMetadata.builder()
                            .next("next")
                            .previous("previous")
                            .build()
                    )
                    ._sv(
                        SplitListResponse.PaginatedStockSplitResponse._Sv
                            .PAGINATED_STOCK_SPLIT_RESPONSE_V1
                    )
                    .build()
            )

        val roundtrippedSplitListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(splitListResponse),
                jacksonTypeRef<SplitListResponse>(),
            )

        assertThat(roundtrippedSplitListResponse).isEqualTo(splitListResponse)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val splitListResponse =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<SplitListResponse>())

        val e = assertThrows<DinariInvalidDataException> { splitListResponse.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
