// File generated from our OpenAPI spec by Stainless.

package com.dinari.models.v2.accounts

import com.dinari.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class AccountGetCashBalancesResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val accountGetCashBalancesResponse =
            AccountGetCashBalancesResponse.builder()
                .amount(0.0)
                .chainId(Chain.EIP155_1)
                .symbol("symbol")
                .tokenAddress("token_address")
                .build()

        assertThat(accountGetCashBalancesResponse.amount()).isEqualTo(0.0)
        assertThat(accountGetCashBalancesResponse.chainId()).isEqualTo(Chain.EIP155_1)
        assertThat(accountGetCashBalancesResponse.symbol()).isEqualTo("symbol")
        assertThat(accountGetCashBalancesResponse.tokenAddress()).isEqualTo("token_address")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val accountGetCashBalancesResponse =
            AccountGetCashBalancesResponse.builder()
                .amount(0.0)
                .chainId(Chain.EIP155_1)
                .symbol("symbol")
                .tokenAddress("token_address")
                .build()

        val roundtrippedAccountGetCashBalancesResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountGetCashBalancesResponse),
                jacksonTypeRef<AccountGetCashBalancesResponse>(),
            )

        assertThat(roundtrippedAccountGetCashBalancesResponse)
            .isEqualTo(accountGetCashBalancesResponse)
    }
}
