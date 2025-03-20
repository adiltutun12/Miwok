package com.example.miwok
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tab_layout)
        viewPager = findViewById(R.id.view_pager)

        val adapter = ViewPagerAdapter(this)
        viewPager.adapter = adapter

        // povezivanje TabLayout-a sa ViewPager2
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Numbers"
                1 -> "Family"
                2 -> "Colors"
                3 -> "Phrases"
                else -> "Numbers"
            }
        }.attach()
    }

    override fun onPause() {
        super.onPause()
        // Oslobodi MediaPlayer za sve fragmente
        (findViewById<ViewPager2>(R.id.view_pager)?.adapter as? WordAdapter)?.releaseMediaPlayer()
    }

}
