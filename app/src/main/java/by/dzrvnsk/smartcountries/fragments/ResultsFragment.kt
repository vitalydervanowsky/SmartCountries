package by.dzrvnsk.smartcountries.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.dzrvnsk.smartcountries.LAST_LOGIN
import by.dzrvnsk.smartcountries.LAST_POINTS
import by.dzrvnsk.smartcountries.LAST_SCORES
import by.dzrvnsk.smartcountries.LAST_TIME
import by.dzrvnsk.smartcountries.NO_POINTS
import by.dzrvnsk.smartcountries.NO_SCORES
import by.dzrvnsk.smartcountries.NO_TIME
import by.dzrvnsk.smartcountries.R
import by.dzrvnsk.smartcountries.databinding.FragmentResultsBinding

class ResultsFragment : Fragment() {

    private var _binding: FragmentResultsBinding? = null
    private val binding get() = _binding!!
    private val sharedPrefs: SharedPreferences by lazy {
        requireActivity().getSharedPreferences(LAST_LOGIN, Context.MODE_PRIVATE)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initListeners()
    }

    private fun initListeners() = with(binding) {
        btnRestart.setOnClickListener {
            showQuizFragment()
        }
        btnGoBack.setOnClickListener {
            showMenuFragment()
        }
    }

    private fun initViews() = with(binding) {
        val scores = sharedPrefs.getInt(LAST_SCORES, NO_SCORES)
        val resultText = when (scores) {
            in 8..10 -> getString(R.string.result_perfect)
            in 4..7 -> getString(R.string.result_good)
            else -> getString(R.string.result_bad)
        }
        tvLastGameResults.text = resultText
        tvLastGameScores.text = scores.toString()

        val time = sharedPrefs.getLong(LAST_TIME, NO_TIME) / 1000F
        val timeText = "$time sec"
        tvLastGameTime.text = timeText

        val points = sharedPrefs.getFloat(LAST_POINTS, NO_POINTS)
        val pointsText = "$points points"
        tvLastGamePoints.text = pointsText
    }

    private fun showMenuFragment() {
        findNavController().popBackStack(R.id.menuFragment, false)
    }

    private fun showQuizFragment() {
        findNavController().navigate(R.id.action_resultsFragment_to_quizFragment)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
