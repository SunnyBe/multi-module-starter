package com.zistus.core.util.misc

import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class PermissionHelper(val activity: Activity) {
    companion object {
        const val CAMERA_PERMISSION: Int = 100
    }

    // Function to check and request permission
    fun checkPermission(vararg permission: String, requestCode: Int, granted: ()->Unit) {
        // Checking if permission is not granted
        if (ContextCompat.checkSelfPermission(activity.applicationContext, permission.first()) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(activity, permission, requestCode)
        } else {
            granted()
        }
    }
}