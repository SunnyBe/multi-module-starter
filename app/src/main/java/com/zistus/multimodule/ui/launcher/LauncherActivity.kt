package com.zistus.multimodule.ui.launcher

import android.os.Bundle
import com.zistus.core.di.BaseFeatureInjector
import com.zistus.core.ui.BaseActivity
import com.zistus.multimodule.databinding.ActivityLauncherBinding
import com.zistus.multimodule.di.AppFeatureInjector
import javax.inject.Inject

class LauncherActivity : BaseActivity<LauncherViewModel>() {
    override val featureInjector: BaseFeatureInjector = AppFeatureInjector()

    @Inject
    lateinit var testString: String

    private lateinit var binding: ActivityLauncherBinding

    override val viewModel: LauncherViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLauncherBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.endSplash.observe { finish() }
    }
}