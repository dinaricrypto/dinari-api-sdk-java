// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.api.v2.accounts.orders

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class OrderTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val order =
            Order.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .chainId(Order.ChainId.EIP155_1)
                .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .orderContractAddress("order_contract_address")
                .orderSide(Order.OrderSide.BUY)
                .orderTif(Order.OrderTif.DAY)
                .orderTransactionHash("0xeaF12bD1DfFd")
                .orderType(Order.OrderType.MARKET)
                .status(Order.Status.PENDING_SUBMIT)
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .assetToken("asset_token")
                .assetTokenQuantity(0.0)
                .cancelTransactionHash("0xeaF12bD1DfFd")
                .fee(0.0)
                .limitPrice(0.0)
                .paymentToken("payment_token")
                .paymentTokenQuantity(0.0)
                .build()

        assertThat(order.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(order.chainId()).isEqualTo(Order.ChainId.EIP155_1)
        assertThat(order.createdDt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(order.orderContractAddress()).isEqualTo("order_contract_address")
        assertThat(order.orderSide()).isEqualTo(Order.OrderSide.BUY)
        assertThat(order.orderTif()).isEqualTo(Order.OrderTif.DAY)
        assertThat(order.orderTransactionHash()).isEqualTo("0xeaF12bD1DfFd")
        assertThat(order.orderType()).isEqualTo(Order.OrderType.MARKET)
        assertThat(order.status()).isEqualTo(Order.Status.PENDING_SUBMIT)
        assertThat(order.stockId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(order.assetToken()).contains("asset_token")
        assertThat(order.assetTokenQuantity()).contains(0.0)
        assertThat(order.cancelTransactionHash()).contains("0xeaF12bD1DfFd")
        assertThat(order.fee()).contains(0.0)
        assertThat(order.limitPrice()).contains(0.0)
        assertThat(order.paymentToken()).contains("payment_token")
        assertThat(order.paymentTokenQuantity()).contains(0.0)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val order =
            Order.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .chainId(Order.ChainId.EIP155_1)
                .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .orderContractAddress("order_contract_address")
                .orderSide(Order.OrderSide.BUY)
                .orderTif(Order.OrderTif.DAY)
                .orderTransactionHash("0xeaF12bD1DfFd")
                .orderType(Order.OrderType.MARKET)
                .status(Order.Status.PENDING_SUBMIT)
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .assetToken("asset_token")
                .assetTokenQuantity(0.0)
                .cancelTransactionHash("0xeaF12bD1DfFd")
                .fee(0.0)
                .limitPrice(0.0)
                .paymentToken("payment_token")
                .paymentTokenQuantity(0.0)
                .build()

        val roundtrippedOrder =
            jsonMapper.readValue(jsonMapper.writeValueAsString(order), jacksonTypeRef<Order>())

        assertThat(roundtrippedOrder).isEqualTo(order)
    }
}
