// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts

import com.dinari.api.core.JsonValue
import com.dinari.api.core.jsonMapper
import com.dinari.api.errors.DinariInvalidDataException
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.LocalDate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class AccountGetInterestPaymentsResponseTest {

    @Test
    fun ofInterestPayments() {
        val interestPayments =
            listOf(
                AccountGetInterestPaymentsResponse.InterestPayment.builder()
                    .amount(0.0)
                    .currency("currency")
                    .paymentDate(LocalDate.parse("2019-12-27"))
                    .build()
            )

        val accountGetInterestPaymentsResponse =
            AccountGetInterestPaymentsResponse.ofInterestPayments(interestPayments)

        assertThat(accountGetInterestPaymentsResponse.interestPayments()).contains(interestPayments)
        assertThat(accountGetInterestPaymentsResponse.paginatedInterestPayment()).isEmpty
    }

    @Test
    fun ofInterestPaymentsRoundtrip() {
        val jsonMapper = jsonMapper()
        val accountGetInterestPaymentsResponse =
            AccountGetInterestPaymentsResponse.ofInterestPayments(
                listOf(
                    AccountGetInterestPaymentsResponse.InterestPayment.builder()
                        .amount(0.0)
                        .currency("currency")
                        .paymentDate(LocalDate.parse("2019-12-27"))
                        .build()
                )
            )

        val roundtrippedAccountGetInterestPaymentsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountGetInterestPaymentsResponse),
                jacksonTypeRef<AccountGetInterestPaymentsResponse>(),
            )

        assertThat(roundtrippedAccountGetInterestPaymentsResponse)
            .isEqualTo(accountGetInterestPaymentsResponse)
    }

    @Test
    fun ofPaginatedInterestPayment() {
        val paginatedInterestPayment =
            AccountGetInterestPaymentsResponse.PaginatedInterestPaymentResponse.builder()
                .addData(
                    AccountGetInterestPaymentsResponse.PaginatedInterestPaymentResponse.Data
                        .builder()
                        .amount(0.0)
                        .currency("currency")
                        .paymentDate(LocalDate.parse("2019-12-27"))
                        .build()
                )
                .paginationMetadata(
                    AccountGetInterestPaymentsResponse.PaginatedInterestPaymentResponse
                        .PaginationMetadata
                        .builder()
                        .next("next")
                        .previous("previous")
                        .build()
                )
                ._sv(
                    AccountGetInterestPaymentsResponse.PaginatedInterestPaymentResponse._Sv
                        .PAGINATED_INTEREST_PAYMENT_RESPONSE_V1
                )
                .build()

        val accountGetInterestPaymentsResponse =
            AccountGetInterestPaymentsResponse.ofPaginatedInterestPayment(paginatedInterestPayment)

        assertThat(accountGetInterestPaymentsResponse.interestPayments()).isEmpty
        assertThat(accountGetInterestPaymentsResponse.paginatedInterestPayment())
            .contains(paginatedInterestPayment)
    }

    @Test
    fun ofPaginatedInterestPaymentRoundtrip() {
        val jsonMapper = jsonMapper()
        val accountGetInterestPaymentsResponse =
            AccountGetInterestPaymentsResponse.ofPaginatedInterestPayment(
                AccountGetInterestPaymentsResponse.PaginatedInterestPaymentResponse.builder()
                    .addData(
                        AccountGetInterestPaymentsResponse.PaginatedInterestPaymentResponse.Data
                            .builder()
                            .amount(0.0)
                            .currency("currency")
                            .paymentDate(LocalDate.parse("2019-12-27"))
                            .build()
                    )
                    .paginationMetadata(
                        AccountGetInterestPaymentsResponse.PaginatedInterestPaymentResponse
                            .PaginationMetadata
                            .builder()
                            .next("next")
                            .previous("previous")
                            .build()
                    )
                    ._sv(
                        AccountGetInterestPaymentsResponse.PaginatedInterestPaymentResponse._Sv
                            .PAGINATED_INTEREST_PAYMENT_RESPONSE_V1
                    )
                    .build()
            )

        val roundtrippedAccountGetInterestPaymentsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountGetInterestPaymentsResponse),
                jacksonTypeRef<AccountGetInterestPaymentsResponse>(),
            )

        assertThat(roundtrippedAccountGetInterestPaymentsResponse)
            .isEqualTo(accountGetInterestPaymentsResponse)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val accountGetInterestPaymentsResponse =
            jsonMapper()
                .convertValue(testCase.value, jacksonTypeRef<AccountGetInterestPaymentsResponse>())

        val e =
            assertThrows<DinariInvalidDataException> {
                accountGetInterestPaymentsResponse.validate()
            }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
