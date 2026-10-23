package com.kotlin.basic.trpl3c.ui.widget

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.kotlin.basic.trpl3c.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class RawatInapActivity : AppCompatActivity() {
    private lateinit var etRegister: EditText
    private lateinit var etNama: EditText
    private lateinit var etNIK: EditText
    private lateinit var etHP: EditText
    private lateinit var tvTgl: TextView
    private lateinit var tvJam: TextView
    private lateinit var spnKamar: Spinner
    private lateinit var rgKategoriPsn: RadioGroup
    private lateinit var etJlhHari: EditText
    private lateinit var cbBed: CheckBox
    private lateinit var cbSofa: CheckBox
    private lateinit var cbDispenser: CheckBox
    private lateinit var cbMakanan: CheckBox
    private lateinit var etBed: EditText
    private lateinit var etSofa: EditText
    private lateinit var etDispenser: EditText
    private lateinit var etMakanan: EditText
    private lateinit var btnSimpan: Button
    private lateinit var tvTotal: TextView

    private lateinit var timePicker: TimePickerDialog.OnTimeSetListener
    private lateinit var datePicker: DatePickerDialog.OnDateSetListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_rawat_inap)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        etRegister = findViewById(R.id.etRegister)
        etNama = findViewById(R.id.etNama)
        etNIK = findViewById(R.id.etNIK)
        etHP = findViewById(R.id.etHP)
        tvTgl = findViewById(R.id.tvTgl)
        tvJam = findViewById(R.id.tvJam)
        spnKamar = findViewById(R.id.spnKamar)
        rgKategoriPsn = findViewById(R.id.rgKategoriPsn)
        etJlhHari = findViewById(R.id.etJlhHari)
        cbBed = findViewById(R.id.cbBed)
        cbSofa = findViewById(R.id.cbSofa)
        cbDispenser = findViewById(R.id.cbDispenser)
        cbMakanan = findViewById(R.id.cbMakanan)
        etBed = findViewById(R.id.etBed)
        etSofa = findViewById(R.id.etSofa)
        etDispenser = findViewById(R.id.etDispenser)
        etMakanan = findViewById(R.id.etMakanan)
        btnSimpan = findViewById(R.id.btnSimpan)
        tvTotal = findViewById(R.id.tvTotal)
    }

    override fun onStart() {
        super.onStart()
        setupSpinnerKamar()
        setupDatePicker()
        setupTimePicker()
        total()
    }

    private fun setupTimePicker() {
        val myTime = Calendar.getInstance()
        timePicker = TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
            myTime[Calendar.HOUR_OF_DAY] = hourOfDay
            myTime[Calendar.MINUTE] = minute
            val formatIndo = SimpleDateFormat("HH:mm", Locale.getDefault()).format(myTime.time)
            tvJam.text = formatIndo
        }

        tvJam.setOnClickListener {
            TimePickerDialog(
                this,
                timePicker,
                myTime[Calendar.HOUR_OF_DAY],
                myTime[Calendar.MINUTE],
                true
            ).show()
        }
    }

    private fun setupDatePicker() {
        val myCalendar = Calendar.getInstance()
        datePicker = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            myCalendar[Calendar.YEAR] = year
            myCalendar[Calendar.MONTH] = month
            myCalendar[Calendar.DAY_OF_MONTH] = dayOfMonth
            val formatIndo = SimpleDateFormat("dd MMMM yyyy", Locale.Builder().setLanguage("id").setRegion("ID").build())
            tvTgl.text = formatIndo.format(myCalendar.time)
        }

        tvTgl.setOnClickListener {
            DatePickerDialog(
                this,
                datePicker,
                myCalendar[Calendar.YEAR],
                myCalendar[Calendar.MONTH],
                myCalendar[Calendar.DAY_OF_MONTH],
            ).show()
        }
    }

    private fun setupSpinnerKamar() {
        val listKamar = arrayOf(
            "Super VIP : Rp.750.000",
            "VIP : Rp.600.000",
            "Utama : Rp.400.000",
            "I : Rp.255.000",
            "II : Rp.170.000",
            "III : Rp. 160.000",
        )
        val adapter = ArrayAdapter(this, R.layout.spinner_style, listKamar)
        spnKamar.adapter = adapter
    }

    private fun total() {
        val listTambah = arrayOf(cbBed, cbSofa, cbDispenser, cbMakanan)
        val hargaTambah = intArrayOf(75_000, 60_000, 25_000, 45_000)
        val jlhTambah = arrayOf(etBed, etSofa, etDispenser, etMakanan)

        for (i in jlhTambah.indices) {
            jlhTambah[i].addTextChangedListener(object : TextWatcher {
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
                        listTambah[i].isChecked = !et.isNullOrEmpty()
                    }
                }
            })
        }

        btnSimpan.setOnClickListener {
            val jumlahHari = etJlhHari.text.toString().toIntOrNull() ?: 0

            val hargaKamar = when (spnKamar.selectedItemPosition) {
                0 -> 750_000
                1 -> 600_000
                2 -> 400_000
                3 -> 255_000
                4 -> 170_000
                5 -> 160_000
                else -> 0
            }

            val subtotalKamar = hargaKamar * jumlahHari

            var totalBiayaTambahan = 0
            val rincianTambahan = StringBuilder()
            for (i in listTambah.indices) {
                if (listTambah[i].isChecked) {
                    val qty = jlhTambah[i].text.toString().toIntOrNull() ?: 1
                    val subtotalTambah = hargaTambah[i] * qty * jumlahHari
                    totalBiayaTambahan += subtotalTambah
                    val labelItem = listTambah[i].text.toString()
                    rincianTambahan.append("+ ").append(labelItem).append("\n")
                }
            }

            val selectedKatId = rgKategoriPsn.checkedRadioButtonId
            val katPasien = if (selectedKatId != -1) {
                val selectedRadioButton = findViewById<RadioButton>(selectedKatId)
                selectedRadioButton.text.toString()
            } else {
                "Belum dipilih"
            }

            val diskonPersen = when (katPasien) {
                "BPJS" -> 0.10
                "Non BPJS" -> 0.05
                "Mandiri" -> 0.03
                else -> 0.0
            }

            val totalDiskon = (diskonPersen * subtotalKamar).toLong()

            val potongan = if (jumlahHari > 3) 50_000L else 0L

            val totalBiaya = subtotalKamar + totalBiayaTambahan - totalDiskon - potongan

            val noReg = etRegister.text.toString()
            val nama = etNama.text.toString()
            val nik = etNIK.text.toString()
            val hp = etHP.text.toString()
            val tgl = tvTgl.text.toString()
            val jam = tvJam.text.toString()
            val kelasKamar = spnKamar.selectedItem?.toString() ?: ""

            val rincian = StringBuilder()
                .append("No Reg : ").append(noReg).append("\n")
                .append("Nama Lengkap : ").append(nama).append("\n")
                .append("NIK : ").append(nik).append("\n")
                .append("HP : ").append(hp).append("\n")
                .append("Tanggal Masuk : ").append(tgl).append("\n")
                .append("Jam Masuk : ").append(jam).append("\n")
                .append("Kelas Kamar : ").append(kelasKamar).append("\n")
                .append("Kategori Pasien : ").append(katPasien).append("\n")
                .append("Jumlah Hari : ").append(jumlahHari).append("\n")

            if (rincianTambahan.isNotEmpty()) {
                rincian.append("Biaya Tambahan\n").append(rincianTambahan)
            }

            rincian.append("Total Bayar : ").append(totalBiaya)

            tvTotal.text = rincian.toString()
        }
    }
}