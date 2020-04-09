package com.zistus.multimodule.ui.launcher

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import com.zistus.core.MyApplication
import com.zistus.core.util.misc.Urls
import com.zistus.multimodule.R
import com.zistus.multimodule.di.AppFeatureInjector
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class LauncherActivity : DaggerAppCompatActivity() {
    private val featureInjector: AppFeatureInjector = AppFeatureInjector()
    @Inject
    lateinit var testString: String

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).addModuleInjector(featureInjector)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
        Toast.makeText(applicationContext, "Entry: $testString", Toast.LENGTH_LONG).show()

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("${Urls.AppScheme}home"))
        startActivity(intent)
    }
}