// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts

import com.dinari.api.core.http.QueryParams
import java.time.LocalDate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class AccountGetInterestPaymentsParamsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        AccountGetInterestPaymentsParams.builder()
            .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .endDate(LocalDate.parse("2019-12-27"))
            .startDate(LocalDate.parse("2019-12-27"))
            .page(1L)
            .pageSize(1L)
            .build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun pathParams() {
        val params =
            AccountGetInterestPaymentsParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .endDate(LocalDate.parse("2019-12-27"))
                .startDate(LocalDate.parse("2019-12-27"))
                .build()

        assertThat(params._pathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun queryParams() {
        val params =
            AccountGetInterestPaymentsParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .endDate(LocalDate.parse("2019-12-27"))
                .startDate(LocalDate.parse("2019-12-27"))
                .page(1L)
                .pageSize(1L)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("end_date", "2019-12-27")
                    .put("start_date", "2019-12-27")
                    .put("page", "1")
                    .put("page_size", "1")
                    .build()
            )
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            AccountGetInterestPaymentsParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .endDate(LocalDate.parse("2019-12-27"))
                .startDate(LocalDate.parse("2019-12-27"))
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("end_date", "2019-12-27")
                    .put("start_date", "2019-12-27")
                    .build()
            )
    }
}
