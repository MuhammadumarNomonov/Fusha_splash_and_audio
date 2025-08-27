package com.example.fusha.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fusha.R
import com.example.fusha.databinding.FragmentInfoBinding

class InfoFragment : Fragment() {
   private val binding by lazy { FragmentInfoBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return binding.root
    }

}