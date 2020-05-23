package com.zistus.multimodule.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.zistus.core.ui.BaseFragmentNav
import com.zistus.core.util.misc.ScreenPaths
import com.zistus.core.util.misc.SplitInstallUtil
import com.zistus.multimodule.R
import kotlinx.android.synthetic.main.fragment_home.*
import timber.log.Timber
import javax.inject.Inject

class HomeFragment : BaseFragmentNav<HomeViewModel>() {
    override val layoutResourceId: Int = R.layout.fragment_home

    override val viewModel: HomeViewModel by viewModel()

    @Inject
    lateinit var splitInstallUtil: SplitInstallUtil

    private fun makeNewDoc() {
        findNavController().navigate(R.id.newDocFragment)
    }

    private fun includeModule() {
        val entry = testEntry.text.toString().trim()
        if (entry.isNotBlank() && entry.isNotEmpty()) {
            showProgress("Loading Module")
            val moduleName = resources.getString(R.string.label_feature_authentication)
            // Include auth module
            if (!splitInstallUtil.isModuleInstalled(moduleName = moduleName)) {
                viewModel.includeModule(
                    splitInstallUtil,
                    moduleName,
                    ScreenPaths.AUTH_PATH,
                    entry
                )
            } else {
                viewModel.navigateScreen("auth/${entry}")
            }
        } else {
            navigateFragment(R.id.action_homeFragment_to_subHomeFragment)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
//            includeModule()
            makeNewDoc()
        }
    }

    override fun onResume() {
        super.onResume()
        hideProgress()
    }

}