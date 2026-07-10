// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2

import com.dinari.api.core.jsonMapper
import com.dinari.api.models.v2.marketdata.alloys.PaginationMetadata
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class V2ListOrdersResponseTest {

    @Test
    fun create() {
        val v2ListOrdersResponse =
            V2ListOrdersResponse.builder()
                .addData(
                    V2ListOrdersResponse.Data.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .chainId("chain_id")
                        .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .orderContractAddress("order_contract_address")
                        .orderSide(OrderSide.BUY)
                        .orderTif(OrderTif.DAY)
                        .orderTransactionHash("0xeaF12bD1DfFd")
                        .orderType(OrderType.MARKET)
                        .paymentToken("payment_token")
                        .status(BrokerageOrderStatus.PENDING_SUBMIT)
                        .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .assetToken("asset_token")
                        .assetTokenQuantity(0.0)
                        .cancelTransactionHash("0xeaF12bD1DfFd")
                        .clientOrderId("client_order_id")
                        .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .fee(0.0)
                        .limitPrice(0.0)
                        .orderRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .paymentTokenQuantity(0.0)
                        .build()
                )
                .paginationMetadata(
                    PaginationMetadata.builder().next("next").previous("previous").build()
                )
                ._sv(V2ListOrdersResponse._Sv.PAGINATED_ENTITY_ORDER_RESPONSE_V1)
                .build()

        assertThat(v2ListOrdersResponse.data())
            .containsExactly(
                V2ListOrdersResponse.Data.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .chainId("chain_id")
                    .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .orderContractAddress("order_contract_address")
                    .orderSide(OrderSide.BUY)
                    .orderTif(OrderTif.DAY)
                    .orderTransactionHash("0xeaF12bD1DfFd")
                    .orderType(OrderType.MARKET)
                    .paymentToken("payment_token")
                    .status(BrokerageOrderStatus.PENDING_SUBMIT)
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .assetToken("asset_token")
                    .assetTokenQuantity(0.0)
                    .cancelTransactionHash("0xeaF12bD1DfFd")
                    .clientOrderId("client_order_id")
                    .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .fee(0.0)
                    .limitPrice(0.0)
                    .orderRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .paymentTokenQuantity(0.0)
                    .build()
            )
        assertThat(v2ListOrdersResponse.paginationMetadata())
            .isEqualTo(PaginationMetadata.builder().next("next").previous("previous").build())
        assertThat(v2ListOrdersResponse._sv())
            .contains(V2ListOrdersResponse._Sv.PAGINATED_ENTITY_ORDER_RESPONSE_V1)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val v2ListOrdersResponse =
            V2ListOrdersResponse.builder()
                .addData(
                    V2ListOrdersResponse.Data.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .chainId("chain_id")
                        .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .orderContractAddress("order_contract_address")
                        .orderSide(OrderSide.BUY)
                        .orderTif(OrderTif.DAY)
                        .orderTransactionHash("0xeaF12bD1DfFd")
                        .orderType(OrderType.MARKET)
                        .paymentToken("payment_token")
                        .status(BrokerageOrderStatus.PENDING_SUBMIT)
                        .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .assetToken("asset_token")
                        .assetTokenQuantity(0.0)
                        .cancelTransactionHash("0xeaF12bD1DfFd")
                        .clientOrderId("client_order_id")
                        .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .fee(0.0)
                        .limitPrice(0.0)
                        .orderRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .paymentTokenQuantity(0.0)
                        .build()
                )
                .paginationMetadata(
                    PaginationMetadata.builder().next("next").previous("previous").build()
                )
                ._sv(V2ListOrdersResponse._Sv.PAGINATED_ENTITY_ORDER_RESPONSE_V1)
                .build()

        val roundtrippedV2ListOrdersResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(v2ListOrdersResponse),
                jacksonTypeRef<V2ListOrdersResponse>(),
            )

        assertThat(roundtrippedV2ListOrdersResponse).isEqualTo(v2ListOrdersResponse)
    }
}
