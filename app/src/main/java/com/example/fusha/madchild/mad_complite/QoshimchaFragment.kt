package com.example.fusha.madchild.mad_complite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fusha.R
import com.example.fusha.databinding.FragmentQoshimchaBinding

class QoshimchaFragment : Fragment() {

    private var _binding: FragmentQoshimchaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQoshimchaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lottieAnim.setAnimation(R.raw.done)
        binding.lottieAnim.repeatCount = 0
        binding.lottieAnim.playAnimation()

        binding.nextButton.setOnClickListener {
         findNavController().navigate(R.id.action_qoshimchaFragment_to_tashdid1Fragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
