package com.example.and_km6_denyiqbalmubarok_challengechapter2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.and_km6_denyiqbalmubarok_challengechapter2.databinding.ActivityMainBinding
import com.example.and_km6_denyiqbalmubarok_challengechapter2.adapter.CategoryAdapter
import com.example.and_km6_denyiqbalmubarok_challengechapter2.adapter.MenuAdapter
import com.example.and_km6_denyiqbalmubarok_challengechapter2.model.Category
import com.example.and_km6_denyiqbalmubarok_challengechapter2.model.Menu

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val adapterCategory = CategoryAdapter()
    private val adapterMenu = MenuAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setAction()
        setListCategory()
        setListMenu()
    }

    private fun setListMenu() {
        val data = listOf(
            Menu(image = R.drawable.img_grilled_chicken, name = "Ayam Bakar", price = 50000.0),
            Menu(image = R.drawable.img_fried_chicken, name = "Ayam Goreng", price = 40000.0),
            Menu(image = R.drawable.img_geprek_chicken, name = "Ayam Geprek", price = 40000.0),
            Menu(image = R.drawable.img_satay_chicken, name = "Sate Usus Ayam", price = 10000.0),
            Menu(image = R.drawable.img_padang_rice, name = "Nasi Padang", price = 30000.0),
            Menu(image = R.drawable.img_fried_rice, name = "Nasi Goreng", price = 20000.0),
            Menu(image = R.drawable.img_chicken_noodle, name = "Mie Ayam", price = 15000.0),
            Menu(image = R.drawable.img_fried_duck, name = "Bebek Goreng", price = 50000.0),
            Menu(image = R.drawable.img_rendang, name = "Rendang", price = 50000.0),
            Menu(image = R.drawable.img_siomay, name = "Siomay", price = 25000.0)
        )
        binding.rvMenu.apply {
            adapter = this@MainActivity.adapterMenu
        }
        adapterMenu.submitData(data)
    }

    private fun setListCategory() {
        val data = listOf(
            Category(image = R.drawable.img_rice, name = "Nasi"),
            Category(image = R.drawable.img_noddle, name = "Mie"),
            Category(image = R.drawable.img_snack, name = "Snack"),
            Category(image = R.drawable.img_drink, name = "Minuman"),
            Category(image = R.drawable.img_junkfood, name = "Junk Food"),
            Category(image = R.drawable.img_chicken_meat, name = "Daging Ayam"),
            Category(image = R.drawable.img_beef, name = "Daging Sapi"),
            Category(image = R.drawable.img_duck_meat, name = "Daging Bebek")

        )
        binding.rvCategory.apply {
            adapter = this@MainActivity.adapterCategory
        }
        adapterCategory.submitData(data)
    }

    private fun setAction() {
        binding.layoutHeader.ivProfileMenu.setOnClickListener {
            Toast.makeText(this@MainActivity, "Anda masuk ke menu Profile", Toast.LENGTH_SHORT).show()
        }
        binding.layoutHeader.ivCartMenu.setOnClickListener {
            Toast.makeText(this@MainActivity, "Anda masuk ke menu Keranjang", Toast.LENGTH_SHORT).show()
        }
        binding.layoutHeader.svSearchBar.setOnClickListener {
            Toast.makeText(this@MainActivity, "Anda ingin cari Makanan apa?", Toast.LENGTH_SHORT).show()
        }
        binding.layoutBanner.tvTittleBanner.setOnClickListener {
            Toast.makeText(this@MainActivity, "Silahkan Claim Ticket Anda!", Toast.LENGTH_SHORT).show()
        }
        binding.layoutBanner.tvDescBanner.setOnClickListener {
            Toast.makeText(this@MainActivity, "Silahkan Claim Ticket Anda!", Toast.LENGTH_SHORT).show()
        }
        binding.layoutBanner.ivLogoBanner.setOnClickListener {
            Toast.makeText(this@MainActivity, "Silahkan Claim Ticket Anda!", Toast.LENGTH_SHORT).show()
        }
    }
}