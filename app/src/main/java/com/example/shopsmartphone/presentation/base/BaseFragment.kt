package com.example.shopsmartphone.presentation.base

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import com.example.shopsmartphone.managers.BottomNavigationViewManager

open class BaseFragment: Fragment() {
    open val showBottomNavigationView: Boolean
        get() = (parentFragment as? BaseFragment)?.showBottomNavigationView ?: false

    private var bottomNavigationViewManager: BottomNavigationViewManager? = null
    protected fun setBottomNavigationViewVisibility(isVisible: Boolean) {
        bottomNavigationViewManager?.setNavigationViewVisibility(isVisible)
    }

    override fun onAttach(context: Context) {
        if (context is BottomNavigationViewManager) {
            bottomNavigationViewManager = context
        }
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomNavigationViewManager?.setNavigationViewVisibility(showBottomNavigationView)
    }
    protected infix fun <T> LiveData<T>.observe(block: (T) -> Unit) {
        observe(this@BaseFragment.viewLifecycleOwner) { block.invoke(it) }
    }
}