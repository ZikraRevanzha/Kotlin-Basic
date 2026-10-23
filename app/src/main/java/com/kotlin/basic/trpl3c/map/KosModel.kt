package com.kotlin.basic.trpl3c.map

import com.google.android.gms.maps.model.LatLng

data class KosModel(
    val koordinat: LatLng,
    val title: String,
    val snippet: String,
    val gambar: Int,
)
