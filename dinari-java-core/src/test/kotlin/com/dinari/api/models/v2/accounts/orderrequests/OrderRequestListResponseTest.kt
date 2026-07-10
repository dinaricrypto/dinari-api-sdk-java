// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderrequests

import com.dinari.api.core.jsonMapper
import com.dinari.api.models.v2.OrderSide
import com.dinari.api.models.v2.OrderTif
import com.dinari.api.models.v2.OrderType
import com.dinari.api.models.v2.marketdata.alloys.PaginationMetadata
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OrderRequestListResponseTest {

    @Test
    fun create() {
        val orderRequestListResponse =
            OrderRequestListResponse.builder()
                .addData(
                    OrderRequestListResponse.Data.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .orderSide(OrderSide.BUY)
                        .orderTif(OrderTif.DAY)
                        .orderType(OrderType.MARKET)
                        .status(OrderRequestListResponse.Data.Status.QUOTED)
                        .cancelMessage("cancel_message")
                        .clientOrderId("client_order_id")
                        .orderId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .rejectMessage("reject_message")
                        .build()
                )
                .paginationMetadata(
                    PaginationMetadata.builder().next("next").previous("previous").build()
                )
                ._sv(OrderRequestListResponse._Sv.PAGINATED_ACCOUNT_ORDER_REQUEST_RESPONSE_V1)
                .build()

        assertThat(orderRequestListResponse.data())
            .containsExactly(
                OrderRequestListResponse.Data.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .orderSide(OrderSide.BUY)
                    .orderTif(OrderTif.DAY)
                    .orderType(OrderType.MARKET)
                    .status(OrderRequestListResponse.Data.Status.QUOTED)
                    .cancelMessage("cancel_message")
                    .clientOrderId("client_order_id")
                    .orderId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .rejectMessage("reject_message")
                    .build()
            )
        assertThat(orderRequestListResponse.paginationMetadata())
            .isEqualTo(PaginationMetadata.builder().next("next").previous("previous").build())
        assertThat(orderRequestListResponse._sv())
            .contains(OrderRequestListResponse._Sv.PAGINATED_ACCOUNT_ORDER_REQUEST_RESPONSE_V1)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val orderRequestListResponse =
            OrderRequestListResponse.builder()
                .addData(
                    OrderRequestListResponse.Data.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .orderSide(OrderSide.BUY)
                        .orderTif(OrderTif.DAY)
                        .orderType(OrderType.MARKET)
                        .status(OrderRequestListResponse.Data.Status.QUOTED)
                        .cancelMessage("cancel_message")
                        .clientOrderId("client_order_id")
                        .orderId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .rejectMessage("reject_message")
                        .build()
                )
                .paginationMetadata(
                    PaginationMetadata.builder().next("next").previous("previous").build()
                )
                ._sv(OrderRequestListResponse._Sv.PAGINATED_ACCOUNT_ORDER_REQUEST_RESPONSE_V1)
                .build()

        val roundtrippedOrderRequestListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(orderRequestListResponse),
                jacksonTypeRef<OrderRequestListResponse>(),
            )

        assertThat(roundtrippedOrderRequestListResponse).isEqualTo(orderRequestListResponse)
    }
}
