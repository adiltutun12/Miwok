package com.example.miwok

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.miwok.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import android.util.Log


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* pomocu ovoga sam izvukao ideve za slike i za zvukove tako cu to uvrstiti sada
        val imageNames = listOf(
            "phrase_where_are_you_going",
            "phrase_what_is_your_name",
            "phrase_my_name_is",
            "phrase_how_are_you_feeling",
            "phrase_im_feeling_good",
            "phrase_are_you_coming",
            "phrase_yes_im_coming",
            "phrase_im_coming",
            "phrase_lets_go",
            "phrase_come_here"

        )
        for (name in imageNames) {
            val audioResId = resources.getIdentifier(name, "raw", packageName)

            Log.d("ID MI DAJJJJJ", "audioResId: $audioResId")
        }
         */


        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val adapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Numbers"
                1 -> "Family"
                2 -> "Colors"
                3 -> "Phrases"
                else -> ""
            }
        }.attach()
    }
}
