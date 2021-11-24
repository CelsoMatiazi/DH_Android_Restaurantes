package com.example.digitalfoods.startApp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class IntroAdapter(
    fragmentManager: FragmentActivity,
    private val views: List<Fragment>): FragmentStateAdapter(fragmentManager) {


    override fun createFragment(position: Int): Fragment{
        return if (views.isEmpty()){
            throw IllegalArgumentException("The view's list is empty")
        }else{
            views[position]
        }
    }

    override fun getItemCount(): Int = views.size

}