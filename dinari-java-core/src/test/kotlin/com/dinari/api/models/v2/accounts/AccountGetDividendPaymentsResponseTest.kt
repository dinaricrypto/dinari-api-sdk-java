// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts

import com.dinari.api.core.jsonMapper
import com.dinari.api.models.v2.marketdata.alloys.PaginationMetadata
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.LocalDate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountGetDividendPaymentsResponseTest {

    @Test
    fun create() {
        val accountGetDividendPaymentsResponse =
            AccountGetDividendPaymentsResponse.builder()
                .addData(
                    AccountGetDividendPaymentsResponse.Data.builder()
                        .amount(0.0)
                        .currency("currency")
                        .paymentDate(LocalDate.parse("2019-12-27"))
                        .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .build()
                )
                .paginationMetadata(
                    PaginationMetadata.builder().next("next").previous("previous").build()
                )
                ._sv(AccountGetDividendPaymentsResponse._Sv.PAGINATED_DIVIDEND_PAYMENT_RESPONSE_V1)
                .build()

        assertThat(accountGetDividendPaymentsResponse.data())
            .containsExactly(
                AccountGetDividendPaymentsResponse.Data.builder()
                    .amount(0.0)
                    .currency("currency")
                    .paymentDate(LocalDate.parse("2019-12-27"))
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )
        assertThat(accountGetDividendPaymentsResponse.paginationMetadata())
            .isEqualTo(PaginationMetadata.builder().next("next").previous("previous").build())
        assertThat(accountGetDividendPaymentsResponse._sv())
            .contains(AccountGetDividendPaymentsResponse._Sv.PAGINATED_DIVIDEND_PAYMENT_RESPONSE_V1)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val accountGetDividendPaymentsResponse =
            AccountGetDividendPaymentsResponse.builder()
                .addData(
                    AccountGetDividendPaymentsResponse.Data.builder()
                        .amount(0.0)
                        .currency("currency")
                        .paymentDate(LocalDate.parse("2019-12-27"))
                        .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .build()
                )
                .paginationMetadata(
                    PaginationMetadata.builder().next("next").previous("previous").build()
                )
                ._sv(AccountGetDividendPaymentsResponse._Sv.PAGINATED_DIVIDEND_PAYMENT_RESPONSE_V1)
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
