// File generated from our OpenAPI spec by Stainless.

package com.dinari.models.v2.accounts.orderrequests.stocks.eip155

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class Eip155CreateProxiedOrderParamsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        Eip155CreateProxiedOrderParams.builder()
            .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .orderSignature("0xeaF12bD1DfFd")
            .permitSignature("0xeaF12bD1DfFd")
            .preparedProxiedOrderId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun pathParams() {
        val params =
            Eip155CreateProxiedOrderParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .orderSignature("0xeaF12bD1DfFd")
                .permitSignature("0xeaF12bD1DfFd")
                .preparedProxiedOrderId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun body() {
        val params =
            Eip155CreateProxiedOrderParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .orderSignature("0xeaF12bD1DfFd")
                .permitSignature("0xeaF12bD1DfFd")
                .preparedProxiedOrderId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        val body = params._body()

        assertThat(body.orderSignature()).isEqualTo("0xeaF12bD1DfFd")
        assertThat(body.permitSignature()).isEqualTo("0xeaF12bD1DfFd")
        assertThat(body.preparedProxiedOrderId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
    }
}
