package by.dzrvnsk.smartcountries.presentation.fragments

import android.content.ComponentName
import android.content.Context.BIND_AUTO_CREATE
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import by.dzrvnsk.smartcountries.NAV_OPTIONS_ANIMATION_SLIDE_IN_BOTTOM
import by.dzrvnsk.smartcountries.R
import by.dzrvnsk.smartcountries.presentation.model.BaseFragment
import by.dzrvnsk.smartcountries.service.ReminderService

class HelloFragment : BaseFragment() {

    private var reminderService: ReminderService? = ReminderService()
    private val connection = createServiceConnection()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_hello, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.bindService(
            Intent(context, ReminderService::class.java),
            connection,
            BIND_AUTO_CREATE
        )

        view.findViewById<TextView>(R.id.helloTextView).text = getString(
            R.string.say_hello_with_name,
            sharedPrefs.getString(USER_PREFS, "")
        )
        view.findViewById<TextView>(R.id.scoresTextView).apply {
            val lastScores = sharedPrefs.getInt(LAST_SCORES, 0)
            val lastTime = sharedPrefs.getLong(LAST_TIME, NO_TIME)
            if (lastTime == NO_TIME) {
                visibility = View.GONE
            }
            text = getString(
                R.string.last_scores,
                lastScores
            )
        }

        view.findViewById<Button>(R.id.quizButton).setOnClickListener {
            showQuizFragment()
        }
        view.findViewById<Button>(R.id.scoresButton).setOnClickListener {
            showScoresFragment()
        }
        view.findViewById<Button>(R.id.logoutButton).setOnClickListener {
            resetSharedPrefs()
            showLoginFragment()
        }
        view.findViewById<Button>(R.id.setReminderButton).setOnClickListener {
            startRemindService()
        }
        view.findViewById<Button>(R.id.disableReminderButton).setOnClickListener {
            stopReminderService()
        }
    }

    private fun stopReminderService() {
        reminderService?.stop()
        activity?.unbindService(connection)
        showToastInfo(getString(R.string.reminder_stop))
    }

    private fun startRemindService() {
        reminderService?.start()
        showToastInfo(getString(R.string.reminder_start))
    }

    private fun resetSharedPrefs() {
        sharedPrefs.edit()
            .putString(USER_PREFS, "")
            .putInt(LAST_SCORES, 0)
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

    companion object {
        const val LAST_SCORES = "LAST_SCORES"
        const val LAST_TIME = "LAST_TIME"
        const val NO_TIME = 0L
    }
}
