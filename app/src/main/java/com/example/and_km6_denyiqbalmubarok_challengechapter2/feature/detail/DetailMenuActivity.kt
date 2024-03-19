package com.example.and_km6_denyiqbalmubarok_challengechapter2.feature.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.and_km6_denyiqbalmubarok_challengechapter2.databinding.ActivityDetailMenuBinding
import com.example.and_km6_denyiqbalmubarok_challengechapter2.databinding.LayoutBtnOrderMenuBinding
import com.example.and_km6_denyiqbalmubarok_challengechapter2.databinding.LayoutDetailItemMenuBinding
import com.example.and_km6_denyiqbalmubarok_challengechapter2.databinding.LayoutDetailLocShopMenuBinding
import com.example.and_km6_denyiqbalmubarok_challengechapter2.databinding.LayoutDetailOrderMenuBinding
import com.example.and_km6_denyiqbalmubarok_challengechapter2.model.MenuDetail
import com.example.and_km6_denyiqbalmubarok_challengechapter2.utils.toIndonesianFormat
import kotlin.time.times

class DetailMenuActivity : AppCompatActivity() {
    private var count: Int = 1
    private var totPrice: Double = -1.0

    companion object{
        const val EXTRAS_DETAIL_DATA = "EXTRAS_DETAIL_DATA"

        fun startActivity(context: Context, menu: MenuDetail) {
            val intent = Intent(context, DetailMenuActivity::class.java)
            intent.putExtra("EXTRAS_DETAIL_DATA", menu)
            context.startActivity(intent)
        }
    }

    private val binding: ActivityDetailMenuBinding by lazy {
        ActivityDetailMenuBinding.inflate(layoutInflater)
    }

    private val detailItemMenuBinding: LayoutDetailItemMenuBinding by lazy {
        LayoutDetailItemMenuBinding.bind(binding.layoutDetailItemMenu.root)
    }

    private val detailLocShopMenuBinding: LayoutDetailLocShopMenuBinding by lazy {
        LayoutDetailLocShopMenuBinding.bind(binding.layoutDetailLocShopMenu.root)
    }

    private val detailOrderMenu: LayoutDetailOrderMenuBinding by lazy {
        LayoutDetailOrderMenuBinding.bind(binding.layoutDetailOrderMenu.root)
    }

    private val detailBtnOrderMenuBinding: LayoutBtnOrderMenuBinding by lazy {
        LayoutBtnOrderMenuBinding.bind(detailOrderMenu.layoutBtnOrder.root)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getIntentData()
    }

    private fun getIntentData() {
        intent.extras?.getParcelable<MenuDetail>(EXTRAS_DETAIL_DATA)?.let {
            setProfileImage(it.image)
            setProfileData(it.name, it.desc, it.shopLoc, it.price)
            setCounterOrder(it.price)
        }
    }

    private fun setCounterOrder(textPrice: Double?) {
        totPrice = textPrice!!
        detailBtnOrderMenuBinding.tvOrderPrice.text = totPrice.toString()
        detailOrderMenu.ivPlus.setOnClickListener {
            count += 1
            detailOrderMenu.tvCount.text = count.toString()
            totPrice = count.toDouble() * textPrice
            detailBtnOrderMenuBinding.tvOrderPrice.text = totPrice.toString()
        }
        detailOrderMenu.ivMinus.setOnClickListener {
            if(count > 1){
                count -= 1
            }
            detailOrderMenu.tvCount.text = count.toString()
            totPrice = count.toDouble() * textPrice
            detailBtnOrderMenuBinding.tvOrderPrice.text = totPrice.toString()
        }
    }

    private fun setProfileData(textName: String?, textDesc: String?, textShopLoc: String?, textPrice: Double?) {
        textName?.let{detailItemMenuBinding.tvDetailNameMenu.text = it}
        textDesc?.let{detailItemMenuBinding.tvDetailDescMenu.text = it}
        textShopLoc?.let{detailLocShopMenuBinding.tvDetailDescMenu.text = it}
        textPrice?.let{detailItemMenuBinding.tvDetailPriceMenu.text = it.toIndonesianFormat()}
    }

    private fun setProfileImage(imgResDrawable: Int?) {
        imgResDrawable?.let { detailItemMenuBinding.ivBannerImageMenu.setImageResource(it) }
    }
}