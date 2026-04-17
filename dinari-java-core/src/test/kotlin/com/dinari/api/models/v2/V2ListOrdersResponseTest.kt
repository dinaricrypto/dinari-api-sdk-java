// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2

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

internal class V2ListOrdersResponseTest {

    @Test
    fun ofEntityOrders() {
        val entityOrders =
            listOf(
                V2ListOrdersResponse.EntityOrder.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .chainId("chain_id")
                    .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .orderContractAddress("order_contract_address")
                    .orderSide(V2ListOrdersResponse.EntityOrder.OrderSide.BUY)
                    .orderTif(V2ListOrdersResponse.EntityOrder.OrderTif.DAY)
                    .orderTransactionHash("0xeaF12bD1DfFd")
                    .orderType(V2ListOrdersResponse.EntityOrder.OrderType.MARKET)
                    .paymentToken("payment_token")
                    .status(V2ListOrdersResponse.EntityOrder.Status.PENDING_SUBMIT)
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

        val v2ListOrdersResponse = V2ListOrdersResponse.ofEntityOrders(entityOrders)

        assertThat(v2ListOrdersResponse.entityOrders()).contains(entityOrders)
        assertThat(v2ListOrdersResponse.paginatedEntityOrder()).isEmpty
    }

    @Test
    fun ofEntityOrdersRoundtrip() {
        val jsonMapper = jsonMapper()
        val v2ListOrdersResponse =
            V2ListOrdersResponse.ofEntityOrders(
                listOf(
                    V2ListOrdersResponse.EntityOrder.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .chainId("chain_id")
                        .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .orderContractAddress("order_contract_address")
                        .orderSide(V2ListOrdersResponse.EntityOrder.OrderSide.BUY)
                        .orderTif(V2ListOrdersResponse.EntityOrder.OrderTif.DAY)
                        .orderTransactionHash("0xeaF12bD1DfFd")
                        .orderType(V2ListOrdersResponse.EntityOrder.OrderType.MARKET)
                        .paymentToken("payment_token")
                        .status(V2ListOrdersResponse.EntityOrder.Status.PENDING_SUBMIT)
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
            )

        val roundtrippedV2ListOrdersResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(v2ListOrdersResponse),
                jacksonTypeRef<V2ListOrdersResponse>(),
            )

        assertThat(roundtrippedV2ListOrdersResponse).isEqualTo(v2ListOrdersResponse)
    }

    @Test
    fun ofPaginatedEntityOrder() {
        val paginatedEntityOrder =
            V2ListOrdersResponse.PaginatedEntityOrderResponse.builder()
                .addData(
                    V2ListOrdersResponse.PaginatedEntityOrderResponse.Data.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .chainId("chain_id")
                        .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .orderContractAddress("order_contract_address")
                        .orderSide(
                            V2ListOrdersResponse.PaginatedEntityOrderResponse.Data.OrderSide.BUY
                        )
                        .orderTif(
                            V2ListOrdersResponse.PaginatedEntityOrderResponse.Data.OrderTif.DAY
                        )
                        .orderTransactionHash("0xeaF12bD1DfFd")
                        .orderType(
                            V2ListOrdersResponse.PaginatedEntityOrderResponse.Data.OrderType.MARKET
                        )
                        .paymentToken("payment_token")
                        .status(
                            V2ListOrdersResponse.PaginatedEntityOrderResponse.Data.Status
                                .PENDING_SUBMIT
                        )
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
                    V2ListOrdersResponse.PaginatedEntityOrderResponse.PaginationMetadata.builder()
                        .next("next")
                        .previous("previous")
                        .build()
                )
                ._sv(
                    V2ListOrdersResponse.PaginatedEntityOrderResponse._Sv
                        .PAGINATED_ENTITY_ORDER_RESPONSE_V1
                )
                .build()

        val v2ListOrdersResponse = V2ListOrdersResponse.ofPaginatedEntityOrder(paginatedEntityOrder)

        assertThat(v2ListOrdersResponse.entityOrders()).isEmpty
        assertThat(v2ListOrdersResponse.paginatedEntityOrder()).contains(paginatedEntityOrder)
    }

    @Test
    fun ofPaginatedEntityOrderRoundtrip() {
        val jsonMapper = jsonMapper()
        val v2ListOrdersResponse =
            V2ListOrdersResponse.ofPaginatedEntityOrder(
                V2ListOrdersResponse.PaginatedEntityOrderResponse.builder()
                    .addData(
                        V2ListOrdersResponse.PaginatedEntityOrderResponse.Data.builder()
                            .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .chainId("chain_id")
                            .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .orderContractAddress("order_contract_address")
                            .orderSide(
                                V2ListOrdersResponse.PaginatedEntityOrderResponse.Data.OrderSide.BUY
                            )
                            .orderTif(
                                V2ListOrdersResponse.PaginatedEntityOrderResponse.Data.OrderTif.DAY
                            )
                            .orderTransactionHash("0xeaF12bD1DfFd")
                            .orderType(
                                V2ListOrdersResponse.PaginatedEntityOrderResponse.Data.OrderType
                                    .MARKET
                            )
                            .paymentToken("payment_token")
                            .status(
                                V2ListOrdersResponse.PaginatedEntityOrderResponse.Data.Status
                                    .PENDING_SUBMIT
                            )
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
                        V2ListOrdersResponse.PaginatedEntityOrderResponse.PaginationMetadata
                            .builder()
                            .next("next")
                            .previous("previous")
                            .build()
                    )
                    ._sv(
                        V2ListOrdersResponse.PaginatedEntityOrderResponse._Sv
                            .PAGINATED_ENTITY_ORDER_RESPONSE_V1
                    )
                    .build()
            )

        val roundtrippedV2ListOrdersResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(v2ListOrdersResponse),
                jacksonTypeRef<V2ListOrdersResponse>(),
            )

        assertThat(roundtrippedV2ListOrdersResponse).isEqualTo(v2ListOrdersResponse)
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
        val v2ListOrdersResponse =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<V2ListOrdersResponse>())

        val e = assertThrows<DinariInvalidDataException> { v2ListOrdersResponse.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
