package com.kotlin.basic.trpl3c.ui.widget

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.kotlin.basic.trpl3c.R

class PembayaranActivity : AppCompatActivity() {
    private lateinit var cbNasgor: CheckBox
    private lateinit var cbMiegor: CheckBox
    private lateinit var cbSoto: CheckBox
    private lateinit var cbLontong: CheckBox
    private lateinit var cbAGep: CheckBox

    private lateinit var etNasgor: EditText
    private lateinit var etMiegor: EditText
    private lateinit var etSoto: EditText
    private lateinit var etLontong: EditText
    private lateinit var etAGep: EditText
    private lateinit var spnJnsPelanggan: Spinner

    private lateinit var btnBayar: Button
    private lateinit var tvTotal: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pembayaran)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        cbNasgor = findViewById(R.id.cbNasgor)
        cbMiegor = findViewById(R.id.cbMiegor)
        cbSoto = findViewById(R.id.cbSoto)
        cbLontong = findViewById(R.id.cbLontong)
        cbAGep = findViewById(R.id.cbAGep)
        etNasgor = findViewById(R.id.etNasgor)
        etMiegor = findViewById(R.id.etMiegor)
        etSoto = findViewById(R.id.etSoto)
        etLontong = findViewById(R.id.etLontong)
        etAGep = findViewById(R.id.etAGep)
        spnJnsPelanggan = findViewById(R.id.spnJnsPelanggan)
        btnBayar = findViewById(R.id.btnBayar)
        tvTotal = findViewById(R.id.tvTotal)
    }

    override fun onStart() {
        super.onStart()
        jnsPelanggan()
        bayar()
    }

    private fun jnsPelanggan() {
        val listJnsPelanggan = arrayOf("VIP", "Member", "Reguler")
        spnJnsPelanggan.adapter = ArrayAdapter(this, R.layout.spinner_style, listJnsPelanggan)
    }

    private fun bayar() {
        // Variabel Untuk List Makanan
        val listMakanan = arrayOf(cbNasgor, cbMiegor, cbSoto, cbLontong, cbAGep)

        // Variabel Harga
        val hargaMakanan = intArrayOf(12_000, 10_000, 12_000, 8_000, 15_000)

        // Variabel Jumlah Makanan
        val jlhMakanan = arrayOf(etNasgor, etMiegor, etSoto, etLontong, etAGep)

        for (i in jlhMakanan.indices) {
            jlhMakanan[i].addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(p0: Editable?) {}

                override fun beforeTextChanged(
                    p0: CharSequence?,
                    p1: Int,
                    p2: Int,
                    p3: Int
                ) {}

                override fun onTextChanged(
                    et: CharSequence?,
                    p1: Int,
                    p2: Int,
                    p3: Int
                ) {
                    if (et.toString() != "0") {
                        listMakanan[i].isChecked = !et.isNullOrEmpty()
                    }
                }
            })
        }

        btnBayar.setOnClickListener {
            var totalBayar = 0.0
            var pilMakanan = ""
            val pelanggan = spnJnsPelanggan.selectedItem?.toString() ?: ""
            val diskon = when (pelanggan) {
                "VIP" -> 0.02
                "Member" -> 0.01
                else -> 0.0
            }
            for (i in listMakanan.indices) {
                // Cek Apakah Checkbox Sudah Dicentang Atau Belum
                if (listMakanan[i].isChecked) {
                    val jlhMkn = jlhMakanan[i].text.toString().toIntOrNull() ?: 0
                    pilMakanan += "${listMakanan[i].text} x ${jlhMakanan[i].text} = Rp. ${jlhMkn * hargaMakanan[i]}\n"
                    totalBayar += jlhMkn * hargaMakanan[i]
                }
            }

            val potonganHarga = if (totalBayar >= 150_000) 1_000 else 0
            val totalDiskon = totalBayar * diskon
            totalBayar -= totalDiskon
            totalBayar -= potonganHarga
            val pembayaran = "Pilihan Makanan : \n$pilMakanan\nTotal Diskon : Rp. $totalDiskon\nPotongan Harga : Rp. $potonganHarga" +
                    "\nJenis Pelanggan : $pelanggan\nTotal Harga : Rp. $totalBayar\n"
            tvTotal.text = pembayaran
        }
    }
}