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

internal class OrderGetFulfillmentsResponseTest {

    @Test
    fun ofAccountOrderFulfillments() {
        val accountOrderFulfillments =
            listOf(
                OrderGetFulfillmentsResponse.AccountOrderFulfillment.builder()
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

        val orderGetFulfillmentsResponse =
            OrderGetFulfillmentsResponse.ofAccountOrderFulfillments(accountOrderFulfillments)

        assertThat(orderGetFulfillmentsResponse.accountOrderFulfillments())
            .contains(accountOrderFulfillments)
        assertThat(orderGetFulfillmentsResponse.paginatedAccountOrderFulfillment()).isEmpty
    }

    @Test
    fun ofAccountOrderFulfillmentsRoundtrip() {
        val jsonMapper = jsonMapper()
        val orderGetFulfillmentsResponse =
            OrderGetFulfillmentsResponse.ofAccountOrderFulfillments(
                listOf(
                    OrderGetFulfillmentsResponse.AccountOrderFulfillment.builder()
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

        val roundtrippedOrderGetFulfillmentsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(orderGetFulfillmentsResponse),
                jacksonTypeRef<OrderGetFulfillmentsResponse>(),
            )

        assertThat(roundtrippedOrderGetFulfillmentsResponse).isEqualTo(orderGetFulfillmentsResponse)
    }

    @Test
    fun ofPaginatedAccountOrderFulfillment() {
        val paginatedAccountOrderFulfillment =
            OrderGetFulfillmentsResponse.PaginatedAccountOrderFulfillmentResponse.builder()
                .addData(
                    OrderGetFulfillmentsResponse.PaginatedAccountOrderFulfillmentResponse.Data
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
                    OrderGetFulfillmentsResponse.PaginatedAccountOrderFulfillmentResponse
                        .PaginationMetadata
                        .builder()
                        .next("next")
                        .previous("previous")
                        .build()
                )
                ._sv(
                    OrderGetFulfillmentsResponse.PaginatedAccountOrderFulfillmentResponse._Sv
                        .PAGINATED_ACCOUNT_ORDER_FULFILLMENT_RESPONSE_V1
                )
                .build()

        val orderGetFulfillmentsResponse =
            OrderGetFulfillmentsResponse.ofPaginatedAccountOrderFulfillment(
                paginatedAccountOrderFulfillment
            )

        assertThat(orderGetFulfillmentsResponse.accountOrderFulfillments()).isEmpty
        assertThat(orderGetFulfillmentsResponse.paginatedAccountOrderFulfillment())
            .contains(paginatedAccountOrderFulfillment)
    }

    @Test
    fun ofPaginatedAccountOrderFulfillmentRoundtrip() {
        val jsonMapper = jsonMapper()
        val orderGetFulfillmentsResponse =
            OrderGetFulfillmentsResponse.ofPaginatedAccountOrderFulfillment(
                OrderGetFulfillmentsResponse.PaginatedAccountOrderFulfillmentResponse.builder()
                    .addData(
                        OrderGetFulfillmentsResponse.PaginatedAccountOrderFulfillmentResponse.Data
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
                        OrderGetFulfillmentsResponse.PaginatedAccountOrderFulfillmentResponse
                            .PaginationMetadata
                            .builder()
                            .next("next")
                            .previous("previous")
                            .build()
                    )
                    ._sv(
                        OrderGetFulfillmentsResponse.PaginatedAccountOrderFulfillmentResponse._Sv
                            .PAGINATED_ACCOUNT_ORDER_FULFILLMENT_RESPONSE_V1
                    )
                    .build()
            )

        val roundtrippedOrderGetFulfillmentsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(orderGetFulfillmentsResponse),
                jacksonTypeRef<OrderGetFulfillmentsResponse>(),
            )

        assertThat(roundtrippedOrderGetFulfillmentsResponse).isEqualTo(orderGetFulfillmentsResponse)
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
        val orderGetFulfillmentsResponse =
            jsonMapper()
                .convertValue(testCase.value, jacksonTypeRef<OrderGetFulfillmentsResponse>())

        val e = assertThrows<DinariInvalidDataException> { orderGetFulfillmentsResponse.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
