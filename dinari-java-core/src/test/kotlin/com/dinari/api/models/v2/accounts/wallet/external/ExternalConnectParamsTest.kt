// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.wallet.external

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExternalConnectParamsTest {

    @Test
    fun create() {
        ExternalConnectParams.builder()
            .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .chainId(WalletChainId.EIP155_0)
            .nonce("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .signature("0xeaF12bD1DfFd")
            .walletAddress("wallet_address")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            ExternalConnectParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .chainId(WalletChainId.EIP155_0)
                .nonce("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .signature("0xeaF12bD1DfFd")
                .walletAddress("wallet_address")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            ExternalConnectParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .chainId(WalletChainId.EIP155_0)
                .nonce("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .signature("0xeaF12bD1DfFd")
                .walletAddress("wallet_address")
                .build()

        val body = params._body()

        assertThat(body.chainId()).isEqualTo(WalletChainId.EIP155_0)
        assertThat(body.nonce()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(body.signature()).isEqualTo("0xeaF12bD1DfFd")
        assertThat(body.walletAddress()).isEqualTo("wallet_address")
    }
}
