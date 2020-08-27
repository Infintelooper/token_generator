package com.cleancodec.tokengenerator

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.fragment_mobile.*
import kotlinx.android.synthetic.main.fragment_name.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [mobile.newInstance] factory method to
 * create an instance of this fragment.
 */
class mobile : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    val otpFragment = otp()

    override fun onCreate(savedInstanceState: Bundle?) {
        (activity as login).stage = 2
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
        return inflater.inflate(R.layout.fragment_mobile, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        warning2.alpha = 0f
        super.onViewCreated(view, savedInstanceState)
        backarrow1.setOnClickListener {
            val nameFragment = name()
            (activity as login).makeCurrentFragmentAnimRtoLl(nameFragment)
        }
        getotpbutton.setOnClickListener{
            if(cno.text.length == 10)
            {
                (activity as login).makeCurrentFragmentAnimLtRl(otpFragment)
                //code for otp trigger
            }
            else
            {
                warning2.alpha = 1f
                (activity as login).AnimateFadeIn()
                Handler().postDelayed({
                    warning2.alpha = 0f
                }, 2400)
            }
        }
        view.setOnClickListener {
            it.hideKeyboard()
        }


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
         * @return A new instance of fragment mobile.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            mobile().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}