@file:JvmName("EmptyHandler")

package com.dinari.api.core.handlers

import com.dinari.api.core.http.HttpResponse
import com.dinari.api.core.http.HttpResponse.Handler

@JvmSynthetic internal fun emptyHandler(): Handler<Void?> = EmptyHandlerInternal

private object EmptyHandlerInternal : Handler<Void?> {
    override fun handle(response: HttpResponse): Void? = null
}
