// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.marketdata.stocks

import com.dinari.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class StockRetrieveNewsParamsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        StockRetrieveNewsParams.builder()
            .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .limit(1L)
            .build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun pathParams() {
        val params =
            StockRetrieveNewsParams.builder()
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun queryParams() {
        val params =
            StockRetrieveNewsParams.builder()
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .limit(1L)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("limit", "1").build())
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            StockRetrieveNewsParams.builder()
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
