package com.cleancodec.tokengenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

import com.cleancodec.tokengenerator.fragment.clock
import com.cleancodec.tokengenerator.fragment.home
import com.cleancodec.tokengenerator.fragment.notify
import com.cleancodec.tokengenerator.fragment.profile


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val clockFragment= clock()
        val homeFragment = home()
        val notifyFragment = notify()
        val profileFragment = profile()

        makeCurrentFragment(homeFragment)
        home_icon.setOnClickListener(){
            makeCurrentFragmentAnim2(homeFragment)
        }
        history_icon.setOnClickListener(){
            makeCurrentFragmentAnim(clockFragment)
        }
        notification_icon.setOnClickListener(){
            makeCurrentFragmentAnim(notifyFragment)
        }
        profile_icon.setOnClickListener(){
            makeCurrentFragmentAnim(profileFragment)
        }

    }
    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
    }
    private fun makeCurrentFragmentAnim(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_left,
                0, 0)
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
    }
    private fun makeCurrentFragmentAnim2(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            setCustomAnimations(R.animator.slide_in_right, R.animator.slide_out_right,
                0, 0)
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
    }








    }

