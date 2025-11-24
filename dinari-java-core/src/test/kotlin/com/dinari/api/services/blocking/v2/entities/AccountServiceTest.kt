// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.entities

import com.dinari.api.TestServerExtension
import com.dinari.api.client.okhttp.DinariOkHttpClient
import com.dinari.api.models.v2.entities.accounts.AccountCreateParams
import com.dinari.api.models.v2.entities.accounts.AccountListParams
import com.dinari.api.models.v2.entities.accounts.Jurisdiction
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class AccountServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun create() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val accountService = client.v2().entities().accounts()

        val account =
            accountService.create(
                AccountCreateParams.builder()
                    .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .jurisdiction(Jurisdiction.BASELINE)
                    .build()
            )

        account.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun list() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val accountService = client.v2().entities().accounts()

        val accounts =
            accountService.list(
                AccountListParams.builder()
                    .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .page(1L)
                    .pageSize(1L)
                    .build()
            )

        accounts.forEach { it.validate() }
    }
}
