// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.tokentransfers

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

internal class TokenTransferListResponseTest {

    @Test
    fun ofTransfers() {
        val transfers =
            listOf(
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

        val tokenTransferListResponse = TokenTransferListResponse.ofTransfers(transfers)

        assertThat(tokenTransferListResponse.transfers()).contains(transfers)
        assertThat(tokenTransferListResponse.paginatedTokenTransfer()).isEmpty
    }

    @Test
    fun ofTransfersRoundtrip() {
        val jsonMapper = jsonMapper()
        val tokenTransferListResponse =
            TokenTransferListResponse.ofTransfers(
                listOf(
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
            )

        val roundtrippedTokenTransferListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tokenTransferListResponse),
                jacksonTypeRef<TokenTransferListResponse>(),
            )

        assertThat(roundtrippedTokenTransferListResponse).isEqualTo(tokenTransferListResponse)
    }

    @Test
    fun ofPaginatedTokenTransfer() {
        val paginatedTokenTransfer =
            TokenTransferListResponse.PaginatedTokenTransferResponse.builder()
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
                    TokenTransferListResponse.PaginatedTokenTransferResponse.PaginationMetadata
                        .builder()
                        .next("next")
                        .previous("previous")
                        .build()
                )
                ._sv(
                    TokenTransferListResponse.PaginatedTokenTransferResponse._Sv
                        .PAGINATED_TOKEN_TRANSFER_RESPONSE_V1
                )
                .build()

        val tokenTransferListResponse =
            TokenTransferListResponse.ofPaginatedTokenTransfer(paginatedTokenTransfer)

        assertThat(tokenTransferListResponse.transfers()).isEmpty
        assertThat(tokenTransferListResponse.paginatedTokenTransfer())
            .contains(paginatedTokenTransfer)
    }

    @Test
    fun ofPaginatedTokenTransferRoundtrip() {
        val jsonMapper = jsonMapper()
        val tokenTransferListResponse =
            TokenTransferListResponse.ofPaginatedTokenTransfer(
                TokenTransferListResponse.PaginatedTokenTransferResponse.builder()
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
                        TokenTransferListResponse.PaginatedTokenTransferResponse.PaginationMetadata
                            .builder()
                            .next("next")
                            .previous("previous")
                            .build()
                    )
                    ._sv(
                        TokenTransferListResponse.PaginatedTokenTransferResponse._Sv
                            .PAGINATED_TOKEN_TRANSFER_RESPONSE_V1
                    )
                    .build()
            )

        val roundtrippedTokenTransferListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tokenTransferListResponse),
                jacksonTypeRef<TokenTransferListResponse>(),
            )

        assertThat(roundtrippedTokenTransferListResponse).isEqualTo(tokenTransferListResponse)
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
        val tokenTransferListResponse =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<TokenTransferListResponse>())

        val e = assertThrows<DinariInvalidDataException> { tokenTransferListResponse.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
