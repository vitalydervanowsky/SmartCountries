package by.dzrvnsk.smartcountries.presentation.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import by.dzrvnsk.smartcountries.R
import by.dzrvnsk.smartcountries.domain.CountryDomain
import by.dzrvnsk.smartcountries.presentation.fragments.countrylist.CountryListFragment
import com.bumptech.glide.Glide
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

class DetailsFragment : Fragment() {

    private var country: CountryDomain? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        country =
            arguments?.getSerializable(CountryListFragment.CURRENT_COUNTRY_ARG) as? CountryDomain
        initViews(view)
    }

    private fun initViews(view: View) {
        view.apply {
            Glide.with(requireContext())
                .load(country?.flag)
                .into(findViewById(R.id.imageView))
            view.findViewById<TextView>(R.id.countryNameTextView).text = country?.name
            view.findViewById<TextView>(R.id.countryNameOfficialTextView).apply {
                text = country?.nameOfficial
                setOnClickListener {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(country?.openStreetMaps)
                        )
                    )
                }
            }
            view.findViewById<TextView>(R.id.countryCapitalTextView).apply {
                country?.capital.let {
                    text = it
                    visibility = View.VISIBLE
                }
                setOnClickListener {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(
                                "geo:${country?.capitalLat},${country?.capitalLng}?z=11"
                            )
                        ).apply {
                            setPackage("com.google.android.apps.maps")
                        }
                    )
                }
            }

            val region = "${country?.region}, ${country?.subregion}"
            view.findViewById<TextView>(R.id.countryRegionTextView).text = region
            val decimalFormat = DecimalFormat("#,##0").apply {
                decimalFormatSymbols = DecimalFormatSymbols.getInstance(Locale.getDefault())
                decimalFormatSymbols.groupingSeparator = ' '
            }
            view.findViewById<TextView>(R.id.countryAreaTextView).text = getString(
                R.string.area_text,
                decimalFormat.format(country?.area?.toInt() ?: 0)
            )
            view.findViewById<TextView>(R.id.populationTextView).text = getString(
                R.string.population_text,
                decimalFormat.format(country?.population ?: 0)
            )
        }

//        parentFragmentManager.beginTransaction()
//            .add(R.id.map_container, MapsFragment.newInstance(country))
//            .commit()
    }
}
