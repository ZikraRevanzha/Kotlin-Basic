package com.kotlin.basic.trpl3c.api.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.basic.trpl3c.R
import com.kotlin.basic.trpl3c.api.models.ProductModel
import com.squareup.picasso.Picasso

class ProductAdapter(
    val listProduct: List<ProductModel.Product>?
) : RecyclerView.Adapter<ProductAdapter.ViewProduct>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewProduct {
        return ViewProduct(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.product_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewProduct, position: Int) {
        val itemProduct = listProduct?.get(position)
        val imageList = itemProduct?.images
        if (!imageList.isNullOrEmpty()) {
            Picasso.get()
                .load(imageList[0])
                .into(holder.ivProduct)
        }
        holder.tvTitle.text = itemProduct?.title
        holder.tvPrice.text = "$ ${itemProduct?.price}"
        holder.rbProduct.rating = itemProduct?.rating?.toFloat() ?: 0f
    }

    override fun getItemCount(): Int = listProduct?.size ?: 0

    class ViewProduct(view: View) : RecyclerView.ViewHolder(view) {
        val ivProduct = view.findViewById<ImageView>(R.id.ivProduct)
        val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        val tvPrice = view.findViewById<TextView>(R.id.tvPrice)
        val rbProduct = view.findViewById<RatingBar>(R.id.rbProduct)
    }
}
