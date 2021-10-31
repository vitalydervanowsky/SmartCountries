package by.dzrvnsk.smartcountries.fragments

import android.content.*
import android.content.Context.BIND_AUTO_CREATE
import android.os.Bundle
import android.os.IBinder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.dzrvnsk.smartcountries.*
import by.dzrvnsk.smartcountries.databinding.FragmentHelloBinding
import by.dzrvnsk.smartcountries.service.ReminderService
import by.dzrvnsk.smartcountries.viewModel.CountryViewModel
import org.koin.android.viewmodel.ext.android.sharedViewModel

class HelloFragment : Fragment() {

    private var _binding: FragmentHelloBinding? = null
    private val binding get() = _binding!!
    private val sharedPrefs: SharedPreferences by lazy {
        requireActivity().getSharedPreferences(LAST_LOGIN, Context.MODE_PRIVATE)
    }
    private var reminderService: ReminderService? = ReminderService()
    private val countryViewModel: CountryViewModel by sharedViewModel()

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = service as ReminderService.LocalBinder
            reminderService = binder.getReminderServiceInstance()
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            reminderService = null
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHelloBinding.inflate(layoutInflater, container, false)
        countryViewModel.fetchCountries()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.bindService(
            Intent(context, ReminderService::class.java),
            connection,
            BIND_AUTO_CREATE
        )

        initViews()
        initListeners()
    }

    private fun initListeners() {
        binding.apply {
            btnStartQuiz.setOnClickListener {
                showQuizFragment()
            }
            btnShowScores.setOnClickListener {
                showResultsFragment()
            }
            btnLogout.setOnClickListener {
                resetSharedPrefs()
                showLoginFragment()
            }
            btnSetReminder.setOnClickListener {
                startRemindService()
            }
            btnDisableReminder.setOnClickListener {
                stopReminderService()
            }
        }
    }

    private fun initViews() {
        binding.apply {
            val helloText =
                getString(R.string.say_hello) + sharedPrefs.getString(LAST_LOGIN, NO_NAME) + "!"
            tvHello.text = helloText
            val lastScores = sharedPrefs.getInt(LAST_SCORES, NO_SCORES)
            if (lastScores == NO_SCORES) {
                tvLastScores.visibility = View.GONE
            }
            val lastScoresText = getString(R.string.last_scores) + lastScores
            tvLastScores.text = lastScoresText
        }
    }

    private fun showResultsFragment() {
        parentFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.container, ResultsFragment())
            .commit()
    }

    private fun stopReminderService() {
        reminderService?.stop()
        activity?.unbindService(connection)
        val reminderText = getString(R.string.reminder_stop)
        Toast.makeText(requireContext(), reminderText, Toast.LENGTH_SHORT).show()
    }

    private fun startRemindService() {
        reminderService?.start()
        val reminderText = getString(R.string.reminder_start)
        Toast.makeText(requireContext(), reminderText, Toast.LENGTH_SHORT).show()
    }

    private fun resetSharedPrefs() {
        sharedPrefs.edit()
            .putString(LAST_LOGIN, NO_NAME)
            .putInt(LAST_SCORES, NO_SCORES)
            .apply()
    }

    private fun showLoginFragment() {
        parentFragmentManager.beginTransaction()
            .setCustomAnimations(
                R.anim.slide_in_bottom,
                R.anim.fade_out,
                R.anim.fade_in,
                R.anim.slide_out_bottom
            )
            .addToBackStack(null)
            .replace(R.id.container, LoginFragment())
            .commit()
    }

    private fun showQuizFragment() {
        parentFragmentManager.beginTransaction()
            .setCustomAnimations(
                R.anim.slide_in_bottom,
                R.anim.fade_out,
                R.anim.fade_in,
                R.anim.slide_out_bottom
            )
            .replace(R.id.container, QuizFragment())
            .commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}