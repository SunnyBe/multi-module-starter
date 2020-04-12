package com.zistus.multimodule.ui.launcher

import androidx.lifecycle.liveData
import com.zistus.core.ui.viewModel.BaseViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

class LauncherViewModel @Inject constructor(): BaseViewModel() {

    val endSplash = liveData{
        val param = "Param to pass."
        delay(2000)
        navigateScreen("home/${param}")
        emit(Unit)
    }
}