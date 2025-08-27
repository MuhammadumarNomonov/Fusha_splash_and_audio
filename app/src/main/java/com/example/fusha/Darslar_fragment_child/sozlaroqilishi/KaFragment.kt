package com.example.fusha.Darslar_fragment_child.sozlaroqilishi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fusha.Darslar_fragment_child.sozlaroqilishi.yordamchi.LessonUtils
import com.example.fusha.R
import com.example.fusha.databinding.FragmentKaBinding

class KaFragment : Fragment() {
    private val currentLessonid = 11
 private val binding by lazy{ FragmentKaBinding.inflate(layoutInflater)}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.btnNext.setOnClickListener {
            val lamid = 12
            LessonUtils.markLessonAsSeen(requireContext(),lamid)
            findNavController().navigate(R.id.action_kaFragment_to_lamFragment)
        }

        return binding.root
    }



}