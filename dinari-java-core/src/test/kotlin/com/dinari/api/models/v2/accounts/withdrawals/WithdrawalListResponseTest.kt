// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.withdrawals

import com.dinari.api.core.jsonMapper
import com.dinari.api.models.v2.BrokerageOrderStatus
import com.dinari.api.models.v2.marketdata.alloys.PaginationMetadata
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WithdrawalListResponseTest {

    @Test
    fun create() {
        val withdrawalListResponse =
            WithdrawalListResponse.builder()
                .addData(
                    Withdrawal.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .chainId("chain_id")
                        .paymentTokenAddress("payment_token_address")
                        .paymentTokenAmount(0.0)
                        .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .status(BrokerageOrderStatus.PENDING_SUBMIT)
                        .transactionDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .transactionHash("0xeaF12bD1DfFd")
                        .withdrawalRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .build()
                )
                .paginationMetadata(
                    PaginationMetadata.builder().next("next").previous("previous").build()
                )
                ._sv(WithdrawalListResponse._Sv.PAGINATED_WITHDRAWAL_RESPONSE_V1)
                .build()

        assertThat(withdrawalListResponse.data())
            .containsExactly(
                Withdrawal.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .chainId("chain_id")
                    .paymentTokenAddress("payment_token_address")
                    .paymentTokenAmount(0.0)
                    .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .status(BrokerageOrderStatus.PENDING_SUBMIT)
                    .transactionDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .transactionHash("0xeaF12bD1DfFd")
                    .withdrawalRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )
        assertThat(withdrawalListResponse.paginationMetadata())
            .isEqualTo(PaginationMetadata.builder().next("next").previous("previous").build())
        assertThat(withdrawalListResponse._sv())
            .contains(WithdrawalListResponse._Sv.PAGINATED_WITHDRAWAL_RESPONSE_V1)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val withdrawalListResponse =
            WithdrawalListResponse.builder()
                .addData(
                    Withdrawal.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .chainId("chain_id")
                        .paymentTokenAddress("payment_token_address")
                        .paymentTokenAmount(0.0)
                        .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .status(BrokerageOrderStatus.PENDING_SUBMIT)
                        .transactionDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .transactionHash("0xeaF12bD1DfFd")
                        .withdrawalRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .build()
                )
                .paginationMetadata(
                    PaginationMetadata.builder().next("next").previous("previous").build()
                )
                ._sv(WithdrawalListResponse._Sv.PAGINATED_WITHDRAWAL_RESPONSE_V1)
                .build()

        val roundtrippedWithdrawalListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(withdrawalListResponse),
                jacksonTypeRef<WithdrawalListResponse>(),
            )

        assertThat(roundtrippedWithdrawalListResponse).isEqualTo(withdrawalListResponse)
    }
}
