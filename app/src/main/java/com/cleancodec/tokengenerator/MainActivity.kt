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
        var pageno = 1

        makeCurrentFragment(homeFragment)
        home_icon.setImageResource(R.drawable.ic_homeb)

        home_icon.setOnClickListener(){

            home_icon.setImageResource(R.drawable.ic_homeb)
            history_icon.setImageResource(R.drawable.ic_history_icon)
            notification_icon.setImageResource(R.drawable.ic_notification_icon)
            profile_icon.setImageResource(R.drawable.ic_profile_icon)

            pageno = 1
            makeCurrentFragmentAnimRtoL(homeFragment)
        }
        history_icon.setOnClickListener(){

            history_icon.setImageResource(R.drawable.ic_historyb)
            home_icon.setImageResource(R.drawable.ic_home_icon)
            notification_icon.setImageResource(R.drawable.ic_notification_icon)
            profile_icon.setImageResource(R.drawable.ic_profile_icon)

            if(pageno<2)
                makeCurrentFragmentAnimLtR(clockFragment)
            else
                makeCurrentFragmentAnimRtoL(clockFragment)
            pageno = 2
        }
        notification_icon.setOnClickListener(){

            notification_icon.setImageResource(R.drawable.ic_notifyb)
            home_icon.setImageResource(R.drawable.ic_home_icon)
            history_icon.setImageResource(R.drawable.ic_history_icon)
            profile_icon.setImageResource(R.drawable.ic_profile_icon)

            if(pageno <3)
                makeCurrentFragmentAnimLtR(notifyFragment)
            else
                makeCurrentFragmentAnimRtoL(notifyFragment)
            pageno = 3
        }
        profile_icon.setOnClickListener(){

            profile_icon.setImageResource(R.drawable.ic_profileb)
            home_icon.setImageResource(R.drawable.ic_home_icon)
            history_icon.setImageResource(R.drawable.ic_history_icon)
            notification_icon.setImageResource(R.drawable.ic_notification_icon)

            pageno = 4
            makeCurrentFragmentAnimLtR(profileFragment)
        }

    }
    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
    }
    private fun makeCurrentFragmentAnimLtR(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_left,
                0, 0)
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
    }
    private fun makeCurrentFragmentAnimRtoL(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            setCustomAnimations(R.animator.slide_in_right, R.animator.slide_out_right,
                0, 0)
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
    }








    }

