package com.example.fusha.Darslar_fragment_child.sozlaroqilishi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fusha.Darslar_fragment_child.sozlaroqilishi.yordamchi.LessonUtils
import com.example.fusha.R
import com.example.fusha.databinding.FragmentTABinding

class TAFragment : Fragment() {
    private  val currentLessonid = 6
    private val binding by lazy { FragmentTABinding.inflate(layoutInflater) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding.btnNextT.setOnClickListener {
            val naid = 7
            LessonUtils.markLessonAsSeen(requireContext(), naid)
            findNavController().navigate(R.id.action_TAFragment_to_naFragment)
        }

        return  binding.root
    }


}