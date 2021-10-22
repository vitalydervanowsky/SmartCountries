package by.dzrvnsk.smartcountries.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import by.dzrvnsk.smartcountries.R
import by.dzrvnsk.smartcountries.database.UserRepository
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

    private val compositeDisposable = CompositeDisposable()
    private val scopeIO = CoroutineScope(Dispatchers.IO)
    private val sharedPrefs: SharedPreferences by lazy {
        requireActivity().getSharedPreferences("LAST_LOGIN", Context.MODE_PRIVATE)
    }
    private val userRepository: UserRepository by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.editLoginLogin.setText(sharedPrefs.getString("LAST_USER_NAME", ""))

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnLogin.isEnabled = false

            btnLogin.setOnClickListener {
                login(editLoginLogin.text.toString(), editLoginPassword.text.toString())
            }
            btnRegister.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .setCustomAnimations(
                        R.anim.slide_in_bottom,
                        R.anim.fade_out,
                        R.anim.fade_in,
                        R.anim.slide_out_bottom
                    )
                    .addToBackStack(null)
                    .replace(R.id.container, RegisterFragment())
                    .commit()
            }
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
            compositeDisposable.add(Observable
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
    }

    private fun login(login: String, password: String) = scopeIO.launch {
        val user = userRepository.loginUser(login, password)
        activity?.runOnUiThread {
            if (user != null) {
                sharedPrefs.edit()
                    .putString("LAST_USER_NAME", login)
                    .apply()
                parentFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.container, ListFragment())
                    .commit()
            } else {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.email_password_error),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}