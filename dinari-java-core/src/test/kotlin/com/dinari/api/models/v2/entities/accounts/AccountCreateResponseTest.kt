// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.entities.accounts

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountCreateResponseTest {

    @Test
    fun create() {
        val accountCreateResponse =
            AccountCreateResponse.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .isActive(true)
                .jurisdiction(Jurisdiction.BASELINE)
                .brokerageAccountId("brokerage_account_id")
                .build()

        assertThat(accountCreateResponse.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(accountCreateResponse.createdDt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(accountCreateResponse.entityId())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(accountCreateResponse.isActive()).isEqualTo(true)
        assertThat(accountCreateResponse.jurisdiction()).isEqualTo(Jurisdiction.BASELINE)
        assertThat(accountCreateResponse.brokerageAccountId()).contains("brokerage_account_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val accountCreateResponse =
            AccountCreateResponse.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .isActive(true)
                .jurisdiction(Jurisdiction.BASELINE)
                .brokerageAccountId("brokerage_account_id")
                .build()

        val roundtrippedAccountCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountCreateResponse),
                jacksonTypeRef<AccountCreateResponse>(),
            )

        assertThat(roundtrippedAccountCreateResponse).isEqualTo(accountCreateResponse)
    }
}
