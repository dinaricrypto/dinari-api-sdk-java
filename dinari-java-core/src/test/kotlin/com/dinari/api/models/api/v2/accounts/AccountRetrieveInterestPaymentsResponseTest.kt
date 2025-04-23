// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.api.v2.accounts

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.LocalDate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class AccountRetrieveInterestPaymentsResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val accountRetrieveInterestPaymentsResponse =
            AccountRetrieveInterestPaymentsResponse.builder()
                .amount(0.0)
                .currency("currency")
                .paymentDate(LocalDate.parse("2019-12-27"))
                .build()

        assertThat(accountRetrieveInterestPaymentsResponse.amount()).isEqualTo(0.0)
        assertThat(accountRetrieveInterestPaymentsResponse.currency()).isEqualTo("currency")
        assertThat(accountRetrieveInterestPaymentsResponse.paymentDate())
            .isEqualTo(LocalDate.parse("2019-12-27"))
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val accountRetrieveInterestPaymentsResponse =
            AccountRetrieveInterestPaymentsResponse.builder()
                .amount(0.0)
                .currency("currency")
                .paymentDate(LocalDate.parse("2019-12-27"))
                .build()

        val roundtrippedAccountRetrieveInterestPaymentsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountRetrieveInterestPaymentsResponse),
                jacksonTypeRef<AccountRetrieveInterestPaymentsResponse>(),
            )

        assertThat(roundtrippedAccountRetrieveInterestPaymentsResponse)
            .isEqualTo(accountRetrieveInterestPaymentsResponse)
    }
}
