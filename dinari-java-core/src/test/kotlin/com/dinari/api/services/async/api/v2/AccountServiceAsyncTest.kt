// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.api.v2

import com.dinari.api.TestServerExtension
import com.dinari.api.client.okhttp.DinariOkHttpClientAsync
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
internal class AccountServiceAsyncTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieve() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val accountServiceAsync = client.api().v2().accounts()

        val accountFuture =
            accountServiceAsync.retrieve(
                AccountRetrieveParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val account = accountFuture.get()
        account.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun deactivate() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val accountServiceAsync = client.api().v2().accounts()

        val accountFuture =
            accountServiceAsync.deactivate(
                AccountDeactivateParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val account = accountFuture.get()
        account.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieveCash() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val accountServiceAsync = client.api().v2().accounts()

        val responseFuture =
            accountServiceAsync.retrieveCash(
                AccountRetrieveCashParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieveDividendPayments() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val accountServiceAsync = client.api().v2().accounts()

        val responseFuture =
            accountServiceAsync.retrieveDividendPayments(
                AccountRetrieveDividendPaymentsParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val response = responseFuture.get()
        response.forEach { it.validate() }
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieveInterestPayments() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val accountServiceAsync = client.api().v2().accounts()

        val responseFuture =
            accountServiceAsync.retrieveInterestPayments(
                AccountRetrieveInterestPaymentsParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val response = responseFuture.get()
        response.forEach { it.validate() }
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrievePortfolio() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val accountServiceAsync = client.api().v2().accounts()

        val responseFuture =
            accountServiceAsync.retrievePortfolio(
                AccountRetrievePortfolioParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
