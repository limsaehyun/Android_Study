package com.saehyun.tabviewexample.controller.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.saehyun.tabviewexample.R

class BlankFragment3 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank3, container, false)
    }

    fun newInstant() : BlankFragment3
    {
        val args = Bundle()
        val frag = BlankFragment3()
        frag.arguments = args
        return frag
    }
}