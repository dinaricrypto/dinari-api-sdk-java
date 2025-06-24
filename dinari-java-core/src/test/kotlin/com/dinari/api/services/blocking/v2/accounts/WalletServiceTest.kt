// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.accounts

import com.dinari.api.TestServerExtension
import com.dinari.api.client.okhttp.DinariOkHttpClient
import com.dinari.api.models.v2.accounts.wallet.WalletConnectInternalParams
import com.dinari.api.models.v2.accounts.wallet.external.WalletChainId
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class WalletServiceTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun connectInternal() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val walletService = client.v2().accounts().wallet()

        val wallet =
            walletService.connectInternal(
                WalletConnectInternalParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .chainId(WalletChainId.EIP155_0)
                    .walletAddress("wallet_address")
                    .isShared(true)
                    .build()
            )

        wallet.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun get() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val walletService = client.v2().accounts().wallet()

        val wallet = walletService.get("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        wallet.validate()
    }
}
