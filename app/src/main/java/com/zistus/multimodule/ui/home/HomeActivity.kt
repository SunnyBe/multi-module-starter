package com.zistus.multimodule.ui.home

import android.os.Bundle
import com.zistus.core.di.BaseFeatureInjector
import com.zistus.core.ui.BaseActivityNav
import com.zistus.core.util.annotation.AppDeepLink
import com.zistus.core.util.annotation.WebDeepLink
import com.zistus.core.util.ext.intentExtra
import com.zistus.multimodule.R
import com.zistus.multimodule.di.AppFeatureInjector

@WebDeepLink("home/{param}")
@AppDeepLink("home/{param}")
class HomeActivity : BaseActivityNav<HomeViewModel>() {

    override val layoutResId: Int = R.layout.activity_home

    override val viewModel: HomeViewModel by viewModel()

    override val featureInjector: BaseFeatureInjector = AppFeatureInjector()

    override fun getNavControllerId(): Int = R.id.nav_controller_view_tag

    private val param by intentExtra<Any>("param")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}