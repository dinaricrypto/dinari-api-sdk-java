// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderrequests

import com.dinari.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OrderRequestListParamsTest {

    @Test
    fun create() {
        OrderRequestListParams.builder()
            .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .clientOrderId("client_order_id")
            .limit(20L)
            .next("next")
            .order(OrderRequestListParams.Order.ASC)
            .orderId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .orderRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .page(1L)
            .pageSize(1L)
            .previous("previous")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            OrderRequestListParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            OrderRequestListParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .clientOrderId("client_order_id")
                .limit(20L)
                .next("next")
                .order(OrderRequestListParams.Order.ASC)
                .orderId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .orderRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .page(1L)
                .pageSize(1L)
                .previous("previous")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("client_order_id", "client_order_id")
                    .put("limit", "20")
                    .put("next", "next")
                    .put("order", "asc")
                    .put("order_id", "182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .put("order_request_id", "182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .put("page", "1")
                    .put("page_size", "1")
                    .put("previous", "previous")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            OrderRequestListParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
