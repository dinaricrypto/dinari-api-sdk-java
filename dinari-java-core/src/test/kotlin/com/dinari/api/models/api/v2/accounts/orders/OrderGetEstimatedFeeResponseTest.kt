// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.api.v2.accounts.orders

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class OrderGetEstimatedFeeResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val orderGetEstimatedFeeResponse =
            OrderGetEstimatedFeeResponse.builder()
                .chainId(0L)
                .feeQuote(
                    OrderGetEstimatedFeeResponse.FeeQuote.builder()
                        .deadline(0L)
                        .fee("fee")
                        .orderId("orderId")
                        .requester("requester")
                        .timestamp(0L)
                        .build()
                )
                .feeQuoteSignature("0xeaF12bD1DfFd")
                .addFee(
                    OrderGetEstimatedFeeResponse.Fee.builder()
                        .feeInEth(0.0)
                        .feeInWei("fee_in_wei")
                        .type(OrderGetEstimatedFeeResponse.Fee.Type.SPONSORED_NETWORK)
                        .build()
                )
                .paymentToken("payment_token")
                .build()

        assertThat(orderGetEstimatedFeeResponse.chainId()).isEqualTo(0L)
        assertThat(orderGetEstimatedFeeResponse.feeQuote())
            .isEqualTo(
                OrderGetEstimatedFeeResponse.FeeQuote.builder()
                    .deadline(0L)
                    .fee("fee")
                    .orderId("orderId")
                    .requester("requester")
                    .timestamp(0L)
                    .build()
            )
        assertThat(orderGetEstimatedFeeResponse.feeQuoteSignature()).isEqualTo("0xeaF12bD1DfFd")
        assertThat(orderGetEstimatedFeeResponse.fees())
            .containsExactly(
                OrderGetEstimatedFeeResponse.Fee.builder()
                    .feeInEth(0.0)
                    .feeInWei("fee_in_wei")
                    .type(OrderGetEstimatedFeeResponse.Fee.Type.SPONSORED_NETWORK)
                    .build()
            )
        assertThat(orderGetEstimatedFeeResponse.paymentToken()).isEqualTo("payment_token")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val orderGetEstimatedFeeResponse =
            OrderGetEstimatedFeeResponse.builder()
                .chainId(0L)
                .feeQuote(
                    OrderGetEstimatedFeeResponse.FeeQuote.builder()
                        .deadline(0L)
                        .fee("fee")
                        .orderId("orderId")
                        .requester("requester")
                        .timestamp(0L)
                        .build()
                )
                .feeQuoteSignature("0xeaF12bD1DfFd")
                .addFee(
                    OrderGetEstimatedFeeResponse.Fee.builder()
                        .feeInEth(0.0)
                        .feeInWei("fee_in_wei")
                        .type(OrderGetEstimatedFeeResponse.Fee.Type.SPONSORED_NETWORK)
                        .build()
                )
                .paymentToken("payment_token")
                .build()

        val roundtrippedOrderGetEstimatedFeeResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(orderGetEstimatedFeeResponse),
                jacksonTypeRef<OrderGetEstimatedFeeResponse>(),
            )

        assertThat(roundtrippedOrderGetEstimatedFeeResponse).isEqualTo(orderGetEstimatedFeeResponse)
    }
}
