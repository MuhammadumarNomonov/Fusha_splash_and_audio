package com.example.fusha.Darslar_fragment_child.sozlaroqilishi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fusha.Darslar_fragment_child.sozlaroqilishi.yordamchi.LessonUtils
import com.example.fusha.R
import com.example.fusha.databinding.FragmentGooBinding

class GooFragment : Fragment() {
    private  val currentLessonid = 27
  private val binding by lazy { FragmentGooBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.btnNext.setOnClickListener {
            val aynid = 28
            LessonUtils.markLessonAsSeen(requireContext(),aynid)
            findNavController().navigate(R.id.action_gooFragment_to_aynFragment)
        }

        return binding.root
    }

}