package com.kotlin.basic.trpl3c.recycler

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.kotlin.basic.trpl3c.R

class DetailAksesorisActivity : AppCompatActivity() {
    private lateinit var ivAksesorisDetail: ImageView
    private lateinit var tvHargaAksesorisDetail: TextView
    private lateinit var tvNamaAksesorisDetail: TextView
    private lateinit var tvRatingAksesorisDetail: TextView
    private lateinit var tvDeskripsiAksesorisDetail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_aksesoris)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        ivAksesorisDetail = findViewById(R.id.ivAksesorisDetail)
        tvHargaAksesorisDetail = findViewById(R.id.tvHargaDetail)
        tvNamaAksesorisDetail = findViewById(R.id.tvNamaDetail)
        tvRatingAksesorisDetail = findViewById(R.id.tvRatingDetail)
        tvDeskripsiAksesorisDetail = findViewById(R.id.tvDeskripsiDetail)
    }
    override fun onStart() {
        super.onStart()
        showDetailAksesoris()
    }

    private fun showDetailAksesoris() {
        val gambar = intent.getIntExtra("gambar" + "", 0)
        val harga = intent.getStringExtra("harga")
        val nama = intent.getStringExtra("nama")
        val rating = intent.getFloatExtra("rating", 0.0f)
        val deskripsi = intent.getStringExtra("deskripsi")

        ivAksesorisDetail.setImageResource(gambar)
        tvHargaAksesorisDetail.text = harga
        tvNamaAksesorisDetail.text = nama
        tvRatingAksesorisDetail.text = rating.toString()
        tvDeskripsiAksesorisDetail.text = deskripsi
    }
}
