// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.api.v2.marketdata.stocks

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class StockListResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val stockListResponse =
            StockListResponse.builder()
                .id("id")
                .isFractionable(true)
                .name("name")
                .symbol("symbol")
                .cik("cik")
                .compositeFigi("composite_figi")
                .cusip("cusip")
                .description("description")
                .displayName("display_name")
                .logoUrl("logo_url")
                .build()

        assertThat(stockListResponse.id()).isEqualTo("id")
        assertThat(stockListResponse.isFractionable()).isEqualTo(true)
        assertThat(stockListResponse.name()).isEqualTo("name")
        assertThat(stockListResponse.symbol()).isEqualTo("symbol")
        assertThat(stockListResponse.cik()).contains("cik")
        assertThat(stockListResponse.compositeFigi()).contains("composite_figi")
        assertThat(stockListResponse.cusip()).contains("cusip")
        assertThat(stockListResponse.description()).contains("description")
        assertThat(stockListResponse.displayName()).contains("display_name")
        assertThat(stockListResponse.logoUrl()).contains("logo_url")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val stockListResponse =
            StockListResponse.builder()
                .id("id")
                .isFractionable(true)
                .name("name")
                .symbol("symbol")
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
