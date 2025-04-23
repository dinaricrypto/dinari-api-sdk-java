// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.api.v2.marketdata.stocks

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class StockRetrieveDividendsResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val stockRetrieveDividendsResponse =
            StockRetrieveDividendsResponse.builder()
                .cashAmount(0.0)
                .currency("currency")
                .declarationDate("declaration_date")
                .dividendType("dividend_type")
                .exDividendDate("ex_dividend_date")
                .frequency(0L)
                .payDate("pay_date")
                .recordDate("record_date")
                .ticker("ticker")
                .build()

        assertThat(stockRetrieveDividendsResponse.cashAmount()).contains(0.0)
        assertThat(stockRetrieveDividendsResponse.currency()).contains("currency")
        assertThat(stockRetrieveDividendsResponse.declarationDate()).contains("declaration_date")
        assertThat(stockRetrieveDividendsResponse.dividendType()).contains("dividend_type")
        assertThat(stockRetrieveDividendsResponse.exDividendDate()).contains("ex_dividend_date")
        assertThat(stockRetrieveDividendsResponse.frequency()).contains(0L)
        assertThat(stockRetrieveDividendsResponse.payDate()).contains("pay_date")
        assertThat(stockRetrieveDividendsResponse.recordDate()).contains("record_date")
        assertThat(stockRetrieveDividendsResponse.ticker()).contains("ticker")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val stockRetrieveDividendsResponse =
            StockRetrieveDividendsResponse.builder()
                .cashAmount(0.0)
                .currency("currency")
                .declarationDate("declaration_date")
                .dividendType("dividend_type")
                .exDividendDate("ex_dividend_date")
                .frequency(0L)
                .payDate("pay_date")
                .recordDate("record_date")
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
