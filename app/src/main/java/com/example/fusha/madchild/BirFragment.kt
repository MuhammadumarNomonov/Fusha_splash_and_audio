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
import com.example.fusha.databinding.FragmentBirBinding

class BirFragment : Fragment() {
   private val binding by lazy { FragmentBirBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_birFragment_to_ikkiFragment)
        }

        binding.btnPlay.setOnClickListener {
            val youtubeURL ="https://www.youtube.com/watch?v=CKHo9_F0g2E"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(youtubeURL))
            startActivity(intent)
        }

        return binding.root
    }


}