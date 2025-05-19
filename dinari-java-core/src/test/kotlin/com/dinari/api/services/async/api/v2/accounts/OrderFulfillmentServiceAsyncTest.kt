// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.api.v2.accounts

import com.dinari.api.TestServerExtension
import com.dinari.api.client.okhttp.DinariOkHttpClientAsync
import com.dinari.api.models.api.v2.accounts.orderfulfillments.OrderFulfillmentQueryParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class OrderFulfillmentServiceAsyncTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun query() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .secret("My Secret")
                .build()
        val orderFulfillmentServiceAsync = client.api().v2().accounts().orderFulfillments()

        val orderFulfillmentsFuture =
            orderFulfillmentServiceAsync.query(
                OrderFulfillmentQueryParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .addOrderId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .page(1L)
                    .pageSize(1L)
                    .build()
            )

        val orderFulfillments = orderFulfillmentsFuture.get()
        orderFulfillments.forEach { it.validate() }
    }
}
