@file:JvmName("EmptyHandler")

package com.dinari.core.handlers

import com.dinari.core.http.HttpResponse
import com.dinari.core.http.HttpResponse.Handler

@JvmSynthetic internal fun emptyHandler(): Handler<Void?> = EmptyHandlerInternal

private object EmptyHandlerInternal : Handler<Void?> {
    override fun handle(response: HttpResponse): Void? = null
}
