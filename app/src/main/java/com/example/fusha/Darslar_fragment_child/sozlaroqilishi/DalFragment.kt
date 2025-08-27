package com.example.fusha.Darslar_fragment_child.sozlaroqilishi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fusha.Darslar_fragment_child.sozlaroqilishi.yordamchi.LessonUtils
import com.example.fusha.R
import com.example.fusha.databinding.FragmentDalBinding

class DalFragment : Fragment() {
    private val currentLessonid = 29
private val binding by lazy { FragmentDalBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.btnNext.setOnClickListener {
            val test3fid = 30
            LessonUtils.markLessonAsSeen(requireContext(),test3fid)
            findNavController().navigate(R.id.action_dalFragment_to_test3Fragment)
        }

        return binding.root
    }

}