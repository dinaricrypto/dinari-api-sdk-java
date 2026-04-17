// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts

import com.dinari.api.core.http.QueryParams
import java.time.LocalDate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountGetInterestPaymentsParamsTest {

    @Test
    fun create() {
        AccountGetInterestPaymentsParams.builder()
            .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .endDate(LocalDate.parse("2019-12-27"))
            .startDate(LocalDate.parse("2019-12-27"))
            .limit(20L)
            .next("next")
            .order(AccountGetInterestPaymentsParams.Order.ASC)
            .page(1L)
            .pageSize(1L)
            .previous("previous")
            .build()
    }

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

    @Test
    fun queryParams() {
        val params =
            AccountGetInterestPaymentsParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .endDate(LocalDate.parse("2019-12-27"))
                .startDate(LocalDate.parse("2019-12-27"))
                .limit(20L)
                .next("next")
                .order(AccountGetInterestPaymentsParams.Order.ASC)
                .page(1L)
                .pageSize(1L)
                .previous("previous")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("end_date", "2019-12-27")
                    .put("start_date", "2019-12-27")
                    .put("limit", "20")
                    .put("next", "next")
                    .put("order", "asc")
                    .put("page", "1")
                    .put("page_size", "1")
                    .put("previous", "previous")
                    .build()
            )
    }

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
