package com.rsp.hbm.Fragments

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.IntentSender
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.PagerSnapHelper
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.tasks.Task
import com.rsp.hbm.Hall
import com.rsp.ohb.R
import com.rsp.hbm.adapters.HomeItemsAdapter
import com.rsp.ohb.databinding.FragmentMapBinding

class MapFragment : Fragment(), OnMapReadyCallback {
    lateinit var binding: FragmentMapBinding

    lateinit var googleMap: GoogleMap
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMapBinding.inflate(layoutInflater)
        val list = ArrayList<Hall>()
        list.add(
            Hall(
                "Shehnai Palace Marriage Hall",
                "Jaranwala Rd, Lahore, Punjab",
                "https://media.zameen.com/thumbnails/209607-800x600.jpeg"
            )
        )
        list.add(
            Hall(
                "Hajvery Shahdi Hall & Garden",
                "Nain Sukh, Lahore, Punjab",
                "https://mashriqtv.pk/en/wp-content/uploads/2022/02/wedding-hall.jpg"
            )
        )

        list.add(
            Hall(
                "Dream Palace Marriage Halls",
                "Kot Abdul Malik, Lahore, Punjab",
                "https://www.chennaiconventioncentre.com/wp-content/uploads/2018/11/wedding-hall.jpg"
            )
        )



        binding.apply {
            trendingRecView.adapter = HomeItemsAdapter(requireActivity(), list)
            PagerSnapHelper().attachToRecyclerView(trendingRecView)
            val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
            mapFragment.getMapAsync(this@MapFragment)
        }

        //required to get GPS Details


        //required to get GPS Details
        fusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(requireActivity())
        locationRequest = LocationRequest.create()
        locationRequest!!.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        locationRequest!!.interval = 5000
        locationRequest!!.fastestInterval = 2000



        if (isGPSAvailable()) {
            getLocation(null)
        } else {
            turnOnGPS()
        }


        return binding.root
    }

    private fun turnOnGPS() {
        val builder = LocationSettingsRequest.Builder().addLocationRequest(
            locationRequest!!
        )
        builder.setAlwaysShow(true)
        val result = LocationServices.getSettingsClient(requireContext())
            .checkLocationSettings(builder.build())
        result.addOnCompleteListener { task: Task<LocationSettingsResponse> ->
            try {
                val response =
                    task.getResult(ApiException::class.java)
                if (response.locationSettingsStates!!.isLocationPresent) {
                    getLocation(null)
                }
            } catch (e: ApiException) {
                e.printStackTrace()
                if (e.statusCode == LocationSettingsStatusCodes.RESOLUTION_REQUIRED) {
                    val apiException = e as ResolvableApiException
                    try {
                        apiException.startResolutionForResult(requireActivity(), 76)
                    } catch (ex: IntentSender.SendIntentException) {
                        ex.printStackTrace()
                    }
                }
            }
        }
    }


    private fun isGPSAvailable(): Boolean {
        val locationManager =
            requireActivity().getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
    }


    var fusedLocationProviderClient: FusedLocationProviderClient? = null
    var locationRequest: LocationRequest? = null
    private fun requestPermission() {
        val per = arrayOf(
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_BACKGROUND_LOCATION,
            Manifest.permission.ACCESS_LOCATION_EXTRA_COMMANDS,
            Manifest.permission.ACCESS_FINE_LOCATION
        )
        val REQUEST_CODE = 121
        ActivityCompat.requestPermissions(
            requireActivity(),
            per,
            REQUEST_CODE
        )
    }

    var latitude = 0.000;
    var longitude = 0.000;

    private fun getLocation(map: GoogleMap?) {
        if (ActivityCompat.checkSelfPermission(
                requireActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireActivity(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermission()
        } else {
            fusedLocationProviderClient!!.lastLocation.addOnSuccessListener { location: Location? ->
                if (location != null) {
                    latitude = location.latitude
                    longitude = location.longitude
                    val isFirst = booleanArrayOf(true)
                    if (isGPSAvailable()) {
                        if (googleMap != null) {
                            //            getLocation(map);
                            googleMap.isMyLocationEnabled = true
                            googleMap.setOnMyLocationChangeListener { location ->
                                if (isFirst[0]) {
                                    val currentLatLng =
                                        LatLng(location.latitude, location.longitude)
                                    val update =
                                        CameraUpdateFactory.newLatLngZoom(currentLatLng, 15f)
                                    googleMap.moveCamera(update)
                                    isFirst[0] = false
                                }
                            }
                        }

                    } else {
                        turnOnGPS()
                    }
                }
            }
        }
    }

    @SuppressLint("MissingPermission")
    override fun onMapReady(map: GoogleMap) {
        googleMap = map


    }

}