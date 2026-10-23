package com.kotlin.basic.trpl3c.api.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.basic.trpl3c.R
import com.kotlin.basic.trpl3c.api.models.CategoryModel
import com.squareup.picasso.Picasso

class CategoryMealAdapter(
    val listCategory: List<CategoryModel.Category>
) : RecyclerView.Adapter<CategoryMealAdapter.ViewCategory>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewCategory {
        return ViewCategory(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.category_meal_layout, parent, false)
        )
    }

    override fun onBindViewHolder( holder: CategoryMealAdapter.ViewCategory, position: Int) {
        val itemCategory = listCategory[position]
        Picasso.get()
            .load(itemCategory.strCategoryThumb)
            .into(holder.ivCategory)
        holder.tvNamaCategory.text = itemCategory.strCategory
    }

    override fun getItemCount(): Int = listCategory.size

    class ViewCategory(view: View) : RecyclerView.ViewHolder(view) {
        val ivCategory = view.findViewById<ImageView>(R.id.ivCategory)
        val tvNamaCategory = view.findViewById<TextView>(R.id.tvNamaCategory)

    }

}