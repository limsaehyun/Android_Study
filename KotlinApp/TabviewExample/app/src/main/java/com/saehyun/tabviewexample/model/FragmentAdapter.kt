package com.saehyun.tabviewexample.model

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.saehyun.tabviewexample.controller.fragment.BlankFragment
import com.saehyun.tabviewexample.controller.fragment.BlankFragment2
import com.saehyun.tabviewexample.controller.fragment.BlankFragment3

class FragmentAdapter (fm : FragmentManager): FragmentPagerAdapter(fm) {
    //position 에 따라 원하는 Fragment로 이동시키기
    override fun getItem(position: Int): Fragment {
        val fragment = when (position) {
            0 -> BlankFragment().newInstant()
            1 -> BlankFragment2().newInstant()
            2 -> BlankFragment3().newInstant()
            else -> BlankFragment().newInstant()
        }
        return fragment
    }

    //tab의 개수만큼 return
    override fun getCount(): Int = 3

    //tab의 이름 fragment마다 바꾸게 하기
    override fun getPageTitle(position: Int): CharSequence? {
        val title = when (position) {
            0 -> "0ne"
            1 -> "Two"
            2 -> "Three"
            else -> "main"
        }
        return title
    }
}
