package com.rsp.hbm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.rsp.hbm.adapters.ImagesSliderAdapter
import com.rsp.ohb.R
import com.rsp.ohb.databinding.ActivityHallDetailsBinding
import java.util.*


class HallDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityHallDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHallDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {


            calender.minDate = System.currentTimeMillis() - 1000;
            calender.maxDate = (System.currentTimeMillis() - 1000 + 8.64e+7 * 30).toLong()

            val imageList = ArrayList<Int>()
            imageList.add(R.drawable.s1)
            imageList.add(R.drawable.s2)
            viewPager.adapter = ImagesSliderAdapter(imageList)
            viewPager.clipChildren = false
            viewPager.clipToPadding = false
            viewPager.offscreenPageLimit = imageList.size
            viewPager.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

            viewPager.registerOnPageChangeCallback(object: OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    itemCount.text = "${position+1}/${imageList.size}"


                }
            })

        }
    }
}