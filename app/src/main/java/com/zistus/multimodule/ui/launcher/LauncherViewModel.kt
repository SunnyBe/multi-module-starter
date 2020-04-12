package com.zistus.multimodule.ui.launcher

import androidx.lifecycle.liveData
import com.zistus.core.ui.BaseViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

class LauncherViewModel @Inject constructor(): BaseViewModel() {
    val endSplash = liveData<Unit>{
        delay(2000)
        navigateScreen("home")
        emit(Unit)
    }
}