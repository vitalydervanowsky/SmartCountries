package by.dzrvnsk.smartcountries.presentation.fragments.registration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.dzrvnsk.smartcountries.data.usecase.RegisterUserUseCase
import kotlinx.coroutines.launch

class RegistrationViewModel(
    private val registerUserUseCase: RegisterUserUseCase,
) : ViewModel() {

    private val isRegistrationCompletedLiveData = MutableLiveData<Boolean>()
    val isRegistrationCompleted: LiveData<Boolean> = isRegistrationCompletedLiveData

    fun registerUser(login: String, password: String) {
        viewModelScope.launch {
            runCatching {
                registerUserUseCase.registerUser(login, password)
            }.onSuccess {
                isRegistrationCompletedLiveData.value = it
            }.onFailure {
                isRegistrationCompletedLiveData.value = false
            }
        }
    }
}
