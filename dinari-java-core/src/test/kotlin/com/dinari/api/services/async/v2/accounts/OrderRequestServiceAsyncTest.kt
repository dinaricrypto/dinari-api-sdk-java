// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.v2.accounts

import com.dinari.api.TestServerExtension
import com.dinari.api.client.okhttp.DinariOkHttpClientAsync
import com.dinari.api.core.JsonValue
import com.dinari.api.models.v2.accounts.Chain
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestCreateLimitBuyParams
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestCreateLimitSellParams
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestCreateMarketBuyParams
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestCreateMarketSellParams
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestGetFeeQuoteParams
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestListParams
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestRetrieveParams
import com.dinari.api.models.v2.accounts.orders.OrderSide
import com.dinari.api.models.v2.accounts.orders.OrderType
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class OrderRequestServiceAsyncTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieve() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val orderRequestServiceAsync = client.v2().accounts().orderRequests()

        val orderRequestFuture =
            orderRequestServiceAsync.retrieve(
                OrderRequestRetrieveParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .orderRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val orderRequest = orderRequestFuture.get()
        orderRequest.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun list() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val orderRequestServiceAsync = client.v2().accounts().orderRequests()

        val orderRequestsFuture =
            orderRequestServiceAsync.list(
                OrderRequestListParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .page(1L)
                    .pageSize(1L)
                    .build()
            )

        val orderRequests = orderRequestsFuture.get()
        orderRequests.forEach { it.validate() }
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun createLimitBuy() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val orderRequestServiceAsync = client.v2().accounts().orderRequests()

        val orderRequestFuture =
            orderRequestServiceAsync.createLimitBuy(
                OrderRequestCreateLimitBuyParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .assetQuantity(JsonValue.from("0"))
                    .limitPrice(JsonValue.from("0"))
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val orderRequest = orderRequestFuture.get()
        orderRequest.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun createLimitSell() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val orderRequestServiceAsync = client.v2().accounts().orderRequests()

        val orderRequestFuture =
            orderRequestServiceAsync.createLimitSell(
                OrderRequestCreateLimitSellParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .assetQuantity(JsonValue.from("0"))
                    .limitPrice(JsonValue.from("0"))
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .paymentTokenAddress("payment_token_address")
                    .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val orderRequest = orderRequestFuture.get()
        orderRequest.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun createMarketBuy() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val orderRequestServiceAsync = client.v2().accounts().orderRequests()

        val orderRequestFuture =
            orderRequestServiceAsync.createMarketBuy(
                OrderRequestCreateMarketBuyParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .paymentAmount(JsonValue.from("0"))
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val orderRequest = orderRequestFuture.get()
        orderRequest.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun createMarketSell() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val orderRequestServiceAsync = client.v2().accounts().orderRequests()

        val orderRequestFuture =
            orderRequestServiceAsync.createMarketSell(
                OrderRequestCreateMarketSellParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .assetQuantity(JsonValue.from("0"))
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .paymentTokenAddress("payment_token_address")
                    .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val orderRequest = orderRequestFuture.get()
        orderRequest.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun getFeeQuote() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val orderRequestServiceAsync = client.v2().accounts().orderRequests()

        val responseFuture =
            orderRequestServiceAsync.getFeeQuote(
                OrderRequestGetFeeQuoteParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .orderSide(OrderSide.BUY)
                    .orderType(OrderType.MARKET)
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .assetTokenQuantity(JsonValue.from("0"))
                    .chainId(Chain.EIP155_1)
                    .limitPrice(JsonValue.from("0"))
                    .paymentTokenAddress("payment_token_address")
                    .paymentTokenQuantity(JsonValue.from("0"))
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
