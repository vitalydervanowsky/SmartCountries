package by.dzrvnsk.smartcountries.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import by.dzrvnsk.smartcountries.databinding.ItemCountryBinding
import by.dzrvnsk.smartcountries.model.response.Country
import com.bumptech.glide.Glide
import java.util.*

class CountryAdapter(
    private val countries: ArrayList<Country>,
    private val listener: (Country) -> Unit
) : RecyclerView.Adapter<CountryViewHolder>(),
    Filterable {

    private val countriesFull = countries.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding = ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position], listener)
    }

    override fun getItemCount(): Int = countries.size

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filteredList = arrayListOf<Country>()

                if (constraint == null || constraint.isEmpty()) {
                    filteredList.addAll(countriesFull as ArrayList<Country>)
                } else {
                    val filterPattern: String =
                        constraint.toString().lowercase(Locale.getDefault()).trim()

                    countriesFull.forEach { country ->
                        if (countryNameContains(country, filterPattern)) {
                            filteredList.add(country)
                        }
                    }
                }
                val results = FilterResults()
                results.values = filteredList
                return results
            }

            private fun countryNameContains(country: Country, filterPattern: String): Boolean {
                return country.name.common.lowercase(Locale.getDefault()).contains(filterPattern)
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults) {
                countries.clear()
                countries.addAll(results.values as ArrayList<Country>)
                notifyDataSetChanged()
            }
        }
    }
}

class CountryViewHolder(private val binding: ItemCountryBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(country: Country, listener: (Country) -> Unit) {
        binding.apply {
            Glide.with(itemView)
                .load(country.flags.png)
                .into(ivCountryFlag)
            tvCountryName.text = country.name.common
            tvCountryRegion.text = country.region
            tvCountrySubregion.text = country.subregion
            itemView.setOnClickListener {
                listener(country)
            }
        }
    }
}