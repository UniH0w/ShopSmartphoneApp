package com.example.shopsmartphone.extensions

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

fun Fragment.navigateTo(direction: Int) {
    findNavController().navigate(direction)
}
fun Fragment.navigateBack() = findNavController().popBackStack()

fun Fragment.toastShow(text: String) {
    Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
}