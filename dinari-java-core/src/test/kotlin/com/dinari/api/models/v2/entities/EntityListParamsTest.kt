// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.entities

import com.dinari.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class EntityListParamsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        EntityListParams.builder().page(1L).pageSize(1L).referenceId("x").build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun queryParams() {
        val params = EntityListParams.builder().page(1L).pageSize(1L).referenceId("x").build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("page", "1")
                    .put("page_size", "1")
                    .put("reference_id", "x")
                    .build()
            )
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = EntityListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
