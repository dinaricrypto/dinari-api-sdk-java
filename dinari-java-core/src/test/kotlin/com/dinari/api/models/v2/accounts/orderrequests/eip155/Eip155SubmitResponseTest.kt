// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderrequests.eip155

import com.dinari.api.core.jsonMapper
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestStatus
import com.dinari.api.models.v2.accounts.orders.OrderSide
import com.dinari.api.models.v2.accounts.orders.OrderTif
import com.dinari.api.models.v2.accounts.orders.OrderType
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Eip155SubmitResponseTest {

    @Test
    fun create() {
        val eip155SubmitResponse =
            Eip155SubmitResponse.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .orderSide(OrderSide.BUY)
                .orderTif(OrderTif.DAY)
                .orderType(OrderType.MARKET)
                .status(OrderRequestStatus.QUOTED)
                .cancelMessage("cancel_message")
                .orderId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .rejectMessage("reject_message")
                .build()

        assertThat(eip155SubmitResponse.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(eip155SubmitResponse.accountId())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(eip155SubmitResponse.createdDt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(eip155SubmitResponse.orderSide()).isEqualTo(OrderSide.BUY)
        assertThat(eip155SubmitResponse.orderTif()).isEqualTo(OrderTif.DAY)
        assertThat(eip155SubmitResponse.orderType()).isEqualTo(OrderType.MARKET)
        assertThat(eip155SubmitResponse.status()).isEqualTo(OrderRequestStatus.QUOTED)
        assertThat(eip155SubmitResponse.cancelMessage()).contains("cancel_message")
        assertThat(eip155SubmitResponse.orderId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(eip155SubmitResponse.recipientAccountId())
            .contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(eip155SubmitResponse.rejectMessage()).contains("reject_message")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val eip155SubmitResponse =
            Eip155SubmitResponse.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .orderSide(OrderSide.BUY)
                .orderTif(OrderTif.DAY)
                .orderType(OrderType.MARKET)
                .status(OrderRequestStatus.QUOTED)
                .cancelMessage("cancel_message")
                .orderId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .rejectMessage("reject_message")
                .build()

        val roundtrippedEip155SubmitResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(eip155SubmitResponse),
                jacksonTypeRef<Eip155SubmitResponse>(),
            )

        assertThat(roundtrippedEip155SubmitResponse).isEqualTo(eip155SubmitResponse)
    }
}
