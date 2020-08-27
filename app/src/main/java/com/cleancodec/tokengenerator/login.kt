package com.cleancodec.tokengenerator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

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
    public fun makeCurrentFragmentAnimLtRl(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_left,
                0, 0)
            replace(R.id.cl_wrapper, fragment)
            commit()
        }
    }
    public fun makeCurrentFragmentAnimRtoLl(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            setCustomAnimations(
                R.animator.slide_in_right, R.animator.slide_out_right,
                0, 0
            )
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