// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderrequests.eip155

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Eip155OrderRequestPermitTransactionTest {

    @Test
    fun create() {
        val eip155OrderRequestPermitTransaction =
            Eip155OrderRequestPermitTransaction.builder()
                .orderRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .permitSignature("0xeaF12bD1DfFd")
                .build()

        assertThat(eip155OrderRequestPermitTransaction.orderRequestId())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(eip155OrderRequestPermitTransaction.permitSignature())
            .isEqualTo("0xeaF12bD1DfFd")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val eip155OrderRequestPermitTransaction =
            Eip155OrderRequestPermitTransaction.builder()
                .orderRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .permitSignature("0xeaF12bD1DfFd")
                .build()

        val roundtrippedEip155OrderRequestPermitTransaction =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(eip155OrderRequestPermitTransaction),
                jacksonTypeRef<Eip155OrderRequestPermitTransaction>(),
            )

        assertThat(roundtrippedEip155OrderRequestPermitTransaction)
            .isEqualTo(eip155OrderRequestPermitTransaction)
    }
}
