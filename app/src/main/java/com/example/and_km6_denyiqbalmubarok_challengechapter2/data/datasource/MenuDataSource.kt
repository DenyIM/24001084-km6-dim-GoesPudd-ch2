package com.example.and_km6_denyiqbalmubarok_challengechapter2.data.datasource

import com.example.and_km6_denyiqbalmubarok_challengechapter2.R
import com.example.and_km6_denyiqbalmubarok_challengechapter2.model.MenuDetail

interface MenuDataSource {
    fun getMenuDetailMembers(): List<MenuDetail>
}

class MenuDataSourceImpl(): MenuDataSource {

    override fun getMenuDetailMembers(): List<MenuDetail> {
        return mutableListOf(
            MenuDetail(image = R.drawable.img_grilled_chicken, name = "Ayam Bakar", desc = "Ayam Bakar Khas Pak Mail", shopLoc = "Loc1", price = 50000.0, mapsLoc = "https://www.google.com/maps/place/The+Breeze+BSD+City/@-6.3013244,106.6533703,17z/data=!4m6!3m5!1s0x2e69fb03fd576c99:0xf5e7f5736ced52fa!8m2!3d-6.3013244!4d106.6533703!16s%2Fg%2F11fjtgndvf?entry=ttu"),
            MenuDetail(image = R.drawable.img_fried_chicken, name = "Ayam Goreng", desc = "Ayam Goreng Khas Pak Mail", shopLoc = "Loc2", price = 40000.0, mapsLoc = "https://www.google.com/maps/place/The+Breeze+BSD+City/@-6.3013244,106.6533703,17z/data=!4m6!3m5!1s0x2e69fb03fd576c99:0xf5e7f5736ced52fa!8m2!3d-6.3013244!4d106.6533703!16s%2Fg%2F11fjtgndvf?entry=ttu"),
            MenuDetail(image = R.drawable.img_geprek_chicken, name = "Ayam Geprek", desc = "Ayam Geprek Khas Pak Mail", shopLoc = "Loc3", price = 40000.0, mapsLoc = "https://www.google.com/maps/place/The+Breeze+BSD+City/@-6.3013244,106.6533703,17z/data=!4m6!3m5!1s0x2e69fb03fd576c99:0xf5e7f5736ced52fa!8m2!3d-6.3013244!4d106.6533703!16s%2Fg%2F11fjtgndvf?entry=ttu"),
            MenuDetail(image = R.drawable.img_satay_chicken, name = "Sate Usus Ayam", desc = "Sate Usus Ayam Khas Pak Mail", shopLoc = "Loc4", price = 10000.0, mapsLoc = "https://www.google.com/maps/place/The+Breeze+BSD+City/@-6.3013244,106.6533703,17z/data=!4m6!3m5!1s0x2e69fb03fd576c99:0xf5e7f5736ced52fa!8m2!3d-6.3013244!4d106.6533703!16s%2Fg%2F11fjtgndvf?entry=ttu"),
            MenuDetail(image = R.drawable.img_padang_rice, name = "Nasi Padang", desc = "Nasi Padang Khas Pak Budi", shopLoc = "Loc5", price = 30000.0, mapsLoc = "https://www.google.com/maps/place/The+Breeze+BSD+City/@-6.3013244,106.6533703,17z/data=!4m6!3m5!1s0x2e69fb03fd576c99:0xf5e7f5736ced52fa!8m2!3d-6.3013244!4d106.6533703!16s%2Fg%2F11fjtgndvf?entry=ttu"),
            MenuDetail(image = R.drawable.img_fried_rice, name = "Nasi Goreng", desc = "Nasi Goreng Khas Pak Budi", shopLoc = "Loc6", price = 20000.0, mapsLoc = "https://www.google.com/maps/place/Sinar+Mas+Land+Plaza+BSD+City/@-6.3013244,106.6533703,17z/data=!4m6!3m5!1s0x2e69fb323e588cc3:0xfd70a4bd249b08c3!8m2!3d-6.3015567!4d106.6513501!16s%2Fg%2F1hc2slmq6?entry=ttu"),
            MenuDetail(image = R.drawable.img_chicken_noodle, name = "Mie Ayam", desc = "Mie Ayam Khas Pak Budi", shopLoc = "Loc7", price = 15000.0, mapsLoc = "https://www.google.com/maps/place/Sinar+Mas+Land+Plaza+BSD+City/@-6.3013244,106.6533703,17z/data=!4m6!3m5!1s0x2e69fb323e588cc3:0xfd70a4bd249b08c3!8m2!3d-6.3015567!4d106.6513501!16s%2Fg%2F1hc2slmq6?entry=ttu"),
            MenuDetail(image = R.drawable.img_fried_duck, name = "Bebek Goreng", desc = "Bebek Goreng Khas Pak Norman", shopLoc = "Loc8", price = 50000.0, mapsLoc = "https://www.google.com/maps/place/Sinar+Mas+Land+Plaza+BSD+City/@-6.3013244,106.6533703,17z/data=!4m6!3m5!1s0x2e69fb323e588cc3:0xfd70a4bd249b08c3!8m2!3d-6.3015567!4d106.6513501!16s%2Fg%2F1hc2slmq6?entry=ttu"),
            MenuDetail(image = R.drawable.img_rendang, name = "Rendang", desc = "Rendang Khas Bu Siti", shopLoc = "Loc9", price = 50000.0, mapsLoc = "https://www.google.com/maps/place/Sinar+Mas+Land+Plaza+BSD+City/@-6.3013244,106.6533703,17z/data=!4m6!3m5!1s0x2e69fb323e588cc3:0xfd70a4bd249b08c3!8m2!3d-6.3015567!4d106.6513501!16s%2Fg%2F1hc2slmq6?entry=ttu"),
            MenuDetail(image = R.drawable.img_siomay, name = "Siomay", desc = "Siomay Khas Pak Mamat", shopLoc = "Loc10", price = 25000.0, mapsLoc = "https://www.google.com/maps/place/Sinar+Mas+Land+Plaza+BSD+City/@-6.3013244,106.6533703,17z/data=!4m6!3m5!1s0x2e69fb323e588cc3:0xfd70a4bd249b08c3!8m2!3d-6.3015567!4d106.6513501!16s%2Fg%2F1hc2slmq6?entry=ttu")
        )
    }
}