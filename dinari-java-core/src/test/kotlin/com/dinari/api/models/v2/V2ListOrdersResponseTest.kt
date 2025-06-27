// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2

import com.dinari.api.core.jsonMapper
import com.dinari.api.models.v2.accounts.Chain
import com.dinari.api.models.v2.accounts.orders.BrokerageOrderStatus
import com.dinari.api.models.v2.accounts.orders.OrderSide
import com.dinari.api.models.v2.accounts.orders.OrderTif
import com.dinari.api.models.v2.accounts.orders.OrderType
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class V2ListOrdersResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val v2ListOrdersResponse =
            V2ListOrdersResponse.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .chainId(Chain.EIP155_1)
                .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .orderContractAddress("order_contract_address")
                .orderSide(OrderSide.BUY)
                .orderTif(OrderTif.DAY)
                .orderTransactionHash("0xeaF12bD1DfFd")
                .orderType(OrderType.MARKET)
                .status(BrokerageOrderStatus.PENDING_SUBMIT)
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .assetToken("asset_token")
                .assetTokenQuantity(0.0)
                .cancelTransactionHash("0xeaF12bD1DfFd")
                .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .fee(0.0)
                .limitPrice(0.0)
                .paymentToken("payment_token")
                .paymentTokenQuantity(0.0)
                .build()

        assertThat(v2ListOrdersResponse.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(v2ListOrdersResponse.chainId()).isEqualTo(Chain.EIP155_1)
        assertThat(v2ListOrdersResponse.createdDt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(v2ListOrdersResponse.orderContractAddress()).isEqualTo("order_contract_address")
        assertThat(v2ListOrdersResponse.orderSide()).isEqualTo(OrderSide.BUY)
        assertThat(v2ListOrdersResponse.orderTif()).isEqualTo(OrderTif.DAY)
        assertThat(v2ListOrdersResponse.orderTransactionHash()).isEqualTo("0xeaF12bD1DfFd")
        assertThat(v2ListOrdersResponse.orderType()).isEqualTo(OrderType.MARKET)
        assertThat(v2ListOrdersResponse.status()).isEqualTo(BrokerageOrderStatus.PENDING_SUBMIT)
        assertThat(v2ListOrdersResponse.stockId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(v2ListOrdersResponse.accountId())
            .contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(v2ListOrdersResponse.assetToken()).contains("asset_token")
        assertThat(v2ListOrdersResponse.assetTokenQuantity()).contains(0.0)
        assertThat(v2ListOrdersResponse.cancelTransactionHash()).contains("0xeaF12bD1DfFd")
        assertThat(v2ListOrdersResponse.entityId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(v2ListOrdersResponse.fee()).contains(0.0)
        assertThat(v2ListOrdersResponse.limitPrice()).contains(0.0)
        assertThat(v2ListOrdersResponse.paymentToken()).contains("payment_token")
        assertThat(v2ListOrdersResponse.paymentTokenQuantity()).contains(0.0)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val v2ListOrdersResponse =
            V2ListOrdersResponse.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .chainId(Chain.EIP155_1)
                .createdDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .orderContractAddress("order_contract_address")
                .orderSide(OrderSide.BUY)
                .orderTif(OrderTif.DAY)
                .orderTransactionHash("0xeaF12bD1DfFd")
                .orderType(OrderType.MARKET)
                .status(BrokerageOrderStatus.PENDING_SUBMIT)
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .assetToken("asset_token")
                .assetTokenQuantity(0.0)
                .cancelTransactionHash("0xeaF12bD1DfFd")
                .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .fee(0.0)
                .limitPrice(0.0)
                .paymentToken("payment_token")
                .paymentTokenQuantity(0.0)
                .build()

        val roundtrippedV2ListOrdersResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(v2ListOrdersResponse),
                jacksonTypeRef<V2ListOrdersResponse>(),
            )

        assertThat(roundtrippedV2ListOrdersResponse).isEqualTo(v2ListOrdersResponse)
    }
}
