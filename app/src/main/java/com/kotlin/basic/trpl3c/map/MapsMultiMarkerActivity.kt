package com.kotlin.basic.trpl3c.map

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.kotlin.basic.trpl3c.R
import com.kotlin.basic.trpl3c.databinding.ActivityMapsMultiMakerBinding

class MapsMultiMakerActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsMultiMakerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMapsMultiMakerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val listKos = listOf<KosModel>(
            KosModel(
                LatLng(-0.29986405589752674, 100.37381478736448),
                "Rumah GW",
                "Ini adalah rumah saya",
                R.drawable.marker_rumah
            ),
            KosModel(
                LatLng(-0.9304260546675247, 100.43144053355803),
                "Kontrakan A",
                "Ini adalah kontrakan saya",
                R.drawable.marker_sekolah
            ),
            KosModel(
                LatLng(-0.9294322957303905, 100.42823917006615),
                "Kos A",
                "Ini adalah kos lama saya",
                R.drawable.marker_masjid
            ),
            KosModel(
                LatLng(-0.9265300535373736, 100.43227635266601),
                "Kost Bu Emerni (Kost Cowok)",
                "Ps. Baru, Jl. Dr. Moh. Hatta Kel Gang V No.9, RT.04/RW.01, Cupak Tangah, Kec. Pauh, Kota Padang, Sumatera Barat 25162",
                R.drawable.marker_cafe
            ),
            KosModel(
                LatLng(-0.9253590626677545, 100.44000162253631),
                "Kost Putra (UNIVERSITAS ANDALAS - kp. Duri)",
                "Jl. Kampung Duri No.10, Kapala Koto, Kec. Pauh, Kota Padang, Sumatera Barat 25163",
                R.drawable.marker_lab
            )
        )

        // Add markers for each kos and move the camera
        listKos.forEach { kos ->
            mMap.addMarker(
                MarkerOptions().position(
                    kos.koordinat).title(kos.title).snippet(kos.snippet).icon(
                    BitmapDescriptorFactory.fromResource(kos.gambar)))
        }

        // Add a marker in Rumah and move the camera
        val titiktengah = LatLng(-0.9273717230294701, 100.43444109747323)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(titiktengah, 15.0f))

    }
}