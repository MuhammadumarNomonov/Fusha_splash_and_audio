package com.example.fusha.Darslar_fragment_child.sozlaroqilishi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fusha.R
import com.example.fusha.databinding.FragmentBarakallaBinding

class BarakallaFragment : Fragment() {
  private val binding by lazy { FragmentBarakallaBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_barakallaFragment_to_sozlarFragment)
        }

        binding.btnHome.setOnClickListener {
            findNavController().navigate(R.id.action_barakallaFragment_to_homeFragment)
        }

        return binding.root
    }

}