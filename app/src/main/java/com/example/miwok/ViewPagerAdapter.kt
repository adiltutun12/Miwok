package com.example.miwok

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> WordListFragment.newInstance("numbers")
            1 -> WordListFragment.newInstance("family")
            2 -> WordListFragment.newInstance("colors")
            3 -> WordListFragment.newInstance("phrases")
            else -> WordListFragment.newInstance("numbers")
        }
    }

}
