// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.entities.accounts

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

internal class AccountListResponseTest {

    @Test
    fun ofAccounts() {
        val accounts =
            listOf(
                Account.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .isActive(true)
                    .jurisdiction(Account.Jurisdiction.BASELINE)
                    .brokerageAccountId("brokerage_account_id")
                    .build()
            )

        val accountListResponse = AccountListResponse.ofAccounts(accounts)

        assertThat(accountListResponse.accounts()).contains(accounts)
        assertThat(accountListResponse.paginatedAccount()).isEmpty
    }

    @Test
    fun ofAccountsRoundtrip() {
        val jsonMapper = jsonMapper()
        val accountListResponse =
            AccountListResponse.ofAccounts(
                listOf(
                    Account.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .isActive(true)
                        .jurisdiction(Account.Jurisdiction.BASELINE)
                        .brokerageAccountId("brokerage_account_id")
                        .build()
                )
            )

        val roundtrippedAccountListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountListResponse),
                jacksonTypeRef<AccountListResponse>(),
            )

        assertThat(roundtrippedAccountListResponse).isEqualTo(accountListResponse)
    }

    @Test
    fun ofPaginatedAccount() {
        val paginatedAccount =
            AccountListResponse.PaginatedAccountResponse.builder()
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
                    AccountListResponse.PaginatedAccountResponse.PaginationMetadata.builder()
                        .next("next")
                        .previous("previous")
                        .build()
                )
                ._sv(AccountListResponse.PaginatedAccountResponse._Sv.PAGINATED_ACCOUNT_RESPONSE_V1)
                .build()

        val accountListResponse = AccountListResponse.ofPaginatedAccount(paginatedAccount)

        assertThat(accountListResponse.accounts()).isEmpty
        assertThat(accountListResponse.paginatedAccount()).contains(paginatedAccount)
    }

    @Test
    fun ofPaginatedAccountRoundtrip() {
        val jsonMapper = jsonMapper()
        val accountListResponse =
            AccountListResponse.ofPaginatedAccount(
                AccountListResponse.PaginatedAccountResponse.builder()
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
                        AccountListResponse.PaginatedAccountResponse.PaginationMetadata.builder()
                            .next("next")
                            .previous("previous")
                            .build()
                    )
                    ._sv(
                        AccountListResponse.PaginatedAccountResponse._Sv
                            .PAGINATED_ACCOUNT_RESPONSE_V1
                    )
                    .build()
            )

        val roundtrippedAccountListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountListResponse),
                jacksonTypeRef<AccountListResponse>(),
            )

        assertThat(roundtrippedAccountListResponse).isEqualTo(accountListResponse)
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
        val accountListResponse =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<AccountListResponse>())

        val e = assertThrows<DinariInvalidDataException> { accountListResponse.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
