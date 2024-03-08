package com.example.and_km6_denyiqbalmubarok_challengechapter2.model

import androidx.annotation.DrawableRes
import java.util.UUID

data class Menu(
    var id: String = UUID.randomUUID().toString(),
    @DrawableRes
    var image: Int,
    var name: String,
    var price: Double
)
