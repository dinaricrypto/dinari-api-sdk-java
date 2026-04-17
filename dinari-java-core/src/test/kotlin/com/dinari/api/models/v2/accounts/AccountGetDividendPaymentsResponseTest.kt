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

internal class AccountGetDividendPaymentsResponseTest {

    @Test
    fun ofDividendPayments() {
        val dividendPayments =
            listOf(
                AccountGetDividendPaymentsResponse.DividendPayment.builder()
                    .amount(0.0)
                    .currency("currency")
                    .paymentDate(LocalDate.parse("2019-12-27"))
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val accountGetDividendPaymentsResponse =
            AccountGetDividendPaymentsResponse.ofDividendPayments(dividendPayments)

        assertThat(accountGetDividendPaymentsResponse.dividendPayments()).contains(dividendPayments)
        assertThat(accountGetDividendPaymentsResponse.paginatedDividendPayment()).isEmpty
    }

    @Test
    fun ofDividendPaymentsRoundtrip() {
        val jsonMapper = jsonMapper()
        val accountGetDividendPaymentsResponse =
            AccountGetDividendPaymentsResponse.ofDividendPayments(
                listOf(
                    AccountGetDividendPaymentsResponse.DividendPayment.builder()
                        .amount(0.0)
                        .currency("currency")
                        .paymentDate(LocalDate.parse("2019-12-27"))
                        .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .build()
                )
            )

        val roundtrippedAccountGetDividendPaymentsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountGetDividendPaymentsResponse),
                jacksonTypeRef<AccountGetDividendPaymentsResponse>(),
            )

        assertThat(roundtrippedAccountGetDividendPaymentsResponse)
            .isEqualTo(accountGetDividendPaymentsResponse)
    }

    @Test
    fun ofPaginatedDividendPayment() {
        val paginatedDividendPayment =
            AccountGetDividendPaymentsResponse.PaginatedDividendPaymentResponse.builder()
                .addData(
                    AccountGetDividendPaymentsResponse.PaginatedDividendPaymentResponse.Data
                        .builder()
                        .amount(0.0)
                        .currency("currency")
                        .paymentDate(LocalDate.parse("2019-12-27"))
                        .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .build()
                )
                .paginationMetadata(
                    AccountGetDividendPaymentsResponse.PaginatedDividendPaymentResponse
                        .PaginationMetadata
                        .builder()
                        .next("next")
                        .previous("previous")
                        .build()
                )
                ._sv(
                    AccountGetDividendPaymentsResponse.PaginatedDividendPaymentResponse._Sv
                        .PAGINATED_DIVIDEND_PAYMENT_RESPONSE_V1
                )
                .build()

        val accountGetDividendPaymentsResponse =
            AccountGetDividendPaymentsResponse.ofPaginatedDividendPayment(paginatedDividendPayment)

        assertThat(accountGetDividendPaymentsResponse.dividendPayments()).isEmpty
        assertThat(accountGetDividendPaymentsResponse.paginatedDividendPayment())
            .contains(paginatedDividendPayment)
    }

    @Test
    fun ofPaginatedDividendPaymentRoundtrip() {
        val jsonMapper = jsonMapper()
        val accountGetDividendPaymentsResponse =
            AccountGetDividendPaymentsResponse.ofPaginatedDividendPayment(
                AccountGetDividendPaymentsResponse.PaginatedDividendPaymentResponse.builder()
                    .addData(
                        AccountGetDividendPaymentsResponse.PaginatedDividendPaymentResponse.Data
                            .builder()
                            .amount(0.0)
                            .currency("currency")
                            .paymentDate(LocalDate.parse("2019-12-27"))
                            .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .build()
                    )
                    .paginationMetadata(
                        AccountGetDividendPaymentsResponse.PaginatedDividendPaymentResponse
                            .PaginationMetadata
                            .builder()
                            .next("next")
                            .previous("previous")
                            .build()
                    )
                    ._sv(
                        AccountGetDividendPaymentsResponse.PaginatedDividendPaymentResponse._Sv
                            .PAGINATED_DIVIDEND_PAYMENT_RESPONSE_V1
                    )
                    .build()
            )

        val roundtrippedAccountGetDividendPaymentsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountGetDividendPaymentsResponse),
                jacksonTypeRef<AccountGetDividendPaymentsResponse>(),
            )

        assertThat(roundtrippedAccountGetDividendPaymentsResponse)
            .isEqualTo(accountGetDividendPaymentsResponse)
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
        val accountGetDividendPaymentsResponse =
            jsonMapper()
                .convertValue(testCase.value, jacksonTypeRef<AccountGetDividendPaymentsResponse>())

        val e =
            assertThrows<DinariInvalidDataException> {
                accountGetDividendPaymentsResponse.validate()
            }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
