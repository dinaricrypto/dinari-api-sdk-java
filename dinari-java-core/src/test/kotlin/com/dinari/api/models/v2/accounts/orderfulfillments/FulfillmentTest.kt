// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderfulfillments

import com.dinari.api.core.jsonMapper
import com.dinari.api.models.v2.accounts.Chain
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class FulfillmentTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val fulfillment =
            Fulfillment.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .assetTokenFilled(0.0)
                .assetTokenSpent(0.0)
                .chainId(Chain.EIP155_1)
                .orderId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .paymentTokenFilled(0.0)
                .paymentTokenSpent(0.0)
                .transactionDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .transactionHash("0xeaF12bD1DfFd")
                .paymentTokenFee(0.0)
                .build()

        assertThat(fulfillment.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(fulfillment.assetTokenFilled()).isEqualTo(0.0)
        assertThat(fulfillment.assetTokenSpent()).isEqualTo(0.0)
        assertThat(fulfillment.chainId()).isEqualTo(Chain.EIP155_1)
        assertThat(fulfillment.orderId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(fulfillment.paymentTokenFilled()).isEqualTo(0.0)
        assertThat(fulfillment.paymentTokenSpent()).isEqualTo(0.0)
        assertThat(fulfillment.transactionDt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(fulfillment.transactionHash()).isEqualTo("0xeaF12bD1DfFd")
        assertThat(fulfillment.paymentTokenFee()).contains(0.0)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fulfillment =
            Fulfillment.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .assetTokenFilled(0.0)
                .assetTokenSpent(0.0)
                .chainId(Chain.EIP155_1)
                .orderId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .paymentTokenFilled(0.0)
                .paymentTokenSpent(0.0)
                .transactionDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .transactionHash("0xeaF12bD1DfFd")
                .paymentTokenFee(0.0)
                .build()

        val roundtrippedFulfillment =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fulfillment),
                jacksonTypeRef<Fulfillment>(),
            )

        assertThat(roundtrippedFulfillment).isEqualTo(fulfillment)
    }
}
