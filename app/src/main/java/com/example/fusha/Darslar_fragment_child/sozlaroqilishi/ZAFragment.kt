package com.example.fusha.Darslar_fragment_child.sozlaroqilishi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fusha.Darslar_fragment_child.sozlaroqilishi.yordamchi.LessonUtils
import com.example.fusha.R
import com.example.fusha.databinding.FragmentZABinding

class ZAFragment : Fragment() {
    private  val currentLessonid = 4
   private  val binding by lazy { FragmentZABinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
     binding.btnNextZa.setOnClickListener {
         val mimid = 5
         LessonUtils.markLessonAsSeen(requireContext(), mimid)
    findNavController().navigate(R.id.action_ZAFragment_to_mimFragment)
}


        return binding.root
    }


}