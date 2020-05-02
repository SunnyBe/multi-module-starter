package com.zistus.core.recycler_reuse.factory.models.uiFields

import android.view.View
import com.zistus.core.R
import com.zistus.core.recycler_reuse.factory.interfaces.FactoryEventListener
import com.zistus.core.recycler_reuse.factory.models.UIField
import kotlinx.android.synthetic.main.item_button.view.*

data class ButtonField(
    var title: String = "",
    var isSelected: Boolean = false,
    var selectedPosition: Int = 0

) : UIField(R.layout.item_button) {
    override fun bind(itemView: View, factoryEventListener: FactoryEventListener?) {
        itemView.button_signup.text = title
        itemView.setOnClickListener {
            factoryEventListener?.onItemClicked(this@ButtonField)
        }
    }

    override fun hasValidData(): Boolean {
        return true
    }
}