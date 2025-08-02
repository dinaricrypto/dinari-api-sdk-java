// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountGetCashBalancesResponseTest {

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
