package by.dzrvnsk.smartcountries.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.dzrvnsk.smartcountries.R
import by.dzrvnsk.smartcountries.databinding.FragmentQuizBinding
import by.dzrvnsk.smartcountries.model.CountryViewModel
import by.dzrvnsk.smartcountries.quiz.Question
import by.dzrvnsk.smartcountries.service.WORK_TAG
import com.bumptech.glide.Glide
import org.koin.android.viewmodel.ext.android.sharedViewModel

class QuizFragment : Fragment() {

    private var _binding: FragmentQuizBinding? = null
    private val binding get() = _binding!!
    private val countryViewModel: CountryViewModel by sharedViewModel()
    private var scores = 0
    private var currentPosition = 0
    private var listOfQuestions = listOf<Question>()
    private val sharedPrefs: SharedPreferences by lazy {
        requireActivity().getSharedPreferences("LAST_LOGIN", Context.MODE_PRIVATE)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuizBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        countryViewModel.getCountries()
        countryViewModel.getQuestionsLiveData().observe(viewLifecycleOwner, {
            listOfQuestions = it
            Log.e(WORK_TAG, listOfQuestions.toString())
            setDataToViews()

            binding.apply {
                btnOption1.setOnClickListener {
                    if (listOfQuestions[currentPosition].answer.name.common == listOfQuestions[currentPosition].option1.name.common) {
                        scores++
                    }
                    currentPosition++
                    if (currentPosition < listOfQuestions.size) {
                        setDataToViews()
                    } else {
                        showResultsFragment()
                    }
                }

                btnOption2.setOnClickListener {
                    if (listOfQuestions[currentPosition].answer.name.common == listOfQuestions[currentPosition].option2.name.common) {
                        scores++
                    }
                    currentPosition++
                    if (currentPosition < listOfQuestions.size) {
                        setDataToViews()
                    } else {
                        showResultsFragment()
                    }
                }

                btnOption3.setOnClickListener {
                    if (listOfQuestions[currentPosition].answer.name.common == listOfQuestions[currentPosition].option3.name.common) {
                        scores++
                    }
                    currentPosition++
                    if (currentPosition < listOfQuestions.size) {
                        setDataToViews()
                    } else {
                        showResultsFragment()
                    }
                }

                btnOption4.setOnClickListener {
                    if (listOfQuestions[currentPosition].answer.name.common == listOfQuestions[currentPosition].option4.name.common) {
                        scores++
                    }
                    currentPosition++
                    if (currentPosition < listOfQuestions.size) {
                        setDataToViews()
                    } else {
                        showResultsFragment()
                    }
                }

            }
        })
    }

    private fun showResultsFragment() {
        sharedPrefs.edit()
            .putInt("LAST_GAME_SCORES", scores)
            .apply()
        parentFragmentManager.beginTransaction()
            .replace(R.id.container, ResultsFragment())
            .commit()
    }

    private fun setDataToViews() {
        binding.apply {
            val scoresText = "Scores: $scores"
            tvScores.text = scoresText
            val position = currentPosition + 1
            val currentPositionText = "Question: $position/${listOfQuestions.size}"
            tvQuestionNumber.text = currentPositionText
            val question = listOfQuestions[currentPosition]
            Glide.with(this@QuizFragment)
                .load(question.answer.flags.png)
                .into(ivQuestion)
            btnOption1.text = question.option1.name.common
            btnOption2.text = question.option2.name.common
            btnOption3.text = question.option3.name.common
            btnOption4.text = question.option4.name.common
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}