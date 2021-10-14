package by.dzrvnsk.currency.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.dzrvnsk.currency.databinding.ItemCountryBinding
import by.dzrvnsk.currency.response.Country
import com.bumptech.glide.Glide

class CountryAdapter(
    private val data: ArrayList<Country>,
    private val delegate: (Country) -> Unit
) : RecyclerView.Adapter<CountryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding = ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(data[position], delegate)
    }

    override fun getItemCount(): Int = data.size
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