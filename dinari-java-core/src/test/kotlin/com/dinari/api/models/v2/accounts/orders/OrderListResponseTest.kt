// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orders

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OrderListResponseTest {

    @Test
    fun create() {
        val orderListResponse =
            OrderListResponse.builder()
                .addData(
                    OrderListResponse.Data.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .chainId("chain_id")
                        .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .orderContractAddress("order_contract_address")
                        .orderSide(OrderListResponse.Data.OrderSide.BUY)
                        .orderTif(OrderListResponse.Data.OrderTif.DAY)
                        .orderTransactionHash("0xeaF12bD1DfFd")
                        .orderType(OrderListResponse.Data.OrderType.MARKET)
                        .paymentToken("payment_token")
                        .status(OrderListResponse.Data.Status.PENDING_SUBMIT)
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
                    OrderListResponse.PaginationMetadata.builder()
                        .next("next")
                        .previous("previous")
                        .build()
                )
                ._sv(OrderListResponse._Sv.PAGINATED_ACCOUNT_ORDER_RESPONSE_V1)
                .build()

        assertThat(orderListResponse.data())
            .containsExactly(
                OrderListResponse.Data.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .chainId("chain_id")
                    .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .orderContractAddress("order_contract_address")
                    .orderSide(OrderListResponse.Data.OrderSide.BUY)
                    .orderTif(OrderListResponse.Data.OrderTif.DAY)
                    .orderTransactionHash("0xeaF12bD1DfFd")
                    .orderType(OrderListResponse.Data.OrderType.MARKET)
                    .paymentToken("payment_token")
                    .status(OrderListResponse.Data.Status.PENDING_SUBMIT)
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
        assertThat(orderListResponse.paginationMetadata())
            .isEqualTo(
                OrderListResponse.PaginationMetadata.builder()
                    .next("next")
                    .previous("previous")
                    .build()
            )
        assertThat(orderListResponse._sv())
            .contains(OrderListResponse._Sv.PAGINATED_ACCOUNT_ORDER_RESPONSE_V1)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val orderListResponse =
            OrderListResponse.builder()
                .addData(
                    OrderListResponse.Data.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .chainId("chain_id")
                        .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .orderContractAddress("order_contract_address")
                        .orderSide(OrderListResponse.Data.OrderSide.BUY)
                        .orderTif(OrderListResponse.Data.OrderTif.DAY)
                        .orderTransactionHash("0xeaF12bD1DfFd")
                        .orderType(OrderListResponse.Data.OrderType.MARKET)
                        .paymentToken("payment_token")
                        .status(OrderListResponse.Data.Status.PENDING_SUBMIT)
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
                    OrderListResponse.PaginationMetadata.builder()
                        .next("next")
                        .previous("previous")
                        .build()
                )
                ._sv(OrderListResponse._Sv.PAGINATED_ACCOUNT_ORDER_RESPONSE_V1)
                .build()

        val roundtrippedOrderListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(orderListResponse),
                jacksonTypeRef<OrderListResponse>(),
            )

        assertThat(roundtrippedOrderListResponse).isEqualTo(orderListResponse)
    }
}
