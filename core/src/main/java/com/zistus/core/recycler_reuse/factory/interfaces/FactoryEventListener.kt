package com.zistus.core.recycler_reuse.factory.interfaces

import com.zistus.core.recycler_reuse.factory.models.UIField

interface FactoryEventListener {
    fun onItemClicked(uiField: UIField, params: Any = Any())
}