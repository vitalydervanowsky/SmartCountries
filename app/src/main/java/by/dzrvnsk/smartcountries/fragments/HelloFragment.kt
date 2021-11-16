package by.dzrvnsk.smartcountries.fragments

import android.content.ComponentName
import android.content.Context
import android.content.Context.BIND_AUTO_CREATE
import android.content.Intent
import android.content.ServiceConnection
import android.content.SharedPreferences
import android.os.Bundle
import android.os.IBinder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.dzrvnsk.smartcountries.LAST_LOGIN
import by.dzrvnsk.smartcountries.LAST_SCORES
import by.dzrvnsk.smartcountries.LAST_TIME
import by.dzrvnsk.smartcountries.NAV_OPTIONS_ANIMATION_SLIDE_IN_BOTTOM
import by.dzrvnsk.smartcountries.NO_NAME
import by.dzrvnsk.smartcountries.NO_SCORES
import by.dzrvnsk.smartcountries.NO_TIME
import by.dzrvnsk.smartcountries.R
import by.dzrvnsk.smartcountries.databinding.FragmentHelloBinding
import by.dzrvnsk.smartcountries.service.ReminderService
import by.dzrvnsk.smartcountries.viewModel.CountryViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HelloFragment : Fragment() {

    private var _binding: FragmentHelloBinding? = null
    private val binding get() = _binding!!
    private val sharedPrefs: SharedPreferences by lazy {
        requireActivity().getSharedPreferences(LAST_LOGIN, Context.MODE_PRIVATE)
    }
    private var reminderService: ReminderService? = ReminderService()
    private val countryViewModel: CountryViewModel by sharedViewModel()
    private val connection = createServiceConnection()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
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

    private fun initListeners() = with(binding) {
        btnStartQuiz.setOnClickListener {
            showQuizFragment()
        }
        btnShowScores.setOnClickListener {
            showScoresFragment()
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

    private fun initViews() = with(binding) {
        val helloText =
            getString(R.string.say_hello) + sharedPrefs.getString(LAST_LOGIN, NO_NAME) + "!"
        tvHello.text = helloText
        val lastScores = sharedPrefs.getInt(LAST_SCORES, NO_SCORES)
        val lastTime = sharedPrefs.getLong(LAST_TIME, NO_TIME)
        if (lastTime == NO_TIME) {
            tvLastScores.visibility = View.GONE
        }
        val lastScoresText = getString(R.string.last_scores) + lastScores
        tvLastScores.text = lastScoresText
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

    private fun showQuizFragment() {
        findNavController().navigate(
            R.id.action_helloFragment_to_quizFragment,
            bundleOf(),
            NAV_OPTIONS_ANIMATION_SLIDE_IN_BOTTOM
        )
    }

    private fun showScoresFragment() {
        findNavController().navigate(
            R.id.action_helloFragment_to_scoresFragment,
            bundleOf(),
            NAV_OPTIONS_ANIMATION_SLIDE_IN_BOTTOM
        )
    }

    private fun showLoginFragment() {
        findNavController().navigate(
            R.id.action_helloFragment_to_loginFragment,
            bundleOf(),
            NAV_OPTIONS_ANIMATION_SLIDE_IN_BOTTOM
        )
    }

    private fun createServiceConnection(): ServiceConnection {
        return object : ServiceConnection {
            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                val binder = service as ReminderService.LocalBinder
                reminderService = binder.getReminderServiceInstance()
            }

            override fun onServiceDisconnected(p0: ComponentName?) {
                reminderService = null
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
