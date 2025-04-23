// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.api.v2

import com.dinari.api.TestServerExtension
import com.dinari.api.client.okhttp.DinariOkHttpClient
import com.dinari.api.models.api.v2.accounts.AccountDeactivateParams
import com.dinari.api.models.api.v2.accounts.AccountRetrieveCashParams
import com.dinari.api.models.api.v2.accounts.AccountRetrieveDividendPaymentsParams
import com.dinari.api.models.api.v2.accounts.AccountRetrieveInterestPaymentsParams
import com.dinari.api.models.api.v2.accounts.AccountRetrieveParams
import com.dinari.api.models.api.v2.accounts.AccountRetrievePortfolioParams
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
                .apiKey("My API Key")
                .build()
        val accountService = client.api().v2().accounts()

        val account =
            accountService.retrieve(
                AccountRetrieveParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        account.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun deactivate() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val accountService = client.api().v2().accounts()

        val account =
            accountService.deactivate(
                AccountDeactivateParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        account.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieveCash() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val accountService = client.api().v2().accounts()

        val response =
            accountService.retrieveCash(
                AccountRetrieveCashParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        response.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieveDividendPayments() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val accountService = client.api().v2().accounts()

        val response =
            accountService.retrieveDividendPayments(
                AccountRetrieveDividendPaymentsParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        response.forEach { it.validate() }
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieveInterestPayments() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val accountService = client.api().v2().accounts()

        val response =
            accountService.retrieveInterestPayments(
                AccountRetrieveInterestPaymentsParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        response.forEach { it.validate() }
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrievePortfolio() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val accountService = client.api().v2().accounts()

        val response =
            accountService.retrievePortfolio(
                AccountRetrievePortfolioParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        response.validate()
    }
}
