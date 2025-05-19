// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.api.v2.accounts.wallet

import com.dinari.api.TestServerExtension
import com.dinari.api.client.okhttp.DinariOkHttpClientAsync
import com.dinari.api.models.api.v2.accounts.wallet.external.ExternalConnectParams
import com.dinari.api.models.api.v2.accounts.wallet.external.ExternalGetNonceParams
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
                .apiKey("My API Key")
                .secret("My Secret")
                .build()
        val externalServiceAsync = client.api().v2().accounts().wallet().external()

        val walletFuture =
            externalServiceAsync.connect(
                ExternalConnectParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .chainId(ExternalConnectParams.ChainId.EIP155_1)
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
                .apiKey("My API Key")
                .secret("My Secret")
                .build()
        val externalServiceAsync = client.api().v2().accounts().wallet().external()

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
