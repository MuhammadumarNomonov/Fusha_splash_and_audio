package com.example.fusha.Darslar_fragment_child.sozlaroqilishi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fusha.Darslar_fragment_child.sozlaroqilishi.yordamchi.LessonUtils
import com.example.fusha.R
import com.example.fusha.databinding.FragmentSodBinding

class SodFragment : Fragment() {
    private val currentLessonid = 21
   private val binding by lazy { FragmentSodBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

      binding.btnNext.setOnClickListener {
          val toid = 22
          LessonUtils.markLessonAsSeen(requireContext(),toid)
          findNavController().navigate(R.id.action_sodFragment_to_toFragment)
      }

        return binding.root
    }



}