// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.v2.accounts

import com.dinari.api.TestServerExtension
import com.dinari.api.client.okhttp.DinariOkHttpClientAsync
import com.dinari.api.models.v2.accounts.Chain
import com.dinari.api.models.v2.accounts.orders.OrderCancelParams
import com.dinari.api.models.v2.accounts.orders.OrderGetFulfillmentsParams
import com.dinari.api.models.v2.accounts.orders.OrderListParams
import com.dinari.api.models.v2.accounts.orders.OrderRetrieveParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class OrderServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieve() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val orderServiceAsync = client.v2().accounts().orders()

        val orderFuture =
            orderServiceAsync.retrieve(
                OrderRetrieveParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .orderId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val order = orderFuture.get()
        order.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun list() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val orderServiceAsync = client.v2().accounts().orders()

        val ordersFuture =
            orderServiceAsync.list(
                OrderListParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .chainId(Chain.EIP155_1)
                    .clientOrderId("client_order_id")
                    .orderTransactionHash("order_transaction_hash")
                    .page(1L)
                    .pageSize(1L)
                    .build()
            )

        val orders = ordersFuture.get()
        orders.forEach { it.validate() }
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun cancel() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val orderServiceAsync = client.v2().accounts().orders()

        val orderFuture =
            orderServiceAsync.cancel(
                OrderCancelParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .orderId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val order = orderFuture.get()
        order.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun getFulfillments() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val orderServiceAsync = client.v2().accounts().orders()

        val fulfillmentsFuture =
            orderServiceAsync.getFulfillments(
                OrderGetFulfillmentsParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .orderId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .page(1L)
                    .pageSize(1L)
                    .build()
            )

        val fulfillments = fulfillmentsFuture.get()
        fulfillments.forEach { it.validate() }
    }
}
