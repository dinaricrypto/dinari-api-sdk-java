// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.v2.accounts

import com.dinari.api.client.okhttp.DinariOkHttpClientAsync
import com.dinari.api.models.v2.accounts.orders.OrderBatchCancelParams
import com.dinari.api.models.v2.accounts.orders.OrderCancelParams
import com.dinari.api.models.v2.accounts.orders.OrderGetFulfillmentsParams
import com.dinari.api.models.v2.accounts.orders.OrderListParams
import com.dinari.api.models.v2.accounts.orders.OrderRetrieveParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class OrderServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client =
            DinariOkHttpClientAsync.builder()
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

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            DinariOkHttpClientAsync.builder()
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val orderServiceAsync = client.v2().accounts().orders()

        val ordersFuture =
            orderServiceAsync.list(
                OrderListParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .chainId("chain_id")
                    .clientOrderId("client_order_id")
                    .limit(20L)
                    .next("next")
                    .order(OrderListParams.Order.ASC)
                    .orderTransactionHash("order_transaction_hash")
                    .previous("previous")
                    .build()
            )

        val orders = ordersFuture.get()
        orders.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun batchCancel() {
        val client =
            DinariOkHttpClientAsync.builder()
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val orderServiceAsync = client.v2().accounts().orders()

        val responseFuture =
            orderServiceAsync.batchCancel(
                OrderBatchCancelParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .addOrderId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun cancel() {
        val client =
            DinariOkHttpClientAsync.builder()
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

    @Disabled("Mock server tests are disabled")
    @Test
    fun getFulfillments() {
        val client =
            DinariOkHttpClientAsync.builder()
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val orderServiceAsync = client.v2().accounts().orders()

        val paginatedOrderFulfillmentFuture =
            orderServiceAsync.getFulfillments(
                OrderGetFulfillmentsParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .orderId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .limit(20L)
                    .next("next")
                    .order(OrderGetFulfillmentsParams.Order.ASC)
                    .previous("previous")
                    .build()
            )

        val paginatedOrderFulfillment = paginatedOrderFulfillmentFuture.get()
        paginatedOrderFulfillment.validate()
    }
}
