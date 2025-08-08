// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.marketdata.stocks

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.LocalDate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StockRetrieveDividendsResponseTest {

    @Test
    fun create() {
        val stockRetrieveDividendsResponse =
            StockRetrieveDividendsResponse.builder()
                .cashAmount(0.0)
                .currency("currency")
                .dividendType("dividend_type")
                .exDividendDate(LocalDate.parse("2019-12-27"))
                .payDate(LocalDate.parse("2019-12-27"))
                .recordDate(LocalDate.parse("2019-12-27"))
                .ticker("ticker")
                .build()

        assertThat(stockRetrieveDividendsResponse.cashAmount()).contains(0.0)
        assertThat(stockRetrieveDividendsResponse.currency()).contains("currency")
        assertThat(stockRetrieveDividendsResponse.dividendType()).contains("dividend_type")
        assertThat(stockRetrieveDividendsResponse.exDividendDate())
            .contains(LocalDate.parse("2019-12-27"))
        assertThat(stockRetrieveDividendsResponse.payDate()).contains(LocalDate.parse("2019-12-27"))
        assertThat(stockRetrieveDividendsResponse.recordDate())
            .contains(LocalDate.parse("2019-12-27"))
        assertThat(stockRetrieveDividendsResponse.ticker()).contains("ticker")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val stockRetrieveDividendsResponse =
            StockRetrieveDividendsResponse.builder()
                .cashAmount(0.0)
                .currency("currency")
                .dividendType("dividend_type")
                .exDividendDate(LocalDate.parse("2019-12-27"))
                .payDate(LocalDate.parse("2019-12-27"))
                .recordDate(LocalDate.parse("2019-12-27"))
                .ticker("ticker")
                .build()

        val roundtrippedStockRetrieveDividendsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(stockRetrieveDividendsResponse),
                jacksonTypeRef<StockRetrieveDividendsResponse>(),
            )

        assertThat(roundtrippedStockRetrieveDividendsResponse)
            .isEqualTo(stockRetrieveDividendsResponse)
    }
}
