package com.example.fusha.Darslar_fragment_child.sozlaroqilishi

import android.content.res.Resources
import android.graphics.Color
import com.example.fusha.utils.dp
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.speech.tts.TextToSpeech
import android.view.ContextThemeWrapper
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fusha.Darslar_fragment_child.sozlaroqilishi.yordamchi.LessonUtils
import com.example.fusha.R
import com.example.fusha.databinding.FragmentMuammoTestBinding
import com.google.android.material.card.MaterialCardView
import java.util.*

class MuammoTestFragment : Fragment() {
    private val currentLessonid = 16

    private val binding by lazy { FragmentMuammoTestBinding.inflate(layoutInflater) }

    private val originalWords = listOf(
        "كُنْ", "كُمْ", "كَمْ", "اِبْنُ", "بِنْتُ", "اَبْ",
        "رَوْ", "اَوْ", "كَمُلَ", "لَمْ", "بَلْ", "اَلْ",
        "هَلْ",  "هَمْ", "هَبْ", "وَمَنْ", "لَوْ",
        "وَهَبْ","فَمْ","فَلَكْ","فَنْ","كَفْ",
    )

    private val availableWords = originalWords.toMutableList()
    private lateinit var currentWord: String
    private val selectedLetters = mutableListOf<String>()
    private lateinit var tts: TextToSpeech
    private lateinit var letterButtons: List<TextView>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        initTTS()
        initLetterButtons()
        return binding.root
    }

    private fun initTTS() {
        tts = TextToSpeech(requireContext()) { status ->
            if (status == TextToSpeech.SUCCESS) {
                tts.language = Locale("ar")
                loadRandomWord()
            }
        }
    }

    private fun initLetterButtons() {
        letterButtons = listOf(
            binding.btnChar1, binding.btnChar2, binding.btnChar3, binding.btnChar4,
            binding.btnChar5, binding.btnChar6, binding.btnChar7, binding.btnChar8,
        )

        letterButtons.forEach { button ->
            button.setOnClickListener {
                val letter = button.text.toString()
                if (letter.isNotBlank()) {
                    animateFlyUp(button)
                    addLetterToWord(letter)
                }
            }
        }

        binding.btnTekshirishNext.setOnClickListener {
            val qoid = 17
            LessonUtils.markLessonAsSeen(requireContext(),qoid)
             findNavController().navigate(R.id.action_muammoTestFragment_to_qoFragment)
        }

        binding.layoutWordSlotsMuammo.setOnClickListener {
            selectedLetters.clear()
            loadSelectedLetters()
        }

        binding.btnVolumeMuammo.setOnClickListener {
            speakWord(currentWord)
        }
    }

    private fun animateFlyUp(view: View) {
        val animation = AnimationUtils.loadAnimation(requireContext(), R.anim.slide_up)
        view.startAnimation(animation)
    }

    private fun loadRandomWord() {
        if (availableWords.isEmpty()) {
            showToast("🎉 Barcha so‘zlar tugadi!", R.drawable.ic_correct)
            binding.progressBar.progress = 100
            binding.btnTekshirishNext.visibility = View.VISIBLE
            return
        }

        selectedLetters.clear()
        currentWord = availableWords.random()
        availableWords.remove(currentWord)

        loadLetterOptions()
        loadSelectedLetters()
        speakWord(currentWord)
        updateProgressBar()

        binding.btnTekshirishNext.visibility = View.GONE
    }

    private fun updateProgressBar() {
        val total = originalWords.size
        val used = total - availableWords.size
        val progressPercent = ((used.toFloat() / total) * 100).toInt()
        binding.progressBar.progress = progressPercent
    }

    private fun parseArabicWord(word: String): List<String> {
        val result = mutableListOf<String>()
        var buffer = ""

        for (char in word) {
            if (char in listOf('َ', 'ُ', 'ِ', 'ْ', 'ّ')) {
                buffer += char
                result.add(buffer)
                buffer = ""
            } else {
                if (buffer.isNotEmpty()) result.add(buffer)
                buffer = "$char"
            }
        }

        if (buffer.isNotEmpty()) result.add(buffer)
        return result
    }

    private fun loadLetterOptions() {
        val wordUnits = parseArabicWord(currentWord).shuffled()

        for (i in letterButtons.indices) {
            if (i < wordUnits.size) {
                letterButtons[i].visibility = View.VISIBLE
                letterButtons[i].text = wordUnits[i]
            } else {
                letterButtons[i].visibility = View.INVISIBLE
            }
        }
    }

    private fun loadSelectedLetters() {
        binding.layoutWordSlotsMuammo.removeAllViews()

        val themedContext = ContextThemeWrapper(requireContext(), com.google.android.material.R.style.Theme_MaterialComponents_Light)

        val wordTextView = TextView(themedContext).apply {
            text = selectedLetters.joinToString("")
            textSize = 26f
            setTextColor(Color.BLACK)
            gravity = Gravity.CENTER
            textAlignment = View.TEXT_ALIGNMENT_CENTER
            textDirection = View.TEXT_DIRECTION_RTL
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }

        val card = MaterialCardView(themedContext).apply {
            radius = 12f
            setCardBackgroundColor(Color.WHITE)
            cardElevation = 6f

            strokeWidth = 2
            strokeColor = Color.GRAY
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                setMargins(16.dp, 8.dp, 16.dp, 8.dp)
            }
            addView(wordTextView)
        }

        binding.layoutWordSlotsMuammo.addView(card)
    }

    private fun addLetterToWord(letter: String) {
        val wordUnits = parseArabicWord(currentWord)
        if (selectedLetters.size < wordUnits.size) {
            selectedLetters.add(letter)
            loadSelectedLetters()

            if (selectedLetters.size == wordUnits.size) {
                val userWord = selectedLetters.joinToString("")
                if (userWord == currentWord) {
                    showToast(" To‘g‘ri!", R.drawable.ic_correct)
                    Handler(Looper.getMainLooper()).postDelayed({ loadRandomWord() }, 1500)
                } else {
                    showToast(" Noto‘g‘ri", R.drawable.ic_wrong)
                    Handler(Looper.getMainLooper()).postDelayed({
                        selectedLetters.clear()
                        loadSelectedLetters()
                    }, 1500)
                }
            }
        }
    }

    private fun speakWord(word: String) {
        tts.speak(word, TextToSpeech.QUEUE_FLUSH, null, null)
    }

    override fun onDestroy() {
        super.onDestroy()
        tts.shutdown()
    }

    private fun showToast(message: String, iconResId: Int) {
        val toast = Toast(requireContext())
        toast.duration = Toast.LENGTH_SHORT

        val layout = LinearLayout(requireContext()).apply {
            orientation = LinearLayout.HORIZONTAL
            setPadding(24, 16, 24, 16)
            setBackgroundResource(R.drawable.toast_background)
            gravity = Gravity.CENTER_VERTICAL
        }

        val icon = ImageView(requireContext()).apply {
            setImageResource(iconResId)
            layoutParams = LinearLayout.LayoutParams(60, 60).apply {
                rightMargin = 16
            }
        }

        val text = TextView(requireContext()).apply {
            text = message
            setTextColor(Color.WHITE)
            textSize = 16f
        }

        layout.addView(icon)
        layout.addView(text)

        toast.view = layout
        toast.setGravity(Gravity.CENTER_HORIZONTAL or Gravity.BOTTOM, 0, 120)
        toast.show()
    }
}
