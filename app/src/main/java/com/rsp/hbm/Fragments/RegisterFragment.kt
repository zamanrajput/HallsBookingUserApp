package com.rsp.hbm.Fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rsp.hbm.AuthActivity
import com.rsp.ohb.databinding.FragmentRegisterBinding

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterFragment : Fragment() {
    lateinit var binding: FragmentRegisterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentRegisterBinding.inflate(layoutInflater)







        binding.apply {
            loginText.setOnClickListener {
                AuthActivity.mCtx.setLogin(View(AuthActivity.mCtx))
            }

            lName.setOnFocusChangeListener { v, hasFocus ->
                if (hasFocus) {
                    parent.scrollTo(0, 150)
                }
            }

            fName.setOnFocusChangeListener { v, hasFocus ->
                if (hasFocus) {
                    parent.scrollTo(0, 150)
                }
            }

            phone.setOnFocusChangeListener { v, hasFocus ->
                if (hasFocus) {
                    parent.scrollTo(0, 150)
                }
            }

            otp.setOnFocusChangeListener { v, hasFocus ->
                if (hasFocus) {
                    parent.scrollTo(0, 400)
                }
            }



            otp.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    parent.scrollTo(0, 100)

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    parent.scrollTo(0, 100)

                }

                override fun afterTextChanged(s: Editable?) {
                    parent.scrollTo(0, 100)
                }
            })




        }










        return binding.root

    }


}