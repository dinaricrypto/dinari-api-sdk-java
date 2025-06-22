// File generated from our OpenAPI spec by Stainless.

package com.dinari.services.blocking.v2.accounts

import com.dinari.TestServerExtension
import com.dinari.client.okhttp.DinariOkHttpClient
import com.dinari.core.JsonValue
import com.dinari.models.v2.accounts.orderrequests.CreateLimitOrderInput
import com.dinari.models.v2.accounts.orderrequests.OrderRequestCreateLimitBuyParams
import com.dinari.models.v2.accounts.orderrequests.OrderRequestCreateLimitSellParams
import com.dinari.models.v2.accounts.orderrequests.OrderRequestCreateMarketBuyParams
import com.dinari.models.v2.accounts.orderrequests.OrderRequestCreateMarketSellParams
import com.dinari.models.v2.accounts.orderrequests.OrderRequestGetFeeQuoteParams
import com.dinari.models.v2.accounts.orderrequests.OrderRequestListParams
import com.dinari.models.v2.accounts.orderrequests.OrderRequestRetrieveParams
import com.dinari.models.v2.accounts.orders.OrderSide
import com.dinari.models.v2.accounts.orders.OrderType
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class OrderRequestServiceTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieve() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val orderRequestService = client.v2().accounts().orderRequests()

        val orderRequest =
            orderRequestService.retrieve(
                OrderRequestRetrieveParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .orderRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        orderRequest.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun list() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val orderRequestService = client.v2().accounts().orderRequests()

        val orderRequests =
            orderRequestService.list(
                OrderRequestListParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .page(1L)
                    .pageSize(1L)
                    .build()
            )

        orderRequests.forEach { it.validate() }
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun createLimitBuy() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val orderRequestService = client.v2().accounts().orderRequests()

        val orderRequest =
            orderRequestService.createLimitBuy(
                OrderRequestCreateLimitBuyParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .createLimitOrderInput(
                        CreateLimitOrderInput.builder()
                            .assetQuantity(0L)
                            .limitPrice(0.0)
                            .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .build()
                    )
                    .build()
            )

        orderRequest.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun createLimitSell() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val orderRequestService = client.v2().accounts().orderRequests()

        val orderRequest =
            orderRequestService.createLimitSell(
                OrderRequestCreateLimitSellParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .createLimitOrderInput(
                        CreateLimitOrderInput.builder()
                            .assetQuantity(0L)
                            .limitPrice(0.0)
                            .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .build()
                    )
                    .build()
            )

        orderRequest.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun createMarketBuy() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val orderRequestService = client.v2().accounts().orderRequests()

        val orderRequest =
            orderRequestService.createMarketBuy(
                OrderRequestCreateMarketBuyParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .paymentAmount(JsonValue.from("0"))
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        orderRequest.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun createMarketSell() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val orderRequestService = client.v2().accounts().orderRequests()

        val orderRequest =
            orderRequestService.createMarketSell(
                OrderRequestCreateMarketSellParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .assetQuantity(JsonValue.from("0"))
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        orderRequest.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun getFeeQuote() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val orderRequestService = client.v2().accounts().orderRequests()

        val response =
            orderRequestService.getFeeQuote(
                OrderRequestGetFeeQuoteParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .orderSide(OrderSide.BUY)
                    .orderType(OrderType.MARKET)
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .assetTokenQuantity(JsonValue.from("0"))
                    .limitPrice(JsonValue.from("0"))
                    .paymentTokenQuantity(JsonValue.from("0"))
                    .build()
            )

        response.validate()
    }
}
