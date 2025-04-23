// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.api.v2.marketdata.stocks

import com.dinari.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class StockRetrieveHistoricalPricesParamsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        StockRetrieveHistoricalPricesParams.builder()
            .stockId("stock_id")
            .timespan(StockRetrieveHistoricalPricesParams.Timespan.DAY)
            .build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun pathParams() {
        val params =
            StockRetrieveHistoricalPricesParams.builder()
                .stockId("stock_id")
                .timespan(StockRetrieveHistoricalPricesParams.Timespan.DAY)
                .build()

        assertThat(params._pathParam(0)).isEqualTo("stock_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun queryParams() {
        val params =
            StockRetrieveHistoricalPricesParams.builder()
                .stockId("stock_id")
                .timespan(StockRetrieveHistoricalPricesParams.Timespan.DAY)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("timespan", "DAY").build())
    }
}
