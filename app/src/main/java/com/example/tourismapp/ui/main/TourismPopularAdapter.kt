package com.example.tourismapp.ui.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tourismapp.R
import com.example.tourismapp.model.TourismPlace
import com.example.tourismapp.ui.detail.DetailActivity

class TourismPopularAdapter :
    RecyclerView.Adapter<TourismPopularAdapter.ListViewHolder>() {

    private var listTourism = ArrayList<TourismPlace>()

    fun setDataTourism(tourism: List<TourismPlace>?) {
        if (tourism == null) {
            return
        }
        this.listTourism.clear()
        this.listTourism.addAll(tourism)
    }
    
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_popular, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) =
        holder.bind(listTourism[position])

    override fun getItemCount(): Int = listTourism.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        private var tvLocation: TextView = itemView.findViewById(R.id.country)
        private var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        private var tvPrice: TextView = itemView.findViewById(R.id.price)


        fun bind(tourism: TourismPlace) {
            tvName.text = tourism.name
            tvLocation.text = tourism.location
            tvPrice.text = tourism.ticketPrice
            Glide.with(itemView.context)
                .load(tourism.imageAsset)
                .into(imgPhoto)

            itemView.setOnClickListener {
                val tourismDetail = Intent(itemView.context, DetailActivity::class.java).putExtra("DATA_TOURISM", tourism)
                itemView.context.startActivities(arrayOf(tourismDetail))
            }
        }

    }
}