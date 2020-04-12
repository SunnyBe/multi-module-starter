package com.zistus.multimodule.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.zistus.core.ui.BaseFragmentNav
import com.zistus.multimodule.R
import com.zistus.multimodule.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*
import timber.log.Timber

class HomeFragment : BaseFragmentNav<FragmentHomeBinding, HomeViewModel>() {
    override val layoutResourceId: Int = R.layout.fragment_home

    override val viewModel: HomeViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.errorState.observe{
            Timber.e(it)
            Toast.makeText(context, "${it.message}", Toast.LENGTH_LONG).show()
        }
        viewModel.loadValues.observe { testLabel.text = it?.name ?: "" }
        testButton?.setOnClickListener {
            navigateFragment(R.id.action_homeFragment_to_subHomeFragment)
        }
    }
}