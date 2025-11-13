// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orders

import com.dinari.api.core.http.QueryParams
import com.dinari.api.models.v2.accounts.Chain
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OrderListParamsTest {

    @Test
    fun create() {
        OrderListParams.builder()
            .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .chainId(Chain.EIP155_1)
            .clientOrderId("client_order_id")
            .orderTransactionHash("order_transaction_hash")
            .page(1L)
            .pageSize(1L)
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            OrderListParams.builder().accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()

        assertThat(params._pathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            OrderListParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .chainId(Chain.EIP155_1)
                .clientOrderId("client_order_id")
                .orderTransactionHash("order_transaction_hash")
                .page(1L)
                .pageSize(1L)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("chain_id", "eip155:1")
                    .put("client_order_id", "client_order_id")
                    .put("order_transaction_hash", "order_transaction_hash")
                    .put("page", "1")
                    .put("page_size", "1")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            OrderListParams.builder().accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
