package by.dzrvnsk.smartcountries.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.dzrvnsk.smartcountries.R
import by.dzrvnsk.smartcountries.database.userDatabase.User
import by.dzrvnsk.smartcountries.database.userDatabase.UserRepository
import by.dzrvnsk.smartcountries.databinding.FragmentRegisterBinding
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private val userRepository: UserRepository by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initListeners()
    }

    private fun initViews() {
        enableBtnRegister()
    }

    private fun enableBtnRegister() = with(binding) {
        val emailObservable = Observable.create<Boolean> { emitter ->
            editRegistrationLogin.addTextChangedListener {
                if (!emitter.isDisposed)
                    emitter.onNext(it.toString().isNotEmpty())
            }
        }
        val passwordIsNotEmptyObservable = Observable.create<Boolean> { emitter ->
            editRegistrationPassword.addTextChangedListener {
                if (!emitter.isDisposed)
                    emitter.onNext(it.toString().isNotEmpty())
            }
        }
        CompositeDisposable().add(
            Observable
                .combineLatest(
                    emailObservable,
                    passwordIsNotEmptyObservable,
                    { emailIsNotEmpty, passwordIsNotEmpty ->
                        emailIsNotEmpty && passwordIsNotEmpty
                    }
                )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    btnRegister.isEnabled = it
                }
        )
    }

    private fun initListeners() = with(binding) {
        btnRegister.setOnClickListener {
            registerUser(
                editRegistrationLogin.text.toString(),
                editRegistrationPassword.text.toString()
            )
        }
    }

    private fun registerUser(login: String, password: String) =
        CoroutineScope(Dispatchers.IO).launch {
            userRepository.registerUser(User(login, password))
            activity?.runOnUiThread {
                val toastText = login + getString(R.string.registration_success)
                Toast.makeText(requireContext(), toastText, Toast.LENGTH_SHORT).show()
                findNavController().popBackStack()
            }
        }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
