package com.zistus.multimodule.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import com.zistus.core.ui.BaseFragmentNav
import com.zistus.core.util.misc.SplitInstallUtil
import com.zistus.multimodule.R
import com.zistus.multimodule.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*
import timber.log.Timber
import javax.inject.Inject

class HomeFragment : BaseFragmentNav<FragmentHomeBinding, HomeViewModel>() {
    override val layoutResourceId: Int = R.layout.fragment_home

    override val viewModel: HomeViewModel by viewModel()

    @Inject
    lateinit var splitInstallUtil: SplitInstallUtil

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showProgress()
        viewModel.errorState.observe {
            hideProgress()
            Timber.e(it)
            Toast.makeText(context, "${it.message}", Toast.LENGTH_LONG).show()
        }
        viewModel.loadValues.observe {
            hideProgress()
            testLabel.text = it?.name ?: ""
        }

        testButton?.setOnClickListener {
            val entry = fragmentBinding.testEntry.text.toString().trim()
            if (entry.isNotBlank() && entry.isNotEmpty()) {
                // Include another module for this condition with the entry from edit text
                includeOnRequestModule(R.string.label_feature_authentication, entry)
            } else {
                navigateFragment(R.id.action_homeFragment_to_subHomeFragment)
            }
        }
    }

    private fun includeOnRequestModule(@StringRes moduleName: Int, entry: String) {
        splitInstallUtil.installModule(resources.getString(moduleName)) {
            it?.let {
                Toast.makeText(
                    context,
                    it.message ?: "Failed to load module",
                    Toast.LENGTH_LONG
                ).show()
            } ?: kotlin.run {
                viewModel.navigateScreen("auth/${entry}")
                Toast.makeText(
                    context,
                    "Successfully loaded module",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}