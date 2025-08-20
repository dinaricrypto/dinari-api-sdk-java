// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.tokentransfers

import com.dinari.api.core.jsonMapper
import com.dinari.api.models.v2.accounts.Chain
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TokenTransferTest {

    @Test
    fun create() {
        val tokenTransfer =
            TokenTransfer.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .chainId(Chain.EIP155_1)
                .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .quantity(0.0)
                .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .senderAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .status(TokenTransfer.Status.PENDING)
                .tokenAddress("token_address")
                .updatedDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .transactionHash("0xeaF12bD1DfFd")
                .build()

        assertThat(tokenTransfer.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(tokenTransfer.chainId()).isEqualTo(Chain.EIP155_1)
        assertThat(tokenTransfer.createdDt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(tokenTransfer.quantity()).isEqualTo(0.0)
        assertThat(tokenTransfer.recipientAccountId())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(tokenTransfer.senderAccountId())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(tokenTransfer.status()).isEqualTo(TokenTransfer.Status.PENDING)
        assertThat(tokenTransfer.tokenAddress()).isEqualTo("token_address")
        assertThat(tokenTransfer.updatedDt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(tokenTransfer.transactionHash()).contains("0xeaF12bD1DfFd")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val tokenTransfer =
            TokenTransfer.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .chainId(Chain.EIP155_1)
                .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .quantity(0.0)
                .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .senderAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .status(TokenTransfer.Status.PENDING)
                .tokenAddress("token_address")
                .updatedDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .transactionHash("0xeaF12bD1DfFd")
                .build()

        val roundtrippedTokenTransfer =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tokenTransfer),
                jacksonTypeRef<TokenTransfer>(),
            )

        assertThat(roundtrippedTokenTransfer).isEqualTo(tokenTransfer)
    }
}
