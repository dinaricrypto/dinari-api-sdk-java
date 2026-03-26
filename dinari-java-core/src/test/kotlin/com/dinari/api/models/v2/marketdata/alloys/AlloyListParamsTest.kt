// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.marketdata.alloys

import com.dinari.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AlloyListParamsTest {

    @Test
    fun create() {
        AlloyListParams.builder()
            .limit(20L)
            .next("next")
            .order(AlloyListParams.Order.ASC)
            .previous("previous")
            .addSymbol("string")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            AlloyListParams.builder()
                .limit(20L)
                .next("next")
                .order(AlloyListParams.Order.ASC)
                .previous("previous")
                .addSymbol("string")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("limit", "20")
                    .put("next", "next")
                    .put("order", "asc")
                    .put("previous", "previous")
                    .put("symbols", "string")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = AlloyListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
