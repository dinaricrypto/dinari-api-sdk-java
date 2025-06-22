// File generated from our OpenAPI spec by Stainless.

package com.dinari.services.async.v2.accounts

import com.dinari.TestServerExtension
import com.dinari.client.okhttp.DinariOkHttpClientAsync
import com.dinari.models.v2.accounts.orderfulfillments.OrderFulfillmentQueryParams
import com.dinari.models.v2.accounts.orderfulfillments.OrderFulfillmentRetrieveParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class OrderFulfillmentServiceAsyncTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieve() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val orderFulfillmentServiceAsync = client.v2().accounts().orderFulfillments()

        val fulfillmentFuture =
            orderFulfillmentServiceAsync.retrieve(
                OrderFulfillmentRetrieveParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .orderFulfillmentId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val fulfillment = fulfillmentFuture.get()
        fulfillment.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun query() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val orderFulfillmentServiceAsync = client.v2().accounts().orderFulfillments()

        val fulfillmentsFuture =
            orderFulfillmentServiceAsync.query(
                OrderFulfillmentQueryParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .addOrderId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .page(1L)
                    .pageSize(1L)
                    .build()
            )

        val fulfillments = fulfillmentsFuture.get()
        fulfillments.forEach { it.validate() }
    }
}
