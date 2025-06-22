// File generated from our OpenAPI spec by Stainless.

package com.dinari.models.v2.accounts.orders.stocks.eip155

import com.dinari.core.JsonValue
import com.dinari.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class Eip155PrepareOrderResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val eip155PrepareOrderResponse =
            Eip155PrepareOrderResponse.builder()
                .addFee(
                    Eip155PrepareOrderResponse.Fee.builder()
                        .feeInEth(0.0)
                        .feeInWei("fee_in_wei")
                        .type(Eip155PrepareOrderResponse.Fee.Type.SPONSORED_NETWORK)
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
                Eip155PrepareOrderResponse.Fee.builder()
                    .feeInEth(0.0)
                    .feeInWei("fee_in_wei")
                    .type(Eip155PrepareOrderResponse.Fee.Type.SPONSORED_NETWORK)
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

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val eip155PrepareOrderResponse =
            Eip155PrepareOrderResponse.builder()
                .addFee(
                    Eip155PrepareOrderResponse.Fee.builder()
                        .feeInEth(0.0)
                        .feeInWei("fee_in_wei")
                        .type(Eip155PrepareOrderResponse.Fee.Type.SPONSORED_NETWORK)
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
