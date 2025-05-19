// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.api.v2.accounts

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class AccountRetrieveCashResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val accountRetrieveCashResponse =
            AccountRetrieveCashResponse.builder()
                .amount(0.0)
                .chainId(AccountRetrieveCashResponse.ChainId.EIP155_1)
                .symbol("symbol")
                .tokenAddress("token_address")
                .build()

        assertThat(accountRetrieveCashResponse.amount()).isEqualTo(0.0)
        assertThat(accountRetrieveCashResponse.chainId())
            .isEqualTo(AccountRetrieveCashResponse.ChainId.EIP155_1)
        assertThat(accountRetrieveCashResponse.symbol()).isEqualTo("symbol")
        assertThat(accountRetrieveCashResponse.tokenAddress()).isEqualTo("token_address")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val accountRetrieveCashResponse =
            AccountRetrieveCashResponse.builder()
                .amount(0.0)
                .chainId(AccountRetrieveCashResponse.ChainId.EIP155_1)
                .symbol("symbol")
                .tokenAddress("token_address")
                .build()

        val roundtrippedAccountRetrieveCashResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountRetrieveCashResponse),
                jacksonTypeRef<AccountRetrieveCashResponse>(),
            )

        assertThat(roundtrippedAccountRetrieveCashResponse).isEqualTo(accountRetrieveCashResponse)
    }
}
