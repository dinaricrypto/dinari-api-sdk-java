// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.marketdata.stocks

import com.dinari.api.core.JsonValue
import com.dinari.api.core.jsonMapper
import com.dinari.api.errors.DinariInvalidDataException
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class StockListResponseTest {

    @Test
    fun ofStocks() {
        val stocks =
            listOf(
                StockListResponse.Stock.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .isFractionable(true)
                    .isTradable(true)
                    .name("name")
                    .symbol("symbol")
                    .addToken("string")
                    .cik("cik")
                    .compositeFigi("composite_figi")
                    .cusip("cusip")
                    .description("description")
                    .displayName("display_name")
                    .logoUrl("logo_url")
                    .build()
            )

        val stockListResponse = StockListResponse.ofStocks(stocks)

        assertThat(stockListResponse.stocks()).contains(stocks)
        assertThat(stockListResponse.paginatedStock()).isEmpty
    }

    @Test
    fun ofStocksRoundtrip() {
        val jsonMapper = jsonMapper()
        val stockListResponse =
            StockListResponse.ofStocks(
                listOf(
                    StockListResponse.Stock.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .isFractionable(true)
                        .isTradable(true)
                        .name("name")
                        .symbol("symbol")
                        .addToken("string")
                        .cik("cik")
                        .compositeFigi("composite_figi")
                        .cusip("cusip")
                        .description("description")
                        .displayName("display_name")
                        .logoUrl("logo_url")
                        .build()
                )
            )

        val roundtrippedStockListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(stockListResponse),
                jacksonTypeRef<StockListResponse>(),
            )

        assertThat(roundtrippedStockListResponse).isEqualTo(stockListResponse)
    }

    @Test
    fun ofPaginatedStock() {
        val paginatedStock =
            StockListResponse.PaginatedStockResponse.builder()
                .addData(
                    StockListResponse.PaginatedStockResponse.Data.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .isFractionable(true)
                        .isTradable(true)
                        .name("name")
                        .symbol("symbol")
                        .addToken("string")
                        .cik("cik")
                        .compositeFigi("composite_figi")
                        .cusip("cusip")
                        .description("description")
                        .displayName("display_name")
                        .logoUrl("logo_url")
                        .build()
                )
                .paginationMetadata(
                    StockListResponse.PaginatedStockResponse.PaginationMetadata.builder()
                        .next("next")
                        .previous("previous")
                        .build()
                )
                ._sv(StockListResponse.PaginatedStockResponse._Sv.PAGINATED_STOCK_RESPONSE_V1)
                .build()

        val stockListResponse = StockListResponse.ofPaginatedStock(paginatedStock)

        assertThat(stockListResponse.stocks()).isEmpty
        assertThat(stockListResponse.paginatedStock()).contains(paginatedStock)
    }

    @Test
    fun ofPaginatedStockRoundtrip() {
        val jsonMapper = jsonMapper()
        val stockListResponse =
            StockListResponse.ofPaginatedStock(
                StockListResponse.PaginatedStockResponse.builder()
                    .addData(
                        StockListResponse.PaginatedStockResponse.Data.builder()
                            .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .isFractionable(true)
                            .isTradable(true)
                            .name("name")
                            .symbol("symbol")
                            .addToken("string")
                            .cik("cik")
                            .compositeFigi("composite_figi")
                            .cusip("cusip")
                            .description("description")
                            .displayName("display_name")
                            .logoUrl("logo_url")
                            .build()
                    )
                    .paginationMetadata(
                        StockListResponse.PaginatedStockResponse.PaginationMetadata.builder()
                            .next("next")
                            .previous("previous")
                            .build()
                    )
                    ._sv(StockListResponse.PaginatedStockResponse._Sv.PAGINATED_STOCK_RESPONSE_V1)
                    .build()
            )

        val roundtrippedStockListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(stockListResponse),
                jacksonTypeRef<StockListResponse>(),
            )

        assertThat(roundtrippedStockListResponse).isEqualTo(stockListResponse)
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
        val stockListResponse =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<StockListResponse>())

        val e = assertThrows<DinariInvalidDataException> { stockListResponse.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
