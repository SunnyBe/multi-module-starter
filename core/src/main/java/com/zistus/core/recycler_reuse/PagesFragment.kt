package com.zistus.core.recycler_reuse

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zistus.core.recycler_reuse.factory.adapter.UIFactoryAdapter
import com.zistus.core.recycler_reuse.factory.interfaces.FactoryEventListener
import com.zistus.core.recycler_reuse.factory.models.UIField
import kotlinx.android.synthetic.main.item_page_fragment.*

open class PagesFragment: Fragment() {

    protected var factoryItemsAdapter = UIFactoryAdapter(arrayListOf(), object : FactoryEventListener {
        override fun onItemClicked(uiField: UIField, params: Any) {
            when (uiField) {

            }
        }
    })


    fun setAdapterEvent(factoryEventListener: FactoryEventListener) {
        factoryItemsAdapter.setEventAdapter(factoryEventListener)
    }

    open fun update(uiModels: MutableList<UIField>?) {
        uiModels?.let { factoryItemsAdapter.updatePage(it) }
        factoryRecycler.visibility = if (factoryItemsAdapter.items().isEmpty()) View.GONE else View.VISIBLE
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        factoryRecycler.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        factoryRecycler.setHasFixedSize(false)
        factoryRecycler.adapter = factoryItemsAdapter
    }
}