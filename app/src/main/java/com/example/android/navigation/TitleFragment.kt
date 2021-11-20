package com.example.android.navigation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding


class TitleFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentTitleBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_title, container, false
        )
        binding.playButton.setOnClickListener{
            it.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())
        }
        //add overflow menu in titleFragment menu with option
        setHasOptionsMenu(true)
        return  binding.root
    }

    //create a menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        //inflate menu from menu/overflow_menu
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    //select item in menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //navigate to about
        return NavigationUI.onNavDestinationSelected(item, view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }
}