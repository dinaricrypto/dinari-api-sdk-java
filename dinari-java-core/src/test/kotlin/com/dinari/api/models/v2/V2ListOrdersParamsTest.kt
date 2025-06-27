// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2

import com.dinari.api.core.http.QueryParams
import com.dinari.api.models.v2.accounts.Chain
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class V2ListOrdersParamsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        V2ListOrdersParams.builder()
            .chainId(Chain.EIP155_1)
            .orderFulfillmentTransactionHash("order_fulfillment_transaction_hash")
            .orderTransactionHash("order_transaction_hash")
            .page(1L)
            .pageSize(1L)
            .build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun queryParams() {
        val params =
            V2ListOrdersParams.builder()
                .chainId(Chain.EIP155_1)
                .orderFulfillmentTransactionHash("order_fulfillment_transaction_hash")
                .orderTransactionHash("order_transaction_hash")
                .page(1L)
                .pageSize(1L)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("chain_id", "eip155:1")
                    .put("order_fulfillment_transaction_hash", "order_fulfillment_transaction_hash")
                    .put("order_transaction_hash", "order_transaction_hash")
                    .put("page", "1")
                    .put("page_size", "1")
                    .build()
            )
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = V2ListOrdersParams.builder().chainId(Chain.EIP155_1).build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("chain_id", "eip155:1").build())
    }
}
