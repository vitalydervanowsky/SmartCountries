package by.dzrvnsk.smartcountries.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.dzrvnsk.smartcountries.database.scoresDatabase.QuizResult
import by.dzrvnsk.smartcountries.databinding.ItemScoreBinding

class ScoresAdapter(
    private val scores: List<QuizResult>
) : RecyclerView.Adapter<ScoresViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoresViewHolder {
        val binding = ItemScoreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ScoresViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ScoresViewHolder, position: Int) {
        holder.bind(scores[position])
    }

    override fun getItemCount(): Int = scores.size
}

class ScoresViewHolder(private val binding: ItemScoreBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(quizResult: QuizResult) {
        binding.apply {
            tvLogin.text = quizResult.login
            tvScores.text = quizResult.scores.toString()
            tvPoints.text = quizResult.points.toString()
        }
    }
}
