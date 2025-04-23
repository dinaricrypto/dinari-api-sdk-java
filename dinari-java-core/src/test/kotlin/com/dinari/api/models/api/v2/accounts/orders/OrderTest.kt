// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.api.v2.accounts.orders

import com.dinari.api.core.JsonValue
import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import kotlin.jvm.optionals.getOrNull
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
                .assetTokenQuantity(0.0)
                .brokerageOrderStatus(Order.BrokerageOrderStatus.PENDING_SUBMIT)
                .chainId(0L)
                .orderContractAddress("order_contract_address")
                .orderSide(Order.OrderSide.BUY)
                .orderTif(Order.OrderTif.DAY)
                .orderTransactionHash("0xeaF12bD1DfFd")
                .orderType(Order.OrderType.MARKET)
                .paymentTokenQuantity(0.0)
                .smartContractOrderId("smart_contract_order_id")
                .cancelTransactionHash("0xeaF12bD1DfFd")
                .addFee(
                    Order.Fee.builder().putAdditionalProperty("foo", JsonValue.from("bar")).build()
                )
                .networkFeeInUsd(0.0)
                .build()

        assertThat(order.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(order.assetTokenQuantity()).isEqualTo(0.0)
        assertThat(order.brokerageOrderStatus())
            .isEqualTo(Order.BrokerageOrderStatus.PENDING_SUBMIT)
        assertThat(order.chainId()).isEqualTo(0L)
        assertThat(order.orderContractAddress()).isEqualTo("order_contract_address")
        assertThat(order.orderSide()).isEqualTo(Order.OrderSide.BUY)
        assertThat(order.orderTif()).isEqualTo(Order.OrderTif.DAY)
        assertThat(order.orderTransactionHash()).isEqualTo("0xeaF12bD1DfFd")
        assertThat(order.orderType()).isEqualTo(Order.OrderType.MARKET)
        assertThat(order.paymentTokenQuantity()).isEqualTo(0.0)
        assertThat(order.smartContractOrderId()).isEqualTo("smart_contract_order_id")
        assertThat(order.cancelTransactionHash()).contains("0xeaF12bD1DfFd")
        assertThat(order.fees().getOrNull())
            .containsExactly(
                Order.Fee.builder().putAdditionalProperty("foo", JsonValue.from("bar")).build()
            )
        assertThat(order.networkFeeInUsd()).contains(0.0)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val order =
            Order.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .assetTokenQuantity(0.0)
                .brokerageOrderStatus(Order.BrokerageOrderStatus.PENDING_SUBMIT)
                .chainId(0L)
                .orderContractAddress("order_contract_address")
                .orderSide(Order.OrderSide.BUY)
                .orderTif(Order.OrderTif.DAY)
                .orderTransactionHash("0xeaF12bD1DfFd")
                .orderType(Order.OrderType.MARKET)
                .paymentTokenQuantity(0.0)
                .smartContractOrderId("smart_contract_order_id")
                .cancelTransactionHash("0xeaF12bD1DfFd")
                .addFee(
                    Order.Fee.builder().putAdditionalProperty("foo", JsonValue.from("bar")).build()
                )
                .networkFeeInUsd(0.0)
                .build()

        val roundtrippedOrder =
            jsonMapper.readValue(jsonMapper.writeValueAsString(order), jacksonTypeRef<Order>())

        assertThat(roundtrippedOrder).isEqualTo(order)
    }
}
