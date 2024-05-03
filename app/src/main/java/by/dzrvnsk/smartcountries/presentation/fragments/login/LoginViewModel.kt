package by.dzrvnsk.smartcountries.presentation.fragments.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.dzrvnsk.smartcountries.data.usecase.LoginUserUseCase
import by.dzrvnsk.smartcountries.domain.UserDomain
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUserUseCase: LoginUserUseCase,
) : ViewModel() {

    private val userLiveData = MutableLiveData<UserDomain?>()
    val user: LiveData<UserDomain?> = userLiveData

    fun loginUser(login: String, password: String) {
        viewModelScope.launch {
            runCatching {
                loginUserUseCase.loginUser(login, password)
            }.onSuccess {
                userLiveData.value = it
            }.onFailure {
                userLiveData.value = null
            }
        }
    }
}
