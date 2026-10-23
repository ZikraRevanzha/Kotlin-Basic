package com.kotlin.basic.trpl3c.intent

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.kotlin.basic.trpl3c.R

class NilaiAkhirActivity : AppCompatActivity() {
    private lateinit var tvNIM: TextView
    private lateinit var tvNama: TextView
    private lateinit var tvProdi: TextView
    private lateinit var tvJk: TextView
    private lateinit var tvWaktu: TextView
    private lateinit var tvKhd: TextView
    private lateinit var tvTgs: TextView
    private lateinit var tvUTS: TextView
    private lateinit var tvUAS: TextView
    private lateinit var tvNAkhir: TextView
    private lateinit var tvNHuruf: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nilai_akhir)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        tvNIM = findViewById(R.id.tvNIM)
        tvNama = findViewById(R.id.tvNama)
        tvProdi = findViewById(R.id.tvProdi)
        tvJk = findViewById(R.id.tvJk)
        tvWaktu = findViewById(R.id.tvWaktu)
        tvKhd = findViewById(R.id.tvKhd)
        tvTgs = findViewById(R.id.tvTgs)
        tvUTS = findViewById(R.id.tvUTS)
        tvUAS = findViewById(R.id.tvUAS)
        tvNAkhir = findViewById(R.id.tvNAkhir)
        tvNHuruf = findViewById(R.id.tvNHuruf)
    }

    override fun onStart() {
        super.onStart()
        nilai()
    }

    private fun nilai() {
        val nim = intent.getStringExtra("Nim")
        val nama = intent.getStringExtra("Nama")
        val prodi = intent.getStringExtra("Prodi")
        val jk = intent.getStringExtra("Jenis Kelamin")
        val waktu = intent.getStringExtra("Waktu")
        val khd = intent.getIntExtra("Kehadiran", 0)
        val tgs = intent.getIntExtra("Tugas", 0)
        val uts = intent.getIntExtra("UTS", 0)
        val uas = intent.getIntExtra("UAS", 0)
        val nilaiAngka = intent.getDoubleExtra("Nilai Angka", 0.0)
        val nilaiHuruf = intent.getStringExtra("Nilai Huruf")

        tvNIM.text = "NIM : $nim"
        tvNama.text = "Nama : $nama"
        tvProdi.text = "Prodi : $prodi"
        tvJk.text = "Jenis Kelamin : $jk"
        tvWaktu.text = "Waktu : $waktu"
        tvKhd.text = "Kehadiran : $khd"
        tvTgs.text = "Tugas : $tgs"
        tvUTS.text = "UTS : $uts"
        tvUAS.text = "UAS : $uas"
        tvNAkhir.text = "Nilai Akhir : $nilaiAngka"
        tvNHuruf.text = "Nilai Huruf : $nilaiHuruf"
    }
}