package com.cleancodec.tokengenerator

import android.app.Activity
import android.app.AlertDialog

class LoadingDialog(myActivity: Activity) {
    private var activity:Activity = myActivity
    private lateinit var dialog:AlertDialog


    fun startLoadingDialog()
    {
        val builder = AlertDialog.Builder(activity)
        val inflater = activity.layoutInflater

        builder.setView(inflater.inflate(R.layout.custom_dialog,null))
        builder.setCancelable(true)

        dialog = builder.create()
        dialog.show()

    }
    fun dissmissDialog()
    {
        dialog.dismiss()
    }
}