package com.example.gitstudying

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MainCategoryAdapter(val data: ArrayList<Category> ) :
    RecyclerView.Adapter<MainCategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v: View = inflater.inflate(R.layout.main_category_item, parent, false)
        return ViewHolder(v)
    }

    @SuppressLint("SuspiciousIndentation", "ClickableViewAccessibility")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = data[position]
            Glide
                .with(holder.itemView.context)
                .load(category.image)
                .placeholder(CustomShimmerDrawable().shimmerDrawable)
                .into(holder.imageCategory)
            holder.txtCategory.text = category.categoryName




    }

    override fun getItemCount(): Int {
        return data.size.coerceAtMost(7)
    }

    interface MainCategoryOnClick{
        fun mainCategoryOnClick(position : Int , categoryName : String)
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageCategory: ImageView
        val txtCategory: TextView
        val parentArea: LinearLayout

        init {
            imageCategory = itemView.findViewById(R.id.imageCategory)
            txtCategory = itemView.findViewById(R.id.txtCategory)
            parentArea = itemView.findViewById(R.id.parentArea)
        }
    }
}
