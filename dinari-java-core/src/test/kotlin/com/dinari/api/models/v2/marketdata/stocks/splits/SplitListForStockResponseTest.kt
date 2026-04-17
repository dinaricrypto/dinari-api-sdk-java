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

internal class SplitListForStockResponseTest {

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

        val splitListForStockResponse = SplitListForStockResponse.ofStockSplits(stockSplits)

        assertThat(splitListForStockResponse.stockSplits()).contains(stockSplits)
        assertThat(splitListForStockResponse.paginatedStockSplit()).isEmpty
    }

    @Test
    fun ofStockSplitsRoundtrip() {
        val jsonMapper = jsonMapper()
        val splitListForStockResponse =
            SplitListForStockResponse.ofStockSplits(
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

        val roundtrippedSplitListForStockResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(splitListForStockResponse),
                jacksonTypeRef<SplitListForStockResponse>(),
            )

        assertThat(roundtrippedSplitListForStockResponse).isEqualTo(splitListForStockResponse)
    }

    @Test
    fun ofPaginatedStockSplit() {
        val paginatedStockSplit =
            SplitListForStockResponse.PaginatedStockSplitResponse.builder()
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
                    SplitListForStockResponse.PaginatedStockSplitResponse.PaginationMetadata
                        .builder()
                        .next("next")
                        .previous("previous")
                        .build()
                )
                ._sv(
                    SplitListForStockResponse.PaginatedStockSplitResponse._Sv
                        .PAGINATED_STOCK_SPLIT_RESPONSE_V1
                )
                .build()

        val splitListForStockResponse =
            SplitListForStockResponse.ofPaginatedStockSplit(paginatedStockSplit)

        assertThat(splitListForStockResponse.stockSplits()).isEmpty
        assertThat(splitListForStockResponse.paginatedStockSplit()).contains(paginatedStockSplit)
    }

    @Test
    fun ofPaginatedStockSplitRoundtrip() {
        val jsonMapper = jsonMapper()
        val splitListForStockResponse =
            SplitListForStockResponse.ofPaginatedStockSplit(
                SplitListForStockResponse.PaginatedStockSplitResponse.builder()
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
                        SplitListForStockResponse.PaginatedStockSplitResponse.PaginationMetadata
                            .builder()
                            .next("next")
                            .previous("previous")
                            .build()
                    )
                    ._sv(
                        SplitListForStockResponse.PaginatedStockSplitResponse._Sv
                            .PAGINATED_STOCK_SPLIT_RESPONSE_V1
                    )
                    .build()
            )

        val roundtrippedSplitListForStockResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(splitListForStockResponse),
                jacksonTypeRef<SplitListForStockResponse>(),
            )

        assertThat(roundtrippedSplitListForStockResponse).isEqualTo(splitListForStockResponse)
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
        val splitListForStockResponse =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<SplitListForStockResponse>())

        val e = assertThrows<DinariInvalidDataException> { splitListForStockResponse.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
