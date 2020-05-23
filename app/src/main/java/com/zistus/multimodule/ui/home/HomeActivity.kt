package com.zistus.multimodule.ui.home

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.zistus.core.di.BaseFeatureInjector
import com.zistus.core.ui.BaseNavActivity
import com.zistus.core.util.annotation.AppDeepLink
import com.zistus.core.util.annotation.WebDeepLink
import com.zistus.core.util.ext.intentExtra
import com.zistus.core.util.misc.PermissionHelper
import com.zistus.multimodule.R
import com.zistus.multimodule.di.AppFeatureInjector

@WebDeepLink("home/{param}")
@AppDeepLink("home/{param}")
class HomeActivity : BaseNavActivity<HomeViewModel>() {
    override val featureInjector: BaseFeatureInjector = AppFeatureInjector()

    override val layoutResId: Int = R.layout.activity_home

    override val viewModel: HomeViewModel by viewModel()

    override fun getNavControllerId(): Int = R.id.home_nav_host_fragment

    private val param by intentExtra<Any>("param")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            PermissionHelper.CAMERA_PERMISSION -> {
                if (grantResults.isNotEmpty() && grantResults.first() == PackageManager.PERMISSION_GRANTED) {
                    findNavController(getNavControllerId()).navigate(R.id.newDocFragment)
                } else {
                    Toast.makeText(applicationContext, "Camera permission is needed", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}