package com.zistus.core.recycler_reuse.factory.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zistus.core.recycler_reuse.factory.interfaces.FactoryEventListener
import com.zistus.core.recycler_reuse.factory.models.UIField

open class UIFactoryAdapter(private val uiModels: MutableList<UIField>, private var factoryEventListener: FactoryEventListener? = null): RecyclerView.Adapter<UIFactoryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UIFactoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return UIFactoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return uiModels.size
    }

    override fun onBindViewHolder(holder: UIFactoryViewHolder, position: Int) {
        holder.bind(uiModels[position], factoryEventListener)
    }

    fun setEventAdapter(factoryEventListener: FactoryEventListener) {
        this.factoryEventListener = factoryEventListener
    }

    fun updatePage(uiModels: MutableList<UIField>) {
        this.uiModels.clear()
        this.uiModels.addAll(uiModels)
        notifyDataSetChanged()
    }

    fun items(): MutableList<UIField> {
        return uiModels
    }

    fun fieldWithKey(key: String): UIField? {
        return uiModels.find { it.key == key }
    }

    fun fieldIndex(field: UIField): Int {
        return uiModels.indexOfFirst { field.key == it.key }
    }

    fun fieldIndexWithKey(key: String): Int {
        val field = uiModels.find { it.key == key }
        return field?.let { uiModels.indexOf(field) } ?: kotlin.run { -1 }
    }

    fun isFormValid(): Boolean {
        var result = true
        uiModels.forEach {
            result = result && it.hasValidData()
        }
        return result
    }


    fun formWarning(): String {
        uiModels.forEach {
            if (!it.hasValidData())
                return it.errorMessage
        }
        return ""
    }

    fun factoryFormData(): HashMap<String, Any> {
        val data = hashMapOf<String, Any>()
        uiModels.forEach {
            data[it.myKey()] = it.getValue()
        }
        return data
    }

}