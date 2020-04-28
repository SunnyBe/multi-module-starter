package com.zistus.core.recycler_reuse.factory.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.zistus.core.recycler_reuse.factory.interfaces.FactoryEventListener
import com.zistus.core.recycler_reuse.factory.models.UIField

class UIFactoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(uiModel: UIField, eventListener: FactoryEventListener?) {
        uiModel.bind(itemView, eventListener)
    }
}