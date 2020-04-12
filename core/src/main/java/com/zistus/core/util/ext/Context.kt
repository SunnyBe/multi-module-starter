package com.zistus.core.util.ext

import android.app.Activity
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty


/**
 * Extract the intent extras data
 * @param name used as the key name for extras data
 */
fun <T> intentExtra(name: String? = null) = object : ReadOnlyProperty<Activity, T?> {
    override fun getValue(thisRef: Activity, property: KProperty<*>): T? {
        return thisRef.intent.extras?.get(name ?: property.name) as? T
    }
}