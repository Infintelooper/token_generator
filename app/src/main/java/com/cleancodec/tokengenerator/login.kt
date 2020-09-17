package com.cleancodec.tokengenerator

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import kotlinx.android.synthetic.main.fragment_mobile.*
import kotlinx.android.synthetic.main.fragment_name.*
import kotlinx.android.synthetic.main.fragment_otp.*

class login : AppCompatActivity() {
    var stage = 0
    lateinit var _phoneno:String
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val nameFragment = name()

        makeCurrentFragment(nameFragment)

        //val loadingDialog =LoadingDialog(myActivity = this)
        /*
        getotpbutton.setOnClickListener {
            loadingDialog.startLoadingDialog()
            Handler(Looper.getMainLooper()).postDelayed({
                successLogin()
                loadingDialog.dissmissDialog()     /// need to add changes on OTP confirmation

            }, 5000)
        }

        go_button.setOnClickListener{
            if(cname.text.isEmpty())
            {
                makeCurrentFragmentAnimLtR(mobileFragment)
            }
        }
        */

    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.cl_wrapper, fragment)
            commit()
        }
    }
    fun makeCurrentFragmentAnimLtRl(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_left,
                0, 0)
            replace(R.id.cl_wrapper, fragment)
            commit()
        }
    }
    fun makeCurrentFragmentAnimRtoLl(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            setCustomAnimations(
                R.animator.slide_in_right, R.animator.slide_out_right,
                0, 0
            )
            add(R.id.cl_wrapper, fragment)
            commit()
        }
    }

    fun successLogin()
    {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_out_bottom, R.anim.slide_in_bottom)
    }
     fun AnimateFadeIn()
    {
        val anim = AnimationUtils.loadAnimation(applicationContext,R.anim.blink)
        if(stage == 1)
            warning1.startAnimation(anim)
        else if(stage ==2)
            warning2.startAnimation(anim)
        else if(stage == 3)
            warning3.startAnimation(anim)
    }
    fun passPhoneNo(no:String)
    {
        _phoneno = no
    }
    public fun signInTheUserBycredential(credential: PhoneAuthCredential) {

        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    successLogin()
                    Log.d(ContentValues.TAG, "signInWithCredential:success")

                } else {
                    // Sign in failed, display a message and update the UI
                    Log.w(ContentValues.TAG, "signInWithCredential:failure", task.exception)
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        // The verification code entered was invalid
                        // [START_EXCLUDE silent]
                        // [END_EXCLUDE]
                    }
                }
            }

    }



}