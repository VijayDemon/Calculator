package com.example.calculator.welcome

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.calculator.R
import com.example.calculator.databinding.FragmentWelcomeBinding


class Welcome : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding :FragmentWelcomeBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_welcome,container,false)



        binding.button.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_welcome_to_aboutFragment)
        )
        binding.button2.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_welcome_to_mainFragment3)
        )

        setHasOptionsMenu(true)
        return binding.root

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu,menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return  NavigationUI.onNavDestinationSelected(item!! , requireView().findNavController()) || super.onOptionsItemSelected(item)
    }
}
