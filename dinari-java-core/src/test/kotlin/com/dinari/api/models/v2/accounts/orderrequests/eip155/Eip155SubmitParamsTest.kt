// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderrequests.eip155

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Eip155SubmitParamsTest {

    @Test
    fun create() {
        Eip155SubmitParams.builder()
            .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .orderRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .permitSignature("0xeaF12bD1DfFd")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            Eip155SubmitParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .orderRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .permitSignature("0xeaF12bD1DfFd")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            Eip155SubmitParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .orderRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .permitSignature("0xeaF12bD1DfFd")
                .build()

        val body = params._body()

        assertThat(body.orderRequestId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(body.permitSignature()).isEqualTo("0xeaF12bD1DfFd")
    }
}
