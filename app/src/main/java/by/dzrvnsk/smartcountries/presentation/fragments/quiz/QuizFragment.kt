package by.dzrvnsk.smartcountries.presentation.fragments.quiz

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import by.dzrvnsk.smartcountries.R
import by.dzrvnsk.smartcountries.domain.CountryDomain
import by.dzrvnsk.smartcountries.presentation.model.BaseFragment
import by.dzrvnsk.smartcountries.presentation.model.Question
import com.bumptech.glide.Glide
import org.koin.android.ext.android.inject
import java.util.Calendar

class QuizFragment : BaseFragment() {

    private var scoresTextView: TextView? = null
    private var questionNumberTextView: TextView? = null
    private var imageView: ImageView? = null
    private var optionButtons: List<Button?>? = null
    private var nextButton: Button? = null

    private val viewModel: QuizViewModel by inject()
    private var attempt = START_ATTEMPT
    private var scores = START_SCORES
    private var position = START_POSITION
    private var questions = listOf<Question>()
    private var correctMediaPlayer: MediaPlayer? = null
    private var incorrectMediaPlayer: MediaPlayer? = null
    private var duration = START_TIME_DURATION
    private var startTime = START_TIME_DURATION
    private var stopTime = START_TIME_DURATION

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        initMediaPlayers()
        initViewModel()
    }

    private fun initViews(view: View) {
        view.apply {
            scoresTextView = findViewById(R.id.scoresTextView)
            questionNumberTextView = findViewById(R.id.questionNumberTextView)
            imageView = findViewById(R.id.imageView)
            optionButtons = listOf(
                findViewById(R.id.option1Button),
                findViewById(R.id.option2Button),
                findViewById(R.id.option3Button),
                findViewById(R.id.option4Button)
            )
            optionButtons?.forEachIndexed { index, button ->
                button?.setOnClickListener {
                    checkAnswer(questions[position].options[index])
                }
            }
            nextButton = findViewById<Button?>(R.id.nextButton).apply {
                setOnClickListener {
                    doOnNextClick()
                }
            }
        }
    }

    private fun initMediaPlayers() {
        if (correctMediaPlayer == null) {
            correctMediaPlayer = MediaPlayer.create(requireContext(), R.raw.correct)
        }
        if (incorrectMediaPlayer == null) {
            incorrectMediaPlayer = MediaPlayer.create(requireContext(), R.raw.incorrect)
        }
    }

    private fun initViewModel() {
        viewModel.questions.observe(viewLifecycleOwner) {
            questions = it
            setDataToViews()
        }
        viewModel.saveResults.observe(viewLifecycleOwner) {
            it?.let { result ->
                findNavController().navigate(
                    R.id.action_quizFragment_to_resultsFragment,
                    bundleOf(
                        RESULT_KEY to result
                    )
                )
                viewModel.clearResult()
            }
        }
    }

    private fun doOnNextClick() {
        if (++position < QUIZ_SIZE) {
            setDataToViews()
        } else {
            saveScoresAndGoToResultsFragment()
        }
    }

    private fun saveScoresAndGoToResultsFragment() {
        val login = sharedPrefs.getString(USER_PREFS, "") ?: ""
        val points: Float = scores * 100000 / duration.toFloat() / QUIZ_SIZE
        viewModel.saveResults(login, scores, points, duration)
    }

    private fun checkAnswer(option: CountryDomain) {
        stopTime = Calendar.getInstance().timeInMillis
        duration += stopTime - startTime
        val colorIncorrect = ContextCompat.getColor(requireContext(), R.color.answer_incorrect)
        val colorCorrect = ContextCompat.getColor(requireContext(), R.color.answer_correct)
        optionButtons?.forEachIndexed { index, button ->
            button?.setBackgroundColor(
                if (questions[position].answer == questions[position].options[index]) {
                    colorCorrect
                } else {
                    colorIncorrect
                }
            )
        }
        if (questions[position].answer == option && attempt == START_ATTEMPT) {
            correctMediaPlayer?.start()
            scores++
        } else {
            incorrectMediaPlayer?.start()
        }
        attempt++

        scoresTextView?.text = getString(
            R.string.scores_text,
            scores
        )
        nextButton?.visibility = View.VISIBLE
    }

    private fun setDataToViews() {
        attempt = START_ATTEMPT
        nextButton?.visibility = View.GONE
        scoresTextView?.text = getString(
            R.string.scores_text,
            scores
        )
        questionNumberTextView?.text = getString(
            R.string.questions_text,
            position + 1,
            QUIZ_SIZE
        )
        val question = questions[position]
        imageView?.let {
            Glide.with(this)
                .load(question.answer.flag)
                .into(it)
        }
        val colorDefault = ContextCompat.getColor(requireContext(), R.color.purple_500)
        optionButtons?.forEachIndexed { index, button ->
            button?.text = question.options[index].name
            button?.setBackgroundColor(colorDefault)
        }
        startTime = Calendar.getInstance().timeInMillis
    }

    companion object {
        const val START_ATTEMPT = 1
        const val START_POSITION = 0
        const val START_SCORES = 0
        const val START_TIME_DURATION = 0L
        const val QUIZ_SIZE = 10
        const val RESULT_KEY = "RESULT_KEY"
    }
}
