// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderrequests.stocks.eip155

import com.dinari.api.core.JsonValue
import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EvmTypedDataTest {

    @Test
    fun create() {
        val evmTypedData =
            EvmTypedData.builder()
                .domain(JsonValue.from(mapOf<String, Any>()))
                .message(JsonValue.from(mapOf<String, Any>()))
                .primaryType("primaryType")
                .types(JsonValue.from(mapOf<String, Any>()))
                .build()

        assertThat(evmTypedData._domain()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(evmTypedData._message()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(evmTypedData.primaryType()).isEqualTo("primaryType")
        assertThat(evmTypedData._types()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val evmTypedData =
            EvmTypedData.builder()
                .domain(JsonValue.from(mapOf<String, Any>()))
                .message(JsonValue.from(mapOf<String, Any>()))
                .primaryType("primaryType")
                .types(JsonValue.from(mapOf<String, Any>()))
                .build()

        val roundtrippedEvmTypedData =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(evmTypedData),
                jacksonTypeRef<EvmTypedData>(),
            )

        assertThat(roundtrippedEvmTypedData).isEqualTo(evmTypedData)
    }
}
