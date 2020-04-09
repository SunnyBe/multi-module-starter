package com.zistus.multimodule.ui.home

import android.os.Bundle
import com.zistus.core.util.annotation.AppDeepLink
import com.zistus.core.util.annotation.WebDeepLink
import com.zistus.multimodule.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@WebDeepLink("home")
@AppDeepLink("home")
class HomeActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var testString: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testLabel?.text = "Entry: $testString"
    }
}