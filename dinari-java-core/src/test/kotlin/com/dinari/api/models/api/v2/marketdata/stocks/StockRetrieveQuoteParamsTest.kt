// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.api.v2.marketdata.stocks

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class StockRetrieveQuoteParamsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        StockRetrieveQuoteParams.builder().stockId("stock_id").build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun pathParams() {
        val params = StockRetrieveQuoteParams.builder().stockId("stock_id").build()

        assertThat(params._pathParam(0)).isEqualTo("stock_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
