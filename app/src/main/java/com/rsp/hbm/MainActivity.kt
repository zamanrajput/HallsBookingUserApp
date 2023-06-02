package com.rsp.hbm

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import com.rsp.hbm.Fragments.HomeFragment
import com.rsp.hbm.Fragments.MapFragment
import com.rsp.hbm.Fragments.SearchFragment
import com.rsp.ohb.R
import com.rsp.ohb.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var binding: ActivityMainBinding
        lateinit var mCtx: MainActivity

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mCtx = this
        startActivity(Intent(this, HallDetailsActivity::class.java))

        supportFragmentManager.beginTransaction().replace(R.id.container, HomeFragment()).commit()

        binding.apply {
            homeCard.setOnClickListener { selectHome() }
            mapCard.setOnClickListener { selectMap() }
            searchCard.setOnClickListener { selectSearch() }
        }

    }

    fun selectMap() {
        with(binding) {
            mapRSC.setImageResource(R.drawable.loc_selected)
            homeRsc.setImageResource(R.drawable.home_unselected)
            searchRsc.setImageResource(R.drawable.search_ic)
            supportFragmentManager.beginTransaction().replace(R.id.container, MapFragment())
                .commit()
        }
    }

    fun selectHome() {
        with(binding) {
            mapRSC.setImageResource(R.drawable.loc_unselected)
            homeRsc.setImageResource(R.drawable.home_selected)
            searchRsc.setImageResource(R.drawable.search_ic)
            supportFragmentManager.beginTransaction().replace(R.id.container, HomeFragment())
                .commit()
        }
    }

    fun selectSearch() {
        with(binding) {
            mapRSC.setImageResource(R.drawable.loc_unselected)
            homeRsc.setImageResource(R.drawable.home_unselected)
            searchRsc.setImageResource(R.drawable.search_ic_selected)
            supportFragmentManager.beginTransaction().replace(R.id.container, SearchFragment())
                .commit()
        }
    }

}