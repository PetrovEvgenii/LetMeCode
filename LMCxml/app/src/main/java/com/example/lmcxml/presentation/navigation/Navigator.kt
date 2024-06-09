package com.example.lmcxml.presentation.navigation

import androidx.fragment.app.Fragment

interface Navigator {

    fun open (fragment: Fragment, addToBackStack : Boolean= true)
    fun back()
}