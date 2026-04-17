// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts

import com.dinari.api.core.jsonMapper
import com.dinari.api.models.v2.entities.accounts.Jurisdiction
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountRetrieveResponseTest {

    @Test
    fun create() {
        val accountRetrieveResponse =
            AccountRetrieveResponse.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .isActive(true)
                .jurisdiction(Jurisdiction.BASELINE)
                .brokerageAccountId("brokerage_account_id")
                .build()

        assertThat(accountRetrieveResponse.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(accountRetrieveResponse.createdDt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(accountRetrieveResponse.entityId())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(accountRetrieveResponse.isActive()).isEqualTo(true)
        assertThat(accountRetrieveResponse.jurisdiction()).isEqualTo(Jurisdiction.BASELINE)
        assertThat(accountRetrieveResponse.brokerageAccountId()).contains("brokerage_account_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val accountRetrieveResponse =
            AccountRetrieveResponse.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .isActive(true)
                .jurisdiction(Jurisdiction.BASELINE)
                .brokerageAccountId("brokerage_account_id")
                .build()

        val roundtrippedAccountRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountRetrieveResponse),
                jacksonTypeRef<AccountRetrieveResponse>(),
            )

        assertThat(roundtrippedAccountRetrieveResponse).isEqualTo(accountRetrieveResponse)
    }
}
