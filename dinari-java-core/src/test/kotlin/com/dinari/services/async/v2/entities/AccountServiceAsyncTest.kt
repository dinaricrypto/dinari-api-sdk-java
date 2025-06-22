// File generated from our OpenAPI spec by Stainless.

package com.dinari.services.async.v2.entities

import com.dinari.TestServerExtension
import com.dinari.client.okhttp.DinariOkHttpClientAsync
import com.dinari.models.v2.entities.accounts.AccountListParams
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
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val accountServiceAsync = client.v2().entities().accounts()

        val accountFuture = accountServiceAsync.create("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        val account = accountFuture.get()
        account.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun list() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val accountServiceAsync = client.v2().entities().accounts()

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
