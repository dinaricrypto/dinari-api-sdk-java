// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.withdrawalrequests

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

internal class WithdrawalRequestListResponseTest {

    @Test
    fun ofRequests() {
        val requests =
            listOf(
                WithdrawalRequest.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .paymentTokenAmount(0.0)
                    .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .status(WithdrawalRequest.Status.PENDING)
                    .updatedDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build()
            )

        val withdrawalRequestListResponse = WithdrawalRequestListResponse.ofRequests(requests)

        assertThat(withdrawalRequestListResponse.requests()).contains(requests)
        assertThat(withdrawalRequestListResponse.paginatedWithdrawalRequest()).isEmpty
    }

    @Test
    fun ofRequestsRoundtrip() {
        val jsonMapper = jsonMapper()
        val withdrawalRequestListResponse =
            WithdrawalRequestListResponse.ofRequests(
                listOf(
                    WithdrawalRequest.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .paymentTokenAmount(0.0)
                        .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .status(WithdrawalRequest.Status.PENDING)
                        .updatedDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
            )

        val roundtrippedWithdrawalRequestListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(withdrawalRequestListResponse),
                jacksonTypeRef<WithdrawalRequestListResponse>(),
            )

        assertThat(roundtrippedWithdrawalRequestListResponse)
            .isEqualTo(withdrawalRequestListResponse)
    }

    @Test
    fun ofPaginatedWithdrawalRequest() {
        val paginatedWithdrawalRequest =
            WithdrawalRequestListResponse.PaginatedWithdrawalRequestResponse.builder()
                .addData(
                    WithdrawalRequest.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .paymentTokenAmount(0.0)
                        .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .status(WithdrawalRequest.Status.PENDING)
                        .updatedDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .paginationMetadata(
                    WithdrawalRequestListResponse.PaginatedWithdrawalRequestResponse
                        .PaginationMetadata
                        .builder()
                        .next("next")
                        .previous("previous")
                        .build()
                )
                ._sv(
                    WithdrawalRequestListResponse.PaginatedWithdrawalRequestResponse._Sv
                        .PAGINATED_WITHDRAWAL_REQUEST_RESPONSE_V1
                )
                .build()

        val withdrawalRequestListResponse =
            WithdrawalRequestListResponse.ofPaginatedWithdrawalRequest(paginatedWithdrawalRequest)

        assertThat(withdrawalRequestListResponse.requests()).isEmpty
        assertThat(withdrawalRequestListResponse.paginatedWithdrawalRequest())
            .contains(paginatedWithdrawalRequest)
    }

    @Test
    fun ofPaginatedWithdrawalRequestRoundtrip() {
        val jsonMapper = jsonMapper()
        val withdrawalRequestListResponse =
            WithdrawalRequestListResponse.ofPaginatedWithdrawalRequest(
                WithdrawalRequestListResponse.PaginatedWithdrawalRequestResponse.builder()
                    .addData(
                        WithdrawalRequest.builder()
                            .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .paymentTokenAmount(0.0)
                            .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .status(WithdrawalRequest.Status.PENDING)
                            .updatedDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .build()
                    )
                    .paginationMetadata(
                        WithdrawalRequestListResponse.PaginatedWithdrawalRequestResponse
                            .PaginationMetadata
                            .builder()
                            .next("next")
                            .previous("previous")
                            .build()
                    )
                    ._sv(
                        WithdrawalRequestListResponse.PaginatedWithdrawalRequestResponse._Sv
                            .PAGINATED_WITHDRAWAL_REQUEST_RESPONSE_V1
                    )
                    .build()
            )

        val roundtrippedWithdrawalRequestListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(withdrawalRequestListResponse),
                jacksonTypeRef<WithdrawalRequestListResponse>(),
            )

        assertThat(roundtrippedWithdrawalRequestListResponse)
            .isEqualTo(withdrawalRequestListResponse)
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
        val withdrawalRequestListResponse =
            jsonMapper()
                .convertValue(testCase.value, jacksonTypeRef<WithdrawalRequestListResponse>())

        val e =
            assertThrows<DinariInvalidDataException> { withdrawalRequestListResponse.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
