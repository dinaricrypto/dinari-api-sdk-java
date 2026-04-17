// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orders

import com.dinari.api.core.JsonValue
import com.dinari.api.core.jsonMapper
import com.dinari.api.errors.DinariInvalidDataException
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class OrderListResponseTest {

    @Test
    fun ofAccountOrders() {
        val accountOrders =
            listOf(
                OrderListResponse.AccountOrder.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .chainId("chain_id")
                    .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .orderContractAddress("order_contract_address")
                    .orderSide(OrderListResponse.AccountOrder.OrderSide.BUY)
                    .orderTif(OrderListResponse.AccountOrder.OrderTif.DAY)
                    .orderTransactionHash("0xeaF12bD1DfFd")
                    .orderType(OrderListResponse.AccountOrder.OrderType.MARKET)
                    .paymentToken("payment_token")
                    .status(OrderListResponse.AccountOrder.Status.PENDING_SUBMIT)
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

        val orderListResponse = OrderListResponse.ofAccountOrders(accountOrders)

        assertThat(orderListResponse.accountOrders()).contains(accountOrders)
        assertThat(orderListResponse.paginatedAccountOrder()).isEmpty
    }

    @Test
    fun ofAccountOrdersRoundtrip() {
        val jsonMapper = jsonMapper()
        val orderListResponse =
            OrderListResponse.ofAccountOrders(
                listOf(
                    OrderListResponse.AccountOrder.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .chainId("chain_id")
                        .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .orderContractAddress("order_contract_address")
                        .orderSide(OrderListResponse.AccountOrder.OrderSide.BUY)
                        .orderTif(OrderListResponse.AccountOrder.OrderTif.DAY)
                        .orderTransactionHash("0xeaF12bD1DfFd")
                        .orderType(OrderListResponse.AccountOrder.OrderType.MARKET)
                        .paymentToken("payment_token")
                        .status(OrderListResponse.AccountOrder.Status.PENDING_SUBMIT)
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
            )

        val roundtrippedOrderListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(orderListResponse),
                jacksonTypeRef<OrderListResponse>(),
            )

        assertThat(roundtrippedOrderListResponse).isEqualTo(orderListResponse)
    }

    @Test
    fun ofPaginatedAccountOrder() {
        val paginatedAccountOrder =
            OrderListResponse.PaginatedAccountOrderResponse.builder()
                .addData(
                    OrderListResponse.PaginatedAccountOrderResponse.Data.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .chainId("chain_id")
                        .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .orderContractAddress("order_contract_address")
                        .orderSide(
                            OrderListResponse.PaginatedAccountOrderResponse.Data.OrderSide.BUY
                        )
                        .orderTif(OrderListResponse.PaginatedAccountOrderResponse.Data.OrderTif.DAY)
                        .orderTransactionHash("0xeaF12bD1DfFd")
                        .orderType(
                            OrderListResponse.PaginatedAccountOrderResponse.Data.OrderType.MARKET
                        )
                        .paymentToken("payment_token")
                        .status(
                            OrderListResponse.PaginatedAccountOrderResponse.Data.Status
                                .PENDING_SUBMIT
                        )
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
                .paginationMetadata(
                    OrderListResponse.PaginatedAccountOrderResponse.PaginationMetadata.builder()
                        .next("next")
                        .previous("previous")
                        .build()
                )
                ._sv(
                    OrderListResponse.PaginatedAccountOrderResponse._Sv
                        .PAGINATED_ACCOUNT_ORDER_RESPONSE_V1
                )
                .build()

        val orderListResponse = OrderListResponse.ofPaginatedAccountOrder(paginatedAccountOrder)

        assertThat(orderListResponse.accountOrders()).isEmpty
        assertThat(orderListResponse.paginatedAccountOrder()).contains(paginatedAccountOrder)
    }

    @Test
    fun ofPaginatedAccountOrderRoundtrip() {
        val jsonMapper = jsonMapper()
        val orderListResponse =
            OrderListResponse.ofPaginatedAccountOrder(
                OrderListResponse.PaginatedAccountOrderResponse.builder()
                    .addData(
                        OrderListResponse.PaginatedAccountOrderResponse.Data.builder()
                            .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .chainId("chain_id")
                            .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .orderContractAddress("order_contract_address")
                            .orderSide(
                                OrderListResponse.PaginatedAccountOrderResponse.Data.OrderSide.BUY
                            )
                            .orderTif(
                                OrderListResponse.PaginatedAccountOrderResponse.Data.OrderTif.DAY
                            )
                            .orderTransactionHash("0xeaF12bD1DfFd")
                            .orderType(
                                OrderListResponse.PaginatedAccountOrderResponse.Data.OrderType
                                    .MARKET
                            )
                            .paymentToken("payment_token")
                            .status(
                                OrderListResponse.PaginatedAccountOrderResponse.Data.Status
                                    .PENDING_SUBMIT
                            )
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
                    .paginationMetadata(
                        OrderListResponse.PaginatedAccountOrderResponse.PaginationMetadata.builder()
                            .next("next")
                            .previous("previous")
                            .build()
                    )
                    ._sv(
                        OrderListResponse.PaginatedAccountOrderResponse._Sv
                            .PAGINATED_ACCOUNT_ORDER_RESPONSE_V1
                    )
                    .build()
            )

        val roundtrippedOrderListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(orderListResponse),
                jacksonTypeRef<OrderListResponse>(),
            )

        assertThat(roundtrippedOrderListResponse).isEqualTo(orderListResponse)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val orderListResponse =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<OrderListResponse>())

        val e = assertThrows<DinariInvalidDataException> { orderListResponse.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
