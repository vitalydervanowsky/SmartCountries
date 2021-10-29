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
import by.dzrvnsk.smartcountries.R
import by.dzrvnsk.smartcountries.databinding.FragmentHelloBinding
import by.dzrvnsk.smartcountries.service.ReminderService

class HelloFragment : Fragment() {

    private var _binding: FragmentHelloBinding? = null
    private val binding get() = _binding!!
    private val sharedPrefs: SharedPreferences by lazy {
        requireActivity().getSharedPreferences("LAST_LOGIN", Context.MODE_PRIVATE)
    }
    private var reminderService: ReminderService? = ReminderService()

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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding) {
            super.onViewCreated(view, savedInstanceState)

            activity?.bindService(
                Intent(context, ReminderService::class.java),
                connection,
                BIND_AUTO_CREATE
            )

            val helloText =
                getString(R.string.say_hello) + sharedPrefs.getString("LAST_USER_NAME", "") + "!"
            tvHello.text = helloText
            var lastScores = sharedPrefs.getInt("LAST_GAME_SCORES", 0).toString()
            if (lastScores.toInt() == 0) {
                tvLastScores.visibility = View.GONE
            }
            lastScores = getString(R.string.last_scores) + lastScores
            tvLastScores.text = lastScores

            btnStartQuiz.setOnClickListener {
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

            btnShowScores.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.container, ResultsFragment())
                    .commit()
            }

            btnLogout.setOnClickListener {
                sharedPrefs.edit()
                    .putString("LAST_USER_NAME", "")
                    .putInt("LAST_GAME_SCORES", 0)
                    .apply()
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

            btnSetReminder.setOnClickListener {
                reminderService?.start()
                Toast.makeText(requireContext(), "Reminder is set!", Toast.LENGTH_SHORT).show()
            }

            btnDisableReminder.setOnClickListener {
                reminderService?.stop()
                activity?.unbindService(connection)
                Toast.makeText(requireContext(), "Reminder is disabled!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}