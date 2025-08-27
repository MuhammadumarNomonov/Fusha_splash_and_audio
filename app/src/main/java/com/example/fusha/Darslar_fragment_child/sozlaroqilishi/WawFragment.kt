package com.example.fusha.Darslar_fragment_child.sozlaroqilishi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fusha.Darslar_fragment_child.sozlaroqilishi.yordamchi.LessonUtils
import com.example.fusha.R
import com.example.fusha.databinding.FragmentWawBinding

class WawFragment : Fragment() {
    private val currentLessonid = 13
   private val binding by lazy { FragmentWawBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

binding.btnNext.setOnClickListener {
    val ymhaid = 14
    LessonUtils.markLessonAsSeen(requireContext(),ymhaid)
    findNavController().navigate(R.id.action_wawFragment_to_ymHaFragment)
}

        return binding.root
    }


}