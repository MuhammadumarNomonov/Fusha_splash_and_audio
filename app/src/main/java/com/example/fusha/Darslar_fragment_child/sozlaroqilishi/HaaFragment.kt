package com.example.fusha.Darslar_fragment_child.sozlaroqilishi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fusha.Darslar_fragment_child.sozlaroqilishi.yordamchi.LessonUtils
import com.example.fusha.R
import com.example.fusha.databinding.FragmentHaaBinding

class HaaFragment : Fragment() {
    private val currentLessonid = 26
 private val binding by lazy { FragmentHaaBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

      binding.btnNext.setOnClickListener {
          val goid = 27
          LessonUtils.markLessonAsSeen(requireContext(),goid)
          findNavController().navigate(R.id.action_haaFragment_to_gooFragment)
      }


        return binding.root

    }



}