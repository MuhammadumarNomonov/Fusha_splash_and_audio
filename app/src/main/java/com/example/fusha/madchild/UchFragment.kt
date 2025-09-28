package com.example.fusha.madchild

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fusha.R
import com.example.fusha.databinding.FragmentUchBinding

class UchFragment : Fragment() {
   private val binding by lazy { FragmentUchBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding.btnNext3.setOnClickListener {
            findNavController().navigate(R.id.action_uchFragment_to_tortFragment)
        }


        binding.btnPlayAudio.setOnClickListener {
            val youtubeURL ="https://www.youtube.com/watch?v=_TM-d5yUoGQ"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(youtubeURL))
            startActivity(intent)
        }


        return binding.root
    }


}