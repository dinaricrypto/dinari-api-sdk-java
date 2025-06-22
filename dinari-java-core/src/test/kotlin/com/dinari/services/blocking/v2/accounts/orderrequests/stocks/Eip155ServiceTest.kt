// File generated from our OpenAPI spec by Stainless.

package com.dinari.services.blocking.v2.accounts.orderrequests.stocks

import com.dinari.TestServerExtension
import com.dinari.client.okhttp.DinariOkHttpClient
import com.dinari.core.JsonValue
import com.dinari.models.v2.accounts.Chain
import com.dinari.models.v2.accounts.orderrequests.stocks.eip155.Eip155CreateProxiedOrderParams
import com.dinari.models.v2.accounts.orderrequests.stocks.eip155.Eip155PrepareProxiedOrderParams
import com.dinari.models.v2.accounts.orders.OrderSide
import com.dinari.models.v2.accounts.orders.OrderTif
import com.dinari.models.v2.accounts.orders.OrderType
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class Eip155ServiceTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun createProxiedOrder() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val eip155Service = client.v2().accounts().orderRequests().stocks().eip155()

        val orderRequest =
            eip155Service.createProxiedOrder(
                Eip155CreateProxiedOrderParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .orderSignature("0xeaF12bD1DfFd")
                    .permitSignature("0xeaF12bD1DfFd")
                    .preparedProxiedOrderId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        orderRequest.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun prepareProxiedOrder() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val eip155Service = client.v2().accounts().orderRequests().stocks().eip155()

        val response =
            eip155Service.prepareProxiedOrder(
                Eip155PrepareProxiedOrderParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .chainId(Chain.EIP155_1)
                    .orderSide(OrderSide.BUY)
                    .orderTif(OrderTif.DAY)
                    .orderType(OrderType.MARKET)
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .assetTokenQuantity(JsonValue.from("0"))
                    .limitPrice(JsonValue.from("0"))
                    .paymentToken("payment_token")
                    .paymentTokenQuantity(JsonValue.from("0"))
                    .build()
            )

        response.validate()
    }
}
