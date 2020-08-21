package com.cleancodec.tokengenerator

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.content.Context
import androidx.core.content.ContextCompat.startActivity

class LoadingDialog(myActivity: Activity) {
    lateinit var context: Context
    private var activity:Activity = myActivity
    private lateinit var dialog:AlertDialog
    lateinit var login:login

    fun startLoadingDialog()
    {
        val builder = AlertDialog.Builder(activity)
        val inflater = activity.layoutInflater

        builder.setView(inflater.inflate(R.layout.custom_dialog,null))
        builder.setCancelable(false)

        dialog = builder.create()
        dialog.show()



    }
    fun dissmissDialog()
    {
        dialog.dismiss()
    }
    }

