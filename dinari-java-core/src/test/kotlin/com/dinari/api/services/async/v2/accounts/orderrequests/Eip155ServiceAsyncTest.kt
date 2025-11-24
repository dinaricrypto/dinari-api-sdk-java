// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.v2.accounts.orderrequests

import com.dinari.api.TestServerExtension
import com.dinari.api.client.okhttp.DinariOkHttpClientAsync
import com.dinari.api.models.v2.accounts.Chain
import com.dinari.api.models.v2.accounts.orderrequests.eip155.Eip155CreatePermitParams
import com.dinari.api.models.v2.accounts.orderrequests.eip155.Eip155CreatePermitTransactionParams
import com.dinari.api.models.v2.accounts.orderrequests.eip155.Eip155OrderRequestPermitTransaction
import com.dinari.api.models.v2.accounts.orderrequests.eip155.Eip155SubmitParams
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
    fun createPermit() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val eip155ServiceAsync = client.v2().accounts().orderRequests().eip155()

        val responseFuture =
            eip155ServiceAsync.createPermit(
                Eip155CreatePermitParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .chainId(Chain.EIP155_1)
                    .orderSide(OrderSide.BUY)
                    .orderTif(OrderTif.DAY)
                    .orderType(OrderType.MARKET)
                    .paymentToken("payment_token")
                    .assetTokenQuantity(0.0)
                    .clientOrderId("client_order_id")
                    .limitPrice(0.0)
                    .paymentTokenQuantity(0.0)
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .tokenId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun createPermitTransaction() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val eip155ServiceAsync = client.v2().accounts().orderRequests().eip155()

        val responseFuture =
            eip155ServiceAsync.createPermitTransaction(
                Eip155CreatePermitTransactionParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .eip155OrderRequestPermitTransaction(
                        Eip155OrderRequestPermitTransaction.builder()
                            .orderRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .permitSignature("0xeaF12bD1DfFd")
                            .build()
                    )
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun submit() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val eip155ServiceAsync = client.v2().accounts().orderRequests().eip155()

        val responseFuture =
            eip155ServiceAsync.submit(
                Eip155SubmitParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .eip155OrderRequestPermitTransaction(
                        Eip155OrderRequestPermitTransaction.builder()
                            .orderRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .permitSignature("0xeaF12bD1DfFd")
                            .build()
                    )
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
