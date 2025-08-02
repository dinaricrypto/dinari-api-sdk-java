// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orders.stocks.eip155

import com.dinari.api.core.JsonValue
import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Eip155PrepareOrderResponseTest {

    @Test
    fun create() {
        val eip155PrepareOrderResponse =
            Eip155PrepareOrderResponse.builder()
                .addFee(
                    OrderFeeAmount.builder()
                        .feeInEth(0.0)
                        .feeInWei("fee_in_wei")
                        .type(OrderFeeAmount.Type.SPONSORED_NETWORK)
                        .build()
                )
                .addTransactionData(
                    Eip155PrepareOrderResponse.TransactionData.builder()
                        .abi(JsonValue.from(mapOf<String, Any>()))
                        .args(JsonValue.from(mapOf<String, Any>()))
                        .contractAddress("contract_address")
                        .data("0xeaF12bD1DfFd")
                        .build()
                )
                .build()

        assertThat(eip155PrepareOrderResponse.fees())
            .containsExactly(
                OrderFeeAmount.builder()
                    .feeInEth(0.0)
                    .feeInWei("fee_in_wei")
                    .type(OrderFeeAmount.Type.SPONSORED_NETWORK)
                    .build()
            )
        assertThat(eip155PrepareOrderResponse.transactionData())
            .containsExactly(
                Eip155PrepareOrderResponse.TransactionData.builder()
                    .abi(JsonValue.from(mapOf<String, Any>()))
                    .args(JsonValue.from(mapOf<String, Any>()))
                    .contractAddress("contract_address")
                    .data("0xeaF12bD1DfFd")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val eip155PrepareOrderResponse =
            Eip155PrepareOrderResponse.builder()
                .addFee(
                    OrderFeeAmount.builder()
                        .feeInEth(0.0)
                        .feeInWei("fee_in_wei")
                        .type(OrderFeeAmount.Type.SPONSORED_NETWORK)
                        .build()
                )
                .addTransactionData(
                    Eip155PrepareOrderResponse.TransactionData.builder()
                        .abi(JsonValue.from(mapOf<String, Any>()))
                        .args(JsonValue.from(mapOf<String, Any>()))
                        .contractAddress("contract_address")
                        .data("0xeaF12bD1DfFd")
                        .build()
                )
                .build()

        val roundtrippedEip155PrepareOrderResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(eip155PrepareOrderResponse),
                jacksonTypeRef<Eip155PrepareOrderResponse>(),
            )

        assertThat(roundtrippedEip155PrepareOrderResponse).isEqualTo(eip155PrepareOrderResponse)
    }
}
