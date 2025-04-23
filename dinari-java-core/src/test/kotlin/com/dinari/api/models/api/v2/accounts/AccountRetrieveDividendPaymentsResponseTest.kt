// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.api.v2.accounts

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.LocalDate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class AccountRetrieveDividendPaymentsResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val accountRetrieveDividendPaymentsResponse =
            AccountRetrieveDividendPaymentsResponse.builder()
                .amount(0.0)
                .currency("currency")
                .paymentDate(LocalDate.parse("2019-12-27"))
                .stockId("stock_id")
                .build()

        assertThat(accountRetrieveDividendPaymentsResponse.amount()).isEqualTo(0.0)
        assertThat(accountRetrieveDividendPaymentsResponse.currency()).isEqualTo("currency")
        assertThat(accountRetrieveDividendPaymentsResponse.paymentDate())
            .isEqualTo(LocalDate.parse("2019-12-27"))
        assertThat(accountRetrieveDividendPaymentsResponse.stockId()).isEqualTo("stock_id")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val accountRetrieveDividendPaymentsResponse =
            AccountRetrieveDividendPaymentsResponse.builder()
                .amount(0.0)
                .currency("currency")
                .paymentDate(LocalDate.parse("2019-12-27"))
                .stockId("stock_id")
                .build()

        val roundtrippedAccountRetrieveDividendPaymentsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountRetrieveDividendPaymentsResponse),
                jacksonTypeRef<AccountRetrieveDividendPaymentsResponse>(),
            )

        assertThat(roundtrippedAccountRetrieveDividendPaymentsResponse)
            .isEqualTo(accountRetrieveDividendPaymentsResponse)
    }
}
