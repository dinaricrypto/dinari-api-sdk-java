// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderrequests.stocks.eip155

import com.dinari.api.core.JsonValue
import com.dinari.api.core.jsonMapper
import com.dinari.api.models.v2.accounts.orders.stocks.eip155.OrderFeeAmount
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class Eip155PrepareProxiedOrderResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val eip155PrepareProxiedOrderResponse =
            Eip155PrepareProxiedOrderResponse.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .deadline(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .addFee(
                    OrderFeeAmount.builder()
                        .feeInEth(0.0)
                        .feeInWei("fee_in_wei")
                        .type(OrderFeeAmount.Type.SPONSORED_NETWORK)
                        .build()
                )
                .orderTypedData(
                    EvmTypedData.builder()
                        .domain(JsonValue.from(mapOf<String, Any>()))
                        .message(JsonValue.from(mapOf<String, Any>()))
                        .primaryType("primaryType")
                        .types(JsonValue.from(mapOf<String, Any>()))
                        .build()
                )
                .permitTypedData(
                    EvmTypedData.builder()
                        .domain(JsonValue.from(mapOf<String, Any>()))
                        .message(JsonValue.from(mapOf<String, Any>()))
                        .primaryType("primaryType")
                        .types(JsonValue.from(mapOf<String, Any>()))
                        .build()
                )
                .build()

        assertThat(eip155PrepareProxiedOrderResponse.id())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(eip155PrepareProxiedOrderResponse.deadline())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(eip155PrepareProxiedOrderResponse.fees())
            .containsExactly(
                OrderFeeAmount.builder()
                    .feeInEth(0.0)
                    .feeInWei("fee_in_wei")
                    .type(OrderFeeAmount.Type.SPONSORED_NETWORK)
                    .build()
            )
        assertThat(eip155PrepareProxiedOrderResponse.orderTypedData())
            .isEqualTo(
                EvmTypedData.builder()
                    .domain(JsonValue.from(mapOf<String, Any>()))
                    .message(JsonValue.from(mapOf<String, Any>()))
                    .primaryType("primaryType")
                    .types(JsonValue.from(mapOf<String, Any>()))
                    .build()
            )
        assertThat(eip155PrepareProxiedOrderResponse.permitTypedData())
            .isEqualTo(
                EvmTypedData.builder()
                    .domain(JsonValue.from(mapOf<String, Any>()))
                    .message(JsonValue.from(mapOf<String, Any>()))
                    .primaryType("primaryType")
                    .types(JsonValue.from(mapOf<String, Any>()))
                    .build()
            )
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val eip155PrepareProxiedOrderResponse =
            Eip155PrepareProxiedOrderResponse.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .deadline(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .addFee(
                    OrderFeeAmount.builder()
                        .feeInEth(0.0)
                        .feeInWei("fee_in_wei")
                        .type(OrderFeeAmount.Type.SPONSORED_NETWORK)
                        .build()
                )
                .orderTypedData(
                    EvmTypedData.builder()
                        .domain(JsonValue.from(mapOf<String, Any>()))
                        .message(JsonValue.from(mapOf<String, Any>()))
                        .primaryType("primaryType")
                        .types(JsonValue.from(mapOf<String, Any>()))
                        .build()
                )
                .permitTypedData(
                    EvmTypedData.builder()
                        .domain(JsonValue.from(mapOf<String, Any>()))
                        .message(JsonValue.from(mapOf<String, Any>()))
                        .primaryType("primaryType")
                        .types(JsonValue.from(mapOf<String, Any>()))
                        .build()
                )
                .build()

        val roundtrippedEip155PrepareProxiedOrderResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(eip155PrepareProxiedOrderResponse),
                jacksonTypeRef<Eip155PrepareProxiedOrderResponse>(),
            )

        assertThat(roundtrippedEip155PrepareProxiedOrderResponse)
            .isEqualTo(eip155PrepareProxiedOrderResponse)
    }
}
