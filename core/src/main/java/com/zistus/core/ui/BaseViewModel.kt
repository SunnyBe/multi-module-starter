package com.zistus.core.ui

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zistus.core.util.misc.Urls

/**
 * Basic functionality that all modules can perform. For example navigation through screens
 */
abstract class BaseViewModel: ViewModel() {
    private val _intentNavigation = MutableLiveData<Intent>()
    val intentNavigation: LiveData<Intent> get() = _intentNavigation

    fun navigate(intent: Intent) {
        _intentNavigation.value = intent
    }

    // Navigate to the next activity via Intent using url
    fun navigate(url: String) {
        _intentNavigation.value = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    }

    // Append screen path and Navigate using deep-link
    fun navigateScreen(screenPath: String) {
        navigate("${Urls.AppScheme}$screenPath")
    }
}