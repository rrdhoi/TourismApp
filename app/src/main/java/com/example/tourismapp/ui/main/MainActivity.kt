package com.example.tourismapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tourismapp.databinding.ActivityMainBinding
import android.content.Intent
import android.view.animation.OvershootInterpolator
import com.example.tourismapp.ui.ProfileActivity
import com.example.tourismapp.utils.TourismData
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter
import jp.wasabeef.recyclerview.animators.OvershootInLeftAnimator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var tourismData : TourismData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tourismData = TourismData

        showRecyclerList()
        showRecyclerSchedule()

        binding.profileImage.setOnClickListener{
            startActivity(Intent(this@MainActivity, ProfileActivity::class.java))
        }
    }

    private fun showRecyclerList() {
        binding.rvTravel.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        val listTravelAdapter = TourismAdapter()
        listTravelAdapter.setDataTourism(tourismData.tourismPlaceList)

        binding.rvTravel.adapter = ScaleInAnimationAdapter(listTravelAdapter).apply {
            setDuration(1000)
            setInterpolator(OvershootInterpolator())
            setFirstOnly(false)
        }

    }

    private fun showRecyclerSchedule() {
        binding.rvSchedule.layoutManager = LinearLayoutManager(this)
        val listTravelAdapter = TourismPopularAdapter()
        listTravelAdapter.setDataTourism(tourismData.tourismPlaceList)
        binding.rvSchedule.adapter = ScaleInAnimationAdapter(listTravelAdapter).apply {
            setDuration(1000)
            setInterpolator(OvershootInterpolator())
            setFirstOnly(false)
        }
    }
}