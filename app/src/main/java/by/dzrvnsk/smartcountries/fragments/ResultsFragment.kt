package by.dzrvnsk.smartcountries.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.dzrvnsk.smartcountries.R
import by.dzrvnsk.smartcountries.databinding.FragmentResultsBinding

class ResultsFragment : Fragment() {

    private var _binding: FragmentResultsBinding? = null
    private val binding get() = _binding!!
    private val sharedPrefs: SharedPreferences by lazy {
        requireActivity().getSharedPreferences("LAST_LOGIN", Context.MODE_PRIVATE)
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
        val scores = sharedPrefs.getInt("LAST_GAME_SCORES", 0)
        binding.apply {
            tvLastGameScores.text = scores.toString()

            btnRestart.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.container, QuizFragment())
                    .commit()
            }

            btnGoBack.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.container, MenuFragment())
                    .commit()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}