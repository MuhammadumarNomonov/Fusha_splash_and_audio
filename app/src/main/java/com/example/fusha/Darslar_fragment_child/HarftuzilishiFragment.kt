package com.example.fusha.Darslar_fragment_child

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fusha.R
import com.example.fusha.databinding.FragmentHarftuzilishiBinding
import androidx.core.graphics.toColorInt
import com.example.fusha.Darslar_fragment_child.sozlaroqilishi.yordamchi.LessonUtils

class HarftuzilishiFragment : Fragment() {
    private  val currentLessonid = 2

 private val binding by lazy { FragmentHarftuzilishiBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        // Tugmani boshlanishda o‘chirib qo‘yamiz va rangini kul qilamiz
        binding.agreeButton.isEnabled = false
        binding.agreeButton.setBackgroundColor("#BDBDBD".toColorInt()) // kul rang

        // ScrollView oxirigacha skroll bo‘lsa, tugma faollashadi va yashil bo‘ladi
        binding.scrollView.viewTreeObserver.addOnScrollChangedListener {
            val view = binding.scrollView.getChildAt(0)
            val diff = view.bottom - (binding.scrollView.height + binding.scrollView.scrollY)

            if (diff <= 0) {
                binding.agreeButton.isEnabled = true
                binding.agreeButton.setBackgroundColor("#4CAF50".toColorInt()) // yashil
            }
        }

        binding.agreeButton.setOnClickListener {
            val navOptions = androidx.navigation.NavOptions.Builder()
                .setEnterAnim(android.R.anim.fade_in)
                .setExitAnim(android.R.anim.fade_out)
                .build()
            val alifroId = 3
            LessonUtils.markLessonAsSeen(requireContext(), alifroId)
            findNavController().navigate(
                R.id.action_harftuzilishi_to_sozlarningoqilishiFragment,
                null,
                navOptions
            )
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        LessonUtils.markLessonAsSeen(requireContext(), currentLessonid)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}
