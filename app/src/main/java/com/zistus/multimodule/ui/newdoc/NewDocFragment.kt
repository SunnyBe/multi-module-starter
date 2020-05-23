package com.zistus.multimodule.ui.newdoc

import android.Manifest
import android.app.Activity
import android.content.Context
import android.hardware.Camera
import android.os.Bundle
import android.view.View
import com.zistus.core.ui.BaseFragmentNav
import com.zistus.core.ui.camera.CameraPreview
import com.zistus.core.util.misc.PermissionHelper
import com.zistus.core.util.misc.CameraFeatureHelper
import com.zistus.multimodule.R
import kotlinx.android.synthetic.main.fragment_new_doc.*

class NewDocFragment : BaseFragmentNav<NewDocViewModel>() {
    override val layoutResourceId: Int = R.layout.fragment_new_doc
    override val viewModel: NewDocViewModel by viewModel()
    lateinit var cameraFeature: CameraFeatureHelper
    private var camera: Camera? = null
    private var mPreview: CameraPreview? = null
    private lateinit var permissionHelper: PermissionHelper

    private fun startCamera(context: Context?) {
        context?.run {
            if (cameraFeature.mobileHasCamera(this)) {
                checkCameraPermission(activity)
            } else {
                // No camera
                activity?.finish()
            }
        }
    }

    private fun checkCameraPermission(activity: Activity?) {
        activity?.let {
            if (this::permissionHelper.isInitialized) {
                permissionHelper.checkPermission(
                    permission = *arrayOf(Manifest.permission.CAMERA),
                    requestCode = PermissionHelper.CAMERA_PERMISSION
                ) {
                    camera = cameraFeature.getCameraInstance()
                    mPreview = cameraFeature.createPreview(camera)
                    cameraFeature.setPreview(mPreview, cameraPreview)
                }
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        permissionHelper = PermissionHelper(activity!!)
        context?.let {
            cameraFeature = CameraFeatureHelper(it)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startCamera(context)
        buttonCapture.setOnClickListener {
            cameraFeature.takePicture(camera)
        }
    }

    override fun onPause() {
        super.onPause()
        releaseCamera()
    }

    private fun releaseCamera() {
        camera?.release() // release the camera for other applications
        camera = null
    }
}