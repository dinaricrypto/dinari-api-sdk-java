// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.api.v2.accounts.orderfulfillments

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class OrderFulfillmentTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val orderFulfillment =
            OrderFulfillment.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .assetTokenFilled(0.0)
                .assetTokenSpent(0.0)
                .chainId(OrderFulfillment.ChainId.EIP155_1)
                .orderId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .paymentTokenFilled(0.0)
                .paymentTokenSpent(0.0)
                .transactionDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .transactionHash("0xeaF12bD1DfFd")
                .paymentTokenFee(0.0)
                .build()

        assertThat(orderFulfillment.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(orderFulfillment.assetTokenFilled()).isEqualTo(0.0)
        assertThat(orderFulfillment.assetTokenSpent()).isEqualTo(0.0)
        assertThat(orderFulfillment.chainId()).isEqualTo(OrderFulfillment.ChainId.EIP155_1)
        assertThat(orderFulfillment.orderId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(orderFulfillment.paymentTokenFilled()).isEqualTo(0.0)
        assertThat(orderFulfillment.paymentTokenSpent()).isEqualTo(0.0)
        assertThat(orderFulfillment.transactionDt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(orderFulfillment.transactionHash()).isEqualTo("0xeaF12bD1DfFd")
        assertThat(orderFulfillment.paymentTokenFee()).contains(0.0)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val orderFulfillment =
            OrderFulfillment.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .assetTokenFilled(0.0)
                .assetTokenSpent(0.0)
                .chainId(OrderFulfillment.ChainId.EIP155_1)
                .orderId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .paymentTokenFilled(0.0)
                .paymentTokenSpent(0.0)
                .transactionDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .transactionHash("0xeaF12bD1DfFd")
                .paymentTokenFee(0.0)
                .build()

        val roundtrippedOrderFulfillment =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(orderFulfillment),
                jacksonTypeRef<OrderFulfillment>(),
            )

        assertThat(roundtrippedOrderFulfillment).isEqualTo(orderFulfillment)
    }
}
