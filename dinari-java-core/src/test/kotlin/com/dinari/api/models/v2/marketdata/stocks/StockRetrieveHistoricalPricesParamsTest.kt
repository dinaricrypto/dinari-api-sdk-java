// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.marketdata.stocks

import com.dinari.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StockRetrieveHistoricalPricesParamsTest {

    @Test
    fun create() {
        StockRetrieveHistoricalPricesParams.builder()
            .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .timespan(StockRetrieveHistoricalPricesParams.Timespan.DAY)
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            StockRetrieveHistoricalPricesParams.builder()
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .timespan(StockRetrieveHistoricalPricesParams.Timespan.DAY)
                .build()

        assertThat(params._pathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            StockRetrieveHistoricalPricesParams.builder()
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .timespan(StockRetrieveHistoricalPricesParams.Timespan.DAY)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("timespan", "DAY").build())
    }
}
