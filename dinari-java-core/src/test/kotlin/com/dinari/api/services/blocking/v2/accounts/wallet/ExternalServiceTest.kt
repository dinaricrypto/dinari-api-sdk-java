// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.accounts.wallet

import com.dinari.api.TestServerExtension
import com.dinari.api.client.okhttp.DinariOkHttpClient
import com.dinari.api.models.v2.accounts.wallet.external.ExternalConnectParams
import com.dinari.api.models.v2.accounts.wallet.external.ExternalGetNonceParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ExternalServiceTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun connect() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val externalService = client.v2().accounts().wallet().external()

        val wallet =
            externalService.connect(
                ExternalConnectParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .chainId(ExternalConnectParams.ChainId.EIP155_1)
                    .nonce("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .signature("0xeaF12bD1DfFd")
                    .walletAddress("wallet_address")
                    .build()
            )

        wallet.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun getNonce() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val externalService = client.v2().accounts().wallet().external()

        val response =
            externalService.getNonce(
                ExternalGetNonceParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .chainId(ExternalGetNonceParams.ChainId.EIP155_1)
                    .walletAddress("wallet_address")
                    .build()
            )

        response.validate()
    }
}
