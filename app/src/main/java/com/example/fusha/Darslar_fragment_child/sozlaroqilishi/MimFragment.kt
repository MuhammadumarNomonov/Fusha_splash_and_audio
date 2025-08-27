package com.example.fusha.Darslar_fragment_child.sozlaroqilishi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fusha.Darslar_fragment_child.sozlaroqilishi.yordamchi.LessonUtils
import com.example.fusha.R
import com.example.fusha.databinding.FragmentMimBinding

class MimFragment : Fragment() {
    private  val currentLessonid = 5
        private val binding by lazy {FragmentMimBinding.inflate(layoutInflater)}


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.btnNextM.setOnClickListener {
            val taid = 6
            LessonUtils.markLessonAsSeen(requireContext(), taid)
            findNavController().navigate(R.id.action_mimFragment_to_TAFragment)

        }



        return binding.root

    }


}