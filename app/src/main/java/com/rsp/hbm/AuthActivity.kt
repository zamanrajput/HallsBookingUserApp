package com.rsp.hbm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.rsp.hbm.Fragments.LoginFragment
import com.rsp.hbm.Fragments.RegisterFragment
import com.rsp.ohb.R
import com.rsp.ohb.databinding.ActivityAuthBinding

class AuthActivity : BaseActivity() {

    companion object {
        lateinit var binding: ActivityAuthBinding
        lateinit var mCtx: AuthActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mCtx = this

//        supportFragmentManager.beginTransaction().replace(R.id.container, LoginFragment()).commit()
        val adapter = ScreenSlidePagerAdapter(this)
        binding.container.adapter = adapter

        binding.container.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == 0) {
                    setLogin(View(this@AuthActivity))
                }
                if (position == 1) {
                    setRegister(View(this@AuthActivity))
                }
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }
        })

    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (binding.container.currentItem == 0) {
            // If the user is currently looking at the first step, allow the system to handle
            // the Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed()
        } else {
            // Otherwise, select the previous step.
            binding.container.currentItem = binding.container.currentItem - 1
        }
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    public inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = 2

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> LoginFragment()
                1 -> RegisterFragment()
                else -> {
                    LoginFragment()
                }
            }
        }
    }


    //set using xml
    fun setLogin(v: View) {
        binding.apply {
            loginBar.setBackgroundResource(R.drawable.bg_bar_selected)
            registerBar.setBackgroundResource(R.drawable.bg_bar_grey)
            loginText.setTextColor(getColor(R.color.primary))
            registerText.setTextColor(getColor(R.color.black))
            container.currentItem = (0)
        }
    }

    //set using xml
    fun setRegister(v: View) {
        binding.apply {
            loginBar.setBackgroundResource(R.drawable.bg_bar_grey)
            registerBar.setBackgroundResource(R.drawable.bg_bar_selected)
            loginText.setTextColor(getColor(R.color.black))
            registerText.setTextColor(getColor(R.color.primary))
            container.currentItem = 1
        }
    }
}