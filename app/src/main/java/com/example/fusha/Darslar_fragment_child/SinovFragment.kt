package com.example.fusha.Darslar_fragment_child

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.fusha.Darslar_fragment_child.sozlaroqilishi.yordamchi.LessonUtils
import com.example.fusha.R
import com.example.fusha.databinding.FragmentSinovBinding

data class ArabicLetter(
    val arabic: String,
    val uzbek: String,
    val audioResId: Int
)

class SinovFragment : Fragment() {

    private lateinit var binding: FragmentSinovBinding
    private lateinit var correctLetter: ArabicLetter
    private var mediaPlayer: MediaPlayer? = null
    private val usedLetters = mutableSetOf<ArabicLetter>()
    private var correctAnswerCount = 0

    private val lessonid = 1

    private val arabLetters = listOf(
        ArabicLetter("ا", "alif", R.raw.alif),
        ArabicLetter("ب", "ba", R.raw.ba),
        ArabicLetter("ت", "ta", R.raw.ta),
        ArabicLetter("ث", "sa", R.raw.sa),
        ArabicLetter("ج", "jim", R.raw.jim),
        ArabicLetter("ح", "ho", R.raw.ha),
        ArabicLetter("خ", "kho", R.raw.xo),
        ArabicLetter("د", "dal", R.raw.dal),
        ArabicLetter("ذ", "zal", R.raw.zal),
        ArabicLetter("ر", "ro", R.raw.ro),
        ArabicLetter("ز", "za", R.raw.zay),
        ArabicLetter("س", "sin", R.raw.sin),
        ArabicLetter("ش", "shin", R.raw.shin),
        ArabicLetter("ص", "sod", R.raw.sod),
        ArabicLetter("ض", "dod", R.raw.dod),
        ArabicLetter("ط", "to", R.raw.to),
        ArabicLetter("ظ", "zo", R.raw.zo),
        ArabicLetter("ع", "ayn", R.raw.ayn),
        ArabicLetter("غ", "g‘ayn", R.raw.goyn),
        ArabicLetter("ف", "fa", R.raw.fa),
        ArabicLetter("ق", "qof", R.raw.qof),
        ArabicLetter("ك", "kaf", R.raw.kaf),
        ArabicLetter("ل", "lam", R.raw.lam),
        ArabicLetter("م", "mim", R.raw.miym),
        ArabicLetter("ن", "nun", R.raw.nun),
        ArabicLetter("ه", "ha", R.raw.hha),
        ArabicLetter("و", "vov", R.raw.wow),
        ArabicLetter("ي", "ya", R.raw.ya)
    )

    private val buttons by lazy {
        listOf(
            binding.optionButton1,
            binding.optionbutton2,
            binding.optionButton3,
            binding.optionButton4
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSinovBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        LessonUtils.markLessonAsSeen(requireContext(), lessonid)

        binding.playAgainButton.setOnClickListener {
            mediaPlayer?.seekTo(0)
            mediaPlayer?.start()
        }

        binding.nextButton01.setOnClickListener {
            val harftuzilishiid = 2
            LessonUtils.markLessonAsSeen(requireContext(), harftuzilishiid)

            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.sinovFragment, true) // back stackni tozalaydi
                .build()

            findNavController().navigate(
                R.id.action_sinovFragment_to_harftuzilishi,
                null,
                navOptions
            )
        }


        binding.progressBar.max = arabLetters.size



        binding.progressBar.progress = correctAnswerCount

        loadNewTest()
    }

    fun loadNewTest() {
        if (usedLetters.size == arabLetters.size) {
            showTestFinishedDialog()
            return
        }

        resetButtons()

        val remainingLetters = arabLetters.filterNot { it in usedLetters }
        correctLetter = remainingLetters.random()
        usedLetters.add(correctLetter)

        safePlayAudio(correctLetter.audioResId)

        val options = (arabLetters - correctLetter).shuffled().take(3) + correctLetter
        val shuffledOptions = options.shuffled()

        buttons.forEachIndexed { index, button ->
            val letter = shuffledOptions[index]
            button.text = letter.arabic
            button.setOnClickListener {
                handleAnswerSelected(letter, index, shuffledOptions)
            }
        }
    }

    private fun handleAnswerSelected(
        selectedLetter: ArabicLetter,
        selectedIndex: Int,
        allOptions: List<ArabicLetter>
    ) {
        disableButtons()

        if (selectedLetter == correctLetter) {
            buttons[selectedIndex].setBackgroundResource(R.drawable.correct_option_background)
            Toast.makeText(requireContext(), "✅ To‘g‘ri!", Toast.LENGTH_SHORT).show()
            correctAnswerCount++
            binding.progressBar.progress = correctAnswerCount
        } else {
            buttons[selectedIndex].setBackgroundResource(R.drawable.wrong_option_background)
            showCorrectAnswer(allOptions)
            Toast.makeText(requireContext(), "❌ Noto‘g‘ri!", Toast.LENGTH_SHORT).show()
        }

        binding.root.postDelayed({ loadNewTest() }, 2000)
    }

    private fun showCorrectAnswer(options: List<ArabicLetter>) {
        val correctIndex = options.indexOf(correctLetter)
        if (correctIndex in buttons.indices) {
            buttons[correctIndex].setBackgroundResource(R.drawable.correct_option_background)
        }
    }

    private fun resetButtons() {
        buttons.forEach {
            it.setBackgroundResource(R.drawable.default_option_background)
            it.isEnabled = true
        }
    }

    private fun disableButtons() {
        buttons.forEach { it.isEnabled = false }
    }

    private fun safePlayAudio(audioResId: Int) {
        context?.let {
            mediaPlayer?.release()
            mediaPlayer = MediaPlayer.create(it, audioResId)
            mediaPlayer?.start()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mediaPlayer?.release()
        mediaPlayer = null
    }

    private fun showTestFinishedDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle("Test tugadi")
            .setMessage("🎉 28 ta harfni to‘liq tanidingiz!\nKeyingi bosqichga o‘tmoqchimisiz?")
            .setCancelable(false)
            .setPositiveButton("Ha") { _, _ ->
                findNavController().navigate(R.id.action_sinovFragment_to_kalimaFragment)
            }
            .setNegativeButton("Yo‘q") { dialog, _ -> dialog.dismiss() }
            .show()
    }
}