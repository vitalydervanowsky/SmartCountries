package by.dzrvnsk.smartcountries.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.SearchView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.dzrvnsk.smartcountries.NAV_OPTIONS_ANIMATION_SLIDE_IN_RIGHT
import by.dzrvnsk.smartcountries.R
import by.dzrvnsk.smartcountries.RANDOM_COUNTRY
import by.dzrvnsk.smartcountries.RANDOM_COUNTRY_FLAG
import by.dzrvnsk.smartcountries.RANDOM_COUNTRY_NAME
import by.dzrvnsk.smartcountries.adapter.CountryAdapter
import by.dzrvnsk.smartcountries.databinding.FragmentListBinding
import by.dzrvnsk.smartcountries.model.response.Country
import by.dzrvnsk.smartcountries.viewModel.CountryViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private val countryViewModel: CountryViewModel by sharedViewModel()
    private val sharedPrefs: SharedPreferences by lazy {
        requireActivity().getSharedPreferences(RANDOM_COUNTRY, Context.MODE_PRIVATE)
    }
    private lateinit var adapter: CountryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initListeners()
    }

    private fun initViews() {
        countryViewModel.fetchCountries()
        countryViewModel.getCountriesLiveData().observe(viewLifecycleOwner, {
            setAdapter(it)
        })

        countryViewModel.getCurrentCountryLiveData().observe(viewLifecycleOwner, {
            saveToSharedPrefs(it)
        })
    }

    private fun setAdapter(countries: ArrayList<Country>) {
        adapter = CountryAdapter(countries) { currentCountry ->
            countryViewModel.setCurrentCountryLiveData(currentCountry)
            showDetailsFragment()
        }
        binding.apply {
            rvList.adapter = adapter
            searchCountry.isIconified = true
            searchCountry.imeOptions = EditorInfo.IME_ACTION_DONE
        }
    }

    private fun initListeners() {
        binding.searchCountry.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(query: String): Boolean {
                adapter.filter.filter(query)
                return false
            }
        })
    }

    private fun saveToSharedPrefs(country: Country) {
        sharedPrefs.edit()
            .putString(RANDOM_COUNTRY_NAME, country.name.common)
            .putString(RANDOM_COUNTRY_FLAG, country.flags.png)
            .apply()
    }

    private fun showDetailsFragment() {
        findNavController().navigate(
            R.id.action_listFragment_to_detailsFragment,
            bundleOf(),
            NAV_OPTIONS_ANIMATION_SLIDE_IN_RIGHT
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
