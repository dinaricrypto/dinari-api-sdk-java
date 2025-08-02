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

        assertThat(stockListResponse.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(stockListResponse.isFractionable()).isEqualTo(true)
        assertThat(stockListResponse.isTradable()).isEqualTo(true)
        assertThat(stockListResponse.name()).isEqualTo("name")
        assertThat(stockListResponse.symbol()).isEqualTo("symbol")
        assertThat(stockListResponse.tokens()).containsExactly("string")
        assertThat(stockListResponse.cik()).contains("cik")
        assertThat(stockListResponse.compositeFigi()).contains("composite_figi")
        assertThat(stockListResponse.cusip()).contains("cusip")
        assertThat(stockListResponse.description()).contains("description")
        assertThat(stockListResponse.displayName()).contains("display_name")
        assertThat(stockListResponse.logoUrl()).contains("logo_url")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val stockListResponse =
            StockListResponse.builder()
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

        val roundtrippedStockListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(stockListResponse),
                jacksonTypeRef<StockListResponse>(),
            )

        assertThat(roundtrippedStockListResponse).isEqualTo(stockListResponse)
    }
}
