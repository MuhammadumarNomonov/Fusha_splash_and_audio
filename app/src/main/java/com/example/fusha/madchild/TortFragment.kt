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
import com.example.fusha.databinding.FragmentTortBinding

class TortFragment : Fragment() {
    private val binding by lazy { FragmentTortBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.btnPlay.setOnClickListener {
            val youtubeURL ="https://www.youtube.com/watch?v=JchWzJZyFUs"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(youtubeURL))
            startActivity(intent)
        }

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_tortFragment_to_beshFragment)
        }


        return binding.root
    }

}