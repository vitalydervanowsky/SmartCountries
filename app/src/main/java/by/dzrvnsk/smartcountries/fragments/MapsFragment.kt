package by.dzrvnsk.smartcountries.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.dzrvnsk.smartcountries.R
import by.dzrvnsk.smartcountries.model.CountryViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.koin.android.viewmodel.ext.android.sharedViewModel

class MapsFragment : Fragment() {

    private val countryViewModel: CountryViewModel by sharedViewModel()

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
        mapFragment?.getMapAsync { googleMap ->
            countryViewModel.getCurrentCountryLiveData().observe(viewLifecycleOwner, { country ->
                val latLng = LatLng(country.latlng[0], country.latlng[1])
                googleMap.addMarker(
                    MarkerOptions()
                        .position(latLng)
                        .title(country.name.common)
                )
                val zoom = when (country.area.toInt()) {
                    in 0..2000 -> 8f
                    in 2000..10000 -> 7f
                    in 10000..50000 -> 6f
                    in 50000..200000 -> 5f
                    in 200000..1000000 -> 4f
                    in 1000000..4000000 -> 3f
                    in 4000000..10000000 -> 2f
                    else -> 1f
                }
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom))
            })
        }
    }
}