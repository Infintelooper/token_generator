package com.cleancodec.tokengenerator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import kotlinx.android.synthetic.main.activity_login.*

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loadingDialog =LoadingDialog(myActivity = this)

        login_button.setOnClickListener {
            loadingDialog.startLoadingDialog()
            Handler(Looper.getMainLooper()).postDelayed({
                successLogin()
                loadingDialog.dissmissDialog()     /// need to add changes on OTP confirmation

            }, 5000)
        }
    }
    fun successLogin()
    {
        val intent = Intent(this, MainActivity::class.java)
        // start your next activity
        startActivity(intent)
    }
}