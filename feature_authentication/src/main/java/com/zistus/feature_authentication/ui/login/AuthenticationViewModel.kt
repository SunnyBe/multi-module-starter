package com.zistus.feature_authentication.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import android.util.Patterns
import com.zistus.core.recycler_reuse.factory.adapter.UIFactoryAdapter
import com.zistus.core.recycler_reuse.factory.models.UIField
import com.zistus.core.recycler_reuse.factory.models.uiFields.NameField
import com.zistus.core.recycler_reuse.factory.pageFactory.AuthFactory
import com.zistus.core.ui.viewModel.BaseViewModel
import com.zistus.feature_authentication.R
import com.zistus.feature_authentication.data.LoginResult
import com.zistus.feature_authentication.domain.LoginFormState
import com.zistus.feature_authentication.ui.logout.LoginRepository
import com.zistus.feature_authentication.ui.logout.Result
import javax.inject.Inject

class AuthenticationViewModel @Inject constructor(private val loginRepository: LoginRepository) : BaseViewModel() {

    val uiField = MutableLiveData<MutableList<UIField>>()

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    fun login(username: String, password: String) {
        // can be launched in a separate asynchronous job
        val result = loginRepository.login(username, password)

        if (result is Result.Success) {
            _loginResult.value =
                LoginResult(
                    success = LoggedInUserView(
                        displayName = result.data.displayName
                    )
                )
        } else {
            _loginResult.value =
                LoginResult(error = R.string.login_failed)
        }
    }

    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
            _loginForm.value =
                LoginFormState(
                    usernameError = R.string.invalid_username
                )
        } else if (!isPasswordValid(password)) {
            _loginForm.value =
                LoginFormState(
                    passwordError = R.string.invalid_password
                )
        } else {
            _loginForm.value =
                LoginFormState(
                    isDataValid = true
                )
        }
    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }

    fun createForm() {
        uiField.postValue(AuthFactory.signUpPage())
    }

    fun authenticateUser(factoryItemsAdapter: UIFactoryAdapter): String {
        val nameField = factoryItemsAdapter.fieldWithKey(AuthFactory.Keys.F_NAME) as NameField
        val lastField = factoryItemsAdapter.fieldWithKey(AuthFactory.Keys.Phone) as NameField
        return if (nameField.hasValidData())  nameField.text +"-:-"+lastField.text else nameField.errorMessage
    }
}
