package com.example.fusha.Darslar_fragment_child

import android.media.MediaPlayer
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
import com.example.fusha.databinding.FragmentHarflarBinding

data class Letter(
    val arabic: String,
    val uzbek: String,
    val soundResId: Int
)

class HarflarFragment : Fragment() {

    private var _binding: FragmentHarflarBinding? = null
    private val binding get() = _binding!!

    private var mediaPlayer: MediaPlayer? = null

    private val allLetters = listOf(
        Letter("ا", "Alif", R.raw.alif),
        Letter("ب", "Ba", R.raw.ba),
        Letter("ت", "Ta", R.raw.ta),
        Letter("ث", "S̱̱a", R.raw.sa),
        Letter("ج", "Jim", R.raw.jim),
        Letter("ح", "Ha", R.raw.ha),
        Letter("خ", "Kho", R.raw.xo),
        Letter("د", "Dal", R.raw.dal),
        Letter("ذ", "Zhal", R.raw.zal),
        Letter("ر", "Ro", R.raw.ro),
        Letter("ز", "Za", R.raw.zay),
        Letter("س", "Sin", R.raw.sin),
        Letter("ش", "Shin", R.raw.shin),
        Letter("ص", "Sod", R.raw.sod),
        Letter("ض", "Zod", R.raw.dod),
        Letter("ط", "To", R.raw.to),
        Letter("ظ", "Zo", R.raw.zo),
        Letter("ع", "Ayn", R.raw.ayn),
        Letter("غ", "G‘ayn", R.raw.goyn),
        Letter("ف", "Fa", R.raw.fa),
        Letter("ق", "Qof", R.raw.qof),
        Letter("ك", "Kaf", R.raw.kaf),
        Letter("ل", "Lam", R.raw.lam),
        Letter("م", "Mim", R.raw.miym),
        Letter("ن", "Nun", R.raw.nun),
        Letter("ه", "Ha", R.raw.hha),
        Letter("و", "Vov", R.raw.wow),
        Letter("ي", "Ya", R.raw.ya)
    )

    private val currentLessonId = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHarflarBinding.inflate(inflater, container, false)

        // Darsga kirildi deb belgilash
        LessonUtils.markLessonAsSeen(requireContext(), currentLessonId)

        showLetters()

        binding.continueButton.setOnClickListener {
            // (ixtiyoriy) Keyingi darsni ham bajarilgan deb belgilash
             LessonUtils.markLessonAsSeen(requireContext(), 1)

            findNavController().navigate(R.id.action_harflarFragment_to_hcompleteFragment)
        }

        return binding.root
    }

    private fun showLetters() {
        val gridLayout = binding.root.findViewById<GridLayout>(R.id.cardGrid)
        gridLayout.removeAllViews()
        val inflater = layoutInflater

        for (letter in allLetters) {
            val card = inflater.inflate(R.layout.harflar_cardview, gridLayout, false)

            val arabicText = card.findViewById<TextView>(R.id.arabicText)
            val uzbekText = card.findViewById<TextView>(R.id.uzbekText)
            val soundIcon = card.findViewById<ImageView>(R.id.voiceIcon)

            arabicText.text = letter.arabic
            uzbekText.text = letter.uzbek

            val playSound = {
                mediaPlayer?.release()
                mediaPlayer = MediaPlayer.create(requireContext(), letter.soundResId)
                mediaPlayer?.start()
            }

            card.setOnClickListener { playSound() }
            soundIcon.setOnClickListener { playSound() }

            gridLayout.addView(card)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mediaPlayer?.release()
        mediaPlayer = null
        _binding = null
    }
}
