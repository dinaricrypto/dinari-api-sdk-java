// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orders.stocks.eip155

import com.dinari.api.core.jsonMapper
import com.dinari.api.models.v2.accounts.Chain
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class Eip155GetFeeQuoteResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val eip155GetFeeQuoteResponse =
            Eip155GetFeeQuoteResponse.builder()
                .chainId(Chain.EIP155_1)
                .fee(0.0)
                .orderFeeContractObject(
                    Eip155GetFeeQuoteResponse.OrderFeeContractObject.builder()
                        .chainId(Eip155GetFeeQuoteResponse.OrderFeeContractObject.ChainId._42161)
                        .feeQuote(
                            Eip155GetFeeQuoteResponse.OrderFeeContractObject.FeeQuote.builder()
                                .deadline(0L)
                                .fee("fee")
                                .orderId("orderId")
                                .requester("requester")
                                .timestamp(0L)
                                .build()
                        )
                        .feeQuoteSignature("0xeaF12bD1DfFd")
                        .addFee(
                            Eip155GetFeeQuoteResponse.OrderFeeContractObject.Fee.builder()
                                .feeInEth(0.0)
                                .feeInWei("fee_in_wei")
                                .type(
                                    Eip155GetFeeQuoteResponse.OrderFeeContractObject.Fee.Type
                                        .SPONSORED_NETWORK
                                )
                                .build()
                        )
                        .paymentToken("payment_token")
                        .build()
                )
                .build()

        assertThat(eip155GetFeeQuoteResponse.chainId()).isEqualTo(Chain.EIP155_1)
        assertThat(eip155GetFeeQuoteResponse.fee()).isEqualTo(0.0)
        assertThat(eip155GetFeeQuoteResponse.orderFeeContractObject())
            .isEqualTo(
                Eip155GetFeeQuoteResponse.OrderFeeContractObject.builder()
                    .chainId(Eip155GetFeeQuoteResponse.OrderFeeContractObject.ChainId._42161)
                    .feeQuote(
                        Eip155GetFeeQuoteResponse.OrderFeeContractObject.FeeQuote.builder()
                            .deadline(0L)
                            .fee("fee")
                            .orderId("orderId")
                            .requester("requester")
                            .timestamp(0L)
                            .build()
                    )
                    .feeQuoteSignature("0xeaF12bD1DfFd")
                    .addFee(
                        Eip155GetFeeQuoteResponse.OrderFeeContractObject.Fee.builder()
                            .feeInEth(0.0)
                            .feeInWei("fee_in_wei")
                            .type(
                                Eip155GetFeeQuoteResponse.OrderFeeContractObject.Fee.Type
                                    .SPONSORED_NETWORK
                            )
                            .build()
                    )
                    .paymentToken("payment_token")
                    .build()
            )
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val eip155GetFeeQuoteResponse =
            Eip155GetFeeQuoteResponse.builder()
                .chainId(Chain.EIP155_1)
                .fee(0.0)
                .orderFeeContractObject(
                    Eip155GetFeeQuoteResponse.OrderFeeContractObject.builder()
                        .chainId(Eip155GetFeeQuoteResponse.OrderFeeContractObject.ChainId._42161)
                        .feeQuote(
                            Eip155GetFeeQuoteResponse.OrderFeeContractObject.FeeQuote.builder()
                                .deadline(0L)
                                .fee("fee")
                                .orderId("orderId")
                                .requester("requester")
                                .timestamp(0L)
                                .build()
                        )
                        .feeQuoteSignature("0xeaF12bD1DfFd")
                        .addFee(
                            Eip155GetFeeQuoteResponse.OrderFeeContractObject.Fee.builder()
                                .feeInEth(0.0)
                                .feeInWei("fee_in_wei")
                                .type(
                                    Eip155GetFeeQuoteResponse.OrderFeeContractObject.Fee.Type
                                        .SPONSORED_NETWORK
                                )
                                .build()
                        )
                        .paymentToken("payment_token")
                        .build()
                )
                .build()

        val roundtrippedEip155GetFeeQuoteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(eip155GetFeeQuoteResponse),
                jacksonTypeRef<Eip155GetFeeQuoteResponse>(),
            )

        assertThat(roundtrippedEip155GetFeeQuoteResponse).isEqualTo(eip155GetFeeQuoteResponse)
    }
}
