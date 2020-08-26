package com.cleancodec.tokengenerator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_mobile.*

class login : AppCompatActivity() {
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
        */
    }
    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.cl_wrapper, fragment)
            commit()
        }
    }
    fun successLogin()
    {
        val intent = Intent(this, MainActivity::class.java)
        // start your next activity
        startActivity(intent)
        overridePendingTransition(R.anim.slide_out_bottom, R.anim.slide_in_bottom)
        //var options = activityOptions.makeSceneTransitionAnimation()
        //var options = ActivityOptions.makeSceneTransitionAnimation(MainActivity)
        //var options = ActivityOptions.makeSceneTransitionAnimation()
    }
}