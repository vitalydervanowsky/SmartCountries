package by.dzrvnsk.currency.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import by.dzrvnsk.currency.database.User
import by.dzrvnsk.currency.database.UserDatabase
import by.dzrvnsk.currency.database.UserRepository
import by.dzrvnsk.currency.databinding.FragmentRegisterBinding
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    private val compositeDisposable = CompositeDisposable()
    private val scopeIO = CoroutineScope(Dispatchers.IO)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnRegister.isEnabled = false

            val emailObservable = Observable.create<Boolean> { emitter ->
                editRegistrationEmail.addTextChangedListener {
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
            compositeDisposable.add(Observable
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
            btnRegister.setOnClickListener {
                register(
                    editRegistrationEmail.text.toString(),
                    editRegistrationPassword.text.toString()
                )
            }
        }
    }

    private fun register(email: String, password: String) = scopeIO.launch {
        if (valid(email, password)) {
            val userDao = UserDatabase.getDatabase(requireContext()).userDao()
            val repository = UserRepository(userDao)
            repository.registerUser(User(email, password))
            activity?.runOnUiThread {
                Toast.makeText(
                    requireContext(),
                    "$email is registered!",
                    Toast.LENGTH_SHORT
                )
                    .show()
                activity?.onBackPressed()
            }
        } else
            activity?.runOnUiThread {
                Toast.makeText(requireContext(), "Fill all fields!", Toast.LENGTH_SHORT).show()
            }
    }

    private fun valid(email: String, password: String): Boolean =
        email.isNotEmpty() && password.isNotEmpty()

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}