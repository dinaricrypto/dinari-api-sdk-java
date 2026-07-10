// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts

import com.dinari.api.core.jsonMapper
import com.dinari.api.models.v2.marketdata.alloys.PaginationMetadata
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.LocalDate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountGetInterestPaymentsResponseTest {

    @Test
    fun create() {
        val accountGetInterestPaymentsResponse =
            AccountGetInterestPaymentsResponse.builder()
                .addData(
                    AccountGetInterestPaymentsResponse.Data.builder()
                        .amount(0.0)
                        .currency("currency")
                        .paymentDate(LocalDate.parse("2019-12-27"))
                        .build()
                )
                .paginationMetadata(
                    PaginationMetadata.builder().next("next").previous("previous").build()
                )
                ._sv(AccountGetInterestPaymentsResponse._Sv.PAGINATED_INTEREST_PAYMENT_RESPONSE_V1)
                .build()

        assertThat(accountGetInterestPaymentsResponse.data())
            .containsExactly(
                AccountGetInterestPaymentsResponse.Data.builder()
                    .amount(0.0)
                    .currency("currency")
                    .paymentDate(LocalDate.parse("2019-12-27"))
                    .build()
            )
        assertThat(accountGetInterestPaymentsResponse.paginationMetadata())
            .isEqualTo(PaginationMetadata.builder().next("next").previous("previous").build())
        assertThat(accountGetInterestPaymentsResponse._sv())
            .contains(AccountGetInterestPaymentsResponse._Sv.PAGINATED_INTEREST_PAYMENT_RESPONSE_V1)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val accountGetInterestPaymentsResponse =
            AccountGetInterestPaymentsResponse.builder()
                .addData(
                    AccountGetInterestPaymentsResponse.Data.builder()
                        .amount(0.0)
                        .currency("currency")
                        .paymentDate(LocalDate.parse("2019-12-27"))
                        .build()
                )
                .paginationMetadata(
                    PaginationMetadata.builder().next("next").previous("previous").build()
                )
                ._sv(AccountGetInterestPaymentsResponse._Sv.PAGINATED_INTEREST_PAYMENT_RESPONSE_V1)
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
