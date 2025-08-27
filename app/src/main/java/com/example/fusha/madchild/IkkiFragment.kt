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
import com.example.fusha.databinding.FragmentIkkiBinding

class IkkiFragment : Fragment() {
   private val binging by lazy {FragmentIkkiBinding.inflate(layoutInflater)}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binging.btnNext2.setOnClickListener {
            findNavController().navigate(R.id.action_ikkiFragment_to_uchFragment)
        }

        binging.btnPlayAudio.setOnClickListener {
            val youtubeURL ="https://www.youtube.com/watch?v=vgOlmQFUz_c"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(youtubeURL))
            startActivity(intent)
        }


     return binging.root
    }

}