// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async

import com.dinari.api.TestServerExtension
import com.dinari.api.client.okhttp.DinariOkHttpClientAsync
import com.dinari.api.models.v2.V2ListOrdersParams
import com.dinari.api.models.v2.accounts.Chain
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class V2ServiceAsyncTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun listOrders() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val v2ServiceAsync = client.v2()

        val responseFuture =
            v2ServiceAsync.listOrders(
                V2ListOrdersParams.builder()
                    .chainId(Chain.EIP155_1)
                    .orderFulfillmentTransactionHash("order_fulfillment_transaction_hash")
                    .orderRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .orderTransactionHash("order_transaction_hash")
                    .page(1L)
                    .pageSize(1L)
                    .build()
            )

        val response = responseFuture.get()
        response.forEach { it.validate() }
    }
}
