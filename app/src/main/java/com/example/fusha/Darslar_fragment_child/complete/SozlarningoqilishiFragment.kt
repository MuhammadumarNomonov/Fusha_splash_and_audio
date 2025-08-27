package com.example.fusha.Darslar_fragment_child.complete

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fusha.Darslar_fragment_child.sozlaroqilishi.yordamchi.LessonUtils
import com.example.fusha.R
import com.example.fusha.databinding.FragmentSozlarningoqilishiBinding

class SozlarningoqilishiFragment : Fragment() {
    private  val currentLessonid = 3
        private val binding by lazy {FragmentSozlarningoqilishiBinding.inflate(layoutInflater)}


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.btnNext.setOnClickListener {
            val zayid = 4
            LessonUtils.markLessonAsSeen(requireContext(), zayid)
            findNavController().navigate(R.id.action_sozlarningoqilishiFragment_to_ZAFragment)
        }


        return binding.root


    }


}