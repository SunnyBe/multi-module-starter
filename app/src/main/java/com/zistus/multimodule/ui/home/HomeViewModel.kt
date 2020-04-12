package com.zistus.multimodule.ui.home

import com.zistus.core.ui.BaseViewModel
import javax.inject.Inject

class HomeViewModel @Inject constructor(): BaseViewModel() {
    val loadValues = liveData<DataState<String>> {
        val value = "This is an emitted shiit"
        delay(2000)
        emit(DataState.Success(value))
    }
}