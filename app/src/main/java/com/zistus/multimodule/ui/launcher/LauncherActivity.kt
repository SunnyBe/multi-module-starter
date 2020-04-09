package com.zistus.multimodule.ui.launcher

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import com.zistus.core.MyApplication
import com.zistus.core.di.BaseFeatureInjector
import com.zistus.core.ui.BaseActivity
import com.zistus.core.util.misc.Urls
import com.zistus.multimodule.R
import com.zistus.multimodule.databinding.ActivityLauncherBindingImpl
import com.zistus.multimodule.di.AppFeatureInjector
import javax.inject.Inject

class LauncherActivity : BaseActivity<ActivityLauncherBindingImpl, LauncherViewModel>() {
    override val featureInjector: BaseFeatureInjector = AppFeatureInjector()

    @Inject
    lateinit var testString: String

    override val layoutResId: Int = R.layout.activity_launcher

    override val viewModel: LauncherViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
//        (application as MyApplication).addModuleInjector(featureInjector)
        super.onCreate(savedInstanceState)
        Toast.makeText(applicationContext, "Entry: $testString", Toast.LENGTH_LONG).show()

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("${Urls.AppScheme}home"))
        startActivity(intent).also { finish() }
    }
}