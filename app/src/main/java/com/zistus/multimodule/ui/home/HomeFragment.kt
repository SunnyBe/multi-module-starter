package com.zistus.multimodule.ui.home

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.zistus.core.entity.DataState
import com.zistus.core.ui.BaseFragmentNav
import com.zistus.multimodule.R
import com.zistus.multimodule.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment: BaseFragmentNav<FragmentHomeBinding, HomeViewModel>() {
    override val layoutResourceId: Int = R.layout.fragment_home

    override val viewModel: HomeViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadValues.observe {
            testLabel.text = when (it) {
                is DataState.Success-> it.data
                is DataState.Error-> it.throwable.message
                is DataState.Loading-> it.data
            }
        }
        testButton?.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_subHomeFragment)
        }
    }
}