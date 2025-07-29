// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.entities

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EntityCreateParamsTest {

    @Test
    fun create() {
        EntityCreateParams.builder().name("x").referenceId("x").build()
    }

    @Test
    fun body() {
        val params = EntityCreateParams.builder().name("x").referenceId("x").build()

        val body = params._body()

        assertThat(body.name()).isEqualTo("x")
        assertThat(body.referenceId()).contains("x")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = EntityCreateParams.builder().name("x").build()

        val body = params._body()

        assertThat(body.name()).isEqualTo("x")
    }
}
