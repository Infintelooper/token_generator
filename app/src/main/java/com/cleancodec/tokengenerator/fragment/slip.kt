@file:Suppress("DEPRECATION")

package com.cleancodec.tokengenerator.fragment

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.cleancodec.tokengenerator.R
import kotlinx.android.synthetic.main.fragment_slip.*

// TODO: Rename parameter arguments, choose names that match
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [slip.newInstance] factory method to
 * create an instance of this fragment.
 */
class slip : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
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
        return inflater.inflate(R.layout.fragment_slip, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tap_message.setOnClickListener{
            AnimateFO()
        }

    }
    private fun AnimateFO()
    {
        val anim = AnimationUtils.loadAnimation(activity?.applicationContext,R.anim.fade_out)
        tap_message.startAnimation(anim)
        Handler().postDelayed({
            Change()
        }, 600)
        //tap_message.visibility = View.GONE
    }
    private fun Rotate()
    {
        val anim = AnimationUtils.loadAnimation(activity?.applicationContext,R.anim.rotate_indefinitely)
        tap_message.startAnimation(anim)
        Handler().postDelayed({
            interpolator_anticipate_overshoot()
        }, 1000)

    }
    private fun Change(){
        tap_message.setImageResource(R.drawable.ic_loading)
        Rotate()
    }
    private fun interpolator_anticipate_overshoot()
    {
        tap_message.visibility = View.GONE
        val anim = AnimationUtils.loadAnimation(activity?.applicationContext,R.anim.interpolator_accelerate_decelerate)
        anim.fillAfter = true
        token_slip.startAnimation(anim)
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment slip.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            slip().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}