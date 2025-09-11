// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.v2.accounts.orderrequests.stocks

import com.dinari.api.TestServerExtension
import com.dinari.api.client.okhttp.DinariOkHttpClientAsync
import com.dinari.api.models.v2.accounts.Chain
import com.dinari.api.models.v2.accounts.orderrequests.stocks.eip155.Eip155CreateProxiedOrderParams
import com.dinari.api.models.v2.accounts.orderrequests.stocks.eip155.Eip155PrepareProxiedOrderParams
import com.dinari.api.models.v2.accounts.orders.OrderSide
import com.dinari.api.models.v2.accounts.orders.OrderTif
import com.dinari.api.models.v2.accounts.orders.OrderType
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class Eip155ServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun createProxiedOrder() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val eip155ServiceAsync = client.v2().accounts().orderRequests().stocks().eip155()

        val orderRequestFuture =
            eip155ServiceAsync.createProxiedOrder(
                Eip155CreateProxiedOrderParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .orderSignature("0xeaF12bD1DfFd")
                    .permitSignature("0xeaF12bD1DfFd")
                    .preparedProxiedOrderId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val orderRequest = orderRequestFuture.get()
        orderRequest.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun prepareProxiedOrder() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val eip155ServiceAsync = client.v2().accounts().orderRequests().stocks().eip155()

        val responseFuture =
            eip155ServiceAsync.prepareProxiedOrder(
                Eip155PrepareProxiedOrderParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .chainId(Chain.EIP155_1)
                    .orderSide(OrderSide.BUY)
                    .orderTif(OrderTif.DAY)
                    .orderType(OrderType.MARKET)
                    .paymentToken("payment_token")
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .assetTokenQuantity(0.0)
                    .limitPrice(0.0)
                    .paymentTokenQuantity(0.0)
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
