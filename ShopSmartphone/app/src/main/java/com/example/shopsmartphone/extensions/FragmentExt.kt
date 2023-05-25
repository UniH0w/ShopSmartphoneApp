package com.example.shopsmartphone.extensions

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

fun Fragment.navigateTo(direction: Int) {
    findNavController().navigate(direction)
}
