package by.dzrvnsk.smartcountries.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.dzrvnsk.smartcountries.R
import by.dzrvnsk.smartcountries.adapter.CountryAdapter
import by.dzrvnsk.smartcountries.databinding.FragmentListBinding
import by.dzrvnsk.smartcountries.model.CountryViewModel
import org.koin.android.viewmodel.ext.android.sharedViewModel

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private val countriesViewModel: CountryViewModel by sharedViewModel()
    private val sharedPrefs: SharedPreferences by lazy {
        requireActivity().getSharedPreferences("RANDOM_COUNTRY", Context.MODE_PRIVATE)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // one time network request
        countriesViewModel.getCountries()
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

        countriesViewModel.getCountriesLiveData().observe(viewLifecycleOwner, {
            binding.rvList.adapter = CountryAdapter(it) { currentCountry ->
                countriesViewModel.setCurrentCountryLiveData(currentCountry)
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

        countriesViewModel.getCurrentCountryLiveData().observe(viewLifecycleOwner, {
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