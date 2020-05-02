package com.zistus.feature_authentication.ui

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.lifecycle.Observer
import com.google.android.play.core.splitcompat.SplitCompat
import com.zistus.core.di.BaseFeatureInjector
import com.zistus.core.ui.BaseActivity
import com.zistus.core.ui.BaseNavActivity
import com.zistus.core.util.annotation.AppDeepLink
import com.zistus.core.util.annotation.WebDeepLink
import com.zistus.core.util.ext.intentExtra
import com.zistus.feature_authentication.R
import com.zistus.feature_authentication.databinding.ActivityAuthenticationBinding
import com.zistus.feature_authentication.di.AuthFeatureInjector
import com.zistus.feature_authentication.ui.login.AuthenticationViewModel
import com.zistus.feature_authentication.ui.login.LoggedInUserView

@WebDeepLink("auth/{param}")
@AppDeepLink("auth/{param}")
//class AuthenticationActivity :
//    BaseActivity<ActivityAuthenticationBinding, AuthenticationViewModel>() {
class AuthenticationActivity :
    BaseNavActivity<AuthenticationViewModel>() {

    override val featureInjector: BaseFeatureInjector = AuthFeatureInjector()
    override val layoutResId: Int = R.layout.activity_auth
    override val viewModel: AuthenticationViewModel by viewModel()

    override fun getNavControllerId(): Int = R.id.auth_nav_host_fragment

    private val param by intentExtra<Any>("param")

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        // Emulates installation of on demand modules using SplitCompat.
        SplitCompat.installActivity(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
