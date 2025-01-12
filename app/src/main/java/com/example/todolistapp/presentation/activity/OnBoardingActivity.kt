package com.example.todolistapp.presentation.activity

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.todolistapp.R
import com.example.todolistapp.databinding.ActivityOnBoardingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardingActivity : AppCompatActivity() {
    lateinit var binding: ActivityOnBoardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOnBoardingBinding.inflate(layoutInflater)

        setContentView(binding.root)

        /*

        SHARED PREFS PART

        TODO
         */
        val prefs: SharedPreferences = getSharedPreferences("onboarding", MODE_PRIVATE)

        binding.btStart.setOnClickListener {
            prefs.edit().putBoolean(SEEN_ON_BOARDING, true).commit()

            val intent = Intent(this, HomeActivity::class.java)

            startActivity(intent)
            finish()
        }

        if(hasSeenOnBoarding(prefs)){
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }






    private fun hasSeenOnBoarding(prefs: SharedPreferences): Boolean{
        return prefs.getBoolean(SEEN_ON_BOARDING ,false)
    }

    companion object{
        //SHARED PREFS KEYS
        val SEEN_ON_BOARDING = "ON_BOARDING_PREF_ID"
    }
}