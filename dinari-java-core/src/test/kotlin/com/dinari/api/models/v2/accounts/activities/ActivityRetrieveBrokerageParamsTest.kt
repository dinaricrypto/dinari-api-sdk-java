// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.activities

import com.dinari.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ActivityRetrieveBrokerageParamsTest {

    @Test
    fun create() {
        ActivityRetrieveBrokerageParams.builder()
            .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .pageSize(1L)
            .pageToken("page_token")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            ActivityRetrieveBrokerageParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            ActivityRetrieveBrokerageParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .pageSize(1L)
                .pageToken("page_token")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder().put("page_size", "1").put("page_token", "page_token").build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            ActivityRetrieveBrokerageParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
