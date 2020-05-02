package com.zistus.feature_authentication.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.zistus.core.recycler_reuse.PagesFragment
import com.zistus.core.recycler_reuse.factory.interfaces.FactoryEventListener
import com.zistus.core.recycler_reuse.factory.models.UIField
import com.zistus.core.recycler_reuse.factory.models.uiFields.ButtonField
import com.zistus.feature_authentication.R
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class AuthenticationFragment: PagesFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    val authViewModel: AuthenticationViewModel by viewModels<AuthenticationViewModel> { viewModelFactory }
//    lateinit var authViewModel: AuthenticationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.auth_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        factoryRecycler = view.findViewById(R.id.factoryRecycler)
        super.onViewCreated(view, savedInstanceState)
//        authViewModel =  ViewModelProviders.of(this).get(AuthenticationViewModel::class.java)
        authViewModel.createForm()
        authViewModel.uiField.observe { update(it) }

        setAdapterEvent(object : FactoryEventListener{
            override fun onItemClicked(uiField: UIField, params: Any) {
                when(uiField){
                    is ButtonField-> {
                        val entry = authViewModel.authenticateUser(factoryItemsAdapter)
                        Toast.makeText(context, "Entry: $entry", Toast.LENGTH_LONG).show()
                    }
                }
            }

        })
    }

}