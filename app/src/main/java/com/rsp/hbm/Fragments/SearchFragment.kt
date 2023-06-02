package com.rsp.hbm.Fragments

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.PagerSnapHelper
import com.rsp.hbm.Hall
import com.rsp.hbm.MainActivity
import com.rsp.hbm.adapters.HomeItemsAdapter
import com.rsp.hbm.adapters.KeyboardUtils
import com.rsp.ohb.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    lateinit var binding: FragmentSearchBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(layoutInflater)


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

        with(binding) {

            trendingRecView.adapter = HomeItemsAdapter(requireActivity(), list)
            recomendedRV.adapter = HomeItemsAdapter(requireActivity(), list)
            val pagerSnapHelper = PagerSnapHelper()
            pagerSnapHelper.attachToRecyclerView(trendingRecView)
            val pagerSnapHelperRecomended = PagerSnapHelper()
            pagerSnapHelperRecomended.attachToRecyclerView(recomendedRV)

            KeyboardUtils.addKeyboardToggleListener(
                requireActivity()
            ) {
                if (it) {
                    MainActivity.binding.btmNav.visibility = View.GONE
                } else {
                    Handler().postDelayed({
                        MainActivity.binding.btmNav.visibility = View.VISIBLE
                    }, 100)
                }
            }
        }







        return binding.root
    }

}