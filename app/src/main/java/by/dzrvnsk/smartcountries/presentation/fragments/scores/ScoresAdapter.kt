package by.dzrvnsk.smartcountries.presentation.fragments.scores

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.dzrvnsk.smartcountries.R
import by.dzrvnsk.smartcountries.domain.ScoreDomain
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.Locale

class ScoresAdapter(
    private var scores: List<ScoreDomain> = emptyList()
) : RecyclerView.Adapter<ScoresAdapter.ScoresViewHolder>() {

    private val dateFormat = SimpleDateFormat(DD_MM_YYYY_HH_MM_PATTERN, Locale.getDefault())
    private val decimalFormat = DecimalFormat("#.00")

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(newItems: List<ScoreDomain>) {
        scores = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoresViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_score, parent, false)
        return ScoresViewHolder(view)
    }

    override fun onBindViewHolder(holder: ScoresViewHolder, position: Int) {
        holder.bind(scores[position])
    }

    override fun getItemCount(): Int = scores.size

    inner class ScoresViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        fun bind(scoreDomain: ScoreDomain) {
            itemView.apply {
                findViewById<TextView>(R.id.loginTextView).text = scoreDomain.login
                findViewById<TextView>(R.id.scoresTextView).text = scoreDomain.scores.toString()
                findViewById<TextView>(R.id.pointsTextView).text = scoreDomain.points.toString()
                findViewById<TextView>(R.id.durationTextView).text = itemView.context.getString(
                    R.string.in_seconds,
                    decimalFormat.format(scoreDomain.duration / 1000.0)
                )
                findViewById<TextView>(R.id.dateTextView).text = dateFormat.format(scoreDomain.date)
            }
        }
    }

    companion object {
        const val DD_MM_YYYY_HH_MM_PATTERN = "dd.MM.yyyy HH:mm"
    }
}
