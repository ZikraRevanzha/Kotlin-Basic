package com.kotlin.basic.trpl3c.recycler

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.kotlin.basic.trpl3c.R

class GridDetailActivity : AppCompatActivity() {
    private lateinit var ivGambar: ImageView
    private lateinit var tvNamaProduk: TextView
    private lateinit var tvHarga: TextView
    private lateinit var tvRating: TextView
    private lateinit var tvTerjual: TextView
    private lateinit var tvDeskripsi: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_grid_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
        ivGambar = findViewById(R.id.ivGambar)
        tvHarga = findViewById(R.id.tvHarga)
        tvNamaProduk = findViewById(R.id.tvNamaProduk)
        tvRating = findViewById(R.id.tvRating)
        tvTerjual = findViewById(R.id.tvTerjual)
        tvDeskripsi = findViewById(R.id.tvDeskripsi)
    }

    override fun onStart() {
        super.onStart()
        showDetailAksesoris()
    }

    private fun showDetailAksesoris() {
        val gambar = intent.getIntExtra("gambar", 0)
        val harga = intent.getStringExtra("harga")
        val nama = intent.getStringExtra("nama")
        val rating = intent.getFloatExtra("rating", 0.0f)
        val terjual = intent.getStringExtra("terjual")
        val deskripsi = intent.getStringExtra("deskripsi")

        ivGambar.setImageResource(gambar)
        tvHarga.text = harga
        tvNamaProduk.text = nama
        tvRating.text = rating.toString()
        tvTerjual.text = "$terjual Terjual"
        tvDeskripsi.text = deskripsi
    }
}
