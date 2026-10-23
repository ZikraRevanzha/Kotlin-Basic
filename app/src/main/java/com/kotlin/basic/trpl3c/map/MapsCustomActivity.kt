package com.kotlin.basic.trpl3c.map

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions
import com.kotlin.basic.trpl3c.R
import com.kotlin.basic.trpl3c.databinding.ActivityMapsCustomBinding

class MapsCustomActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsCustomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMapsCustomBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setSupportActionBar(binding.tbThemeMap)
        // Menyembunyikan title pada toolbar
        supportActionBar?.setDisplayShowTitleEnabled(false)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.theme_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.themeStandart -> {
                mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
                setThemeMap(R.raw.standard_map)
                true
            }
            R.id.themeSilver -> {
                mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
                setThemeMap(R.raw.silver_map)
                true
            }
            R.id.themeRetro -> {
                mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
                setThemeMap(R.raw.retro_map)
                true
            }
            R.id.themeDark -> {
                mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
                setThemeMap(R.raw.dark_map)
                true
            }
            R.id.themeNight -> {
                mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
                setThemeMap(R.raw.night_map)
                true
            }
            R.id.themeAubergine -> {
                mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
                setThemeMap(R.raw.aubergine_map)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun setThemeMap(fileJsonTheme: Int){
        mMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(
            this,
            fileJsonTheme))
    }

    fun tipeMapNormal(){
        binding.fabNormal.setOnClickListener{
            mMap.mapType = GoogleMap.MAP_TYPE_NORMAL }
    }

    fun tipeMapSatellite(){
        binding.fabSatellite.setOnClickListener{
            mMap.mapType = GoogleMap.MAP_TYPE_SATELLITE }
    }

    fun tipeMapTerrain(){
        binding.fabTerrain.setOnClickListener{
            mMap.mapType = GoogleMap.MAP_TYPE_TERRAIN }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val listHotel = listOf(
            HotelModel(
                LatLng(-0.9335820006645288, 100.35294104480904),
                "Mercure Padang",
                "Jl. Purus IV No.8, Purus, Kec. Padang Bar., Kota Padang, Sumatera Barat 25115",
                4.5f,
                "Rp 750.000",
                R.drawable.hotel
            ),
            HotelModel(
                LatLng(-0.941536827847352, 100.35849761128964),
                "Hotel Santika Premiere Padang",
                "Jl. Jend. A Yani No.20, Olo, Kec. Padang Bar., Kota Padang, Sumatera Barat 25117",
                4.7f,
                "Rp 900.000",
                R.drawable.hotel2
            )
        )

        val ttktingeh = LatLng(-0.9392546091138226, 100.35554934834305)
        for (i in listHotel) {
            val marker = mMap.addMarker(
                MarkerOptions()
                    .position(i.koordinat)
                    .title(i.namaTempat)
            )
            // Simpan Data Marker Dalam Tag
            marker?.tag = i
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ttktingeh, 15f))

        // Handler saat Marker diklik
        mMap.setOnMarkerClickListener { marker ->
            val hotel = marker.tag as? HotelModel
            if (hotel != null) {
                showMarkerDetail(hotel)
            }
            false
        }
        mMap.setOnMapClickListener {
            // Sembunyikan CardView Detail
            binding.cvDetail.visibility = View.GONE
        }
        tipeMapNormal()
        tipeMapSatellite()
        tipeMapTerrain()
    }

    // Fungsi Menampilkan Detail Hotel Ketika DiKlik
    private fun showMarkerDetail(hotelModel: HotelModel) {
        binding.tvNamaTempat.text = hotelModel.namaTempat
        binding.tvAlamat.text = hotelModel.alamat
        binding.rbHotel.rating = hotelModel.rating
        binding.tvHarga.text = hotelModel.harga
        binding.ivHotel.setImageResource(hotelModel.gambar)

        // Tampilkan CardView Detail
        binding.cvDetail.visibility = View.VISIBLE
    }
}