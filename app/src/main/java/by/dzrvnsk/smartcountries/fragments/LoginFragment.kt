package by.dzrvnsk.smartcountries.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.dzrvnsk.smartcountries.LAST_LOGIN
import by.dzrvnsk.smartcountries.NAV_OPTIONS_ANIMATION_SLIDE_IN_BOTTOM
import by.dzrvnsk.smartcountries.R
import by.dzrvnsk.smartcountries.database.userDatabase.UserRepository
import by.dzrvnsk.smartcountries.databinding.FragmentLoginBinding
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val sharedPrefs: SharedPreferences by lazy {
        requireActivity().getSharedPreferences(LAST_LOGIN, Context.MODE_PRIVATE)
    }
    private val userRepository: UserRepository by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initListeners()
    }

    private fun initViews() {
        enableBtnLogin()
    }

    private fun initListeners() = with(binding) {
        btnLogin.setOnClickListener {
            login(editLoginLogin.text.toString(), editLoginPassword.text.toString())
        }
        btnRegister.setOnClickListener {
            showRegisterFragment()
        }
    }

    private fun enableBtnLogin() = with(binding) {
        val loginObservable = Observable.create<Boolean> { emitter ->
            editLoginLogin.addTextChangedListener {
                if (!emitter.isDisposed)
                    emitter.onNext(it.toString().isNotEmpty())
            }
        }
        val passwordObservable = Observable.create<Boolean> { emitter ->
            editLoginPassword.addTextChangedListener {
                if (!emitter.isDisposed)
                    emitter.onNext(it.toString().isNotEmpty())
            }
        }
        CompositeDisposable().add(
            Observable
                .combineLatest(
                    loginObservable,
                    passwordObservable,
                    { loginIsNotEmpty, passwordIsNotEmpty ->
                        loginIsNotEmpty && passwordIsNotEmpty
                    }
                )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    btnLogin.isEnabled = it
                }
        )
    }

    private fun showRegisterFragment() {
        findNavController().navigate(
            R.id.action_loginFragment_to_registerFragment,
            bundleOf(),
            NAV_OPTIONS_ANIMATION_SLIDE_IN_BOTTOM
        )
    }

    private fun login(login: String, password: String) = CoroutineScope(Dispatchers.IO).launch {
        val user = userRepository.loginUser(login, password)
        activity?.runOnUiThread {
            if (user != null) {
                saveToSharedPrefs(login)
                showHelloFragment()
            } else {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.email_password_error),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun saveToSharedPrefs(login: String) {
        sharedPrefs.edit()
            .putString(LAST_LOGIN, login)
            .apply()
    }

    private fun showHelloFragment() {
        findNavController().navigate(R.id.action_loginFragment_to_helloFragment)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
