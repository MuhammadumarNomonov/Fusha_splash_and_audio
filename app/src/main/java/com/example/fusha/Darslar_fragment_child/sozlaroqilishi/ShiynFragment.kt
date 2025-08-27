package com.example.fusha.Darslar_fragment_child.sozlaroqilishi

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fusha.Darslar_fragment_child.sozlaroqilishi.yordamchi.LessonUtils
import com.example.fusha.R
import com.example.fusha.databinding.FragmentShiynBinding

class ShiynFragment : Fragment() {
    private val currentLessonid = 18
 private val binding by lazy { FragmentShiynBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding.btnNext.setOnClickListener {
            val siynid = 19
            LessonUtils.markLessonAsSeen(requireContext(),siynid)
            findNavController().navigate(R.id.action_shiynFragment_to_siynFragment)
        }

      return binding.root


    }


    }
