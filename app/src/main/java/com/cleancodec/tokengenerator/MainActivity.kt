package com.cleancodec.tokengenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

import com.cleancodec.tokengenerator.fragment.clock
import com.cleancodec.tokengenerator.fragment.home

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        home_icon.setOnClickListener(){
            //Log.i("MyClass.getView() — get item number", "MyClass.getView() — get item number")

        //val clockFragment= clock()


        }

    }
    private fun makeCurrentFragment(fragment: Fragment)
    {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper,fragment)
            commit()
        }
    }
    }

