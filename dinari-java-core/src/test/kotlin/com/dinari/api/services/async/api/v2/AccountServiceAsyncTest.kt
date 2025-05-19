// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.api.v2

import com.dinari.api.TestServerExtension
import com.dinari.api.client.okhttp.DinariOkHttpClientAsync
import com.dinari.api.models.api.v2.accounts.AccountRetrieveDividendPaymentsParams
import com.dinari.api.models.api.v2.accounts.AccountRetrieveInterestPaymentsParams
import java.time.LocalDate
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
                .secret("My Secret")
                .build()
        val accountServiceAsync = client.api().v2().accounts()

        val accountFuture = accountServiceAsync.retrieve("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

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
                .secret("My Secret")
                .build()
        val accountServiceAsync = client.api().v2().accounts()

        val accountFuture = accountServiceAsync.deactivate("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

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
                .secret("My Secret")
                .build()
        val accountServiceAsync = client.api().v2().accounts()

        val responseFuture =
            accountServiceAsync.retrieveCash("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        val response = responseFuture.get()
        response.forEach { it.validate() }
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieveDividendPayments() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .secret("My Secret")
                .build()
        val accountServiceAsync = client.api().v2().accounts()

        val responseFuture =
            accountServiceAsync.retrieveDividendPayments(
                AccountRetrieveDividendPaymentsParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .endDate(LocalDate.parse("2019-12-27"))
                    .startDate(LocalDate.parse("2019-12-27"))
                    .page(1L)
                    .pageSize(1L)
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
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
                .secret("My Secret")
                .build()
        val accountServiceAsync = client.api().v2().accounts()

        val responseFuture =
            accountServiceAsync.retrieveInterestPayments(
                AccountRetrieveInterestPaymentsParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .endDate(LocalDate.parse("2019-12-27"))
                    .startDate(LocalDate.parse("2019-12-27"))
                    .page(1L)
                    .pageSize(1L)
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
                .secret("My Secret")
                .build()
        val accountServiceAsync = client.api().v2().accounts()

        val responseFuture =
            accountServiceAsync.retrievePortfolio("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        val response = responseFuture.get()
        response.validate()
    }
}
