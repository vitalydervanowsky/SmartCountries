package by.dzrvnsk.smartcountries.presentation.fragments.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import by.dzrvnsk.smartcountries.R
import by.dzrvnsk.smartcountries.presentation.model.BaseFragment
import com.google.android.material.textfield.TextInputEditText
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.koin.android.ext.android.inject

class RegistrationFragment : BaseFragment() {

    private var loginEditText: TextInputEditText? = null
    private var passwordEditText: TextInputEditText? = null
    private var button: Button? = null

    private val viewModel: RegistrationViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {
            loginEditText = findViewById(R.id.loginEditText)
            passwordEditText = findViewById(R.id.passwordEditText)
            button = findViewById<Button?>(R.id.button).apply {
                setOnClickListener {
                    viewModel.registerUser(
                        loginEditText?.text.toString(),
                        passwordEditText?.text.toString()
                    )
                }
            }
        }
        enableBtnRegister()
        initViewModel()
    }

    private fun enableBtnRegister() {
        val emailObservable = Observable.create<Boolean> { emitter ->
            loginEditText?.addTextChangedListener {
                if (!emitter.isDisposed)
                    emitter.onNext(it.toString().isNotEmpty())
            }
        }
        val passwordIsNotEmptyObservable = Observable.create<Boolean> { emitter ->
            passwordEditText?.addTextChangedListener {
                if (!emitter.isDisposed)
                    emitter.onNext(it.toString().isNotEmpty())
            }
        }
        CompositeDisposable().add(
            Observable
                .combineLatest(
                    emailObservable,
                    passwordIsNotEmptyObservable
                ) { emailIsNotEmpty, passwordIsNotEmpty ->
                    emailIsNotEmpty && passwordIsNotEmpty
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    button?.isEnabled = it
                }
        )
    }

    private fun initViewModel() {
        viewModel.isRegistrationCompleted.observe(viewLifecycleOwner) {
            if (it) {
                showToastInfo(
                    getString(
                        R.string.registration_success,
                        loginEditText?.text.toString()
                    )
                )
                findNavController().popBackStack()
            }
        }
    }
}
