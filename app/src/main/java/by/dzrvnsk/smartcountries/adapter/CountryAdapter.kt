package by.dzrvnsk.smartcountries.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import by.dzrvnsk.smartcountries.databinding.ItemCountryBinding
import by.dzrvnsk.smartcountries.response.Country
import com.bumptech.glide.Glide
import java.util.*
import kotlin.collections.ArrayList

class CountryAdapter(
    private val data: ArrayList<Country>,
    private val delegate: (Country) -> Unit
) : RecyclerView.Adapter<CountryViewHolder>(),
    Filterable {

    private val dataFull = data.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding = ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(data[position], delegate)
    }

    override fun getItemCount(): Int = data.size

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filteredList = arrayListOf<Country>()

                if (constraint == null || constraint.isEmpty()) {
                    filteredList.addAll(dataFull as ArrayList<Country>)
                } else {
                    val filterPattern: String =
                        constraint.toString().lowercase(Locale.getDefault()).trim()

                    dataFull.forEach { country ->
                        if (country.name.common.lowercase(Locale.getDefault())
                                .contains(filterPattern)
                        )
                            filteredList.add(country)
                    }
                }
                val results = FilterResults()
                results.values = filteredList
                return results
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults) {
                data.clear()
                data.addAll(results.values as ArrayList<Country>)
                notifyDataSetChanged()
            }
        }
    }
}

class CountryViewHolder(private val binding: ItemCountryBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(country: Country, delegate: (Country) -> Unit) {
        binding.apply {
            Glide.with(itemView)
                .load(country.flags.png)
                .into(ivCountryFlag)
            tvCountryName.text = country.name.common
            tvCountryRegion.text = country.region
            tvCountrySubregion.text = country.subregion
            itemView.setOnClickListener {
                delegate(country)
            }
        }
    }
}