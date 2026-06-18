// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.withdrawalrequests

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WithdrawalRequestListResponseTest {

    @Test
    fun create() {
        val withdrawalRequestListResponse =
            WithdrawalRequestListResponse.builder()
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
                    WithdrawalRequestListResponse.PaginationMetadata.builder()
                        .next("next")
                        .previous("previous")
                        .build()
                )
                ._sv(WithdrawalRequestListResponse._Sv.PAGINATED_WITHDRAWAL_REQUEST_RESPONSE_V1)
                .build()

        assertThat(withdrawalRequestListResponse.data())
            .containsExactly(
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
        assertThat(withdrawalRequestListResponse.paginationMetadata())
            .isEqualTo(
                WithdrawalRequestListResponse.PaginationMetadata.builder()
                    .next("next")
                    .previous("previous")
                    .build()
            )
        assertThat(withdrawalRequestListResponse._sv())
            .contains(WithdrawalRequestListResponse._Sv.PAGINATED_WITHDRAWAL_REQUEST_RESPONSE_V1)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val withdrawalRequestListResponse =
            WithdrawalRequestListResponse.builder()
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
                    WithdrawalRequestListResponse.PaginationMetadata.builder()
                        .next("next")
                        .previous("previous")
                        .build()
                )
                ._sv(WithdrawalRequestListResponse._Sv.PAGINATED_WITHDRAWAL_REQUEST_RESPONSE_V1)
                .build()

        val roundtrippedWithdrawalRequestListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(withdrawalRequestListResponse),
                jacksonTypeRef<WithdrawalRequestListResponse>(),
            )

        assertThat(roundtrippedWithdrawalRequestListResponse)
            .isEqualTo(withdrawalRequestListResponse)
    }
}
