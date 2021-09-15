package com.example.tourismapp.model
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TourismPlace(
    val name:String,
    val location: String,
    val description: String,
    val openDays: String,
    val openTime: String,
    val ticketPrice: String,
    val imageAsset: Int,
    val imageUrls: List<String>,
): Parcelable