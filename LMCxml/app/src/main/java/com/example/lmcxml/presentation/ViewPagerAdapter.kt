package com.example.lmcxml.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.lmcxml.presentation.authors.AuthorListFragment
import com.example.lmcxml.presentation.articles.ArticlesListFragment

private const val NUM_TABS = 2

class ViewPagerAdapter (fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
       if (position == 0) {
             return ArticlesListFragment()
        }
       else {
           return AuthorListFragment()

       }
    }

    }