package com.example.calculator.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.calculator.R
import com.example.calculator.databinding.FragmentMenuBinding

class MenuFragment :Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bindObj :FragmentMenuBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_menu,container,false)
        return bindObj.root

    }
}