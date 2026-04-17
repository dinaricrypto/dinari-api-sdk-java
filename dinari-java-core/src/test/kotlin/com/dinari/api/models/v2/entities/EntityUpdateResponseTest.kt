// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.entities

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EntityUpdateResponseTest {

    @Test
    fun create() {
        val entityUpdateResponse =
            EntityUpdateResponse.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .entityType(EntityUpdateResponse.EntityType.INDIVIDUAL)
                .isKycComplete(true)
                .name("name")
                .nationality("nationality")
                .referenceId("x")
                .build()

        assertThat(entityUpdateResponse.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(entityUpdateResponse.entityType())
            .isEqualTo(EntityUpdateResponse.EntityType.INDIVIDUAL)
        assertThat(entityUpdateResponse.isKycComplete()).isEqualTo(true)
        assertThat(entityUpdateResponse.name()).contains("name")
        assertThat(entityUpdateResponse.nationality()).contains("nationality")
        assertThat(entityUpdateResponse.referenceId()).contains("x")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val entityUpdateResponse =
            EntityUpdateResponse.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .entityType(EntityUpdateResponse.EntityType.INDIVIDUAL)
                .isKycComplete(true)
                .name("name")
                .nationality("nationality")
                .referenceId("x")
                .build()

        val roundtrippedEntityUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(entityUpdateResponse),
                jacksonTypeRef<EntityUpdateResponse>(),
            )

        assertThat(roundtrippedEntityUpdateResponse).isEqualTo(entityUpdateResponse)
    }
}
