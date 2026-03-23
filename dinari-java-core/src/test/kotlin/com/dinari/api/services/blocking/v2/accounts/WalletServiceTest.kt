// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.accounts

import com.dinari.api.client.okhttp.DinariOkHttpClient
import com.dinari.api.models.v2.accounts.wallet.WalletConnectInternalParams
import com.dinari.api.models.v2.accounts.wallet.external.WalletChainId
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class WalletServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun connectInternal() {
        val client =
            DinariOkHttpClient.builder()
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

    @Disabled("Mock server tests are disabled")
    @Test
    fun get() {
        val client =
            DinariOkHttpClient.builder()
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val walletService = client.v2().accounts().wallet()

        val wallet = walletService.get("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        wallet.validate()
    }
}
