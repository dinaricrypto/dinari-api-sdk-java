package com.dinari.errors

class DinariInvalidDataException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) : DinariException(message, cause)
