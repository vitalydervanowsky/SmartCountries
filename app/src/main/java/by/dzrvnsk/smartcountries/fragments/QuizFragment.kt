package by.dzrvnsk.smartcountries.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import by.dzrvnsk.smartcountries.*
import by.dzrvnsk.smartcountries.databinding.FragmentQuizBinding
import by.dzrvnsk.smartcountries.model.response.Country
import by.dzrvnsk.smartcountries.quiz.Question
import by.dzrvnsk.smartcountries.viewModel.CountryViewModel
import com.bumptech.glide.Glide
import org.koin.android.viewmodel.ext.android.sharedViewModel
import kotlin.random.Random

class QuizFragment : Fragment() {

    private var _binding: FragmentQuizBinding? = null
    private val binding get() = _binding!!
    private val countryViewModel: CountryViewModel by sharedViewModel()
    private var attempt = START_ATTEMPT
    private var scores = START_SCORES
    private var position = START_POSITION
    private var questions = mutableListOf<Question>()
    private var countries = listOf<Country>()
    private val sharedPrefs: SharedPreferences by lazy {
        requireActivity().getSharedPreferences(LAST_LOGIN, Context.MODE_PRIVATE)
    }
    private val usedCountries = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuizBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        countryViewModel.getCountriesLiveData().observe(viewLifecycleOwner, {
            countries = it
            getQuestions()
            setDataToViews()
            initListeners()
        })
    }

    private fun initListeners() {
        binding.apply {
            btnOption1.setOnClickListener {
                checkAnswer(questions[position].option1)
            }

            btnOption2.setOnClickListener {
                checkAnswer(questions[position].option2)
            }

            btnOption3.setOnClickListener {
                checkAnswer(questions[position].option3)
            }

            btnOption4.setOnClickListener {
                checkAnswer(questions[position].option4)
            }

            btnNextQuestion.setOnClickListener {
                doOnNextClick()
            }
        }
    }

    private fun doOnNextClick() {
        if (++position < QUIZ_SIZE) {
            setDataToViews()
        } else {
            saveScores()
            showResultsFragment()
        }
    }

    private fun saveScores() {
        sharedPrefs.edit()
            .putInt(LAST_SCORES, scores)
            .apply()
    }

    private fun showResultsFragment() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.container, ResultsFragment())
            .commit()
    }

    private fun checkAnswer(option: Country) {
        if (questions[position].answer == option && attempt == START_ATTEMPT) {
            scores++
        }
        attempt++
        updateViews()
    }

    private fun updateViews() {
        binding.apply {
            val scoresText = getString(R.string.scores_text) + scores
            tvScores.text = scoresText
            btnNextQuestion.visibility = View.VISIBLE
            val colorIncorrect = ContextCompat.getColor(requireContext(), R.color.answer_incorrect)
            val colorCorrect = ContextCompat.getColor(requireContext(), R.color.answer_correct)
            btnOption1.setBackgroundColor(colorIncorrect)
            btnOption2.setBackgroundColor(colorIncorrect)
            btnOption3.setBackgroundColor(colorIncorrect)
            btnOption4.setBackgroundColor(colorIncorrect)
            when (questions[position].answer) {
                questions[position].option1 -> btnOption1.setBackgroundColor(colorCorrect)
                questions[position].option2 -> btnOption2.setBackgroundColor(colorCorrect)
                questions[position].option3 -> btnOption3.setBackgroundColor(colorCorrect)
                questions[position].option4 -> btnOption4.setBackgroundColor(colorCorrect)
            }
        }
    }

    private fun setDataToViews() {
        binding.apply {
            attempt = 1
            btnNextQuestion.visibility = View.GONE
            val scoresText = getString(R.string.scores_text) + scores
            tvScores.text = scoresText
            val positionText = "${getString(R.string.questions_text)}${position + 1}/$QUIZ_SIZE"
            tvQuestionNumber.text = positionText
            val question = questions[position]
            Glide.with(this@QuizFragment)
                .load(question.answer.flags.png)
                .into(ivQuestion)
            btnOption1.text = question.option1.name.common
            btnOption2.text = question.option2.name.common
            btnOption3.text = question.option3.name.common
            btnOption4.text = question.option4.name.common
            val colorDefault = ContextCompat.getColor(requireContext(), R.color.purple_500)
            btnOption1.setBackgroundColor(colorDefault)
            btnOption2.setBackgroundColor(colorDefault)
            btnOption3.setBackgroundColor(colorDefault)
            btnOption4.setBackgroundColor(colorDefault)
        }
    }

    private fun getQuestions() {
        for (i in 0 until QUIZ_SIZE) {
            usedCountries.clear()
            val country1 = getRandomCountry()
            val country2 = getRandomCountry()
            val country3 = getRandomCountry()
            val country4 = getRandomCountry()
            val correctAnswerCountry = when (Random.nextInt(4)) {
                0 -> country1
                1 -> country2
                2 -> country3
                else -> country4
            }
            questions.add(
                Question(correctAnswerCountry, country1, country2, country3, country4)
            )
        }
    }

    private fun getRandomCountry(): Country {
        var number = Random.nextInt(countries.size)
        while (usedCountries.contains(number)) {
            number = Random.nextInt(countries.size)
        }
        usedCountries.add(number)
        return countries[number]
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}