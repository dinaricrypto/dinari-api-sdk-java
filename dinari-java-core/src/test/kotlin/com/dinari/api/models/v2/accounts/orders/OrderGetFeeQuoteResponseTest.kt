// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orders

import com.dinari.api.core.jsonMapper
import com.dinari.api.models.v2.accounts.Chain
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class OrderGetFeeQuoteResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val orderGetFeeQuoteResponse =
            OrderGetFeeQuoteResponse.builder()
                .chainId(Chain.EIP155_1)
                .fee(0.0)
                .orderFeeContractObject(
                    OrderGetFeeQuoteResponse.OrderFeeContractObject.builder()
                        .chainId(0L)
                        .feeQuote(
                            OrderGetFeeQuoteResponse.OrderFeeContractObject.FeeQuote.builder()
                                .deadline(0L)
                                .fee("fee")
                                .orderId("orderId")
                                .requester("requester")
                                .timestamp(0L)
                                .build()
                        )
                        .feeQuoteSignature("0xeaF12bD1DfFd")
                        .addFee(
                            OrderGetFeeQuoteResponse.OrderFeeContractObject.Fee.builder()
                                .feeInEth(0.0)
                                .feeInWei("fee_in_wei")
                                .type(
                                    OrderGetFeeQuoteResponse.OrderFeeContractObject.Fee.Type
                                        .SPONSORED_NETWORK
                                )
                                .build()
                        )
                        .paymentToken("payment_token")
                        .build()
                )
                .build()

        assertThat(orderGetFeeQuoteResponse.chainId()).isEqualTo(Chain.EIP155_1)
        assertThat(orderGetFeeQuoteResponse.fee()).isEqualTo(0.0)
        assertThat(orderGetFeeQuoteResponse.orderFeeContractObject())
            .isEqualTo(
                OrderGetFeeQuoteResponse.OrderFeeContractObject.builder()
                    .chainId(0L)
                    .feeQuote(
                        OrderGetFeeQuoteResponse.OrderFeeContractObject.FeeQuote.builder()
                            .deadline(0L)
                            .fee("fee")
                            .orderId("orderId")
                            .requester("requester")
                            .timestamp(0L)
                            .build()
                    )
                    .feeQuoteSignature("0xeaF12bD1DfFd")
                    .addFee(
                        OrderGetFeeQuoteResponse.OrderFeeContractObject.Fee.builder()
                            .feeInEth(0.0)
                            .feeInWei("fee_in_wei")
                            .type(
                                OrderGetFeeQuoteResponse.OrderFeeContractObject.Fee.Type
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
        val orderGetFeeQuoteResponse =
            OrderGetFeeQuoteResponse.builder()
                .chainId(Chain.EIP155_1)
                .fee(0.0)
                .orderFeeContractObject(
                    OrderGetFeeQuoteResponse.OrderFeeContractObject.builder()
                        .chainId(0L)
                        .feeQuote(
                            OrderGetFeeQuoteResponse.OrderFeeContractObject.FeeQuote.builder()
                                .deadline(0L)
                                .fee("fee")
                                .orderId("orderId")
                                .requester("requester")
                                .timestamp(0L)
                                .build()
                        )
                        .feeQuoteSignature("0xeaF12bD1DfFd")
                        .addFee(
                            OrderGetFeeQuoteResponse.OrderFeeContractObject.Fee.builder()
                                .feeInEth(0.0)
                                .feeInWei("fee_in_wei")
                                .type(
                                    OrderGetFeeQuoteResponse.OrderFeeContractObject.Fee.Type
                                        .SPONSORED_NETWORK
                                )
                                .build()
                        )
                        .paymentToken("payment_token")
                        .build()
                )
                .build()

        val roundtrippedOrderGetFeeQuoteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(orderGetFeeQuoteResponse),
                jacksonTypeRef<OrderGetFeeQuoteResponse>(),
            )

        assertThat(roundtrippedOrderGetFeeQuoteResponse).isEqualTo(orderGetFeeQuoteResponse)
    }
}
