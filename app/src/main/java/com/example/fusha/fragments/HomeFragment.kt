package com.example.fusha.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fusha.R
import com.example.fusha.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.login.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
        }

        binding.kitob.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_darslarFragment)
        }

        binding.sms.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_sozlarFragment)
        }

        binding.qoida.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_qoidaFragment)
        }

        binding.test.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_testFragment)
        }

    binding.restrat.setOnClickListener {
          findNavController().navigate(R.id.action_homeFragment_to_restartFragment)
       }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
