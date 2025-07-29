// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.entities

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EntityUpdateParamsTest {

    @Test
    fun create() {
        EntityUpdateParams.builder()
            .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .referenceId("x")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            EntityUpdateParams.builder().entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()

        assertThat(params._pathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            EntityUpdateParams.builder()
                .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .referenceId("x")
                .build()

        val body = params._body()

        assertThat(body.referenceId()).contains("x")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            EntityUpdateParams.builder().entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()

        val body = params._body()
    }
}
