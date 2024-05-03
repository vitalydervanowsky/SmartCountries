package by.dzrvnsk.smartcountries.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.dzrvnsk.smartcountries.R
import by.dzrvnsk.smartcountries.domain.CountryDomain
import by.dzrvnsk.smartcountries.presentation.fragments.countrylist.CountryListFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        val country =
            arguments?.getSerializable(CountryListFragment.CURRENT_COUNTRY_ARG) as? CountryDomain
        mapFragment?.getMapAsync { googleMap ->
            val latLng = LatLng(country?.countryLat ?: 0.0, country?.countryLng ?: 0.0)
            googleMap.addMarker(
                MarkerOptions()
                    .position(latLng)
                    .title(country?.name)
            )
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom(country)))
        }
    }

    private fun zoom(country: CountryDomain?) = when (country?.area?.toInt()) {
        in 0..2000 -> 8f
        in 2000..10000 -> 7f
        in 10000..50000 -> 6f
        in 50000..200000 -> 5f
        in 200000..1000000 -> 4f
        in 1000000..4000000 -> 3f
        in 4000000..10000000 -> 2f
        else -> 1f
    }

    companion object {
        fun newInstance(country: CountryDomain?): MapsFragment {
            val args = Bundle()
            args.putSerializable(CountryListFragment.CURRENT_COUNTRY_ARG, country)
            val fragment = MapsFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
