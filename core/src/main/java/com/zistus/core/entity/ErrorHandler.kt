package com.zistus.core.entity

data class ErrorHandler(val type: String, override val message: String?): Throwable()