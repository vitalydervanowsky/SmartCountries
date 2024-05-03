package by.dzrvnsk.smartcountries.presentation.fragments.countrylist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.dzrvnsk.smartcountries.R
import by.dzrvnsk.smartcountries.domain.CountryDomain
import com.bumptech.glide.Glide

class CountryAdapter(
    private val listener: (CountryDomain) -> Unit
) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    private val countries: MutableList<CountryDomain> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(newList: List<CountryDomain>) {
        countries.clear()
        countries.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position], listener)
    }

    override fun getItemCount(): Int = countries.size

    inner class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(
            country: CountryDomain,
            listener: (CountryDomain) -> Unit
        ) {
            itemView.apply {
                Glide.with(itemView)
                    .load(country.flag)
                    .into(findViewById(R.id.imageView))
                findViewById<TextView>(R.id.countryNameTextView).text = country.name
                findViewById<TextView>(R.id.countryRegionTextView).text = country.region
                findViewById<TextView>(R.id.countrySubregionTextView).text = country.subregion
                itemView.setOnClickListener {
                    listener(country)
                }
            }
        }
    }
}
