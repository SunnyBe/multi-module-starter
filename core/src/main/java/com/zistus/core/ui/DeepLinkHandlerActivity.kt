package com.zistus.core.ui

import android.app.Activity
import android.os.Bundle
import com.airbnb.deeplinkdispatch.BaseDeepLinkDelegate
import com.airbnb.deeplinkdispatch.Parser

class DeepLinkHandlerActivity: Activity() {

    companion object {
        private const val Prefix = "com.zistus" // Basic file path for all file
        // Deep link for app module files
        const val AppDeepLinkModule = "$Prefix.multimodule.utils.AppDeeplinkModuleLoader"
        // Deep link for feature1 module
        const val AuthDeepLinkModule = "$Prefix.feature_authentication.utils.AuthDeeplinkModuleLoader"
    }

    // Load the deep link loader for a specified string module.
    private fun String.loadDeepLinkLoader(): Parser? {
        return try {
            Class.forName(this).newInstance() as? Parser
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val loaders = listOfNotNull(
            AppDeepLinkModule.loadDeepLinkLoader(),
            AuthDeepLinkModule.loadDeepLinkLoader()
        )
        // DeepLinkDelegate for this list of loaders(AppDeepLinkModule, & others)
        // are generated at compile-time.
        val deepLinkDelegate = BaseDeepLinkDelegate(loaders)

        // Delegate the deep link handling to DeepLinkDispatch.
        // It will start the correct Activity based on the incoming Intent URI
        deepLinkDelegate.dispatchFrom(this)
        // Finish this Activity since the correct one has been just started
        finish()
    }
}