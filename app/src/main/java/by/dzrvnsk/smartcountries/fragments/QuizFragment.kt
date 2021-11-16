package by.dzrvnsk.smartcountries.fragments

import android.content.Context
import android.content.SharedPreferences
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.dzrvnsk.smartcountries.LAST_LOGIN
import by.dzrvnsk.smartcountries.LAST_POINTS
import by.dzrvnsk.smartcountries.LAST_SCORES
import by.dzrvnsk.smartcountries.LAST_TIME
import by.dzrvnsk.smartcountries.NO_NAME
import by.dzrvnsk.smartcountries.QUIZ_SIZE
import by.dzrvnsk.smartcountries.R
import by.dzrvnsk.smartcountries.START_ATTEMPT
import by.dzrvnsk.smartcountries.START_POSITION
import by.dzrvnsk.smartcountries.START_SCORES
import by.dzrvnsk.smartcountries.START_TIME_DURATION
import by.dzrvnsk.smartcountries.database.scoresDatabase.QuizResult
import by.dzrvnsk.smartcountries.database.scoresDatabase.ScoresRepository
import by.dzrvnsk.smartcountries.databinding.FragmentQuizBinding
import by.dzrvnsk.smartcountries.model.response.Country
import by.dzrvnsk.smartcountries.quiz.Question
import by.dzrvnsk.smartcountries.viewModel.CountryViewModel
import com.bumptech.glide.Glide
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import kotlin.random.Random

class QuizFragment : Fragment() {

    private var _binding: FragmentQuizBinding? = null
    private val binding get() = _binding!!
    private val countryViewModel: CountryViewModel by sharedViewModel()
    private val scoresRepository: ScoresRepository by inject()
    private var attempt = START_ATTEMPT
    private var scores = START_SCORES
    private var position = START_POSITION
    private var questions = mutableListOf<Question>()
    private var countries = listOf<Country>()
    private val sharedPrefs: SharedPreferences by lazy {
        requireActivity().getSharedPreferences(LAST_LOGIN, Context.MODE_PRIVATE)
    }
    private val usedCountries = mutableListOf<Int>()
    private var duration = START_TIME_DURATION
    private var startTime = START_TIME_DURATION
    private var stopTime = START_TIME_DURATION

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
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

    private fun initListeners() = with(binding) {
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

    private fun doOnNextClick() {
        if (++position < QUIZ_SIZE) {
            setDataToViews()
        } else {
            saveScores()
            showResultsFragment()
        }
    }

    private fun saveScores() = CoroutineScope(Dispatchers.IO).launch {
        val login = sharedPrefs.getString(LAST_LOGIN, NO_NAME) + ""
        val points: Float = scores * 100000 / duration.toFloat() / QUIZ_SIZE

        scoresRepository.saveResult(QuizResult(login, scores, points))

        sharedPrefs.edit()
            .putInt(LAST_SCORES, scores)
            .putLong(LAST_TIME, duration)
            .putFloat(LAST_POINTS, points)
            .apply()
    }

    private fun showResultsFragment() {
        findNavController().navigate(R.id.action_quizFragment_to_resultsFragment)
    }

    private fun checkAnswer(option: Country) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            stopTime = Calendar.getInstance().timeInMillis
        }
        duration += stopTime - startTime
        if (questions[position].answer == option && attempt == START_ATTEMPT) {
            scores++
        }
        attempt++
        updateViews()
    }

    private fun updateViews() = with(binding) {
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

    private fun setDataToViews() = with(binding) {
        attempt = START_ATTEMPT
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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            startTime = Calendar.getInstance().timeInMillis
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
