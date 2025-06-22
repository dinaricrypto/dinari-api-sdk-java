// File generated from our OpenAPI spec by Stainless.

package com.dinari.models.v2.accounts

import com.dinari.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.LocalDate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class AccountGetDividendPaymentsResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val accountGetDividendPaymentsResponse =
            AccountGetDividendPaymentsResponse.builder()
                .amount(0.0)
                .currency("currency")
                .paymentDate(LocalDate.parse("2019-12-27"))
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        assertThat(accountGetDividendPaymentsResponse.amount()).isEqualTo(0.0)
        assertThat(accountGetDividendPaymentsResponse.currency()).isEqualTo("currency")
        assertThat(accountGetDividendPaymentsResponse.paymentDate())
            .isEqualTo(LocalDate.parse("2019-12-27"))
        assertThat(accountGetDividendPaymentsResponse.stockId())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val accountGetDividendPaymentsResponse =
            AccountGetDividendPaymentsResponse.builder()
                .amount(0.0)
                .currency("currency")
                .paymentDate(LocalDate.parse("2019-12-27"))
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        val roundtrippedAccountGetDividendPaymentsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountGetDividendPaymentsResponse),
                jacksonTypeRef<AccountGetDividendPaymentsResponse>(),
            )

        assertThat(roundtrippedAccountGetDividendPaymentsResponse)
            .isEqualTo(accountGetDividendPaymentsResponse)
    }
}
