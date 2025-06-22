@file:JvmName("JsonHandler")

package com.dinari.core.handlers

import com.dinari.core.http.HttpResponse
import com.dinari.core.http.HttpResponse.Handler
import com.dinari.errors.DinariInvalidDataException
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef

@JvmSynthetic
internal inline fun <reified T> jsonHandler(jsonMapper: JsonMapper): Handler<T> =
    object : Handler<T> {
        override fun handle(response: HttpResponse): T =
            try {
                jsonMapper.readValue(response.body(), jacksonTypeRef())
            } catch (e: Exception) {
                throw DinariInvalidDataException("Error reading response", e)
            }
    }
