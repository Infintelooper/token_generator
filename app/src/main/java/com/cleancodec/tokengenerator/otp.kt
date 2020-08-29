package com.cleancodec.tokengenerator

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.fragment_otp.*
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [otp.newInstance] factory method to
 * create an instance of this fragment.
 */
class otp : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    var correctopt:Number = 123456

    override fun onCreate(savedInstanceState: Bundle?) {
        (activity as login).stage = 3
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_otp, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        warning3.alpha = 0f
        super.onViewCreated(view, savedInstanceState)
        backarrow2.setOnClickListener {
            val mobileFragment = mobile()
            (activity as login).makeCurrentFragmentAnimRtoLl(mobileFragment)
        }
        verifybutton.setOnClickListener {
            if(otpno.text.toString() == correctopt.toString()) {
                (activity as login).successLogin()
            }
            else
            {
                warning3.alpha = 1f
                (activity as login).AnimateFadeIn()
                Handler().postDelayed({
                    warning3.alpha = 0f
                }, 2400)
            }
        }

        view.setOnClickListener {
            it.hideKeyboard()
        }

        Log.i("this is  that", arguments?.getString("number").toString())
    }
    fun View.hideKeyboard() {
        val inputMethodManager = requireContext().getSystemService(android.content.Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        inputMethodManager?.hideSoftInputFromWindow(this.windowToken, 0)
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment otp.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            otp().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}