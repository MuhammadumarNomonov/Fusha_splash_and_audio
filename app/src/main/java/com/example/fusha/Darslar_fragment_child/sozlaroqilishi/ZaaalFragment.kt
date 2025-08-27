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
import com.example.fusha.databinding.FragmentZaaalBinding

class ZaaalFragment : Fragment() {
    private val currentLessonid = 32
  private val binding by lazy { FragmentZaaalBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

           binding.btnNext.setOnClickListener {
               val zoooid = 33
               LessonUtils.markLessonAsSeen(requireContext(),zoooid)
               findNavController().navigate(R.id.action_zaaalFragment_to_zooFragment)
           }

        return  binding.root
    }


}