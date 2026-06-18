// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.accounts

import com.dinari.api.client.okhttp.DinariOkHttpClient
import com.dinari.api.models.v2.accounts.tokentransfers.TokenTransferCreateParams
import com.dinari.api.models.v2.accounts.tokentransfers.TokenTransferListParams
import com.dinari.api.models.v2.accounts.tokentransfers.TokenTransferRetrieveParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class TokenTransferServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            DinariOkHttpClient.builder()
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val tokenTransferService = client.v2().accounts().tokenTransfers()

        val tokenTransfer =
            tokenTransferService.create(
                TokenTransferCreateParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .quantity(0.0)
                    .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .tokenAddress("token_address")
                    .build()
            )

        tokenTransfer.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client =
            DinariOkHttpClient.builder()
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val tokenTransferService = client.v2().accounts().tokenTransfers()

        val tokenTransfer =
            tokenTransferService.retrieve(
                TokenTransferRetrieveParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .transferId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        tokenTransfer.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            DinariOkHttpClient.builder()
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val tokenTransferService = client.v2().accounts().tokenTransfers()

        val tokenTransfers =
            tokenTransferService.list(
                TokenTransferListParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .limit(20L)
                    .next("next")
                    .order(TokenTransferListParams.Order.ASC)
                    .previous("previous")
                    .build()
            )

        tokenTransfers.validate()
    }
}
