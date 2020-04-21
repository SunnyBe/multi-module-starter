package com.zistus.core.util.misc

data class ErrorManager(
    val type: ErrorType,
    override val message: String?,
    val error: Throwable?
) : Throwable()

enum class ErrorType {
    CORE_SPLIT,
    SYSTEM
}

fun Throwable.toErrorManager(type: ErrorType, overrideMsg: String? = this.message) = ErrorManager(type, overrideMsg, this)

fun Exception.toErrorManager(type: ErrorType, overrideMsg: String? = this.message) = ErrorManager(type, overrideMsg, this)