package by.dzrvnsk.smartcountries.presentation.fragments.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import by.dzrvnsk.smartcountries.NAV_OPTIONS_ANIMATION_SLIDE_IN_BOTTOM
import by.dzrvnsk.smartcountries.R
import by.dzrvnsk.smartcountries.presentation.model.BaseFragment
import com.google.android.material.textfield.TextInputEditText
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.koin.android.ext.android.inject

class LoginFragment : BaseFragment() {

    private var loginEditText: TextInputEditText? = null
    private var passwordEditText: TextInputEditText? = null
    private var loginButton: Button? = null

    private val viewModel: LoginViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
        initViewModel()
    }

    private fun initViews(view: View) {
        view.apply {
            loginEditText = findViewById(R.id.loginEditText)
            passwordEditText = findViewById(R.id.passwordEditText)
            loginButton = findViewById<Button?>(R.id.loginButton).apply {
                setOnClickListener {
                    viewModel.loginUser(
                        loginEditText?.text.toString(),
                        passwordEditText?.text.toString()
                    )
                }
            }
            findViewById<Button?>(R.id.registerButton).apply {
                setOnClickListener {
                    showRegisterFragment()
                }
            }
        }
        enableBtnLogin()
    }

    private fun enableBtnLogin() {
        val loginObservable = Observable.create<Boolean> { emitter ->
            loginEditText?.addTextChangedListener {
                if (!emitter.isDisposed) {
                    emitter.onNext(it.toString().isNotEmpty())
                }
            }
        }
        val passwordObservable = Observable.create<Boolean> { emitter ->
            passwordEditText?.addTextChangedListener {
                if (!emitter.isDisposed) {
                    emitter.onNext(it.toString().isNotEmpty())
                }
            }
        }
        CompositeDisposable().add(
            Observable
                .combineLatest(
                    loginObservable,
                    passwordObservable
                ) { loginIsNotEmpty, passwordIsNotEmpty ->
                    loginIsNotEmpty && passwordIsNotEmpty
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    loginButton?.isEnabled = it
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

    private fun initViewModel() {
        viewModel.user.observe(viewLifecycleOwner) { user ->
            if (user != null) {
                saveToSharedPrefs(
                    loginEditText?.text.toString()
                )
                showHelloFragment()
            } else {
                showToastInfo(getString(R.string.email_password_error))
            }
        }
    }

    private fun saveToSharedPrefs(login: String) {
        sharedPrefs.edit()
            .putString(USER_PREFS, login)
            .apply()
    }

    private fun showHelloFragment() {
        findNavController().navigate(R.id.action_loginFragment_to_helloFragment)
    }
}
