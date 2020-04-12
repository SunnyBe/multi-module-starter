package com.zistus.multimodule.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zistus.core.entity.DataState
import com.zistus.core.ui.BaseFragment
import com.zistus.multimodule.R
import com.zistus.multimodule.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment: BaseFragment<HomeViewModel>() {
    override val layoutResourceId: Int = R.layout.fragment_home

    override val viewModel: HomeViewModel by viewModel()

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadValues.observe {
            testLabel.text = when (it) {
                is DataState.Success-> it.data
                is DataState.Error-> it.throwable.message
                is DataState.Loading-> it.data
            }
        }
    }
}