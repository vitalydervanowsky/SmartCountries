package by.dzrvnsk.smartcountries.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.dzrvnsk.smartcountries.LAST_LOGIN
import by.dzrvnsk.smartcountries.LAST_SCORES
import by.dzrvnsk.smartcountries.NO_SCORES
import by.dzrvnsk.smartcountries.R
import by.dzrvnsk.smartcountries.databinding.FragmentResultsBinding

class ResultsFragment : Fragment() {

    private var _binding: FragmentResultsBinding? = null
    private val binding get() = _binding!!
    private val sharedPrefs: SharedPreferences by lazy {
        requireActivity().getSharedPreferences(LAST_LOGIN, Context.MODE_PRIVATE)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
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

    private fun initListeners() {
        binding.btnRestart.setOnClickListener {
            showQuizFragment()
        }
        binding.btnGoBack.setOnClickListener {
            showMenuFragment()
        }
    }

    private fun initViews() {
        val scores = sharedPrefs.getInt(LAST_SCORES, NO_SCORES)
        val resultText = when (scores) {
            in 8..10 -> getString(R.string.result_perfect)
            in 4..7 -> getString(R.string.result_good)
            else -> getString(R.string.result_bad)
        }
        binding.tvLastGameResults.text = resultText
        binding.tvLastGameScores.text = scores.toString()
    }

    private fun showMenuFragment() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.container, MenuFragment())
            .commit()
    }

    private fun showQuizFragment() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.container, QuizFragment())
            .commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}