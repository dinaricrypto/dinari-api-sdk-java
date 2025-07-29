// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orders.stocks.eip155

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OrderFeeAmountTest {

    @Test
    fun create() {
        val orderFeeAmount =
            OrderFeeAmount.builder()
                .feeInEth(0.0)
                .feeInWei("fee_in_wei")
                .type(OrderFeeAmount.Type.SPONSORED_NETWORK)
                .build()

        assertThat(orderFeeAmount.feeInEth()).isEqualTo(0.0)
        assertThat(orderFeeAmount.feeInWei()).isEqualTo("fee_in_wei")
        assertThat(orderFeeAmount.type()).isEqualTo(OrderFeeAmount.Type.SPONSORED_NETWORK)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val orderFeeAmount =
            OrderFeeAmount.builder()
                .feeInEth(0.0)
                .feeInWei("fee_in_wei")
                .type(OrderFeeAmount.Type.SPONSORED_NETWORK)
                .build()

        val roundtrippedOrderFeeAmount =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(orderFeeAmount),
                jacksonTypeRef<OrderFeeAmount>(),
            )

        assertThat(roundtrippedOrderFeeAmount).isEqualTo(orderFeeAmount)
    }
}
