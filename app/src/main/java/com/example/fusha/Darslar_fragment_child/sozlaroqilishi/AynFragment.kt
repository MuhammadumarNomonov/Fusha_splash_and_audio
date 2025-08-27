package com.example.fusha.Darslar_fragment_child.sozlaroqilishi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fusha.Darslar_fragment_child.sozlaroqilishi.yordamchi.LessonUtils
import com.example.fusha.R
import com.example.fusha.databinding.FragmentAynBinding

class AynFragment : Fragment() {
    private val currentLessonid = 28
   private val binding by lazy { FragmentAynBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.btnNext.setOnClickListener {
            val dalid = 29
            LessonUtils.markLessonAsSeen(requireContext(),dalid)
            findNavController().navigate(R.id.action_aynFragment_to_dalFragment)
        }

        return  binding.root
    }

}