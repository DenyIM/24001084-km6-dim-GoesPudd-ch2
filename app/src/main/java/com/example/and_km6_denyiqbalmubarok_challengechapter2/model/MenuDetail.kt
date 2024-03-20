package com.example.and_km6_denyiqbalmubarok_challengechapter2.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize
import java.util.UUID

@Parcelize
data class MenuDetail(
    @DrawableRes
    var image: Int,
    var name: String,
    var desc: String,
    var shopLoc: String,
    var price: Double,
    var mapsLoc: String
): Parcelable
