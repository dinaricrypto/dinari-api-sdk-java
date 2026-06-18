// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.entities

import com.dinari.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EntityListParamsTest {

    @Test
    fun create() {
        EntityListParams.builder()
            .limit(20L)
            .next("next")
            .order(EntityListParams.Order.ASC)
            .previous("previous")
            .referenceId("x")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            EntityListParams.builder()
                .limit(20L)
                .next("next")
                .order(EntityListParams.Order.ASC)
                .previous("previous")
                .referenceId("x")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("limit", "20")
                    .put("next", "next")
                    .put("order", "asc")
                    .put("previous", "previous")
                    .put("reference_id", "x")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = EntityListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
