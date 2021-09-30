package by.dzrvnsk.currency.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import by.dzrvnsk.currency.R
import by.dzrvnsk.currency.databinding.FragmentLoginBinding
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val compositeDisposable = CompositeDisposable()
    private val access = Pair("login", "123")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            val email = editLoginEmail.text.toString()
            val password = editLoginPassword.text.toString()
            btnLogin.isEnabled = email.isNotEmpty() || password.isNotEmpty()

            btnLogin.setOnClickListener {
                login(editLoginEmail.text.toString(), editLoginPassword.text.toString())
            }

            btnRegister.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.container, RegisterFragment())
                    .commit()
            }

            val loginObservable = Observable.create<Boolean> { emitter ->
                editLoginEmail.addTextChangedListener {
                    if (!emitter.isDisposed)
                        emitter.onNext(it.toString() == access.first)
                }
            }

            val passwordObservable = Observable.create<Boolean> { emitter ->
                editLoginPassword.addTextChangedListener {
                    if (!emitter.isDisposed)
                        emitter.onNext(it.toString() == access.second)
                }
            }

            compositeDisposable.add(Observable
                .combineLatest(
                    loginObservable,
                    passwordObservable,
                    { loginIsCorrect, passwordIsCorrect ->
                        loginIsCorrect && passwordIsCorrect
                    }
                )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    btnLogin.isEnabled = it
                }
            )
        }
    }

    private fun login(email: String, password: String) {
        if (valid(email, password)) {
            Toast.makeText(requireContext(), email, Toast.LENGTH_SHORT).show()
            openNextFragment()
        } else {
            showError()
        }
    }

    private fun showError() {
        binding.tvLoginEmail.error = getString(R.string.email_password_error)
        binding.tvLoginPassword.error = getString(R.string.email_password_error)
    }

    private fun openNextFragment() {
        parentFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.container, NextFragment())
            .commit()
    }

    private fun valid(email: String, password: String): Boolean =
        email.isNotEmpty() && password.isNotEmpty()

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}