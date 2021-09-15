package com.example.tourismapp.ui.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.tourismapp.databinding.ActivityDetailBinding
import com.example.tourismapp.model.TourismPlace
import com.example.tourismapp.ui.main.MainActivity

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataTourism = intent.getParcelableExtra<TourismPlace>("DATA_TOURISM")

        with(binding){
            tvTitle.text = dataTourism?.name
            (dataTourism?.description?.subSequence(0, 200).toString() + "...").also { tvDesc.text = it }
            tvOpendays.text = dataTourism?.openDays
            tvOpentime.text = dataTourism?.openTime
            tvTotal.text = dataTourism?.ticketPrice

            Glide.with(this@DetailActivity)
                .load(dataTourism?.imageAsset)
                .into(ivPoster)

            ivBack.setOnClickListener{
                startActivity(Intent(this@DetailActivity, MainActivity::class.java))
            }
        }
    }
}