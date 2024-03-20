package com.example.and_km6_denyiqbalmubarok_challengechapter2.data.datasource

import com.example.and_km6_denyiqbalmubarok_challengechapter2.R
import com.example.and_km6_denyiqbalmubarok_challengechapter2.model.Category
import com.example.and_km6_denyiqbalmubarok_challengechapter2.model.MenuDetail

interface CategoryDataSource {
    fun getCategoryMembers(): List<Category>
}

class CategoryDataSourceImpl(): CategoryDataSource {
    override fun getCategoryMembers(): List<Category> {
        return mutableListOf(
            Category(image = R.drawable.img_rice, name = "Nasi"),
            Category(image = R.drawable.img_noddle, name = "Mie"),
            Category(image = R.drawable.img_snack, name = "Snack"),
            Category(image = R.drawable.img_drink, name = "Minuman"),
            Category(image = R.drawable.img_junkfood, name = "Junk Food"),
            Category(image = R.drawable.img_chicken_meat, name = "Daging Ayam"),
            Category(image = R.drawable.img_beef, name = "Daging Sapi"),
            Category(image = R.drawable.img_duck_meat, name = "Daging Bebek")
        )
    }
}
