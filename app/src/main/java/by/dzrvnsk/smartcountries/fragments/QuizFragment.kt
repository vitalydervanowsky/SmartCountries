package by.dzrvnsk.smartcountries.fragments

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.dzrvnsk.smartcountries.R
import by.dzrvnsk.smartcountries.databinding.FragmentQuizBinding
import by.dzrvnsk.smartcountries.model.CountryViewModel
import by.dzrvnsk.smartcountries.quiz.Question
import by.dzrvnsk.smartcountries.response.Country
import com.bumptech.glide.Glide
import org.koin.android.viewmodel.ext.android.sharedViewModel
import kotlin.random.Random

class QuizFragment : Fragment() {

    private var _binding: FragmentQuizBinding? = null
    private val binding get() = _binding!!
    private val countryViewModel: CountryViewModel by sharedViewModel()
    private val size = 10
    private var attempt = 1
    private var scores = 0
    private var position = 0
    private var questions = listOf<Question>()
    private var countries = listOf<Country>()
    private val sharedPrefs: SharedPreferences by lazy {
        requireActivity().getSharedPreferences("LAST_LOGIN", Context.MODE_PRIVATE)
    }
    private val usedCountries = mutableListOf<Int>()
    private val colorCorrect = Color.rgb(0, 105, 0)
    private val colorIncorrect = Color.rgb(176, 20, 65)
    private val colorDefault = Color.rgb(98, 0, 238)

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
            questions = getQuestions()

            setDataToViews()

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
                    if (++position < questions.size) {
                        setDataToViews()
                    } else {
                        sharedPrefs.edit()
                            .putInt("LAST_GAME_SCORES", scores)
                            .apply()
                        parentFragmentManager.beginTransaction()
                            .replace(R.id.container, ResultsFragment())
                            .commit()
                    }
                }
            }
        })
    }

    private fun checkAnswer(option: Country) {
        if (questions[position].answer == option && attempt == 1) {
            scores++
        }
        attempt++

        binding.apply {
            val scoresText = "Scores: $scores"
            tvScores.text = scoresText
            btnNextQuestion.visibility = View.VISIBLE
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
            val scoresText = "Scores: $scores"
            tvScores.text = scoresText
            val positionText = "Question: ${position + 1}/${questions.size}"
            tvQuestionNumber.text = positionText
            val question = questions[position]
            Glide.with(this@QuizFragment)
                .load(question.answer.flags.png)
                .into(ivQuestion)
            btnOption1.text = question.option1.name.common
            btnOption2.text = question.option2.name.common
            btnOption3.text = question.option3.name.common
            btnOption4.text = question.option4.name.common
            btnOption1.setBackgroundColor(colorDefault)
            btnOption2.setBackgroundColor(colorDefault)
            btnOption3.setBackgroundColor(colorDefault)
            btnOption4.setBackgroundColor(colorDefault)
        }
    }

    private fun getQuestions(): List<Question> {
        val listOfQuestions = mutableListOf<Question>()
        for (i in 0 until size) {
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
            listOfQuestions.add(
                Question(correctAnswerCountry, country1, country2, country3, country4)
            )
        }
        return listOfQuestions
    }

    private fun getRandomCountry(): Country {
        var number: Int
        do {
            number = Random.nextInt(countries.size)
        } while (usedCountries.contains(number))
        usedCountries.add(number)
        return countries[number]
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}