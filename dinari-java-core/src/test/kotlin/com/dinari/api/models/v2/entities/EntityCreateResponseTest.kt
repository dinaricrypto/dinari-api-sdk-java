// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.entities

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EntityCreateResponseTest {

    @Test
    fun create() {
        val entityCreateResponse =
            EntityCreateResponse.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .entityType(EntityCreateResponse.EntityType.INDIVIDUAL)
                .isKycComplete(true)
                .name("name")
                .nationality("nationality")
                .referenceId("x")
                .build()

        assertThat(entityCreateResponse.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(entityCreateResponse.entityType())
            .isEqualTo(EntityCreateResponse.EntityType.INDIVIDUAL)
        assertThat(entityCreateResponse.isKycComplete()).isEqualTo(true)
        assertThat(entityCreateResponse.name()).contains("name")
        assertThat(entityCreateResponse.nationality()).contains("nationality")
        assertThat(entityCreateResponse.referenceId()).contains("x")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val entityCreateResponse =
            EntityCreateResponse.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .entityType(EntityCreateResponse.EntityType.INDIVIDUAL)
                .isKycComplete(true)
                .name("name")
                .nationality("nationality")
                .referenceId("x")
                .build()

        val roundtrippedEntityCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(entityCreateResponse),
                jacksonTypeRef<EntityCreateResponse>(),
            )

        assertThat(roundtrippedEntityCreateResponse).isEqualTo(entityCreateResponse)
    }
}
