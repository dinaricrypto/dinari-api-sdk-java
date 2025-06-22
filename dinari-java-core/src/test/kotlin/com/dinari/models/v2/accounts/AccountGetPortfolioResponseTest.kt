// File generated from our OpenAPI spec by Stainless.

package com.dinari.models.v2.accounts

import com.dinari.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class AccountGetPortfolioResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val accountGetPortfolioResponse =
            AccountGetPortfolioResponse.builder()
                .addAsset(
                    AccountGetPortfolioResponse.Asset.builder()
                        .amount(0.0)
                        .chainId(Chain.EIP155_1)
                        .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .symbol("symbol")
                        .tokenAddress("token_address")
                        .build()
                )
                .build()

        assertThat(accountGetPortfolioResponse.assets())
            .containsExactly(
                AccountGetPortfolioResponse.Asset.builder()
                    .amount(0.0)
                    .chainId(Chain.EIP155_1)
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .symbol("symbol")
                    .tokenAddress("token_address")
                    .build()
            )
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val accountGetPortfolioResponse =
            AccountGetPortfolioResponse.builder()
                .addAsset(
                    AccountGetPortfolioResponse.Asset.builder()
                        .amount(0.0)
                        .chainId(Chain.EIP155_1)
                        .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .symbol("symbol")
                        .tokenAddress("token_address")
                        .build()
                )
                .build()

        val roundtrippedAccountGetPortfolioResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountGetPortfolioResponse),
                jacksonTypeRef<AccountGetPortfolioResponse>(),
            )

        assertThat(roundtrippedAccountGetPortfolioResponse).isEqualTo(accountGetPortfolioResponse)
    }
}
