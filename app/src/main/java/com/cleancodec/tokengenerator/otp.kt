package com.cleancodec.tokengenerator

import android.content.ContentValues.TAG
import android.os.Bundle
import android.os.Handler
import android.text.SpannableStringBuilder
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.arch.core.executor.TaskExecutor
import androidx.core.view.isVisible
import com.google.android.gms.tasks.TaskExecutors
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.custom_dialog.*
import kotlinx.android.synthetic.main.fragment_mobile.*
import kotlinx.android.synthetic.main.fragment_otp.*
import java.util.concurrent.TimeUnit

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
    lateinit var verificationCodeBySystem:String

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

        //Log.i("this is  that", (activity as login)._phoneno)
        phoneno.text = SpannableStringBuilder((activity as login)._phoneno)

        var phoneNo:String = (activity as login)._phoneno

    }

    private fun sentVerificationCodeToUser(phoneNo: String) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
            phoneNo, // Phone number to verify
            60, // Timeout duration
            TimeUnit.SECONDS, // Unit of timeout
            TaskExecutors.MAIN_THREAD, // Activity (for callback binding)
            mCallBacks) // OnVerificationStateChangedCallbacks
    }

    var mCallBacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        override fun onVerificationCompleted(credential: PhoneAuthCredential) {
            var code: String = credential.toString()
            if (code != null) {
                //do something on code
                verifyCode(code);
            }
        }
        override fun onVerificationFailed(e: FirebaseException) {
            //Toast.makeText(,e.message,Toast.LENGTH_SHORT).show()
        }
        override fun onCodeSent(
            verificationId: String,
            token: PhoneAuthProvider.ForceResendingToken
        )   {
                verificationCodeBySystem = verificationId
            }
    }

    fun verifyCode(codeByUser:String){
        var credential:PhoneAuthCredential = PhoneAuthProvider.getCredential(verificationCodeBySystem,codeByUser)
        (activity as login).signInTheUserBycredential(credential)
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