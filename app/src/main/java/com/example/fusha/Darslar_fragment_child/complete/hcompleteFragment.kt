
package com.example.fusha.Darslar_fragment_child.complete


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fusha.R
import com.example.fusha.databinding.FragmentHcompleteBinding

class HcompleteFragment : Fragment() {
    private val binding by lazy { FragmentHcompleteBinding.inflate(layoutInflater) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        binding.nextLessonButton.setOnClickListener {
            findNavController().navigate(R.id.action_hcompleteFragment_to_sinovFragment)
        }


        return binding.root
    }


}
