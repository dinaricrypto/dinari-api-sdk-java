// File generated from our OpenAPI spec by Stainless.

@file:JvmName("ErrorHandler")

package com.dinari.api.core.handlers

import com.dinari.api.core.JsonMissing
import com.dinari.api.core.JsonValue
import com.dinari.api.core.http.HttpResponse
import com.dinari.api.core.http.HttpResponse.Handler
import com.dinari.api.errors.BadRequestException
import com.dinari.api.errors.InternalServerException
import com.dinari.api.errors.NotFoundException
import com.dinari.api.errors.PermissionDeniedException
import com.dinari.api.errors.RateLimitException
import com.dinari.api.errors.UnauthorizedException
import com.dinari.api.errors.UnexpectedStatusCodeException
import com.dinari.api.errors.UnprocessableEntityException
import com.fasterxml.jackson.databind.json.JsonMapper

@JvmSynthetic
internal fun errorHandler(jsonMapper: JsonMapper): Handler<JsonValue> {
    val handler = jsonHandler<JsonValue>(jsonMapper)

    return object : Handler<JsonValue> {
        override fun handle(response: HttpResponse): JsonValue =
            try {
                handler.handle(response)
            } catch (e: Exception) {
                JsonMissing.of()
            }
    }
}

@JvmSynthetic
internal fun <T> Handler<T>.withErrorHandler(errorHandler: Handler<JsonValue>): Handler<T> =
    object : Handler<T> {
        override fun handle(response: HttpResponse): T =
            when (val statusCode = response.statusCode()) {
                in 200..299 -> this@withErrorHandler.handle(response)
                400 ->
                    throw BadRequestException.builder()
                        .headers(response.headers())
                        .body(errorHandler.handle(response))
                        .build()
                401 ->
                    throw UnauthorizedException.builder()
                        .headers(response.headers())
                        .body(errorHandler.handle(response))
                        .build()
                403 ->
                    throw PermissionDeniedException.builder()
                        .headers(response.headers())
                        .body(errorHandler.handle(response))
                        .build()
                404 ->
                    throw NotFoundException.builder()
                        .headers(response.headers())
                        .body(errorHandler.handle(response))
                        .build()
                422 ->
                    throw UnprocessableEntityException.builder()
                        .headers(response.headers())
                        .body(errorHandler.handle(response))
                        .build()
                429 ->
                    throw RateLimitException.builder()
                        .headers(response.headers())
                        .body(errorHandler.handle(response))
                        .build()
                in 500..599 ->
                    throw InternalServerException.builder()
                        .statusCode(statusCode)
                        .headers(response.headers())
                        .body(errorHandler.handle(response))
                        .build()
                else ->
                    throw UnexpectedStatusCodeException.builder()
                        .statusCode(statusCode)
                        .headers(response.headers())
                        .body(errorHandler.handle(response))
                        .build()
            }
    }
