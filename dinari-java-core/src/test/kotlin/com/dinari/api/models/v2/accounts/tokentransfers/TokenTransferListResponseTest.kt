// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.tokentransfers

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TokenTransferListResponseTest {

    @Test
    fun create() {
        val tokenTransferListResponse =
            TokenTransferListResponse.builder()
                .addData(
                    TokenTransfer.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .chainId(TokenTransfer.ChainId.EIP155_1)
                        .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .quantity(0.0)
                        .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .senderAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .status(TokenTransfer.Status.PENDING)
                        .tokenAddress("token_address")
                        .updatedDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .transactionHash("0xeaF12bD1DfFd")
                        .build()
                )
                .paginationMetadata(
                    TokenTransferListResponse.PaginationMetadata.builder()
                        .next("next")
                        .previous("previous")
                        .build()
                )
                ._sv(TokenTransferListResponse._Sv.PAGINATED_TOKEN_TRANSFER_RESPONSE_V1)
                .build()

        assertThat(tokenTransferListResponse.data())
            .containsExactly(
                TokenTransfer.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .chainId(TokenTransfer.ChainId.EIP155_1)
                    .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .quantity(0.0)
                    .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .senderAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .status(TokenTransfer.Status.PENDING)
                    .tokenAddress("token_address")
                    .updatedDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .transactionHash("0xeaF12bD1DfFd")
                    .build()
            )
        assertThat(tokenTransferListResponse.paginationMetadata())
            .isEqualTo(
                TokenTransferListResponse.PaginationMetadata.builder()
                    .next("next")
                    .previous("previous")
                    .build()
            )
        assertThat(tokenTransferListResponse._sv())
            .contains(TokenTransferListResponse._Sv.PAGINATED_TOKEN_TRANSFER_RESPONSE_V1)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val tokenTransferListResponse =
            TokenTransferListResponse.builder()
                .addData(
                    TokenTransfer.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .chainId(TokenTransfer.ChainId.EIP155_1)
                        .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .quantity(0.0)
                        .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .senderAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .status(TokenTransfer.Status.PENDING)
                        .tokenAddress("token_address")
                        .updatedDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .transactionHash("0xeaF12bD1DfFd")
                        .build()
                )
                .paginationMetadata(
                    TokenTransferListResponse.PaginationMetadata.builder()
                        .next("next")
                        .previous("previous")
                        .build()
                )
                ._sv(TokenTransferListResponse._Sv.PAGINATED_TOKEN_TRANSFER_RESPONSE_V1)
                .build()

        val roundtrippedTokenTransferListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tokenTransferListResponse),
                jacksonTypeRef<TokenTransferListResponse>(),
            )

        assertThat(roundtrippedTokenTransferListResponse).isEqualTo(tokenTransferListResponse)
    }
}
