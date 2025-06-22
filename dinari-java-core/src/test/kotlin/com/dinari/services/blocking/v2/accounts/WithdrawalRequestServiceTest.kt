// File generated from our OpenAPI spec by Stainless.

package com.dinari.services.blocking.v2.accounts

import com.dinari.TestServerExtension
import com.dinari.client.okhttp.DinariOkHttpClient
import com.dinari.core.JsonValue
import com.dinari.models.v2.accounts.withdrawalrequests.WithdrawalRequestCreateParams
import com.dinari.models.v2.accounts.withdrawalrequests.WithdrawalRequestListParams
import com.dinari.models.v2.accounts.withdrawalrequests.WithdrawalRequestRetrieveParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class WithdrawalRequestServiceTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val withdrawalRequestService = client.v2().accounts().withdrawalRequests()

        val withdrawalRequest =
            withdrawalRequestService.create(
                WithdrawalRequestCreateParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .paymentTokenQuantity(JsonValue.from("0"))
                    .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        withdrawalRequest.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieve() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val withdrawalRequestService = client.v2().accounts().withdrawalRequests()

        val withdrawalRequest =
            withdrawalRequestService.retrieve(
                WithdrawalRequestRetrieveParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .withdrawalRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        withdrawalRequest.validate()
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
        val withdrawalRequestService = client.v2().accounts().withdrawalRequests()

        val withdrawalRequests =
            withdrawalRequestService.list(
                WithdrawalRequestListParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .page(1L)
                    .pageSize(1L)
                    .build()
            )

        withdrawalRequests.forEach { it.validate() }
    }
}
