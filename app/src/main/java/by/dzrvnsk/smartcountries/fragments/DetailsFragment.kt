package by.dzrvnsk.smartcountries.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.dzrvnsk.smartcountries.R
import by.dzrvnsk.smartcountries.databinding.FragmentDetailsBinding
import by.dzrvnsk.smartcountries.model.CountryViewModel
import com.bumptech.glide.Glide
import org.koin.android.viewmodel.ext.android.sharedViewModel

class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    private val countriesViewModel: CountryViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            countriesViewModel.getCurrentCountryLiveData().observe(viewLifecycleOwner, { country ->
                Glide.with(requireContext())
                    .load(country.flags.png)
                    .into(ivCountryFlag)
                tvCountryName.text = country.name.common
                tvCountryNameOfficial.text = country.name.official
                tvCountryNameOfficial.setOnClickListener {
                    val intentUri = Uri.parse(country.maps.openStreetMaps)
                    val mapIntent = Intent(Intent.ACTION_VIEW, intentUri)
                    startActivity(mapIntent)
                }
                if (country.capital != null) {
                    tvCountryCapital.text = country.capital.first()
                } else {
                    tvCountryCapital.visibility = View.GONE
                }
                tvCountryCapital.setOnClickListener {
                    val gmmIntentUri =
                        Uri.parse("geo:${country.capitalInfo.latlng[0]},${country.capitalInfo.latlng[1]}?z=11")
                    val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                    mapIntent.setPackage("com.google.android.apps.maps")
                    startActivity(mapIntent)

                }
                val region = "${country.region}, ${country.subregion}"
                tvCountryRegion.text = region
                val area = "Area: ${separateDigits(country.area.toInt())}"
                tvCountryArea.text = area
                val population = "Population: ${separateDigits(country.population)}"
                tvCountryPopulation.text = population
            })

            parentFragmentManager.beginTransaction()
                .add(R.id.map_container, MapsFragment())
                .commit()
        }
    }

    private fun separateDigits(int: Int): String {
        val stringBuilder = StringBuilder()
        var count = 0
        var number = int
        while (number > 0) {
            val digit = number % 10
            number /= 10
            if (count % 3 == 0) {
                stringBuilder.append(" ")
            }
            stringBuilder.append(digit)
            count++
        }
        return stringBuilder.toString().reversed()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}