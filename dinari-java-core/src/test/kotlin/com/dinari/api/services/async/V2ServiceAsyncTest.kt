// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async

import com.dinari.api.client.okhttp.DinariOkHttpClientAsync
import com.dinari.api.models.v2.V2ListOrdersParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class V2ServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun listOrders() {
        val client =
            DinariOkHttpClientAsync.builder()
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val v2ServiceAsync = client.v2()

        val responseFuture =
            v2ServiceAsync.listOrders(
                V2ListOrdersParams.builder()
                    .chainId("chain_id")
                    .limit(20L)
                    .next("next")
                    .order(V2ListOrdersParams.Order.ASC)
                    .orderFulfillmentTransactionHash("order_fulfillment_transaction_hash")
                    .orderRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .orderTransactionHash("order_transaction_hash")
                    .previous("previous")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
