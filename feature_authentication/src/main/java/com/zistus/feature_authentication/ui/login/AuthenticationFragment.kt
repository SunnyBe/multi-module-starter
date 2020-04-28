package com.zistus.feature_authentication.ui.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.zistus.core.recycler_reuse.PagesFragment
import com.zistus.core.recycler_reuse.factory.interfaces.FactoryEventsAdapter
import com.zistus.core.recycler_reuse.factory.models.UIField

class AuthenticationFragment: PagesFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapterEvent(object : FactoryEventsAdapter() {
            override fun onItemClicked(uiField: UIField, params: Any) {
                super.onItemClicked(uiField, params)
                /*if (uiField is PhotoUploadField) {
                    // Handle the image upload.
                } else if (uiField is ButtonField) {
                    if (factoryItemsAdapter.isFormValid()) {
                        authVM.registerUser(factoryItemsAdapter)
                    } else {
                        context?.let {
                            Toast.makeText(it, factoryItemsAdapter.formWarning(), Toast.LENGTH_LONG).show()
                        }
                    }
                }*/
            }
        })
    }
}