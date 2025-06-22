// File generated from our OpenAPI spec by Stainless.

package com.dinari.models.v2.accounts

import com.dinari.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.LocalDate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class AccountGetInterestPaymentsResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val accountGetInterestPaymentsResponse =
            AccountGetInterestPaymentsResponse.builder()
                .amount(0.0)
                .currency("currency")
                .paymentDate(LocalDate.parse("2019-12-27"))
                .build()

        assertThat(accountGetInterestPaymentsResponse.amount()).isEqualTo(0.0)
        assertThat(accountGetInterestPaymentsResponse.currency()).isEqualTo("currency")
        assertThat(accountGetInterestPaymentsResponse.paymentDate())
            .isEqualTo(LocalDate.parse("2019-12-27"))
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val accountGetInterestPaymentsResponse =
            AccountGetInterestPaymentsResponse.builder()
                .amount(0.0)
                .currency("currency")
                .paymentDate(LocalDate.parse("2019-12-27"))
                .build()

        val roundtrippedAccountGetInterestPaymentsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountGetInterestPaymentsResponse),
                jacksonTypeRef<AccountGetInterestPaymentsResponse>(),
            )

        assertThat(roundtrippedAccountGetInterestPaymentsResponse)
            .isEqualTo(accountGetInterestPaymentsResponse)
    }
}
