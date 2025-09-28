package com.example.fusha.Tashdid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fusha.R
import com.example.fusha.databinding.FragmentTashdid2Binding

class Tashdid2Fragment : Fragment() {
    private val binding by lazy { FragmentTashdid2Binding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

         binding.btnNext.setOnClickListener {
             findNavController().navigate(R.id.action_tashdid2Fragment_to_tashdid3Fragment)
         }

        return binding.root
    }

}