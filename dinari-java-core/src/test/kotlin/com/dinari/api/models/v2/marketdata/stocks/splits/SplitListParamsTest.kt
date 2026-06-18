// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.marketdata.stocks.splits

import com.dinari.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SplitListParamsTest {

    @Test
    fun create() {
        SplitListParams.builder()
            .limit(20L)
            .next("next")
            .order(SplitListParams.Order.ASC)
            .previous("previous")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            SplitListParams.builder()
                .limit(20L)
                .next("next")
                .order(SplitListParams.Order.ASC)
                .previous("previous")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("limit", "20")
                    .put("next", "next")
                    .put("order", "asc")
                    .put("previous", "previous")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = SplitListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
