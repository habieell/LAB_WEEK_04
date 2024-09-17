package com.example.lab_week_04

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

val TABS_FIXED = listOf(
    R.string.starbucks_title,
    R.string.janjijiwa_title,
    R.string.kopikenangan_title,
)

class CafeAdapter(fragment: Fragment, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragment.childFragmentManager, lifecycle) {
    private val context = fragment.requireContext()

    override fun getItemCount(): Int {
        return TABS_FIXED.size
    }

    override fun createFragment(position: Int): Fragment {
        val content = when (position) {
            0 -> R.string.starbucks_desc
            1 -> R.string.janjijiwa_desc
            2 -> R.string.kopikenangan_desc
            else -> R.string.starbucks_desc
        }

        val items = when (position) {
            0 -> R.array.starbucks_items
            1 -> R.array.janjijiwa_items
            2 -> R.array.kopikenangan_items
            else -> R.array.starbucks_items
        }

        return CafeDetailFragment.newInstance(
            context.resources.getString(content),
            context.resources.getStringArray(items).toList()
        )
    }
}