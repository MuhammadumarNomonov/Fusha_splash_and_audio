package com.example.fusha.madchild

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.gridlayout.widget.GridLayout
import androidx.navigation.fragment.findNavController
import com.example.fusha.Darslar_fragment_child.sozlaroqilishi.yordamchi.LessonUtils
import com.example.fusha.R
import com.example.fusha.databinding.FragmentBeshBinding
import com.example.fusha.databinding.FragmentHarflarBinding

data class MadLetter(
    val arabic: String,
    val uzbek: String

)

class BeshFragment : Fragment() {

    private var _binding: FragmentBeshBinding? = null
    private val binding get() = _binding!!

    // 🔹 Mad bilan yozilgan harflar
    private val allLetters = listOf(
        MadLetter("بَا", "Bā"),
        MadLetter("بِي", "Bī"),
        MadLetter("بُو", "Bū"),

        MadLetter("مَا", "Mā"),
        MadLetter("مِي", "Mī"),
        MadLetter("مُو", "Mū"),

        MadLetter("تَا", "Tā"),
        MadLetter("تِي", "Tī"),
        MadLetter("تُو", "Tū"),

        MadLetter("فَا", "Fā"),
        MadLetter("فِي", "Fī"),
        MadLetter("فُو", "Fū")
    )

    private val currentLessonId = 4  // 5-dars uchun (0 dan boshlangan indeks)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBeshBinding.inflate(inflater, container, false)


        showLetters()

        binding.nextbutton.setOnClickListener {

            findNavController().navigate(R.id.action_beshFragment_to_qoshimchaFragment)
        }

        return binding.root
    }

    private fun showLetters() {
        val gridLayout = binding.root.findViewById<GridLayout>(R.id.cardGrid2)
        gridLayout.removeAllViews()
        val inflater = layoutInflater

        for (letter in allLetters) {
            val card = inflater.inflate(R.layout.mad_hafr_card, gridLayout, false)

            val arabicText2 = card.findViewById<TextView>(R.id.arabicText2)
            val uzbekText2 = card.findViewById<TextView>(R.id.uzbekText2)
            val soundIcon = card.findViewById<ImageView>(R.id.voiceIcon2)

            arabicText2.text = letter.arabic
            uzbekText2.text = letter.uzbek

            // 🔇 Audio ijro qismini hozircha kommentga olindi
            /*
            val playSound = {
                mediaPlayer?.release()
                mediaPlayer = MediaPlayer.create(requireContext(), letter.soundResId)
                mediaPlayer?.start()
            }

            card.setOnClickListener { playSound() }
            soundIcon.setOnClickListener { playSound() }
            */

            gridLayout.addView(card)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
