package com.example.fusha.mad_chozish

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fusha.R
import com.example.fusha.databinding.FragmentSozlarBinding
import com.example.fusha.databinding.Mad2Binding

@Suppress("DUPLICATE_LABEL_IN_WHEN")
class SozlarFragment : Fragment() {

    private var _binding: FragmentSozlarBinding? = null
    private val binding get() = _binding!!

    private var currentSection = -1

    private val dataList = listOf(
        MyData2("1-Dars Madd Nima?", "10/10"),
        MyData2("2-Dars Madd Tabi'iy", "10/10"),
        MyData2("3-Dars Mad Muttasil va Mad Munfasil", "10/10"),
        MyData2("4", "10/10"),
        MyData2("5", "10/10"),
        MyData2("Miym-م", "10/10"),
        MyData2("Taa-ت","10/10"),
        MyData2("Nuun-ن", "10/10"),
        MyData2("Yaa-ي", "10/10"),
        MyData2("Test", "10/10"),
        MyData2("Baa-ب", "10/10"),
        MyData2("Kaaf-ك", "10/10"),
        MyData2("Laam-ل", "10/10"),
        MyData2("Waaw-و", "10/10"),
        MyData2("Ha-ه", "10/10"),
        MyData2("Faa-ف", "10/10"),
        MyData2("Test", "10/10"),
        MyData2("Qoof-ق","10/10"),
        MyData2("Shiyn-ش", "10/10"),
        MyData2("Siyn-س", "10/10"),
        MyData2("Tha-ث", "10/10"),
        MyData2("Sood-ص", "10/10"),
        MyData2("Too-ط","10/10"),
        MyData2("Test", "10/10"),
        MyData2("Jiym-ج", "10/10"),
        MyData2("Xoo-خ", "10/10"),
        MyData2("Haa-ح", "10/10"),
        MyData2("G’oo-غ", "10/10"),
        MyData2("Âyn-ع","10/10"),
        MyData2("Daal-د", "10/10"),
        MyData2("Test", "10/10"),
        MyData2("Ďood-ض", "10/10"),
        MyData2("Źaal-ذ", "10/10"),
        MyData2("Žoo-ظ", "10/10")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSozlarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val layoutManager = LinearLayoutManager(requireContext())
        binding.recycle2.layoutManager = layoutManager

        val adapter = Adapter2(dataList) { item, position ->
            markLessonAsSeen(position)
            updateProgressBar()



            when (position) {
                0 -> findNavController().navigate(R.id.action_sozlarFragment_to_birFragment)
                1 -> findNavController().navigate(R.id.action_sozlarFragment_to_ikkiFragment)
                2 -> findNavController().navigate(R.id.action_sozlarFragment_to_uchFragment)

            }

        }

        binding.recycle2.adapter = adapter
        updateProgressBar()
        updateClassHeader(1)

        binding.recycle2.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(rv: RecyclerView, dx: Int, dy: Int) {
                val firstVisible = layoutManager.findFirstVisibleItemPosition()
                val section = if (firstVisible in 0..33) 1 else 1

                if (section != currentSection) {
                    currentSection = section
                    updateClassHeader(section)
                }
            }
        })
    }

    override fun onResume() {
        super.onResume()
        updateProgressBar()
    }

    private fun updateClassHeader(section: Int) {
        val container = binding.classContainer2
        container.removeAllViews()

        val headerBinding = Mad2Binding.inflate(layoutInflater, container, false)
        headerBinding.classTitle2.text = "Mad Darslari" // Hozircha faqat bir bosqich ishlatyapsiz
        container.addView(headerBinding.root)
    }

    private fun markLessonAsSeen(id: Int) {
        val prefs = requireContext().getSharedPreferences("seen_lessons", Context.MODE_PRIVATE)
        if (!prefs.getBoolean("lesson_$id", false)) {
            prefs.edit().putBoolean("lesson_$id", true).apply()
        }
    }

    private fun isLessonSeen(id: Int): Boolean {
        val prefs = requireContext().getSharedPreferences("seen_lessons", Context.MODE_PRIVATE)
        return prefs.getBoolean("lesson_$id", false)
    }

    private fun getSeenLessonsCount(): Int {
        return dataList.indices.count { isLessonSeen(it) }
    }

    private fun updateProgressBar() {
        val total = dataList.size
        val seen = getSeenLessonsCount()
        val percent = if (total == 0) 0 else (seen * 100 / total)

        binding.progressBar2.progress = percent
        binding.progressText2.text = "$seen/$total"

        if (seen == total) {
            Toast.makeText(requireContext(), "🎉 Barcha darslar tugadi!", Toast.LENGTH_SHORT).show()
            resetProgress()
        }
    }

    private fun resetProgress() {
        val prefs = requireContext().getSharedPreferences("seen_lessons", Context.MODE_PRIVATE)
        val editor = prefs.edit()
        dataList.indices.forEach {
            editor.remove("lesson_$it")
        }
        editor.apply()

        binding.progressBar2.progress = 0
        binding.progressText2.text = "0/${dataList.size} dars bajarildi"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
