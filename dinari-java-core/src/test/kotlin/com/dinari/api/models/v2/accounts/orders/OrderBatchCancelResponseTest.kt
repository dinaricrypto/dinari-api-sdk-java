// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orders

import com.dinari.api.core.jsonMapper
import com.dinari.api.models.v2.accounts.Chain
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OrderBatchCancelResponseTest {

    @Test
    fun create() {
        val orderBatchCancelResponse =
            OrderBatchCancelResponse.builder()
                .addCancelQueuedOrder(
                    Order.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .chainId(Chain.EIP155_1)
                        .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .orderContractAddress("order_contract_address")
                        .orderSide(OrderSide.BUY)
                        .orderTif(OrderTif.DAY)
                        .orderTransactionHash("0xeaF12bD1DfFd")
                        .orderType(OrderType.MARKET)
                        .paymentToken("payment_token")
                        .status(BrokerageOrderStatus.PENDING_SUBMIT)
                        .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .assetToken("asset_token")
                        .assetTokenQuantity(0.0)
                        .cancelTransactionHash("0xeaF12bD1DfFd")
                        .clientOrderId("client_order_id")
                        .fee(0.0)
                        .limitPrice(0.0)
                        .orderRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .paymentTokenQuantity(0.0)
                        .build()
                )
                .addFailedToCancelOrder(
                    Order.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .chainId(Chain.EIP155_1)
                        .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .orderContractAddress("order_contract_address")
                        .orderSide(OrderSide.BUY)
                        .orderTif(OrderTif.DAY)
                        .orderTransactionHash("0xeaF12bD1DfFd")
                        .orderType(OrderType.MARKET)
                        .paymentToken("payment_token")
                        .status(BrokerageOrderStatus.PENDING_SUBMIT)
                        .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .assetToken("asset_token")
                        .assetTokenQuantity(0.0)
                        .cancelTransactionHash("0xeaF12bD1DfFd")
                        .clientOrderId("client_order_id")
                        .fee(0.0)
                        .limitPrice(0.0)
                        .orderRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .paymentTokenQuantity(0.0)
                        .build()
                )
                .build()

        assertThat(orderBatchCancelResponse.cancelQueuedOrders())
            .containsExactly(
                Order.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .chainId(Chain.EIP155_1)
                    .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .orderContractAddress("order_contract_address")
                    .orderSide(OrderSide.BUY)
                    .orderTif(OrderTif.DAY)
                    .orderTransactionHash("0xeaF12bD1DfFd")
                    .orderType(OrderType.MARKET)
                    .paymentToken("payment_token")
                    .status(BrokerageOrderStatus.PENDING_SUBMIT)
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .assetToken("asset_token")
                    .assetTokenQuantity(0.0)
                    .cancelTransactionHash("0xeaF12bD1DfFd")
                    .clientOrderId("client_order_id")
                    .fee(0.0)
                    .limitPrice(0.0)
                    .orderRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .paymentTokenQuantity(0.0)
                    .build()
            )
        assertThat(orderBatchCancelResponse.failedToCancelOrders())
            .containsExactly(
                Order.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .chainId(Chain.EIP155_1)
                    .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .orderContractAddress("order_contract_address")
                    .orderSide(OrderSide.BUY)
                    .orderTif(OrderTif.DAY)
                    .orderTransactionHash("0xeaF12bD1DfFd")
                    .orderType(OrderType.MARKET)
                    .paymentToken("payment_token")
                    .status(BrokerageOrderStatus.PENDING_SUBMIT)
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .assetToken("asset_token")
                    .assetTokenQuantity(0.0)
                    .cancelTransactionHash("0xeaF12bD1DfFd")
                    .clientOrderId("client_order_id")
                    .fee(0.0)
                    .limitPrice(0.0)
                    .orderRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .paymentTokenQuantity(0.0)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val orderBatchCancelResponse =
            OrderBatchCancelResponse.builder()
                .addCancelQueuedOrder(
                    Order.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .chainId(Chain.EIP155_1)
                        .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .orderContractAddress("order_contract_address")
                        .orderSide(OrderSide.BUY)
                        .orderTif(OrderTif.DAY)
                        .orderTransactionHash("0xeaF12bD1DfFd")
                        .orderType(OrderType.MARKET)
                        .paymentToken("payment_token")
                        .status(BrokerageOrderStatus.PENDING_SUBMIT)
                        .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .assetToken("asset_token")
                        .assetTokenQuantity(0.0)
                        .cancelTransactionHash("0xeaF12bD1DfFd")
                        .clientOrderId("client_order_id")
                        .fee(0.0)
                        .limitPrice(0.0)
                        .orderRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .paymentTokenQuantity(0.0)
                        .build()
                )
                .addFailedToCancelOrder(
                    Order.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .chainId(Chain.EIP155_1)
                        .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .orderContractAddress("order_contract_address")
                        .orderSide(OrderSide.BUY)
                        .orderTif(OrderTif.DAY)
                        .orderTransactionHash("0xeaF12bD1DfFd")
                        .orderType(OrderType.MARKET)
                        .paymentToken("payment_token")
                        .status(BrokerageOrderStatus.PENDING_SUBMIT)
                        .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .assetToken("asset_token")
                        .assetTokenQuantity(0.0)
                        .cancelTransactionHash("0xeaF12bD1DfFd")
                        .clientOrderId("client_order_id")
                        .fee(0.0)
                        .limitPrice(0.0)
                        .orderRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .paymentTokenQuantity(0.0)
                        .build()
                )
                .build()

        val roundtrippedOrderBatchCancelResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(orderBatchCancelResponse),
                jacksonTypeRef<OrderBatchCancelResponse>(),
            )

        assertThat(roundtrippedOrderBatchCancelResponse).isEqualTo(orderBatchCancelResponse)
    }
}
