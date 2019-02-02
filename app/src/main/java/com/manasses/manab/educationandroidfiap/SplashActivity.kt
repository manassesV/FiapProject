package com.manasses.manab.educationandroidfiap

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.manasses.manab.educationandroidfiap.R.styleable.LottieAnimationView

class SplashActivity : AppCompatActivity() {

    private  lateinit var preference: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        preference = getSharedPreferences("user_preferences", Context.MODE_PRIVATE);
        val isFirsOpen = preference.getBoolean("open_first", true)


        if (isFirsOpen){
            markAppAlReadOpen()
            load()
        }else{
            showMain()
        }
    }

    private fun markAppAlReadOpen() {
        val editor = preference.edit().apply {
            putBoolean("open_first", false)
            commit()
        }
    }

    private fun load() {


        Handler().postDelayed({
            showMain()
        }, 3500L)
    }

    private fun showMain() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
