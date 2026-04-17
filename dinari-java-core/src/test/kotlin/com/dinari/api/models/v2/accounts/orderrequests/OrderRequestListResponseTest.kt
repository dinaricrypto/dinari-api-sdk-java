// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderrequests

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

internal class OrderRequestListResponseTest {

    @Test
    fun ofAccountOrderRequests() {
        val accountOrderRequests =
            listOf(
                OrderRequestListResponse.AccountOrderRequest.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .orderSide(OrderRequestListResponse.AccountOrderRequest.OrderSide.BUY)
                    .orderTif(OrderRequestListResponse.AccountOrderRequest.OrderTif.DAY)
                    .orderType(OrderRequestListResponse.AccountOrderRequest.OrderType.MARKET)
                    .status(OrderRequestListResponse.AccountOrderRequest.Status.QUOTED)
                    .cancelMessage("cancel_message")
                    .clientOrderId("client_order_id")
                    .orderId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .rejectMessage("reject_message")
                    .build()
            )

        val orderRequestListResponse =
            OrderRequestListResponse.ofAccountOrderRequests(accountOrderRequests)

        assertThat(orderRequestListResponse.accountOrderRequests()).contains(accountOrderRequests)
        assertThat(orderRequestListResponse.paginatedAccountOrderRequest()).isEmpty
    }

    @Test
    fun ofAccountOrderRequestsRoundtrip() {
        val jsonMapper = jsonMapper()
        val orderRequestListResponse =
            OrderRequestListResponse.ofAccountOrderRequests(
                listOf(
                    OrderRequestListResponse.AccountOrderRequest.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .orderSide(OrderRequestListResponse.AccountOrderRequest.OrderSide.BUY)
                        .orderTif(OrderRequestListResponse.AccountOrderRequest.OrderTif.DAY)
                        .orderType(OrderRequestListResponse.AccountOrderRequest.OrderType.MARKET)
                        .status(OrderRequestListResponse.AccountOrderRequest.Status.QUOTED)
                        .cancelMessage("cancel_message")
                        .clientOrderId("client_order_id")
                        .orderId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .rejectMessage("reject_message")
                        .build()
                )
            )

        val roundtrippedOrderRequestListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(orderRequestListResponse),
                jacksonTypeRef<OrderRequestListResponse>(),
            )

        assertThat(roundtrippedOrderRequestListResponse).isEqualTo(orderRequestListResponse)
    }

    @Test
    fun ofPaginatedAccountOrderRequest() {
        val paginatedAccountOrderRequest =
            OrderRequestListResponse.PaginatedAccountOrderRequestResponse.builder()
                .addData(
                    OrderRequestListResponse.PaginatedAccountOrderRequestResponse.Data.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .orderSide(
                            OrderRequestListResponse.PaginatedAccountOrderRequestResponse.Data
                                .OrderSide
                                .BUY
                        )
                        .orderTif(
                            OrderRequestListResponse.PaginatedAccountOrderRequestResponse.Data
                                .OrderTif
                                .DAY
                        )
                        .orderType(
                            OrderRequestListResponse.PaginatedAccountOrderRequestResponse.Data
                                .OrderType
                                .MARKET
                        )
                        .status(
                            OrderRequestListResponse.PaginatedAccountOrderRequestResponse.Data
                                .Status
                                .QUOTED
                        )
                        .cancelMessage("cancel_message")
                        .clientOrderId("client_order_id")
                        .orderId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .rejectMessage("reject_message")
                        .build()
                )
                .paginationMetadata(
                    OrderRequestListResponse.PaginatedAccountOrderRequestResponse.PaginationMetadata
                        .builder()
                        .next("next")
                        .previous("previous")
                        .build()
                )
                ._sv(
                    OrderRequestListResponse.PaginatedAccountOrderRequestResponse._Sv
                        .PAGINATED_ACCOUNT_ORDER_REQUEST_RESPONSE_V1
                )
                .build()

        val orderRequestListResponse =
            OrderRequestListResponse.ofPaginatedAccountOrderRequest(paginatedAccountOrderRequest)

        assertThat(orderRequestListResponse.accountOrderRequests()).isEmpty
        assertThat(orderRequestListResponse.paginatedAccountOrderRequest())
            .contains(paginatedAccountOrderRequest)
    }

    @Test
    fun ofPaginatedAccountOrderRequestRoundtrip() {
        val jsonMapper = jsonMapper()
        val orderRequestListResponse =
            OrderRequestListResponse.ofPaginatedAccountOrderRequest(
                OrderRequestListResponse.PaginatedAccountOrderRequestResponse.builder()
                    .addData(
                        OrderRequestListResponse.PaginatedAccountOrderRequestResponse.Data.builder()
                            .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .orderSide(
                                OrderRequestListResponse.PaginatedAccountOrderRequestResponse.Data
                                    .OrderSide
                                    .BUY
                            )
                            .orderTif(
                                OrderRequestListResponse.PaginatedAccountOrderRequestResponse.Data
                                    .OrderTif
                                    .DAY
                            )
                            .orderType(
                                OrderRequestListResponse.PaginatedAccountOrderRequestResponse.Data
                                    .OrderType
                                    .MARKET
                            )
                            .status(
                                OrderRequestListResponse.PaginatedAccountOrderRequestResponse.Data
                                    .Status
                                    .QUOTED
                            )
                            .cancelMessage("cancel_message")
                            .clientOrderId("client_order_id")
                            .orderId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .rejectMessage("reject_message")
                            .build()
                    )
                    .paginationMetadata(
                        OrderRequestListResponse.PaginatedAccountOrderRequestResponse
                            .PaginationMetadata
                            .builder()
                            .next("next")
                            .previous("previous")
                            .build()
                    )
                    ._sv(
                        OrderRequestListResponse.PaginatedAccountOrderRequestResponse._Sv
                            .PAGINATED_ACCOUNT_ORDER_REQUEST_RESPONSE_V1
                    )
                    .build()
            )

        val roundtrippedOrderRequestListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(orderRequestListResponse),
                jacksonTypeRef<OrderRequestListResponse>(),
            )

        assertThat(roundtrippedOrderRequestListResponse).isEqualTo(orderRequestListResponse)
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
        val orderRequestListResponse =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<OrderRequestListResponse>())

        val e = assertThrows<DinariInvalidDataException> { orderRequestListResponse.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
