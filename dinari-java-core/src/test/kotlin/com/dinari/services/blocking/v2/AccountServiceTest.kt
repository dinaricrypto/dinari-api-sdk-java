// File generated from our OpenAPI spec by Stainless.

package com.dinari.services.blocking.v2

import com.dinari.TestServerExtension
import com.dinari.client.okhttp.DinariOkHttpClient
import com.dinari.models.v2.accounts.AccountGetDividendPaymentsParams
import com.dinari.models.v2.accounts.AccountGetInterestPaymentsParams
import com.dinari.models.v2.accounts.AccountMintSandboxTokensParams
import com.dinari.models.v2.accounts.Chain
import java.time.LocalDate
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class AccountServiceTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieve() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val accountService = client.v2().accounts()

        val account = accountService.retrieve("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        account.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun deactivate() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val accountService = client.v2().accounts()

        val account = accountService.deactivate("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        account.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun getCashBalances() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val accountService = client.v2().accounts()

        val response = accountService.getCashBalances("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        response.forEach { it.validate() }
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun getDividendPayments() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val accountService = client.v2().accounts()

        val response =
            accountService.getDividendPayments(
                AccountGetDividendPaymentsParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .endDate(LocalDate.parse("2019-12-27"))
                    .startDate(LocalDate.parse("2019-12-27"))
                    .page(1L)
                    .pageSize(1L)
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        response.forEach { it.validate() }
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun getInterestPayments() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val accountService = client.v2().accounts()

        val response =
            accountService.getInterestPayments(
                AccountGetInterestPaymentsParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .endDate(LocalDate.parse("2019-12-27"))
                    .startDate(LocalDate.parse("2019-12-27"))
                    .page(1L)
                    .pageSize(1L)
                    .build()
            )

        response.forEach { it.validate() }
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun getPortfolio() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val accountService = client.v2().accounts()

        val response = accountService.getPortfolio("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        response.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun mintSandboxTokens() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val accountService = client.v2().accounts()

        accountService.mintSandboxTokens(
            AccountMintSandboxTokensParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .chainId(Chain.EIP155_1)
                .build()
        )
    }
}
