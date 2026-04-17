// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.withdrawals

import com.dinari.api.core.jsonMapper
import com.dinari.api.models.v2.accounts.Chain
import com.dinari.api.models.v2.accounts.orders.BrokerageOrderStatus
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WithdrawalRetrieveResponseTest {

    @Test
    fun create() {
        val withdrawalRetrieveResponse =
            WithdrawalRetrieveResponse.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .chainId(Chain.EIP155_1)
                .paymentTokenAddress("payment_token_address")
                .paymentTokenAmount(0.0)
                .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .status(BrokerageOrderStatus.PENDING_SUBMIT)
                .transactionDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .transactionHash("0xeaF12bD1DfFd")
                .withdrawalRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        assertThat(withdrawalRetrieveResponse.id())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(withdrawalRetrieveResponse.accountId())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(withdrawalRetrieveResponse.chainId()).isEqualTo(Chain.EIP155_1)
        assertThat(withdrawalRetrieveResponse.paymentTokenAddress())
            .isEqualTo("payment_token_address")
        assertThat(withdrawalRetrieveResponse.paymentTokenAmount()).isEqualTo(0.0)
        assertThat(withdrawalRetrieveResponse.recipientAccountId())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(withdrawalRetrieveResponse.status())
            .isEqualTo(BrokerageOrderStatus.PENDING_SUBMIT)
        assertThat(withdrawalRetrieveResponse.transactionDt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(withdrawalRetrieveResponse.transactionHash()).isEqualTo("0xeaF12bD1DfFd")
        assertThat(withdrawalRetrieveResponse.withdrawalRequestId())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val withdrawalRetrieveResponse =
            WithdrawalRetrieveResponse.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .chainId(Chain.EIP155_1)
                .paymentTokenAddress("payment_token_address")
                .paymentTokenAmount(0.0)
                .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .status(BrokerageOrderStatus.PENDING_SUBMIT)
                .transactionDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .transactionHash("0xeaF12bD1DfFd")
                .withdrawalRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        val roundtrippedWithdrawalRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(withdrawalRetrieveResponse),
                jacksonTypeRef<WithdrawalRetrieveResponse>(),
            )

        assertThat(roundtrippedWithdrawalRetrieveResponse).isEqualTo(withdrawalRetrieveResponse)
    }
}
