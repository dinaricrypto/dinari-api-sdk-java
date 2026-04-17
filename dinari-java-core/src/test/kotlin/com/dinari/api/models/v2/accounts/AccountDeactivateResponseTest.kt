// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts

import com.dinari.api.core.jsonMapper
import com.dinari.api.models.v2.entities.accounts.Jurisdiction
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountDeactivateResponseTest {

    @Test
    fun create() {
        val accountDeactivateResponse =
            AccountDeactivateResponse.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .isActive(true)
                .jurisdiction(Jurisdiction.BASELINE)
                .brokerageAccountId("brokerage_account_id")
                .build()

        assertThat(accountDeactivateResponse.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(accountDeactivateResponse.createdDt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(accountDeactivateResponse.entityId())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(accountDeactivateResponse.isActive()).isEqualTo(true)
        assertThat(accountDeactivateResponse.jurisdiction()).isEqualTo(Jurisdiction.BASELINE)
        assertThat(accountDeactivateResponse.brokerageAccountId()).contains("brokerage_account_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val accountDeactivateResponse =
            AccountDeactivateResponse.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .isActive(true)
                .jurisdiction(Jurisdiction.BASELINE)
                .brokerageAccountId("brokerage_account_id")
                .build()

        val roundtrippedAccountDeactivateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountDeactivateResponse),
                jacksonTypeRef<AccountDeactivateResponse>(),
            )

        assertThat(roundtrippedAccountDeactivateResponse).isEqualTo(accountDeactivateResponse)
    }
}
