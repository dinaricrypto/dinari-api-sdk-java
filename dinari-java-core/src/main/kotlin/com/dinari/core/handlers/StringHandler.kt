@file:JvmName("StringHandler")

package com.dinari.core.handlers

import com.dinari.core.http.HttpResponse
import com.dinari.core.http.HttpResponse.Handler

@JvmSynthetic internal fun stringHandler(): Handler<String> = StringHandlerInternal

private object StringHandlerInternal : Handler<String> {
    override fun handle(response: HttpResponse): String =
        response.body().readBytes().toString(Charsets.UTF_8)
}
