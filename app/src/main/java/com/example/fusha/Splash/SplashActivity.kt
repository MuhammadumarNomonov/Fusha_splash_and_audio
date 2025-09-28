package com.example.fusha.Splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.fusha.MainActivity
import com.example.fusha.R
import com.example.fusha.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animation = AnimationUtils.loadAnimation(this, R.anim.splash_anim)
        binding.logo.startAnimation(animation)

        val fadeZoomAnim = AnimationUtils.loadAnimation(this, R.anim.logo_zoom)
        binding.applogoText.apply {
            visibility = View.VISIBLE
            startAnimation(fadeZoomAnim)
        }

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 3750)
    }
}
