package com.zistus.core.util.misc

data class ErrorManager(
    val type: String,
    override val message: String?,
    override val cause: Throwable?
) : Throwable()