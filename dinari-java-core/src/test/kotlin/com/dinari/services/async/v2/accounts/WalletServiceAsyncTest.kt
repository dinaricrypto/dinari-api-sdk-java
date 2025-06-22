// File generated from our OpenAPI spec by Stainless.

package com.dinari.services.async.v2.accounts

import com.dinari.TestServerExtension
import com.dinari.client.okhttp.DinariOkHttpClientAsync
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class WalletServiceAsyncTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun get() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val walletServiceAsync = client.v2().accounts().wallet()

        val walletFuture = walletServiceAsync.get("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        val wallet = walletFuture.get()
        wallet.validate()
    }
}
