package by.dzrvnsk.smartcountries.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.SearchView
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var adapter: CountryAdapter? = null

        countriesViewModel.fetchCountries()
        countriesViewModel.getCountriesLiveData().observe(viewLifecycleOwner, {
            adapter = CountryAdapter(it) { currentCountry ->
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
            binding.apply {
                rvList.adapter = adapter
                searchCountry.isIconified = true
                searchCountry.imeOptions = EditorInfo.IME_ACTION_DONE
            }
        })

        countriesViewModel.getCurrentCountryLiveData().observe(viewLifecycleOwner, {
            sharedPrefs.edit()
                .putString("RANDOM_COUNTRY_NAME", it.name.common)
                .putString("RANDOM_COUNTRY_FLAG", it.flags.png)
                .apply()
        })

        binding.searchCountry.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(query: String): Boolean {
                adapter?.filter?.filter(query)
                return false
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}