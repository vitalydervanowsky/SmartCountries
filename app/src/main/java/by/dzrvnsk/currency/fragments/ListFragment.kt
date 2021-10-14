package by.dzrvnsk.currency.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import by.dzrvnsk.currency.adapter.CountryAdapter
import by.dzrvnsk.currency.databinding.FragmentListBinding
import by.dzrvnsk.currency.model.CountryViewModel

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private val countriesViewModel: CountryViewModel by activityViewModels()

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
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}