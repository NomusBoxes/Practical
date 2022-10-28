package ru.samsung.itschool.a311_practical_work2.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import ru.samsung.itschool.a311_practical_work2.R

private val TAB_TITLES = arrayOf(
        R.string.tab_text_1,
        R.string.tab_text_2,
        R.string.tab_text_3,
        R.string.tab_text_4,
        R.string.tab_text_5,
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(fa: FragmentActivity)
    : FragmentStateAdapter(fa) {

    override fun getItemCount(): Int = TAB_TITLES.size

    override fun createFragment(position: Int): Fragment =
        PlaceholderFragment.newInstance(position + 1)
}