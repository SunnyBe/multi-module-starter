package com.zistus.core.recycler_reuse.factory.models.uiFields

import android.text.InputFilter
import android.text.InputType
import android.view.View
import com.zistus.core.R
import com.zistus.core.recycler_reuse.factory.interfaces.FactoryEventListener
import com.zistus.core.recycler_reuse.factory.interfaces.TextWatcherAdapter
import com.zistus.core.recycler_reuse.factory.models.UIField
import kotlinx.android.synthetic.main.item_name.view.*

class NameField(
    var hint: String = "",
    var text: String = "",
    var inputType: Int = InputType.TYPE_CLASS_TEXT,
    var maxLength: Int = -1,
    var required: Boolean = false,
    var validation: ((text: String) -> Boolean)? = null
) : UIField(R.layout.item_name) {

    override fun bind(itemView: View, factoryEventListener: FactoryEventListener?) {
        itemView.fieldName.setText(this.text)
        itemView.fieldName.inputType = inputType
        itemView.textInputContainer.hint = hint
        if (maxLength != -1) {
            itemView.fieldName.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxLength))
        }

        itemView.fieldName.addTextChangedListener(object : TextWatcherAdapter() {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                super.onTextChanged(s, start, before, count)
                s?.let {
                    text = s.toString()
                }
            }
        })
    }

    override fun hasValidData(): Boolean {
        return if (required) validation?.invoke(text) ?: kotlin.run { true } else true
    }

    override fun getValue(): Any {
        return text
    }
}