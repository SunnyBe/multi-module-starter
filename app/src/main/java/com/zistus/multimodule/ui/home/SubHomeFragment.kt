package com.zistus.multimodule.ui.home

import android.os.Bundle
import android.view.View
import com.zistus.core.ui.BaseFragmentNav
import com.zistus.multimodule.R
import com.zistus.multimodule.databinding.FragmentSubhomeBinding

class SubHomeFragment : BaseFragmentNav<HomeViewModel>() {
    override val layoutResourceId: Int = R.layout.fragment_subhome
    override val viewModel: HomeViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}