package com.example.and_km6_denyiqbalmubarok_challengechapter2.feature.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.and_km6_denyiqbalmubarok_challengechapter2.R
import com.example.and_km6_denyiqbalmubarok_challengechapter2.databinding.ActivityMainBinding
import com.example.and_km6_denyiqbalmubarok_challengechapter2.adapter.CategoryAdapter
import com.example.and_km6_denyiqbalmubarok_challengechapter2.data.datasource.MenuDataSource
import com.example.and_km6_denyiqbalmubarok_challengechapter2.adapter.changelayoutmenu.MenuAdapter
import com.example.and_km6_denyiqbalmubarok_challengechapter2.data.datasource.MenuDataSourceImpl
import com.example.and_km6_denyiqbalmubarok_challengechapter2.databinding.LayoutHeaderMenuBinding
import com.example.and_km6_denyiqbalmubarok_challengechapter2.adapter.changelayoutmenu.OnItemClickedListener
import com.example.and_km6_denyiqbalmubarok_challengechapter2.data.datasource.CategoryDataSource
import com.example.and_km6_denyiqbalmubarok_challengechapter2.data.datasource.CategoryDataSourceImpl
import com.example.and_km6_denyiqbalmubarok_challengechapter2.feature.detail.DetailMenuActivity
import com.example.and_km6_denyiqbalmubarok_challengechapter2.model.Category
import com.example.and_km6_denyiqbalmubarok_challengechapter2.model.MenuDetail

class MainActivity : AppCompatActivity() {
    private var menuAdapter: MenuAdapter? = null
    private val categoryAdapter = CategoryAdapter()
    private val menuDataSource: MenuDataSource by lazy { MenuDataSourceImpl() }
    private val categoryDataSource: CategoryDataSource by lazy { CategoryDataSourceImpl() }
    private var isUsingGridMode: Boolean = true
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val headerMenuBinding: LayoutHeaderMenuBinding by lazy {
        LayoutHeaderMenuBinding.bind(binding.layoutHeaderMenu.root)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setListCategory()
        setListMenu(isUsingGridMode)
        setAction()

    }

    private fun setAction() {
        headerMenuBinding.ivLogoListMenu.setOnClickListener {
            isUsingGridMode = !isUsingGridMode
            setButtonImage(isUsingGridMode)
            setListMenu(isUsingGridMode)
        }
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

    private fun setListMenu(isUsingGrid: Boolean) {
        val listMode = if (isUsingGrid) MenuAdapter.MODE_GRID else MenuAdapter.MODE_LIST
        menuAdapter = MenuAdapter(
            listMode = listMode,
            listener = object : OnItemClickedListener<MenuDetail> {
                override fun onItemClicked(item: MenuDetail) {
                    //navigate to detail
                    navigateToDetailMenu(item)
                }
            })
        binding.rvMenu.apply {
            adapter = this@MainActivity.menuAdapter
            layoutManager = GridLayoutManager(this@MainActivity, if (isUsingGrid) 2 else 1)
        }
        menuAdapter?.submitData(menuDataSource.getMenuDetailMembers())
    }

    private fun navigateToDetailMenu(item: MenuDetail) {
        val intent = Intent(this, DetailMenuActivity::class.java)
        intent.putExtra(DetailMenuActivity.EXTRAS_DETAIL_DATA, item)
        startActivity(intent)
    }

    private fun setListCategory() {
        binding.rvCategory.apply {
            adapter = this@MainActivity.categoryAdapter
        }
        categoryAdapter.submitData(categoryDataSource.getCategoryMembers())
    }

    private fun setButtonImage(usingGridMode: Boolean) {
        headerMenuBinding.ivLogoListMenu.setImageResource(if (usingGridMode) R.drawable.img_logo_list1 else R.drawable.img_logo_list2)
    }
}