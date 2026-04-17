// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.entities

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EntityRetrieveCurrentResponseTest {

    @Test
    fun create() {
        val entityRetrieveCurrentResponse =
            EntityRetrieveCurrentResponse.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .entityType(EntityRetrieveCurrentResponse.EntityType.INDIVIDUAL)
                .isKycComplete(true)
                .name("name")
                .nationality("nationality")
                .referenceId("x")
                .build()

        assertThat(entityRetrieveCurrentResponse.id())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(entityRetrieveCurrentResponse.entityType())
            .isEqualTo(EntityRetrieveCurrentResponse.EntityType.INDIVIDUAL)
        assertThat(entityRetrieveCurrentResponse.isKycComplete()).isEqualTo(true)
        assertThat(entityRetrieveCurrentResponse.name()).contains("name")
        assertThat(entityRetrieveCurrentResponse.nationality()).contains("nationality")
        assertThat(entityRetrieveCurrentResponse.referenceId()).contains("x")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val entityRetrieveCurrentResponse =
            EntityRetrieveCurrentResponse.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .entityType(EntityRetrieveCurrentResponse.EntityType.INDIVIDUAL)
                .isKycComplete(true)
                .name("name")
                .nationality("nationality")
                .referenceId("x")
                .build()

        val roundtrippedEntityRetrieveCurrentResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(entityRetrieveCurrentResponse),
                jacksonTypeRef<EntityRetrieveCurrentResponse>(),
            )

        assertThat(roundtrippedEntityRetrieveCurrentResponse)
            .isEqualTo(entityRetrieveCurrentResponse)
    }
}
