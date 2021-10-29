package by.dzrvnsk.smartcountries.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
    private var scores = 0
    private var position = 0
    private var questions = listOf<Question>()
    private var countries = listOf<Country>()
    private val sharedPrefs: SharedPreferences by lazy {
        requireActivity().getSharedPreferences("LAST_LOGIN", Context.MODE_PRIVATE)
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

        countryViewModel.fetchCountries()
        countryViewModel.getCountriesLiveData().observe(viewLifecycleOwner, {
            countries = it
            questions = getQuestions()

            setDataToViews()

            binding.apply {
                btnOption1.setOnClickListener {
                    checkAnswer(questions[position].answer, questions[position].option1)
                }

                btnOption2.setOnClickListener {
                    checkAnswer(questions[position].answer, questions[position].option2)
                }

                btnOption3.setOnClickListener {
                    checkAnswer(questions[position].answer, questions[position].option3)
                }

                btnOption4.setOnClickListener {
                    checkAnswer(questions[position].answer, questions[position].option4)
                }

            }
        })
    }

    private fun checkAnswer(answer: Country, option: Country) {
        if (answer.name.common == option.name.common) {
            scores++
            Toast.makeText(requireContext(), "Correct!\nIt was ${answer.name.common}", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(requireContext(), "Incorrect!\nIt was ${answer.name.common}", Toast.LENGTH_SHORT).show()
        }
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

    private fun setDataToViews() {
        binding.apply {
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
        }
    }

    private fun getQuestions(): List<Question> {
        val listOfQuestions = mutableListOf<Question>()
        for (i in 0..9) {
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