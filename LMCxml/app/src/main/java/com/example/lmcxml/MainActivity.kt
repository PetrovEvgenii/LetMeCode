package com.example.lmcxml

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.lmcxml.databinding.ActivityMainBinding
import com.example.lmcxml.presentation.ViewPagerAdapter
import com.example.lmcxml.presentation.navigation.Navigator
import com.google.android.material.tabs.TabLayoutMediator

val tabArray = arrayOf(
    "Articles",
    "Authors",
)

class MainActivity : AppCompatActivity(), Navigator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)


        setContentView(binding.root)
        if (savedInstanceState == null) {

        val viewPager = binding.viewPager2
        val tabLayout = binding.tabLayout

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabArray[position]
        }.attach()
    }}

    override fun open(fragment: Fragment, addToBackStack: Boolean) {



        val transaction = supportFragmentManager.beginTransaction()
        if (addToBackStack) {
            transaction.addToBackStack(null)
        }
        transaction
            .replace(R.id.viewPager2, fragment)
            .commit()
    }

    override fun back() {
        supportFragmentManager.popBackStack()
    }
}