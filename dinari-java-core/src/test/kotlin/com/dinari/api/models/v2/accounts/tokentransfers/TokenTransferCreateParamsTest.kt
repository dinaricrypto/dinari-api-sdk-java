// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.tokentransfers

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TokenTransferCreateParamsTest {

    @Test
    fun create() {
        TokenTransferCreateParams.builder()
            .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .quantity(0.0)
            .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .tokenAddress("token_address")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            TokenTransferCreateParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .quantity(0.0)
                .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .tokenAddress("token_address")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            TokenTransferCreateParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .quantity(0.0)
                .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .tokenAddress("token_address")
                .build()

        val body = params._body()

        assertThat(body.quantity()).isEqualTo(0.0)
        assertThat(body.recipientAccountId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(body.tokenAddress()).isEqualTo("token_address")
    }
}
