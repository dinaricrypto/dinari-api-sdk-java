// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.api.v2.entities

import com.dinari.api.TestServerExtension
import com.dinari.api.client.okhttp.DinariOkHttpClientAsync
import com.dinari.api.models.api.v2.entities.accounts.AccountCreateParams
import com.dinari.api.models.api.v2.entities.accounts.AccountListParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class AccountServiceAsyncTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val accountServiceAsync = client.api().v2().entities().accounts()

        val accountFuture =
            accountServiceAsync.create(
                AccountCreateParams.builder()
                    .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val account = accountFuture.get()
        account.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun list() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val accountServiceAsync = client.api().v2().entities().accounts()

        val accountsFuture =
            accountServiceAsync.list(
                AccountListParams.builder()
                    .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .page(1L)
                    .pageSize(1L)
                    .build()
            )

        val accounts = accountsFuture.get()
        accounts.forEach { it.validate() }
    }
}
