// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountMintSandboxTokensParamsTest {

    @Test
    fun create() {
        AccountMintSandboxTokensParams.builder()
            .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .chainId(Chain.EIP155_1)
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            AccountMintSandboxTokensParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            AccountMintSandboxTokensParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .chainId(Chain.EIP155_1)
                .build()

        val body = params._body()

        assertThat(body.chainId()).contains(Chain.EIP155_1)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            AccountMintSandboxTokensParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        val body = params._body()
    }
}
