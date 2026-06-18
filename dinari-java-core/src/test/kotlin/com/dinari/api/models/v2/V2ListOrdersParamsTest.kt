// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2

import com.dinari.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class V2ListOrdersParamsTest {

    @Test
    fun create() {
        V2ListOrdersParams.builder()
            .chainId("chain_id")
            .limit(20L)
            .next("next")
            .order(V2ListOrdersParams.Order.ASC)
            .orderFulfillmentTransactionHash("order_fulfillment_transaction_hash")
            .orderRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .orderTransactionHash("order_transaction_hash")
            .previous("previous")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            V2ListOrdersParams.builder()
                .chainId("chain_id")
                .limit(20L)
                .next("next")
                .order(V2ListOrdersParams.Order.ASC)
                .orderFulfillmentTransactionHash("order_fulfillment_transaction_hash")
                .orderRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .orderTransactionHash("order_transaction_hash")
                .previous("previous")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("chain_id", "chain_id")
                    .put("limit", "20")
                    .put("next", "next")
                    .put("order", "asc")
                    .put("order_fulfillment_transaction_hash", "order_fulfillment_transaction_hash")
                    .put("order_request_id", "182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .put("order_transaction_hash", "order_transaction_hash")
                    .put("previous", "previous")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = V2ListOrdersParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
