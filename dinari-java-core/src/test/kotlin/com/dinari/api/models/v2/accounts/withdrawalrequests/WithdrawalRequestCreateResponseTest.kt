// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.withdrawalrequests

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WithdrawalRequestCreateResponseTest {

    @Test
    fun create() {
        val withdrawalRequestCreateResponse =
            WithdrawalRequestCreateResponse.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .paymentTokenAmount(0.0)
                .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .status(WithdrawalRequestCreateResponse.Status.PENDING)
                .updatedDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        assertThat(withdrawalRequestCreateResponse.id())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(withdrawalRequestCreateResponse.accountId())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(withdrawalRequestCreateResponse.createdDt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(withdrawalRequestCreateResponse.paymentTokenAmount()).isEqualTo(0.0)
        assertThat(withdrawalRequestCreateResponse.recipientAccountId())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(withdrawalRequestCreateResponse.status())
            .isEqualTo(WithdrawalRequestCreateResponse.Status.PENDING)
        assertThat(withdrawalRequestCreateResponse.updatedDt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val withdrawalRequestCreateResponse =
            WithdrawalRequestCreateResponse.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .paymentTokenAmount(0.0)
                .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .status(WithdrawalRequestCreateResponse.Status.PENDING)
                .updatedDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val roundtrippedWithdrawalRequestCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(withdrawalRequestCreateResponse),
                jacksonTypeRef<WithdrawalRequestCreateResponse>(),
            )

        assertThat(roundtrippedWithdrawalRequestCreateResponse)
            .isEqualTo(withdrawalRequestCreateResponse)
    }
}
