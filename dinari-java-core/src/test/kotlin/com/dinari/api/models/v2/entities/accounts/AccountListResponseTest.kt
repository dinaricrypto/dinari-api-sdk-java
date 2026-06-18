// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.entities.accounts

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountListResponseTest {

    @Test
    fun create() {
        val accountListResponse =
            AccountListResponse.builder()
                .addData(
                    Account.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .isActive(true)
                        .jurisdiction(Account.Jurisdiction.BASELINE)
                        .brokerageAccountId("brokerage_account_id")
                        .build()
                )
                .paginationMetadata(
                    AccountListResponse.PaginationMetadata.builder()
                        .next("next")
                        .previous("previous")
                        .build()
                )
                ._sv(AccountListResponse._Sv.PAGINATED_ACCOUNT_RESPONSE_V1)
                .build()

        assertThat(accountListResponse.data())
            .containsExactly(
                Account.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .isActive(true)
                    .jurisdiction(Account.Jurisdiction.BASELINE)
                    .brokerageAccountId("brokerage_account_id")
                    .build()
            )
        assertThat(accountListResponse.paginationMetadata())
            .isEqualTo(
                AccountListResponse.PaginationMetadata.builder()
                    .next("next")
                    .previous("previous")
                    .build()
            )
        assertThat(accountListResponse._sv())
            .contains(AccountListResponse._Sv.PAGINATED_ACCOUNT_RESPONSE_V1)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val accountListResponse =
            AccountListResponse.builder()
                .addData(
                    Account.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .isActive(true)
                        .jurisdiction(Account.Jurisdiction.BASELINE)
                        .brokerageAccountId("brokerage_account_id")
                        .build()
                )
                .paginationMetadata(
                    AccountListResponse.PaginationMetadata.builder()
                        .next("next")
                        .previous("previous")
                        .build()
                )
                ._sv(AccountListResponse._Sv.PAGINATED_ACCOUNT_RESPONSE_V1)
                .build()

        val roundtrippedAccountListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountListResponse),
                jacksonTypeRef<AccountListResponse>(),
            )

        assertThat(roundtrippedAccountListResponse).isEqualTo(accountListResponse)
    }
}
