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
                        .marketValue(0.0)
                        .stockId("stock_id")
                        .build()
                )
                .build()

        assertThat(accountRetrievePortfolioResponse.assets())
            .containsExactly(
                AccountRetrievePortfolioResponse.Asset.builder()
                    .amount(0.0)
                    .marketValue(0.0)
                    .stockId("stock_id")
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
                        .marketValue(0.0)
                        .stockId("stock_id")
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
