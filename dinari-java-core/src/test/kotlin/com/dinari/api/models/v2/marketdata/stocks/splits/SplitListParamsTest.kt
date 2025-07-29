// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.marketdata.stocks.splits

import com.dinari.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SplitListParamsTest {

    @Test
    fun create() {
        SplitListParams.builder().page(1L).pageSize(1L).build()
    }

    @Test
    fun queryParams() {
        val params = SplitListParams.builder().page(1L).pageSize(1L).build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("page", "1").put("page_size", "1").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = SplitListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
