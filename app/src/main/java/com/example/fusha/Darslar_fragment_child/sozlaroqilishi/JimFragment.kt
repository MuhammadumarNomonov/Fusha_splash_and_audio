package com.example.fusha.Darslar_fragment_child.sozlaroqilishi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fusha.Darslar_fragment_child.sozlaroqilishi.yordamchi.LessonUtils
import com.example.fusha.R
import com.example.fusha.databinding.FragmentJimBinding

class JimFragment : Fragment() {
    private val currentLessonid = 24
   private val binding by lazy { FragmentJimBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

  binding.btnNext.setOnClickListener {
      val xooid = 25
      LessonUtils.markLessonAsSeen(requireContext(),xooid)
      findNavController().navigate(R.id.action_jimFragment_to_xooFragment)
  }

        return binding.root
    }


}