// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.api.v2.accounts

import com.dinari.api.TestServerExtension
import com.dinari.api.client.okhttp.DinariOkHttpClientAsync
import com.dinari.api.models.api.v2.accounts.orders.OrderCancelParams
import com.dinari.api.models.api.v2.accounts.orders.OrderListParams
import com.dinari.api.models.api.v2.accounts.orders.OrderRetrieveFulfillmentsParams
import com.dinari.api.models.api.v2.accounts.orders.OrderRetrieveParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class OrderServiceAsyncTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieve() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .secret("My Secret")
                .build()
        val orderServiceAsync = client.api().v2().accounts().orders()

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

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun list() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .secret("My Secret")
                .build()
        val orderServiceAsync = client.api().v2().accounts().orders()

        val ordersFuture =
            orderServiceAsync.list(
                OrderListParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .page(1L)
                    .pageSize(1L)
                    .build()
            )

        val orders = ordersFuture.get()
        orders.forEach { it.validate() }
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun cancel() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .secret("My Secret")
                .build()
        val orderServiceAsync = client.api().v2().accounts().orders()

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

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieveFulfillments() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .secret("My Secret")
                .build()
        val orderServiceAsync = client.api().v2().accounts().orders()

        val orderFulfillmentsFuture =
            orderServiceAsync.retrieveFulfillments(
                OrderRetrieveFulfillmentsParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .orderId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .page(1L)
                    .pageSize(1L)
                    .build()
            )

        val orderFulfillments = orderFulfillmentsFuture.get()
        orderFulfillments.forEach { it.validate() }
    }
}
