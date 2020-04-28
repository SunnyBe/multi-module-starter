package com.zistus.core.recycler_reuse.factory.models;

import android.view.View
import com.zistus.core.recycler_reuse.factory.interfaces.FactoryEventListener

abstract class UIField(
    val layout: Int,
    var key: String = "",
    var errorMessage: String = "",
    var dataSource: Any = Any()
) {

    // bind this UIModel to an itemView for a viewHolder
    abstract fun bind(itemView: View, factoryEventListener: FactoryEventListener?)

    // If UiModel has valid/expected data
    abstract fun hasValidData(): Boolean

    // Key chain the key value to uiField and extend the uiModel for more functionality
    fun withKey(key: String): UIField {
        this.key = key
        return this
    }

    // Key chain the dataSource to uiField and extend the uiModel for more functionality
    fun withDataSource(dataSource: Any): UIField {
        this.dataSource = dataSource
        return this
    }

    // Key chain error Message for this uiField
    open fun errorMessage(message: String): UIField {
        this.errorMessage = message
        return this
    }

    fun myKey(): String {
        return key
    }

    fun warn(): String {
        return errorMessage
    }

    open fun getValue(): Any {
        return Any()
    }

    // To prevent duplicate uiField by equating key
    override fun equals(other: Any?): Boolean {
        return (other as? UIField)?.key?.equals(this.key) ?: kotlin.run { false }
    }

    override fun hashCode(): Int {
        return key.hashCode()
    }

}
