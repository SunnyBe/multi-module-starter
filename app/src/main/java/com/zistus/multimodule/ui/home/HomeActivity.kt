package com.zistus.multimodule.ui.home

import android.os.Bundle
import com.zistus.core.di.BaseFeatureInjector
import com.zistus.core.ui.BaseActivity
import com.zistus.core.util.annotation.AppDeepLink
import com.zistus.core.util.annotation.WebDeepLink
import com.zistus.multimodule.R
import com.zistus.multimodule.databinding.ActivityHomeBinding
import com.zistus.multimodule.di.AppFeatureInjector
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

@WebDeepLink("home/{param}")
@AppDeepLink("home/{param}")
class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>() {

    override val layoutResId: Int = R.layout.activity_home

    override val viewModel: HomeViewModel by viewModel()

    override val featureInjector: BaseFeatureInjector = AppFeatureInjector()

    @Inject
    lateinit var testString: String

    //    private val param by intentExtra<String>()
    private val param = intent.extras?.getString("param") ?: ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        testLabel?.text = "The Current page is $param"
    }
}