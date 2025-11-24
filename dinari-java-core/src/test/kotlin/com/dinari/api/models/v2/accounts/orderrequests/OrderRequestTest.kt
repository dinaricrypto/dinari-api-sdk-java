// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderrequests

import com.dinari.api.core.jsonMapper
import com.dinari.api.models.v2.accounts.orders.OrderSide
import com.dinari.api.models.v2.accounts.orders.OrderTif
import com.dinari.api.models.v2.accounts.orders.OrderType
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OrderRequestTest {

    @Test
    fun create() {
        val orderRequest =
            OrderRequest.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .orderSide(OrderSide.BUY)
                .orderTif(OrderTif.DAY)
                .orderType(OrderType.MARKET)
                .status(OrderRequestStatus.QUOTED)
                .clientOrderId("client_order_id")
                .orderId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        assertThat(orderRequest.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(orderRequest.accountId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(orderRequest.createdDt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(orderRequest.orderSide()).isEqualTo(OrderSide.BUY)
        assertThat(orderRequest.orderTif()).isEqualTo(OrderTif.DAY)
        assertThat(orderRequest.orderType()).isEqualTo(OrderType.MARKET)
        assertThat(orderRequest.status()).isEqualTo(OrderRequestStatus.QUOTED)
        assertThat(orderRequest.clientOrderId()).contains("client_order_id")
        assertThat(orderRequest.orderId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(orderRequest.recipientAccountId())
            .contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val orderRequest =
            OrderRequest.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .orderSide(OrderSide.BUY)
                .orderTif(OrderTif.DAY)
                .orderType(OrderType.MARKET)
                .status(OrderRequestStatus.QUOTED)
                .clientOrderId("client_order_id")
                .orderId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        val roundtrippedOrderRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(orderRequest),
                jacksonTypeRef<OrderRequest>(),
            )

        assertThat(roundtrippedOrderRequest).isEqualTo(orderRequest)
    }
}
