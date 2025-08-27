package com.example.fusha.Darslar_fragment_child.sozlaroqilishi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fusha.Darslar_fragment_child.sozlaroqilishi.yordamchi.LessonUtils
import com.example.fusha.R
import com.example.fusha.databinding.FragmentZooBinding

class ZooFragment : Fragment() {
    private val currentLessonid = 33
  private val binding by lazy { FragmentZooBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

      binding.btnNext.setOnClickListener {
          findNavController().navigate(R.id.action_zooFragment_to_barakallaFragment)
      }

        return binding.root
    }


}