package by.dzrvnsk.smartcountries.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import by.dzrvnsk.smartcountries.R
import by.dzrvnsk.smartcountries.model.CountryViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment() {

    private val countryViewModel: CountryViewModel by activityViewModels()

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
            countryViewModel.currentCountryLiveData.observe(viewLifecycleOwner, {
                val country = LatLng(it.latlng[0], it.latlng[1])
                googleMap.addMarker(
                    MarkerOptions()
                        .position(country)
                        .title("Marker in ${it.name.common}")
                )
                val zoom = when (it.area.toInt()) {
                    in 0..10000 -> 7f
                    in 10000..50000 -> 6f
                    in 50000..200000 -> 5f
                    in 200000..1000000 -> 4f
                    in 1000000..4000000 -> 3f
                    in 4000000..10000000 -> 2f
                    else -> 1f
                }
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(country, zoom))
            })
        }
    }
}