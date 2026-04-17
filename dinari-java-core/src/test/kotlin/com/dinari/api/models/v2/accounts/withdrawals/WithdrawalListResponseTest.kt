// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.withdrawals

import com.dinari.api.core.JsonValue
import com.dinari.api.core.jsonMapper
import com.dinari.api.errors.DinariInvalidDataException
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class WithdrawalListResponseTest {

    @Test
    fun ofWithdrawals() {
        val withdrawals =
            listOf(
                Withdrawal.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .chainId("chain_id")
                    .paymentTokenAddress("payment_token_address")
                    .paymentTokenAmount(0.0)
                    .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .status(Withdrawal.Status.PENDING_SUBMIT)
                    .transactionDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .transactionHash("0xeaF12bD1DfFd")
                    .withdrawalRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val withdrawalListResponse = WithdrawalListResponse.ofWithdrawals(withdrawals)

        assertThat(withdrawalListResponse.withdrawals()).contains(withdrawals)
        assertThat(withdrawalListResponse.paginatedWithdrawal()).isEmpty
    }

    @Test
    fun ofWithdrawalsRoundtrip() {
        val jsonMapper = jsonMapper()
        val withdrawalListResponse =
            WithdrawalListResponse.ofWithdrawals(
                listOf(
                    Withdrawal.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .chainId("chain_id")
                        .paymentTokenAddress("payment_token_address")
                        .paymentTokenAmount(0.0)
                        .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .status(Withdrawal.Status.PENDING_SUBMIT)
                        .transactionDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .transactionHash("0xeaF12bD1DfFd")
                        .withdrawalRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .build()
                )
            )

        val roundtrippedWithdrawalListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(withdrawalListResponse),
                jacksonTypeRef<WithdrawalListResponse>(),
            )

        assertThat(roundtrippedWithdrawalListResponse).isEqualTo(withdrawalListResponse)
    }

    @Test
    fun ofPaginatedWithdrawal() {
        val paginatedWithdrawal =
            WithdrawalListResponse.PaginatedWithdrawalResponse.builder()
                .addData(
                    Withdrawal.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .chainId("chain_id")
                        .paymentTokenAddress("payment_token_address")
                        .paymentTokenAmount(0.0)
                        .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .status(Withdrawal.Status.PENDING_SUBMIT)
                        .transactionDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .transactionHash("0xeaF12bD1DfFd")
                        .withdrawalRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .build()
                )
                .paginationMetadata(
                    WithdrawalListResponse.PaginatedWithdrawalResponse.PaginationMetadata.builder()
                        .next("next")
                        .previous("previous")
                        .build()
                )
                ._sv(
                    WithdrawalListResponse.PaginatedWithdrawalResponse._Sv
                        .PAGINATED_WITHDRAWAL_RESPONSE_V1
                )
                .build()

        val withdrawalListResponse =
            WithdrawalListResponse.ofPaginatedWithdrawal(paginatedWithdrawal)

        assertThat(withdrawalListResponse.withdrawals()).isEmpty
        assertThat(withdrawalListResponse.paginatedWithdrawal()).contains(paginatedWithdrawal)
    }

    @Test
    fun ofPaginatedWithdrawalRoundtrip() {
        val jsonMapper = jsonMapper()
        val withdrawalListResponse =
            WithdrawalListResponse.ofPaginatedWithdrawal(
                WithdrawalListResponse.PaginatedWithdrawalResponse.builder()
                    .addData(
                        Withdrawal.builder()
                            .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .chainId("chain_id")
                            .paymentTokenAddress("payment_token_address")
                            .paymentTokenAmount(0.0)
                            .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .status(Withdrawal.Status.PENDING_SUBMIT)
                            .transactionDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .transactionHash("0xeaF12bD1DfFd")
                            .withdrawalRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .build()
                    )
                    .paginationMetadata(
                        WithdrawalListResponse.PaginatedWithdrawalResponse.PaginationMetadata
                            .builder()
                            .next("next")
                            .previous("previous")
                            .build()
                    )
                    ._sv(
                        WithdrawalListResponse.PaginatedWithdrawalResponse._Sv
                            .PAGINATED_WITHDRAWAL_RESPONSE_V1
                    )
                    .build()
            )

        val roundtrippedWithdrawalListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(withdrawalListResponse),
                jacksonTypeRef<WithdrawalListResponse>(),
            )

        assertThat(roundtrippedWithdrawalListResponse).isEqualTo(withdrawalListResponse)
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
        val withdrawalListResponse =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<WithdrawalListResponse>())

        val e = assertThrows<DinariInvalidDataException> { withdrawalListResponse.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
