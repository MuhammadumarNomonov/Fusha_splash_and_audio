package com.example.fusha.Darslar_fragment_child.sozlaroqilishi

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fusha.Darslar_fragment_child.sozlaroqilishi.yordamchi.LessonUtils
import com.example.fusha.R
import com.example.fusha.databinding.FragmentQoBinding

class QoFragment : Fragment() {
    private val currentLessonid = 17
    private val binding by lazy { FragmentQoBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding.btnNext.setOnClickListener {
            val shiynid = 18
            LessonUtils.markLessonAsSeen(requireContext(),shiynid)
            findNavController().navigate(R.id.action_qoFragment_to_shiynFragment)
        }

        binding.btncancel.setOnClickListener {
            findNavController().navigate(R.id.action_qoFragment_to_darslarFragment)
        }

        return binding.root
    }
}
