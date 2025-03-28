package com.example.miwok.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.miwok.model.Category

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = Category.entries.size

    override fun createFragment(position: Int): Fragment {
        val category = Category.entries.getOrNull(position) ?: Category.NUMBERS
        return WordListFragment.newInstance(category)
    }
}

