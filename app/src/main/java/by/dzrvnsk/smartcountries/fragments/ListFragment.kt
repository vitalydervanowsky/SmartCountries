package by.dzrvnsk.smartcountries.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import by.dzrvnsk.smartcountries.R
import by.dzrvnsk.smartcountries.adapter.CountryAdapter
import by.dzrvnsk.smartcountries.databinding.FragmentListBinding
import by.dzrvnsk.smartcountries.model.CountryViewModel

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private val countriesViewModel: CountryViewModel by activityViewModels()
    private val sharedPrefs: SharedPreferences by lazy {
        requireActivity().getSharedPreferences("RANDOM_COUNTRY", Context.MODE_PRIVATE)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        countriesViewModel.countriesLiveData.observe(viewLifecycleOwner, {
            binding.rvList.adapter = CountryAdapter(it) { currentCountry ->
                countriesViewModel.setCurrentCountry(currentCountry)
                parentFragmentManager.beginTransaction()
                    .setCustomAnimations(
                        R.anim.slide_in_right,
                        R.anim.fade_out,
                        R.anim.fade_in,
                        R.anim.slide_out_right
                    )
                    .addToBackStack(null)
                    .replace(R.id.container, DetailsFragment())
                    .commit()
            }
        })

        countriesViewModel.currentCountryLiveData.observe(viewLifecycleOwner, {
            sharedPrefs.edit()
                .putString("RANDOM_COUNTRY_NAME", it.name.common)
                .putString("RANDOM_COUNTRY_FLAG", it.flags.png)
                .apply()
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}