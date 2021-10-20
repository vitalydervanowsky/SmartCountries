package by.dzrvnsk.smartcountries.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import by.dzrvnsk.smartcountries.R
import by.dzrvnsk.smartcountries.databinding.FragmentDetailsBinding
import by.dzrvnsk.smartcountries.model.CountryViewModel
import com.bumptech.glide.Glide

class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    private val countriesViewModel: CountryViewModel by activityViewModels()

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
            countriesViewModel.currentCountryLiveData.observe(viewLifecycleOwner, {
                Glide.with(requireContext())
                    .load(it.flags.png)
                    .into(ivCountryFlag)
                tvCountryName.text = it.name.common
                tvCountryNameOfficial.text = it.name.official
                if (it.capital != null) {
                    tvCountryCapital.text = it.capital.first()
                } else {
                    tvCountryCapital.visibility = View.GONE
                }
                val region = "${it.region}, ${it.subregion}"
                tvCountryRegion.text = region
                val area = "Area: ${separateDigits(it.area.toInt())}"
                tvCountryArea.text = area
                val population = "Population: ${separateDigits(it.population)}"
                tvCountryPopulation.text = population
            })

            parentFragmentManager.beginTransaction()
                .add(R.id.map_container, MapsFragment())
                .commit()
        }
    }

    private fun separateDigits(int: Int) : String {
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