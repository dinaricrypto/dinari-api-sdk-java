// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderfulfillments

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

internal class OrderFulfillmentQueryResponseTest {

    @Test
    fun ofAccountOrderFulfillments() {
        val accountOrderFulfillments =
            listOf(
                OrderFulfillmentQueryResponse.AccountOrderFulfillment.builder()
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

        val orderFulfillmentQueryResponse =
            OrderFulfillmentQueryResponse.ofAccountOrderFulfillments(accountOrderFulfillments)

        assertThat(orderFulfillmentQueryResponse.accountOrderFulfillments())
            .contains(accountOrderFulfillments)
        assertThat(orderFulfillmentQueryResponse.paginatedAccountOrderFulfillment()).isEmpty
    }

    @Test
    fun ofAccountOrderFulfillmentsRoundtrip() {
        val jsonMapper = jsonMapper()
        val orderFulfillmentQueryResponse =
            OrderFulfillmentQueryResponse.ofAccountOrderFulfillments(
                listOf(
                    OrderFulfillmentQueryResponse.AccountOrderFulfillment.builder()
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
            )

        val roundtrippedOrderFulfillmentQueryResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(orderFulfillmentQueryResponse),
                jacksonTypeRef<OrderFulfillmentQueryResponse>(),
            )

        assertThat(roundtrippedOrderFulfillmentQueryResponse)
            .isEqualTo(orderFulfillmentQueryResponse)
    }

    @Test
    fun ofPaginatedAccountOrderFulfillment() {
        val paginatedAccountOrderFulfillment =
            OrderFulfillmentQueryResponse.PaginatedAccountOrderFulfillmentResponse.builder()
                .addData(
                    OrderFulfillmentQueryResponse.PaginatedAccountOrderFulfillmentResponse.Data
                        .builder()
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
                    OrderFulfillmentQueryResponse.PaginatedAccountOrderFulfillmentResponse
                        .PaginationMetadata
                        .builder()
                        .next("next")
                        .previous("previous")
                        .build()
                )
                ._sv(
                    OrderFulfillmentQueryResponse.PaginatedAccountOrderFulfillmentResponse._Sv
                        .PAGINATED_ACCOUNT_ORDER_FULFILLMENT_RESPONSE_V1
                )
                .build()

        val orderFulfillmentQueryResponse =
            OrderFulfillmentQueryResponse.ofPaginatedAccountOrderFulfillment(
                paginatedAccountOrderFulfillment
            )

        assertThat(orderFulfillmentQueryResponse.accountOrderFulfillments()).isEmpty
        assertThat(orderFulfillmentQueryResponse.paginatedAccountOrderFulfillment())
            .contains(paginatedAccountOrderFulfillment)
    }

    @Test
    fun ofPaginatedAccountOrderFulfillmentRoundtrip() {
        val jsonMapper = jsonMapper()
        val orderFulfillmentQueryResponse =
            OrderFulfillmentQueryResponse.ofPaginatedAccountOrderFulfillment(
                OrderFulfillmentQueryResponse.PaginatedAccountOrderFulfillmentResponse.builder()
                    .addData(
                        OrderFulfillmentQueryResponse.PaginatedAccountOrderFulfillmentResponse.Data
                            .builder()
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
                        OrderFulfillmentQueryResponse.PaginatedAccountOrderFulfillmentResponse
                            .PaginationMetadata
                            .builder()
                            .next("next")
                            .previous("previous")
                            .build()
                    )
                    ._sv(
                        OrderFulfillmentQueryResponse.PaginatedAccountOrderFulfillmentResponse._Sv
                            .PAGINATED_ACCOUNT_ORDER_FULFILLMENT_RESPONSE_V1
                    )
                    .build()
            )

        val roundtrippedOrderFulfillmentQueryResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(orderFulfillmentQueryResponse),
                jacksonTypeRef<OrderFulfillmentQueryResponse>(),
            )

        assertThat(roundtrippedOrderFulfillmentQueryResponse)
            .isEqualTo(orderFulfillmentQueryResponse)
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
        val orderFulfillmentQueryResponse =
            jsonMapper()
                .convertValue(testCase.value, jacksonTypeRef<OrderFulfillmentQueryResponse>())

        val e =
            assertThrows<DinariInvalidDataException> { orderFulfillmentQueryResponse.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
