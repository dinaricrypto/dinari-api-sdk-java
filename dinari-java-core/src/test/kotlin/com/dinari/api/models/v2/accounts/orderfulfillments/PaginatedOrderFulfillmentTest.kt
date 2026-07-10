// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderfulfillments

import com.dinari.api.core.jsonMapper
import com.dinari.api.models.v2.marketdata.alloys.PaginationMetadata
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PaginatedOrderFulfillmentTest {

    @Test
    fun create() {
        val paginatedOrderFulfillment =
            PaginatedOrderFulfillment.builder()
                .addData(
                    PaginatedOrderFulfillment.Data.builder()
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
                    PaginationMetadata.builder().next("next").previous("previous").build()
                )
                ._sv(PaginatedOrderFulfillment._Sv.PAGINATED_ACCOUNT_ORDER_FULFILLMENT_RESPONSE_V1)
                .build()

        assertThat(paginatedOrderFulfillment.data())
            .containsExactly(
                PaginatedOrderFulfillment.Data.builder()
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
        assertThat(paginatedOrderFulfillment.paginationMetadata())
            .isEqualTo(PaginationMetadata.builder().next("next").previous("previous").build())
        assertThat(paginatedOrderFulfillment._sv())
            .contains(PaginatedOrderFulfillment._Sv.PAGINATED_ACCOUNT_ORDER_FULFILLMENT_RESPONSE_V1)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val paginatedOrderFulfillment =
            PaginatedOrderFulfillment.builder()
                .addData(
                    PaginatedOrderFulfillment.Data.builder()
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
                    PaginationMetadata.builder().next("next").previous("previous").build()
                )
                ._sv(PaginatedOrderFulfillment._Sv.PAGINATED_ACCOUNT_ORDER_FULFILLMENT_RESPONSE_V1)
                .build()

        val roundtrippedPaginatedOrderFulfillment =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(paginatedOrderFulfillment),
                jacksonTypeRef<PaginatedOrderFulfillment>(),
            )

        assertThat(roundtrippedPaginatedOrderFulfillment).isEqualTo(paginatedOrderFulfillment)
    }
}
