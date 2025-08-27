package com.example.fusha.Darslar_fragment_child.sozlaroqilishi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fusha.Darslar_fragment_child.sozlaroqilishi.yordamchi.LessonUtils
import com.example.fusha.R
import com.example.fusha.databinding.FragmentLamBinding

class LamFragment : Fragment() {
    private val currentLessonid = 12
    private  val binding by lazy{ FragmentLamBinding.inflate(layoutInflater)}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.btnNext.setOnClickListener {
            val wawid = 13
            LessonUtils.markLessonAsSeen(requireContext(),wawid)
            findNavController().navigate(R.id.action_lamFragment_to_wawFragment)
        }

        return binding.root

    }


}