package com.kotlin.basic.trpl3c.recycler

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.basic.trpl3c.R

class BukuActivity : AppCompatActivity() {
    private lateinit var rvBuku: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_buku)
        rvBuku = findViewById(R.id.rvBuku)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onStart() {
        super.onStart()
        showBuku()
    }

    private fun showBuku() {
        val listBuku = listOf(
            BukuModel(
                R.drawable.img_buku1,
                "Si Putih",
                "Tere Liye",
                "Rp. 98.100",
                "Stok: 80"
            ),
            BukuModel(
                R.drawable.img_buku2,
                "Doraemon 25 (2026)",
                "Fujiko F. Fujio",
                "Rp. 33.750",
                "Stok: 30"
            ),
            BukuModel(
                R.drawable.img_buku3,
                "Dr. Stone 20",
                "Riichiro Inagaki",
                "Rp. 45.000",
                "Stok: 50"
            ),
            BukuModel(
                R.drawable.img_buku4,
                "Metode Penelitian Kuantitatif dan Kualitatif : Perencanaan, Pelaksanaan, dan Evaluasi",
                "Sri Rahayu, M.Pd. & Muhammad Iqbal Al Qodri, S.Pd.",
                "Rp. 53.550",
                "Stok: 100"
            ),
        )
        rvBuku.adapter = BukuAdapter(listBuku)
    }
}
