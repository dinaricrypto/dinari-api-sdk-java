// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.errors

import com.dinari.api.core.JsonValue
import com.dinari.api.core.http.Headers

abstract class DinariServiceException
protected constructor(message: String, cause: Throwable? = null) : DinariException(message, cause) {

    abstract fun statusCode(): Int

    abstract fun headers(): Headers

    abstract fun body(): JsonValue
}
