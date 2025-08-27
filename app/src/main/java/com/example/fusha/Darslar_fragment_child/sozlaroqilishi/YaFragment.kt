package com.example.fusha.Darslar_fragment_child.sozlaroqilishi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fusha.Darslar_fragment_child.sozlaroqilishi.yordamchi.LessonUtils
import com.example.fusha.R
import com.example.fusha.databinding.FragmentYaBinding

class YaFragment : Fragment() {
    private val currentLessonid = 8
    private val binding by lazy { FragmentYaBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.btnNext.setOnClickListener {
            val bsht = 9
            LessonUtils.markLessonAsSeen(requireContext(), bsht)
            findNavController().navigate(R.id.action_yaFragment_to_boshlangichTestFragment)
        }

      return binding.root
    }


}