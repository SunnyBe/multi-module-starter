package com.zistus.multimodule.ui.home

import androidx.lifecycle.liveData
import com.zistus.core.entity.DataState
import com.zistus.core.ui.viewModel.BaseViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

class HomeViewModel @Inject constructor(): BaseViewModel() {
    val loadValues = liveData<DataState<String>> {
        val value = "This is an emitted shiit"
        delay(2000)
        emit(DataState.Success(value))
    }
}