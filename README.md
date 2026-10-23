# Kotlin Basic - Android Mobile Programming

[![Kotlin](https://img.shields.io/badge/Kotlin-2.0.0-purple?logo=kotlin)](https://kotlinlang.org/)
[![Android SDK](https://img.shields.io/badge/Min%20SDK-24-blue?logo=android)](https://developer.android.com/)
[![Target SDK](https://img.shields.io/badge/Target%20SDK-35%2B-green?logo=android)](https://developer.android.com/)
[![Gradle](https://img.shields.io/badge/Gradle-Kotlin%20DSL-02303A?logo=gradle)](https://gradle.org/)

Repository ini berisi kumpulan modul pembelajaran, latihan praktikum, dan implementasi fitur dasar hingga menengah dalam pengembangan aplikasi Android berbasis **Kotlin**. Project ini dikembangkan untuk mata kuliah **Pemrograman Mobile** (Semester 5 - Program Studi D4 Teknologi Rekayasa Perangkat Lunak, Kelas 3C).

---

## 📑 Daftar Isi
- [Fitur & Modul Utama](#-fitur--modul-utama)
- [Struktur Proyek](#-struktur-proyek)
- [Teknologi yang Digunakan](#-teknologi-yang-digunakan)
- [Cara Menjalankan Proyek](#-cara-menjalankan-proyek)
- [Konfigurasi Google Maps](#-konfigurasi-google-maps)
- [Kontributor](#-kontributor)

---

## 🚀 Fitur & Modul Utama

Project ini mencakup berbagai komponen inti dalam ekosistem Android:

### 1. Activity Lifecycle
- **`MainActivity`**: Pemahaman dan logging siklus hidup activity (`onCreate`, `onStart`, `onResume`, `onPause`, `onStop`, `onDestroy`).

### 2. UI Layouts (`ui.layout`)
- **Constraint Layout** (`ConstraintActivity`): Tata letak fleksibel dan responsif berbasis constraint.
- **Linear Layout** (`LinerActivity`): Penataan komponen secara linear (vertikal/horizontal).
- **Relative Layout** (`RelativeActivity`): Penataan komponen relatif terhadap parent dan elemen lainnya.
- **Table Layout** (`TableActivity`): Struktur tampilan baris dan kolom.
- **Scroll View** (`ScrollActivity`): Penanganan tampilan konten yang melebihi batas layar vertikal.

### 3. Form & UI Widgets (`ui.widget`)
- **Register Form** (`RegisterActivity`): Validasi input user (nama, email, password, no. telp, tanggal lahir, keahlian, jenjang pendidikan).
- **Perhitungan Nilai** (`NilaiActivity`): Form input nilai akademik dan penentuan grade.
- **Perhitungan Pembayaran** (`PembayaranActivity`): Perhitungan transaksi, diskon, dan total bayar.
- **Biaya Rawat Inap** (`RawatInapActivity`): Simulasi perhitungan biaya rumah sakit berdasarkan jenis kamar dan durasi.
- **Spinner, Date & Time Picker** (`SpinnerDateTimeActivity`): Dialog pemilihan tanggal, waktu, serta dropdown menu (Spinner).

### 4. Intent & Data Passing (`intent`)
- **Explicit Intent & Transfer Data** (`NilaiIntentActivity` & `NilaiAkhirActivity`): Pengiriman parameter/data antar activity dan pemrosesan hasil akhir.

### 5. RecyclerView & Adapters (`recycler`)
- **Katalog Aksesoris** (`AksesorisActivity` & `DetailAksesorisActivity`): List produk vertikal dengan custom view holder dan navigasi detail.
- **Daftar Buku** (`BukuActivity`): Tampilan katalog buku dengan adapter khusus.
- **Grid Layout & Detail** (`GridActivity` & `GridDetailActivity`): Implementasi `GridLayoutManager` untuk galeri item beserta halaman detailnya.
- **Flash Sale Item** (`FlashAdapter`): Tampilan penawaran promo / flashsale.

### 6. Menus & Popups (`menu`)
- **Popup Menu** (`PopUpActivity`): Penggunaan menu kontekstual dan aksi berbasis menu dialog.

### 7. Google Maps Integration (`map`)
- **Maps Basic** (`MapsActivity`): Inisialisasi peta Google Maps.
- **Custom Map Styling** (`MapsCustomActivity`): Pengaturan tema visual peta (Aubergine, Dark, Night, Retro, Silver, Standard) menggunakan konfigurasi JSON.
- **Multi Marker Interaktif** (`MapsMultiMarkerActivity`): Penanda lokasi jamak (Cafe, Kos, Lab, Masjid, Rumah, Sekolah, Hotel) dengan custom marker icon.

---

## 📂 Struktur Proyek

```text
Kotlin Basic/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/kotlin/basic/trpl3c/
│   │   │   │   ├── intent/          # Activity terkait perpindahan intent & data
│   │   │   │   ├── map/             # Google Maps & Custom Styling
│   │   │   │   ├── menu/            # Popup & Options Menu
│   │   │   │   ├── recycler/        # RecyclerView, Model, & Custom Adapter
│   │   │   │   ├── ui/
│   │   │   │   │   ├── layout/      # Implementasi jenis-jenis Layout
│   │   │   │   │   └── widget/      # Implementasi Widget, Input, & Form
│   │   │   │   └── MainActivity.kt  # Activity Lifecycle demonstration
│   │   │   └── res/
│   │   │       ├── layout/          # XML Layout files
│   │   │       ├── raw/             # Map JSON Styles (dark, retro, aubergine, dll)
│   │   │       ├── drawable/        # Asset grafis, ikon marker, & ilustrasi
│   │   │       └── values/          # Strings, colors, & themes
│   │   └── AndroidManifest.xml
│   └── build.gradle.kts
├── gradle/
│   └── libs.versions.toml           # Version Catalog dependensi
├── build.gradle.kts
└── settings.gradle.kts
```

---

## 🛠 Teknologi yang Digunakan

- **Bahasa Pemrograman**: [Kotlin](https://kotlinlang.org/)
- **Target SDK**: Android 35 / 37
- **Min SDK**: Android 24 (Nougat)
- **View Binding**: Diaktifkan untuk akses aman terhadap view layout
- **Google Play Services Maps**: `play-services-maps` untuk integrasi peta digital
- **AndroidX & Material Design**: Komponen antarmuka modern Material 3

---

## 💻 Cara Menjalankan Proyek

1. **Clone repository ini**:
   ```bash
   git clone https://github.com/ZikraRevanzha/Kotlin-Basic.git
   ```
2. **Buka project di Android Studio**:
   - Pilih **Open** lalu arahkan ke direktori hasil clone `Kotlin-Basic`.
3. **Sinkronisasi Gradle**:
   - Tunggu Android Studio mengunduh dependensi dan melakukan Gradle Sync.
4. **Jalankan Aplikasi**:
   - Sambungkan perangkat fisik Android melalui USB Debugging atau jalankan Android Virtual Device (AVD / Emulator).
   - Klik tombol **Run** (`Shift + F10`) di Android Studio.

---

## 🗺️ Konfigurasi Google Maps

Untuk mengaktifkan modul Google Maps:
1. Dapatkan API Key dari [Google Cloud Console](https://console.cloud.google.com/).
2. Aktifkan **Maps SDK for Android**.
3. Tambahkan API Key ke file `local.properties`:
   ```properties
   MAPS_API_KEY=AIzaSy...
   ```
4. Pastikan izin akses lokasi (`ACCESS_COARSE_LOCATION` / `ACCESS_FINE_LOCATION`) telah diizinkan pada perangkat.

---

## 👤 Kontributor

- **Nama**: Zikra Revanzha
- **Email**: [zikrarevanzha@gmail.com](mailto:zikrarevanzha@gmail.com)
- **GitHub**: [@ZikraRevanzha](https://github.com/ZikraRevanzha)
- **Program Studi**: D4 Teknologi Rekayasa Perangkat Lunak (TRPL) - Semester 5
