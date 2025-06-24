// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.wallet

import com.dinari.api.models.v2.accounts.wallet.external.WalletChainId
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class WalletConnectInternalParamsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        WalletConnectInternalParams.builder()
            .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .chainId(WalletChainId.EIP155_0)
            .walletAddress("wallet_address")
            .isShared(true)
            .build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun pathParams() {
        val params =
            WalletConnectInternalParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .chainId(WalletChainId.EIP155_0)
                .walletAddress("wallet_address")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun body() {
        val params =
            WalletConnectInternalParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .chainId(WalletChainId.EIP155_0)
                .walletAddress("wallet_address")
                .isShared(true)
                .build()

        val body = params._body()

        assertThat(body.chainId()).isEqualTo(WalletChainId.EIP155_0)
        assertThat(body.walletAddress()).isEqualTo("wallet_address")
        assertThat(body.isShared()).contains(true)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            WalletConnectInternalParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .chainId(WalletChainId.EIP155_0)
                .walletAddress("wallet_address")
                .build()

        val body = params._body()

        assertThat(body.chainId()).isEqualTo(WalletChainId.EIP155_0)
        assertThat(body.walletAddress()).isEqualTo("wallet_address")
    }
}
