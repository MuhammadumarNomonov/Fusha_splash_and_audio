package com.example.fusha.Darslar_fragment_child.sozlaroqilishi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fusha.Darslar_fragment_child.sozlaroqilishi.yordamchi.LessonUtils
import com.example.fusha.R
import com.example.fusha.databinding.FragmentThinBinding

class ThinFragment : Fragment() {
    private val currentLessonid = 20
    private val binding by lazy { FragmentThinBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding.btnNext.setOnClickListener {
            val sodid = 21
            LessonUtils.markLessonAsSeen(requireContext(),sodid)
            findNavController().navigate(R.id.action_thinFragment_to_sodFragment)
        }
        return binding.root

    }

}