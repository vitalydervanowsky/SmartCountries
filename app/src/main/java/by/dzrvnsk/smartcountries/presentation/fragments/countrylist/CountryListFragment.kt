package by.dzrvnsk.smartcountries.presentation.fragments.countrylist

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import by.dzrvnsk.smartcountries.NAV_OPTIONS_ANIMATION_SLIDE_IN_RIGHT
import by.dzrvnsk.smartcountries.R
import by.dzrvnsk.smartcountries.domain.CountryDomain
import by.dzrvnsk.smartcountries.presentation.model.BaseFragment
import org.koin.android.ext.android.inject

class CountryListFragment : BaseFragment() {

    private var recyclerView: RecyclerView? = null
    private var swipeRefreshLayout: SwipeRefreshLayout? = null

    private val viewModel: CountryListViewModel by inject()
    private var adapter: CountryAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_country_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        initAdapter()
        initViewModel()
        getCountries()
    }

    private fun initViews(view: View) {
        view.apply {
            findViewById<EditText>(R.id.editText).apply {
                imeOptions = EditorInfo.IME_ACTION_DONE
                addTextChangedListener(
                    object : TextWatcher {
                        override fun beforeTextChanged(
                            s: CharSequence?,
                            start: Int,
                            count: Int,
                            after: Int
                        ) = Unit

                        override fun onTextChanged(
                            s: CharSequence?,
                            start: Int,
                            before: Int,
                            count: Int
                        ) = Unit

                        override fun afterTextChanged(s: Editable?) {
                            viewModel.filterByName(s.toString())
                        }
                    }
                )
            }
            recyclerView = findViewById(R.id.recyclerView)
            swipeRefreshLayout = findViewById<SwipeRefreshLayout>(R.id.swipeRefreshLayout).apply {
                setOnRefreshListener {
                    viewModel.getAllCountries(isForce = true)
                }
            }
        }
    }

    private fun initAdapter() {
        adapter = CountryAdapter { country ->
            saveToSharedPrefs(country)
            findNavController().navigate(
                R.id.action_listFragment_to_detailsFragment,
                bundleOf(
                    CURRENT_COUNTRY_ARG to country
                ),
                NAV_OPTIONS_ANIMATION_SLIDE_IN_RIGHT
            )
        }
        recyclerView?.adapter = adapter
    }

    private fun initViewModel() {
        viewModel.countries.observe(viewLifecycleOwner) { items ->
            items?.let {
                swipeRefreshLayout?.isRefreshing = false
                adapter?.setItems(it)
            }
        }
    }

    private fun getCountries() {
        swipeRefreshLayout?.isRefreshing = true
        viewModel.getAllCountries()
    }

    private fun saveToSharedPrefs(country: CountryDomain) {
        sharedPrefs.edit()
            .putString(RANDOM_COUNTRY_NAME, country.name)
            .putString(RANDOM_COUNTRY_FLAG, country.flag)
            .apply()
    }

    companion object {
        const val CURRENT_COUNTRY_ARG = "CURRENT_COUNTRY_ARG"
        const val RANDOM_COUNTRY_NAME = "RANDOM_COUNTRY_NAME"
        const val RANDOM_COUNTRY_FLAG = "RANDOM_COUNTRY_FLAG"
    }
}
