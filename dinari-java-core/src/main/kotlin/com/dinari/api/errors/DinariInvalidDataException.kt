package com.dinari.api.errors

class DinariInvalidDataException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) : DinariException(message, cause)
