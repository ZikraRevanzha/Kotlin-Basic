package com.kotlin.basic.trpl3c.recycler

import com.kotlin.basic.trpl3c.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BukuAdapter(
    val listBuku: List<BukuModel>
): RecyclerView.Adapter<BukuAdapter.ViewBuku>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BukuAdapter.ViewBuku {
        return ViewBuku(LayoutInflater.from(parent.context).inflate(R.layout.buku_layout, parent, false))
    }

    override fun onBindViewHolder(holder: BukuAdapter.ViewBuku, position: Int) {
        val itemBuku = listBuku[position]
        holder.ivBuku.setImageResource(itemBuku.gambarBuku)
        holder.tvJudulBuku.text = itemBuku.judulBuku
        holder.tvPenulis.text = itemBuku.penulis
        holder.tvHarga.text = itemBuku.harga
        holder.tvStok.text = itemBuku.stok
    }

    override fun getItemCount(): Int = listBuku.size

    class ViewBuku(view: android.view.View): RecyclerView.ViewHolder(view) {
        val ivBuku = view.findViewById<ImageView>(R.id.ivBuku)
        val tvJudulBuku = view.findViewById<TextView>(R.id.tvJudulBuku)
        val tvPenulis = view.findViewById<TextView>(R.id.tvPenulis)
        val tvHarga = view.findViewById<TextView>(R.id.tvHarga)
        val tvStok = view.findViewById<TextView>(R.id.tvStok)
    }
}
