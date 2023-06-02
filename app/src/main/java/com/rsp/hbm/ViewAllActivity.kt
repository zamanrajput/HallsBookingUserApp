package com.rsp.hbm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.PagerSnapHelper
import com.rsp.hbm.adapters.HomeItemsAdapter
import com.rsp.hbm.adapters.ViewAllItemsAdapter
import com.rsp.ohb.databinding.ActivityViewAllBinding

class ViewAllActivity : AppCompatActivity() {

    lateinit var binding: ActivityViewAllBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewAllBinding.inflate(layoutInflater)
        setContentView(binding.root)
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
            mainRecView.adapter = ViewAllItemsAdapter(this@ViewAllActivity, list)

        }


    }
}