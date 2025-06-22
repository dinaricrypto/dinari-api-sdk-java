// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.withdrawals

import com.dinari.api.core.jsonMapper
import com.dinari.api.models.v2.accounts.Chain
import com.dinari.api.models.v2.accounts.orders.BrokerageOrderStatus
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class WithdrawalTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val withdrawal =
            Withdrawal.builder()
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

        assertThat(withdrawal.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(withdrawal.accountId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(withdrawal.chainId()).isEqualTo(Chain.EIP155_1)
        assertThat(withdrawal.paymentTokenAddress()).isEqualTo("payment_token_address")
        assertThat(withdrawal.paymentTokenAmount()).isEqualTo(0.0)
        assertThat(withdrawal.recipientAccountId())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(withdrawal.status()).isEqualTo(BrokerageOrderStatus.PENDING_SUBMIT)
        assertThat(withdrawal.transactionDt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(withdrawal.transactionHash()).isEqualTo("0xeaF12bD1DfFd")
        assertThat(withdrawal.withdrawalRequestId())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val withdrawal =
            Withdrawal.builder()
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

        val roundtrippedWithdrawal =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(withdrawal),
                jacksonTypeRef<Withdrawal>(),
            )

        assertThat(roundtrippedWithdrawal).isEqualTo(withdrawal)
    }
}
