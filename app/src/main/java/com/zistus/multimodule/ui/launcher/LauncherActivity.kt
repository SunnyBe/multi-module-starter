package com.zistus.multimodule.ui.launcher

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.zistus.core.di.BaseFeatureInjector
import com.zistus.core.ui.BaseActivity
import com.zistus.multimodule.R
import com.zistus.multimodule.databinding.ActivityLauncherBinding
import com.zistus.multimodule.di.AppFeatureInjector
import javax.inject.Inject

class LauncherActivity : BaseActivity<ActivityLauncherBinding, LauncherViewModel>() {
    override val featureInjector: BaseFeatureInjector = AppFeatureInjector()

    @Inject
    lateinit var testString: String

    override val layoutResId: Int = R.layout.activity_launcher

    override val viewModel: LauncherViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(applicationContext, "Entry: $testString", Toast.LENGTH_LONG).show()
        viewModel.endSplash.observe(this, Observer {
            finish()
        })
    }
}