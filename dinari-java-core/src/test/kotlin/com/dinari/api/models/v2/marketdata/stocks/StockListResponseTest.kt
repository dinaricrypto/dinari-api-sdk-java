// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.marketdata.stocks

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StockListResponseTest {

    @Test
    fun create() {
        val stockListResponse =
            StockListResponse.builder()
                .addData(
                    StockListResponse.Data.builder()
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
                    StockListResponse.PaginationMetadata.builder()
                        .next("next")
                        .previous("previous")
                        .build()
                )
                ._sv(StockListResponse._Sv.PAGINATED_STOCK_RESPONSE_V1)
                .build()

        assertThat(stockListResponse.data())
            .containsExactly(
                StockListResponse.Data.builder()
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
        assertThat(stockListResponse.paginationMetadata())
            .isEqualTo(
                StockListResponse.PaginationMetadata.builder()
                    .next("next")
                    .previous("previous")
                    .build()
            )
        assertThat(stockListResponse._sv())
            .contains(StockListResponse._Sv.PAGINATED_STOCK_RESPONSE_V1)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val stockListResponse =
            StockListResponse.builder()
                .addData(
                    StockListResponse.Data.builder()
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
                    StockListResponse.PaginationMetadata.builder()
                        .next("next")
                        .previous("previous")
                        .build()
                )
                ._sv(StockListResponse._Sv.PAGINATED_STOCK_RESPONSE_V1)
                .build()

        val roundtrippedStockListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(stockListResponse),
                jacksonTypeRef<StockListResponse>(),
            )

        assertThat(roundtrippedStockListResponse).isEqualTo(stockListResponse)
    }
}
