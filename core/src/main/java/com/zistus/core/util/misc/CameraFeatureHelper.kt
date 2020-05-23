package com.zistus.core.util.misc

import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Camera
import android.net.Uri
import android.os.Environment
import android.widget.FrameLayout
import com.zistus.core.ui.camera.CameraPreview
import timber.log.Timber
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class CameraFeatureHelper(val context: Context) {
    val MEDIA_TYPE_IMAGE = 1
    val MEDIA_TYPE_VIDEO = 2

    val mPicture = Camera.PictureCallback { data, _ ->
        val pictureFile: File = getOutputMediaFile(MEDIA_TYPE_IMAGE) ?: run {
            Timber.d("Error creating media file, check storage permissions")
            return@PictureCallback
        }
        try {
            val fos = FileOutputStream(pictureFile)
            fos.write(data)
            fos.close()
        } catch (e: FileNotFoundException) {
            Timber.d("File not found: ${e.message}")
        } catch (e: IOException) {
            Timber.d("Error accessing file: ${e.message}")
        }
    }

    /** Check if this device has a camera */
    fun mobileHasCamera(context: Context): Boolean {
        return context.packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)
    }

    fun getCameraInstance(): Camera? {
        return try {
            Camera.open() // attempt to get a Camera instance
        } catch (e: Exception) {
            // Camera is not available (in use or does not exist)
            Timber.e(e)
            null // returns null if camera is unavailable
        }
    }

    fun createPreview(camera: Camera?): CameraPreview? {
        return camera?.let {
            // Create our Preview view
            CameraPreview(context = context, mCamera = it)
        }
    }

    fun setPreview(cameraPreview: CameraPreview?, view: FrameLayout) {
        // Set the Preview view as the content of our activity.
        cameraPreview?.also {
            view.addView(it)
        }
    }


    /** Create a file Uri for saving an image or video */
    private fun getOutputMediaFileUri(type: Int): Uri {
        return Uri.fromFile(getOutputMediaFile(type))
    }

    /** Create a File for saving an image or video */
    private fun getOutputMediaFile(type: Int): File? {
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.

        val mediaStorageDir = File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),
            "DigiDoc"
        )
        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.

        // Create the storage directory if it does not exist
        mediaStorageDir.apply {
            if (!exists()) {
                if (!mkdirs()) {
                    Timber.d("failed to create directory")
                    return null
                }
            }
        }

        // Create a media file name
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        return when (type) {
            MEDIA_TYPE_IMAGE -> {
                File("${mediaStorageDir.path}${File.separator}IMG_$timeStamp.jpg")
            }
            MEDIA_TYPE_VIDEO -> {
                File("${mediaStorageDir.path}${File.separator}VID_$timeStamp.mp4")
            }
            else -> null
        }

    }

    fun takePicture(camera: Camera?) {
        // get an image from the camera
        camera?.takePicture(null, null, mPicture)
    }
}