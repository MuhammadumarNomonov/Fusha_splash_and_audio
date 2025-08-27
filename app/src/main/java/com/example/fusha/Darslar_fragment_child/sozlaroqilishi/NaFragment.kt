package com.example.fusha.Darslar_fragment_child.sozlaroqilishi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fusha.Darslar_fragment_child.sozlaroqilishi.yordamchi.LessonUtils
import com.example.fusha.R
import com.example.fusha.databinding.FragmentNaBinding

class NaFragment : Fragment() {
    private  val currentLessonid = 7
   private val binding by lazy { FragmentNaBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.btnNext.setOnClickListener {
            val yaid = 8
            LessonUtils.markLessonAsSeen(requireContext(), yaid)
            findNavController().navigate(R.id.action_naFragment_to_yaFragment)
        }



     return binding.root

    }

}