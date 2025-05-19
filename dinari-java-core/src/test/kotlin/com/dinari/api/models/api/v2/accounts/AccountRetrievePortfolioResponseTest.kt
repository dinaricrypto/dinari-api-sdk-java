// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.api.v2.accounts

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class AccountRetrievePortfolioResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val accountRetrievePortfolioResponse =
            AccountRetrievePortfolioResponse.builder()
                .addAsset(
                    AccountRetrievePortfolioResponse.Asset.builder()
                        .amount(0.0)
                        .chainId(AccountRetrievePortfolioResponse.Asset.ChainId.EIP155_1)
                        .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .symbol("symbol")
                        .tokenAddress("token_address")
                        .build()
                )
                .build()

        assertThat(accountRetrievePortfolioResponse.assets())
            .containsExactly(
                AccountRetrievePortfolioResponse.Asset.builder()
                    .amount(0.0)
                    .chainId(AccountRetrievePortfolioResponse.Asset.ChainId.EIP155_1)
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
        val accountRetrievePortfolioResponse =
            AccountRetrievePortfolioResponse.builder()
                .addAsset(
                    AccountRetrievePortfolioResponse.Asset.builder()
                        .amount(0.0)
                        .chainId(AccountRetrievePortfolioResponse.Asset.ChainId.EIP155_1)
                        .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .symbol("symbol")
                        .tokenAddress("token_address")
                        .build()
                )
                .build()

        val roundtrippedAccountRetrievePortfolioResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountRetrievePortfolioResponse),
                jacksonTypeRef<AccountRetrievePortfolioResponse>(),
            )

        assertThat(roundtrippedAccountRetrievePortfolioResponse)
            .isEqualTo(accountRetrievePortfolioResponse)
    }
}
