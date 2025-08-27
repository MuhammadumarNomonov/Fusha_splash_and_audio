package com.example.fusha.Darslar_fragment_child.sozlaroqilishi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fusha.Darslar_fragment_child.sozlaroqilishi.yordamchi.LessonUtils
import com.example.fusha.R
import com.example.fusha.databinding.FragmentBaBinding

class BaFragment : Fragment() {
    private val currrentLessonid = 10
    private  val binding by lazy { FragmentBaBinding.inflate(layoutInflater) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.btnNext.setOnClickListener {
            val kafid = 11
            LessonUtils.markLessonAsSeen(requireContext(), kafid)
            findNavController().navigate(R.id.action_baFragment_to_kaFragment)
        }


      return binding.root
    }

}