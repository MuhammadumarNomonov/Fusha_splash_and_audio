package com.example.fusha.Darslar_fragment_child.sozlaroqilishi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fusha.Darslar_fragment_child.sozlaroqilishi.yordamchi.LessonUtils
import com.example.fusha.R
import com.example.fusha.databinding.FragmenthaBinding

class HaFragment : Fragment() {
    private val currentLessonid = 14


  private val binding by lazy {FragmenthaBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

      binding.btnNext.setOnClickListener {
          val faid = 15
          LessonUtils.markLessonAsSeen(requireContext(),faid)
          findNavController().navigate(R.id.action_HaFragment_to_faFragment)
      }

        return binding.root
    }

}