package by.dzrvnsk.smartcountries.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.dzrvnsk.smartcountries.R
import by.dzrvnsk.smartcountries.domain.ScoreDomain
import by.dzrvnsk.smartcountries.presentation.fragments.quiz.QuizFragment
import java.text.DecimalFormat

class ResultsFragment : Fragment() {

    private var result: ScoreDomain? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_results, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        result = arguments?.getSerializable(QuizFragment.RESULT_KEY) as? ScoreDomain
        initViews(view)
        initListeners()
    }

    private fun initListeners() {
        view?.findViewById<Button>(R.id.restartButton)?.setOnClickListener {
            showQuizFragment()
        }
        view?.findViewById<Button>(R.id.backButton)?.setOnClickListener {
            showMenuFragment()
        }
    }

    private fun initViews(view: View) {
        view.findViewById<TextView>(R.id.descriptionTextView).text = when (result?.scores) {
            in 8..10 -> getString(R.string.result_perfect)
            in 4..7 -> getString(R.string.result_good)
            else -> getString(R.string.result_bad)
        }
        view.findViewById<TextView>(R.id.scoresTextView).text = result?.scores.toString()

        val decimalFormat = DecimalFormat("#.00")
        view.findViewById<TextView>(R.id.durationTextView).text = getString(
            R.string.in_seconds,
            decimalFormat.format((result?.duration ?: 0L) / 1000.0)
        )

        view.findViewById<TextView>(R.id.pointsTextView).text = getString(
            R.string.get_some_points,
            result?.points
        )
    }

    private fun showMenuFragment() {
        findNavController().popBackStack(R.id.menuFragment, false)
    }

    private fun showQuizFragment() {
        findNavController().navigate(R.id.action_resultsFragment_to_quizFragment)
    }
}
