package com.example.fusha.Darslar_fragment_child.sozlaroqilishi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fusha.Darslar_fragment_child.sozlaroqilishi.yordamchi.LessonUtils
import com.example.fusha.R
import com.example.fusha.databinding.FragmentXooBinding

class XooFragment : Fragment() {
    private val currentLessonid = 25
 private val binding by lazy { FragmentXooBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.btnNext.setOnClickListener {
            val haid = 26
            LessonUtils.markLessonAsSeen(requireContext(),haid)
            findNavController().navigate(R.id.action_xooFragment_to_haaFragment)
        }

        return  binding.root

    }

}