package com.example.fusha.Darslar_fragment_child.sozlaroqilishi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fusha.Darslar_fragment_child.sozlaroqilishi.yordamchi.LessonUtils
import com.example.fusha.R
import com.example.fusha.databinding.FragmentSiynBinding

class SiynFragment : Fragment() {
    private val currentLessonid = 19
    private val binding by lazy { FragmentSiynBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.btnNext.setOnClickListener {
            val thinid = 20
            LessonUtils.markLessonAsSeen(requireContext(),thinid)
            findNavController().navigate(R.id.action_siynFragment_to_thinFragment)
        }

        return binding.root
    }

}