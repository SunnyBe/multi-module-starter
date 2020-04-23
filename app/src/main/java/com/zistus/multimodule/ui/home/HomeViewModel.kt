package com.zistus.multimodule.ui.home

import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.zistus.core.entity.DataState
import com.zistus.core.ui.viewModel.BaseViewModel
import com.zistus.core.util.misc.ErrorManager
import com.zistus.core.util.misc.ErrorType
import com.zistus.multimodule.domain.test.TestRepository
import kotlinx.coroutines.async
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val testRepository: TestRepository) :
    BaseViewModel() {
    val loadValues = liveData {
        showProgress("Please Wait")
        val value = fetchUsers().await()?.first()
        emit(value = value).also { removeProgress() }
    }

    private fun fetchUsers() = viewModelScope.async{
        when (val data = testRepository.fetchUsers()) {
            is DataState.Success -> {
                data.data
            }
            is DataState.Loading -> {
                data.data
            }
            is DataState.Error -> {
                renderError(ErrorManager(ErrorType.SYSTEM, data.throwable.message, data.throwable))
                data.data
            }
        }
    }
}