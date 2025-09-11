// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.v2.accounts

import com.dinari.api.TestServerExtension
import com.dinari.api.client.okhttp.DinariOkHttpClientAsync
import com.dinari.api.models.v2.accounts.withdrawalrequests.WithdrawalRequestCreateParams
import com.dinari.api.models.v2.accounts.withdrawalrequests.WithdrawalRequestListParams
import com.dinari.api.models.v2.accounts.withdrawalrequests.WithdrawalRequestRetrieveParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class WithdrawalRequestServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun create() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val withdrawalRequestServiceAsync = client.v2().accounts().withdrawalRequests()

        val withdrawalRequestFuture =
            withdrawalRequestServiceAsync.create(
                WithdrawalRequestCreateParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .paymentTokenQuantity(0.0)
                    .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val withdrawalRequest = withdrawalRequestFuture.get()
        withdrawalRequest.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieve() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val withdrawalRequestServiceAsync = client.v2().accounts().withdrawalRequests()

        val withdrawalRequestFuture =
            withdrawalRequestServiceAsync.retrieve(
                WithdrawalRequestRetrieveParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .withdrawalRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val withdrawalRequest = withdrawalRequestFuture.get()
        withdrawalRequest.validate()
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
        val withdrawalRequestServiceAsync = client.v2().accounts().withdrawalRequests()

        val withdrawalRequestsFuture =
            withdrawalRequestServiceAsync.list(
                WithdrawalRequestListParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .page(1L)
                    .pageSize(1L)
                    .build()
            )

        val withdrawalRequests = withdrawalRequestsFuture.get()
        withdrawalRequests.forEach { it.validate() }
    }
}
