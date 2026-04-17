// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.accounts

import com.dinari.api.client.okhttp.DinariOkHttpClient
import com.dinari.api.models.v2.accounts.withdrawals.WithdrawalListParams
import com.dinari.api.models.v2.accounts.withdrawals.WithdrawalRetrieveParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class WithdrawalServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client =
            DinariOkHttpClient.builder()
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val withdrawalService = client.v2().accounts().withdrawals()

        val withdrawal =
            withdrawalService.retrieve(
                WithdrawalRetrieveParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .withdrawalId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        withdrawal.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            DinariOkHttpClient.builder()
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val withdrawalService = client.v2().accounts().withdrawals()

        val withdrawals =
            withdrawalService.list(
                WithdrawalListParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .limit(20L)
                    .next("next")
                    .order(WithdrawalListParams.Order.ASC)
                    .page(1L)
                    .pageSize(1L)
                    .previous("previous")
                    .withdrawalRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        withdrawals.validate()
    }
}
