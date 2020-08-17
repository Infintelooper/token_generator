package com.cleancodec.tokengenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

import com.cleancodec.tokengenerator.fragment.clock
import com.cleancodec.tokengenerator.fragment.home


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val clockFragment= clock()
        val homeFragment = home()

        makeCurrentFragment(homeFragment)
        home_icon.setOnClickListener(){
            makeCurrentFragment(clockFragment)



        }

    }
    private fun makeCurrentFragment(fragment: Fragment)
    {
        supportFragmentManager.beginTransaction().apply {
        setCustomAnimations(R.animator.slide_in_left,
                            R.animator.slide_out_right, 0, 0)
            replace(R.id.fl_wrapper,fragment)
            commit()
        }



    }
    }

