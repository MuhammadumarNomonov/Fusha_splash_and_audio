package com.example.fusha.Tashdid

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fusha.R
import com.example.fusha.databinding.FragmentTashdid1Binding

class Tashdid1Fragment : Fragment() {
    private val binding by lazy { FragmentTashdid1Binding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_tashdid1Fragment_to_tashdid2Fragment)
        }


           binding.btnPlay.setOnClickListener {
               val youtubeURL = "https://www.youtube.com/watch?v=9CZ4d1rOHgk"
               val intent = Intent(Intent.ACTION_VIEW,Uri.parse(youtubeURL))
               startActivity(intent)
           }



        return binding.root
    }



    }

