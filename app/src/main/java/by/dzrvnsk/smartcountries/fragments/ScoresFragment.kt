package by.dzrvnsk.smartcountries.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.dzrvnsk.smartcountries.adapter.ScoresAdapter
import by.dzrvnsk.smartcountries.database.scoresDatabase.QuizResult
import by.dzrvnsk.smartcountries.database.scoresDatabase.ScoresRepository
import by.dzrvnsk.smartcountries.databinding.FragmentScoresBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class ScoresFragment : Fragment() {

    private var _binding: FragmentScoresBinding? = null
    private val binding get() = _binding!!
    private val scoresRepository: ScoresRepository by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentScoresBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initListeners()
    }

    private fun initListeners() {
        binding.btnDeleteScores.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                scoresRepository.deleteAll()
            }
            initViews()
        }
    }

    private fun initViews() = CoroutineScope(Dispatchers.IO).launch {
        val scores: List<QuizResult> = scoresRepository.getScores()

        activity?.runOnUiThread {
            binding.rvList.adapter = ScoresAdapter(scores)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
