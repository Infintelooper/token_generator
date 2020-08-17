package com.cleancodec.tokengenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

import com.cleancodec.tokengenerator.fragment.clock

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        home_icon.setOnClickListener(){
            Log.i("MyClass.getView() — get item number", "MyClass.getView() — get item number")

        val clockFragment= clock()

        }

    }
    }

