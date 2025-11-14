// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderrequests.eip155

import com.dinari.api.core.JsonValue
import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Eip155CreatePermitTransactionResponseTest {

    @Test
    fun create() {
        val eip155CreatePermitTransactionResponse =
            Eip155CreatePermitTransactionResponse.builder()
                .abi(JsonValue.from(mapOf<String, Any>()))
                .args(JsonValue.from(mapOf<String, Any>()))
                .contractAddress("contract_address")
                .data("0xeaF12bD1DfFd")
                .value("value")
                .build()

        assertThat(eip155CreatePermitTransactionResponse._abi())
            .isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(eip155CreatePermitTransactionResponse._args())
            .isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(eip155CreatePermitTransactionResponse.contractAddress())
            .isEqualTo("contract_address")
        assertThat(eip155CreatePermitTransactionResponse.data()).isEqualTo("0xeaF12bD1DfFd")
        assertThat(eip155CreatePermitTransactionResponse.value()).isEqualTo("value")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val eip155CreatePermitTransactionResponse =
            Eip155CreatePermitTransactionResponse.builder()
                .abi(JsonValue.from(mapOf<String, Any>()))
                .args(JsonValue.from(mapOf<String, Any>()))
                .contractAddress("contract_address")
                .data("0xeaF12bD1DfFd")
                .value("value")
                .build()

        val roundtrippedEip155CreatePermitTransactionResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(eip155CreatePermitTransactionResponse),
                jacksonTypeRef<Eip155CreatePermitTransactionResponse>(),
            )

        assertThat(roundtrippedEip155CreatePermitTransactionResponse)
            .isEqualTo(eip155CreatePermitTransactionResponse)
    }
}
