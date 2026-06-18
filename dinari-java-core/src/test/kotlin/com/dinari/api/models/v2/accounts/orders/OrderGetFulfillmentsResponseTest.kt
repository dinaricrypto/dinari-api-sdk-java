// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orders

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OrderGetFulfillmentsResponseTest {

    @Test
    fun create() {
        val orderGetFulfillmentsResponse =
            OrderGetFulfillmentsResponse.builder()
                .addData(
                    OrderGetFulfillmentsResponse.Data.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .assetTokenFilled(0.0)
                        .assetTokenSpent(0.0)
                        .chainId("chain_id")
                        .orderId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .paymentTokenFilled(0.0)
                        .paymentTokenSpent(0.0)
                        .transactionDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .transactionHash("0xeaF12bD1DfFd")
                        .alloyId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .paymentTokenFee(0.0)
                        .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .build()
                )
                .paginationMetadata(
                    OrderGetFulfillmentsResponse.PaginationMetadata.builder()
                        .next("next")
                        .previous("previous")
                        .build()
                )
                ._sv(
                    OrderGetFulfillmentsResponse._Sv.PAGINATED_ACCOUNT_ORDER_FULFILLMENT_RESPONSE_V1
                )
                .build()

        assertThat(orderGetFulfillmentsResponse.data())
            .containsExactly(
                OrderGetFulfillmentsResponse.Data.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .assetTokenFilled(0.0)
                    .assetTokenSpent(0.0)
                    .chainId("chain_id")
                    .orderId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .paymentTokenFilled(0.0)
                    .paymentTokenSpent(0.0)
                    .transactionDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .transactionHash("0xeaF12bD1DfFd")
                    .alloyId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .paymentTokenFee(0.0)
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )
        assertThat(orderGetFulfillmentsResponse.paginationMetadata())
            .isEqualTo(
                OrderGetFulfillmentsResponse.PaginationMetadata.builder()
                    .next("next")
                    .previous("previous")
                    .build()
            )
        assertThat(orderGetFulfillmentsResponse._sv())
            .contains(
                OrderGetFulfillmentsResponse._Sv.PAGINATED_ACCOUNT_ORDER_FULFILLMENT_RESPONSE_V1
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val orderGetFulfillmentsResponse =
            OrderGetFulfillmentsResponse.builder()
                .addData(
                    OrderGetFulfillmentsResponse.Data.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .assetTokenFilled(0.0)
                        .assetTokenSpent(0.0)
                        .chainId("chain_id")
                        .orderId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .paymentTokenFilled(0.0)
                        .paymentTokenSpent(0.0)
                        .transactionDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .transactionHash("0xeaF12bD1DfFd")
                        .alloyId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .paymentTokenFee(0.0)
                        .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .build()
                )
                .paginationMetadata(
                    OrderGetFulfillmentsResponse.PaginationMetadata.builder()
                        .next("next")
                        .previous("previous")
                        .build()
                )
                ._sv(
                    OrderGetFulfillmentsResponse._Sv.PAGINATED_ACCOUNT_ORDER_FULFILLMENT_RESPONSE_V1
                )
                .build()

        val roundtrippedOrderGetFulfillmentsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(orderGetFulfillmentsResponse),
                jacksonTypeRef<OrderGetFulfillmentsResponse>(),
            )

        assertThat(roundtrippedOrderGetFulfillmentsResponse).isEqualTo(orderGetFulfillmentsResponse)
    }
}
