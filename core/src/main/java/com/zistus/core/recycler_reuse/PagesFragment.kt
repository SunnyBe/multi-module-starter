package com.zistus.core.recycler_reuse

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zistus.core.recycler_reuse.factory.adapter.UIFactoryAdapter
import com.zistus.core.recycler_reuse.factory.interfaces.FactoryEventListener
import com.zistus.core.recycler_reuse.factory.models.UIField
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment

open class PagesFragment : Fragment() {
    /*@LayoutRes
    val layourResId: Int*/

    lateinit var factoryRecycler: RecyclerView

    protected var factoryItemsAdapter =
        UIFactoryAdapter(arrayListOf(), object : FactoryEventListener {
            // Events that involves button clicks
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
        factoryRecycler.visibility =
            if (factoryItemsAdapter.items().isEmpty()) View.GONE else View.VISIBLE
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        factoryRecycler.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        factoryRecycler.setHasFixedSize(false)
        factoryRecycler.adapter = factoryItemsAdapter
    }

    fun <T> LiveData<T>.observe(block: (T) -> Unit) = observe(this@PagesFragment, Observer {
        block(it)
    })
}