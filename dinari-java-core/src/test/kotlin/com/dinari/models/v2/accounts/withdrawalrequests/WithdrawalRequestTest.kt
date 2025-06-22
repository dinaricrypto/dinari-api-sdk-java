// File generated from our OpenAPI spec by Stainless.

package com.dinari.models.v2.accounts.withdrawalrequests

import com.dinari.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class WithdrawalRequestTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val withdrawalRequest =
            WithdrawalRequest.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .paymentTokenAmount(0.0)
                .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .status(WithdrawalRequest.Status.PENDING)
                .updatedDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        assertThat(withdrawalRequest.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(withdrawalRequest.accountId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(withdrawalRequest.createdDt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(withdrawalRequest.paymentTokenAmount()).isEqualTo(0.0)
        assertThat(withdrawalRequest.recipientAccountId())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(withdrawalRequest.status()).isEqualTo(WithdrawalRequest.Status.PENDING)
        assertThat(withdrawalRequest.updatedDt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val withdrawalRequest =
            WithdrawalRequest.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .paymentTokenAmount(0.0)
                .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .status(WithdrawalRequest.Status.PENDING)
                .updatedDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val roundtrippedWithdrawalRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(withdrawalRequest),
                jacksonTypeRef<WithdrawalRequest>(),
            )

        assertThat(roundtrippedWithdrawalRequest).isEqualTo(withdrawalRequest)
    }
}
