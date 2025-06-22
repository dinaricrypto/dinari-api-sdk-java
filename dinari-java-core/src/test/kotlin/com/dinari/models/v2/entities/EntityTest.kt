// File generated from our OpenAPI spec by Stainless.

package com.dinari.models.v2.entities

import com.dinari.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class EntityTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val entity =
            Entity.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .entityType(Entity.EntityType.INDIVIDUAL)
                .isKycComplete(true)
                .name("name")
                .nationality("nationality")
                .build()

        assertThat(entity.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(entity.entityType()).isEqualTo(Entity.EntityType.INDIVIDUAL)
        assertThat(entity.isKycComplete()).isEqualTo(true)
        assertThat(entity.name()).contains("name")
        assertThat(entity.nationality()).contains("nationality")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val entity =
            Entity.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .entityType(Entity.EntityType.INDIVIDUAL)
                .isKycComplete(true)
                .name("name")
                .nationality("nationality")
                .build()

        val roundtrippedEntity =
            jsonMapper.readValue(jsonMapper.writeValueAsString(entity), jacksonTypeRef<Entity>())

        assertThat(roundtrippedEntity).isEqualTo(entity)
    }
}
