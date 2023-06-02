package com.rsp.hbm.Fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rsp.hbm.AuthActivity
import com.rsp.ohb.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        binding = FragmentLoginBinding.inflate(layoutInflater)




        binding.apply {
            signUpText.setOnClickListener {
                AuthActivity.mCtx.setRegister(View(AuthActivity.mCtx))
            }


            otp.setOnFocusChangeListener { v, hasFocus ->
                if (hasFocus) {
                    parent.scrollTo(0, 100)
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