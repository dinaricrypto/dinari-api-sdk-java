// File generated from our OpenAPI spec by Stainless.

package com.dinari.services.async.v2.accounts.wallet

import com.dinari.TestServerExtension
import com.dinari.client.okhttp.DinariOkHttpClientAsync
import com.dinari.models.v2.accounts.Chain
import com.dinari.models.v2.accounts.wallet.external.ExternalConnectParams
import com.dinari.models.v2.accounts.wallet.external.ExternalGetNonceParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ExternalServiceAsyncTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun connect() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val externalServiceAsync = client.v2().accounts().wallet().external()

        val walletFuture =
            externalServiceAsync.connect(
                ExternalConnectParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .chainId(Chain.EIP155_1)
                    .nonce("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .signature("0xeaF12bD1DfFd")
                    .walletAddress("wallet_address")
                    .build()
            )

        val wallet = walletFuture.get()
        wallet.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun getNonce() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val externalServiceAsync = client.v2().accounts().wallet().external()

        val responseFuture =
            externalServiceAsync.getNonce(
                ExternalGetNonceParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .walletAddress("wallet_address")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
