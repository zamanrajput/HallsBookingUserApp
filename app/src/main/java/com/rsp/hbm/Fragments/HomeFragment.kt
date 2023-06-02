package com.rsp.hbm.Fragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.viewpager2.widget.ViewPager2
import com.rsp.hbm.Hall
import com.rsp.ohb.R
import com.rsp.hbm.ViewAllActivity
import com.rsp.hbm.adapters.BannerSlider
import com.rsp.hbm.adapters.HomeItemsAdapter
import com.rsp.hbm.adapters.SliderItem
import com.rsp.ohb.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        val bannerList: ArrayList<SliderItem> = ArrayList();
        bannerList.add(
            SliderItem(
                R.drawable.i1,
                "google.com",
                "Google LLC is an American multinational technology company focusing on online advertising, search engine technology, cloud computing, computer software, quantum computing, e-commerce, artificial intelligence, and consumer electronics. ",
                "Google"
            )
        )
        bannerList.add(
            SliderItem(
                R.drawable.i1,
                "google.com",
                "Google LLC is an American multinational technology company focusing on online advertising, search engine technology, cloud computing, computer software, quantum computing, e-commerce, artificial intelligence, and consumer electronics. ",
                "Google"
            )
        )
        bannerList.add(
            SliderItem(
                R.drawable.i1, "google.com", "Now You Can Search Everything Using App", "Google"
            )
        )

        binding.apply {
            viewPager.adapter = BannerSlider(bannerList)

            val handler = Handler()
            val runnable: Runnable = Runnable {
                try {
                    if (viewPager.currentItem + 1 == bannerList.size) {
                        viewPager.currentItem = 0
                    } else {
                        viewPager.currentItem = viewPager.currentItem + 1
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }


            viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    handler.removeCallbacks(runnable)
                    handler.postDelayed(runnable, 4000)
                }
            })


            val list = ArrayList<Hall>()
            list.add(
                Hall(
                    "Shehnai Palace Marriage Hall",
                    "Jaranwala Rd, Lahore, Punjab",
                    "https://media.zameen.com/thumbnails/209607-800x600.jpeg"
                )
            )
            list.add(
                Hall(
                    "Hajvery Shahdi Hall & Garden",
                    "Nain Sukh, Lahore, Punjab",
                    "https://mashriqtv.pk/en/wp-content/uploads/2022/02/wedding-hall.jpg"
                )
            )

            list.add(
                Hall(
                    "Dream Palace Marriage Halls",
                    "Kot Abdul Malik, Lahore, Punjab",
                    "https://www.chennaiconventioncentre.com/wp-content/uploads/2018/11/wedding-hall.jpg"
                )
            )
            trendingRecView.adapter = HomeItemsAdapter(requireActivity(), list)
            val snapHelper = PagerSnapHelper()
            snapHelper.attachToRecyclerView(trendingRecView)




            nearbyRecView.adapter = HomeItemsAdapter(requireActivity(), list)
            val snapHelperNearby = PagerSnapHelper()
            snapHelperNearby.attachToRecyclerView(nearbyRecView)

            trendingViewAll.setOnClickListener{
                startActivity(Intent(requireActivity(), ViewAllActivity::class.java))
            }
            nearbyViewAll.setOnClickListener{
                startActivity(Intent(requireActivity(), ViewAllActivity::class.java))
            }


        }



        return binding.root
    }


}