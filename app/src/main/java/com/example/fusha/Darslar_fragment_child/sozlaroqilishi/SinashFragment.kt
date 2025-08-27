package com.example.fusha.Darslar_fragment_child.sozlaroqilishi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fusha.R
import com.example.fusha.databinding.FragmentSinashBinding
import com.example.fusha.databinding.FragmentSinovBinding

class SinashFragment : Fragment() {
 private val binding by lazy{ FragmentSinashBinding.inflate(layoutInflater)}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return binding.root
    }


}