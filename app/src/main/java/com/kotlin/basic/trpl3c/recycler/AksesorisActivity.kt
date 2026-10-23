package com.kotlin.basic.trpl3c.recycler

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.basic.trpl3c.R

class AksesorisActivity : AppCompatActivity() {
    private lateinit var rvAksesoris: RecyclerView
    private lateinit var rvFlash: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_aksesoris)
        rvAksesoris = findViewById(R.id.rvAksesoris)
        rvFlash = findViewById(R.id.rvFlash)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    override fun onStart() {
        super.onStart()
        showAksesoris()
        showFlashSale()
    }

    private fun showAksesoris() {
        val listAksesoris = listOf(
            AksesorisModel(
                R.drawable.img_aksesoris1,
                "GAMEN Titan Elite Keyboard Mechanical 78 Keys – RGB Light, 3 Pin Hot-Swappable, Ergonomic Design, Full Anti-Ghosting, Keyboard Gaming Mekanik Original",
                "Rp311.499",
                4.9f,
                "KAB. TANGERANG",
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua."),
            AksesorisModel(
                R.drawable.img_aksesoris2,
                "Fantech Kanata Wireless Gaming Mouse WG9",
                "Rp189.900 - Rp279.000",
                4.9f,
                "KOTA JAKARTA BARAT",
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua."),
            AksesorisModel(
                R.drawable.img_aksesoris3,
                "Fantech FLASH HQ53 Gaming Headset LED Lighting with Mic Volume Control Headset Wired Dual 3.5mm USB Driver 50mm Headphone Game PC Laptop",
                "Rp179.900\n",
                4.8f,
                "KOTA JAKARTA BARAT",
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.")
        )
        rvAksesoris.adapter = AksesorisAdapter(listAksesoris)
    }

    private fun showFlashSale() {
        val listFlash = listOf(
            FlashModel(
                R.drawable.img_flashsale1,
                "ISKU Dongkrak Gunting Mobil 2T / 3T Baja Karbon Solid, Kapasitas Beban Ekstra, Tinggi 100-390mm, Kepala Putar 360°, Gagang Ratchet Berlapis Karet, Hemat Tenaga &amp; Stabil",
                "Rp47.405",
                4.8f,
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea",
                ),
            FlashModel(
                R.drawable.img_flashsale2,
                "[10.10 s/d 20%*] HUAWEI WATCH FIT 5 Series | Titanium* | Studi Risiko Diabetes & ECG* | Olahraga Outdoor Tingkat Lanjut*",
                "Rp2.093.000",
                5.0f,
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea"),
            FlashModel(
                R.drawable.img_flashsale3,
                "Mesin Pembuat Kopi Espresso Mini Manual Portable / Manual Coffee Maker Cocok Untuk Traveling Outdoor",
                "Rp151.906",
                4.7f,
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea")
        )
        rvFlash.adapter = FlashAdapter(listFlash)
    }
}